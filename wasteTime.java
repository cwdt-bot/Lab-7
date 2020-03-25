
import java.util.List;
import java.util.ArrayList;

class wasteTime {

    //List where [min, max, sum, count]
    private final List<Double> ffs;

    public wasteTime(){
        this.ffs = new ArrayList<>();
    }

    public wasteTime(Double d){
        List<Double> newList = new ArrayList<>();
        for (int x = 0; x < 3; x++) {
            newList.add(d);
        }
        newList.add(1.0);
        this.ffs = newList;
    }

    private wasteTime(List<Double> list){
        this.ffs = list;
    }

    public List<Double> getList() {
        return this.ffs;
    }

    public wasteTime update(wasteTime w) {
        List<Double> newList = new ArrayList<>(this.getList());
        if (newList.size() == 0) {
            for (int x = 0; x < 3; x++) {
                newList.add(w.getList().get(0));
            }
            newList.add(1.0);
        } else {
            newList.set(0,Double.min(newList.get(0), w.getList().get(0)));
            newList.set(1,Double.max(newList.get(1), w.getList().get(1)));
            newList.set(2,newList.get(2) + w.getList().get(2));
            newList.set(3,newList.get(3) + w.getList().get(3));
        }
        return new wasteTime(newList);
    }

    public double soMean() {
        double currMin = this.ffs.get(0);
        double currMax = this.ffs.get(1);
        double sum = this.ffs.get(2);
        double count = this.ffs.get(3);
        if (currMax == currMin){
            return 0;
        }
        return ((sum/count)-currMin)/(currMax-currMin);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
            for(double s : this.ffs) {
                builder.append(s);
        }
        return builder.toString();
    }

}