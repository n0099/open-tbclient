package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes11.dex */
public class d extends b {
    private final int lHX;
    private final int lHY;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> lPp;
    private final h lPq;
    private volatile Bitmap mBitmap;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.lPp = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.lPq = hVar;
        this.lHX = i;
        this.lHY = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.lPp = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.diB());
        this.mBitmap = this.lPp.get();
        this.lPq = hVar;
        this.lHX = i;
        this.lHY = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dnX = dnX();
        if (dnX != null) {
            dnX.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dnX() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.lPp;
        this.lPp = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dnY() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPp);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.lPp == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dnV() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lHX % 180 != 0 || this.lHY == 5 || this.lHY == 7) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lHX % 180 != 0 || this.lHY == 5 || this.lHY == 7) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int dnZ() {
        return this.lHX;
    }

    public int doa() {
        return this.lHY;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dnW() {
        return this.lPq;
    }
}
