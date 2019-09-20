package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    Object[] kDA;
    int kDB;
    final int kDy;
    Object[] kDz;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kDz = new Object[this.kDy + 1];
            this.kDA = this.kDz;
            this.kDz[0] = obj;
            this.kDB = 1;
            this.size = 1;
        } else if (this.kDB == this.kDy) {
            Object[] objArr = new Object[this.kDy + 1];
            objArr[0] = obj;
            this.kDA[this.kDy] = objArr;
            this.kDA = objArr;
            this.kDB = 1;
            this.size++;
        } else {
            this.kDA[this.kDB] = obj;
            this.kDB++;
            this.size++;
        }
    }

    public Object[] cQS() {
        return this.kDz;
    }

    public int size() {
        return this.size;
    }

    List<Object> cQT() {
        int i = this.kDy;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cQS = cQS();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cQS[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cQS = (Object[]) cQS[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cQT().toString();
    }
}
