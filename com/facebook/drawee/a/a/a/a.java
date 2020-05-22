package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes13.dex */
public class a implements b {
    private final List<b> mno;

    public a(b... bVarArr) {
        this.mno = new ArrayList(bVarArr.length);
        Collections.addAll(this.mno, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.mno.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.mno.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.mno.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mno.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
