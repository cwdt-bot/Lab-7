
class wasteTime {

    //List where [min, max, sum, count]
    private double[] ffs = new double[4];
    private boolean fresh = true;

    public wasteTime(){}

    public wasteTime update(Double d) {
        if (this.fresh == true) {
            ffs[3] = 1;
            for (int x = 0; x < 3; x++) {
                ffs[x] = d;
                this.fresh = false;
            }
        } else {
            ffs[0] = Double.min(ffs[0], d);
            ffs[1] = Double.max(ffs[1], d);
            ffs[2] = ffs[2] + d;
            ffs[3] = ffs[3] + 1;
        }
        return this;
    }

    public double soMean() {
        double sum = ffs[2];
        double currMin = ffs[0];
        double currMax = ffs[1];
        double count = ffs[3];
        if (currMax == currMin){
            return 0;
        }
        return ((sum/count)-currMin)/(currMax-currMin);
    }

}