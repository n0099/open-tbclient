package com.facebook.imagepipeline.g;

import android.util.Pair;
import com.facebook.common.internal.j;
import com.facebook.common.memory.PooledByteBuffer;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes8.dex */
public class e implements Closeable {
    private int aTI;
    private int mHeight;
    private int mWidth;
    private int noX;
    private int noY;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> nwT;
    @Nullable
    private final j<FileInputStream> nwU;
    private com.facebook.c.c nwV;
    private int nwW;
    @Nullable
    private com.facebook.imagepipeline.common.a nwX;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.nwV = com.facebook.c.c.nsy;
        this.noX = -1;
        this.noY = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aTI = 1;
        this.nwW = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.nwT = aVar.clone();
        this.nwU = null;
    }

    public e(j<FileInputStream> jVar) {
        this.nwV = com.facebook.c.c.nsy;
        this.noX = -1;
        this.noY = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aTI = 1;
        this.nwW = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.nwT = null;
        this.nwU = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.nwW = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dUy();
        }
        return null;
    }

    public e dUy() {
        e eVar;
        if (this.nwU != null) {
            eVar = new e(this.nwU, this.nwW);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nwT);
            if (b == null) {
                eVar = null;
            } else {
                try {
                    eVar = new e(b);
                } finally {
                    com.facebook.common.references.a.c(b);
                }
            }
        }
        if (eVar != null) {
            eVar.c(this);
        }
        return eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.facebook.common.references.a.c(this.nwT);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.nwT)) {
            z = this.nwU != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dUz() {
        return com.facebook.common.references.a.b(this.nwT);
    }

    public InputStream getInputStream() {
        if (this.nwU != null) {
            return this.nwU.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nwT);
        if (b != null) {
            try {
                return new com.facebook.common.memory.h((PooledByteBuffer) b.get());
            } finally {
                com.facebook.common.references.a.c(b);
            }
        }
        return null;
    }

    public void c(com.facebook.c.c cVar) {
        this.nwV = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void LN(int i) {
        this.noX = i;
    }

    public void LO(int i) {
        this.noY = i;
    }

    public void setSampleSize(int i) {
        this.aTI = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nwX = aVar;
    }

    public com.facebook.c.c dUA() {
        return this.nwV;
    }

    public int dUw() {
        return this.noX;
    }

    public int dUx() {
        return this.noY;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aTI;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dUB() {
        return this.nwX;
    }

    public boolean LP(int i) {
        if (this.nwV == com.facebook.c.b.nso && this.nwU == null) {
            com.facebook.common.internal.g.checkNotNull(this.nwT);
            PooledByteBuffer pooledByteBuffer = this.nwT.get();
            return pooledByteBuffer.KU(i + (-2)) == -1 && pooledByteBuffer.KU(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.nwT == null || this.nwT.get() == null) ? this.nwW : this.nwT.get().size();
    }

    public String LQ(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dUz = dUz();
        if (dUz == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dUz.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dUz.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dUz.close();
        }
    }

    public void dUC() {
        Pair<Integer, Integer> dUE;
        com.facebook.c.c t = com.facebook.c.d.t(getInputStream());
        this.nwV = t;
        if (com.facebook.c.b.a(t)) {
            dUE = dUD();
        } else {
            dUE = dUE();
        }
        if (t == com.facebook.c.b.nso && this.noX == -1) {
            if (dUE != null) {
                this.noY = com.facebook.d.b.x(getInputStream());
                this.noX = com.facebook.d.b.Mu(this.noY);
                return;
            }
            return;
        }
        this.noX = 0;
    }

    private Pair<Integer, Integer> dUD() {
        Pair<Integer, Integer> z = com.facebook.d.e.z(getInputStream());
        if (z != null) {
            this.mWidth = ((Integer) z.first).intValue();
            this.mHeight = ((Integer) z.second).intValue();
        }
        return z;
    }

    private Pair<Integer, Integer> dUE() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> w = com.facebook.d.a.w(inputStream);
            if (w != null) {
                this.mWidth = ((Integer) w.first).intValue();
                this.mHeight = ((Integer) w.second).intValue();
            }
            return w;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void c(e eVar) {
        this.nwV = eVar.dUA();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.noX = eVar.dUw();
        this.noY = eVar.dUx();
        this.aTI = eVar.getSampleSize();
        this.nwW = eVar.getSize();
        this.nwX = eVar.dUB();
    }

    public static boolean d(e eVar) {
        return eVar.noX >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
    }

    public static void e(@Nullable e eVar) {
        if (eVar != null) {
            eVar.close();
        }
    }

    public static boolean f(@Nullable e eVar) {
        return eVar != null && eVar.isValid();
    }
}
