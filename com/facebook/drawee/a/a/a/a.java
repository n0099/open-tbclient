package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes13.dex */
public class a implements b {
    private final List<b> lKs;

    public a(b... bVarArr) {
        this.lKs = new ArrayList(bVarArr.length);
        Collections.addAll(this.lKs, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.lKs.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.lKs.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void h(String str, int i, boolean z) {
        int size = this.lKs.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.lKs.get(i2).h(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
