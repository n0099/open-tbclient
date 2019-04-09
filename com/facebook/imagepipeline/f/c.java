package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int jCG;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> jIf;
    private final g jIg;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.jIf = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.jIg = gVar;
        this.jCG = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.jIf = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.ctN());
        this.mBitmap = this.jIf.get();
        this.jIg = gVar;
        this.jCG = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cyF = cyF();
        if (cyF != null) {
            cyF.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cyF() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.jIf;
        this.jIf = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.jIf == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cyD() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ab(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.jCG == 90 || this.jCG == 270) ? T(this.mBitmap) : S(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.jCG == 90 || this.jCG == 270) ? S(this.mBitmap) : T(this.mBitmap);
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

    public int cyG() {
        return this.jCG;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cyE() {
        return this.jIg;
    }
}
