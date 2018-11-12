package com.facebook.imagepipeline.f;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c extends a {
    private final int ibT;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> ihm;
    private final g ihn;
    private volatile Bitmap mBitmap;

    public c(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, g gVar, int i) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.ihm = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.ihn = gVar;
        this.ibT = i;
    }

    public c(com.facebook.common.references.a<Bitmap> aVar, g gVar, int i) {
        this.ihm = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.bRf());
        this.mBitmap = this.ihm.get();
        this.ihn = gVar;
        this.ibT = i;
    }

    @Override // com.facebook.imagepipeline.f.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> bVQ = bVQ();
        if (bVQ != null) {
            bVQ.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> bVQ() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.ihm;
        this.ihm = null;
        this.mBitmap = null;
        return aVar;
    }

    @Override // com.facebook.imagepipeline.f.b
    public synchronized boolean isClosed() {
        return this.ihm == null;
    }

    @Override // com.facebook.imagepipeline.f.a
    public Bitmap bVO() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.f.b
    public int getSizeInBytes() {
        return com.facebook.d.a.T(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getWidth() {
        return (this.ibT == 90 || this.ibT == 270) ? L(this.mBitmap) : K(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.f.e
    public int getHeight() {
        return (this.ibT == 90 || this.ibT == 270) ? K(this.mBitmap) : L(this.mBitmap);
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

    public int bVR() {
        return this.ibT;
    }

    @Override // com.facebook.imagepipeline.f.b
    public g bVP() {
        return this.ihn;
    }
}
