package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements b {
    private final List<b> nmA;

    public a(b... bVarArr) {
        this.nmA = new ArrayList(bVarArr.length);
        Collections.addAll(this.nmA, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.nmA.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.nmA.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.nmA.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.nmA.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
