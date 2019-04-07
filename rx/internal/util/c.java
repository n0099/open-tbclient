package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kah;
    Object[] kai;
    Object[] kaj;
    int kak;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kai = new Object[this.kah + 1];
            this.kaj = this.kai;
            this.kai[0] = obj;
            this.kak = 1;
            this.size = 1;
        } else if (this.kak == this.kah) {
            Object[] objArr = new Object[this.kah + 1];
            objArr[0] = obj;
            this.kaj[this.kah] = objArr;
            this.kaj = objArr;
            this.kak = 1;
            this.size++;
        } else {
            this.kaj[this.kak] = obj;
            this.kak++;
            this.size++;
        }
    }

    public Object[] cEp() {
        return this.kai;
    }

    public int size() {
        return this.size;
    }

    List<Object> cEq() {
        int i = this.kah;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cEp = cEp();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cEp[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cEp = (Object[]) cEp[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cEq().toString();
    }
}
