## Josephus Problem

##### Brief Description:
There are n people standing in a circle. The counting begins at some point in the circle and proceeds around the circle in a fixed direction. After, a specified number of people are skipped, the next person is ‘out’. The counting continues until there is one person standing.

##### Solution:
The program finds the Safe-Position in a circle. The program needs two Parameters number-Of-People and Step-Rank. The program does not throw exceptions; it prints error messages.

##### Parameters:
  - numberOfPeople: must be an integer and greater than or equal to one
  - stepRank: must be an integer and greater than or equal to zero
 
##### Instruction:
  - Install: sbt (e.g. port install sbt)
  - build it: `sbt compile`
  - test it `sbt test`
  - test it run it `sbt "run 9 2"`
