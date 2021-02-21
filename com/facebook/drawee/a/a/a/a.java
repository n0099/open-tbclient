package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes15.dex */
public class a implements b {
    private final List<b> pBf;

    public a(b... bVarArr) {
        this.pBf = new ArrayList(bVarArr.length);
        Collections.addAll(this.pBf, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.pBf.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.pBf.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.pBf.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.pBf.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
