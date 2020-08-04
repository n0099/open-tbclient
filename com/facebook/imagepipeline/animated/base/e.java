package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b mYB;
    private int mYC;
    private com.facebook.common.references.a<Bitmap> mYD;
    private List<com.facebook.common.references.a<Bitmap>> mYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.mYB = bVar;
    }

    public b dFz() {
        return this.mYB;
    }

    public com.facebook.common.references.a<Bitmap> dFA() {
        return com.facebook.common.references.a.b(this.mYD);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.mYD = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dFB() {
        return this.mYC;
    }

    public e IX(int i) {
        this.mYC = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dFC() {
        return com.facebook.common.references.a.k(this.mYE);
    }

    public e fz(List<com.facebook.common.references.a<Bitmap>> list) {
        this.mYE = com.facebook.common.references.a.k(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dFD() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.mYD);
            this.mYD = null;
            com.facebook.common.references.a.b(this.mYE);
            this.mYE = null;
        }
    }
}
