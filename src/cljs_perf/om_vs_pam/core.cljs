(ns cljs-perf.om-vs-pam.core)

(def ^not-native om {})
(def ^not-native pam (array-map))

(def ^not-native om-1 {:foo 1})
(def ^not-native pam-1 (array-map :foo 1))

(def ^not-native om-2 {:foo 1 :bar 2})
(def ^not-native pam-2 (array-map :foo 1 :bar 2))

(def ^not-native om-3 {:foo 1 :bar 2 :baz 3})
(def ^not-native pam-3 (array-map :foo 1 :bar 2 :baz 3))

(def ^not-native om-7 (into {} (take 7 (map #(vector (str %1) %2) (rest (range)) (rest (range))))))
(def ^not-native pam-7 (into (array-map) (take 7 (map #(vector (str %1) %2) (rest (range)) (rest (range))))))

(defn ^:export om-assoc []
  (-assoc om :foo 1))

(defn ^:export pam-assoc []
  (-assoc pam :foo 1))

(defn ^:export om-assoc-1 []
  (-assoc om-1 :bar 2))

(defn ^:export pam-assoc-1 []
  (-assoc pam-1 :bar 2))

(defn ^:export om-assoc-2 []
  (-assoc om-2 :baz 3))

(defn ^:export pam-assoc-2 []
  (-assoc pam-2 :baz 3))

(defn ^:export om-assoc-3 []
  (-assoc om-3 :woz 4))

(defn ^:export pam-assoc-3 []
  (-assoc pam-3 :woz 4))

(defn ^:export om-assoc-7 []
  (-assoc om-7 :8 8))

(defn ^:export pam-assoc-7 []
  (-assoc pam-7 :8 8))

(defn ^:export om-assoc-3-exist []
  (-assoc om-3 :baz 4))

(defn ^:export pam-assoc-3-exist []
  (-assoc pam-3 :baz 4))

(defn ^:export om-lookup-1 []
  (-lookup om-1 :foo))

(defn ^:export pam-lookup-1 []
  (-lookup pam-1 :foo))

(defn ^:export om-lookup-2 []
  (-lookup om-2 :bar))

(defn ^:export pam-lookup-2 []
  (-lookup pam-2 :bar))

(defn ^:export om-lookup-3 []
  (-lookup om-3 :baz))

(defn ^:export pam-lookup-3 []
  (-lookup pam-3 :baz))

(defn ^:export om-lookup-7 []
  (-lookup om-7 "7"))

(defn ^:export pam-lookup-7 []
  (-lookup pam-7 "7"))
