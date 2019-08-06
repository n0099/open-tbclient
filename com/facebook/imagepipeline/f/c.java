package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int kdI;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> kjj;
    private final g kjk;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.kjj = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.kjk = gVar;
        this.kdI = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.kjj = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cFh());
        this.mBitmap = this.kjj.get();
        this.kjk = gVar;
        this.kdI = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cKa = cKa();
        if (cKa != null) {
            cKa.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cKa() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.kjj;
        this.kjj = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.kjj == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cJY() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.kdI == 90 || this.kdI == 270) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.kdI == 90 || this.kdI == 270) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int cKb() {
        return this.kdI;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cJZ() {
        return this.kjk;
    }
}
