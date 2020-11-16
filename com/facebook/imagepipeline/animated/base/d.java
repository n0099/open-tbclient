package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class d {
    private final b oUn;
    private final int oUo;
    @Nullable
    private com.facebook.common.references.a<Bitmap> oUp;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> oUq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.oUn = (b) g.checkNotNull(eVar.enb());
        this.oUo = eVar.ene();
        this.oUp = eVar.enc();
        this.oUq = eVar.enf();
    }

    private d(b bVar) {
        this.oUn = (b) g.checkNotNull(bVar);
        this.oUo = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b enb() {
        return this.oUn;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.oUp);
        this.oUp = null;
        com.facebook.common.references.a.b(this.oUq);
        this.oUq = null;
    }
}
