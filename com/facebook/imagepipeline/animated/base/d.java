package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b lOZ;
    private final int lPa;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lPb;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lPc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lOZ = (b) g.checkNotNull(eVar.dms());
        this.lPa = eVar.dmu();
        this.lPb = eVar.dmt();
        this.lPc = eVar.dmv();
    }

    private d(b bVar) {
        this.lOZ = (b) g.checkNotNull(bVar);
        this.lPa = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dms() {
        return this.lOZ;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.lPb);
        this.lPb = null;
        com.facebook.common.references.a.a(this.lPc);
        this.lPc = null;
    }
}
