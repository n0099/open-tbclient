package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b lZk;
    private int lZl;
    private com.facebook.common.references.a<Bitmap> lZm;
    private List<com.facebook.common.references.a<Bitmap>> lZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lZk = bVar;
    }

    public b dqa() {
        return this.lZk;
    }

    public com.facebook.common.references.a<Bitmap> dqb() {
        return com.facebook.common.references.a.b(this.lZm);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lZm = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dqc() {
        return this.lZl;
    }

    public e GH(int i) {
        this.lZl = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dqd() {
        return com.facebook.common.references.a.i(this.lZn);
    }

    public e eV(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lZn = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dqe() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lZm);
            this.lZm = null;
            com.facebook.common.references.a.b(this.lZn);
            this.lZn = null;
        }
    }
}
