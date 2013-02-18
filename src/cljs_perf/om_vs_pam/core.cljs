(ns cljs-perf.om-vs-pam.core)

(def om {})
(def pam (array-map))

(def om-1 {:foo 1})
(def pam-1 (array-map :foo 1))

(def om-2 {:foo 1 :bar 2})
(def pam-2 (array-map :foo 1 :bar 2))

(def om-3 {:foo 1 :bar 2 :baz 3})
(def pam-3 (array-map :foo 1 :bar 2 :baz 3))

(defn ^:export om-assoc []
  (assoc om :foo 1))

(defn ^:export pam-assoc []
  (assoc pam :foo 1))

(defn ^:export om-assoc-1 []
  (assoc om-1 :bar 2))

(defn ^:export pam-assoc-1 []
  (assoc pam-1 :bar 2))

(defn ^:export om-assoc-2 []
  (assoc om-2 :baz 3))

(defn ^:export pam-assoc-2 []
  (assoc pam-2 :baz 3))

(defn ^:export om-lookup-1 []
  (get om-1 :foo))

(defn ^:export pam-lookup-1 []
  (get pam-1 :foo))

(defn ^:export om-lookup-2 []
  (get om-2 :bar))

(defn ^:export pam-lookup-2 []
  (get pam-2 :bar))

(defn ^:export om-lookup-3 []
  (get om-3 :baz))

(defn ^:export pam-lookup-3 []
  (get pam-3 :baz))