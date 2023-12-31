package Cases;

public class CaseTest {
    int xx = 170;
    int yy = 635;

    public int case1() {
        if (xx < 870 && yy == 635 && xx != 380 && xx != 590) {
            xx += 70;
            if (xx == 380 && yy == 635) {
                xx -= 140;
                yy -= 70;
            } else if (xx == 590 && yy == 635) {
                xx += 70;
                yy -= 70;
            }
        } else if (xx == 870 && yy == 635) {
//                        xx -= 70;
            //870 Ladder()
            yy -= 70;
        } else if (xx < 210 && yy == 565) {
            xx -= 70;
        }
        return xx;

    }
}