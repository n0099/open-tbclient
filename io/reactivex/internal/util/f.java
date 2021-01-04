package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {
    final int capacityHint;
    Object[] qkq;
    Object[] qkr;
    int qks;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.qkq = new Object[this.capacityHint + 1];
            this.qkr = this.qkq;
            this.qkq[0] = obj;
            this.qks = 1;
            this.size = 1;
        } else if (this.qks == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.qkr[this.capacityHint] = objArr;
            this.qkr = objArr;
            this.qks = 1;
            this.size++;
        } else {
            this.qkr[this.qks] = obj;
            this.qks++;
            this.size++;
        }
    }

    public Object[] eLA() {
        return this.qkq;
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
        Object[] eLA = eLA();
        while (i4 < i2) {
            arrayList.add(eLA[i3]);
            i4++;
            int i5 = i3 + 1;
            if (i5 == i) {
                i3 = 0;
                eLA = eLA[i];
            } else {
                i3 = i5;
            }
        }
        return arrayList.toString();
    }
}
