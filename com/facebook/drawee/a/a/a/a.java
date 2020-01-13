package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public class a implements b {
    private final List<b> lJt;

    public a(b... bVarArr) {
        this.lJt = new ArrayList(bVarArr.length);
        Collections.addAll(this.lJt, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.lJt.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.lJt.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void h(String str, int i, boolean z) {
        int size = this.lJt.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.lJt.get(i2).h(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
