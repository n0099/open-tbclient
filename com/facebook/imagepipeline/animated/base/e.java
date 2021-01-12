package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    private final b pvZ;
    private int pwa;
    private com.facebook.common.references.a<Bitmap> pwb;
    private List<com.facebook.common.references.a<Bitmap>> pwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pvZ = bVar;
    }

    public b etf() {
        return this.pvZ;
    }

    public com.facebook.common.references.a<Bitmap> etg() {
        return com.facebook.common.references.a.b(this.pwb);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pwb = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int eth() {
        return this.pwa;
    }

    public e Pe(int i) {
        this.pwa = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> eti() {
        return com.facebook.common.references.a.m(this.pwc);
    }

    public e gM(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pwc = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d etj() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pwb);
            this.pwb = null;
            com.facebook.common.references.a.b(this.pwc);
            this.pwc = null;
        }
    }
}
