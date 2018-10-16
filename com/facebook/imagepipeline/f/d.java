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
    private int iai;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> ifD;
    @Nullable
    private final i<FileInputStream> ifE;
    private com.facebook.c.c ifF;
    private int ifG;
    @Nullable
    private com.facebook.cache.common.b ifH;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.ifF = com.facebook.c.c.ibV;
        this.iai = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ifG = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.ifD = aVar.clone();
        this.ifE = null;
    }

    public d(i<FileInputStream> iVar) {
        this.ifF = com.facebook.c.c.ibV;
        this.iai = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ifG = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.ifD = null;
        this.ifE = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.ifG = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.bWx();
        }
        return null;
    }

    public d bWx() {
        d dVar;
        if (this.ifE != null) {
            dVar = new d(this.ifE, this.ifG);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ifD);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.ifD);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.ifD)) {
            z = this.ifE != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> bWy() {
        return com.facebook.common.references.a.b(this.ifD);
    }

    public InputStream getInputStream() {
        if (this.ifE != null) {
            return this.ifE.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ifD);
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
        this.ifF = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void xz(int i) {
        this.iai = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.ifH = bVar;
    }

    public com.facebook.c.c bWz() {
        return this.ifF;
    }

    public int bWw() {
        return this.iai;
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
        return this.ifH;
    }

    public boolean xA(int i) {
        if (this.ifF == com.facebook.c.b.ibM && this.ifE == null) {
            com.facebook.common.internal.g.checkNotNull(this.ifD);
            PooledByteBuffer pooledByteBuffer = this.ifD.get();
            return pooledByteBuffer.xd(i + (-2)) == -1 && pooledByteBuffer.xd(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.ifD == null || this.ifD.get() == null) ? this.ifG : this.ifD.get().size();
    }

    public void bWB() {
        Pair<Integer, Integer> bWD;
        com.facebook.c.c r = com.facebook.c.d.r(getInputStream());
        this.ifF = r;
        if (com.facebook.c.b.a(r)) {
            bWD = bWC();
        } else {
            bWD = bWD();
        }
        if (r == com.facebook.c.b.ibM && this.iai == -1) {
            if (bWD != null) {
                this.iai = com.facebook.d.b.xZ(com.facebook.d.b.v(getInputStream()));
                return;
            }
            return;
        }
        this.iai = 0;
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
        this.ifF = dVar.bWz();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.iai = dVar.bWw();
        this.mSampleSize = dVar.getSampleSize();
        this.ifG = dVar.getSize();
        this.ifH = dVar.bWA();
    }

    public static boolean d(d dVar) {
        return dVar.iai >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
