package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import java.util.List;
/* loaded from: classes12.dex */
public class e {
    private final b oJr;
    private int oJs;
    private com.facebook.common.references.a<Bitmap> oJt;
    private List<com.facebook.common.references.a<Bitmap>> oJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.oJr = bVar;
    }

    public b ejo() {
        return this.oJr;
    }

    public com.facebook.common.references.a<Bitmap> ejp() {
        return com.facebook.common.references.a.b(this.oJt);
    }

    public e j(com.facebook.common.references.a<Bitmap> aVar) {
        this.oJt = com.facebook.common.references.a.b(aVar);
        return this;
    }

    public int ejq() {
        return this.oJs;
    }

    public e OD(int i) {
        this.oJs = i;
        return this;
    }

    public List<com.facebook.common.references.a<Bitmap>> ejr() {
        return com.facebook.common.references.a.m(this.oJu);
    }

    public e gr(List<com.facebook.common.references.a<Bitmap>> list) {
        this.oJu = com.facebook.common.references.a.m(list);
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<com.facebook.common.references.a<android.graphics.Bitmap>>, com.facebook.common.references.a<android.graphics.Bitmap>] */
    public d ejs() {
        try {
            return new d(this);
        } finally {
            com.facebook.common.references.a.c(this.oJt);
            this.oJt = null;
            com.facebook.common.references.a.b(this.oJu);
            this.oJu = null;
        }
    }
}
