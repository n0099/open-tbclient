package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f {
    final int capacityHint;
    Object[] nzs;
    Object[] nzt;
    int nzu;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nzs = new Object[this.capacityHint + 1];
            this.nzt = this.nzs;
            this.nzs[0] = obj;
            this.nzu = 1;
            this.size = 1;
        } else if (this.nzu == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nzt[this.capacityHint] = objArr;
            this.nzt = objArr;
            this.nzu = 1;
            this.size++;
        } else {
            this.nzt[this.nzu] = obj;
            this.nzu++;
            this.size++;
        }
    }

    public Object[] dIu() {
        return this.nzs;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dIu = dIu();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dIu[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dIu = (Object[]) dIu[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
