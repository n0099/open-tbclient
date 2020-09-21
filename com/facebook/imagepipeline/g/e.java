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
    private int aVX;
    private int mHeight;
    private int mWidth;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> nGQ;
    @Nullable
    private final j<FileInputStream> nGR;
    private com.facebook.c.c nGS;
    private int nGT;
    @Nullable
    private com.facebook.imagepipeline.common.a nGU;
    private int nyV;
    private int nyW;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.nGS = com.facebook.c.c.nCw;
        this.nyV = -1;
        this.nyW = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aVX = 1;
        this.nGT = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.nGQ = aVar.clone();
        this.nGR = null;
    }

    public e(j<FileInputStream> jVar) {
        this.nGS = com.facebook.c.c.nCw;
        this.nyV = -1;
        this.nyW = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aVX = 1;
        this.nGT = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.nGQ = null;
        this.nGR = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.nGT = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dYw();
        }
        return null;
    }

    public e dYw() {
        e eVar;
        if (this.nGR != null) {
            eVar = new e(this.nGR, this.nGT);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nGQ);
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
        com.facebook.common.references.a.c(this.nGQ);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.nGQ)) {
            z = this.nGR != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dYx() {
        return com.facebook.common.references.a.b(this.nGQ);
    }

    public InputStream getInputStream() {
        if (this.nGR != null) {
            return this.nGR.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nGQ);
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
        this.nGS = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Ms(int i) {
        this.nyV = i;
    }

    public void Mt(int i) {
        this.nyW = i;
    }

    public void setSampleSize(int i) {
        this.aVX = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nGU = aVar;
    }

    public com.facebook.c.c dYy() {
        return this.nGS;
    }

    public int dYu() {
        return this.nyV;
    }

    public int dYv() {
        return this.nyW;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aVX;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dYz() {
        return this.nGU;
    }

    public boolean Mu(int i) {
        if (this.nGS == com.facebook.c.b.nCm && this.nGR == null) {
            com.facebook.common.internal.g.checkNotNull(this.nGQ);
            PooledByteBuffer pooledByteBuffer = this.nGQ.get();
            return pooledByteBuffer.Lz(i + (-2)) == -1 && pooledByteBuffer.Lz(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.nGQ == null || this.nGQ.get() == null) ? this.nGT : this.nGQ.get().size();
    }

    public String Mv(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dYx = dYx();
        if (dYx == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dYx.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dYx.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dYx.close();
        }
    }

    public void dYA() {
        Pair<Integer, Integer> dYC;
        com.facebook.c.c t = com.facebook.c.d.t(getInputStream());
        this.nGS = t;
        if (com.facebook.c.b.a(t)) {
            dYC = dYB();
        } else {
            dYC = dYC();
        }
        if (t == com.facebook.c.b.nCm && this.nyV == -1) {
            if (dYC != null) {
                this.nyW = com.facebook.d.b.x(getInputStream());
                this.nyV = com.facebook.d.b.MZ(this.nyW);
                return;
            }
            return;
        }
        this.nyV = 0;
    }

    private Pair<Integer, Integer> dYB() {
        Pair<Integer, Integer> z = com.facebook.d.e.z(getInputStream());
        if (z != null) {
            this.mWidth = ((Integer) z.first).intValue();
            this.mHeight = ((Integer) z.second).intValue();
        }
        return z;
    }

    private Pair<Integer, Integer> dYC() {
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
        this.nGS = eVar.dYy();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.nyV = eVar.dYu();
        this.nyW = eVar.dYv();
        this.aVX = eVar.getSampleSize();
        this.nGT = eVar.getSize();
        this.nGU = eVar.dYz();
    }

    public static boolean d(e eVar) {
        return eVar.nyV >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
