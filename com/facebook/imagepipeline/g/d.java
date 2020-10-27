package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int oFH;
    private final int oFI;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> oNx;
    private final h oNy;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.oNx = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.oNy = hVar;
        this.oFH = i;
        this.oFI = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.oNx = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.egz());
        this.mBitmap = this.oNx.get();
        this.oNy = hVar;
        this.oFH = i;
        this.oFI = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> emb = emb();
        if (emb != null) {
            emb.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> emb() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.oNx;
        this.oNx = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> emc() {
        return com.facebook.common.references.a.b(this.oNx);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.oNx == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap elZ() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.am(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.oFH % 180 != 0 || this.oFI == 5 || this.oFI == 7) ? ad(this.mBitmap) : ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.oFH % 180 != 0 || this.oFI == 5 || this.oFI == 7) ? ac(this.mBitmap) : ad(this.mBitmap);
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

    public int emd() {
        return this.oFH;
    }

    public int eme() {
        return this.oFI;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h ema() {
        return this.oNy;
    }
}
