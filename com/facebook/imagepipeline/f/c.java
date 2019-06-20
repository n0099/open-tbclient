package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int jVy;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> kaW;
    private final g kaX;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.kaW = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.kaX = gVar;
        this.jVy = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.kaW = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cBL());
        this.mBitmap = this.kaW.get();
        this.kaX = gVar;
        this.jVy = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cGC = cGC();
        if (cGC != null) {
            cGC.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cGC() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.kaW;
        this.kaW = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.kaW == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cGA() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.jVy == 90 || this.jVy == 270) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.jVy == 90 || this.jVy == 270) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int cGD() {
        return this.jVy;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cGB() {
        return this.kaX;
    }
}
