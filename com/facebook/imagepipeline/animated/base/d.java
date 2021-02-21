package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class d {
    private final b pGI;
    private final int pGJ;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pGK;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pGI = (b) g.checkNotNull(eVar.evF());
        this.pGJ = eVar.evH();
        this.pGK = eVar.evG();
        this.pGL = eVar.evI();
    }

    private d(b bVar) {
        this.pGI = (b) g.checkNotNull(bVar);
        this.pGJ = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b evF() {
        return this.pGI;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pGK);
        this.pGK = null;
        com.facebook.common.references.a.b(this.pGL);
        this.pGL = null;
    }
}
