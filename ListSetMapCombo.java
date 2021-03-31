
import java.util.*;
import java.util.stream.Collectors;
import java.util.Map.Entry;


public class ListSetMapCombo {

    public static void main(String[] args) {
        List<String> listdata = new ArrayList<>();
        addDataToList(listdata);

        //identify duplicates in list and record how many time they are occurring
        Set<String> treesetdata = new TreeSet<>();
        Map<String,Integer> treemapdata= new TreeMap<>();
        boolean added;
        for(String s:listdata){
            added = treesetdata.add(s);
            if(added){
                treemapdata.put(s,1);
            }else{
                treemapdata.put(s,treemapdata.get(s)+1);
            }
        }

        //print data in set
        treesetdata.stream().forEach(System.out::println);
        System.out.println("---- Above is set data ----");

        //print data in map
        treemapdata.forEach((key,value) -> System.out.println(key+" "+value));
        System.out.println("---- Above is tree data ----");

        //print mapdata in sorted - Ofcourse we are using treemap this is not required
        //in case we are using hashmap this would be useful
        treemapdata.entrySet().stream()
                .sorted( (k1,k2) -> k1.getValue().compareTo(k2.getValue()) )
                .forEach((k -> System.out.println(k.getKey() +" "+k.getValue())));
        System.out.println("---- Above is tree map data sorted by value ----");

        //Sorting by value and storing the result in Map
        Map<String, Integer> valueascsortedmap = treemapdata.entrySet().stream()
                                                .sorted(Entry.comparingByValue())
                                                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                                                    (e1, e2) -> e1 , LinkedHashMap::new)
                                                        );
        valueascsortedmap.forEach((key,value) -> System.out.println(key+" "+value));
        System.out.println("---- Above is stored map data sorted by value ----");

        Map<String,Integer> valuedescsortedmap = treemapdata.entrySet().stream()
                .sorted(Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                        (e1,e2) -> e1, LinkedHashMap::new)
                );
        valuedescsortedmap.forEach((key,value) -> System.out.println(key+" "+value));

        System.out.println("---- Above is reverse stored map data sorted by value ----");

    }



    private static void addDataToList(List<String> listdata) {
        listdata.add("value1");listdata.add("value1");listdata.add("value1");
        listdata.add("value2");listdata.add("value2");
        listdata.add("value3");listdata.add("value3");listdata.add("value3");listdata.add("value3");
        listdata.add("value4");
        listdata.add("value7");listdata.add("value7");listdata.add("value7");listdata.add("value7");listdata.add("value7");listdata.add("value7");
        listdata.add("value5");listdata.add("value5");listdata.add("value5");listdata.add("value5");listdata.add("value5");listdata.add("value5");
        listdata.add("value8");listdata.add("value8");listdata.add("value8");
    }
}
