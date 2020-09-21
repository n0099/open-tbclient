package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> nGO;
    private final h nGP;
    private final int nyV;
    private final int nyW;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.nGO = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.nGP = hVar;
        this.nyV = i;
        this.nyW = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.nGO = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dSQ());
        this.mBitmap = this.nGO.get();
        this.nGP = hVar;
        this.nyV = i;
        this.nyW = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dYs = dYs();
        if (dYs != null) {
            dYs.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dYs() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.nGO;
        this.nGO = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dYt() {
        return com.facebook.common.references.a.b(this.nGO);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.nGO == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dYq() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ai(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.nyV % 180 != 0 || this.nyW == 5 || this.nyW == 7) ? Z(this.mBitmap) : Y(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.nyV % 180 != 0 || this.nyW == 5 || this.nyW == 7) ? Y(this.mBitmap) : Z(this.mBitmap);
    }

    private static int Y(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int Z(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int dYu() {
        return this.nyV;
    }

    public int dYv() {
        return this.nyW;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dYr() {
        return this.nGP;
    }
}
