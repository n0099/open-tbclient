package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kaX;
    Object[] kaY;
    Object[] kaZ;
    int kba;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kaY = new Object[this.kaX + 1];
            this.kaZ = this.kaY;
            this.kaY[0] = obj;
            this.kba = 1;
            this.size = 1;
        } else if (this.kba == this.kaX) {
            Object[] objArr = new Object[this.kaX + 1];
            objArr[0] = obj;
            this.kaZ[this.kaX] = objArr;
            this.kaZ = objArr;
            this.kba = 1;
            this.size++;
        } else {
            this.kaZ[this.kba] = obj;
            this.kba++;
            this.size++;
        }
    }

    public Object[] cEx() {
        return this.kaY;
    }

    public int size() {
        return this.size;
    }

    List<Object> cEy() {
        int i = this.kaX;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cEx = cEx();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cEx[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cEx = (Object[]) cEx[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cEy().toString();
    }
}
