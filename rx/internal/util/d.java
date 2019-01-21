package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    final int iQh;
    Object[] iQi;
    Object[] iQj;
    int iQk;
    volatile int size;

    public d(int i) {
        this.iQh = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            this.iQi = new Object[this.iQh + 1];
            this.iQj = this.iQi;
            this.iQi[0] = obj;
            this.iQk = 1;
            this.size = 1;
        } else if (this.iQk == this.iQh) {
            Object[] objArr = new Object[this.iQh + 1];
            objArr[0] = obj;
            this.iQj[this.iQh] = objArr;
            this.iQj = objArr;
            this.iQk = 1;
            this.size++;
        } else {
            this.iQj[this.iQk] = obj;
            this.iQk++;
            this.size++;
        }
    }

    public Object[] cfK() {
        return this.iQi;
    }

    public int size() {
        return this.size;
    }

    List<Object> cfL() {
        int i = this.iQh;
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
