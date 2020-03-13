package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private final int lMu;
    private final int lMv;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> lUa;
    private final h lUb;
    private volatile Bitmap mBitmap;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.lUa = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.lUb = hVar;
        this.lMu = i;
        this.lMv = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.lUa = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dkU());
        this.mBitmap = this.lUa.get();
        this.lUb = hVar;
        this.lMu = i;
        this.lMv = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dqu = dqu();
        if (dqu != null) {
            dqu.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dqu() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.lUa;
        this.lUa = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dqv() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lUa);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lUa == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dqs() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ad(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lMu % 180 != 0 || this.lMv == 5 || this.lMv == 7) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lMu % 180 != 0 || this.lMv == 5 || this.lMv == 7) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int dqw() {
        return this.lMu;
    }

    public int dqx() {
        return this.lMv;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dqt() {
        return this.lUb;
    }
}
