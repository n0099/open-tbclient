package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final int lRA;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lRB;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lRC;
    private final b lRz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lRz = (b) g.checkNotNull(eVar.dof());
        this.lRA = eVar.doh();
        this.lRB = eVar.dog();
        this.lRC = eVar.doi();
    }

    private d(b bVar) {
        this.lRz = (b) g.checkNotNull(bVar);
        this.lRA = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dof() {
        return this.lRz;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.lRB);
        this.lRB = null;
        com.facebook.common.references.a.a(this.lRC);
        this.lRC = null;
    }
}
