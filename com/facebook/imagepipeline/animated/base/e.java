package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes6.dex */
public class e {
    private final b nCG;
    private int nCH;
    private com.facebook.common.references.a<Bitmap> nCI;
    private List<com.facebook.common.references.a<Bitmap>> nCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.nCG = bVar;
    }

    public b dVF() {
        return this.nCG;
    }

    public com.facebook.common.references.a<Bitmap> dVG() {
        return com.facebook.common.references.a.b(this.nCI);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.nCI = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dVH() {
        return this.nCH;
    }

    public e Mg(int i) {
        this.nCH = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dVI() {
        return com.facebook.common.references.a.m(this.nCJ);
    }

    public e fS(List<com.facebook.common.references.a<Bitmap>> list) {
        this.nCJ = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dVJ() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.nCI);
            this.nCI = null;
            com.facebook.common.references.a.b(this.nCJ);
            this.nCJ = null;
        }
    }
}
