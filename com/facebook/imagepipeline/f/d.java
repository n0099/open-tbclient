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
    private int jVu;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> kaU;
    @Nullable
    private final i<FileInputStream> kaV;
    private com.facebook.c.c kaW;
    private int kaX;
    @Nullable
    private com.facebook.cache.common.b kaY;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.kaW = com.facebook.c.c.jXm;
        this.jVu = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kaX = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.kaU = aVar.clone();
        this.kaV = null;
    }

    public d(i<FileInputStream> iVar) {
        this.kaW = com.facebook.c.c.jXm;
        this.jVu = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kaX = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.kaU = null;
        this.kaV = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.kaX = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cGD();
        }
        return null;
    }

    public d cGD() {
        d dVar;
        if (this.kaV != null) {
            dVar = new d(this.kaV, this.kaX);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kaU);
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
        com.facebook.common.references.a.c(this.kaU);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.kaU)) {
            z = this.kaV != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cGE() {
        return com.facebook.common.references.a.b(this.kaU);
    }

    public InputStream getInputStream() {
        if (this.kaV != null) {
            return this.kaV.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kaU);
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
        this.kaW = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Dl(int i) {
        this.jVu = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.kaY = bVar;
    }

    public com.facebook.c.c cGF() {
        return this.kaW;
    }

    public int cGC() {
        return this.jVu;
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
    public com.facebook.cache.common.b cGG() {
        return this.kaY;
    }

    public boolean Dm(int i) {
        if (this.kaW == com.facebook.c.b.jXd && this.kaV == null) {
            com.facebook.common.internal.g.checkNotNull(this.kaU);
            PooledByteBuffer pooledByteBuffer = this.kaU.get();
            return pooledByteBuffer.CP(i + (-2)) == -1 && pooledByteBuffer.CP(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.kaU == null || this.kaU.get() == null) ? this.kaX : this.kaU.get().size();
    }

    public void cGH() {
        Pair<Integer, Integer> cGJ;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.kaW = u;
        if (com.facebook.c.b.a(u)) {
            cGJ = cGI();
        } else {
            cGJ = cGJ();
        }
        if (u == com.facebook.c.b.jXd && this.jVu == -1) {
            if (cGJ != null) {
                this.jVu = com.facebook.d.b.DL(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jVu = 0;
    }

    private Pair<Integer, Integer> cGI() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cGJ() {
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
        this.kaW = dVar.cGF();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jVu = dVar.cGC();
        this.mSampleSize = dVar.getSampleSize();
        this.kaX = dVar.getSize();
        this.kaY = dVar.cGG();
    }

    public static boolean d(d dVar) {
        return dVar.jVu >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
