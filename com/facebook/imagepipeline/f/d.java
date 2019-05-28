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
    private int jVv;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> kaV;
    @Nullable
    private final i<FileInputStream> kaW;
    private com.facebook.c.c kaX;
    private int kaY;
    @Nullable
    private com.facebook.cache.common.b kaZ;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.kaX = com.facebook.c.c.jXn;
        this.jVv = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kaY = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.kaV = aVar.clone();
        this.kaW = null;
    }

    public d(i<FileInputStream> iVar) {
        this.kaX = com.facebook.c.c.jXn;
        this.jVv = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kaY = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.kaV = null;
        this.kaW = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.kaY = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cGF();
        }
        return null;
    }

    public d cGF() {
        d dVar;
        if (this.kaW != null) {
            dVar = new d(this.kaW, this.kaY);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kaV);
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
        com.facebook.common.references.a.c(this.kaV);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.kaV)) {
            z = this.kaW != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cGG() {
        return com.facebook.common.references.a.b(this.kaV);
    }

    public InputStream getInputStream() {
        if (this.kaW != null) {
            return this.kaW.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kaV);
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
        this.kaX = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Dl(int i) {
        this.jVv = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.kaZ = bVar;
    }

    public com.facebook.c.c cGH() {
        return this.kaX;
    }

    public int cGE() {
        return this.jVv;
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
    public com.facebook.cache.common.b cGI() {
        return this.kaZ;
    }

    public boolean Dm(int i) {
        if (this.kaX == com.facebook.c.b.jXe && this.kaW == null) {
            com.facebook.common.internal.g.checkNotNull(this.kaV);
            PooledByteBuffer pooledByteBuffer = this.kaV.get();
            return pooledByteBuffer.CP(i + (-2)) == -1 && pooledByteBuffer.CP(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.kaV == null || this.kaV.get() == null) ? this.kaY : this.kaV.get().size();
    }

    public void cGJ() {
        Pair<Integer, Integer> cGL;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.kaX = u;
        if (com.facebook.c.b.a(u)) {
            cGL = cGK();
        } else {
            cGL = cGL();
        }
        if (u == com.facebook.c.b.jXe && this.jVv == -1) {
            if (cGL != null) {
                this.jVv = com.facebook.d.b.DL(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jVv = 0;
    }

    private Pair<Integer, Integer> cGK() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cGL() {
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
        this.kaX = dVar.cGH();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jVv = dVar.cGE();
        this.mSampleSize = dVar.getSampleSize();
        this.kaY = dVar.getSize();
        this.kaZ = dVar.cGI();
    }

    public static boolean d(d dVar) {
        return dVar.jVv >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
