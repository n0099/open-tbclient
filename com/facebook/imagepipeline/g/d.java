package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class d extends b {
    private final int lLA;
    private final int lLB;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> lTg;
    private final h lTh;
    private volatile Bitmap mBitmap;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.lTg = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.lTh = hVar;
        this.lLA = i;
        this.lLB = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.lTg = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.djE());
        this.mBitmap = this.lTg.get();
        this.lTh = hVar;
        this.lLA = i;
        this.lLB = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dpf = dpf();
        if (dpf != null) {
            dpf.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dpf() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.lTg;
        this.lTg = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dpg() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTg);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lTg == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dpd() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ad(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lLA % 180 != 0 || this.lLB == 5 || this.lLB == 7) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lLA % 180 != 0 || this.lLB == 5 || this.lLB == 7) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int dph() {
        return this.lLA;
    }

    public int dpi() {
        return this.lLB;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dpe() {
        return this.lTh;
    }
}
