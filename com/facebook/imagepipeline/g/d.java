package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int nOo;
    private final int nOp;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> nWf;
    private final h nWg;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.nWf = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.nWg = hVar;
        this.nOo = i;
        this.nOp = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.nWf = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dWB());
        this.mBitmap = this.nWf.get();
        this.nWg = hVar;
        this.nOo = i;
        this.nOp = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> ecd = ecd();
        if (ecd != null) {
            ecd.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> ecd() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.nWf;
        this.nWf = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> ece() {
        return com.facebook.common.references.a.b(this.nWf);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.nWf == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap ecb() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ai(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.nOo % 180 != 0 || this.nOp == 5 || this.nOp == 7) ? Z(this.mBitmap) : Y(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.nOo % 180 != 0 || this.nOp == 5 || this.nOp == 7) ? Y(this.mBitmap) : Z(this.mBitmap);
    }

    private static int Y(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int Z(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int ecf() {
        return this.nOo;
    }

    public int ecg() {
        return this.nOp;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h ecc() {
        return this.nWg;
    }
}
