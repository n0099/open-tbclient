package com.facebook.imagepipeline.f;

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
/* loaded from: classes5.dex */
public class e implements Closeable {
    private int bfz;
    private int mHeight;
    private int mWidth;
    @Nullable
    private com.facebook.imagepipeline.common.a pEA;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pEw;
    @Nullable
    private final j<FileInputStream> pEx;
    private com.facebook.c.c pEy;
    private int pEz;
    private int pxd;
    private int pxe;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pEy = com.facebook.c.c.pAq;
        this.pxd = -1;
        this.pxe = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bfz = 1;
        this.pEz = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pEw = aVar.clone();
        this.pEx = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pEy = com.facebook.c.c.pAq;
        this.pxd = -1;
        this.pxe = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bfz = 1;
        this.pEz = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pEw = null;
        this.pEx = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pEz = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.ezL();
        }
        return null;
    }

    public e ezL() {
        e eVar;
        if (this.pEx != null) {
            eVar = new e(this.pEx, this.pEz);
        } else {
            com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pEw);
            if (b2 == null) {
                eVar = null;
            } else {
                try {
                    eVar = new e(b2);
                } finally {
                    com.facebook.common.references.a.c(b2);
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
        com.facebook.common.references.a.c(this.pEw);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pEw)) {
            z = this.pEx != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> ezM() {
        return com.facebook.common.references.a.b(this.pEw);
    }

    public InputStream getInputStream() {
        if (this.pEx != null) {
            return this.pEx.get();
        }
        com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pEw);
        if (b2 != null) {
            try {
                return new com.facebook.common.memory.h((PooledByteBuffer) b2.get());
            } finally {
                com.facebook.common.references.a.c(b2);
            }
        }
        return null;
    }

    public void c(com.facebook.c.c cVar) {
        this.pEy = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void QX(int i) {
        this.pxd = i;
    }

    public void QY(int i) {
        this.pxe = i;
    }

    public void setSampleSize(int i) {
        this.bfz = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pEA = aVar;
    }

    public com.facebook.c.c ezN() {
        return this.pEy;
    }

    public int ezJ() {
        return this.pxd;
    }

    public int ezK() {
        return this.pxe;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.bfz;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezO() {
        return this.pEA;
    }

    public boolean QZ(int i) {
        if (this.pEy == com.facebook.c.b.pAg && this.pEx == null) {
            com.facebook.common.internal.g.checkNotNull(this.pEw);
            PooledByteBuffer pooledByteBuffer = this.pEw.get();
            return pooledByteBuffer.Qg(i + (-2)) == -1 && pooledByteBuffer.Qg(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pEw == null || this.pEw.get() == null) ? this.pEz : this.pEw.get().size();
    }

    public String Ra(int i) {
        com.facebook.common.references.a<PooledByteBuffer> ezM = ezM();
        if (ezM == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = ezM.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            ezM.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            ezM.close();
        }
    }

    public void ezP() {
        Pair<Integer, Integer> ezR;
        com.facebook.c.c y = com.facebook.c.d.y(getInputStream());
        this.pEy = y;
        if (com.facebook.c.b.a(y)) {
            ezR = ezQ();
        } else {
            ezR = ezR();
        }
        if (y == com.facebook.c.b.pAg && this.pxd == -1) {
            if (ezR != null) {
                this.pxe = com.facebook.d.b.C(getInputStream());
                this.pxd = com.facebook.d.b.RC(this.pxe);
                return;
            }
            return;
        }
        this.pxd = 0;
    }

    private Pair<Integer, Integer> ezQ() {
        Pair<Integer, Integer> E = com.facebook.d.e.E(getInputStream());
        if (E != null) {
            this.mWidth = ((Integer) E.first).intValue();
            this.mHeight = ((Integer) E.second).intValue();
        }
        return E;
    }

    private Pair<Integer, Integer> ezR() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> B = com.facebook.d.a.B(inputStream);
            if (B != null) {
                this.mWidth = ((Integer) B.first).intValue();
                this.mHeight = ((Integer) B.second).intValue();
            }
            return B;
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
        this.pEy = eVar.ezN();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.pxd = eVar.ezJ();
        this.pxe = eVar.ezK();
        this.bfz = eVar.getSampleSize();
        this.pEz = eVar.getSize();
        this.pEA = eVar.ezO();
    }

    public static boolean d(e eVar) {
        return eVar.pxd >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
