package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class d {
    private final b pAA;
    private final int pAB;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pAC;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pAA = (b) g.checkNotNull(eVar.ewX());
        this.pAB = eVar.ewZ();
        this.pAC = eVar.ewY();
        this.pAD = eVar.exa();
    }

    private d(b bVar) {
        this.pAA = (b) g.checkNotNull(bVar);
        this.pAB = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b ewX() {
        return this.pAA;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pAC);
        this.pAC = null;
        com.facebook.common.references.a.b(this.pAD);
        this.pAD = null;
    }
}
