package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class d {
    private final b nCG;
    private final int nCH;
    @Nullable
    private com.facebook.common.references.a<Bitmap> nCI;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> nCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.nCG = (b) g.checkNotNull(eVar.dVF());
        this.nCH = eVar.dVH();
        this.nCI = eVar.dVG();
        this.nCJ = eVar.dVI();
    }

    private d(b bVar) {
        this.nCG = (b) g.checkNotNull(bVar);
        this.nCH = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dVF() {
        return this.nCG;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.nCI);
        this.nCI = null;
        com.facebook.common.references.a.b(this.nCJ);
        this.nCJ = null;
    }
}
