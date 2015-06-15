;; Build a program to calculate change in proper denominations after accepting a
;; starting USD$ value. For example, a starting value of $11.00 would result in
;; (1) $10 and (1) $1 bills.

;; Design specs
;; - Make use of all common USD$ denominations
;; - Calculate change using the minimum number of bills and coins necessary
;; - Assume infinite amounts of each denomination in change machine
;; - Use a language of your choice and provide source code for review
;; - Functioning program must be demonstrable to reviewers in some fashion
;;
;; The present denominations of our currency in production are $1, $2, $5,
;; $10, $20, $50 and $100.
;;
;; U.S. coins currently are made in the following six denominations: cent,
;; nickel, dime, quarter, half dollar, and dollar.

(ns change.core
  (:gen-class))

(defn clean-string
  "Clean STRING and return an integer"
  [string]
  (let [clean (Integer/parseInt (re-find #"\d+" string))]
    clean))

(defn pennify
  "Convert AMOUNT to pennies"
  [amount]
  (let [dollars (clean-string (first (clojure.string/split amount #"\.")))
        pennies (clean-string (second (clojure.string/split amount #"\.")))]
    (+ (* 100 dollars) pennies)))

(defn fits
  "Returns number of times CHANGE fits in AMOUNT"
  [amount change]
  (let [change (int (Math/floor (/ amount change)))]  
    (if (not= 0 change)
      change
      0)))

(defn count-change
  "Returns change for given AMOUNT"
  [amount currency collection]
  (let [valid-currency {:10000 "hundred-dollar" :5000 "fifty-dollar" :2000 "twenty-dollar" :1000 "ten-dollar" :500 "five-dollar"
                        :200 "two-dollar" :100 "one-dollar" :50 " half-dollar" :25 "quarter" :10 "dime" :5 "nickel" :1 "cent" } 
        a (cond (not= 0 (fits amount (first currency))) (- amount (* (first currency) (fits amount (first currency))))
                :else amount)
        b (rest currency)
        c (cond (not= 0 (fits amount (first currency))) (assoc collection ((keyword (str (first currency))) valid-currency) (fits amount (first currency)))
                :else collection)]
    (do
      (if (not= a 0)
        (recur a b c)
        c))
   ))
  
(defn -main
  "Give correct change for an amount of money"
  [amount]
  (println (count-change (pennify amount) [10000 5000 2000 1000 500 200 100 50 25 10 5 1] {})))
