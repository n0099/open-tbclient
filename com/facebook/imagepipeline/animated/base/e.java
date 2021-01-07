package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    private final b pAA;
    private int pAB;
    private com.facebook.common.references.a<Bitmap> pAC;
    private List<com.facebook.common.references.a<Bitmap>> pAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pAA = bVar;
    }

    public b ewX() {
        return this.pAA;
    }

    public com.facebook.common.references.a<Bitmap> ewY() {
        return com.facebook.common.references.a.b(this.pAC);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pAC = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int ewZ() {
        return this.pAB;
    }

    public e QL(int i) {
        this.pAB = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> exa() {
        return com.facebook.common.references.a.m(this.pAD);
    }

    public e gM(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pAD = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d exb() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pAC);
            this.pAC = null;
            com.facebook.common.references.a.b(this.pAD);
            this.pAD = null;
        }
    }
}
