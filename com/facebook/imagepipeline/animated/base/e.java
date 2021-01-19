package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes5.dex */
public class e {
    private final b pwa;
    private int pwb;
    private com.facebook.common.references.a<Bitmap> pwc;
    private List<com.facebook.common.references.a<Bitmap>> pwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pwa = bVar;
    }

    public b etf() {
        return this.pwa;
    }

    public com.facebook.common.references.a<Bitmap> etg() {
        return com.facebook.common.references.a.b(this.pwc);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pwc = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int eth() {
        return this.pwb;
    }

    public e Pe(int i) {
        this.pwb = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> eti() {
        return com.facebook.common.references.a.m(this.pwd);
    }

    public e gM(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pwd = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d etj() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pwc);
            this.pwc = null;
            com.facebook.common.references.a.b(this.pwd);
            this.pwd = null;
        }
    }
}
