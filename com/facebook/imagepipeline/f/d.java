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
    private int jDt;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> jIU;
    @Nullable
    private final i<FileInputStream> jIV;
    private com.facebook.c.c jIW;
    private int jIX;
    @Nullable
    private com.facebook.cache.common.b jIY;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.jIW = com.facebook.c.c.jFm;
        this.jDt = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIX = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.jIU = aVar.clone();
        this.jIV = null;
    }

    public d(i<FileInputStream> iVar) {
        this.jIW = com.facebook.c.c.jFm;
        this.jDt = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIX = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.jIU = null;
        this.jIV = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.jIX = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cyL();
        }
        return null;
    }

    public d cyL() {
        d dVar;
        if (this.jIV != null) {
            dVar = new d(this.jIV, this.jIX);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIU);
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
        com.facebook.common.references.a.c(this.jIU);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.jIU)) {
            z = this.jIV != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cyM() {
        return com.facebook.common.references.a.b(this.jIU);
    }

    public InputStream getInputStream() {
        if (this.jIV != null) {
            return this.jIV.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIU);
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
        this.jIW = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Cr(int i) {
        this.jDt = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.jIY = bVar;
    }

    public com.facebook.c.c cyN() {
        return this.jIW;
    }

    public int cyK() {
        return this.jDt;
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
    public com.facebook.cache.common.b cyO() {
        return this.jIY;
    }

    public boolean Cs(int i) {
        if (this.jIW == com.facebook.c.b.jFd && this.jIV == null) {
            com.facebook.common.internal.g.checkNotNull(this.jIU);
            PooledByteBuffer pooledByteBuffer = this.jIU.get();
            return pooledByteBuffer.BV(i + (-2)) == -1 && pooledByteBuffer.BV(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.jIU == null || this.jIU.get() == null) ? this.jIX : this.jIU.get().size();
    }

    public void cyP() {
        Pair<Integer, Integer> cyR;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.jIW = u;
        if (com.facebook.c.b.a(u)) {
            cyR = cyQ();
        } else {
            cyR = cyR();
        }
        if (u == com.facebook.c.b.jFd && this.jDt == -1) {
            if (cyR != null) {
                this.jDt = com.facebook.d.b.CR(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jDt = 0;
    }

    private Pair<Integer, Integer> cyQ() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cyR() {
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
        this.jIW = dVar.cyN();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jDt = dVar.cyK();
        this.mSampleSize = dVar.getSampleSize();
        this.jIX = dVar.getSize();
        this.jIY = dVar.cyO();
    }

    public static boolean d(d dVar) {
        return dVar.jDt >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
