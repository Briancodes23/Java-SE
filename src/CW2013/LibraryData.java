package CW2013;


import java.util.*;

public class LibraryData {

    private static class Item {

        Item(String n, String a, int r) {
            name = n;
            artist = a;
            rating = r;
        }

        // instance variables 
        private String name;
        private String artist;
        private int rating;
        private int playCount;

        public String toString() {
            return name + " - " + artist;
        }
    }

    
  
    private static Map <String, Item> library = new TreeMap<String, Item>();
    

    static {
        //All songs items will go into this static method, which means it can be accessed without creating an object 
        library.put("01", new Item("Songname01", "Artist01", 3));
        library.put("02", new Item("Songname02", "Artist02", 5));
        library.put("03", new Item("Songname03", "Artist03", 2));
        library.put("04", new Item("Songname04", "Artist04", 1));
        library.put("05", new Item("Songname05", "Artist05", 0));
        
    }   

    public static String listAll() {
        String output = "";
        Iterator iterator = library.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Item item = library.get(key);
            output += key + " " + item.name + " - " + item.artist + "\n";
        }
        return output;
    }

    public static String getName(String key) {
        Item item = library.get(key);
        if (item == null) {
            return null;
        } else {
            return item.name;
        }
    }
 

    public static String getArtist(String key) {
        Item item = library.get(key);
        if (item == null) {
            return null; 
        } else {
            return item.artist;
        }
    }

    public static int getRating(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1; 
        } else {
            return item.rating;
        }
    }

    public static void setRating(String key, int rating) {
        Item item = library.get(key);
        if (item != null) {
            item.rating = rating;
        }
    }

    public static int getPlayCount(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1;
        } else {
            return item.playCount;
        }
    }

    public static void incrementPlayCount(String key) {
        Item item = library.get(key);
        if (item != null) {
            item.playCount += 1;
        }
    }

    public static void close() {
      
    }
}
