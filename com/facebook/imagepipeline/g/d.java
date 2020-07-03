package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int mMB;
    private final int mMC;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> mUD;
    private final h mUE;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.mUD = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.mUE = hVar;
        this.mMB = i;
        this.mMC = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.mUD = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dzs());
        this.mBitmap = this.mUD.get();
        this.mUE = hVar;
        this.mMB = i;
        this.mMC = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dEV = dEV();
        if (dEV != null) {
            dEV.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dEV() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.mUD;
        this.mUD = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dEW() {
        return com.facebook.common.references.a.b(this.mUD);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.mUD == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dET() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ag(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.mMB % 180 != 0 || this.mMC == 5 || this.mMC == 7) ? X(this.mBitmap) : W(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.mMB % 180 != 0 || this.mMC == 5 || this.mMC == 7) ? W(this.mBitmap) : X(this.mBitmap);
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

    public int dEX() {
        return this.mMB;
    }

    public int dEY() {
        return this.mMC;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dEU() {
        return this.mUE;
    }
}
