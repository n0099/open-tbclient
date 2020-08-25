package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private final b nsq;
    private int nsr;
    private com.facebook.common.references.a<Bitmap> nss;
    private List<com.facebook.common.references.a<Bitmap>> nst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.nsq = bVar;
    }

    public b dRy() {
        return this.nsq;
    }

    public com.facebook.common.references.a<Bitmap> dRz() {
        return com.facebook.common.references.a.b(this.nss);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.nss = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dRA() {
        return this.nsr;
    }

    public e LB(int i) {
        this.nsr = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dRB() {
        return com.facebook.common.references.a.m(this.nst);
    }

    public e fJ(List<com.facebook.common.references.a<Bitmap>> list) {
        this.nst = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dRC() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.nss);
            this.nss = null;
            com.facebook.common.references.a.b(this.nst);
            this.nst = null;
        }
    }
}
