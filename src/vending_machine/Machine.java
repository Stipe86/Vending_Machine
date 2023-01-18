package vending_machine;

public class Machine {

    private Item[][] items;


    public Machine () {
    }


    public Machine (Item [][] items) {
        this.items = new Item [items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item (items[i][j]);
            }
        }
    }

    public Machine(Machine source) {
        this.items = new Item[source.items.length][source.items[0].length];
        for (int i = 0; i < source.items.length; i++) {
            for (int j = 0; j < source.items[i].length; j++) {
                this.items[i][j] = new Item(source.items[i][j]);
            }
        }
    }


    public Item getItem(int row, int spot) {
        return new Item(this.items[row][spot]);
    }

    public Item [][] getItems() {
        Item [][] copy = new Item[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                copy[i][j]=items[i][j];
            }
        }
        return copy;

    }


    public void setItem(Item item, int row, int spot) {
    this.items[row][spot] = new Item(item);
    }

    public void setItems(Item[][] items) {
        this.items = new Item[items.length][items[0].length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                this.items[i][j] = new Item(items[i][j]);
            }
        }
    }

    /**
     * Function name – dispense
     * @param row (int)
     * @param spot (int)
     * @return (boolean)
     *
     * Inside the function:
     *  1. Checks if the requested item has a quantity bigger than 0.
     *      • if so: decreases its quantity by one and returns true.
     *      • otherwise: returns false.
     */

    public boolean dispense (int row, int spot) {
       if (items[row][spot].getQuantity()>0) {
           items[row][spot].setQuantity(items[row][spot].getQuantity()-1);
           return true;
       }

       else {

        return false;
       }
    }

    @Override
    public String toString() {
        String s = "";
        s += "\n";
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                s += "\t";
                s += items[i][j].toString()+ " ";
            }
            s += "\n";
        }
        s += "\t***************************";
        return s;
    }
}
