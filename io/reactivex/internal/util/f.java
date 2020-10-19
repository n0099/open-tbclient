package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes17.dex */
public class f {
    final int capacityHint;
    Object[] oPD;
    Object[] oPE;
    int oPF;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.oPD = new Object[this.capacityHint + 1];
            this.oPE = this.oPD;
            this.oPD[0] = obj;
            this.oPF = 1;
            this.size = 1;
        } else if (this.oPF == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.oPE[this.capacityHint] = objArr;
            this.oPE = objArr;
            this.oPF = 1;
            this.size++;
        } else {
            this.oPE[this.oPF] = obj;
            this.oPF++;
            this.size++;
        }
    }

    public Object[] enl() {
        return this.oPD;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] enl = enl();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(enl[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                enl = (Object[]) enl[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
