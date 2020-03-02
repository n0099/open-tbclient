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
/* loaded from: classes13.dex */
public class e implements Closeable {
    private int amh;
    private int lMj;
    private int lMk;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> lTR;
    @Nullable
    private final j<FileInputStream> lTS;
    private com.facebook.c.c lTT;
    private int lTU;
    @Nullable
    private com.facebook.imagepipeline.common.a lTV;
    private int mHeight;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.lTT = com.facebook.c.c.lPA;
        this.lMj = -1;
        this.lMk = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.amh = 1;
        this.lTU = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.lTR = aVar.clone();
        this.lTS = null;
    }

    public e(j<FileInputStream> jVar) {
        this.lTT = com.facebook.c.c.lPA;
        this.lMj = -1;
        this.lMk = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.amh = 1;
        this.lTU = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.lTR = null;
        this.lTS = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.lTU = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dqx();
        }
        return null;
    }

    public e dqx() {
        e eVar;
        if (this.lTS != null) {
            eVar = new e(this.lTS, this.lTU);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTR);
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
        com.facebook.common.references.a.c(this.lTR);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.lTR)) {
            z = this.lTS != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dqy() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTR);
    }

    public InputStream getInputStream() {
        if (this.lTS != null) {
            return this.lTS.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTR);
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
        this.lTT = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Il(int i) {
        this.lMj = i;
    }

    public void Im(int i) {
        this.lMk = i;
    }

    public void setSampleSize(int i) {
        this.amh = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTV = aVar;
    }

    public com.facebook.c.c dqz() {
        return this.lTT;
    }

    public int dqv() {
        return this.lMj;
    }

    public int dqw() {
        return this.lMk;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.amh;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqA() {
        return this.lTV;
    }

    public boolean In(int i) {
        if (this.lTT == com.facebook.c.b.lPq && this.lTS == null) {
            com.facebook.common.internal.g.checkNotNull(this.lTR);
            PooledByteBuffer pooledByteBuffer = this.lTR.get();
            return pooledByteBuffer.Ht(i + (-2)) == -1 && pooledByteBuffer.Ht(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.lTR == null || this.lTR.get() == null) ? this.lTU : this.lTR.get().size();
    }

    public String Io(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dqy = dqy();
        if (dqy == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dqy.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dqy.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dqy.close();
        }
    }

    public void dqB() {
        Pair<Integer, Integer> dqD;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.lTT = v;
        if (com.facebook.c.b.a(v)) {
            dqD = dqC();
        } else {
            dqD = dqD();
        }
        if (v == com.facebook.c.b.lPq && this.lMj == -1) {
            if (dqD != null) {
                this.lMk = com.facebook.d.b.z(getInputStream());
                this.lMj = com.facebook.d.b.IR(this.lMk);
                return;
            }
            return;
        }
        this.lMj = 0;
    }

    private Pair<Integer, Integer> dqC() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> dqD() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> y = com.facebook.d.a.y(inputStream);
            if (y != null) {
                this.mWidth = ((Integer) y.first).intValue();
                this.mHeight = ((Integer) y.second).intValue();
            }
            return y;
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
        this.lTT = eVar.dqz();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lMj = eVar.dqv();
        this.lMk = eVar.dqw();
        this.amh = eVar.getSampleSize();
        this.lTU = eVar.getSize();
        this.lTV = eVar.dqA();
    }

    public static boolean d(e eVar) {
        return eVar.lMj >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
