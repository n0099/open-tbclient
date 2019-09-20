package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int kgg;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> klG;
    private final g klH;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.klG = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.klH = gVar;
        this.kgg = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.klG = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cFV());
        this.mBitmap = this.klG.get();
        this.klH = gVar;
        this.kgg = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cKO = cKO();
        if (cKO != null) {
            cKO.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cKO() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.klG;
        this.klG = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.klG == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cKM() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.kgg == 90 || this.kgg == 270) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.kgg == 90 || this.kgg == 270) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int cKP() {
        return this.kgg;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cKN() {
        return this.klH;
    }
}
