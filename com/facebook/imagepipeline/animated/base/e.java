package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b pjm;
    private int pjn;
    private com.facebook.common.references.a<Bitmap> pjo;
    private List<com.facebook.common.references.a<Bitmap>> pjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.pjm = bVar;
    }

    public b esM() {
        return this.pjm;
    }

    public com.facebook.common.references.a<Bitmap> esN() {
        return com.facebook.common.references.a.b(this.pjo);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.pjo = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int esO() {
        return this.pjn;
    }

    public e Qx(int i) {
        this.pjn = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> esP() {
        return com.facebook.common.references.a.m(this.pjp);
    }

    public e gP(List<com.facebook.common.references.a<Bitmap>> list) {
        this.pjp = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d esQ() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.pjo);
            this.pjo = null;
            com.facebook.common.references.a.b(this.pjp);
            this.pjp = null;
        }
    }
}
