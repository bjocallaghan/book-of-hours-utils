(ns net.bjoc.book-of-hours.data.macros
  (:require [clojure.string :as str]))

(defn- collapse-nums [& args]
  (reduce (fn [acc x]
            (if (number? x)
              (conj (pop acc) [(peek acc) x])
              (conj acc x)))
          [] args))
;; (collapse-nums :heart :sky)
;; (collapse-nums :heart 2 :sky)
;; (collapse-nums :heart :sky 3)

(defn- args->aspects
  [args]
  (conj (->> args
             (map (fn [x] (if (symbol? x) (keyword x) x)))
             (apply collapse-nums))
        :memory))
;; (args->aspects '(solace heart 2 sky))

(defmacro defmem
  [short-name & args]
  (let [name (str "Memory: " (str/capitalize short-name))
        expanded# {:name name
                   :aspects (args->aspects args)}
        ]
    `(def ~short-name ~expanded#)))
