package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d extends b {
    private final int lVA;
    private final int lVz;
    private volatile Bitmap mBitmap;
    @GuardedBy("this")
    private com.facebook.common.references.a<Bitmap> mdv;
    private final h mdw;

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i) {
        this(bitmap, cVar, hVar, i, 0);
    }

    public d(Bitmap bitmap, com.facebook.common.references.c<Bitmap> cVar, h hVar, int i, int i2) {
        this.mBitmap = (Bitmap) com.facebook.common.internal.g.checkNotNull(bitmap);
        this.mdv = com.facebook.common.references.a.a(this.mBitmap, (com.facebook.common.references.c) com.facebook.common.internal.g.checkNotNull(cVar));
        this.mdw = hVar;
        this.lVz = i;
        this.lVA = i2;
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i) {
        this(aVar, hVar, i, 0);
    }

    public d(com.facebook.common.references.a<Bitmap> aVar, h hVar, int i, int i2) {
        this.mdv = (com.facebook.common.references.a) com.facebook.common.internal.g.checkNotNull(aVar.dnh());
        this.mBitmap = this.mdv.get();
        this.mdw = hVar;
        this.lVz = i;
        this.lVA = i2;
    }

    @Override // com.facebook.imagepipeline.g.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a<Bitmap> dsM = dsM();
        if (dsM != null) {
            dsM.close();
        }
    }

    private synchronized com.facebook.common.references.a<Bitmap> dsM() {
        com.facebook.common.references.a<Bitmap> aVar;
        aVar = this.mdv;
        this.mdv = null;
        this.mBitmap = null;
        return aVar;
    }

    @Nullable
    public synchronized com.facebook.common.references.a<Bitmap> dsN() {
        return com.facebook.common.references.a.b(this.mdv);
    }

    @Override // com.facebook.imagepipeline.g.c
    public synchronized boolean isClosed() {
        return this.mdv == null;
    }

    @Override // com.facebook.imagepipeline.g.b
    public Bitmap dsK() {
        return this.mBitmap;
    }

    @Override // com.facebook.imagepipeline.g.c
    public int getSizeInBytes() {
        return com.facebook.d.a.ae(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getWidth() {
        return (this.lVz % 180 != 0 || this.lVA == 5 || this.lVA == 7) ? V(this.mBitmap) : U(this.mBitmap);
    }

    @Override // com.facebook.imagepipeline.g.f
    public int getHeight() {
        return (this.lVz % 180 != 0 || this.lVA == 5 || this.lVA == 7) ? U(this.mBitmap) : V(this.mBitmap);
    }

    private static int U(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int V(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int dsO() {
        return this.lVz;
    }

    public int dsP() {
        return this.lVA;
    }

    @Override // com.facebook.imagepipeline.g.c
    public h dsL() {
        return this.mdw;
    }
}
