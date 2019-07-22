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
    private int kcC;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> kif;
    @Nullable
    private final i<FileInputStream> kig;
    private com.facebook.c.c kih;
    private int kii;
    @Nullable
    private com.facebook.cache.common.b kij;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.kih = com.facebook.c.c.keu;
        this.kcC = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kii = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.kif = aVar.clone();
        this.kig = null;
    }

    public d(i<FileInputStream> iVar) {
        this.kih = com.facebook.c.c.keu;
        this.kcC = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kii = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.kif = null;
        this.kig = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.kii = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cJH();
        }
        return null;
    }

    public d cJH() {
        d dVar;
        if (this.kig != null) {
            dVar = new d(this.kig, this.kii);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kif);
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
        com.facebook.common.references.a.c(this.kif);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.kif)) {
            z = this.kig != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cJI() {
        return com.facebook.common.references.a.b(this.kif);
    }

    public InputStream getInputStream() {
        if (this.kig != null) {
            return this.kig.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kif);
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
        this.kih = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void DS(int i) {
        this.kcC = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.kij = bVar;
    }

    public com.facebook.c.c cJJ() {
        return this.kih;
    }

    public int cJG() {
        return this.kcC;
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
    public com.facebook.cache.common.b cJK() {
        return this.kij;
    }

    public boolean DT(int i) {
        if (this.kih == com.facebook.c.b.kel && this.kig == null) {
            com.facebook.common.internal.g.checkNotNull(this.kif);
            PooledByteBuffer pooledByteBuffer = this.kif.get();
            return pooledByteBuffer.Dw(i + (-2)) == -1 && pooledByteBuffer.Dw(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.kif == null || this.kif.get() == null) ? this.kii : this.kif.get().size();
    }

    public void cJL() {
        Pair<Integer, Integer> cJN;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.kih = u;
        if (com.facebook.c.b.a(u)) {
            cJN = cJM();
        } else {
            cJN = cJN();
        }
        if (u == com.facebook.c.b.kel && this.kcC == -1) {
            if (cJN != null) {
                this.kcC = com.facebook.d.b.Es(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.kcC = 0;
    }

    private Pair<Integer, Integer> cJM() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cJN() {
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
        this.kih = dVar.cJJ();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.kcC = dVar.cJG();
        this.mSampleSize = dVar.getSampleSize();
        this.kii = dVar.getSize();
        this.kij = dVar.cJK();
    }

    public static boolean d(d dVar) {
        return dVar.kcC >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
