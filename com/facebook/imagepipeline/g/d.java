package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes17.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int oQE;
    private final int oQF;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> oYt;
    private final h oYu;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.oYt = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.oYu = hVar;
        this.oQE = i;
        this.oQF = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.oYt = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.ekm());
        this.mBitmap = this.oYt.get();
        this.oYu = hVar;
        this.oQE = i;
        this.oQF = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> epQ = epQ();
        if (epQ != null) {
            epQ.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> epQ() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.oYt;
        this.oYt = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> epR() {
        return com.facebook.common.references.a.b(this.oYt);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.oYt == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap epO() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.am(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.oQE % 180 != 0 || this.oQF == 5 || this.oQF == 7) ? ad(this.mBitmap) : ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.oQE % 180 != 0 || this.oQF == 5 || this.oQF == 7) ? ac(this.mBitmap) : ad(this.mBitmap);
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

    public int epS() {
        return this.oQE;
    }

    public int epT() {
        return this.oQF;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h epP() {
        return this.oYu;
    }
}
