(defproject cljs-perf "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :source-paths ["clojurescript/src/clj"
                 "clojurescript/src/cljs"]
  :dependencies [[org.clojure/clojure "1.4.0"]]
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
               {:id "ratcliff"
                :source-paths ["src/cljs_perf/ratcliff"]
                :compiler {:optimizations :advanced
                           :output-to "ratcliff.js"}}]})