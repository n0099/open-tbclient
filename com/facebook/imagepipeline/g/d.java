package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private final int lMj;
    private final int lMk;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> lTP;
    private final h lTQ;
    private volatile Bitmap mBitmap;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.lTP = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.lTQ = hVar;
        this.lMj = i;
        this.lMk = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.lTP = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dkT());
        this.mBitmap = this.lTP.get();
        this.lTQ = hVar;
        this.lMj = i;
        this.lMk = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dqt = dqt();
        if (dqt != null) {
            dqt.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dqt() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.lTP;
        this.lTP = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dqu() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTP);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lTP == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dqr() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ad(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lMj % 180 != 0 || this.lMk == 5 || this.lMk == 7) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lMj % 180 != 0 || this.lMk == 5 || this.lMk == 7) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int dqv() {
        return this.lMj;
    }

    public int dqw() {
        return this.lMk;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dqs() {
        return this.lTQ;
    }
}
