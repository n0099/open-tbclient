package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class d {
    private final b pIN;
    private final int pIO;
    @Nullable
    private com.facebook.common.references.a<Bitmap> pIP;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> pIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.pIN = (b) g.checkNotNull(eVar.evO());
        this.pIO = eVar.evQ();
        this.pIP = eVar.evP();
        this.pIQ = eVar.evR();
    }

    private d(b bVar) {
        this.pIN = (b) g.checkNotNull(bVar);
        this.pIO = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b evO() {
        return this.pIN;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.pIP);
        this.pIP = null;
        com.facebook.common.references.a.b(this.pIQ);
        this.pIQ = null;
    }
}
