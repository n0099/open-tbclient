package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int ksB;
    Object[] ksC;
    Object[] ksD;
    int ksE;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.ksC = new Object[this.ksB + 1];
            this.ksD = this.ksC;
            this.ksC[0] = obj;
            this.ksE = 1;
            this.size = 1;
        } else if (this.ksE == this.ksB) {
            Object[] objArr = new Object[this.ksB + 1];
            objArr[0] = obj;
            this.ksD[this.ksB] = objArr;
            this.ksD = objArr;
            this.ksE = 1;
            this.size++;
        } else {
            this.ksD[this.ksE] = obj;
            this.ksE++;
            this.size++;
        }
    }

    public Object[] cLW() {
        return this.ksC;
    }

    public int size() {
        return this.size;
    }

    List<Object> cLX() {
        int i = this.ksB;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cLW = cLW();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cLW[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cLW = (Object[]) cLW[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cLX().toString();
    }
}
