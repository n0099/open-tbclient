package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class d {
    private final b lZg;
    private final int lZh;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lZi;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lZg = (b) g.checkNotNull(eVar.dqc());
        this.lZh = eVar.dqe();
        this.lZi = eVar.dqd();
        this.lZj = eVar.dqf();
    }

    private d(b bVar) {
        this.lZg = (b) g.checkNotNull(bVar);
        this.lZh = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dqc() {
        return this.lZg;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lZi);
        this.lZi = null;
        com.facebook.common.references.a.a(this.lZj);
        this.lZj = null;
    }
}
