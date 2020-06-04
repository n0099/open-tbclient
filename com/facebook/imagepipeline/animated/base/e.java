package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b mup;
    private int muq;
    private com.facebook.common.references.a<Bitmap> mur;
    private List<com.facebook.common.references.a<Bitmap>> mus;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.mup = bVar;
    }

    public b dxG() {
        return this.mup;
    }

    public com.facebook.common.references.a<Bitmap> dxH() {
        return com.facebook.common.references.a.b(this.mur);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.mur = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dxI() {
        return this.muq;
    }

    public e Hv(int i) {
        this.muq = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dxJ() {
        return com.facebook.common.references.a.k(this.mus);
    }

    public e fe(List<com.facebook.common.references.a<Bitmap>> list) {
        this.mus = com.facebook.common.references.a.k(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dxK() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.mur);
            this.mur = null;
            com.facebook.common.references.a.b(this.mus);
            this.mus = null;
        }
    }
}
