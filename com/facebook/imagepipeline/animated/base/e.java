package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b lOU;
    private int lOV;
    private com.facebook.common.references.a<Bitmap> lOW;
    private List<com.facebook.common.references.a<Bitmap>> lOX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lOU = bVar;
    }

    public b dmq() {
        return this.lOU;
    }

    public com.facebook.common.references.a<Bitmap> dmr() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lOW);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lOW = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        return this;
    }

    public int dms() {
        return this.lOV;
    }

    public e HV(int i) {
        this.lOV = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dmt() {
        return com.facebook.common.references.a.i(this.lOX);
    }

    public e eZ(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lOX = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dmu() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.lOW);
            this.lOW = null;
            com.facebook.common.references.a.a(this.lOX);
            this.lOX = null;
        }
    }
}
