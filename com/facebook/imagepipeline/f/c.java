package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int keo;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> kjS;
    private final g kjT;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.kjS = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.kjT = gVar;
        this.keo = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.kjS = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.cCT());
        this.mBitmap = this.kjS.get();
        this.kjT = gVar;
        this.keo = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> cHL = cHL();
        if (cHL != null) {
            cHL.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> cHL() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.kjS;
        this.kjS = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.kjS == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap cHJ() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.aa(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.keo == 90 || this.keo == 270) ? S(this.mBitmap) : R(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.keo == 90 || this.keo == 270) ? R(this.mBitmap) : S(this.mBitmap);
    }

    private static int R(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int S(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int cHM() {
        return this.keo;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g cHK() {
        return this.kjT;
    }
}
