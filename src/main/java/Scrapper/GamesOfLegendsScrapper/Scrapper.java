package Scrapper.GamesOfLegendsScrapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrapper {
	 final String url = "https://gol.gg/tournament/list/region-ALL/";

	 //Obtains de data from selected tournament via its url, and saves it as dbName.csv
	 public void startTournament(String url, String dbName){
	 	startTournament(url, dbName, "");
	 	System.out.println("Your "+dbName+" database is ready!");
	 }

	 //Auxiliary method for startTournament, invokes method getMatches(), which goes through all the matches from a tournament
	 private void startTournament(String url, String dbName, String phase){
		 try{
			 PrintWriter writer = new PrintWriter(dbName + ".csv", "UTF-8");
			 writer.println("Partido;Fase;Duracion;Nombre azul;Gana Azul;Primera Torre Azul;Numero de Torres Derribadas Azul;Diferencia de Torres Derribadas Azul;Numero total de Dragones Azul;Dragones de Nube Azul;Dragones de Oceano Azul;Dragones de Montaña Azul;Dragones Infernales Azul;Dragones Ancianos Azul;Numero de Barones Nashor Azul;Primera Sangre Azul;Oro Azul;Diferencia de Oro azul;Region Azul;Asesinatos Azul; Muertes Azul; Asesinatos/Muertes Azul;Nombre Rojo;Gana Rojo;Primera Torre Rojo;Numero de Torres Derribadas Rojo;Diferencia de Torres Derribadas Azul;Numero total de Dragones Rojo;Dragones de Nube Rojo;Dragones de Oceano Rojo;Dragones de Montaña Rojo;Dragones Infernales Rojo;Dragones Ancianos Rojo;Numero de Barones Nashor Rojo;Primera Sangre Rojo;Oro Rojo;Diferencia de Oro rojo;Region Rojo;Asesinatos Rojo; Muertes Rojo; Asesinatos/Muertes Rojo");
			 getMatches(url,writer,phase);
			 writer.close();
		 }catch (FileNotFoundException e) {
			 e.printStackTrace();
		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		 }
	 }

	 //Obtains the data from the World Championship 2019 and saves it as bdName.csv
	 //It invokes the method getMatches for each phase in the tournament
	 public void startWorldChampionship2019(){
	 	startWorldChampionship2019("World Championship 2019");
	 }

	 private void startWorldChampionship2019(String dbName){
	 	String playInUrl = "https://gol.gg/tournament/tournament-stats/World%20Championship%20Play-In%202019/";
	 	String groupPhaseUrl = "https://gol.gg/tournament/tournament-stats/World%20Championship%202019/";
	 	String knockoutStageUrl="";
		 try {
			 PrintWriter writer;
			 writer = new PrintWriter(dbName+".csv","UTF-8");
			 writer.println("Partido;Fase;Duracion;Nombre azul;Gana Azul;Primera Torre Azul;Numero de Torres Derribadas Azul;Diferencia de Torres Derribadas Azul;Numero total de Dragones Azul;Dragones de Nube Azul;Dragones de Oceano Azul;Dragones de Montaña Azul;Dragones Infernales Azul;Dragones Ancianos Azul;Numero de Barones Nashor Azul;Primera Sangre Azul;Oro Azul;Diferencia de Oro azul;Region Azul;Asesinatos Azul; Muertes Azul; Asesinatos/Muertes Azul;Nombre Rojo;Gana Rojo;Primera Torre Rojo;Numero de Torres Derribadas Rojo;Diferencia de Torres Derribadas Azul;Numero total de Dragones Rojo;Dragones de Nube Rojo;Dragones de Oceano Rojo;Dragones de Montaña Rojo;Dragones Infernales Rojo;Dragones Ancianos Rojo;Numero de Barones Nashor Rojo;Primera Sangre Rojo;Oro Rojo;Diferencia de Oro rojo;Region Rojo;Asesinatos Rojo; Muertes Rojo; Asesinatos/Muertes Rojo");
			 getMatches(groupPhaseUrl,writer, "GroupPhase");
			 getMatches(playInUrl,writer, "playIn");
			 System.out.println("Your World Championship 2019 database is ready!");
			 writer.close();
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 } catch (UnsupportedEncodingException e) {
			 e.printStackTrace();
		 }
	 }

	 //Obtains the data from the tournament ranging from [nFirstTournament-nLastTournament], and saves it as bdNmae.csv
	 public void start(String dbName, int nFirstTournament, int nLastTournament) {
		start(url,dbName, nFirstTournament,nLastTournament);
		System.out.println("Your "+dbName+" database is ready!");
	 }

	 //Auxiliary method from star(). Obtains the url from each tournament and invokes method getMatches, which recives a tournament url as an argument
	 private void start(String url, String dbName, int nFirstTournament, int nLastTournament) {
		 if(nLastTournament<nFirstTournament){
		 	System.out.println("start: Invalid arguments, nLastTournament can not be less than nFirtsTournament");
		 	return;
		 }
		 if(nLastTournament<1){
		 	System.out.println("start: Invalid arguments, nFirstTournament starts on 1");
		 	return;
		 }
	 	 if (getStatusConnectionCode(url) == 200) {
			 try {
				 	PrintWriter writer;
				 	writer = new PrintWriter(dbName+".csv","UTF-8");
				 	writer.println("Partido;Fase;Duracion;Nombre azul;Gana Azul;Primera Torre Azul;Numero de Torres Derribadas Azul;Diferencia de Torres Derribadas Azul;Numero total de Dragones Azul;Dragones de Nube Azul;Dragones de Oceano Azul;Dragones de Montaña Azul;Dragones Infernales Azul;Dragones Ancianos Azul;Numero de Barones Nashor Azul;Primera Sangre Azul;Oro Azul;Diferencia de Oro azul;Region Azul;Asesinatos Azul; Muertes Azul; Asesinatos/Muertes Azul;Nombre Rojo;Gana Rojo;Primera Torre Rojo;Numero de Torres Derribadas Rojo;Diferencia de Torres Derribadas Azul;Numero total de Dragones Rojo;Dragones de Nube Rojo;Dragones de Oceano Rojo;Dragones de Montaña Rojo;Dragones Infernales Rojo;Dragones Ancianos Rojo;Numero de Barones Nashor Rojo;Primera Sangre Rojo;Oro Rojo;Diferencia de Oro rojo;Region Rojo;Asesinatos Rojo; Muertes Rojo; Asesinatos/Muertes Rojo");
				 	Document document = getHtmlDocument(url);
		            Elements matches = document.getElementsByClass("col-xs-12").get(5).children().get(0).children().get(1).children();
		            String localurl ="";
		            for(int i = nFirstTournament; i<=nLastTournament; i++){
		            	localurl = getTournamentUrl(matches.get(i));
						getMatches(localurl,writer,"Tournament " + i);
					}
					writer.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			 
		 }else {
			 System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		 }
	 }

	 //Return the url of a tournament given its position in the html code of https://gol.gg/tournament/list/region-ALL/
	 private String getTournamentUrl(Element elem) {
		 String[] parts = elem.children().get(0).children().get(0).attr("href").split("/");
		 String result = "https://gol.gg/tournament/";
		 for(int i = 1; i<parts.length;i++) {			 
			 result+=parts[i] +"/";
		 }
		 System.out.println();		 
		 return result;
	 }

	 //Recives the list of matches from the tournament as an url. It checks if a match is a BO1 or a BO5, which are treated differently in the scrapper.
	 //Once a match has been classified as a BO1 or BO5, it is send to matchDataBO1 or matchDtaBO5 as it proceeds
	 private void getMatches(String url, PrintWriter writer,String phase) {
		 if (getStatusConnectionCode(url) == 200) {			 			 			
			 Document document = getHtmlDocument(url);            
             Elements matches = document.getElementsByClass("col-xs-12").get(16).children().get(1).children().get(1).children();
             for(Element match : matches) {
            	 String urlGame = urlGame(match);
            	 String matchname = matchname(match);
            	 int BO1 = bO1(match);	           
            	 if(BO1 == 1)matchDataBO1(urlGame,writer,matchname,phase);
            	 if(BO1 == 0)matchDataBO5(urlGame,writer,matchname,phase);            		             	 
             }
		 }else {
			 System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		 }
	 }

	 //Manages the games of BO5 format. It identifies the victors of each match of the BO5 game and invokes the method matchDataBO1 with each indivual match correspondig to its BO5 game
	 private void matchDataBO5(String url,PrintWriter db, String matchname, String phase) {
		 if (getStatusConnectionCode(url) == 200) {
			 Document document = getHtmlDocument(url);
			 Elements matches = document.getElementsByClass("col-xs-12").get(3).children().get(0).children().get(0).children().get(0).children();
			 String urlgame = "";
			 String match = "";
			 //int victor = -1;
			 for(int i= 1; i<matches.size()-1;i++) {				 
				 match = matchname+ " - Game " + i;
				 urlgame = "https://gol.gg/";
				 String[] urlgameparts = matches.get(i).children().get(0).attr("href").split("/");
				 for(int j = 1; j<urlgameparts.length; j++) {
					 urlgame += urlgameparts[j]+"/";
				 }
				 matchDataBO1(urlgame,db,match,phase);
			 }			 			 			 			 					 
		 }else {
			 System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		 }		 		 
	 }

	 //Returns and array of ints, victors[n] will be 1 if the match at position n+1 was won by blue side, and 0 if red won
	 private int[] victors(Elements elem) {
		 int[] victors = new int[elem.size()-1];
		 for(int i = 0; i <elem.size()-1; i++) {								 
			 victors[i] = victorBO5(elem.get(i).children().get(1).children().get(0).children().get(0).children().get(0));
		 }
		 return victors;
	}

	 //Obtains the victor from each match corresponding to a BO5 game
	 private int victorBO5(Element elem) {
		 int result = -1;
		 int blue = elem.children().get(0).children().size();
		 int red  = elem.children().get(2).children().size();
		 if(blue>red)result = 1;
		 if(red>blue)result = 0;
		 return result;
	 }

	 //Recieves the url of a match as an argument (url), which side won that match, the name of the match (match) and to which phase of the tournament it belonged
	 //It assembles the data obtained from both contenders and inserts it in the data base
	 private void matchDataBO1(String url, PrintWriter db, String match, String phase) {
		 if (getStatusConnectionCode(url) == 200) {
			 Document document = getHtmlDocument(url);
			 Elements datos = document.getElementsByClass("col-xs-12").get(4).children().get(0).children().get(0).children();
			 int gameTime = gameTime(datos.get(0));
			 int victor  = victor(datos.get(0));
             boolean victorb = false;
             if(victor == 1)victorb=true;
			 String blueRegion = region(datos.get(1).children().get(0));
			 String blueName = name(datos.get(1).children().get(0));
			 String blueDataRaw = contendantData(datos.get(2).children().get(0),true,blueRegion,victorb);
			 String redRegion = region(datos.get(1).children().get(1));
			 String redName = name(datos.get(1).children().get(1));
			 String redDataRaw = contendantData(datos.get(2).children().get(1),false,redRegion,victorb);
			 String[] blueDataParts = blueDataRaw.split(";");
			 String[] redDataParts = redDataRaw.split(";");
			 
			 float blueKills = Integer.parseInt(blueDataParts[blueDataParts.length-1]);
			 float blueDeaths = Integer.parseInt(redDataParts[redDataParts.length-1]);
			 float blueKDF = blueKills/blueDeaths;
			 String blueKD = kdaString(blueKDF);

			 int blueGoldDif = Integer.parseInt(blueDataParts[11])-Integer.parseInt(redDataParts[11]);
			 int blueTurretDif = Integer.parseInt(blueDataParts[2])-Integer.parseInt(redDataParts[2]);
			 blueDataRaw+=";"+(int)(blueDeaths)+";"+blueKD+";"+blueGoldDif+";"+blueTurretDif;
			 String blueData = sortedData(blueDataRaw);

			 float redKills = blueDeaths;
			 float redDeaths = blueKills;
			 float redKDF = redKills/redDeaths;
			 String redKD = kdaString(redKDF);

			 int redGoldDif = -1*blueGoldDif;
			 int redTurretDif = -1*blueTurretDif;
			 redDataRaw+=";"+(int)(redDeaths)+";"+redKD + ";" + redGoldDif+";"+redTurretDif;
			 String redData = sortedData(redDataRaw);


			 String result = match +";"+phase+";"+gameTime;
			 result += ";" + blueName+";"+blueData + ";"+redName+";" + redData;
			 db.println(result);
		 }else {
			 System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		 }
	 }

	 //Sorts the data and arranges it in the order established in README
	 private String sortedData(String rawData){
	 	String result = "";
	 	String[] parts = rawData.split(";");
	 	int i = 0;
	 	for(i = 0; i<3; i++){
	 		result += parts[i] + ";";
		}
	 	result+= parts[parts.length-1]+ ";";
	 	for(i = 3; i<12; i++){
	 		result += parts[i] + ";";
	 	}
	 	result+= parts[parts.length-2]+ ";";
		 for(i = 12; i<16; i++){
			 result += parts[i];
			 if(i != 15) result +=";";
		 }
	 	return result;
	 }

	 //Returns a string containing all the data from a contender in a match
	 private String contendantData(Element elem, boolean blue, String region, boolean victor) {
		 String result = "";
		 int firstTurret = firstTurret(elem);
		 int nTurrets = nTurrets(elem);	 
		 int nWindDrakes = numberOfWindDrakes(elem);
		 int nOceanDrakes = numberOfOceanDrakes(elem);
		 int nMountainDrakes = numberOfMountainDrakes(elem);
		 int nInfernalDrakes = numberOfInfernalDrakes(elem);
		 int nElderDrakes = numberOfElderDrakes(elem);
		 int nTotalDrakes = nWindDrakes + nOceanDrakes + nMountainDrakes + nInfernalDrakes + nElderDrakes;
		 int nBaron = numberOfBarons(elem);
		 int firstBlood = firstBlood(elem);
		 int gold = gold(elem);
		 int kills = kills(elem);
		 int victorInt = -1;
		 boolean victorb = !(victor^blue);
		 if(victorb)victorInt = 1;
		 if(!victorb)victorInt = 0;

		 result +=  victorInt + ";" + firstTurret + ";"+ nTurrets + ";" + nTotalDrakes + ";" + nWindDrakes+ ";" +nOceanDrakes+ ";" +nMountainDrakes + ";" + nInfernalDrakes+ ";" +nElderDrakes+ ";" +nBaron+ ";" + firstBlood+ ";" + gold + ";" + region + ";" +kills;
		 return result; 
	 }

	 //Returns the name of  contender in a match
	 private String name(Element elem) {
		 String result = elem.children().get(0).ownText();
		 return result.trim();
	 }

	 //Returns the number of kills a contender obtained in a match
	 private int kills(Element elem) {
		 int result = -1;
		 String k = elem.children().get(0).children().get(0).children().get(2).text();
		 if(k == "")return result;
		 result = Integer.parseInt(k.trim());
		 return result;
	 }

	 //Returns the region of a contender
	 private String region(Element elem) {
		 	 String result ="";
		 	 String[] parts = elem.children().get(0).attr("href").split("/");
		 	 String url = "https://gol.gg/";		 	 
		 	 for(int i = 1; i<parts.length; i++) {
		 		 url += parts[i].trim()+"/";
		 	 }
		 	 result = regionAux(url);
		 	 return result;
	 }

	 //Auxiliar method for region
	 private String regionAux(String url) {
		 String result = "-";
		 if (getStatusConnectionCode(url) == 200) {
			 Document document = getHtmlDocument(url);
			 result = document.getElementsByClass("col-xs-12").get(6).children().get(0).children().get(0).children().get(1).children().get(1).text();			
		 }else {
			 System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
		 }
		 return result;
	 }

	 //Returns the amount of gold obtained by a contender
	 private int gold(Element elem) {
	 		int result = -1;
		 	String[] g = elem.children().get(0).children().get(0).children().get(1).text().split("k");
		 	float result_aux = Float.parseFloat(g[0].trim());
		 	result = (int)(result_aux*1000);
		 	return result;
	 }

	 //Returns if a contender obtained first blood
	 private int firstBlood(Element elem) {
		 int result = -1;
		 Elements e = elem.children().get(0).children().get(0).children().get(2).children();
		 if(e.size()==3)result = 1;
		 if(e.size()==1)result = 0;
		 return result;
	 }

	 //Returns the number of Barons a contender obtained
	 private int numberOfBarons(Element elem) {
		 int result = 0;
		 String s = elem.children().get(0).children().get(0).children().get(4).text();
		 if(s.equals(""))return result;
		 result = Integer.parseInt(s.trim());
		 return result;
	 }

	 //Returns the number of Elder Dragons a contender obtained
	 private int numberOfElderDrakes(Element elem) {
		  int result = 0;
		  Elements elements = elem.children().get(0).children().get(0).children().get(3).children();
		  for(Element e : elements) {
			  if(e.attr("alt").trim().equalsIgnoreCase("Elder Dragon"))result ++;			  
		  }
		  return result;
	 }

	 //Returns the number of Infernal Dragons a contender obtained
	 private int numberOfInfernalDrakes(Element elem) {
		  int result = 0;
		  Elements elements = elem.children().get(0).children().get(0).children().get(3).children();
		  for(Element e : elements) {
			  if(e.attr("alt").trim().equalsIgnoreCase("Infernal Drake"))result ++;			  
		  }
		  return result;
	 }

	 //Returns the number of Mountain Dragons a contender obtained
	 private int numberOfMountainDrakes(Element elem) {
		  int result = 0;
		  Elements elements = elem.children().get(0).children().get(0).children().get(3).children();
		  for(Element e : elements) {
			  if(e.attr("alt").trim().equalsIgnoreCase("Mountain Drake"))result ++;
			  
		  }
		  return result;
	 }

	 //Returns the number of Wind Dragons a contender obtained
	 private int numberOfWindDrakes(Element elem) {
		  int result = 0;
		  Elements elements = elem.children().get(0).children().get(0).children().get(3).children();
		  for(Element e : elements) {
			  if(e.attr("alt").trim().equalsIgnoreCase("Cloud Drake"))result ++;
			  
		  }
		  return result;
	 }

	 //Returns the number of Ocean Dragons a contender obtained
	 private int numberOfOceanDrakes(Element elem) {
		  int result = 0;
		  Elements elements = elem.children().get(0).children().get(0).children().get(3).children();
		  for(Element e : elements) {
			  if(e.attr("alt").trim().equalsIgnoreCase("Ocean Drake"))result ++;
			  
		  }
		  return result;
	 }

	 //Returns the duration of a game
	 private int gameTime(Element elem) {
		 String[] g = elem.children().get(1).text().split(":");
		 int minutes = Integer.parseInt(g[0].trim())*60;
		 int seconds = Integer.parseInt(g[1].trim());
		 int result = minutes + seconds;
		 return result;
	 }

	 //Returns if a contendant obtained first turret
	 private int firstTurret(Element elem) {
		 int result = -1;
		 int size = elem.children().get(0).children().get(0).children().get(0).children().size();
		 if(size == 3)result = 1;
		 if(size == 1)result = 0;
		 return result;
	 }

	 //Returns the number of turrest a contendant destroyed
	 private int nTurrets(Element elem) {
		 int result = 0;
		 String n = elem.children().get(0).children().get(0).children().get(0).text();
		 try {
			 if(n!="")result = Integer.parseInt(n);
		 }catch(Exception e) {
			 
		 }
		 return result;
	 }

	 //Returns the name of the match
	 private String matchname(Element match) {
		 String result = match.children().get(0).children().get(0).text().trim();
		 return result;
	 }

	 //Returns the url of a game
	 private String urlGame(Element match) {
		 String result = "https://gol.gg/";
    	 String[] parts = match.children().get(0).children().get(0).attr("href").split("/");
    	 for(int i = 1; i<parts.length; i++) {
    		result += parts[i] +"/";
    	 }
    	 return result;
	 }

	 //Returns if a game is of BO1 format or BO5
	 private int bO1(Element match) {
		 String a =  match.children().get(2).text();
		 if(!a.contains("-"))return -1;
		 String[] s = a.split("-");
		 if(s.length!=2)return -1;
		 int blue = Integer.parseInt(s[0].trim());
		 int red = Integer.parseInt(s[1].trim());
		 if(blue >1 || red >1)return 0;
		 return 1; 
	 }

	 //Returns 1 if blue side wins, 0 if red wins
	 private int victor(Element match) {
		 if(match.children().get(1).children().get(1).hasAttr("id"))return 1;
		 return 0;
	 }

     private String kdaString(float kda){
        String a = ""+kda;
        String[] b = a.split("\\.");
        String result = b[0]+","+b[1];
        return  result;
    }

	 //Returns the status connection of a page
     int getStatusConnectionCode(String url) {
        Response response = null;
        try {
            return Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute().statusCode();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
            return 404;
        }
    }

     //Return the html document of the page
     Document getHtmlDocument(String url) {
        try {
            return Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
            return null;
        }
    }
}
