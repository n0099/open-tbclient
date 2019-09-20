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
    private int kgg;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> klI;
    @Nullable
    private final i<FileInputStream> klJ;
    private com.facebook.c.c klK;
    private int klL;
    @Nullable
    private com.facebook.cache.common.b klM;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.klK = com.facebook.c.c.khY;
        this.kgg = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.klL = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.klI = aVar.clone();
        this.klJ = null;
    }

    public d(i<FileInputStream> iVar) {
        this.klK = com.facebook.c.c.khY;
        this.kgg = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.klL = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.klI = null;
        this.klJ = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.klL = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cKQ();
        }
        return null;
    }

    public d cKQ() {
        d dVar;
        if (this.klJ != null) {
            dVar = new d(this.klJ, this.klL);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.klI);
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
        com.facebook.common.references.a.c(this.klI);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.klI)) {
            z = this.klJ != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cKR() {
        return com.facebook.common.references.a.b(this.klI);
    }

    public InputStream getInputStream() {
        if (this.klJ != null) {
            return this.klJ.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.klI);
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
        this.klK = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void DY(int i) {
        this.kgg = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.klM = bVar;
    }

    public com.facebook.c.c cKS() {
        return this.klK;
    }

    public int cKP() {
        return this.kgg;
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
    public com.facebook.cache.common.b cKT() {
        return this.klM;
    }

    public boolean DZ(int i) {
        if (this.klK == com.facebook.c.b.khP && this.klJ == null) {
            com.facebook.common.internal.g.checkNotNull(this.klI);
            PooledByteBuffer pooledByteBuffer = this.klI.get();
            return pooledByteBuffer.DC(i + (-2)) == -1 && pooledByteBuffer.DC(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.klI == null || this.klI.get() == null) ? this.klL : this.klI.get().size();
    }

    public void cKU() {
        Pair<Integer, Integer> cKW;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.klK = u;
        if (com.facebook.c.b.a(u)) {
            cKW = cKV();
        } else {
            cKW = cKW();
        }
        if (u == com.facebook.c.b.khP && this.kgg == -1) {
            if (cKW != null) {
                this.kgg = com.facebook.d.b.Ey(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.kgg = 0;
    }

    private Pair<Integer, Integer> cKV() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cKW() {
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
        this.klK = dVar.cKS();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.kgg = dVar.cKP();
        this.mSampleSize = dVar.getSampleSize();
        this.klL = dVar.getSize();
        this.klM = dVar.cKT();
    }

    public static boolean d(d dVar) {
        return dVar.kgg >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
