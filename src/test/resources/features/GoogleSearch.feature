# Created by ticeky at 1/20/2019
Feature: Search using google

  As a web user,
  I need the ability to search google for results
  So that I can find out more information about the things I search

  Scenario Outline: Perform a google search for an actor
    Given the web user has an actors name <ActorName>
    When the web user performs a google search
    Then the web user receives search results related to the actor name that was searched
    Examples:
      | ActorName   |
      | Jim Carrey   |
      | Tom Cruise   |
      | Bruce Willis |
