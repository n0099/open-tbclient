package com.facebook.imagepipeline.f;

import android.util.Pair;
import com.facebook.common.internal.i;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.h;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class d implements Closeable {
    private int imr;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> irK;
    @Nullable
    private final i<FileInputStream> irL;
    private com.facebook.c.c irM;
    private int irN;
    @Nullable
    private com.facebook.cache.common.b irO;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.irM = com.facebook.c.c.iof;
        this.imr = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.irN = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.irK = aVar.clone();
        this.irL = null;
    }

    public d(i<FileInputStream> iVar) {
        this.irM = com.facebook.c.c.iof;
        this.imr = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.irN = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.irK = null;
        this.irL = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.irN = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.bYO();
        }
        return null;
    }

    public d bYO() {
        d dVar;
        if (this.irL != null) {
            dVar = new d(this.irL, this.irN);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.irK);
            if (b == null) {
                dVar = null;
            } else {
                try {
                    dVar = new d(b);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
                }
            }
        }
        if (dVar != null) {
            dVar.c(this);
        }
        return dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.irK);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.irK)) {
            z = this.irL != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> bYP() {
        return com.facebook.common.references.a.b(this.irK);
    }

    public InputStream getInputStream() {
        if (this.irL != null) {
            return this.irL.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.irK);
        if (b != null) {
            try {
                return new h((PooledByteBuffer) b.get());
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
            }
        }
        return null;
    }

    public void c(com.facebook.c.c cVar) {
        this.irM = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void yC(int i) {
        this.imr = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.irO = bVar;
    }

    public com.facebook.c.c bYQ() {
        return this.irM;
    }

    public int bYN() {
        return this.imr;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    @Nullable
    public com.facebook.cache.common.b bYR() {
        return this.irO;
    }

    public boolean yD(int i) {
        if (this.irM == com.facebook.c.b.inW && this.irL == null) {
            com.facebook.common.internal.g.checkNotNull(this.irK);
            PooledByteBuffer pooledByteBuffer = this.irK.get();
            return pooledByteBuffer.yg(i + (-2)) == -1 && pooledByteBuffer.yg(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.irK == null || this.irK.get() == null) ? this.irN : this.irK.get().size();
    }

    public void bYS() {
        Pair<Integer, Integer> bYU;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.irM = s;
        if (com.facebook.c.b.a(s)) {
            bYU = bYT();
        } else {
            bYU = bYU();
        }
        if (s == com.facebook.c.b.inW && this.imr == -1) {
            if (bYU != null) {
                this.imr = com.facebook.d.b.zc(com.facebook.d.b.w(getInputStream()));
                return;
            }
            return;
        }
        this.imr = 0;
    }

    private Pair<Integer, Integer> bYT() {
        Pair<Integer, Integer> y = com.facebook.d.e.y(getInputStream());
        if (y != null) {
            this.mWidth = ((Integer) y.first).intValue();
            this.mHeight = ((Integer) y.second).intValue();
        }
        return y;
    }

    private Pair<Integer, Integer> bYU() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> v = com.facebook.d.a.v(inputStream);
            if (v != null) {
                this.mWidth = ((Integer) v.first).intValue();
                this.mHeight = ((Integer) v.second).intValue();
            }
            return v;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void c(d dVar) {
        this.irM = dVar.bYQ();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.imr = dVar.bYN();
        this.mSampleSize = dVar.getSampleSize();
        this.irN = dVar.getSize();
        this.irO = dVar.bYR();
    }

    public static boolean d(d dVar) {
        return dVar.imr >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
    }

    public static void e(@Nullable d dVar) {
        if (dVar != null) {
            dVar.close();
        }
    }

    public static boolean f(@Nullable d dVar) {
        return dVar != null && dVar.isValid();
    }
}
