package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private int mYA;
    private com.facebook.common.references.a<Bitmap> mYB;
    private List<com.facebook.common.references.a<Bitmap>> mYC;
    private final b mYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.mYz = bVar;
    }

    public b dFy() {
        return this.mYz;
    }

    public com.facebook.common.references.a<Bitmap> dFz() {
        return com.facebook.common.references.a.b(this.mYB);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.mYB = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dFA() {
        return this.mYA;
    }

    public e IX(int i) {
        this.mYA = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dFB() {
        return com.facebook.common.references.a.k(this.mYC);
    }

    public e fz(List<com.facebook.common.references.a<Bitmap>> list) {
        this.mYC = com.facebook.common.references.a.k(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dFC() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.mYB);
            this.mYB = null;
            com.facebook.common.references.a.b(this.mYC);
            this.mYC = null;
        }
    }
}
