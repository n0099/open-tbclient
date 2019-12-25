package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class f {
    final int capacityHint;
    Object[] mXk;
    Object[] mXl;
    int mXm;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.mXk = new Object[this.capacityHint + 1];
            this.mXl = this.mXk;
            this.mXk[0] = obj;
            this.mXm = 1;
            this.size = 1;
        } else if (this.mXm == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.mXl[this.capacityHint] = objArr;
            this.mXl = objArr;
            this.mXm = 1;
            this.size++;
        } else {
            this.mXl[this.mXm] = obj;
            this.mXm++;
            this.size++;
        }
    }

    public Object[] dEk() {
        return this.mXk;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dEk = dEk();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dEk[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dEk = (Object[]) dEk[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
