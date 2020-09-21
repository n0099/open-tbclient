package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes15.dex */
public class a implements b {
    private final List<b> nwS;

    public a(b... bVarArr) {
        this.nwS = new ArrayList(bVarArr.length);
        Collections.addAll(this.nwS, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.nwS.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.nwS.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.nwS.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.nwS.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
