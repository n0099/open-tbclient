package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b lPI;
    private final int lPJ;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lPK;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lPI = (b) g.checkNotNull(eVar.dnH());
        this.lPJ = eVar.dnJ();
        this.lPK = eVar.dnI();
        this.lPL = eVar.dnK();
    }

    private d(b bVar) {
        this.lPI = (b) g.checkNotNull(bVar);
        this.lPJ = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dnH() {
        return this.lPI;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.lPK);
        this.lPK = null;
        com.facebook.common.references.a.a(this.lPL);
        this.lPL = null;
    }
}
