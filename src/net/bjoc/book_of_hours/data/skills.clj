(ns net.bjoc.book-of-hours.data.skills
  (:require [clojure.string :as str]))

(defmacro defskill
  [short-name
   full-name
   major
   minor
   & wisdoms]
  (let [expanded# {:name full-name
                   :major (keyword major)
                   :minor (keyword minor)
                   :wisdoms (mapv keyword wisdoms)}]
    `(def ~short-name ~expanded#)))

(defskill pyro "Pyroglyphics" forge lantern illumination ithastry)
(defskill r&r "Rhyme & Remembrance" winter moon birdsong skolekosophy)
(defskill inks "Inks of Containment" winter moon horomachistry)
(defskill wolf "Wolf Stories" moon scale birdsong)
(defskill martial "Edicts Martial" moon edge horomachistry)
(defskill magge "Maggephene Mysteries" moon heart preservation)
(defskill glass "Glassblowing & Vesselcrafting" knock sky ithastry)
(defskill hammer "Disciplines of the Hammer" edge forge illumination)
(defskill weave "Weaving & Knotworking" heart moth birdsong bosk)
(defskill herbs "Herbs & Infusions" heart nectar bosk preservation)
(defskill liminal "Edicts Liminal" moth knock skolekosophy)
(defskill roots "Rites of the Roots" nectar moth bosk)
(defskill sacra "Sacra Solis Invicti" lantern sky horomachistry illumination)
(defskill snow "Snow Stories" winter moon hushery)
(defskill meni "Meniscate Reflections" forge edge preservation)
(defskill r&e "Resurgences & Emergences" moth grail bosk)
(defskill bells "Bells & Brazieries" forge sky horomachistry ithastry)
(defskill f&f "Furs & Feathers" sky scale bosk nyctodromy)
(defskill p&p "Pentiments & Precursors" scale grail birdsong skolekosophy)
(defskill p&c "Putrefactions & Calcinations" winter moon ithastry)
(defskill sea "Sea Stories" moon grail birdsong nyctodromy)
(defskill sights "Sights & Sensations" sky winter nyctodromy)
(defskill s&e "Surgeries & Exsanguinations" heart knock hushery preservation)
(defskill watch "Watchman's Paradoxes" lantern sky illumination)
(defskill g&l "Glaziery & Lightsmithing" lantern sky illumination ithastry)
(defskill i&n "Insects & Nectars" nectar moon bosk nyctodromy)
(defskill path "Path & Pilgrim" rose scale birdsong nyctodromy)
(defskill inviolable "Edicts Inviolable" heart moon horomachistry preservation)
(defskill sand "Sand Stories" heart moon birdsong skolekosophy)
(defskill rag "Ragged Crossroads" edge winter illumination skolekosophy)
(defskill d&d "Drums & Dances" heart nectar bosk illumination)
(defskill s&s "Solutions & Separations" moth knock ithastry skolekosophy)
(defskill sickle "Sickle & Eclipse" edge moth nyctodromy preservation)
(defskill l&c "Lockworks & Clockworks" knock sky ithastry skolekosophy)
(defskill prelim "Preliminal Meter" knock rose illumination ithastry)
(defskill aural "Aural Contemplations" lantern edge illumination nyctodromy)
(defskill strings "Strings & Songs" sky heart birdsong nyctodromy)
(defskill spices "Spices & Savours" nectar forge ithastry nil)
(defskill sky "Sky Stories" sky rose birdsong horomachistry)
(defskill t&l "Transformations & Liberations" forge moth illumination ithastry)
(defskill p&t "Pearl & Tide" rose moon bosk nyctodromy)
(defskill coil "Coil & Chasm" scale nectar nyctodromy skolekosophy)
(defskill oura "Ouranoscopy" sky moon horomachistry hushery)
(defskill desires "Desires & Dissolutions" grail moon bosk illumination)
(defskill p&e "Purifications & Exaltations" sky lantern illumination ithastry)
(defskill leaves "Leaves & Thorns" nectar grail birdsong bosk)
(defskill h&i "Horns & Ivories" scale knock bosk skolekosophy)
(defskill limiae "Sacra Limiae" moth sky horomachistry hushery)
(defskill apple "Lesson: Applebright Euphonies" sky grail bosk illumination)
(defskill h&h "Hill & Hollow" moon scale nyctodromy preservation)
(defskill d&w "Door & Wall" knock forge horomachistry nyctodromy)
(defskill a&l "Anbary & Lapidary" sky forge horomachistry ithastry)
(defskill signs "The Great Signs and the Great Scars" grail knock horomachistry hushery)
(defskill tridesma "Tridesma Hiera" moon grail bosk preservation)
(defskill scar "Disciplines of the Scar" edge lantern hushery illumination)
(defskill s&v "Serpents & Venoms" scale moon hushery skolekosophy)
(defskill revelation "Inks of Revelation" lantern moth hushery ithastry)
(defskill s&b "Stitching & Binding" sky heart ithastry preservation)

;;;

(let [this-ns *ns*]
  (defn all-skills []
    (->> (ns-publics this-ns)
         (map val)
         (map deref)
         (filter map?))))

(defn rank-up [level {:keys [name major minor] :as s}]
  {:name name
   major (inc level)
   minor level})

(defn best-skills
  "Return a sequence of skills ranked by how well they satisfy `target`.

  `upgrades` should be a map, where 'base' skills are the keys and the value is
  the current rank of the skill.

  Example `upgrades`:
  {skill/hammer 2
   skill/liminal 2
   skill/martial 3}
  "
  [upgrades target]
  (let [in-upgrades? (->> upgrades keys (map :name) set)
        skills (->> upgrades
                    (map (fn [[s lvl]] (rank-up lvl s))))]
                       ;; (->> (all-skills)
                       ;;      (remove #(in-upgrades? (:name %)))
                       ;;      (map #(rank-up 1 %))))]
    (->> skills
         (sort-by target #(compare %2 %1))
         (filter target))))
;; (best-skills {} :edge)

(def best-skill (comp first best-skills))
