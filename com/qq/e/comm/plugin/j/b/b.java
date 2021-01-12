package com.qq.e.comm.plugin.j.b;

import com.qq.e.comm.plugin.j.b.l;
/* loaded from: classes3.dex */
class b implements l {
    @Override // com.qq.e.comm.plugin.j.b.l
    public l.a[] a(long j, int i) {
        long j2 = j / i;
        l.a[] aVarArr = new l.a[i];
        for (int i2 = 0; i2 < i - 1; i2++) {
            aVarArr[i2] = new l.a(i2 * j2, j2);
        }
        aVarArr[i - 1] = new l.a((i - 1) * j2, j - (j2 * (i - 1)));
        return aVarArr;
    }
}
