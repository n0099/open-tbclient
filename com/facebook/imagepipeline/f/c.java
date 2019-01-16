package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int inz;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> isP;
    private final g isQ;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.isP = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.isQ = gVar;
        this.inz = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.isP = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.bUJ());
        this.mBitmap = this.isP.get();
        this.isQ = gVar;
        this.inz = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> bZu = bZu();
        if (bZu != null) {
            bZu.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> bZu() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.isP;
        this.isP = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.isP == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap bZs() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.inz == 90 || this.inz == 270) ? L(this.mBitmap) : K(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.inz == 90 || this.inz == 270) ? K(this.mBitmap) : L(this.mBitmap);
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

    public int bZv() {
        return this.inz;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g bZt() {
        return this.isQ;
    }
}
