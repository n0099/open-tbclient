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
    private int inz;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> isR;
    @Nullable
    private final i<FileInputStream> isS;
    private com.facebook.c.c isT;
    private int isU;
    @Nullable
    private com.facebook.cache.common.b isV;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.isT = com.facebook.c.c.ipm;
        this.inz = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.isU = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.isR = aVar.clone();
        this.isS = null;
    }

    public d(i<FileInputStream> iVar) {
        this.isT = com.facebook.c.c.ipm;
        this.inz = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.isU = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.isR = null;
        this.isS = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.isU = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.bZw();
        }
        return null;
    }

    public d bZw() {
        d dVar;
        if (this.isS != null) {
            dVar = new d(this.isS, this.isU);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.isR);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.isR);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.isR)) {
            z = this.isS != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> bZx() {
        return com.facebook.common.references.a.b(this.isR);
    }

    public InputStream getInputStream() {
        if (this.isS != null) {
            return this.isS.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.isR);
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
        this.isT = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void yE(int i) {
        this.inz = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.isV = bVar;
    }

    public com.facebook.c.c bZy() {
        return this.isT;
    }

    public int bZv() {
        return this.inz;
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
    public com.facebook.cache.common.b bZz() {
        return this.isV;
    }

    public boolean yF(int i) {
        if (this.isT == com.facebook.c.b.ipd && this.isS == null) {
            com.facebook.common.internal.g.checkNotNull(this.isR);
            PooledByteBuffer pooledByteBuffer = this.isR.get();
            return pooledByteBuffer.yi(i + (-2)) == -1 && pooledByteBuffer.yi(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.isR == null || this.isR.get() == null) ? this.isU : this.isR.get().size();
    }

    public void bZA() {
        Pair<Integer, Integer> bZC;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.isT = s;
        if (com.facebook.c.b.a(s)) {
            bZC = bZB();
        } else {
            bZC = bZC();
        }
        if (s == com.facebook.c.b.ipd && this.inz == -1) {
            if (bZC != null) {
                this.inz = com.facebook.d.b.ze(com.facebook.d.b.w(getInputStream()));
                return;
            }
            return;
        }
        this.inz = 0;
    }

    private Pair<Integer, Integer> bZB() {
        Pair<Integer, Integer> y = com.facebook.d.e.y(getInputStream());
        if (y != null) {
            this.mWidth = ((Integer) y.first).intValue();
            this.mHeight = ((Integer) y.second).intValue();
        }
        return y;
    }

    private Pair<Integer, Integer> bZC() {
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
        this.isT = dVar.bZy();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.inz = dVar.bZv();
        this.mSampleSize = dVar.getSampleSize();
        this.isU = dVar.getSize();
        this.isV = dVar.bZz();
    }

    public static boolean d(d dVar) {
        return dVar.inz >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
