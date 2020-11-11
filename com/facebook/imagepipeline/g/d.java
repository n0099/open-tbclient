package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int oPa;
    private final int oPb;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> oWQ;
    private final h oWR;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.oWQ = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.oWR = hVar;
        this.oPa = i;
        this.oPb = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.oWQ = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.eko());
        this.mBitmap = this.oWQ.get();
        this.oWR = hVar;
        this.oPa = i;
        this.oPb = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> epS = epS();
        if (epS != null) {
            epS.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> epS() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.oWQ;
        this.oWQ = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> epT() {
        return com.facebook.common.references.a.b(this.oWQ);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.oWQ == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap epQ() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.am(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.oPa % 180 != 0 || this.oPb == 5 || this.oPb == 7) ? ad(this.mBitmap) : ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.oPa % 180 != 0 || this.oPb == 5 || this.oPb == 7) ? ac(this.mBitmap) : ad(this.mBitmap);
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

    public int epU() {
        return this.oPa;
    }

    public int epV() {
        return this.oPb;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h epR() {
        return this.oWR;
    }
}
