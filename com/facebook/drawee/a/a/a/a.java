package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements b {
    private final List<b> mSG;

    public a(b... bVarArr) {
        this.mSG = new ArrayList(bVarArr.length);
        Collections.addAll(this.mSG, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.mSG.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.mSG.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void g(String str, int i, boolean z) {
        int size = this.mSG.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mSG.get(i2).g(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
