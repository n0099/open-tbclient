package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class f {
    final int capacityHint;
    Object[] qsb;
    Object[] qsc;
    int qsd;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.qsb = new Object[this.capacityHint + 1];
            this.qsc = this.qsb;
            this.qsb[0] = obj;
            this.qsd = 1;
            this.size = 1;
        } else if (this.qsd == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.qsc[this.capacityHint] = objArr;
            this.qsc = objArr;
            this.qsd = 1;
            this.size++;
        } else {
            this.qsc[this.qsd] = obj;
            this.qsd++;
            this.size++;
        }
    }

    public Object[] eKM() {
        return this.qsb;
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
        Object[] eKM = eKM();
        while (i4 < i2) {
            arrayList.add(eKM[i3]);
            i4++;
            int i5 = i3 + 1;
            if (i5 == i) {
                i3 = 0;
                eKM = eKM[i];
            } else {
                i3 = i5;
            }
        }
        return arrayList.toString();
    }
}
