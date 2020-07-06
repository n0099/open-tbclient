package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nNG;
    Object[] nNH;
    int nNI;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nNG = new Object[this.capacityHint + 1];
            this.nNH = this.nNG;
            this.nNG[0] = obj;
            this.nNI = 1;
            this.size = 1;
        } else if (this.nNI == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nNH[this.capacityHint] = objArr;
            this.nNH = objArr;
            this.nNI = 1;
            this.size++;
        } else {
            this.nNH[this.nNI] = obj;
            this.nNI++;
            this.size++;
        }
    }

    public Object[] dPU() {
        return this.nNG;
    }

    public int size() {
        return this.size;
    }

    List<Object> dUS() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dPU = dPU();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dPU[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dPU = (Object[]) dPU[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dUS().toString();
    }
}
