package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b lZk;
    private final int lZl;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lZm;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lZk = (b) g.checkNotNull(eVar.dpZ());
        this.lZl = eVar.dqb();
        this.lZm = eVar.dqa();
        this.lZn = eVar.dqc();
    }

    private d(b bVar) {
        this.lZk = (b) g.checkNotNull(bVar);
        this.lZl = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dpZ() {
        return this.lZk;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lZm);
        this.lZm = null;
        com.facebook.common.references.a.b(this.lZn);
        this.lZn = null;
    }
}
