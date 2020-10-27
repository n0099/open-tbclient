package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class c {
    final int capacityHint;
    Object[] pHa;
    Object[] pHb;
    int pHc;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.pHa = new Object[this.capacityHint + 1];
            this.pHb = this.pHa;
            this.pHa[0] = obj;
            this.pHc = 1;
            this.size = 1;
        } else if (this.pHc == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.pHb[this.capacityHint] = objArr;
            this.pHb = objArr;
            this.pHc = 1;
            this.size++;
        } else {
            this.pHb[this.pHc] = obj;
            this.pHc++;
            this.size++;
        }
    }

    public Object[] exk() {
        return this.pHa;
    }

    public int size() {
        return this.size;
    }

    List<Object> eCj() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] exk = exk();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(exk[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                exk = (Object[]) exk[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return eCj().toString();
    }
}
