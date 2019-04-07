package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int jCF;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> jIe;
    private final g jIf;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.jIe = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.jIf = gVar;
        this.jCF = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.jIe = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.ctN());
        this.mBitmap = this.jIe.get();
        this.jIf = gVar;
        this.jCF = i;
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
        aVar = this.jIe;
        this.jIe = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.jIe == null;
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
        return (this.jCF == 90 || this.jCF == 270) ? T(this.mBitmap) : S(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.jCF == 90 || this.jCF == 270) ? S(this.mBitmap) : T(this.mBitmap);
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
        return this.jCF;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cyE() {
        return this.jIf;
    }
}
