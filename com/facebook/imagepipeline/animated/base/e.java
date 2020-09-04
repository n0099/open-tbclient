package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private final b nsI;
    private int nsJ;
    private com.facebook.common.references.a<Bitmap> nsK;
    private List<com.facebook.common.references.a<Bitmap>> nsL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.nsI = bVar;
    }

    public b dRH() {
        return this.nsI;
    }

    public com.facebook.common.references.a<Bitmap> dRI() {
        return com.facebook.common.references.a.b(this.nsK);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.nsK = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dRJ() {
        return this.nsJ;
    }

    public e LB(int i) {
        this.nsJ = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dRK() {
        return com.facebook.common.references.a.m(this.nsL);
    }

    public e fJ(List<com.facebook.common.references.a<Bitmap>> list) {
        this.nsL = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dRL() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.nsK);
            this.nsK = null;
            com.facebook.common.references.a.b(this.nsL);
            this.nsL = null;
        }
    }
}
