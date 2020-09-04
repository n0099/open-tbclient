package io.reactivex.internal.util;

import java.util.ArrayList;
/* loaded from: classes7.dex */
public class f {
    final int capacityHint;
    Object[] oqG;
    Object[] oqH;
    int oqI;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.oqG = new Object[this.capacityHint + 1];
            this.oqH = this.oqG;
            this.oqG[0] = obj;
            this.oqI = 1;
            this.size = 1;
        } else if (this.oqI == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.oqH[this.capacityHint] = objArr;
            this.oqH = objArr;
            this.oqI = 1;
            this.size++;
        } else {
            this.oqH[this.oqI] = obj;
            this.oqI++;
            this.size++;
        }
    }

    public Object[] efC() {
        return this.oqG;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] efC = efC();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(efC[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                efC = (Object[]) efC[i];
                i4 = 0;
            }
        }
        return arrayList.toString();
    }
}
