package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int mps;
    private final int mpt;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> mxm;
    private final h mxn;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.mxm = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.mxn = hVar;
        this.mps = i;
        this.mpt = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.mxm = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.duB());
        this.mBitmap = this.mxm.get();
        this.mxn = hVar;
        this.mps = i;
        this.mpt = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dAf = dAf();
        if (dAf != null) {
            dAf.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dAf() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.mxm;
        this.mxm = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dAg() {
        return com.facebook.common.references.a.b(this.mxm);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.mxm == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dAd() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ag(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.mps % 180 != 0 || this.mpt == 5 || this.mpt == 7) ? X(this.mBitmap) : W(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.mps % 180 != 0 || this.mpt == 5 || this.mpt == 7) ? W(this.mBitmap) : X(this.mBitmap);
    }

    private static int W(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int X(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int dAh() {
        return this.mps;
    }

    public int dAi() {
        return this.mpt;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dAe() {
        return this.mxn;
    }
}
