package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private volatile Bitmap mBitmap;
    private final int mqC;
    private final int mqD;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> myw;
    private final h myx;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.myw = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.myx = hVar;
        this.mqC = i;
        this.mqD = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.myw = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.duP());
        this.mBitmap = this.myw.get();
        this.myx = hVar;
        this.mqC = i;
        this.mqD = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dAt = dAt();
        if (dAt != null) {
            dAt.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dAt() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.myw;
        this.myw = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dAu() {
        return com.facebook.common.references.a.b(this.myw);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.myw == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dAr() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ag(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.mqC % 180 != 0 || this.mqD == 5 || this.mqD == 7) ? X(this.mBitmap) : W(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.mqC % 180 != 0 || this.mqD == 5 || this.mqD == 7) ? W(this.mBitmap) : X(this.mBitmap);
    }

    private static int W(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int X(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int dAv() {
        return this.mqC;
    }

    public int dAw() {
        return this.mqD;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dAs() {
        return this.myx;
    }
}
