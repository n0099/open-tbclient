package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class d {
    private final b oSK;
    private final int oSL;
    @Nullable
    private com.facebook.common.references.a<Bitmap> oSM;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> oSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.oSK = (b) g.checkNotNull(eVar.ene());
        this.oSL = eVar.eng();
        this.oSM = eVar.enf();
        this.oSN = eVar.enh();
    }

    private d(b bVar) {
        this.oSK = (b) g.checkNotNull(bVar);
        this.oSL = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b ene() {
        return this.oSK;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.oSM);
        this.oSM = null;
        com.facebook.common.references.a.b(this.oSN);
        this.oSN = null;
    }
}
