package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    final int capacityHint;
    Object[] pRX;
    Object[] pRY;
    int pRZ;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.pRX = new Object[this.capacityHint + 1];
            this.pRY = this.pRX;
            this.pRX[0] = obj;
            this.pRZ = 1;
            this.size = 1;
        } else if (this.pRZ == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.pRY[this.capacityHint] = objArr;
            this.pRY = objArr;
            this.pRZ = 1;
            this.size++;
        } else {
            this.pRY[this.pRZ] = obj;
            this.pRZ++;
            this.size++;
        }
    }

    public Object[] eBa() {
        return this.pRX;
    }

    public int size() {
        return this.size;
    }

    List<Object> eFZ() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] eBa = eBa();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(eBa[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                eBa = (Object[]) eBa[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return eFZ().toString();
    }
}
