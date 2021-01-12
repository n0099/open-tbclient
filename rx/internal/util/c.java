package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    final int capacityHint;
    Object[] qhw;
    Object[] qhx;
    int qhy;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.qhw = new Object[this.capacityHint + 1];
            this.qhx = this.qhw;
            this.qhw[0] = obj;
            this.qhy = 1;
            this.size = 1;
        } else if (this.qhy == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.qhx[this.capacityHint] = objArr;
            this.qhx = objArr;
            this.qhy = 1;
            this.size++;
        } else {
            this.qhx[this.qhy] = obj;
            this.qhy++;
            this.size++;
        }
    }

    public Object[] eIo() {
        return this.qhw;
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
