# GamesOfLegends Scrapper
Obtains the match data from any tournament displayed in https://gol.gg, displaying all the data obtained in .csv format. 

By default the scrapper obtains the data from 2019 World Championship with method startWorldChampionship2019(), but with methods such as startTournament() and start(), which willed be explained in section _Public methods_, you can obtain the desired data from any tournament you desire.

## Data obtained
The scrapper only obtains the following parameters. If you wish for more to be implemented please contact me at pablotcampos25@gmail.com

The following parameters can be divided in two categories, parameters corresponding to the match itself and parameters that correspond to the teams playing the match. Team parameters will be displayed twice, first the winning team parameters followed by the losing team parameters.

### Match parameters
- Match
- Tournament phase
- Game duration (seconds)
- Winner

### Team parameters
- First Tower (boolean 0/1)
- Number of Towers destroyed
- Total number of Dragons obtained
- Number of Wind Dragons obtained
- Number of Ocean Dragons obtained
- Number of Earth Dragons obtained
- Number of Infernal Dragons obtained
- Number of Elder Dragons obtained
- Number of Barons obtained
- First Blood (boolean 0/1)
- Total gold (k)
- Region of origin
- Side of the map (blue/red)
- Kills
- Deaths
- Kill/Deaths

## Data representation
Data is represented in the order mentioned shown in _Data obtained_. First the match data is shown, followed by the winning teams stats and closed by the loosing team stats. 
An example is shown in the repository (example.csv). The example is writtten in spanish, as this proyect was started as part of a university assigment.


## Public methods
Each method will create one .csv file with selected tournaments data.
### startWorldChampionship2019(String dbName)
By default start method, obtains the data from the 2019 World Championship match by match. Takes as an argument the name of the .csv about to be created, which will be saved inside the scrapper folder.
### startTournament(String url, String dbName) 
Method that obtains de data from the selected tournament. This can be done by passing the tournaments url as the first argument. To find your desired url, go to https://gol.gg/tournament/list/region-ALL/ where all tournaments available on gol.gg are displayed. Click on the desired tournament and copy its url. The second argument takes the name of the desired database to be created.

WARNING: This method will leave the column "Phase"  blank as there is no information on gol.gg to relate each match to its corresponding phase in the selected tournament.

### start(String dbName, int nFirstTournament, int nLastTournament)
Obtains the data from the tournaments in range [nFirstTournament,nLastTournament], being 1 the first tournament displayed in https://gol.gg/tournament/list/region-ALL/ and being 1 <= nLastTournament <= last tournament from current season. To obtain the data from tournaments from previous seasons get their url and use startTournament(String url, String dbname) as explained above

