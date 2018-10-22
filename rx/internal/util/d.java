package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    final int iCY;
    Object[] iCZ;
    Object[] iDa;
    int iDb;
    volatile int size;

    public d(int i) {
        this.iCY = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            this.iCZ = new Object[this.iCY + 1];
            this.iDa = this.iCZ;
            this.iCZ[0] = obj;
            this.iDb = 1;
            this.size = 1;
        } else if (this.iDb == this.iCY) {
            Object[] objArr = new Object[this.iCY + 1];
            objArr[0] = obj;
            this.iDa[this.iCY] = objArr;
            this.iDa = objArr;
            this.iDb = 1;
            this.size++;
        } else {
            this.iDa[this.iDb] = obj;
            this.iDb++;
            this.size++;
        }
    }

    public Object[] ccM() {
        return this.iCZ;
    }

    public int size() {
        return this.size;
    }

    List<Object> ccN() {
        int i = this.iCY;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] ccM = ccM();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(ccM[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                ccM = (Object[]) ccM[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return ccN().toString();
    }
}
