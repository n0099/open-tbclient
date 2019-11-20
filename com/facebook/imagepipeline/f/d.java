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
    private int abp;
    private int kdx;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> kjd;
    @Nullable
    private final i<FileInputStream> kje;
    private com.facebook.c.c kjf;
    private int kjg;
    @Nullable
    private com.facebook.cache.common.b kjh;
    private int mHeight;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.kjf = com.facebook.c.c.kfs;
        this.kdx = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.abp = 1;
        this.kjg = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.kjd = aVar.clone();
        this.kje = null;
    }

    public d(i<FileInputStream> iVar) {
        this.kjf = com.facebook.c.c.kfs;
        this.kdx = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.abp = 1;
        this.kjg = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.kjd = null;
        this.kje = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.kjg = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cHL();
        }
        return null;
    }

    public d cHL() {
        d dVar;
        if (this.kje != null) {
            dVar = new d(this.kje, this.kjg);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kjd);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.kjd);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.kjd)) {
            z = this.kje != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cHM() {
        return com.facebook.common.references.a.b(this.kjd);
    }

    public InputStream getInputStream() {
        if (this.kje != null) {
            return this.kje.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kjd);
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
        this.kjf = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Ct(int i) {
        this.kdx = i;
    }

    public void setSampleSize(int i) {
        this.abp = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.kjh = bVar;
    }

    public com.facebook.c.c cHN() {
        return this.kjf;
    }

    public int cHK() {
        return this.kdx;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.abp;
    }

    @Nullable
    public com.facebook.cache.common.b cHO() {
        return this.kjh;
    }

    public boolean Cu(int i) {
        if (this.kjf == com.facebook.c.b.kfj && this.kje == null) {
            com.facebook.common.internal.g.checkNotNull(this.kjd);
            PooledByteBuffer pooledByteBuffer = this.kjd.get();
            return pooledByteBuffer.BX(i + (-2)) == -1 && pooledByteBuffer.BX(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.kjd == null || this.kjd.get() == null) ? this.kjg : this.kjd.get().size();
    }

    public void cHP() {
        Pair<Integer, Integer> cHR;
        com.facebook.c.c r = com.facebook.c.d.r(getInputStream());
        this.kjf = r;
        if (com.facebook.c.b.a(r)) {
            cHR = cHQ();
        } else {
            cHR = cHR();
        }
        if (r == com.facebook.c.b.kfj && this.kdx == -1) {
            if (cHR != null) {
                this.kdx = com.facebook.d.b.CT(com.facebook.d.b.v(getInputStream()));
                return;
            }
            return;
        }
        this.kdx = 0;
    }

    private Pair<Integer, Integer> cHQ() {
        Pair<Integer, Integer> x = com.facebook.d.e.x(getInputStream());
        if (x != null) {
            this.mWidth = ((Integer) x.first).intValue();
            this.mHeight = ((Integer) x.second).intValue();
        }
        return x;
    }

    private Pair<Integer, Integer> cHR() {
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
        this.kjf = dVar.cHN();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.kdx = dVar.cHK();
        this.abp = dVar.getSampleSize();
        this.kjg = dVar.getSize();
        this.kjh = dVar.cHO();
    }

    public static boolean d(d dVar) {
        return dVar.kdx >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
