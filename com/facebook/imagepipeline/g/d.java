package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int noF;
    private final int noG;
    private final h nwA;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> nwz;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.nwz = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.nwA = hVar;
        this.noF = i;
        this.noG = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.nwz = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dOJ());
        this.mBitmap = this.nwz.get();
        this.nwA = hVar;
        this.noF = i;
        this.noG = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dUl = dUl();
        if (dUl != null) {
            dUl.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dUl() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.nwz;
        this.nwz = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dUm() {
        return com.facebook.common.references.a.b(this.nwz);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.nwz == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dUj() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.aj(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.noF % 180 != 0 || this.noG == 5 || this.noG == 7) ? aa(this.mBitmap) : Z(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.noF % 180 != 0 || this.noG == 5 || this.noG == 7) ? Z(this.mBitmap) : aa(this.mBitmap);
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

    public int dUn() {
        return this.noF;
    }

    public int dUo() {
        return this.noG;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dUk() {
        return this.nwA;
    }
}
