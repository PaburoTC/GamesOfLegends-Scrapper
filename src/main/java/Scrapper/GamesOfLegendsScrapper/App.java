package Scrapper.GamesOfLegendsScrapper;

public class App 
{
    public static void main( String[] args )
    {
        String dbName = "example";
        Scrapper scrapper = new Scrapper();
        //scrapper.start(dbName);
        //scrapper.startTournament("https://gol.gg/tournament/tournament-stats/EU%20Master%20Summer%202019/","EU Masters");
        scrapper.startWorldChampionship2019("World Championship 2019");
    }
}
