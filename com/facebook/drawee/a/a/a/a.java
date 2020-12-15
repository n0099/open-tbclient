package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements b {
    private final List<b> pdK;

    public a(b... bVarArr) {
        this.pdK = new ArrayList(bVarArr.length);
        Collections.addAll(this.pdK, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.pdK.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.pdK.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.pdK.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.pdK.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
