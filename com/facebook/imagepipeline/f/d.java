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
    private int jCF;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> jIg;
    @Nullable
    private final i<FileInputStream> jIh;
    private com.facebook.c.c jIi;
    private int jIj;
    @Nullable
    private com.facebook.cache.common.b jIk;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.jIi = com.facebook.c.c.jEy;
        this.jCF = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIj = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.jIg = aVar.clone();
        this.jIh = null;
    }

    public d(i<FileInputStream> iVar) {
        this.jIi = com.facebook.c.c.jEy;
        this.jCF = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIj = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.jIg = null;
        this.jIh = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.jIj = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cyH();
        }
        return null;
    }

    public d cyH() {
        d dVar;
        if (this.jIh != null) {
            dVar = new d(this.jIh, this.jIj);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIg);
            if (b == null) {
                dVar = null;
            } else {
                try {
                    dVar = new d(b);
                } finally {
                    com.facebook.common.references.a.c(b);
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
        com.facebook.common.references.a.c(this.jIg);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.jIg)) {
            z = this.jIh != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cyI() {
        return com.facebook.common.references.a.b(this.jIg);
    }

    public InputStream getInputStream() {
        if (this.jIh != null) {
            return this.jIh.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIg);
        if (b != null) {
            try {
                return new h((PooledByteBuffer) b.get());
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }
        return null;
    }

    public void c(com.facebook.c.c cVar) {
        this.jIi = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Ch(int i) {
        this.jCF = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.jIk = bVar;
    }

    public com.facebook.c.c cyJ() {
        return this.jIi;
    }

    public int cyG() {
        return this.jCF;
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
    public com.facebook.cache.common.b cyK() {
        return this.jIk;
    }

    public boolean Ci(int i) {
        if (this.jIi == com.facebook.c.b.jEp && this.jIh == null) {
            com.facebook.common.internal.g.checkNotNull(this.jIg);
            PooledByteBuffer pooledByteBuffer = this.jIg.get();
            return pooledByteBuffer.BL(i + (-2)) == -1 && pooledByteBuffer.BL(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.jIg == null || this.jIg.get() == null) ? this.jIj : this.jIg.get().size();
    }

    public void cyL() {
        Pair<Integer, Integer> cyN;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.jIi = u;
        if (com.facebook.c.b.a(u)) {
            cyN = cyM();
        } else {
            cyN = cyN();
        }
        if (u == com.facebook.c.b.jEp && this.jCF == -1) {
            if (cyN != null) {
                this.jCF = com.facebook.d.b.CH(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jCF = 0;
    }

    private Pair<Integer, Integer> cyM() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cyN() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> x = com.facebook.d.a.x(inputStream);
            if (x != null) {
                this.mWidth = ((Integer) x.first).intValue();
                this.mHeight = ((Integer) x.second).intValue();
            }
            return x;
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
        this.jIi = dVar.cyJ();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jCF = dVar.cyG();
        this.mSampleSize = dVar.getSampleSize();
        this.jIj = dVar.getSize();
        this.jIk = dVar.cyK();
    }

    public static boolean d(d dVar) {
        return dVar.jCF >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
