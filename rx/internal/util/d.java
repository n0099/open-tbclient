package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    final int iLP;
    Object[] iLQ;
    Object[] iLR;
    int iLS;
    volatile int size;

    public d(int i) {
        this.iLP = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            this.iLQ = new Object[this.iLP + 1];
            this.iLR = this.iLQ;
            this.iLQ[0] = obj;
            this.iLS = 1;
            this.size = 1;
        } else if (this.iLS == this.iLP) {
            Object[] objArr = new Object[this.iLP + 1];
            objArr[0] = obj;
            this.iLR[this.iLP] = objArr;
            this.iLR = objArr;
            this.iLS = 1;
            this.size++;
        } else {
            this.iLR[this.iLS] = obj;
            this.iLS++;
            this.size++;
        }
    }

    public Object[] cem() {
        return this.iLQ;
    }

    public int size() {
        return this.size;
    }

    List<Object> cen() {
        int i = this.iLP;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cem = cem();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cem[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cem = (Object[]) cem[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cen().toString();
    }
}
