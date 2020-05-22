package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nqG;
    Object[] nqH;
    int nqI;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nqG = new Object[this.capacityHint + 1];
            this.nqH = this.nqG;
            this.nqG[0] = obj;
            this.nqI = 1;
            this.size = 1;
        } else if (this.nqI == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nqH[this.capacityHint] = objArr;
            this.nqH = objArr;
            this.nqI = 1;
            this.size++;
        } else {
            this.nqH[this.nqI] = obj;
            this.nqI++;
            this.size++;
        }
    }

    public Object[] dKW() {
        return this.nqG;
    }

    public int size() {
        return this.size;
    }

    List<Object> dPU() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dKW = dKW();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dKW[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dKW = (Object[]) dKW[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dPU().toString();
    }
}
