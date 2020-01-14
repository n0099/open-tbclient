package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b lOZ;
    private int lPa;
    private com.facebook.common.references.a<Bitmap> lPb;
    private List<com.facebook.common.references.a<Bitmap>> lPc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lOZ = bVar;
    }

    public b dms() {
        return this.lOZ;
    }

    public com.facebook.common.references.a<Bitmap> dmt() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPb);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lPb = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        return this;
    }

    public int dmu() {
        return this.lPa;
    }

    public e HV(int i) {
        this.lPa = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dmv() {
        return com.facebook.common.references.a.i(this.lPc);
    }

    public e eZ(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lPc = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dmw() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.lPb);
            this.lPb = null;
            com.facebook.common.references.a.a(this.lPc);
            this.lPc = null;
        }
    }
}
