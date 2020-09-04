package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class d {
    private final b nsI;
    private final int nsJ;
    @Nullable
    private com.facebook.common.references.a<Bitmap> nsK;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> nsL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.nsI = (b) g.checkNotNull(eVar.dRH());
        this.nsJ = eVar.dRJ();
        this.nsK = eVar.dRI();
        this.nsL = eVar.dRK();
    }

    private d(b bVar) {
        this.nsI = (b) g.checkNotNull(bVar);
        this.nsJ = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dRH() {
        return this.nsI;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.nsK);
        this.nsK = null;
        com.facebook.common.references.a.b(this.nsL);
        this.nsL = null;
    }
}
