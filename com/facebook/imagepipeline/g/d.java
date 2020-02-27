package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private final int lMh;
    private final int lMi;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> lTN;
    private final h lTO;
    private volatile Bitmap mBitmap;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.lTN = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.lTO = hVar;
        this.lMh = i;
        this.lMi = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.lTN = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dkR());
        this.mBitmap = this.lTN.get();
        this.lTO = hVar;
        this.lMh = i;
        this.lMi = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dqr = dqr();
        if (dqr != null) {
            dqr.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dqr() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.lTN;
        this.lTN = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dqs() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTN);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lTN == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dqp() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ad(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lMh % 180 != 0 || this.lMi == 5 || this.lMi == 7) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lMh % 180 != 0 || this.lMi == 5 || this.lMi == 7) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int dqt() {
        return this.lMh;
    }

    public int dqu() {
        return this.lMi;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dqq() {
        return this.lTO;
    }
}
