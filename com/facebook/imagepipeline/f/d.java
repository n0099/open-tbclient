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
    private int inA;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> isS;
    @Nullable
    private final i<FileInputStream> isT;
    private com.facebook.c.c isU;
    private int isV;
    @Nullable
    private com.facebook.cache.common.b isW;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.isU = com.facebook.c.c.ipn;
        this.inA = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.isV = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.isS = aVar.clone();
        this.isT = null;
    }

    public d(i<FileInputStream> iVar) {
        this.isU = com.facebook.c.c.ipn;
        this.inA = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.isV = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.isS = null;
        this.isT = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.isV = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.bZw();
        }
        return null;
    }

    public d bZw() {
        d dVar;
        if (this.isT != null) {
            dVar = new d(this.isT, this.isV);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.isS);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.isS);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.isS)) {
            z = this.isT != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> bZx() {
        return com.facebook.common.references.a.b(this.isS);
    }

    public InputStream getInputStream() {
        if (this.isT != null) {
            return this.isT.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.isS);
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
        this.isU = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void yE(int i) {
        this.inA = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.isW = bVar;
    }

    public com.facebook.c.c bZy() {
        return this.isU;
    }

    public int bZv() {
        return this.inA;
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
        return this.isW;
    }

    public boolean yF(int i) {
        if (this.isU == com.facebook.c.b.ipe && this.isT == null) {
            com.facebook.common.internal.g.checkNotNull(this.isS);
            PooledByteBuffer pooledByteBuffer = this.isS.get();
            return pooledByteBuffer.yi(i + (-2)) == -1 && pooledByteBuffer.yi(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.isS == null || this.isS.get() == null) ? this.isV : this.isS.get().size();
    }

    public void bZA() {
        Pair<Integer, Integer> bZC;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.isU = s;
        if (com.facebook.c.b.a(s)) {
            bZC = bZB();
        } else {
            bZC = bZC();
        }
        if (s == com.facebook.c.b.ipe && this.inA == -1) {
            if (bZC != null) {
                this.inA = com.facebook.d.b.ze(com.facebook.d.b.w(getInputStream()));
                return;
            }
            return;
        }
        this.inA = 0;
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
        this.isU = dVar.bZy();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.inA = dVar.bZv();
        this.mSampleSize = dVar.getSampleSize();
        this.isV = dVar.getSize();
        this.isW = dVar.bZz();
    }

    public static boolean d(d dVar) {
        return dVar.inA >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
