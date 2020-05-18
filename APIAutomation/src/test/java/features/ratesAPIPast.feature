@ratesAPIPast
Feature: Validate Rates API

  @ratesAPIPastDefault
  Scenario Outline: Verify if User is able to get past Data for ratesAPI
    Given User create ratesAPI past Payload with <queryParams>
    When User calls Past "ratesAPI" with "GET" http request
    Then User validates if the Response_past is Success

    Examples: 
      | queryParams         |
      | "validDateFormat"   |
      | "inValidDateFormat" |
      | "blankDate"         |

  @ratesAPIPastSymbols
  Scenario Outline: Verify if User is able to get past Data for ratesAPI Filter : <queryParams> <queryparamsSymbols>
    Given User create ratesAPI past Payload with queryParams : Symbols <queryParams> <queryparamsSymbols>
    When User calls Past "ratesAPI" with "GET" http request
    Then User validates if the Response_past_Symbols is Success

    Examples: 
      | queryParams         | queryparamsSymbols |
      | "validDateFormat"   | "symbols"          |
      | "validDateFormat"   | "invalidSymbols"   |
      | "validDateFormat"   | "blankSymbols"     |
      | "inValidDateFormat" | "symbols"          |
      | "inValidDateFormat" | "invalidSymbols"   |
      | "inValidDateFormat" | "blankSymbols"     |

  @ratesAPIPastBase
  Scenario Outline: Verify if User is able to get past Data for ratesAPI Filter : <queryParams> <queryparamsBase>
    Given User create ratesAPI past Payload with queryParams : Base <queryParams> <queryparamsBase>
    When User calls Past "ratesAPI" with "GET" http request
    Then User validates if the Response_past_Base is Success

    Examples: 
      | queryParams         | queryparamsBase |
      | "validDateFormat"   | "base"          |
      | "validDateFormat"   | "invalidBase"   |
      | "validDateFormat"   | "blankBase"     |
      | "inValidDateFormat" | "base"          |
      | "inValidDateFormat" | "invalidBase"   |
      | "inValidDateFormat" | "blankBase"     |

  @ratesAPIPastSymbolsandBase
  Scenario Outline: Verify if User is able to get past Data for ratesAPI Filter : <queryParams> <queryparamsBase> <queryParamsSymbols>
    Given User create ratesAPI past Payload with queryParams : Symbols and Base <queryParams> <queryparamsBase> <queryParamsSymbols>
    When User calls Past "ratesAPI" with "GET" http request
    Then User validates if the Response_past_Symbols_and_Base is Success

    Examples: 
      | queryParams       | queryparamsBase | queryParamsSymbols |
      | "validDateFormat" | "base"          | "symbols"          |
      | "validDateFormat" | "base"          | "invalidSymbols"   |
      | "validDateFormat" | "base"          | "blankSymbols"     |
      | "validDateFormat" | "invalidBase"   | "symbols"          |
      | "validDateFormat" | "invalidBase"   | "invalidSymbols"   |
      | "validDateFormat" | "invalidBase"   | "blankSymbols"     |
