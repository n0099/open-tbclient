package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes15.dex */
public class a implements b {
    private final List<b> pAF;

    public a(b... bVarArr) {
        this.pAF = new ArrayList(bVarArr.length);
        Collections.addAll(this.pAF, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.pAF.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.pAF.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.pAF.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.pAF.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
