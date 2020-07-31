package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nWp;
    Object[] nWq;
    int nWr;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nWp = new Object[this.capacityHint + 1];
            this.nWq = this.nWp;
            this.nWp[0] = obj;
            this.nWr = 1;
            this.size = 1;
        } else if (this.nWr == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nWq[this.capacityHint] = objArr;
            this.nWq = objArr;
            this.nWr = 1;
            this.size++;
        } else {
            this.nWq[this.nWr] = obj;
            this.nWr++;
            this.size++;
        }
    }

    public Object[] dTq() {
        return this.nWp;
    }

    public int size() {
        return this.size;
    }

    List<Object> dYo() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dTq = dTq();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dTq[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dTq = (Object[]) dTq[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dYo().toString();
    }
}
