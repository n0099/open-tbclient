package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kBg;
    Object[] kBh;
    Object[] kBi;
    int kBj;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kBh = new Object[this.kBg + 1];
            this.kBi = this.kBh;
            this.kBh[0] = obj;
            this.kBj = 1;
            this.size = 1;
        } else if (this.kBj == this.kBg) {
            Object[] objArr = new Object[this.kBg + 1];
            objArr[0] = obj;
            this.kBi[this.kBg] = objArr;
            this.kBi = objArr;
            this.kBj = 1;
            this.size++;
        } else {
            this.kBi[this.kBj] = obj;
            this.kBj++;
            this.size++;
        }
    }

    public Object[] cQg() {
        return this.kBh;
    }

    public int size() {
        return this.size;
    }

    List<Object> cQh() {
        int i = this.kBg;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cQg = cQg();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cQg[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cQg = (Object[]) cQg[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cQh().toString();
    }
}
