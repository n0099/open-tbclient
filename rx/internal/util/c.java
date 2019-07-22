package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kAa;
    Object[] kAb;
    Object[] kAc;
    int kAd;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kAb = new Object[this.kAa + 1];
            this.kAc = this.kAb;
            this.kAb[0] = obj;
            this.kAd = 1;
            this.size = 1;
        } else if (this.kAd == this.kAa) {
            Object[] objArr = new Object[this.kAa + 1];
            objArr[0] = obj;
            this.kAc[this.kAa] = objArr;
            this.kAc = objArr;
            this.kAd = 1;
            this.size++;
        } else {
            this.kAc[this.kAd] = obj;
            this.kAd++;
            this.size++;
        }
    }

    public Object[] cPL() {
        return this.kAb;
    }

    public int size() {
        return this.size;
    }

    List<Object> cPM() {
        int i = this.kAa;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cPL = cPL();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cPL[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cPL = (Object[]) cPL[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cPM().toString();
    }
}
