package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b mQr;
    private int mQs;
    private com.facebook.common.references.a<Bitmap> mQt;
    private List<com.facebook.common.references.a<Bitmap>> mQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.mQr = bVar;
    }

    public b dCm() {
        return this.mQr;
    }

    public com.facebook.common.references.a<Bitmap> dCn() {
        return com.facebook.common.references.a.b(this.mQt);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.mQt = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dCo() {
        return this.mQs;
    }

    public e IC(int i) {
        this.mQs = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dCp() {
        return com.facebook.common.references.a.k(this.mQu);
    }

    public e fq(List<com.facebook.common.references.a<Bitmap>> list) {
        this.mQu = com.facebook.common.references.a.k(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dCq() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.mQt);
            this.mQt = null;
            com.facebook.common.references.a.b(this.mQu);
            this.mQu = null;
        }
    }
}
