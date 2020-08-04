package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public class f {
    final int capacityHint;
    Object[] nWr;
    Object[] nWs;
    int nWt;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nWr = new Object[this.capacityHint + 1];
            this.nWs = this.nWr;
            this.nWr[0] = obj;
            this.nWt = 1;
            this.size = 1;
        } else if (this.nWt == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nWs[this.capacityHint] = objArr;
            this.nWs = objArr;
            this.nWt = 1;
            this.size++;
        } else {
            this.nWs[this.nWt] = obj;
            this.nWt++;
            this.size++;
        }
    }

    public Object[] dTr() {
        return this.nWr;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dTr = dTr();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dTr[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dTr = (Object[]) dTr[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
