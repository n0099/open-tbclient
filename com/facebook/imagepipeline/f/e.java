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
    private int bdO;
    private int mHeight;
    private int mWidth;
    private int pDl;
    private int pDm;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pKE;
    @Nullable
    private final j<FileInputStream> pKF;
    private com.facebook.c.c pKG;
    private int pKH;
    @Nullable
    private com.facebook.imagepipeline.common.a pKI;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pKG = com.facebook.c.c.pGy;
        this.pDl = -1;
        this.pDm = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdO = 1;
        this.pKH = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pKE = aVar.clone();
        this.pKF = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pKG = com.facebook.c.c.pGy;
        this.pDl = -1;
        this.pDm = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdO = 1;
        this.pKH = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pKE = null;
        this.pKF = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pKH = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.eyu();
        }
        return null;
    }

    public e eyu() {
        e eVar;
        if (this.pKF != null) {
            eVar = new e(this.pKF, this.pKH);
        } else {
            com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pKE);
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
        com.facebook.common.references.a.c(this.pKE);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pKE)) {
            z = this.pKF != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> eyv() {
        return com.facebook.common.references.a.b(this.pKE);
    }

    public InputStream getInputStream() {
        if (this.pKF != null) {
            return this.pKF.get();
        }
        com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pKE);
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
        this.pKG = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void PM(int i) {
        this.pDl = i;
    }

    public void PN(int i) {
        this.pDm = i;
    }

    public void setSampleSize(int i) {
        this.bdO = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pKI = aVar;
    }

    public com.facebook.c.c eyw() {
        return this.pKG;
    }

    public int eys() {
        return this.pDl;
    }

    public int eyt() {
        return this.pDm;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.bdO;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyx() {
        return this.pKI;
    }

    public boolean PO(int i) {
        if (this.pKG == com.facebook.c.b.pGo && this.pKF == null) {
            com.facebook.common.internal.g.checkNotNull(this.pKE);
            PooledByteBuffer pooledByteBuffer = this.pKE.get();
            return pooledByteBuffer.OV(i + (-2)) == -1 && pooledByteBuffer.OV(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pKE == null || this.pKE.get() == null) ? this.pKH : this.pKE.get().size();
    }

    public String PP(int i) {
        com.facebook.common.references.a<PooledByteBuffer> eyv = eyv();
        if (eyv == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = eyv.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            eyv.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            eyv.close();
        }
    }

    public void eyy() {
        Pair<Integer, Integer> eyA;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.pKG = v;
        if (com.facebook.c.b.a(v)) {
            eyA = eyz();
        } else {
            eyA = eyA();
        }
        if (v == com.facebook.c.b.pGo && this.pDl == -1) {
            if (eyA != null) {
                this.pDm = com.facebook.d.b.z(getInputStream());
                this.pDl = com.facebook.d.b.Qr(this.pDm);
                return;
            }
            return;
        }
        this.pDl = 0;
    }

    private Pair<Integer, Integer> eyz() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> eyA() {
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
        this.pKG = eVar.eyw();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.pDl = eVar.eys();
        this.pDm = eVar.eyt();
        this.bdO = eVar.getSampleSize();
        this.pKH = eVar.getSize();
        this.pKI = eVar.eyx();
    }

    public static boolean d(e eVar) {
        return eVar.pDl >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
