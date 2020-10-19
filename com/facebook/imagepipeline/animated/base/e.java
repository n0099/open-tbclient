package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b nRZ;
    private int nSa;
    private com.facebook.common.references.a<Bitmap> nSb;
    private List<com.facebook.common.references.a<Bitmap>> nSc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.nRZ = bVar;
    }

    public b dZq() {
        return this.nRZ;
    }

    public com.facebook.common.references.a<Bitmap> dZr() {
        return com.facebook.common.references.a.b(this.nSb);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.nSb = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dZs() {
        return this.nSa;
    }

    public e MM(int i) {
        this.nSa = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dZt() {
        return com.facebook.common.references.a.m(this.nSc);
    }

    public e fV(List<com.facebook.common.references.a<Bitmap>> list) {
        this.nSc = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dZu() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.nSb);
            this.nSb = null;
            com.facebook.common.references.a.b(this.nSc);
            this.nSc = null;
        }
    }
}
