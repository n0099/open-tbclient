package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int pDl;
    private final int pDm;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pKC;
    private final h pKD;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pKC = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pKD = hVar;
        this.pDl = i;
        this.pDm = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pKC = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.esS());
        this.mBitmap = this.pKC.get();
        this.pKD = hVar;
        this.pDl = i;
        this.pDm = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> eyq = eyq();
        if (eyq != null) {
            eyq.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> eyq() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pKC;
        this.pKC = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> eyr() {
        return com.facebook.common.references.a.b(this.pKC);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pKC == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap eyo() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.aj(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.pDl % 180 != 0 || this.pDm == 5 || this.pDm == 7) ? aa(this.mBitmap) : Z(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.pDl % 180 != 0 || this.pDm == 5 || this.pDm == 7) ? Z(this.mBitmap) : aa(this.mBitmap);
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

    public int eys() {
        return this.pDl;
    }

    public int eyt() {
        return this.pDm;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h eyp() {
        return this.pKD;
    }
}
