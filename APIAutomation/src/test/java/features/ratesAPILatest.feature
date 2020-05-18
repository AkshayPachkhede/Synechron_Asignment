@ratesAPILatest
Feature: Validate Rates API

  @ratesAPILatestDefault
  Scenario: Verify if User is able to get latest Data for ratesAPI
    Given User create ratesAPI latest Payload
    When User calls "ratesAPI" with "GET" http request
    Then User validates if the Response is Success

  @ratesAPILatestSymbols
  Scenario Outline: Verify if User is able to get latest Data for ratesAPI Filter : <queryParams>
    Given User create ratesAPI latest Payload with queryParams <queryParams>
    When User calls "ratesAPI" with "GET" http request
    Then User validates if the Response_Symbols is Success

    Examples: 
      | queryParams      |
      | "symbols"        |
      | "invalidSymbols" |
      | "blankSymbols"   |

  @ratesAPILatestBase
  Scenario Outline: Verify if User is able to get latest Data for ratesAPI Filter : <queryParams>
    Given User create ratesAPI latest Base Payload with queryParams <queryParams>
    When User calls "ratesAPI" with "GET" http request
    Then User validates if the Response_Base is Success

    Examples: 
      | queryParams   |
      | "base"        |
      | "invalidBase" |
      | "blankBase"   |

  @ratesAPILatestSymbolsandBase
  Scenario Outline: Verify if User is able to get latest Data for ratesAPI Filter Symbols and Base: <queryParamsSymbols> <queryparamsBase>
    Given User create ratesAPI latest Payload with queryParams : Symbols and Base <queryParamsSymbols> <queryparamsBase>
    When User calls latest "ratesAPI" with "GET" http request
    Then User validates if the Response_latest_SymbolsandBase is Success

    Examples: 
      | queryParamsSymbols | queryparamsBase |
      | "symbols"          | "base"          |
      | "symbols"          | "invalidBase"   |
      | "symbols"          | "blankBase"     |
      | "invalidSymbols"   | "base"          |
      | "invalidSymbols"   | "invalidBase"   |
      | "invalidSymbols"   | "blankSymbols"  |
