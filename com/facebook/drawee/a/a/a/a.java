package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements b {
    private final List<b> puQ;

    public a(b... bVarArr) {
        this.puQ = new ArrayList(bVarArr.length);
        Collections.addAll(this.puQ, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.puQ.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.puQ.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.puQ.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.puQ.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
