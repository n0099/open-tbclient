package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes14.dex */
public class e {
    private final b pIN;
    private int pIO;
    private com.facebook.common.references.a<Bitmap> pIP;
    private List<com.facebook.common.references.a<Bitmap>> pIQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pIN = bVar;
    }

    public b evO() {
        return this.pIN;
    }

    public com.facebook.common.references.a<Bitmap> evP() {
        return com.facebook.common.references.a.b(this.pIP);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pIP = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int evQ() {
        return this.pIO;
    }

    public e PE(int i) {
        this.pIO = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> evR() {
        return com.facebook.common.references.a.m(this.pIQ);
    }

    public e gK(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pIQ = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d evS() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pIP);
            this.pIP = null;
            com.facebook.common.references.a.b(this.pIQ);
            this.pIQ = null;
        }
    }
}
