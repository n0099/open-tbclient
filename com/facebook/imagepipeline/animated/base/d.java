package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b lPG;
    private final int lPH;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lPI;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lPJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lPG = (b) g.checkNotNull(eVar.dnF());
        this.lPH = eVar.dnH();
        this.lPI = eVar.dnG();
        this.lPJ = eVar.dnI();
    }

    private d(b bVar) {
        this.lPG = (b) g.checkNotNull(bVar);
        this.lPH = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dnF() {
        return this.lPG;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.lPI);
        this.lPI = null;
        com.facebook.common.references.a.a(this.lPJ);
        this.lPJ = null;
    }
}
