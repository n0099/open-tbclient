package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int imr;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> irI;
    private final g irJ;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.irI = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.irJ = gVar;
        this.imr = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.irI = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.bUb());
        this.mBitmap = this.irI.get();
        this.irJ = gVar;
        this.imr = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> bYM = bYM();
        if (bYM != null) {
            bYM.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> bYM() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.irI;
        this.irI = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.irI == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap bYK() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.imr == 90 || this.imr == 270) ? L(this.mBitmap) : K(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.imr == 90 || this.imr == 270) ? K(this.mBitmap) : L(this.mBitmap);
    }

    private static int K(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int L(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int bYN() {
        return this.imr;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g bYL() {
        return this.irJ;
    }
}
