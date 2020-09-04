package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int noX;
    private final int noY;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> nwR;
    private final h nwS;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.nwR = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.nwS = hVar;
        this.noX = i;
        this.noY = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.nwR = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dOS());
        this.mBitmap = this.nwR.get();
        this.nwS = hVar;
        this.noX = i;
        this.noY = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dUu = dUu();
        if (dUu != null) {
            dUu.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dUu() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.nwR;
        this.nwR = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dUv() {
        return com.facebook.common.references.a.b(this.nwR);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.nwR == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dUs() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.aj(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.noX % 180 != 0 || this.noY == 5 || this.noY == 7) ? aa(this.mBitmap) : Z(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.noX % 180 != 0 || this.noY == 5 || this.noY == 7) ? Z(this.mBitmap) : aa(this.mBitmap);
    }

    private static int Z(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int aa(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int dUw() {
        return this.noX;
    }

    public int dUx() {
        return this.noY;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dUt() {
        return this.nwS;
    }
}
