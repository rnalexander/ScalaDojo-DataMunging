package org.timgroup.dojo

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FootballMungingTest extends FunSuite with ShouldMatchers with ReadFile {

  test("The team with smallest difference between for and against is Aston Villa") {
    val teamWithTheSmallestDifferenceBetweenForAndAgainst = FootballMunging(readFile("football.dat"))
      .teamWithTheSmallestDifferenceBetweenForAndAgainst

    teamWithTheSmallestDifferenceBetweenForAndAgainst should be("Aston_Villa")
  }

  test("Read the first team line from the football lines") {
    FootballMunging.team_lines_from(List("Source", "    1. Wimbledon AFC")) should be (List("    1. Wimbledon AFC"))
  } 

  test("Converts a team line to a team object") {
    FootballMunging.team_from_team_line("    5. Leeds           38    18  12   8    53  -  37    66") should be(Team("Leeds", 53, 37))
  }  
  
  test("Find team with smallest goal difference") {
    val team1 = Team("Foo1", 10, 11)    
    val team2 = Team("Foo2", 50, 0)
    val team3 = Team("Foo3", 0, 56)
    FootballMunging.team_with_min_goal_difference(List(team1, team2, team3)) should be(team1)
  }
  
}

