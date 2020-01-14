package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    final int capacityHint;
    Object[] nzx;
    Object[] nzy;
    int nzz;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nzx = new Object[this.capacityHint + 1];
            this.nzy = this.nzx;
            this.nzx[0] = obj;
            this.nzz = 1;
            this.size = 1;
        } else if (this.nzz == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nzy[this.capacityHint] = objArr;
            this.nzy = objArr;
            this.nzz = 1;
            this.size++;
        } else {
            this.nzy[this.nzz] = obj;
            this.nzz++;
            this.size++;
        }
    }

    public Object[] dIw() {
        return this.nzx;
    }

    public int size() {
        return this.size;
    }

    List<Object> dNn() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dIw = dIw();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dIw[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dIw = (Object[]) dIw[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dNn().toString();
    }
}
