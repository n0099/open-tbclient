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
    private int lMh;
    private int lMi;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> lTP;
    @Nullable
    private final j<FileInputStream> lTQ;
    private com.facebook.c.c lTR;
    private int lTS;
    @Nullable
    private com.facebook.imagepipeline.common.a lTT;
    private int mHeight;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.lTR = com.facebook.c.c.lPy;
        this.lMh = -1;
        this.lMi = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.amh = 1;
        this.lTS = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.lTP = aVar.clone();
        this.lTQ = null;
    }

    public e(j<FileInputStream> jVar) {
        this.lTR = com.facebook.c.c.lPy;
        this.lMh = -1;
        this.lMi = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.amh = 1;
        this.lTS = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.lTP = null;
        this.lTQ = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.lTS = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dqv();
        }
        return null;
    }

    public e dqv() {
        e eVar;
        if (this.lTQ != null) {
            eVar = new e(this.lTQ, this.lTS);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTP);
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
        com.facebook.common.references.a.c(this.lTP);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.lTP)) {
            z = this.lTQ != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dqw() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTP);
    }

    public InputStream getInputStream() {
        if (this.lTQ != null) {
            return this.lTQ.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTP);
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
        this.lTR = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Il(int i) {
        this.lMh = i;
    }

    public void Im(int i) {
        this.lMi = i;
    }

    public void setSampleSize(int i) {
        this.amh = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTT = aVar;
    }

    public com.facebook.c.c dqx() {
        return this.lTR;
    }

    public int dqt() {
        return this.lMh;
    }

    public int dqu() {
        return this.lMi;
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
    public com.facebook.imagepipeline.common.a dqy() {
        return this.lTT;
    }

    public boolean In(int i) {
        if (this.lTR == com.facebook.c.b.lPo && this.lTQ == null) {
            com.facebook.common.internal.g.checkNotNull(this.lTP);
            PooledByteBuffer pooledByteBuffer = this.lTP.get();
            return pooledByteBuffer.Ht(i + (-2)) == -1 && pooledByteBuffer.Ht(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.lTP == null || this.lTP.get() == null) ? this.lTS : this.lTP.get().size();
    }

    public String Io(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dqw = dqw();
        if (dqw == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dqw.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dqw.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dqw.close();
        }
    }

    public void dqz() {
        Pair<Integer, Integer> dqB;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.lTR = v;
        if (com.facebook.c.b.a(v)) {
            dqB = dqA();
        } else {
            dqB = dqB();
        }
        if (v == com.facebook.c.b.lPo && this.lMh == -1) {
            if (dqB != null) {
                this.lMi = com.facebook.d.b.z(getInputStream());
                this.lMh = com.facebook.d.b.IR(this.lMi);
                return;
            }
            return;
        }
        this.lMh = 0;
    }

    private Pair<Integer, Integer> dqA() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> dqB() {
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
        this.lTR = eVar.dqx();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lMh = eVar.dqt();
        this.lMi = eVar.dqu();
        this.amh = eVar.getSampleSize();
        this.lTS = eVar.getSize();
        this.lTT = eVar.dqy();
    }

    public static boolean d(e eVar) {
        return eVar.lMh >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
