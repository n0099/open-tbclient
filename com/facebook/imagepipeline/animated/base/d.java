package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b oJr;
    private final int oJs;
    @Nullable
    private com.facebook.common.references.a<Bitmap> oJt;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> oJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.oJr = (b) g.checkNotNull(eVar.ejo());
        this.oJs = eVar.ejq();
        this.oJt = eVar.ejp();
        this.oJu = eVar.ejr();
    }

    private d(b bVar) {
        this.oJr = (b) g.checkNotNull(bVar);
        this.oJs = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b ejo() {
        return this.oJr;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.oJt);
        this.oJt = null;
        com.facebook.common.references.a.b(this.oJu);
        this.oJu = null;
    }
}
