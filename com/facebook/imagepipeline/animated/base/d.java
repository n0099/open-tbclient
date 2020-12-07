package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b pjm;
    private final int pjn;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pjo;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pjm = (b) g.checkNotNull(eVar.esM());
        this.pjn = eVar.esO();
        this.pjo = eVar.esN();
        this.pjp = eVar.esP();
    }

    private d(b bVar) {
        this.pjm = (b) g.checkNotNull(bVar);
        this.pjn = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b esM() {
        return this.pjm;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pjo);
        this.pjo = null;
        com.facebook.common.references.a.b(this.pjp);
        this.pjp = null;
    }
}
