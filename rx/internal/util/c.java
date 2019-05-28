package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    Object[] ksA;
    int ksB;
    final int ksy;
    Object[] ksz;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.ksz = new Object[this.ksy + 1];
            this.ksA = this.ksz;
            this.ksz[0] = obj;
            this.ksB = 1;
            this.size = 1;
        } else if (this.ksB == this.ksy) {
            Object[] objArr = new Object[this.ksy + 1];
            objArr[0] = obj;
            this.ksA[this.ksy] = objArr;
            this.ksA = objArr;
            this.ksB = 1;
            this.size++;
        } else {
            this.ksA[this.ksB] = obj;
            this.ksB++;
            this.size++;
        }
    }

    public Object[] cLX() {
        return this.ksz;
    }

    public int size() {
        return this.size;
    }

    List<Object> cLY() {
        int i = this.ksy;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cLX = cLX();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cLX[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cLX = (Object[]) cLX[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cLY().toString();
    }
}
