(ns cljs-perf.array-vs-pv.core)

;; push vs. conj

(defn ^:export array-push []
  (let [arr (array)]
    (loop [i 0]
      (if (< i 1e6)
        (do
          (.push arr i)
          (recur (inc i)))
        arr))))

(defn ^:export vector-conj []
  (let [pv []]
    (loop [i 0 pv []]
      (if (< i 1e6)
        (recur (inc i) (conj pv i))
        pv))))

(defn ^:export transient-vector-conj []
  (loop [i 0 tv (transient [])]
    (if (< i 1e6)
      (recur (inc i) (-conj! tv i))
      (persistent! tv))))

(defn make-big-array []
  (let [arr (array)]
    (doseq [i (range 1e6)]
      (.push arr i))
    arr))

(defn make-big-vector []
  (loop [i 0 tv (transient [])]
    (if (< i 1e6)
      (recur (inc i) (-conj! tv i))
      (persistent! tv))))

(def big-arr (make-big-array))
(def big-pv (make-big-vector))

(defn ^:export arr-reduce []
  (loop [i 0 s 0]
    (if (< i 1e6)
      (recur (inc i) (+ s (aget big-arr i)))
      s)))

(defn ^:export vector-reduce []
  (loop [i 0 s 0]
    (if (< i 1e6)
      (recur (inc i) (+ s (-nth big-pv i)))
      s)))
