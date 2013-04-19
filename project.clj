(defproject cljs-perf "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :source-paths ["clojurescript/src/clj"
                 "clojurescript/src/cljs"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.json "0.2.2"]]
  :plugins [[lein-cljsbuild "0.3.0"]]
  :cljsbuild {:builds
              [{:id "om_vs_pam"
                :source-paths ["src/cljs_perf/om_vs_pam/"]
                :compiler {:optimizations :advanced
                           :output-to "om_vs_pam.js"}}
               {:id "om_vs_pam_vs_phm"
                :source-paths ["src/cljs_perf/om_vs_pam_vs_phm/"]
                :compiler {:optimizations :advanced
                           :output-to "om_vs_pam_phm.js"}}
               {:id "array_vs_pv"
                :source-paths ["src/cljs_perf/array_vs_pv/"]
                :compiler {:optimizations :advanced
                           :pretty-print false
                           :output-to "array_vs_pv.js"}}
               {:id "ratcliff"
                :source-paths ["src/cljs_perf/ratcliff"]
                :compiler {:optimizations :advanced
                           :output-to "ratcliff.js"}}]})
