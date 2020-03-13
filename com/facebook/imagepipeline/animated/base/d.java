package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b lPT;
    private final int lPU;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lPV;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lPT = (b) g.checkNotNull(eVar.dnI());
        this.lPU = eVar.dnK();
        this.lPV = eVar.dnJ();
        this.lPW = eVar.dnL();
    }

    private d(b bVar) {
        this.lPT = (b) g.checkNotNull(bVar);
        this.lPU = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dnI() {
        return this.lPT;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.lPV);
        this.lPV = null;
        com.facebook.common.references.a.a(this.lPW);
        this.lPW = null;
    }
}
