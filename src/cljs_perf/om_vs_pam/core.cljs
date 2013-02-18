(ns cljs-perf.om-vs-pam.core)

(def om {})
(def pam (array-map))

(defn ^:export om-assoc []
  (assoc om :foo 1))

(defn ^:export pam-assoc []
  (assoc pam :foo 1))