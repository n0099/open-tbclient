package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public class f {
    final int capacityHint;
    Object[] mVA;
    Object[] mVB;
    int mVC;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.mVA = new Object[this.capacityHint + 1];
            this.mVB = this.mVA;
            this.mVA[0] = obj;
            this.mVC = 1;
            this.size = 1;
        } else if (this.mVC == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.mVB[this.capacityHint] = objArr;
            this.mVB = objArr;
            this.mVC = 1;
            this.size++;
        } else {
            this.mVB[this.mVC] = obj;
            this.mVC++;
            this.size++;
        }
    }

    public Object[] dDf() {
        return this.mVA;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dDf = dDf();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dDf[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dDf = (Object[]) dDf[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
