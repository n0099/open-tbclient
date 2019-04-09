package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kai;
    Object[] kaj;
    Object[] kak;
    int kal;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kaj = new Object[this.kai + 1];
            this.kak = this.kaj;
            this.kaj[0] = obj;
            this.kal = 1;
            this.size = 1;
        } else if (this.kal == this.kai) {
            Object[] objArr = new Object[this.kai + 1];
            objArr[0] = obj;
            this.kak[this.kai] = objArr;
            this.kak = objArr;
            this.kal = 1;
            this.size++;
        } else {
            this.kak[this.kal] = obj;
            this.kal++;
            this.size++;
        }
    }

    public Object[] cEp() {
        return this.kaj;
    }

    public int size() {
        return this.size;
    }

    List<Object> cEq() {
        int i = this.kai;
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
