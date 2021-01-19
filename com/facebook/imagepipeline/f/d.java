package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int psC;
    private final int psD;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> pzU;
    private final h pzV;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.pzU = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.pzV = hVar;
        this.psC = i;
        this.psD = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.pzU = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.eqr());
        this.mBitmap = this.pzU.get();
        this.pzV = hVar;
        this.psC = i;
        this.psD = i2;
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
        aVar = this.pzU;
        this.pzU = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> evQ() {
        return com.facebook.common.references.a.b(this.pzU);
    }

    @Override // com.facebook.imagepipeline.f.c
    public synchronized boolean isClosed() {
        return this.pzU == null;
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
        return (this.psC % 180 != 0 || this.psD == 5 || this.psD == 7) ? ab(this.mBitmap) : aa(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.f
    public int getHeight() {
        return (this.psC % 180 != 0 || this.psD == 5 || this.psD == 7) ? aa(this.mBitmap) : ab(this.mBitmap);
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
        return this.psC;
    }

    public int evS() {
        return this.psD;
    }

    @Override // com.facebook.imagepipeline.f.c
    public h evO() {
        return this.pzV;
    }
}
