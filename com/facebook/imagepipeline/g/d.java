package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private final int lOa;
    private final int lOb;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> lVG;
    private final h lVH;
    private volatile Bitmap mBitmap;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.lVG = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.lVH = hVar;
        this.lOa = i;
        this.lOb = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.lVG = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dlr());
        this.mBitmap = this.lVG.get();
        this.lVH = hVar;
        this.lOa = i;
        this.lOb = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dqR = dqR();
        if (dqR != null) {
            dqR.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dqR() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.lVG;
        this.lVG = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dqS() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lVG);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lVG == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dqP() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ad(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lOa % 180 != 0 || this.lOb == 5 || this.lOb == 7) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lOa % 180 != 0 || this.lOb == 5 || this.lOb == 7) ? T(this.mBitmap) : U(this.mBitmap);
    }

    private static int T(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int U(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int dqT() {
        return this.lOa;
    }

    public int dqU() {
        return this.lOb;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dqQ() {
        return this.lVH;
    }
}
