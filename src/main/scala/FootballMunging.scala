package org.timgroup.dojo

case class FootballMunging(val lines: List[String]) {
  import FootballMunging._

  def teamWithTheSmallestDifferenceBetweenForAndAgainst =
    team_with_min_goal_difference(team_lines_from(lines).map(team_from_team_line)).name
}

case class Team(val name: String, val goalsFor: Int, val goalsAgainst: Int) {
  def difference() = Math.abs(goalsFor - goalsAgainst)
}


object FootballMunging {
  def team_lines_from(lines: List[String]) = lines filter starts_with_number

  def team_from_team_line(line: String) = {
    val words = line split """\s+"""
    Team(words(2), words(7).toInt, words(9).toInt)
  }
  
  def starts_with_number(line: String) = line matches """\s+\d+.*"""

  def team_with_min_goal_difference(teams: List[Team]) = {
    teams.sort((l, r) => l.difference < r.difference)(0)
  }
}

