package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private final b pGI;
    private int pGJ;
    private com.facebook.common.references.a<Bitmap> pGK;
    private List<com.facebook.common.references.a<Bitmap>> pGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pGI = bVar;
    }

    public b evF() {
        return this.pGI;
    }

    public com.facebook.common.references.a<Bitmap> evG() {
        return com.facebook.common.references.a.b(this.pGK);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pGK = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int evH() {
        return this.pGJ;
    }

    public e PA(int i) {
        this.pGJ = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> evI() {
        return com.facebook.common.references.a.m(this.pGL);
    }

    public e gK(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pGL = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d evJ() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pGK);
            this.pGK = null;
            com.facebook.common.references.a.b(this.pGL);
            this.pGL = null;
        }
    }
}
