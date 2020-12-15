package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b pjo;
    private final int pjp;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pjq;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pjr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pjo = (b) g.checkNotNull(eVar.esN());
        this.pjp = eVar.esP();
        this.pjq = eVar.esO();
        this.pjr = eVar.esQ();
    }

    private d(b bVar) {
        this.pjo = (b) g.checkNotNull(bVar);
        this.pjp = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b esN() {
        return this.pjo;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pjq);
        this.pjq = null;
        com.facebook.common.references.a.b(this.pjr);
        this.pjr = null;
    }
}
