package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int jDa;
    private final g jIA;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> jIz;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.jIz = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.jIA = gVar;
        this.jDa = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.jIz = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.ctH());
        this.mBitmap = this.jIz.get();
        this.jIA = gVar;
        this.jDa = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cyz = cyz();
        if (cyz != null) {
            cyz.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cyz() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.jIz;
        this.jIz = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.jIz == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cyx() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ab(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.jDa == 90 || this.jDa == 270) ? T(this.mBitmap) : S(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.jDa == 90 || this.jDa == 270) ? S(this.mBitmap) : T(this.mBitmap);
    }

    private static int S(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int T(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int cyA() {
        return this.jDa;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cyy() {
        return this.jIA;
    }
}
