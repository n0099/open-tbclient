package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b mQo;
    private final int mQp;
    @Nullable
    private com.facebook.common.references.a<Bitmap> mQq;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> mQr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.mQo = (b) g.checkNotNull(eVar.dCi());
        this.mQp = eVar.dCk();
        this.mQq = eVar.dCj();
        this.mQr = eVar.dCl();
    }

    private d(b bVar) {
        this.mQo = (b) g.checkNotNull(bVar);
        this.mQp = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dCi() {
        return this.mQo;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.mQq);
        this.mQq = null;
        com.facebook.common.references.a.b(this.mQr);
        this.mQr = null;
    }
}
