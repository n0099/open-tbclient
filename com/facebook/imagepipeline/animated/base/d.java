package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class d {
    private final b pwa;
    private final int pwb;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pwc;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pwa = (b) g.checkNotNull(eVar.etf());
        this.pwb = eVar.eth();
        this.pwc = eVar.etg();
        this.pwd = eVar.eti();
    }

    private d(b bVar) {
        this.pwa = (b) g.checkNotNull(bVar);
        this.pwb = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b etf() {
        return this.pwa;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pwc);
        this.pwc = null;
        com.facebook.common.references.a.b(this.pwd);
        this.pwd = null;
    }
}
