(ns net.bjoc.book-of-hours.core
  (:require [net.bjoc.book-of-hours.data.memories :as mem]
            [net.bjoc.book-of-hours.data.books :as book]
            [net.bjoc.book-of-hours.data.skills :as skill]
            [dev.nu.morse :as m]
            ))

(defn best-memory-books [current-books target]
  (->> (mem/best-memories target)
       (map (fn [memory]
              (->> current-books
                   (filter #(= (:memory %) memory))
                   first)))
       (remove nil?)
       ))
(+ 2 3)
(defn best-memory-books* [current-books target]
  (map (fn [{:keys [name memory]}]
         [name (:name memory)])
       (best-memory-books current-books target)))

(def current-skill-upgrades
  {skill/aural 5
   skill/coil 1
   skill/hammer 1
   skill/g&l 1
   skill/limiae 2
   skill/liminal 1
   skill/magge 1
   skill/martial 2
   skill/p&e 2
   skill/p&p 1
   skill/p&t 1
   skill/path 1
   skill/prelim 3
   skill/pyro 1
   skill/s&s 2
   skill/sea 1
   skill/sights 1
   skill/spices 1
   skill/sky 1
   skill/t&l 1
   })

(def current-books
  [
   book/SA
   book/WH
   book/KRTT
   book/TaN2
   book/AtSotK
   book/SLoN
   book/DHII
   book/OTN
   book/SLoN
   book/SDNR
   book/ASV
   book/SitS
   book/TaN1
   book/JoTD
   book/OTF
   book/_108
   book/KP
   book/BoC
   book/LT
   book/WT
   book/JV
   book/AIV
   book/LfaF
   book/ET
   book/FCT
   book/OiI
   book/SCatEoD
   book/FLoM
   ])

[
(skill/best-skills current-skill-upgrades :edge)
(skill/best-skills current-skill-upgrades :forge)
(skill/best-skills current-skill-upgrades :grail)
(skill/best-skills current-skill-upgrades :heart)
(skill/best-skills current-skill-upgrades :knock)
(skill/best-skills current-skill-upgrades :lantern)
(skill/best-skills current-skill-upgrades :moon)
(skill/best-skills current-skill-upgrades :moth)
(skill/best-skills current-skill-upgrades :nectar)
(skill/best-skills current-skill-upgrades :rose)
(skill/best-skills current-skill-upgrades :scale)
(skill/best-skills current-skill-upgrades :sky)
(skill/best-skills current-skill-upgrades :winter)
]
[
(best-memory-books* current-books :edge)
(best-memory-books* current-books :forge)
(best-memory-books* current-books :grail)
(best-memory-books* current-books :heart)
(best-memory-books* current-books :knock)
(best-memory-books* current-books :lantern)
(best-memory-books* current-books :moon)
(best-memory-books* current-books :moth)
(best-memory-books* current-books :nectar)
(best-memory-books* current-books :rose)
(best-memory-books* current-books :scale)
(best-memory-books* current-books :sky)
(best-memory-books* current-books :winter)
]
(mem/best-memories :edge)
(mem/best-memories :forge)
(mem/best-memories :grail)
(mem/best-memories :heart)
(mem/best-memories :knock)
(mem/best-memories :lantern)
(mem/best-memories :moon)
(mem/best-memories :moth)
(mem/best-memories :nectar)
(mem/best-memories :rose)
(mem/best-memories :sky)
(mem/best-memories :winter)
