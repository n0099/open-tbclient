package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int pFq;
    private final int pFr;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pMH;
    private final h pMI;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pMH = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pMI = hVar;
        this.pFq = i;
        this.pFr = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pMH = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.etb());
        this.mBitmap = this.pMH.get();
        this.pMI = hVar;
        this.pFq = i;
        this.pFr = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> eyz = eyz();
        if (eyz != null) {
            eyz.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> eyz() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pMH;
        this.pMH = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> eyA() {
        return com.facebook.common.references.a.b(this.pMH);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pMH == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap eyx() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.aj(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.pFq % 180 != 0 || this.pFr == 5 || this.pFr == 7) ? aa(this.mBitmap) : Z(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.pFq % 180 != 0 || this.pFr == 5 || this.pFr == 7) ? Z(this.mBitmap) : aa(this.mBitmap);
    }

    private static int Z(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int aa(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int eyB() {
        return this.pFq;
    }

    public int eyC() {
        return this.pFr;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h eyy() {
        return this.pMI;
    }
}
