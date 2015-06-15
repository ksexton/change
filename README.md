# Change Calculator

Calculate change in proper denominations after accepting a starting USD$
value.  For example, a starting value of $11.00 would result in (1)
$10 and (1) $1 bills.

Design specs
  - Make use of all common USD$ denominations
  - Calculate change using the minimum number of bills and coins necessary
  - Assume infinite amounts of each denomination in change machine
  - Use a language of your choice and provide source code for review
  - Functioning program must be demonstrable to reviewers in some fashion

## Notes

The present denominations of our currency in production are $1, $2, $5,
$10, $20, $50 and $100.  U.S. coins currently are made in the
following six denominations: cent, nickel, dime, quarter, half dollar,
and dollar.

## Usage

    $ java -jar change-0.1.0-standalone.jar "\$12.30"

## Examples

    $ java -jar change-0.1.0-standalone.jar "\$11.00"
    {one-dollar 1, ten-dollar 1}
    $ java -jar change-0.1.0-standalone.jar "11.00"
    {one-dollar 1, ten-dollar 1}

### Bugs

Hopefully none, probably some.

