package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int jDl;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> jIK;
    private final g jIL;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.jIK = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.jIL = gVar;
        this.jDl = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.jIK = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.ctU());
        this.mBitmap = this.jIK.get();
        this.jIL = gVar;
        this.jDl = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cyM = cyM();
        if (cyM != null) {
            cyM.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cyM() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.jIK;
        this.jIK = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.jIK == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cyK() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ab(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.jDl == 90 || this.jDl == 270) ? T(this.mBitmap) : S(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.jDl == 90 || this.jDl == 270) ? S(this.mBitmap) : T(this.mBitmap);
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

    public int cyN() {
        return this.jDl;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cyL() {
        return this.jIL;
    }
}
