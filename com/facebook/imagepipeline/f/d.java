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
    private int jDl;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> jIM;
    @Nullable
    private final i<FileInputStream> jIN;
    private com.facebook.c.c jIO;
    private int jIP;
    @Nullable
    private com.facebook.cache.common.b jIQ;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.jIO = com.facebook.c.c.jFe;
        this.jDl = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIP = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.jIM = aVar.clone();
        this.jIN = null;
    }

    public d(i<FileInputStream> iVar) {
        this.jIO = com.facebook.c.c.jFe;
        this.jDl = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIP = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.jIM = null;
        this.jIN = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.jIP = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cyO();
        }
        return null;
    }

    public d cyO() {
        d dVar;
        if (this.jIN != null) {
            dVar = new d(this.jIN, this.jIP);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIM);
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
        com.facebook.common.references.a.c(this.jIM);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.jIM)) {
            z = this.jIN != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cyP() {
        return com.facebook.common.references.a.b(this.jIM);
    }

    public InputStream getInputStream() {
        if (this.jIN != null) {
            return this.jIN.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIM);
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
        this.jIO = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Cr(int i) {
        this.jDl = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.jIQ = bVar;
    }

    public com.facebook.c.c cyQ() {
        return this.jIO;
    }

    public int cyN() {
        return this.jDl;
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
    public com.facebook.cache.common.b cyR() {
        return this.jIQ;
    }

    public boolean Cs(int i) {
        if (this.jIO == com.facebook.c.b.jEV && this.jIN == null) {
            com.facebook.common.internal.g.checkNotNull(this.jIM);
            PooledByteBuffer pooledByteBuffer = this.jIM.get();
            return pooledByteBuffer.BV(i + (-2)) == -1 && pooledByteBuffer.BV(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.jIM == null || this.jIM.get() == null) ? this.jIP : this.jIM.get().size();
    }

    public void cyS() {
        Pair<Integer, Integer> cyU;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.jIO = u;
        if (com.facebook.c.b.a(u)) {
            cyU = cyT();
        } else {
            cyU = cyU();
        }
        if (u == com.facebook.c.b.jEV && this.jDl == -1) {
            if (cyU != null) {
                this.jDl = com.facebook.d.b.CR(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jDl = 0;
    }

    private Pair<Integer, Integer> cyT() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cyU() {
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
        this.jIO = dVar.cyQ();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jDl = dVar.cyN();
        this.mSampleSize = dVar.getSampleSize();
        this.jIP = dVar.getSize();
        this.jIQ = dVar.cyR();
    }

    public static boolean d(d dVar) {
        return dVar.jDl >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
