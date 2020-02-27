package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nAa;
    int nAb;
    Object[] nzZ;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nzZ = new Object[this.capacityHint + 1];
            this.nAa = this.nzZ;
            this.nzZ[0] = obj;
            this.nAb = 1;
            this.size = 1;
        } else if (this.nAb == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nAa[this.capacityHint] = objArr;
            this.nAa = objArr;
            this.nAb = 1;
            this.size++;
        } else {
            this.nAa[this.nAb] = obj;
            this.nAb++;
            this.size++;
        }
    }

    public Object[] dJD() {
        return this.nzZ;
    }

    public int size() {
        return this.size;
    }

    List<Object> dOA() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dJD = dJD();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dJD[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dJD = (Object[]) dJD[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dOA().toString();
    }
}
