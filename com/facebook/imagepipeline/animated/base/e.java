package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private int lRA;
    private com.facebook.common.references.a<Bitmap> lRB;
    private List<com.facebook.common.references.a<Bitmap>> lRC;
    private final b lRz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lRz = bVar;
    }

    public b dof() {
        return this.lRz;
    }

    public com.facebook.common.references.a<Bitmap> dog() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lRB);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lRB = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        return this;
    }

    public int doh() {
        return this.lRA;
    }

    public e Ig(int i) {
        this.lRA = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> doi() {
        return com.facebook.common.references.a.i(this.lRC);
    }

    public e eU(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lRC = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d doj() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.lRB);
            this.lRB = null;
            com.facebook.common.references.a.a(this.lRC);
            this.lRC = null;
        }
    }
}
