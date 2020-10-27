package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes18.dex */
public class a implements b {
    private final List<b> oDE;

    public a(b... bVarArr) {
        this.oDE = new ArrayList(bVarArr.length);
        Collections.addAll(this.oDE, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.oDE.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.oDE.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.oDE.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.oDE.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
