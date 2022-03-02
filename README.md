## **Technická univerzita v Liberci**

**Fakulta mechatroniky, informatiky a mezioborových studií**

# **SEMESTRÁLNÍ PRÁCE**

## z předmětu ALG1

Vypracoval: Filip Král

Datum: 11. 01. 2022

# Specifikace požadavků

Zapište program, který pro každé dva zadané polynomy vyhodnotí jejich součet a součin.

Vstupní polynomy jsou zadány stupněm a jednotlivými koeficienty.

**Specifikace vstupu**

Program má umožnit při jednom spuštění zpracování libovolného počtu dvojic polynomů. Pro každý polynom bude zadán stupeň a jeho koeficienty. Program se má ukončit v případě, že bude zadán záporný stupeň prvního polynomu.

Program bude fungovat za předpokladu, že uživatel zadá celá čísla a v závislosti na podmínce se záporným stupněm prvního polynomu se vyhodnotí součet a součin.

# Návrh řešení

Zadání a celkový koncept programu jsem vyhodnotil jako formátování výstupu do terminálu, jelikož zde nejsou vyžadovány vysoké nároky na matematické myšlení, snažil jsem se, aby byl program co nejvíce odladěn, a aby se nejvíce podobal výsledku, který je ode mne vyžadován.

Vstup je ošetřen proti zadání znaku nebo jiného než celého čísla. Po zadání špatné hodnoty se program vypne s vypsáním chybové hlášky do terminálu.

Program je rozdělen na několik metod, které jsou poté volány do metody pro výpis do terminálu.

Metody polynom1, polynom2 obsahují cyklený výpis celého polynomu do Stringu v závislosti na stupních polynomů. Využil jsem zde pole pro koeficienty.

Metody soucin a soucet obsahují také cyklený výpis, který se ukládá do Stringu, ale také samotný výpočet pro správný výsledek.

Metoda start obsahuje načítání hodnot do polí a následný výpis do terminálu přes metodu outputPolynoms.

## Popis načítání hodnot:

- požadavek na zadání stupně polynomu, potvrzení podmínky o nenulové hodnotě, načtení hodnoty do proměnné **P1** a **P2**
- vytvoření polí **koef1** a **koef2**
- nastavení velikosti pole pro koeficienty na hodnotu stupně polynomu + 1
- požadavek na zapisování hodnot do pole, podle stupně polynomu (stupeň polynomů = počet koeficientů + 1), využití for-cyklu (průchod odzadu) -\&gt; uložení do polí **koef1** a **koef2**

## Popis vypisování polynomů:

- procházení pole s koeficienty odzadu
- podmínka pro nezápornou hodnotu koeficientu na indexu
- podmínky pro správné přidávání a ukládání částí polynomů do String proměnné **vystupPolynom1** a **vystupPolynom2** :

    - pokud se **koef[i] a i == 1** -\&gt; zapiš &quot;+x &quot;;
    - pokud se **koef[i] == 1** zapiš &quot;+x^%d &quot;;
    - …
- poté metody vracejí String proměnné, následný výpis je přes metodu **outputPolynoms()**

## Popis výpočtu a výpisu součtu a součinu polynomů:

-
### Součet

- podmínka pro porovnání délek polí **koef1 \&gt;= koef2** , po správném porovnání nastaví nové pole **soucetPole** na délku pole koef1
  - převzetí hodnot z koef1 do soucetPole
  - využití for-cyklu pro sčítání hodnot na indexech z pole koef2, ukládání do pole soucetPole
- jinak
  - převzetí hodnot z koef2 do soucetPole
  - využití for-cyklu pro sčítání hodnot na indexech z pole koef1, ukládání do pole soucetPole
- výpis je stejný jako u výpisu samotných polynomů, je zde použita proměnná String **vystupSoucet**

-
### Součin

- vytvoření nového pole **soucinPole** s velikostí součtu stupňů obou polynomů +1
- využití dvou for-cyklů, hlavní cyklus projíždí od nuly do velikosti pole koef1, vnořený cyklus projíždí od nuly do velikosti pole koef2
- následuje vytvoření pomocné proměnné **pomoc** , která obsahuje součet indexů právě projížděných polí, poté se do pole soucinPole s indexem pomoc načítá násobení hodnot koeficientů obou polí ( _soucinPole[pomoc] += koef1[i]\*koef2[j];_ ) -\&gt; **násobení každý s každým!**
- výpis je stejný jako u výpisu samotných polynomů, je zde použita proměnná String **vystupSoucin**

# Protokol z testování

| **Číslo testu** | **Typ testu, popis** | **Očekávaný výsledek** | **Skutečný výsledek** | **Prošel (ano/ne)** |
| --- | --- | --- | --- | --- |
| 01 | Limitní stav; **stupPol1 \&lt; 0** | Konec programu | Konec programu | Ano |
| 02 | Nevalidní vstup;
**jiná, než celočíselná hodnota** | Konec programu | Konec programu | Ano |
| 03 | Běžný stav;
**všechno nastaveno na 1** | Prvni polynom: +x +1Druhy polynom: +x +1
Soucet polynomu:+2x +2
Soucin polynomu:+x^2 +2x +1 | Prvni polynom: +x +1Druhy polynom: +x +1
Soucet polynomu:+2x +2
Soucin polynomu:+x^2 +2x +1 | Ano |
| 04 | Běžný stav;
**nastaven polynom druhého řádu** | Prvni polynom: +x^2 +x +1Druhy polynom: +x^2 +x +1
Soucet polynomu:+2x^2 +2x +2
Soucin polynomu:+x^4 +2x^3 +3x^2 +2x +1 | Prvni polynom: +x^2 +x +1Druhy polynom: +x^2 +x +1
Soucet polynomu:+2x^2 +2x +2
Soucin polynomu:+x^4 +2x^3 +3x^2 +2x +1 | Ano |
| 05 | Běžný stav;
**nastaveny polynomy různých řádů a různých koeficientů** | Prvni polynom:
 +2x^4 +x^3 +8x^2 +4x +6Druhy polynom:
 +7x^2 +4x +6
Soucet polynomu:+2x^4 +x^3 +15x^2 +8x +12
Soucin polynomu:+14x^6 +15x^5 +72x^4 +66x^3 +106x^2 +48x +36 | Prvni polynom:
 +2x^4 +x^3 +8x^2 +4x +6Druhy polynom:
 +7x^2 +4x +6
Soucet polynomu:+2x^4 +x^3 +15x^2 +8x +12
Soucin polynomu:+14x^6 +15x^5 +72x^4 +66x^3 +106x^2 +48x +36 | Ano |

# Screenshoty výsledků akceptačních testů

![](RackMultipart20220302-4-15ightq_html_c7f78aab24010027.png)

_Obrázek 1 Test č. 01_

![](RackMultipart20220302-4-15ightq_html_49fabf7da6a51d35.png)

_Obrázek 2 Test č. 02_

![](RackMultipart20220302-4-15ightq_html_cc59385e0079f6c8.png)

_Obrázek 3 Test č. 03_

![](RackMultipart20220302-4-15ightq_html_f4fe6fb2670c5edd.png)

_Obrázek 4 Test č. 04_

![](RackMultipart20220302-4-15ightq_html_7930651e652d76ff.png)

_Obrázek 5 Test č. 05_
