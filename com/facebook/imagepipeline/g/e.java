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
/* loaded from: classes12.dex */
public class e implements Closeable {
    private int aZi;
    private int mHeight;
    private int mWidth;
    private int nOo;
    private int nOp;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> nWh;
    @Nullable
    private final j<FileInputStream> nWi;
    private com.facebook.c.c nWj;
    private int nWk;
    @Nullable
    private com.facebook.imagepipeline.common.a nWl;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.nWj = com.facebook.c.c.nRP;
        this.nOo = -1;
        this.nOp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aZi = 1;
        this.nWk = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.nWh = aVar.clone();
        this.nWi = null;
    }

    public e(j<FileInputStream> jVar) {
        this.nWj = com.facebook.c.c.nRP;
        this.nOo = -1;
        this.nOp = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aZi = 1;
        this.nWk = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.nWh = null;
        this.nWi = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.nWk = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.ech();
        }
        return null;
    }

    public e ech() {
        e eVar;
        if (this.nWi != null) {
            eVar = new e(this.nWi, this.nWk);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nWh);
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
        com.facebook.common.references.a.c(this.nWh);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.nWh)) {
            z = this.nWi != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> eci() {
        return com.facebook.common.references.a.b(this.nWh);
    }

    public InputStream getInputStream() {
        if (this.nWi != null) {
            return this.nWi.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nWh);
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
        this.nWj = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void MY(int i) {
        this.nOo = i;
    }

    public void MZ(int i) {
        this.nOp = i;
    }

    public void setSampleSize(int i) {
        this.aZi = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nWl = aVar;
    }

    public com.facebook.c.c ecj() {
        return this.nWj;
    }

    public int ecf() {
        return this.nOo;
    }

    public int ecg() {
        return this.nOp;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aZi;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eck() {
        return this.nWl;
    }

    public boolean Na(int i) {
        if (this.nWj == com.facebook.c.b.nRF && this.nWi == null) {
            com.facebook.common.internal.g.checkNotNull(this.nWh);
            PooledByteBuffer pooledByteBuffer = this.nWh.get();
            return pooledByteBuffer.Mf(i + (-2)) == -1 && pooledByteBuffer.Mf(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.nWh == null || this.nWh.get() == null) ? this.nWk : this.nWh.get().size();
    }

    public String Nb(int i) {
        com.facebook.common.references.a<PooledByteBuffer> eci = eci();
        if (eci == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = eci.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            eci.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            eci.close();
        }
    }

    public void ecl() {
        Pair<Integer, Integer> ecn;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.nWj = u;
        if (com.facebook.c.b.a(u)) {
            ecn = ecm();
        } else {
            ecn = ecn();
        }
        if (u == com.facebook.c.b.nRF && this.nOo == -1) {
            if (ecn != null) {
                this.nOp = com.facebook.d.b.y(getInputStream());
                this.nOo = com.facebook.d.b.NF(this.nOp);
                return;
            }
            return;
        }
        this.nOo = 0;
    }

    private Pair<Integer, Integer> ecm() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> ecn() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> x = com.facebook.d.a.x(inputStream);
            if (x != null) {
                this.mWidth = ((Integer) x.first).intValue();
                this.mHeight = ((Integer) x.second).intValue();
            }
            return x;
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
        this.nWj = eVar.ecj();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.nOo = eVar.ecf();
        this.nOp = eVar.ecg();
        this.aZi = eVar.getSampleSize();
        this.nWk = eVar.getSize();
        this.nWl = eVar.eck();
    }

    public static boolean d(e eVar) {
        return eVar.nOo >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
