package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    final int capacityHint;
    Object[] mVD;
    Object[] mVE;
    int mVF;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.mVD = new Object[this.capacityHint + 1];
            this.mVE = this.mVD;
            this.mVD[0] = obj;
            this.mVF = 1;
            this.size = 1;
        } else if (this.mVF == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.mVE[this.capacityHint] = objArr;
            this.mVE = objArr;
            this.mVF = 1;
            this.size++;
        } else {
            this.mVE[this.mVF] = obj;
            this.mVF++;
            this.size++;
        }
    }

    public Object[] dDc() {
        return this.mVD;
    }

    public int size() {
        return this.size;
    }

    List<Object> dIa() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] dDc = dDc();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(dDc[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                dDc = (Object[]) dDc[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return dIa().toString();
    }
}
