package com.facebook.drawee.a.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes12.dex */
public class a implements b {
    private final List<b> lJy;

    public a(b... bVarArr) {
        this.lJy = new ArrayList(bVarArr.length);
        Collections.addAll(this.lJy, bVarArr);
    }

    public synchronized void a(b bVar) {
        this.lJy.add(bVar);
    }

    public synchronized void b(b bVar) {
        this.lJy.remove(bVar);
    }

    @Override // com.facebook.drawee.a.a.a.b
    public synchronized void h(String str, int i, boolean z) {
        int size = this.lJy.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.lJy.get(i2).h(str, i, z);
            } catch (Exception e) {
                com.facebook.common.c.a.e("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
            }
        }
    }
}
