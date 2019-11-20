package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int kdx;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> kjb;
    private final g kjc;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.kjb = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.kjc = gVar;
        this.kdx = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.kjb = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cCR());
        this.mBitmap = this.kjb.get();
        this.kjc = gVar;
        this.kdx = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cHJ = cHJ();
        if (cHJ != null) {
            cHJ.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cHJ() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.kjb;
        this.kjb = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.kjb == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cHH() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.aa(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.kdx == 90 || this.kdx == 270) ? S(this.mBitmap) : R(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.kdx == 90 || this.kdx == 270) ? R(this.mBitmap) : S(this.mBitmap);
    }

    private static int R(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int S(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int cHK() {
        return this.kdx;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cHI() {
        return this.kjc;
    }
}
