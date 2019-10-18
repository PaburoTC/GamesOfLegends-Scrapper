package Scrapper.GamesOfLegendsScrapper;

public class App 
{
    public static void main( String[] args )
    {
        String dbName = "db2";
        Scrapper scrapper = new Scrapper();
        scrapper.start(dbName);
    }
}
