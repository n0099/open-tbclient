package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class d {
    private final b pGi;
    private final int pGj;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pGk;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pGi = (b) g.checkNotNull(eVar.evx());
        this.pGj = eVar.evz();
        this.pGk = eVar.evy();
        this.pGl = eVar.evA();
    }

    private d(b bVar) {
        this.pGi = (b) g.checkNotNull(bVar);
        this.pGj = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b evx() {
        return this.pGi;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pGk);
        this.pGk = null;
        com.facebook.common.references.a.b(this.pGl);
        this.pGl = null;
    }
}
