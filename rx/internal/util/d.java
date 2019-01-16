package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    final int iQg;
    Object[] iQh;
    Object[] iQi;
    int iQj;
    volatile int size;

    public d(int i) {
        this.iQg = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            this.iQh = new Object[this.iQg + 1];
            this.iQi = this.iQh;
            this.iQh[0] = obj;
            this.iQj = 1;
            this.size = 1;
        } else if (this.iQj == this.iQg) {
            Object[] objArr = new Object[this.iQg + 1];
            objArr[0] = obj;
            this.iQi[this.iQg] = objArr;
            this.iQi = objArr;
            this.iQj = 1;
            this.size++;
        } else {
            this.iQi[this.iQj] = obj;
            this.iQj++;
            this.size++;
        }
    }

    public Object[] cfK() {
        return this.iQh;
    }

    public int size() {
        return this.size;
    }

    List<Object> cfL() {
        int i = this.iQg;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cfK = cfK();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cfK[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cfK = (Object[]) cfK[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cfL().toString();
    }
}
