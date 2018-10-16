package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    final int iCX;
    Object[] iCY;
    Object[] iCZ;
    int iDa;
    volatile int size;

    public d(int i) {
        this.iCX = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            this.iCY = new Object[this.iCX + 1];
            this.iCZ = this.iCY;
            this.iCY[0] = obj;
            this.iDa = 1;
            this.size = 1;
        } else if (this.iDa == this.iCX) {
            Object[] objArr = new Object[this.iCX + 1];
            objArr[0] = obj;
            this.iCZ[this.iCX] = objArr;
            this.iCZ = objArr;
            this.iDa = 1;
            this.size++;
        } else {
            this.iCZ[this.iDa] = obj;
            this.iDa++;
            this.size++;
        }
    }

    public Object[] ccM() {
        return this.iCY;
    }

    public int size() {
        return this.size;
    }

    List<Object> ccN() {
        int i = this.iCX;
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
