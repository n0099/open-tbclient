package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.internal.g;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class d {
    private final b lLj;
    private final int lLk;
    @Nullable
    private com.facebook.common.references.a<Bitmap> lLl;
    @Nullable
    private List<com.facebook.common.references.a<Bitmap>> lLm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.lLj = (b) g.checkNotNull(eVar.dll());
        this.lLk = eVar.dln();
        this.lLl = eVar.dlm();
        this.lLm = eVar.dlo();
    }

    private d(b bVar) {
        this.lLj = (b) g.checkNotNull(bVar);
        this.lLk = 0;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static e b(b bVar) {
        return new e(bVar);
    }

    public b dll() {
        return this.lLj;
    }

    public synchronized void dispose() {
        com.facebook.common.references.a.c(this.lLl);
        this.lLl = null;
        com.facebook.common.references.a.a(this.lLm);
        this.lLm = null;
    }
}
