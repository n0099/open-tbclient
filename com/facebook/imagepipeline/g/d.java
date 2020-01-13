package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class d extends b {
    private final int lLv;
    private final int lLw;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> lTb;
    private final h lTc;
    private volatile Bitmap mBitmap;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.lTb = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.lTc = hVar;
        this.lLv = i;
        this.lLw = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.lTb = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.djC());
        this.mBitmap = this.lTb.get();
        this.lTc = hVar;
        this.lLv = i;
        this.lLw = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dpd = dpd();
        if (dpd != null) {
            dpd.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dpd() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.lTb;
        this.lTb = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dpe() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTb);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lTb == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dpb() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ad(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lLv % 180 != 0 || this.lLw == 5 || this.lLw == 7) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lLv % 180 != 0 || this.lLw == 5 || this.lLw == 7) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int dpf() {
        return this.lLv;
    }

    public int dpg() {
        return this.lLw;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dpc() {
        return this.lTc;
    }
}
