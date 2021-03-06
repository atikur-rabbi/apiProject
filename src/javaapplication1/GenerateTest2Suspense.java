/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import static javaapplication1.GenerateTest2DK.artist;
import static javaapplication1.GenerateTest2DK.imageUrl;

//import com.sun.deploy.net.URLEncoder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Fahad-PC
 */
public class GenerateTest2Suspense {
//
//    {"employees":[
//    {"firstName":"John", "lastName":"Doe"},
//    {"firstName":"Anna", "lastName":"Smith"},
//    {"firstName":"Peter", "lastName":"Jones"}
//]}
//    

    static int songID;
    static String title;
    static String artist;
    //String album;
    static String path;
    static long duration;
    static long albumId;
    static String composer;
    static String imageUrl;

    static int albumID;
    static String albumName;
    private static Object fis;

    private static void readFile() {
        BufferedReader buffreader = null;
        try {

            //File file = new File("filename_sunday_sus.txt");
            File file = new File("radio_sunday_sus/filename_sunday_sus_name_rep.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //InputStream fis = new FileInputStream("sunday_suspense.txt");     
            InputStream fis = new FileInputStream("radio_sunday_sus/filename_sunday_sus_rep.txt");
            // if file the available for reading
            if (fis != null) {

                // prepare the file for reading
                InputStreamReader chapterReader = new InputStreamReader(fis);
                buffreader = new BufferedReader(chapterReader);

                String line = null;
                while (true) {
                    try {
                        line = buffreader.readLine();
                        String segment = line.substring(46);//33
                        String fin = segment.substring(0, segment.length() - 4);
                        fin = fin.replace("_", " ");
                        fin = fin.replace("-", " ");
                        fin = fin.replace("%28", "");
                        fin = fin.replace("%27", "");
                        fin = fin.replace("%29", "");
                        bw.write(fin + "\n");

                    } catch (Exception e) {

                    }

                    if (line == null) {
                        break;
                    }

                    songPath.add(line);

                }

                bw.close();


                /*String line;

                 // read every line of the file into the line-variable, on line at the time
                 do {
                 line = buffreader.readLine();
                 // do something with the line 
                 System.out.println(line);
                 } while (line != null);
                 */
            }
        } catch (Exception e) {

        } finally {

        }
        boolean abc = true;
        if (abc) {
            return;
        }
    }

    private static void encryptAndWriteToFile() {

        String[] urlImage = {
            "http://i.imgur.com/i2Z2Kdx.png",
            "http://i.imgur.com/38j0K51.png",
            "http://i.imgur.com/NPUTTlR.png",
            "http://i.imgur.com/dO9BzMU.png",
            "http://i.imgur.com/Y42hBNW.jpg",
            "http://i.imgur.com/l8aYI2s.png",
            "http://i.imgur.com/NPUTTlR.png"
        };

        String[] urlAppName = {
            "Aloukik Robbar + Sunday Suspense Collection",
            "Jiboner Golpo Collection",
            "Sunday Suspense Collection\n" +
                    "Note: On request of Radio Mirchi we\n" +
                    "have to remove the app from play store.\n" +
                    "But you guys can enjoy all episode\n" +
                    "include new one in Aloukik Robbar App" ,
            "Rohosyo Romancho Ghost Story",
            "Kuasha Collection",
            "Dor Collection",
            "Bhoot FM Collection"
        };

        String[] urlAppPackageName = {
            "com.studio71.aloukik_robbar",
            "com.studio71.jiboner_golpo_collection",
            "com.studio71.aloukik_robbar",
            "com.studio71.rohosyo_romancho_ghost",
            "com.studio71.kuasha_collection",
            "com.studio71.dor_collection",
            "com.crossappers.bhootfm_collection"
        };

        ArrayList<AppData> appList = new ArrayList<>();
        for (int i = 0; i < urlAppName.length; i++) {
            appList.add(new AppData(i, urlAppName[i], urlAppPackageName[i], urlImage[i]));
        }

        InputStream fis = null;
        try {
            fis = new FileInputStream("filename_sunday_sus_main.json");

            if (fis != null) {
                
                

                InputStreamReader chapterReader = new InputStreamReader(fis);
                BufferedReader buffreader = new BufferedReader(chapterReader);
                String fullData = "";

                while (true) {
                    String tempData = buffreader.readLine();
                    if (tempData == null) {
                        break;
                    }
                    
                    fullData += tempData;
                }
                
                JSONObject jsonObject = new JSONObject(fullData);
                JSONArray jsonArraySong = jsonObject.getJSONArray("songList");
               
                String songJson = jsonArraySong.toString();
                byte[] compressedByte = compress(jsonArraySong.toString());
                String compressedFullData = Base64.getEncoder().encodeToString(compressedByte);

                compressedByte = compress(new Gson().toJson(appList));
                String appListCompressedFullDta = Base64.getEncoder().encodeToString(compressedByte);

                Data data = new Data("905", compressedFullData, appListCompressedFullDta);

                
                File file = new File("radio_sunday_sus/filename_sunday_sus_main_2.json");

                
                
                if (!file.exists()) {
                    file.createNewFile();
                   
                }
                
                

                FileWriter fw = new FileWriter(file.getPath());
                System.out.println("write 6" );
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(new Gson().toJson(data));
                bw.close();
                
                System.out.println("write " + new Gson().toJson(data));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("write 3");
        } catch (IOException ex) {
            System.out.println("write 2");
        }
        
        System.out.println("write 1");

    }

    private static void findTheOriginalUrl() {
        try{
        File file = new File("radio_sunday_sus/filename_sunday_sus_orig_url.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //InputStream fis = new FileInputStream("sunday_suspense.txt");     
            InputStream fis = new FileInputStream("sunday_outputfileName64.txt");
            // if file the available for reading
            if (fis != null) {

                // prepare the file for reading
                InputStreamReader chapterReader = new InputStreamReader(fis);
                BufferedReader buffreader = new BufferedReader(chapterReader);

                String line = null;
                while (true) {
                    try {
                        line = buffreader.readLine();
                    } catch (Exception e) {

                    }

                    if (line == null) {
                        break;
                    }
                    
                    
                    System.out.println("fake: " + line);
                    String url = getFinalURL(line);
                    System.out.println("url " + url);
                    bw.write(url + "\n");

                }

                bw.close();


                /*String line;

                 // read every line of the file into the line-variable, on line at the time
                 do {
                 line = buffreader.readLine();
                 // do something with the line 
                 System.out.println(line);
                 } while (line != null);
                 */
            }
        } catch (Exception e) {
               System.out.println("" + e.toString());
        } finally {

        }
    }
    
    public static String getFinalURL(String url) throws IOException {
    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
    con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

    con.setInstanceFollowRedirects(false);
    con.connect();
    con.getInputStream();

    if (con.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM || con.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
        String redirectUrl = con.getHeaderField("Location");
        return getFinalURL(redirectUrl);
    }
    return url;
}

    ArrayList<String> songList = new ArrayList<>();
    static ArrayList<String> songPath = new ArrayList<>();

    //http://dl.bhoot-fm.com/Bhoot-FM_2016-10-28_(Bhoot-FM.com).mp3
    public static void main(String[] args) throws IOException {

        //();
        //if(true)return;
        //readFile();
        //encryptAndWriteToFile();
        //findTheOriginalUrl();

        //generateGCSFileUrl();
        //if(true) return;

        String[] urlImage = {
            "http://i.imgur.com/DMmPf5f.jpg",
            "http://i.imgur.com/8C3N9lN.jpg",
            "http://i.imgur.com/LGsUamV.jpg",
            "http://i.imgur.com/DrWxBD3.jpg",
            "http://i.imgur.com/kzr9p5M.jpg",
            "http://i.imgur.com/X4pn6lX.jpg",
            "http://i.imgur.com/VvLI4sY.jpg"

        };

        BufferedReader buffreader;
        BufferedReader buffreader2;
        try {

            //File file = new File("filename_sunday_sus.txt");
            //InputStream fis = new FileInputStream("sunday_suspense.txt");     
            InputStream fis = new FileInputStream("sunday_outputfileName_url_bangla.txt");
            InputStream fis2 = new FileInputStream("sunday_outputfileName_name_bangla.txt");
            // if file the available for reading
            if (fis != null) {

                // prepare the file for reading
                InputStreamReader chapterReader = new InputStreamReader(fis);
                buffreader = new BufferedReader(chapterReader);

                InputStreamReader chapterReader2 = new InputStreamReader(fis2);
                buffreader2 = new BufferedReader(chapterReader2);

                String songPath = null;
                String songName = null;

                String url = "{\"songList\":[";

                songID = 0;

                artist = "SS";
                composer = "RM";

                Random r = new Random();

                while (true) {

                    songPath = buffreader.readLine();
                    songName = buffreader2.readLine();
                    
                    if (songPath == null) {
                        break;
                    }
                    
                    songName = songName.replace("SS", "");
                    songName = songName.replace("64ks", "");
                    songName = songName.replace(".mp3", "");


                    imageUrl = urlImage[r.nextInt(7)];

                    /*if(songID>=22)
                    {
                        artist = "SS";
                        composer = "RM";
                    }*/

                    url += "{\"songID\":\"" + songID + "\", \"title\":\"" + (((songID<23)?songID + 1: songID+1 + "" ) ) + "-" + songName + "\", \"artist\":\"" + artist + "\", \"path\":\"" + songPath + "\", \"albumId\":\"" + albumID + "\", \"composer\":\"" + composer + "\", \"imageUrl\":\"" + imageUrl + "\"},";

                    songID++;

                }
                url = url.substring(0, url.length() - 1) + "]}";

                System.out.println("" + url);

                File file = new File("filename_sunday_sus_main.json");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(url);
                bw.close();

                System.out.println("Done");

            }
        } catch (Exception e) {
                System.out.println("exception " +e.toString());
        } finally {

        }

        encryptAndWriteToFile();

    }

    class Song{
        int songID;
        String title;
        String artist;
        String path;
        String albumId;
        String composer;
        String imageUrl;
    }

    private static void readFile2() {

        BufferedReader buffreader;

        try {

            InputStream fis = new FileInputStream("new  2.txt");

            if (fis != null) {
                InputStreamReader chapterReader = new InputStreamReader(fis);
                buffreader = new BufferedReader(chapterReader);
                String songPath = "";


                songID = 41;

                while (true) {
                    String line = buffreader.readLine();

                    if ( line == null) {
                        break;
                    }
                    songPath += line;
                }

                Gson gson  = new Gson();
                List<Song> songList = Arrays.asList(gson.fromJson(songPath, Song[].class));

                for(Song song: songList)
                {
                    song.songID = songID++;
                }

               File file = new File("aloukik_sunday.txt");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(gson.toJson(songList));
                bw.close();

                System.out.println("Done");

            }
        } catch (Exception e) {
            System.out.println("exception " +e.toString());
        } finally {

        }
    }

    public static byte[] compress(String data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return compressed;
    }

    public static void generateGCSFileUrl()
    {

        String lineArray[] = new String[75];
        File folder = new File("D:\\sunday");
        File[] listOfFiles = folder.listFiles();

        try{
        File file = new File("new 2.txt");


        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader buffreader;

        //InputStream fis = new FileInputStream("sunday_suspense.txt");
        InputStream fis = new FileInputStream("new  2.txt");
        // if file the available for reading
        if (fis != null) {

            // prepare the file for reading
            InputStreamReader chapterReader = new InputStreamReader(fis);
            buffreader = new BufferedReader(chapterReader);

            int i = 0;
            String line;
             do {
             line = buffreader.readLine();
             lineArray[i++] = line;
             if(i==72) break;
             } while (line != null);

            bw.close();



        }
    } catch (Exception e) {

    } finally {

    }

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                String name = listOfFiles[i].getName().replaceAll(" ", "_");
                lineArray[i] = lineArray[i].replace("folder", "file");
                try {
                    URL url= new URL(lineArray[i] +"/" + name);
                    URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());

                    String urlStr=uri.toASCIIString();
                    System.out.println(urlStr);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

                //String name = listOfFiles[i].getName().replaceAll(" ", "_");
                //name = name.replaceAll(".mp3", "");
                //name = name.replaceAll(" 64ks", "");
                //name = name.replaceAll(" SS", "");


                //System.out.println(name);
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

}
