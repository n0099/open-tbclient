package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nBZ;
    Object[] nCa;
    int nCb;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nBZ = new Object[this.capacityHint + 1];
            this.nCa = this.nBZ;
            this.nBZ[0] = obj;
            this.nCb = 1;
            this.size = 1;
        } else if (this.nCb == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nCa[this.capacityHint] = objArr;
            this.nCa = objArr;
            this.nCb = 1;
            this.size++;
        } else {
            this.nCa[this.nCb] = obj;
            this.nCb++;
            this.size++;
        }
    }

    public Object[] dKg() {
        return this.nBZ;
    }

    public int size() {
        return this.size;
    }

    List<Object> dPd() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dKg = dKg();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dKg[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dKg = (Object[]) dKg[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dPd().toString();
    }
}
