package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes25.dex */
public class f {
    final int capacityHint;
    Object[] oAo;
    Object[] oAp;
    int oAq;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.oAo = new Object[this.capacityHint + 1];
            this.oAp = this.oAo;
            this.oAo[0] = obj;
            this.oAq = 1;
            this.size = 1;
        } else if (this.oAq == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.oAp[this.capacityHint] = objArr;
            this.oAp = objArr;
            this.oAq = 1;
            this.size++;
        } else {
            this.oAp[this.oAq] = obj;
            this.oAq++;
            this.size++;
        }
    }

    public Object[] ejz() {
        return this.oAo;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] ejz = ejz();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(ejz[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                ejz = (Object[]) ejz[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
