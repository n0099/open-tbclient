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
    private int jDa;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> jIB;
    @Nullable
    private final i<FileInputStream> jIC;
    private com.facebook.c.c jID;
    private int jIE;
    @Nullable
    private com.facebook.cache.common.b jIF;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.jID = com.facebook.c.c.jET;
        this.jDa = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIE = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.jIB = aVar.clone();
        this.jIC = null;
    }

    public d(i<FileInputStream> iVar) {
        this.jID = com.facebook.c.c.jET;
        this.jDa = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.jIE = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.jIB = null;
        this.jIC = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.jIE = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cyB();
        }
        return null;
    }

    public d cyB() {
        d dVar;
        if (this.jIC != null) {
            dVar = new d(this.jIC, this.jIE);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIB);
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
        com.facebook.common.references.a.c(this.jIB);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.jIB)) {
            z = this.jIC != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cyC() {
        return com.facebook.common.references.a.b(this.jIB);
    }

    public InputStream getInputStream() {
        if (this.jIC != null) {
            return this.jIC.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.jIB);
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
        this.jID = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Cq(int i) {
        this.jDa = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.jIF = bVar;
    }

    public com.facebook.c.c cyD() {
        return this.jID;
    }

    public int cyA() {
        return this.jDa;
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
    public com.facebook.cache.common.b cyE() {
        return this.jIF;
    }

    public boolean Cr(int i) {
        if (this.jID == com.facebook.c.b.jEK && this.jIC == null) {
            com.facebook.common.internal.g.checkNotNull(this.jIB);
            PooledByteBuffer pooledByteBuffer = this.jIB.get();
            return pooledByteBuffer.BU(i + (-2)) == -1 && pooledByteBuffer.BU(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.jIB == null || this.jIB.get() == null) ? this.jIE : this.jIB.get().size();
    }

    public void cyF() {
        Pair<Integer, Integer> cyH;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.jID = u;
        if (com.facebook.c.b.a(u)) {
            cyH = cyG();
        } else {
            cyH = cyH();
        }
        if (u == com.facebook.c.b.jEK && this.jDa == -1) {
            if (cyH != null) {
                this.jDa = com.facebook.d.b.CQ(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.jDa = 0;
    }

    private Pair<Integer, Integer> cyG() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cyH() {
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
        this.jID = dVar.cyD();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.jDa = dVar.cyA();
        this.mSampleSize = dVar.getSampleSize();
        this.jIE = dVar.getSize();
        this.jIF = dVar.cyE();
    }

    public static boolean d(d dVar) {
        return dVar.jDa >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
