package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kDp;
    Object[] kDq;
    Object[] kDr;
    int kDs;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kDq = new Object[this.kDp + 1];
            this.kDr = this.kDq;
            this.kDq[0] = obj;
            this.kDs = 1;
            this.size = 1;
        } else if (this.kDs == this.kDp) {
            Object[] objArr = new Object[this.kDp + 1];
            objArr[0] = obj;
            this.kDr[this.kDp] = objArr;
            this.kDr = objArr;
            this.kDs = 1;
            this.size++;
        } else {
            this.kDr[this.kDs] = obj;
            this.kDs++;
            this.size++;
        }
    }

    public Object[] cOV() {
        return this.kDq;
    }

    public int size() {
        return this.size;
    }

    List<Object> cOW() {
        int i = this.kDp;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cOV = cOV();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cOV[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cOV = (Object[]) cOV[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cOW().toString();
    }
}
