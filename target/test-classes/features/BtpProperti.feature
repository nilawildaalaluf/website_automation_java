@All
  Feature: BTN Properti Hitung harga properti

    @Positive @Property
      Scenario: Property
      Given User is on calculate property prices page
      When user fill Penghasilan Total and pengeluaran
      And User Select Jangka waktu
      And User click button Hitung
      Then User get calculate property prices

    @TDD @Property
      Scenario Outline: TDD Property
      Given User is on calculate property prices page
      When user fill penghasilan <total> and <pengeluaran>
      And User Select Jangka waktu
      And User click button Hitung
      Then User get calculate <result> property prices
      Examples:
        | total | pengeluaran | result |
        | 10000000 | 3000000  | Passed |
        | 10000000 | 10000000 | Failed  |
        | 3000000 | 3000000 | Failed  |

