package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    final int iEI;
    Object[] iEJ;
    Object[] iEK;
    int iEL;
    volatile int size;

    public d(int i) {
        this.iEI = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            this.iEJ = new Object[this.iEI + 1];
            this.iEK = this.iEJ;
            this.iEJ[0] = obj;
            this.iEL = 1;
            this.size = 1;
        } else if (this.iEL == this.iEI) {
            Object[] objArr = new Object[this.iEI + 1];
            objArr[0] = obj;
            this.iEK[this.iEI] = objArr;
            this.iEK = objArr;
            this.iEL = 1;
            this.size++;
        } else {
            this.iEK[this.iEL] = obj;
            this.iEL++;
            this.size++;
        }
    }

    public Object[] ccj() {
        return this.iEJ;
    }

    public int size() {
        return this.size;
    }

    List<Object> cck() {
        int i = this.iEI;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] ccj = ccj();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(ccj[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                ccj = (Object[]) ccj[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cck().toString();
    }
}
