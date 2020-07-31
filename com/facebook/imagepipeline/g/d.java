package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int mUN;
    private final int mUO;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> ncH;
    private final h ncI;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.ncH = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.ncI = hVar;
        this.mUN = i;
        this.mUO = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.ncH = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dCI());
        this.mBitmap = this.ncH.get();
        this.ncI = hVar;
        this.mUN = i;
        this.mUO = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dIl = dIl();
        if (dIl != null) {
            dIl.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dIl() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.ncH;
        this.ncH = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dIm() {
        return com.facebook.common.references.a.b(this.ncH);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.ncH == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dIj() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.aj(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.mUN % 180 != 0 || this.mUO == 5 || this.mUO == 7) ? aa(this.mBitmap) : Z(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.mUN % 180 != 0 || this.mUO == 5 || this.mUO == 7) ? Z(this.mBitmap) : aa(this.mBitmap);
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

    public int dIn() {
        return this.mUN;
    }

    public int dIo() {
        return this.mUO;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dIk() {
        return this.ncI;
    }
}
