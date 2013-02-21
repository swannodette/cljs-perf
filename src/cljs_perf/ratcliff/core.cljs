(ns cljs-perf.ratcliff.core)

(defn js-print [& args]
  (if (js* "typeof console != 'undefined'")
    (.log js/console (apply str args))
    (js/print (apply str args))))

(set! *print-fn* js-print)

(deftype F [^:unsynchronized-mutable ^ints curr
            ^:unsynchronized-mutable ^ints prev]
  IFn
  (invoke [_ a1 a2]
    (let [^objects a1 a1
          ^objects a2 a2]
      (areduce a1 i max-len 0
        (let [m (areduce a2 j max-len (unchecked-long max-len)
                  (let [match-len 
                        (if (identical? (aget a1 i) (aget a2 j))
                          (unchecked-inc (aget prev j))
                          0)]
                    (aset curr (unchecked-inc j) (unchecked-int match-len))
                    (if (> match-len max-len)
                      match-len
                      max-len)))
              bak curr]
          (set! curr prev)
          (set! prev bak)
          m)))))

(defn my-lcs2 [^objects a1 a2]
  (let [n (inc (alength a1))
        f (F. (int-array n) (int-array n))]
    (f a1 a2)))

(def pool "ABC")
(defn get-random-id [n] (apply str (repeatedly n #(rand-nth pool))))
(def a1 (into-array (take 10000 (repeatedly #(get-random-id 5)))))
(def a2 (into-array (take 10000 (repeatedly #(get-random-id 5)))))

(time (my-lcs2 a1 a2))