package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public class c {
    final int capacityHint;
    Object[] qlY;
    Object[] qlZ;
    int qma;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.qlY = new Object[this.capacityHint + 1];
            this.qlZ = this.qlY;
            this.qlY[0] = obj;
            this.qma = 1;
            this.size = 1;
        } else if (this.qma == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.qlZ[this.capacityHint] = objArr;
            this.qlZ = objArr;
            this.qma = 1;
            this.size++;
        } else {
            this.qlZ[this.qma] = obj;
            this.qma++;
            this.size++;
        }
    }

    public Object[] eMe() {
        return this.qlY;
    }

    public int size() {
        return this.size;
    }

    List<Object> eOL() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        int i4 = 0;
        Object[] eMe = eMe();
        while (i4 < i2) {
            arrayList.add(eMe[i3]);
            i4++;
            int i5 = i3 + 1;
            if (i5 == i) {
                i3 = 0;
                eMe = eMe[i];
            } else {
                i3 = i5;
            }
        }
        return arrayList;
    }

    public String toString() {
        return eOL().toString();
    }
}
