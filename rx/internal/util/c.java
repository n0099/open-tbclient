package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nrQ;
    Object[] nrR;
    int nrS;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nrQ = new Object[this.capacityHint + 1];
            this.nrR = this.nrQ;
            this.nrQ[0] = obj;
            this.nrS = 1;
            this.size = 1;
        } else if (this.nrS == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nrR[this.capacityHint] = objArr;
            this.nrR = objArr;
            this.nrS = 1;
            this.size++;
        } else {
            this.nrR[this.nrS] = obj;
            this.nrS++;
            this.size++;
        }
    }

    public Object[] dLk() {
        return this.nrQ;
    }

    public int size() {
        return this.size;
    }

    List<Object> dQi() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dLk = dLk();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dLk[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dLk = (Object[]) dLk[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dQi().toString();
    }
}
