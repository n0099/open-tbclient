package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int pfM;
    private final int pfN;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pni;
    private final h pnj;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pni = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pnj = hVar;
        this.pfM = i;
        this.pfN = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pni = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.eqb());
        this.mBitmap = this.pni.get();
        this.pnj = hVar;
        this.pfM = i;
        this.pfN = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> evv = evv();
        if (evv != null) {
            evv.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> evv() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pni;
        this.pni = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> evw() {
        return com.facebook.common.references.a.b(this.pni);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pni == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap evt() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.am(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.pfM % 180 != 0 || this.pfN == 5 || this.pfN == 7) ? ad(this.mBitmap) : ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.pfM % 180 != 0 || this.pfN == 5 || this.pfN == 7) ? ac(this.mBitmap) : ad(this.mBitmap);
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

    public int evx() {
        return this.pfM;
    }

    public int evy() {
        return this.pfN;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h evu() {
        return this.pnj;
    }
}
