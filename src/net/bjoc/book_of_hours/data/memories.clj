(ns net.bjoc.book-of-hours.data.memories
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

;;;

(defmem solace heart 2 sky)
(defmem fear edge scale 2)
(defmem foresight forge 2 lantern)
(defmem hindsight scale winter 2)
(defmem pattern forge knock 2)
(defmem regret forge winter 2)
(defmem impulse moth 2 nectar)
(defmem salt knock moon winter)
(defmem satisfaction grail 2 heart)
(defmem revelation lantern 2)
(defmem beguiling-melody grail 2 sky 2)
(defmem confounding-parable moon 2 rose 2 sky 2)
(defmem contradiction edge 2 moon)
(defmem stolen-secret knock moon 2)
(defmem bittersweet-certainty lantern winter 2)
(defmem storm heart 2 sky 2)
(defmem intuition moon 2 rose 2)
(defmem earth-sign nectar 2 scale 2)
(defmem gossip grail 1 rose 2)
(defmem cheerful-ditty heart 2 sky)
(defmem secret-threshold knock 2 rose)

;;;

(let [this-ns *ns*]
  (defn all-memories []
    (->> (ns-publics this-ns)
         (map val)
         (map deref)
         (filter map?))))

(defn best-memories [target]
  (let [target? #(= target (if (coll? %) (first %) %))]
    (->> (all-memories)
         (filter (fn [{:keys [aspects]}]
                   (not-empty (filter target? aspects))))
         (sort-by (fn [{:keys [aspects]}]
                    (let [v (->> aspects
                                 (filter target?)
                                 first)]
                      (if (coll? v) (second v) 1)))
                  #(compare %2 %1)))))
;; (best-memories :rose)
;; (best-memories :sky)
;; (best-memories :sky)
