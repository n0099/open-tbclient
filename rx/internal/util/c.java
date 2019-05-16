package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    int ksA;
    final int ksx;
    Object[] ksy;
    Object[] ksz;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.ksy = new Object[this.ksx + 1];
            this.ksz = this.ksy;
            this.ksy[0] = obj;
            this.ksA = 1;
            this.size = 1;
        } else if (this.ksA == this.ksx) {
            Object[] objArr = new Object[this.ksx + 1];
            objArr[0] = obj;
            this.ksz[this.ksx] = objArr;
            this.ksz = objArr;
            this.ksA = 1;
            this.size++;
        } else {
            this.ksz[this.ksA] = obj;
            this.ksA++;
            this.size++;
        }
    }

    public Object[] cLV() {
        return this.ksy;
    }

    public int size() {
        return this.size;
    }

    List<Object> cLW() {
        int i = this.ksx;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cLV = cLV();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cLV[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cLV = (Object[]) cLV[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cLW().toString();
    }
}
