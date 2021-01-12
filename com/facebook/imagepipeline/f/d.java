package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int psB;
    private final int psC;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pzT;
    private final h pzU;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pzT = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pzU = hVar;
        this.psB = i;
        this.psC = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pzT = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.eqr());
        this.mBitmap = this.pzT.get();
        this.pzU = hVar;
        this.psB = i;
        this.psC = i2;
    }

    @Override // com.facebook.imagepipeline.f.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> evP = evP();
        if (evP != null) {
            evP.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> evP() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.pzT;
        this.pzT = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> evQ() {
        return com.facebook.common.references.a.b(this.pzT);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pzT == null;
    }

    @Override // com.facebook.imagepipeline.f.b
    public Bitmap evN() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ak(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getWidth() {
        return (this.psB % 180 != 0 || this.psC == 5 || this.psC == 7) ? ab(this.mBitmap) : aa(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.psB % 180 != 0 || this.psC == 5 || this.psC == 7) ? aa(this.mBitmap) : ab(this.mBitmap);
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

    public int evR() {
        return this.psB;
    }

    public int evS() {
        return this.psC;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h evO() {
        return this.pzU;
    }
}
