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
    private int jCG;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> jIh;
    @Nullable
    private final i<FileInputStream> jIi;
    private com.facebook.c.c jIj;
    private int jIk;
    @Nullable
    private com.facebook.cache.common.b jIl;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.jIj = com.facebook.c.c.jEz;
        this.jCG = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIk = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.jIh = aVar.clone();
        this.jIi = null;
    }

    public d(i<FileInputStream> iVar) {
        this.jIj = com.facebook.c.c.jEz;
        this.jCG = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIk = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.jIh = null;
        this.jIi = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.jIk = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cyH();
        }
        return null;
    }

    public d cyH() {
        d dVar;
        if (this.jIi != null) {
            dVar = new d(this.jIi, this.jIk);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIh);
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
        com.facebook.common.references.a.c(this.jIh);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.jIh)) {
            z = this.jIi != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cyI() {
        return com.facebook.common.references.a.b(this.jIh);
    }

    public InputStream getInputStream() {
        if (this.jIi != null) {
            return this.jIi.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIh);
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
        this.jIj = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Ch(int i) {
        this.jCG = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.jIl = bVar;
    }

    public com.facebook.c.c cyJ() {
        return this.jIj;
    }

    public int cyG() {
        return this.jCG;
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
        return this.jIl;
    }

    public boolean Ci(int i) {
        if (this.jIj == com.facebook.c.b.jEq && this.jIi == null) {
            com.facebook.common.internal.g.checkNotNull(this.jIh);
            PooledByteBuffer pooledByteBuffer = this.jIh.get();
            return pooledByteBuffer.BL(i + (-2)) == -1 && pooledByteBuffer.BL(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.jIh == null || this.jIh.get() == null) ? this.jIk : this.jIh.get().size();
    }

    public void cyL() {
        Pair<Integer, Integer> cyN;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.jIj = u;
        if (com.facebook.c.b.a(u)) {
            cyN = cyM();
        } else {
            cyN = cyN();
        }
        if (u == com.facebook.c.b.jEq && this.jCG == -1) {
            if (cyN != null) {
                this.jCG = com.facebook.d.b.CH(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jCG = 0;
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
        this.jIj = dVar.cyJ();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jCG = dVar.cyG();
        this.mSampleSize = dVar.getSampleSize();
        this.jIk = dVar.getSize();
        this.jIl = dVar.cyK();
    }

    public static boolean d(d dVar) {
        return dVar.jCG >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
