Feature: Search by keyword

  Scenario Outline: Searching for a term
    Given Rose wants to learn automation at the academy Choucair
    | strUser | strPassword |
    | <strUser> |       <strPassword>    |
    When Rose search for the course on the choucair academy platform
      | strcourse |
      | <strcourse> |
    Then Rose finds the course called
      | strcourse |
      | <strcourse> |
    Examples:
      | strUser | strPassword | strcourse |
      | 1000033613        |  Choucair2021*           |  Tutorial Nivel Basico   |


