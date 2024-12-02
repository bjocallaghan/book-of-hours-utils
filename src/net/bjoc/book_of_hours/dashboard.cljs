(ns ^:figwheel-hooks net.bjoc.book-of-hours.dashboard
  (:require [goog.dom :as gdom]
            [reagent.dom :as rdom]
            [reagent.core :as r]
            [net.bjoc.book-of-hours.data.memories :as mem]
            ))

(defonce app-state (atom {:title "A Reckoning of Hush House"
                          :current-books []
                          :current-skills {}
                          }))

(defn time-stamp []
  (.toLocaleString (js/Date.)))

(def principles [:edge :moth :scale])

;;;

(defn title []
  [:h1 (:title @app-state)])

(defn principle [principle-name]
  [:dev {:class "principle"}
   [:h2 (name principle-name)]])

(defn app []
  (println "inside")
  [:div {:class "app"}
   [title]
   [:div {:class "principles"}
    (for [p principles]
      [principle p])]])

(defn mount-app-element []
  (rdom/render [app] (gdom/getElement "app")))

 (defn ^:after-load on-reload []
  (mount-app-element))

(comment
  (println (time-stamp) "----------brian---------")
  ;; (println (time-stamp) (mem/all-memories))
  )
