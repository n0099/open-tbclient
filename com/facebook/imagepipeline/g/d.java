package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private final int lVv;
    private final int lVw;
    private volatile Bitmap mBitmap;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> mdr;
    private final h mds;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.mdr = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.mds = hVar;
        this.lVv = i;
        this.lVw = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.mdr = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dnk());
        this.mBitmap = this.mdr.get();
        this.mds = hVar;
        this.lVv = i;
        this.lVw = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dsP = dsP();
        if (dsP != null) {
            dsP.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dsP() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.mdr;
        this.mdr = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dsQ() {
        return com.facebook.common.references.a.b(this.mdr);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.mdr == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dsN() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ae(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lVv % 180 != 0 || this.lVw == 5 || this.lVw == 7) ? V(this.mBitmap) : U(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lVv % 180 != 0 || this.lVw == 5 || this.lVw == 7) ? U(this.mBitmap) : V(this.mBitmap);
    }

    private static int U(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int V(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int dsR() {
        return this.lVv;
    }

    public int dsS() {
        return this.lVw;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dsO() {
        return this.mds;
    }
}
