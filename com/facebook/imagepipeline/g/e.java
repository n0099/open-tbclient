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
    private int ami;
    private int lMu;
    private int lMv;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> lUc;
    @Nullable
    private final j<FileInputStream> lUd;
    private com.facebook.c.c lUe;
    private int lUf;
    @Nullable
    private com.facebook.imagepipeline.common.a lUg;
    private int mHeight;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.lUe = com.facebook.c.c.lPL;
        this.lMu = -1;
        this.lMv = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.ami = 1;
        this.lUf = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.lUc = aVar.clone();
        this.lUd = null;
    }

    public e(j<FileInputStream> jVar) {
        this.lUe = com.facebook.c.c.lPL;
        this.lMu = -1;
        this.lMv = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.ami = 1;
        this.lUf = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.lUc = null;
        this.lUd = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.lUf = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dqy();
        }
        return null;
    }

    public e dqy() {
        e eVar;
        if (this.lUd != null) {
            eVar = new e(this.lUd, this.lUf);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lUc);
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
        com.facebook.common.references.a.c(this.lUc);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.lUc)) {
            z = this.lUd != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dqz() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lUc);
    }

    public InputStream getInputStream() {
        if (this.lUd != null) {
            return this.lUd.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lUc);
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
        this.lUe = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Il(int i) {
        this.lMu = i;
    }

    public void Im(int i) {
        this.lMv = i;
    }

    public void setSampleSize(int i) {
        this.ami = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lUg = aVar;
    }

    public com.facebook.c.c dqA() {
        return this.lUe;
    }

    public int dqw() {
        return this.lMu;
    }

    public int dqx() {
        return this.lMv;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.ami;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqB() {
        return this.lUg;
    }

    public boolean In(int i) {
        if (this.lUe == com.facebook.c.b.lPB && this.lUd == null) {
            com.facebook.common.internal.g.checkNotNull(this.lUc);
            PooledByteBuffer pooledByteBuffer = this.lUc.get();
            return pooledByteBuffer.Ht(i + (-2)) == -1 && pooledByteBuffer.Ht(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.lUc == null || this.lUc.get() == null) ? this.lUf : this.lUc.get().size();
    }

    public String Io(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dqz = dqz();
        if (dqz == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dqz.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dqz.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dqz.close();
        }
    }

    public void dqC() {
        Pair<Integer, Integer> dqE;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.lUe = v;
        if (com.facebook.c.b.a(v)) {
            dqE = dqD();
        } else {
            dqE = dqE();
        }
        if (v == com.facebook.c.b.lPB && this.lMu == -1) {
            if (dqE != null) {
                this.lMv = com.facebook.d.b.z(getInputStream());
                this.lMu = com.facebook.d.b.IR(this.lMv);
                return;
            }
            return;
        }
        this.lMu = 0;
    }

    private Pair<Integer, Integer> dqD() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> dqE() {
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
        this.lUe = eVar.dqA();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lMu = eVar.dqw();
        this.lMv = eVar.dqx();
        this.ami = eVar.getSampleSize();
        this.lUf = eVar.getSize();
        this.lUg = eVar.dqB();
    }

    public static boolean d(e eVar) {
        return eVar.lMu >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
