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
    private int ibT;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> iho;
    @Nullable
    private final i<FileInputStream> ihp;
    private com.facebook.c.c ihq;
    private int ihr;
    @Nullable
    private com.facebook.cache.common.b ihs;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.ihq = com.facebook.c.c.idJ;
        this.ibT = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ihr = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.iho = aVar.clone();
        this.ihp = null;
    }

    public d(i<FileInputStream> iVar) {
        this.ihq = com.facebook.c.c.idJ;
        this.ibT = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ihr = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.iho = null;
        this.ihp = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.ihr = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.bVS();
        }
        return null;
    }

    public d bVS() {
        d dVar;
        if (this.ihp != null) {
            dVar = new d(this.ihp, this.ihr);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.iho);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.iho);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.iho)) {
            z = this.ihp != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> bVT() {
        return com.facebook.common.references.a.b(this.iho);
    }

    public InputStream getInputStream() {
        if (this.ihp != null) {
            return this.ihp.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.iho);
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
        this.ihq = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void xS(int i) {
        this.ibT = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.ihs = bVar;
    }

    public com.facebook.c.c bVU() {
        return this.ihq;
    }

    public int bVR() {
        return this.ibT;
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
    public com.facebook.cache.common.b bVV() {
        return this.ihs;
    }

    public boolean xT(int i) {
        if (this.ihq == com.facebook.c.b.idA && this.ihp == null) {
            com.facebook.common.internal.g.checkNotNull(this.iho);
            PooledByteBuffer pooledByteBuffer = this.iho.get();
            return pooledByteBuffer.xw(i + (-2)) == -1 && pooledByteBuffer.xw(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.iho == null || this.iho.get() == null) ? this.ihr : this.iho.get().size();
    }

    public void bVW() {
        Pair<Integer, Integer> bVY;
        com.facebook.c.c r = com.facebook.c.d.r(getInputStream());
        this.ihq = r;
        if (com.facebook.c.b.a(r)) {
            bVY = bVX();
        } else {
            bVY = bVY();
        }
        if (r == com.facebook.c.b.idA && this.ibT == -1) {
            if (bVY != null) {
                this.ibT = com.facebook.d.b.ys(com.facebook.d.b.v(getInputStream()));
                return;
            }
            return;
        }
        this.ibT = 0;
    }

    private Pair<Integer, Integer> bVX() {
        Pair<Integer, Integer> x = com.facebook.d.e.x(getInputStream());
        if (x != null) {
            this.mWidth = ((Integer) x.first).intValue();
            this.mHeight = ((Integer) x.second).intValue();
        }
        return x;
    }

    private Pair<Integer, Integer> bVY() {
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
        this.ihq = dVar.bVU();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.ibT = dVar.bVR();
        this.mSampleSize = dVar.getSampleSize();
        this.ihr = dVar.getSize();
        this.ihs = dVar.bVV();
    }

    public static boolean d(d dVar) {
        return dVar.ibT >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
