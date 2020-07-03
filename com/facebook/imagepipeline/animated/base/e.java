package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b mQo;
    private int mQp;
    private com.facebook.common.references.a<Bitmap> mQq;
    private List<com.facebook.common.references.a<Bitmap>> mQr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.mQo = bVar;
    }

    public b dCi() {
        return this.mQo;
    }

    public com.facebook.common.references.a<Bitmap> dCj() {
        return com.facebook.common.references.a.b(this.mQq);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.mQq = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dCk() {
        return this.mQp;
    }

    public e IC(int i) {
        this.mQp = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dCl() {
        return com.facebook.common.references.a.k(this.mQr);
    }

    public e fq(List<com.facebook.common.references.a<Bitmap>> list) {
        this.mQr = com.facebook.common.references.a.k(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dCm() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.mQq);
            this.mQq = null;
            com.facebook.common.references.a.b(this.mQr);
            this.mQr = null;
        }
    }
}
