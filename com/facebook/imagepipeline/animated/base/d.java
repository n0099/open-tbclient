package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b mup;
    private final int muq;
    @Nullable
    private com.facebook.common.references.a<Bitmap> mur;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> mus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.mup = (b) g.checkNotNull(eVar.dxG());
        this.muq = eVar.dxI();
        this.mur = eVar.dxH();
        this.mus = eVar.dxJ();
    }

    private d(b bVar) {
        this.mup = (b) g.checkNotNull(bVar);
        this.muq = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dxG() {
        return this.mup;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.mur);
        this.mur = null;
        com.facebook.common.references.a.b(this.mus);
        this.mus = null;
    }
}
