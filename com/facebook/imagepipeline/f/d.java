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
    private int iaj;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> ifE;
    @Nullable
    private final i<FileInputStream> ifF;
    private com.facebook.c.c ifG;
    private int ifH;
    @Nullable
    private com.facebook.cache.common.b ifI;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.ifG = com.facebook.c.c.ibW;
        this.iaj = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ifH = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.ifE = aVar.clone();
        this.ifF = null;
    }

    public d(i<FileInputStream> iVar) {
        this.ifG = com.facebook.c.c.ibW;
        this.iaj = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ifH = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.ifE = null;
        this.ifF = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.ifH = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.bWx();
        }
        return null;
    }

    public d bWx() {
        d dVar;
        if (this.ifF != null) {
            dVar = new d(this.ifF, this.ifH);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ifE);
            if (b == null) {
                dVar = null;
            } else {
                try {
                    dVar = new d(b);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.ifE);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.ifE)) {
            z = this.ifF != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> bWy() {
        return com.facebook.common.references.a.b(this.ifE);
    }

    public InputStream getInputStream() {
        if (this.ifF != null) {
            return this.ifF.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ifE);
        if (b != null) {
            try {
                return new h((PooledByteBuffer) b.get());
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
            }
        }
        return null;
    }

    public void c(com.facebook.c.c cVar) {
        this.ifG = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void xz(int i) {
        this.iaj = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.ifI = bVar;
    }

    public com.facebook.c.c bWz() {
        return this.ifG;
    }

    public int bWw() {
        return this.iaj;
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
    public com.facebook.cache.common.b bWA() {
        return this.ifI;
    }

    public boolean xA(int i) {
        if (this.ifG == com.facebook.c.b.ibN && this.ifF == null) {
            com.facebook.common.internal.g.checkNotNull(this.ifE);
            PooledByteBuffer pooledByteBuffer = this.ifE.get();
            return pooledByteBuffer.xd(i + (-2)) == -1 && pooledByteBuffer.xd(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.ifE == null || this.ifE.get() == null) ? this.ifH : this.ifE.get().size();
    }

    public void bWB() {
        Pair<Integer, Integer> bWD;
        com.facebook.c.c r = com.facebook.c.d.r(getInputStream());
        this.ifG = r;
        if (com.facebook.c.b.a(r)) {
            bWD = bWC();
        } else {
            bWD = bWD();
        }
        if (r == com.facebook.c.b.ibN && this.iaj == -1) {
            if (bWD != null) {
                this.iaj = com.facebook.d.b.xZ(com.facebook.d.b.v(getInputStream()));
                return;
            }
            return;
        }
        this.iaj = 0;
    }

    private Pair<Integer, Integer> bWC() {
        Pair<Integer, Integer> x = com.facebook.d.e.x(getInputStream());
        if (x != null) {
            this.mWidth = ((Integer) x.first).intValue();
            this.mHeight = ((Integer) x.second).intValue();
        }
        return x;
    }

    private Pair<Integer, Integer> bWD() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> u = com.facebook.d.a.u(inputStream);
            if (u != null) {
                this.mWidth = ((Integer) u.first).intValue();
                this.mHeight = ((Integer) u.second).intValue();
            }
            return u;
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
        this.ifG = dVar.bWz();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.iaj = dVar.bWw();
        this.mSampleSize = dVar.getSampleSize();
        this.ifH = dVar.getSize();
        this.ifI = dVar.bWA();
    }

    public static boolean d(d dVar) {
        return dVar.iaj >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
