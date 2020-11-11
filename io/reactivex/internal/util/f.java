package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes17.dex */
public class f {
    final int capacityHint;
    Object[] pQu;
    Object[] pQv;
    int pQw;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.pQu = new Object[this.capacityHint + 1];
            this.pQv = this.pQu;
            this.pQu[0] = obj;
            this.pQw = 1;
            this.size = 1;
        } else if (this.pQw == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.pQv[this.capacityHint] = objArr;
            this.pQv = objArr;
            this.pQw = 1;
            this.size++;
        } else {
            this.pQv[this.pQw] = obj;
            this.pQw++;
            this.size++;
        }
    }

    public Object[] eAZ() {
        return this.pQu;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] eAZ = eAZ();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(eAZ[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                eAZ = (Object[]) eAZ[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
