package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    final int capacityHint;
    Object[] qhx;
    Object[] qhy;
    int qhz;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.qhx = new Object[this.capacityHint + 1];
            this.qhy = this.qhx;
            this.qhx[0] = obj;
            this.qhz = 1;
            this.size = 1;
        } else if (this.qhz == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.qhy[this.capacityHint] = objArr;
            this.qhy = objArr;
            this.qhz = 1;
            this.size++;
        } else {
            this.qhy[this.qhz] = obj;
            this.qhz++;
            this.size++;
        }
    }

    public Object[] eIo() {
        return this.qhx;
    }

    public int size() {
        return this.size;
    }

    List<Object> eKV() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        int i4 = 0;
        Object[] eIo = eIo();
        while (i4 < i2) {
            arrayList.add(eIo[i3]);
            i4++;
            int i5 = i3 + 1;
            if (i5 == i) {
                i3 = 0;
                eIo = eIo[i];
            } else {
                i3 = i5;
            }
        }
        return arrayList;
    }

    public String toString() {
        return eKV().toString();
    }
}
