package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f {
    final int capacityHint;
    Object[] qrB;
    Object[] qrC;
    int qrD;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.qrB = new Object[this.capacityHint + 1];
            this.qrC = this.qrB;
            this.qrB[0] = obj;
            this.qrD = 1;
            this.size = 1;
        } else if (this.qrD == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.qrC[this.capacityHint] = objArr;
            this.qrC = objArr;
            this.qrD = 1;
            this.size++;
        } else {
            this.qrC[this.qrD] = obj;
            this.qrD++;
            this.size++;
        }
    }

    public Object[] eKE() {
        return this.qrB;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        int i4 = 0;
        Object[] eKE = eKE();
        while (i4 < i2) {
            arrayList.add(eKE[i3]);
            i4++;
            int i5 = i3 + 1;
            if (i5 == i) {
                i3 = 0;
                eKE = eKE[i];
            } else {
                i3 = i5;
            }
        }
        return arrayList.toString();
    }
}
