package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements b {
    private final List<b> pqw;

    public a(b... bVarArr) {
        this.pqw = new ArrayList(bVarArr.length);
        Collections.addAll(this.pqw, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.pqw.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.pqw.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.pqw.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.pqw.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
