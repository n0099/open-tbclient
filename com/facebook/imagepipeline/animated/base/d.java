package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b mtf;
    private final int mtg;
    @Nullable
    private com.facebook.common.references.a<Bitmap> mth;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> mti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.mtf = (b) g.checkNotNull(eVar.dxs());
        this.mtg = eVar.dxu();
        this.mth = eVar.dxt();
        this.mti = eVar.dxv();
    }

    private d(b bVar) {
        this.mtf = (b) g.checkNotNull(bVar);
        this.mtg = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dxs() {
        return this.mtf;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.mth);
        this.mth = null;
        com.facebook.common.references.a.b(this.mti);
        this.mti = null;
    }
}
