(ns cljs-perf.chunks.core)

(defn js-print [& args]
  (if (js* "typeof console != 'undefined'")
    (.log js/console (apply str args))
    (js/print (apply str args))))

(set! *print-fn* js-print)

(def bigr (range 1000000))
(def bigv (into [] bigr))

(defn map-bigr []
  (doall (map inc bigr)))

(defn map-bigv []
  (doall (map inc bigv)))

(defn for-bigr []
  (doall
    (for [x bigr]
      (inc x))))

(defn for-bigv []
  (doall
    (for [x bigv]
      (inc x))))

(time (map-bigr))

(time (map-bigv))

(time (for-bigr))

(time (for-bigv))
