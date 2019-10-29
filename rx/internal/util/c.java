package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kEg;
    Object[] kEh;
    Object[] kEi;
    int kEj;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kEh = new Object[this.kEg + 1];
            this.kEi = this.kEh;
            this.kEh[0] = obj;
            this.kEj = 1;
            this.size = 1;
        } else if (this.kEj == this.kEg) {
            Object[] objArr = new Object[this.kEg + 1];
            objArr[0] = obj;
            this.kEi[this.kEg] = objArr;
            this.kEi = objArr;
            this.kEj = 1;
            this.size++;
        } else {
            this.kEi[this.kEj] = obj;
            this.kEj++;
            this.size++;
        }
    }

    public Object[] cOX() {
        return this.kEh;
    }

    public int size() {
        return this.size;
    }

    List<Object> cOY() {
        int i = this.kEg;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cOX = cOX();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cOX[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cOX = (Object[]) cOX[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cOY().toString();
    }
}
