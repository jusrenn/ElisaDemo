# Created by Yusuf Renkoglu at 27.2.2023
@elisa
Feature: Elisa.fi

  Scenario Outline: Käyttäjä etsii ja ostaa elisa.fi:ssa tuotteita.
    * Menee elisa.fi nettisivulle.
    * Menee puhelimet sivulle.
    * Urunleri sirala
    * Klikkaa ensimmäistä tuotetta.
    * Vahvista että onko "<String>" valittu.
    * Sulje browser.

    Examples:
    |String                   |
    |iPhone 13 mini 256 Gt 5G |