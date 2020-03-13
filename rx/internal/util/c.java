package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] nAm;
    Object[] nAn;
    int nAo;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.nAm = new Object[this.capacityHint + 1];
            this.nAn = this.nAm;
            this.nAm[0] = obj;
            this.nAo = 1;
            this.size = 1;
        } else if (this.nAo == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.nAn[this.capacityHint] = objArr;
            this.nAn = objArr;
            this.nAo = 1;
            this.size++;
        } else {
            this.nAn[this.nAo] = obj;
            this.nAo++;
            this.size++;
        }
    }

    public Object[] dJG() {
        return this.nAm;
    }

    public int size() {
        return this.size;
    }

    List<Object> dOD() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dJG = dJG();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dJG[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dJG = (Object[]) dJG[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dOD().toString();
    }
}
