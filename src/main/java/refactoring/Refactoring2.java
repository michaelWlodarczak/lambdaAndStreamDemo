package refactoring;

import java.util.ArrayList;

public class Refactoring2 {
    private String [] names = new String[3];

    public Refactoring2 (){
        ArrayList<String> initialNames = new ArrayList<>();
        initialNames.add("Hania");
        initialNames.add("Krzys");
        initialNames.add("Michal");

        names = initialNames.toArray(new String[3]);
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }


}
