package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final int mYA;
    @Nullable
    private com.facebook.common.references.a<Bitmap> mYB;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> mYC;
    private final b mYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.mYz = (b) g.checkNotNull(eVar.dFy());
        this.mYA = eVar.dFA();
        this.mYB = eVar.dFz();
        this.mYC = eVar.dFB();
    }

    private d(b bVar) {
        this.mYz = (b) g.checkNotNull(bVar);
        this.mYA = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dFy() {
        return this.mYz;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.mYB);
        this.mYB = null;
        com.facebook.common.references.a.b(this.mYC);
        this.mYC = null;
    }
}
