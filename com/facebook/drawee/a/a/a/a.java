package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes13.dex */
public class a implements b {
    private final List<b> lKf;

    public a(b... bVarArr) {
        this.lKf = new ArrayList(bVarArr.length);
        Collections.addAll(this.lKf, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.lKf.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.lKf.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void h(String str, int i, boolean z) {
        int size = this.lKf.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.lKf.get(i2).h(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
