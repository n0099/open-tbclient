package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class d {
    private final b nsq;
    private final int nsr;
    @Nullable
    private com.facebook.common.references.a<Bitmap> nss;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> nst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.nsq = (b) g.checkNotNull(eVar.dRy());
        this.nsr = eVar.dRA();
        this.nss = eVar.dRz();
        this.nst = eVar.dRB();
    }

    private d(b bVar) {
        this.nsq = (b) g.checkNotNull(bVar);
        this.nsr = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dRy() {
        return this.nsq;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.nss);
        this.nss = null;
        com.facebook.common.references.a.b(this.nst);
        this.nst = null;
    }
}
