package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private final b lLj;
    private int lLk;
    private com.facebook.common.references.a<Bitmap> lLl;
    private List<com.facebook.common.references.a<Bitmap>> lLm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lLj = bVar;
    }

    public b dll() {
        return this.lLj;
    }

    public com.facebook.common.references.a<Bitmap> dlm() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lLl);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lLl = com.facebook.common.references.a.b((com.facebook.common.references.a) aVar);
        return this;
    }

    public int dln() {
        return this.lLk;
    }

    public e HM(int i) {
        this.lLk = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dlo() {
        return com.facebook.common.references.a.i(this.lLm);
    }

    public e eZ(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lLm = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dlp() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.lLl);
            this.lLl = null;
            com.facebook.common.references.a.a(this.lLm);
            this.lLm = null;
        }
    }
}
