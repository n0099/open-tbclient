package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kaP;
    Object[] kaQ;
    Object[] kaR;
    int kaS;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kaQ = new Object[this.kaP + 1];
            this.kaR = this.kaQ;
            this.kaQ[0] = obj;
            this.kaS = 1;
            this.size = 1;
        } else if (this.kaS == this.kaP) {
            Object[] objArr = new Object[this.kaP + 1];
            objArr[0] = obj;
            this.kaR[this.kaP] = objArr;
            this.kaR = objArr;
            this.kaS = 1;
            this.size++;
        } else {
            this.kaR[this.kaS] = obj;
            this.kaS++;
            this.size++;
        }
    }

    public Object[] cEA() {
        return this.kaQ;
    }

    public int size() {
        return this.size;
    }

    List<Object> cEB() {
        int i = this.kaP;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cEA = cEA();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cEA[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cEA = (Object[]) cEA[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cEB().toString();
    }
}
