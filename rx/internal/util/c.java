package rx.internal.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    final int capacityHint;
    Object[] oqo;
    Object[] oqp;
    int oqq;
    volatile int size;

    public void add(Object obj) {
        if (this.size == 0) {
            this.oqo = new Object[this.capacityHint + 1];
            this.oqp = this.oqo;
            this.oqo[0] = obj;
            this.oqq = 1;
            this.size = 1;
        } else if (this.oqq == this.capacityHint) {
            Object[] objArr = new Object[this.capacityHint + 1];
            objArr[0] = obj;
            this.oqp[this.capacityHint] = objArr;
            this.oqp = objArr;
            this.oqq = 1;
            this.size++;
        } else {
            this.oqp[this.oqq] = obj;
            this.oqq++;
            this.size++;
        }
    }

    public Object[] eft() {
        return this.oqo;
    }

    public int size() {
        return this.size;
    }

    List<Object> ekt() {
        int i = this.capacityHint;
        int i2 = this.size;
        ArrayList arrayList = new ArrayList(i2 + 1);
        int i3 = 0;
        Object[] eft = eft();
        int i4 = 0;
        while (i3 < i2) {
            arrayList.add(eft[i4]);
            i3++;
            i4++;
            if (i4 == i) {
                eft = (Object[]) eft[i];
                i4 = 0;
            }
        }
        return arrayList;
    }

    public String toString() {
        return ekt().toString();
    }
}
