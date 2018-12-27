package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    final int iOZ;
    Object[] iPa;
    Object[] iPb;
    int iPc;
    volatile int size;

    public d(int i) {
        this.iOZ = i;
    }

    public void add(Object obj) {
        if (this.size == 0) {
            this.iPa = new Object[this.iOZ + 1];
            this.iPb = this.iPa;
            this.iPa[0] = obj;
            this.iPc = 1;
            this.size = 1;
        } else if (this.iPc == this.iOZ) {
            Object[] objArr = new Object[this.iOZ + 1];
            objArr[0] = obj;
            this.iPb[this.iOZ] = objArr;
            this.iPb = objArr;
            this.iPc = 1;
            this.size++;
        } else {
            this.iPb[this.iPc] = obj;
            this.iPc++;
            this.size++;
        }
    }

    public Object[] cfc() {
        return this.iPa;
    }

    public int size() {
        return this.size;
    }

    List<Object> cfd() {
        int i = this.iOZ;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] cfc = cfc();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(cfc[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                cfc = (Object[]) cfc[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return cfd().toString();
    }
}
