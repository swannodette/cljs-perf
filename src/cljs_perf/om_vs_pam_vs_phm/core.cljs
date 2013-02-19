(ns cljs-perf.om-pam-vs-phm.core)

(def om-7 (into {} (take 7 (map #(vector (str %1) %2) (range) (range)))))
(def pam-7 (into (array-map) (take 7 (map #(vector (str %1) %2) (range) (range)))))
(def phm-7 (into cljs.core.PersistentHashMap/EMPTY (take 7 (map #(vector (str %1) %2) (range) (range)))))

(defn ^:export om-assoc-7 []
  (assoc om-7 "7" 7))

(defn ^:export pam-assoc-7 []
  (assoc pam-7 "7" 7))

(defn ^:export phm-assoc-7 []
  (assoc phm-7 "7" 7))

(defn ^:export om-lookup-7 []
  (get om-7 "6"))

(defn ^:export pam-lookup-7 []
  (get pam-7 "6"))

(defn ^:export phm-lookup-7 []
  (get phm-7 "6"))
