package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b lPI;
    private int lPJ;
    private com.facebook.common.references.a<Bitmap> lPK;
    private List<com.facebook.common.references.a<Bitmap>> lPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lPI = bVar;
    }

    public b dnH() {
        return this.lPI;
    }

    public com.facebook.common.references.a<Bitmap> dnI() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPK);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lPK = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        return this;
    }

    public int dnJ() {
        return this.lPJ;
    }

    public e Ia(int i) {
        this.lPJ = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dnK() {
        return com.facebook.common.references.a.i(this.lPL);
    }

    public e eU(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lPL = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dnL() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.lPK);
            this.lPK = null;
            com.facebook.common.references.a.a(this.lPL);
            this.lPL = null;
        }
    }
}
