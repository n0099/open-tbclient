package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class c {
    final int capacityHint;
    Object[] pIN;
    Object[] pIO;
    int pIP;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.pIN = new Object[this.capacityHint + 1];
            this.pIO = this.pIN;
            this.pIN[0] = obj;
            this.pIP = 1;
            this.size = 1;
        } else if (this.pIP == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.pIO[this.capacityHint] = objArr;
            this.pIO = objArr;
            this.pIP = 1;
            this.size++;
        } else {
            this.pIO[this.pIP] = obj;
            this.pIP++;
            this.size++;
        }
    }

    public Object[] eDs() {
        return this.pIN;
    }

    public int size() {
        return this.size;
    }

    List<Object> eFZ() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] eDs = eDs();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(eDs[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                eDs = (Object[]) eDs[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return eFZ().toString();
    }
}
