package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b lPT;
    private int lPU;
    private com.facebook.common.references.a<Bitmap> lPV;
    private List<com.facebook.common.references.a<Bitmap>> lPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lPT = bVar;
    }

    public b dnI() {
        return this.lPT;
    }

    public com.facebook.common.references.a<Bitmap> dnJ() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPV);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lPV = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        return this;
    }

    public int dnK() {
        return this.lPU;
    }

    public e Ia(int i) {
        this.lPU = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dnL() {
        return com.facebook.common.references.a.i(this.lPW);
    }

    public e eU(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lPW = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dnM() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.lPV);
            this.lPV = null;
            com.facebook.common.references.a.a(this.lPW);
            this.lPW = null;
        }
    }
}
