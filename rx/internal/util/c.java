package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nAb;
    Object[] nAc;
    int nAd;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nAb = new Object[this.capacityHint + 1];
            this.nAc = this.nAb;
            this.nAb[0] = obj;
            this.nAd = 1;
            this.size = 1;
        } else if (this.nAd == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nAc[this.capacityHint] = objArr;
            this.nAc = objArr;
            this.nAd = 1;
            this.size++;
        } else {
            this.nAc[this.nAd] = obj;
            this.nAd++;
            this.size++;
        }
    }

    public Object[] dJF() {
        return this.nAb;
    }

    public int size() {
        return this.size;
    }

    List<Object> dOC() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dJF = dJF();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dJF[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dJF = (Object[]) dJF[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dOC().toString();
    }
}
