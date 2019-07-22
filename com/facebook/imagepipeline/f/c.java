package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int kcC;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> kic;
    private final g kie;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.kic = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.kie = gVar;
        this.kcC = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.kic = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cEM());
        this.mBitmap = this.kic.get();
        this.kie = gVar;
        this.kcC = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cJF = cJF();
        if (cJF != null) {
            cJF.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cJF() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.kic;
        this.kic = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.kic == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cJD() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.kcC == 90 || this.kcC == 270) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.kcC == 90 || this.kcC == 270) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int cJG() {
        return this.kcC;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cJE() {
        return this.kie;
    }
}
