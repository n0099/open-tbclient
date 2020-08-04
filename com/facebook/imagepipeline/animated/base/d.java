package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b mYB;
    private final int mYC;
    @Nullable
    private com.facebook.common.references.a<Bitmap> mYD;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> mYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.mYB = (b) g.checkNotNull(eVar.dFz());
        this.mYC = eVar.dFB();
        this.mYD = eVar.dFA();
        this.mYE = eVar.dFC();
    }

    private d(b bVar) {
        this.mYB = (b) g.checkNotNull(bVar);
        this.mYC = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dFz() {
        return this.mYB;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.mYD);
        this.mYD = null;
        com.facebook.common.references.a.b(this.mYE);
        this.mYE = null;
    }
}
