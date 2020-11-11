package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b oSK;
    private int oSL;
    private com.facebook.common.references.a<Bitmap> oSM;
    private List<com.facebook.common.references.a<Bitmap>> oSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.oSK = bVar;
    }

    public b ene() {
        return this.oSK;
    }

    public com.facebook.common.references.a<Bitmap> enf() {
        return com.facebook.common.references.a.b(this.oSM);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.oSM = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int eng() {
        return this.oSL;
    }

    public e OY(int i) {
        this.oSL = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> enh() {
        return com.facebook.common.references.a.m(this.oSN);
    }

    public e gA(List<com.facebook.common.references.a<Bitmap>> list) {
        this.oSN = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d eni() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.oSM);
            this.oSM = null;
            com.facebook.common.references.a.b(this.oSN);
            this.oSN = null;
        }
    }
}
