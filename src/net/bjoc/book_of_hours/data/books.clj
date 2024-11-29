(ns net.bjoc.book-of-hours.data.books
  (:require [clojure.string :as str]
            [net.bjoc.book-of-hours.data.memories :as mem]
            [net.bjoc.book-of-hours.data.skills :as skill]
            ))

(let [this-ns *ns*]
  (defn all-books []
    (->> (ns-publics this-ns)
         (map val)
         (map deref)
         (filter map?))))

(defmacro defbook
  [initials
   full-name
   principle
   difficulty
   period
   price
   subject
   memory]
  (let [expanded# {:name full-name
                   :mystery [(keyword principle) difficulty]
                   :period (keyword period)
                   :price price
                   :subject subject
                   :memory memory}]
    `(def ~initials ~expanded#)))
;; (macroexpand '(defbook BoC "The Book of Cinders" forge 6 curia 2 pyroglyphics mem/foresight))

;;;

(defbook BoC "The Book of Cinders" forge 6 curia 2 skill/pyro mem/foresight)
(defbook EitCoS "Exercises in the Continuity of Self" winter 8 curia 2 skill/r&r mem/hindsight)
(defbook RftAA "Recordings from the Althiban Abyss" scale 4 nocturnal 1 nil nil)
(defbook LT "The Leonine Tantra" edge 8 curia 2 skill/martial mem/fear)
(defbook WD "The World Despoil'd" moon 6 baronial 3 skill/magge mem/solace)
(defbook AoC "Advice on Containment" knock 4 curia 2 skill/glass mem/pattern)
(defbook DHI "De Horis Book 1" nector 4 baronial 3 skill/roots mem/impulse)
(defbook DHII "De Horis Book 2" edge 4 baronial 3 skill/hammer mem/foresight)
(defbook LER "Lady Eva's Repose" winter 4 baronial 3 skill/r&r mem/regret)
(defbook CT "The Ceaseless Tantra" heart 6 curia 2 skill/weave mem/impulse)
(defbook AoSB "Annals of St Brandan's" winter 4 solar 4 skill/inks mem/regret)
(defbook FH "Fekri's Herbary" nector 6 baronial 3 skill/herbs mem/satisfaction)
(defbook TaN1 "Travelling at Night, Vol 1" knock 4 nocturnal 1 skill/liminal mem/impulse)
(defbook TaN2 "Travelling at Night, Vol 2" sky 6 nocturnal 1 skill/sights mem/solace)
(defbook BN "Black Nephrite" moon 6 baronial 3 skill/wolf mem/fear)
(defbook GoN "Gospel of Nicodemus" lantern 6 solar 4 skill/sacra mem/revelation)
(defbook OTN "The Orchid Transfigurations: Noon" heart 4 curia 2 skill/magge mem/solace)
(defbook VC "The Viennese Conundra" moon 4 curia 2 skill/wolf mem/fear)
(defbook ItH "An Introduction to Histories" winter 4 baronial 3 skill/snow mem/hindsight)
(defbook AotRR "The Amalgam of the Red Rose" forge 8 curia 2 skill/meni mem/foresight)
(defbook SS "The Skeleton Songs" grail 4 nocturnal 1 skill/r&e mem/beguiling-melody)
(defbook LDI "The Locksmith's Dream: Incursus" lantern 6 nocturnal 1 skill/g&l mem/confounding-parable)
(defbook HtCG "Honey: The Comprehensive Guide" nectar 6 nocturnal 1 skill/i&n mem/contradiction)
(defbook LfaF "Letters from a Fugitive" rose 6 baronial 3 skill/path mem/confounding-parable)
(defbook VI "Velletri Interviews" heart 6 nocturnal 1 skill/inviolable mem/stolen-secret)
(defbook TST "The Twin-Serpent Tantra" knock 8 nocturnal 1 skill/liminal mem/pattern)
(defbook OiI "Oblations in Iron" winter 6 curia 2 skill/inks mem/hindsight)
(defbook FT "The Flayed Tantra" heart 8 curia 2 skill/magge mem/storm)
(defbook BotC "The Book of the Centipede" rose 6 curia 2 skill/sand mem/intuition)
(defbook SL "The Sun's Lament" edge 4 solar 4 skill/rag mem/fear)
(defbook RitK "Rapt in the King" heart 8 baronial 3 skill/d&d mem/earth-sign)
(defbook FCT "The Fire-Circle Tantra" moth 8 curia 2 skill/s&s mem/intuition)
(defbook LDP&P "The Locksmith's Dream: Portions and Proportions" sky 4 nocturnal 1 skill/l&c mem/confounding-parable)
(defbook EfG "Exorcism for Girls" edge 6 curia 2 skill/sickle mem/fear)
(defbook OL "The Other Line" heart 4 baronial 3 skill/prelim mem/confounding-parable)
(defbook KP "The Krisham Portolan" moon 6 curia 2 skill/sea mem/gossip)
(defbook WH "Wainscot Histories" lantern 6 baronial 3 skill/aural mem/contradiction)
(defbook _108 "One Hundred And Eight" scale 4 baronial 3 skill/p&p mem/confounding-parable)
(defbook PD "Perugian Diaries" sky 4 nocturnal 1 skill/strings mem/cheerful-ditty)
(defbook KRTT "Kitling Ripe's Tasty Treats" nectar 4 baronial 3 skill/spices mem/satisfaction)
(defbook SA "Sunrise Awakenings" lantern 4 baronial 3 skill/aural mem/revelation)
(defbook AtSotK "Against the Sisterhood of the Knot and the Foulness of their Depraved Customs" sky 6 curia 2 skill/sky mem/intuition)
(defbook SLoN "The Six Letters on Necessity" moth 4 curia 2 skill/t&l mem/foresight)
(defbook SDNR "The Sea Does Not Regret" moon 6 curia 2 skill/p&t mem/salt)
(defbook SitS "The Shadow in the Stair" nectar 6 baronial 3 skill/coil mem/impulse)
(defbook ASV "A Seventh Voice" sky 8 baronial 3 skill/prelim mem/confounding-parable)
(defbook JoTD "Journal of Thomas Dewulf" sky 4 baronial 3 skill/oura mem/salt)
(defbook OTF "The Orchid Transfigurations: a Feast" grail 4 baronial 3 skill/desires mem/intuition)
(defbook WT "The Watchful Tantra" lantern 8 curia 2 skill/p&e mem/revelation)
(defbook JV "Just Verse" rose 6 nocturnal 1 skill/prelim mem/pattern)
(defbook AIV "An Impertinent Vitulation" grail 6 baronial 3 skill/leaves mem/satisfaction)
(defbook ET "The Encircling Tantra" scale 6 curia 2 skill/h&i mem/fear)
(defbook SCatEoD "Sunset Celia and the End of Days" sky 10 curia 2 skill/limiae mem/foresight)
(defbook FLoM "The Five Letters On Memory" winter 6 curia 2 skill/r&r mem/regret)
