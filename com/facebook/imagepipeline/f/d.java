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
    private int jVy;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> kaY;
    @Nullable
    private final i<FileInputStream> kaZ;
    private com.facebook.c.c kba;
    private int kbb;
    @Nullable
    private com.facebook.cache.common.b kbc;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.kba = com.facebook.c.c.jXq;
        this.jVy = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kbb = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.kaY = aVar.clone();
        this.kaZ = null;
    }

    public d(i<FileInputStream> iVar) {
        this.kba = com.facebook.c.c.jXq;
        this.jVy = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kbb = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.kaY = null;
        this.kaZ = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.kbb = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cGE();
        }
        return null;
    }

    public d cGE() {
        d dVar;
        if (this.kaZ != null) {
            dVar = new d(this.kaZ, this.kbb);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kaY);
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
        com.facebook.common.references.a.c(this.kaY);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.kaY)) {
            z = this.kaZ != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cGF() {
        return com.facebook.common.references.a.b(this.kaY);
    }

    public InputStream getInputStream() {
        if (this.kaZ != null) {
            return this.kaZ.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kaY);
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
        this.kba = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Dl(int i) {
        this.jVy = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.kbc = bVar;
    }

    public com.facebook.c.c cGG() {
        return this.kba;
    }

    public int cGD() {
        return this.jVy;
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
    public com.facebook.cache.common.b cGH() {
        return this.kbc;
    }

    public boolean Dm(int i) {
        if (this.kba == com.facebook.c.b.jXh && this.kaZ == null) {
            com.facebook.common.internal.g.checkNotNull(this.kaY);
            PooledByteBuffer pooledByteBuffer = this.kaY.get();
            return pooledByteBuffer.CP(i + (-2)) == -1 && pooledByteBuffer.CP(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.kaY == null || this.kaY.get() == null) ? this.kbb : this.kaY.get().size();
    }

    public void cGI() {
        Pair<Integer, Integer> cGK;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.kba = u;
        if (com.facebook.c.b.a(u)) {
            cGK = cGJ();
        } else {
            cGK = cGK();
        }
        if (u == com.facebook.c.b.jXh && this.jVy == -1) {
            if (cGK != null) {
                this.jVy = com.facebook.d.b.DL(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jVy = 0;
    }

    private Pair<Integer, Integer> cGJ() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cGK() {
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
        this.kba = dVar.cGG();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jVy = dVar.cGD();
        this.mSampleSize = dVar.getSampleSize();
        this.kbb = dVar.getSize();
        this.kbc = dVar.cGH();
    }

    public static boolean d(d dVar) {
        return dVar.jVy >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
