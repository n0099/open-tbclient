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
    private int abI;
    private int keo;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> kjU;
    @Nullable
    private final i<FileInputStream> kjV;
    private com.facebook.c.c kjW;
    private int kjX;
    @Nullable
    private com.facebook.cache.common.b kjY;
    private int mHeight;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.kjW = com.facebook.c.c.kgj;
        this.keo = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.abI = 1;
        this.kjX = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.kjU = aVar.clone();
        this.kjV = null;
    }

    public d(i<FileInputStream> iVar) {
        this.kjW = com.facebook.c.c.kgj;
        this.keo = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.abI = 1;
        this.kjX = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.kjU = null;
        this.kjV = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.kjX = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.cHN();
        }
        return null;
    }

    public d cHN() {
        d dVar;
        if (this.kjV != null) {
            dVar = new d(this.kjV, this.kjX);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kjU);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.kjU);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.kjU)) {
            z = this.kjV != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> cHO() {
        return com.facebook.common.references.a.b(this.kjU);
    }

    public InputStream getInputStream() {
        if (this.kjV != null) {
            return this.kjV.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.kjU);
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
        this.kjW = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Cu(int i) {
        this.keo = i;
    }

    public void setSampleSize(int i) {
        this.abI = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.kjY = bVar;
    }

    public com.facebook.c.c cHP() {
        return this.kjW;
    }

    public int cHM() {
        return this.keo;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.abI;
    }

    @Nullable
    public com.facebook.cache.common.b cHQ() {
        return this.kjY;
    }

    public boolean Cv(int i) {
        if (this.kjW == com.facebook.c.b.kga && this.kjV == null) {
            com.facebook.common.internal.g.checkNotNull(this.kjU);
            PooledByteBuffer pooledByteBuffer = this.kjU.get();
            return pooledByteBuffer.BY(i + (-2)) == -1 && pooledByteBuffer.BY(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.kjU == null || this.kjU.get() == null) ? this.kjX : this.kjU.get().size();
    }

    public void cHR() {
        Pair<Integer, Integer> cHT;
        com.facebook.c.c r = com.facebook.c.d.r(getInputStream());
        this.kjW = r;
        if (com.facebook.c.b.a(r)) {
            cHT = cHS();
        } else {
            cHT = cHT();
        }
        if (r == com.facebook.c.b.kga && this.keo == -1) {
            if (cHT != null) {
                this.keo = com.facebook.d.b.CU(com.facebook.d.b.v(getInputStream()));
                return;
            }
            return;
        }
        this.keo = 0;
    }

    private Pair<Integer, Integer> cHS() {
        Pair<Integer, Integer> x = com.facebook.d.e.x(getInputStream());
        if (x != null) {
            this.mWidth = ((Integer) x.first).intValue();
            this.mHeight = ((Integer) x.second).intValue();
        }
        return x;
    }

    private Pair<Integer, Integer> cHT() {
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
        this.kjW = dVar.cHP();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.keo = dVar.cHM();
        this.abI = dVar.getSampleSize();
        this.kjX = dVar.getSize();
        this.kjY = dVar.cHQ();
    }

    public static boolean d(d dVar) {
        return dVar.keo >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
