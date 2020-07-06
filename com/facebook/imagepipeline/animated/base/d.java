package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b mQr;
    private final int mQs;
    @Nullable
    private com.facebook.common.references.a<Bitmap> mQt;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> mQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.mQr = (b) g.checkNotNull(eVar.dCm());
        this.mQs = eVar.dCo();
        this.mQt = eVar.dCn();
        this.mQu = eVar.dCp();
    }

    private d(b bVar) {
        this.mQr = (b) g.checkNotNull(bVar);
        this.mQs = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dCm() {
        return this.mQr;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.mQt);
        this.mQt = null;
        com.facebook.common.references.a.b(this.mQu);
        this.mQu = null;
    }
}
