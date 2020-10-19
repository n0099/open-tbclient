package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b nRZ;
    private final int nSa;
    @Nullable
    private com.facebook.common.references.a<Bitmap> nSb;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> nSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.nRZ = (b) g.checkNotNull(eVar.dZq());
        this.nSa = eVar.dZs();
        this.nSb = eVar.dZr();
        this.nSc = eVar.dZt();
    }

    private d(b bVar) {
        this.nRZ = (b) g.checkNotNull(bVar);
        this.nSa = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dZq() {
        return this.nRZ;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.nSb);
        this.nSb = null;
        com.facebook.common.references.a.b(this.nSc);
        this.nSc = null;
    }
}
