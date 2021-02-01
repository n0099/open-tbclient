package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private final b pGi;
    private int pGj;
    private com.facebook.common.references.a<Bitmap> pGk;
    private List<com.facebook.common.references.a<Bitmap>> pGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pGi = bVar;
    }

    public b evx() {
        return this.pGi;
    }

    public com.facebook.common.references.a<Bitmap> evy() {
        return com.facebook.common.references.a.b(this.pGk);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pGk = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int evz() {
        return this.pGj;
    }

    public e Pz(int i) {
        this.pGj = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> evA() {
        return com.facebook.common.references.a.m(this.pGl);
    }

    public e gK(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pGl = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d evB() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pGk);
            this.pGk = null;
            com.facebook.common.references.a.b(this.pGl);
            this.pGl = null;
        }
    }
}
