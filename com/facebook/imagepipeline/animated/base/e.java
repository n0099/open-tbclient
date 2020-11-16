package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    private final b oUn;
    private int oUo;
    private com.facebook.common.references.a<Bitmap> oUp;
    private List<com.facebook.common.references.a<Bitmap>> oUq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.oUn = bVar;
    }

    public b enb() {
        return this.oUn;
    }

    public com.facebook.common.references.a<Bitmap> enc() {
        return com.facebook.common.references.a.b(this.oUp);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.oUp = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int ene() {
        return this.oUo;
    }

    public e PB(int i) {
        this.oUo = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> enf() {
        return com.facebook.common.references.a.m(this.oUq);
    }

    public e gA(List<com.facebook.common.references.a<Bitmap>> list) {
        this.oUq = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d eng() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.oUp);
            this.oUp = null;
            com.facebook.common.references.a.b(this.oUq);
            this.oUq = null;
        }
    }
}
