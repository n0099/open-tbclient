package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int jVu;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> kaS;
    private final g kaT;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.kaS = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.kaT = gVar;
        this.jVu = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.kaS = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cBK());
        this.mBitmap = this.kaS.get();
        this.kaT = gVar;
        this.jVu = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cGB = cGB();
        if (cGB != null) {
            cGB.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cGB() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.kaS;
        this.kaS = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.kaS == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cGz() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.ac(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.jVu == 90 || this.jVu == 270) ? U(this.mBitmap) : T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.jVu == 90 || this.jVu == 270) ? T(this.mBitmap) : U(this.mBitmap);
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

    public int cGC() {
        return this.jVu;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cGA() {
        return this.kaT;
    }
}
