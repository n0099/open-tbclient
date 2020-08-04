package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int mUP;
    private final int mUQ;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> ncJ;
    private final h ncK;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.ncJ = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.ncK = hVar;
        this.mUP = i;
        this.mUQ = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.ncJ = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dCJ());
        this.mBitmap = this.ncJ.get();
        this.ncK = hVar;
        this.mUP = i;
        this.mUQ = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dIm = dIm();
        if (dIm != null) {
            dIm.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dIm() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.ncJ;
        this.ncJ = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dIn() {
        return com.facebook.common.references.a.b(this.ncJ);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.ncJ == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dIk() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.aj(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.mUP % 180 != 0 || this.mUQ == 5 || this.mUQ == 7) ? aa(this.mBitmap) : Z(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.mUP % 180 != 0 || this.mUQ == 5 || this.mUQ == 7) ? Z(this.mBitmap) : aa(this.mBitmap);
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

    public int dIo() {
        return this.mUP;
    }

    public int dIp() {
        return this.mUQ;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dIl() {
        return this.ncK;
    }
}
