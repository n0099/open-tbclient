package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes13.dex */
public class e {
    private final b lZg;
    private int lZh;
    private com.facebook.common.references.a<Bitmap> lZi;
    private List<com.facebook.common.references.a<Bitmap>> lZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.lZg = bVar;
    }

    public b dqc() {
        return this.lZg;
    }

    public com.facebook.common.references.a<Bitmap> dqd() {
        return com.facebook.common.references.a.b(this.lZi);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.lZi = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int dqe() {
        return this.lZh;
    }

    public e GH(int i) {
        this.lZh = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> dqf() {
        return com.facebook.common.references.a.i(this.lZj);
    }

    public e eV(List<com.facebook.common.references.a<Bitmap>> list) {
        this.lZj = com.facebook.common.references.a.i(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d dqg() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.lZi);
            this.lZi = null;
            com.facebook.common.references.a.a(this.lZj);
            this.lZj = null;
        }
    }
}
