package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b lOU;
    private final int lOV;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lOW;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lOX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lOU = (b) g.checkNotNull(eVar.dmq());
        this.lOV = eVar.dms();
        this.lOW = eVar.dmr();
        this.lOX = eVar.dmt();
    }

    private d(b bVar) {
        this.lOU = (b) g.checkNotNull(bVar);
        this.lOV = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dmq() {
        return this.lOU;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.lOW);
        this.lOW = null;
        com.facebook.common.references.a.a(this.lOX);
        this.lOX = null;
    }
}
