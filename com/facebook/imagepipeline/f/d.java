package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pCN;
    private final h pCO;
    private final int pwW;
    private final int pwX;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pCN = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pCO = hVar;
        this.pwW = i;
        this.pwX = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pCN = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.eue());
        this.mBitmap = this.pCN.get();
        this.pCO = hVar;
        this.pwW = i;
        this.pwX = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> eze = eze();
        if (eze != null) {
            eze.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> eze() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pCN;
        this.pCN = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pCN == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap ezc() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ak(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.pwW % 180 != 0 || this.pwX == 5 || this.pwX == 7) ? ab(this.mBitmap) : aa(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.pwW % 180 != 0 || this.pwX == 5 || this.pwX == 7) ? aa(this.mBitmap) : ab(this.mBitmap);
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

    public int ezf() {
        return this.pwW;
    }

    public int ezg() {
        return this.pwX;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h ezd() {
        return this.pCO;
    }
}
