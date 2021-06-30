# Meteo Tema2

---

### TESTARE

Am folosit JUnit5 pentru testarea clasei **openWeatherMap** fata de datele API, testarea a functionat *100%*. 

## !! Nota !!

Datorita faptului ca datele din **API** **OpenWeatherMap** se schimba in functie de vreme la un interval de timp este
posibil ca testul sa esueze la rulare. Pentru a demonstra veridicitatea testului am pus 2 fisiere "*.png*".
Pentru a efectua testarea este necesar sa accesati linkul: 

**https://api.openweathermap.org/data/2.5/weather?q=Bucharest,RO&appid=c9dcebae7c4eac089ab15fcf2c1fad09&units=metric**

Dupa ce preluati datele necesare clasei ForecastObject se poate efectua testarea cu succes.
De asemenea **atentie la valori**, desi in **JSON** apare "**45**" valoare la un camp exista posibilitatea ca testul sa esueze deoarece de fapt valoarea actuala sa fie
"**45.0**". Datorita faptului ca se lucreaza cu **STRING**-uri si o virgula poate conta. Recomand folosirea de variable tip **DOUBLE**
sau atentia la detalii de acest gen.


# By Pirjol Andrei
