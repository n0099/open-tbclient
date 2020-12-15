package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b pjo;
    private int pjp;
    private com.facebook.common.references.a<Bitmap> pjq;
    private List<com.facebook.common.references.a<Bitmap>> pjr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pjo = bVar;
    }

    public b esN() {
        return this.pjo;
    }

    public com.facebook.common.references.a<Bitmap> esO() {
        return com.facebook.common.references.a.b(this.pjq);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pjq = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int esP() {
        return this.pjp;
    }

    public e Qx(int i) {
        this.pjp = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> esQ() {
        return com.facebook.common.references.a.m(this.pjr);
    }

    public e gP(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pjr = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d esR() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pjq);
            this.pjq = null;
            com.facebook.common.references.a.b(this.pjr);
            this.pjr = null;
        }
    }
}
