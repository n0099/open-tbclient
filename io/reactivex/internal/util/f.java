package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes9.dex */
public class f {
    final int capacityHint;
    Object[] pIL;
    Object[] pIM;
    int pIN;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.pIL = new Object[this.capacityHint + 1];
            this.pIM = this.pIL;
            this.pIL[0] = obj;
            this.pIN = 1;
            this.size = 1;
        } else if (this.pIN == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.pIM[this.capacityHint] = objArr;
            this.pIM = objArr;
            this.pIN = 1;
            this.size++;
        } else {
            this.pIM[this.pIN] = obj;
            this.pIN++;
            this.size++;
        }
    }

    public Object[] eDr() {
        return this.pIL;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] eDr = eDr();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(eDr[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                eDr = (Object[]) eDr[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
