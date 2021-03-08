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
    private int bfr;
    private int mHeight;
    private int mWidth;
    private int pFq;
    private int pFr;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pMJ;
    @Nullable
    private final j<FileInputStream> pMK;
    private com.facebook.c.c pML;
    private int pMM;
    @Nullable
    private com.facebook.imagepipeline.common.a pMN;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pML = com.facebook.c.c.pID;
        this.pFq = -1;
        this.pFr = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bfr = 1;
        this.pMM = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pMJ = aVar.clone();
        this.pMK = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pML = com.facebook.c.c.pID;
        this.pFq = -1;
        this.pFr = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bfr = 1;
        this.pMM = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pMJ = null;
        this.pMK = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pMM = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.eyD();
        }
        return null;
    }

    public e eyD() {
        e eVar;
        if (this.pMK != null) {
            eVar = new e(this.pMK, this.pMM);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.pMJ);
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
        com.facebook.common.references.a.c(this.pMJ);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pMJ)) {
            z = this.pMK != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> eyE() {
        return com.facebook.common.references.a.b(this.pMJ);
    }

    public InputStream getInputStream() {
        if (this.pMK != null) {
            return this.pMK.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.pMJ);
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
        this.pML = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void PQ(int i) {
        this.pFq = i;
    }

    public void PR(int i) {
        this.pFr = i;
    }

    public void setSampleSize(int i) {
        this.bfr = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pMN = aVar;
    }

    public com.facebook.c.c eyF() {
        return this.pML;
    }

    public int eyB() {
        return this.pFq;
    }

    public int eyC() {
        return this.pFr;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.bfr;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyG() {
        return this.pMN;
    }

    public boolean PS(int i) {
        if (this.pML == com.facebook.c.b.pIt && this.pMK == null) {
            com.facebook.common.internal.g.checkNotNull(this.pMJ);
            PooledByteBuffer pooledByteBuffer = this.pMJ.get();
            return pooledByteBuffer.OZ(i + (-2)) == -1 && pooledByteBuffer.OZ(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pMJ == null || this.pMJ.get() == null) ? this.pMM : this.pMJ.get().size();
    }

    public String PT(int i) {
        com.facebook.common.references.a<PooledByteBuffer> eyE = eyE();
        if (eyE == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = eyE.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            eyE.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            eyE.close();
        }
    }

    public void eyH() {
        Pair<Integer, Integer> eyJ;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.pML = v;
        if (com.facebook.c.b.a(v)) {
            eyJ = eyI();
        } else {
            eyJ = eyJ();
        }
        if (v == com.facebook.c.b.pIt && this.pFq == -1) {
            if (eyJ != null) {
                this.pFr = com.facebook.d.b.z(getInputStream());
                this.pFq = com.facebook.d.b.Qv(this.pFr);
                return;
            }
            return;
        }
        this.pFq = 0;
    }

    private Pair<Integer, Integer> eyI() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> eyJ() {
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
        this.pML = eVar.eyF();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.pFq = eVar.eyB();
        this.pFr = eVar.eyC();
        this.bfr = eVar.getSampleSize();
        this.pMM = eVar.getSize();
        this.pMN = eVar.eyG();
    }

    public static boolean d(e eVar) {
        return eVar.pFq >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
