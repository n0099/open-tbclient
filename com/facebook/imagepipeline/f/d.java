package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pEu;
    private final h pEv;
    private final int pxd;
    private final int pxe;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pEu = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pEv = hVar;
        this.pxd = i;
        this.pxe = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pEu = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.eul());
        this.mBitmap = this.pEu.get();
        this.pEv = hVar;
        this.pxd = i;
        this.pxe = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> ezH = ezH();
        if (ezH != null) {
            ezH.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> ezH() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pEu;
        this.pEu = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ezI() {
        return com.facebook.common.references.a.b(this.pEu);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pEu == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap ezF() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ak(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.pxd % 180 != 0 || this.pxe == 5 || this.pxe == 7) ? ab(this.mBitmap) : aa(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.pxd % 180 != 0 || this.pxe == 5 || this.pxe == 7) ? aa(this.mBitmap) : ab(this.mBitmap);
    }

    private static int aa(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int ab(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int ezJ() {
        return this.pxd;
    }

    public int ezK() {
        return this.pxe;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h ezG() {
        return this.pEv;
    }
}
