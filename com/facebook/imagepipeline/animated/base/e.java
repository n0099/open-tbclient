package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b lPG;
    private int lPH;
    private com.facebook.common.references.a<Bitmap> lPI;
    private List<com.facebook.common.references.a<Bitmap>> lPJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lPG = bVar;
    }

    public b dnF() {
        return this.lPG;
    }

    public com.facebook.common.references.a<Bitmap> dnG() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPI);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lPI = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        return this;
    }

    public int dnH() {
        return this.lPH;
    }

    public e Ia(int i) {
        this.lPH = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dnI() {
        return com.facebook.common.references.a.i(this.lPJ);
    }

    public e eU(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lPJ = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dnJ() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.lPI);
            this.lPI = null;
            com.facebook.common.references.a.a(this.lPJ);
            this.lPJ = null;
        }
    }
}
