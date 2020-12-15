package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int pfO;
    private final int pfP;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pnk;
    private final h pnl;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pnk = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pnl = hVar;
        this.pfO = i;
        this.pfP = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pnk = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.eqc());
        this.mBitmap = this.pnk.get();
        this.pnl = hVar;
        this.pfO = i;
        this.pfP = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> evw = evw();
        if (evw != null) {
            evw.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> evw() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pnk;
        this.pnk = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> evx() {
        return com.facebook.common.references.a.b(this.pnk);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pnk == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap evu() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.am(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.pfO % 180 != 0 || this.pfP == 5 || this.pfP == 7) ? ad(this.mBitmap) : ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.pfO % 180 != 0 || this.pfP == 5 || this.pfP == 7) ? ac(this.mBitmap) : ad(this.mBitmap);
    }

    private static int ac(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int ad(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int evy() {
        return this.pfO;
    }

    public int evz() {
        return this.pfP;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h evv() {
        return this.pnl;
    }
}
