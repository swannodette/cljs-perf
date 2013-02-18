(ns cljs-perf.core)

(defn ints-seq
  ([n] (ints-seq 0 n))
  ([i n]
     (when (< i n)
       (lazy-seq
        (cons i (ints-seq (inc i) n))))))

(defn ^:export last-ints-seq []
  (last (ints-seq 1000000)))

(def phm
  (into cljs.core.PersistentHashMap/EMPTY
    [[:a 0] [:b 1] [:c 2] [:d 3] [:e 4] [:f 5] [:g 6] [:h 7]
     [:i 8] [:j 9] [:k 10] [:l 11] [:m 12] [:n 13] [:o 14] [:p 15]
     [:q 16] [:r 17] [:s 18] [:t 19] [:u 20] [:v 21] [:w 22] [:x 23]
     [:y 24] [:z 25] [:a0 26] [:b0 27] [:c0 28] [:d0 29] [:e0 30] [:f0 31]]))

(defn ^:export bench-phm-assoc []
  (dotimes [_ 1000000]
    (assoc phm :g0 32)))

(defn ^:export bench-phm-get []
  (dotimes [_ 1000000]
    (get phm :f0)))
