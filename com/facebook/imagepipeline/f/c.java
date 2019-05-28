package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int jVv;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> kaT;
    private final g kaU;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.kaT = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.kaU = gVar;
        this.jVv = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.kaT = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cBM());
        this.mBitmap = this.kaT.get();
        this.kaU = gVar;
        this.jVv = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cGD = cGD();
        if (cGD != null) {
            cGD.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cGD() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.kaT;
        this.kaT = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.kaT == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cGB() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.jVv == 90 || this.jVv == 270) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.jVv == 90 || this.jVv == 270) ? T(this.mBitmap) : U(this.mBitmap);
    }

    private static int T(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int U(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int cGE() {
        return this.jVv;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cGC() {
        return this.kaU;
    }
}
