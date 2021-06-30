# Meteo Tema2

---

### INTRODUCERE


Aplicatie *Desktop* simpla ce ofera prognoza Meteo a diferitelor locatii pe baza fisierului **locationsData.txt**
folosind librariile **JavaFX** si **Gson** concomitent cu API Meteo pus la dispozitie de catre
**OpenWeatherAPI** ce ne ofera date in format **JSON**.

Pentru a selecta zona de interes se apasa butonul "**Select**". In urma evenimentului de click
*(doar la prima accesare)* clasa **openWeatherMap** va incepe sa ruleze si sa incarce datele relevante
locatiilor alese din meniurile de tip **ComboBox** populate prin intermediul clasei **MainWindowController**
si a fisierului **locationsData.txt**.

## Plugin-uri si Programe:

---
1. **Maven :** Tool pentru *build automation* folosit in proiectele *Java*. Permite dezvoltatorilor sa
configureze si completeze ciclul de dezvoltare intr-un timp eficient printr-un sistem de **Build Uniform**. Permite
   configurarea si descarcarea de librarii necesare si dependinte precum **JavaFX** si **Gson** prin intermediul fisierului
   **POM** (Project Object Model) de tip **XML**.

2. **PlanUML** editor text in completarea ***IntelliJ*** sub forma de extensie ce permite editarea
   si formatarea diagramelor **UML** si **proprii** facilitand o generare mai usoara a acestora.

3. **SceneBuilder :** Un **IDE** vizual separat, care complementeaza *Intellij IDE* pentru a edita si formata
   diverse fisiere **FXML** de tip **GUI** (*Graphical User Interface*).
   
## Librariile folosite pentru acest proiect sunt:

---
- **Mockito** si **JUnit** pentru testare unitara
- **JavaFX** ca librarie si framework de baza pentru dezvoltarea de aplicatii grafice folosind formatul **FXML**
    si injectia *elementelor grafice* in cod.
- **Gson** librarie pentru formatarea fisierelor si datelor in format **JSON**





## Functionalitate:

---
Toate obiectele grafice sunt create si injectate in **MainWindowController** prin intermediul tag-ului
**@FXML** si apelarea functiei **loadFXML** si a obiectului **FXMLoader**.
In urma apasarii (*prima data*) butonului albastru **Select**. API va incepe initializarea
iar clasa de tip *controller* va incepe citirea din fiser pentru locatiile la care urmeaza sa se faca prognoza meteo.
Pentru conectare folosim un **API Key**. 


## Format Fisier de Intrare

---

| ID	 | CityName | latitude | longitude| CountryCode
| ----------- | ----------- | ----------- | ----------- | ----------- |
| 683506 | Bucharest | 26.1063 | 44.4323 | RO

# By Pirjol Andrei
