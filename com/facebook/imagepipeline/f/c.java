package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int ijg;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> ioy;
    private final g ioz;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.ioy = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.ioz = gVar;
        this.ijg = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.ioy = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.bTl());
        this.mBitmap = this.ioy.get();
        this.ioz = gVar;
        this.ijg = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> bXW = bXW();
        if (bXW != null) {
            bXW.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> bXW() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.ioy;
        this.ioy = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.ioy == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap bXU() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.ijg == 90 || this.ijg == 270) ? L(this.mBitmap) : K(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.ijg == 90 || this.ijg == 270) ? K(this.mBitmap) : L(this.mBitmap);
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

    public int bXX() {
        return this.ijg;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g bXV() {
        return this.ioz;
    }
}
