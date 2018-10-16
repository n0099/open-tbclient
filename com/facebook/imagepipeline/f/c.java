package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int iai;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> ifB;
    private final g ifC;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.ifB = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.ifC = gVar;
        this.iai = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.ifB = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.bRK());
        this.mBitmap = this.ifB.get();
        this.ifC = gVar;
        this.iai = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> bWv = bWv();
        if (bWv != null) {
            bWv.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> bWv() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.ifB;
        this.ifB = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.ifB == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap bWt() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.iai == 90 || this.iai == 270) ? L(this.mBitmap) : K(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.iai == 90 || this.iai == 270) ? K(this.mBitmap) : L(this.mBitmap);
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

    public int bWw() {
        return this.iai;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g bWu() {
        return this.ifC;
    }
}
