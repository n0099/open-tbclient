package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    final int capacityHint;
    Object[] qsD;
    Object[] qsE;
    int qsF;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.qsD = new Object[this.capacityHint + 1];
            this.qsE = this.qsD;
            this.qsD[0] = obj;
            this.qsF = 1;
            this.size = 1;
        } else if (this.qsF == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.qsE[this.capacityHint] = objArr;
            this.qsE = objArr;
            this.qsF = 1;
            this.size++;
        } else {
            this.qsE[this.qsF] = obj;
            this.qsF++;
            this.size++;
        }
    }

    public Object[] eKu() {
        return this.qsD;
    }

    public int size() {
        return this.size;
    }

    List<Object> eNb() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        int i4 = 0;
        Object[] eKu = eKu();
        while (i4 < i2) {
            arrayList.add(eKu[i3]);
            i4++;
            int i5 = i3 + 1;
            if (i5 == i) {
                i3 = 0;
                eKu = eKu[i];
            } else {
                i3 = i5;
            }
        }
        return arrayList;
    }

    public String toString() {
        return eNb().toString();
    }
}
