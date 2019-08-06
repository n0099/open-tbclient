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
    private int kdI;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> kjl;
    @Nullable
    private final i<FileInputStream> kjm;
    private com.facebook.c.c kjn;
    private int kjo;
    @Nullable
    private com.facebook.cache.common.b kjp;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.kjn = com.facebook.c.c.kfB;
        this.kdI = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kjo = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.kjl = aVar.clone();
        this.kjm = null;
    }

    public d(i<FileInputStream> iVar) {
        this.kjn = com.facebook.c.c.kfB;
        this.kdI = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.kjo = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.kjl = null;
        this.kjm = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.kjo = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cKc();
        }
        return null;
    }

    public d cKc() {
        d dVar;
        if (this.kjm != null) {
            dVar = new d(this.kjm, this.kjo);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kjl);
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
        com.facebook.common.references.a.c(this.kjl);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.kjl)) {
            z = this.kjm != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cKd() {
        return com.facebook.common.references.a.b(this.kjl);
    }

    public InputStream getInputStream() {
        if (this.kjm != null) {
            return this.kjm.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kjl);
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
        this.kjn = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void DU(int i) {
        this.kdI = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.kjp = bVar;
    }

    public com.facebook.c.c cKe() {
        return this.kjn;
    }

    public int cKb() {
        return this.kdI;
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
    public com.facebook.cache.common.b cKf() {
        return this.kjp;
    }

    public boolean DV(int i) {
        if (this.kjn == com.facebook.c.b.kfs && this.kjm == null) {
            com.facebook.common.internal.g.checkNotNull(this.kjl);
            PooledByteBuffer pooledByteBuffer = this.kjl.get();
            return pooledByteBuffer.Dy(i + (-2)) == -1 && pooledByteBuffer.Dy(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.kjl == null || this.kjl.get() == null) ? this.kjo : this.kjl.get().size();
    }

    public void cKg() {
        Pair<Integer, Integer> cKi;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.kjn = u;
        if (com.facebook.c.b.a(u)) {
            cKi = cKh();
        } else {
            cKi = cKi();
        }
        if (u == com.facebook.c.b.kfs && this.kdI == -1) {
            if (cKi != null) {
                this.kdI = com.facebook.d.b.Eu(com.facebook.d.b.y(getInputStream()));
                return;
            }
            return;
        }
        this.kdI = 0;
    }

    private Pair<Integer, Integer> cKh() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> cKi() {
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
        this.kjn = dVar.cKe();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.kdI = dVar.cKb();
        this.mSampleSize = dVar.getSampleSize();
        this.kjo = dVar.getSize();
        this.kjp = dVar.cKf();
    }

    public static boolean d(d dVar) {
        return dVar.kdI >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
