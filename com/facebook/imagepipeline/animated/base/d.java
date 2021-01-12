package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class d {
    private final b pvZ;
    private final int pwa;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pwb;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pvZ = (b) g.checkNotNull(eVar.etf());
        this.pwa = eVar.eth();
        this.pwb = eVar.etg();
        this.pwc = eVar.eti();
    }

    private d(b bVar) {
        this.pvZ = (b) g.checkNotNull(bVar);
        this.pwa = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b etf() {
        return this.pvZ;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pwb);
        this.pwb = null;
        com.facebook.common.references.a.b(this.pwc);
        this.pwc = null;
    }
}
