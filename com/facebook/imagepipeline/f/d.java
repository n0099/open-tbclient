package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int pCL;
    private final int pCM;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pKc;
    private final h pKd;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pKc = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pKd = hVar;
        this.pCL = i;
        this.pCM = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pKc = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.esK());
        this.mBitmap = this.pKc.get();
        this.pKd = hVar;
        this.pCL = i;
        this.pCM = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> eyi = eyi();
        if (eyi != null) {
            eyi.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> eyi() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pKc;
        this.pKc = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> eyj() {
        return com.facebook.common.references.a.b(this.pKc);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pKc == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap eyg() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.aj(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.pCL % 180 != 0 || this.pCM == 5 || this.pCM == 7) ? aa(this.mBitmap) : Z(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.pCL % 180 != 0 || this.pCM == 5 || this.pCM == 7) ? Z(this.mBitmap) : aa(this.mBitmap);
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

    public int eyk() {
        return this.pCL;
    }

    public int eyl() {
        return this.pCM;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h eyh() {
        return this.pKd;
    }
}
