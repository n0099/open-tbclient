package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b mtf;
    private int mtg;
    private com.facebook.common.references.a<Bitmap> mth;
    private List<com.facebook.common.references.a<Bitmap>> mti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.mtf = bVar;
    }

    public b dxs() {
        return this.mtf;
    }

    public com.facebook.common.references.a<Bitmap> dxt() {
        return com.facebook.common.references.a.b(this.mth);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.mth = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dxu() {
        return this.mtg;
    }

    public e Ht(int i) {
        this.mtg = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dxv() {
        return com.facebook.common.references.a.k(this.mti);
    }

    public e fc(List<com.facebook.common.references.a<Bitmap>> list) {
        this.mti = com.facebook.common.references.a.k(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dxw() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.mth);
            this.mth = null;
            com.facebook.common.references.a.b(this.mti);
            this.mti = null;
        }
    }
}
