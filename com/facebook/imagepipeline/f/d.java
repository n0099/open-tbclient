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
    private int ijg;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> ioA;
    @Nullable
    private final i<FileInputStream> ioB;
    private com.facebook.c.c ioC;
    private int ioD;
    @Nullable
    private com.facebook.cache.common.b ioE;
    private int mHeight;
    private int mSampleSize;
    private int mWidth;

    public d(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.ioC = com.facebook.c.c.ikT;
        this.ijg = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ioD = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.ioA = aVar.clone();
        this.ioB = null;
    }

    public d(i<FileInputStream> iVar) {
        this.ioC = com.facebook.c.c.ikT;
        this.ijg = -1;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.ioD = -1;
        com.facebook.common.internal.g.checkNotNull(iVar);
        this.ioA = null;
        this.ioB = iVar;
    }

    public d(i<FileInputStream> iVar, int i) {
        this(iVar);
        this.ioD = i;
    }

    public static d b(d dVar) {
        if (dVar != null) {
            return dVar.bXY();
        }
        return null;
    }

    public d bXY() {
        d dVar;
        if (this.ioB != null) {
            dVar = new d(this.ioB, this.ioD);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ioA);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.ioA);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.ioA)) {
            z = this.ioB != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> bXZ() {
        return com.facebook.common.references.a.b(this.ioA);
    }

    public InputStream getInputStream() {
        if (this.ioB != null) {
            return this.ioB.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ioA);
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
        this.ioC = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void yp(int i) {
        this.ijg = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void t(@Nullable com.facebook.cache.common.b bVar) {
        this.ioE = bVar;
    }

    public com.facebook.c.c bYa() {
        return this.ioC;
    }

    public int bXX() {
        return this.ijg;
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
    public com.facebook.cache.common.b bYb() {
        return this.ioE;
    }

    public boolean yq(int i) {
        if (this.ioC == com.facebook.c.b.ikK && this.ioB == null) {
            com.facebook.common.internal.g.checkNotNull(this.ioA);
            PooledByteBuffer pooledByteBuffer = this.ioA.get();
            return pooledByteBuffer.xT(i + (-2)) == -1 && pooledByteBuffer.xT(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.ioA == null || this.ioA.get() == null) ? this.ioD : this.ioA.get().size();
    }

    public void bYc() {
        Pair<Integer, Integer> bYe;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.ioC = s;
        if (com.facebook.c.b.a(s)) {
            bYe = bYd();
        } else {
            bYe = bYe();
        }
        if (s == com.facebook.c.b.ikK && this.ijg == -1) {
            if (bYe != null) {
                this.ijg = com.facebook.d.b.yP(com.facebook.d.b.w(getInputStream()));
                return;
            }
            return;
        }
        this.ijg = 0;
    }

    private Pair<Integer, Integer> bYd() {
        Pair<Integer, Integer> y = com.facebook.d.e.y(getInputStream());
        if (y != null) {
            this.mWidth = ((Integer) y.first).intValue();
            this.mHeight = ((Integer) y.second).intValue();
        }
        return y;
    }

    private Pair<Integer, Integer> bYe() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> v = com.facebook.d.a.v(inputStream);
            if (v != null) {
                this.mWidth = ((Integer) v.first).intValue();
                this.mHeight = ((Integer) v.second).intValue();
            }
            return v;
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
        this.ioC = dVar.bYa();
        this.mWidth = dVar.getWidth();
        this.mHeight = dVar.getHeight();
        this.ijg = dVar.bXX();
        this.mSampleSize = dVar.getSampleSize();
        this.ioD = dVar.getSize();
        this.ioE = dVar.bYb();
    }

    public static boolean d(d dVar) {
        return dVar.ijg >= 0 && dVar.mWidth >= 0 && dVar.mHeight >= 0;
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
