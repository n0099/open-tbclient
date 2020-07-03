package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nND;
    Object[] nNE;
    int nNF;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nND = new Object[this.capacityHint + 1];
            this.nNE = this.nND;
            this.nND[0] = obj;
            this.nNF = 1;
            this.size = 1;
        } else if (this.nNF == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nNE[this.capacityHint] = objArr;
            this.nNE = objArr;
            this.nNF = 1;
            this.size++;
        } else {
            this.nNE[this.nNF] = obj;
            this.nNF++;
            this.size++;
        }
    }

    public Object[] dPQ() {
        return this.nND;
    }

    public int size() {
        return this.size;
    }

    List<Object> dUO() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dPQ = dPQ();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dPQ[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dPQ = (Object[]) dPQ[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dUO().toString();
    }
}
