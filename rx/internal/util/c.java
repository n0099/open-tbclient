package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    final int kaE;
    Object[] kaF;
    Object[] kaG;
    int kaH;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.kaF = new Object[this.kaE + 1];
            this.kaG = this.kaF;
            this.kaF[0] = obj;
            this.kaH = 1;
            this.size = 1;
        } else if (this.kaH == this.kaE) {
            Object[] objArr = new Object[this.kaE + 1];
            objArr[0] = obj;
            this.kaG[this.kaE] = objArr;
            this.kaG = objArr;
            this.kaH = 1;
            this.size++;
        } else {
            this.kaG[this.kaH] = obj;
            this.kaH++;
            this.size++;
        }
    }

    public Object[] cEn() {
        return this.kaF;
    }

    public int size() {
        return this.size;
    }

    List<Object> cEo() {
        int i = this.kaE;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cEn = cEn();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cEn[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cEn = (Object[]) cEn[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cEo().toString();
    }
}
