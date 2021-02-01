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
    private int pCL;
    private int pCM;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pKe;
    @Nullable
    private final j<FileInputStream> pKf;
    private com.facebook.c.c pKg;
    private int pKh;
    @Nullable
    private com.facebook.imagepipeline.common.a pKi;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pKg = com.facebook.c.c.pFY;
        this.pCL = -1;
        this.pCM = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdO = 1;
        this.pKh = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pKe = aVar.clone();
        this.pKf = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pKg = com.facebook.c.c.pFY;
        this.pCL = -1;
        this.pCM = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdO = 1;
        this.pKh = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pKe = null;
        this.pKf = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pKh = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.eym();
        }
        return null;
    }

    public e eym() {
        e eVar;
        if (this.pKf != null) {
            eVar = new e(this.pKf, this.pKh);
        } else {
            com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pKe);
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
        com.facebook.common.references.a.c(this.pKe);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pKe)) {
            z = this.pKf != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> eyn() {
        return com.facebook.common.references.a.b(this.pKe);
    }

    public InputStream getInputStream() {
        if (this.pKf != null) {
            return this.pKf.get();
        }
        com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pKe);
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
        this.pKg = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void PL(int i) {
        this.pCL = i;
    }

    public void PM(int i) {
        this.pCM = i;
    }

    public void setSampleSize(int i) {
        this.bdO = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pKi = aVar;
    }

    public com.facebook.c.c eyo() {
        return this.pKg;
    }

    public int eyk() {
        return this.pCL;
    }

    public int eyl() {
        return this.pCM;
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
    public com.facebook.imagepipeline.common.a eyp() {
        return this.pKi;
    }

    public boolean PN(int i) {
        if (this.pKg == com.facebook.c.b.pFO && this.pKf == null) {
            com.facebook.common.internal.g.checkNotNull(this.pKe);
            PooledByteBuffer pooledByteBuffer = this.pKe.get();
            return pooledByteBuffer.OU(i + (-2)) == -1 && pooledByteBuffer.OU(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pKe == null || this.pKe.get() == null) ? this.pKh : this.pKe.get().size();
    }

    public String PO(int i) {
        com.facebook.common.references.a<PooledByteBuffer> eyn = eyn();
        if (eyn == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = eyn.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            eyn.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            eyn.close();
        }
    }

    public void eyq() {
        Pair<Integer, Integer> eys;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.pKg = v;
        if (com.facebook.c.b.a(v)) {
            eys = eyr();
        } else {
            eys = eys();
        }
        if (v == com.facebook.c.b.pFO && this.pCL == -1) {
            if (eys != null) {
                this.pCM = com.facebook.d.b.z(getInputStream());
                this.pCL = com.facebook.d.b.Qq(this.pCM);
                return;
            }
            return;
        }
        this.pCL = 0;
    }

    private Pair<Integer, Integer> eyr() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> eys() {
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
        this.pKg = eVar.eyo();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.pCL = eVar.eyk();
        this.pCM = eVar.eyl();
        this.bdO = eVar.getSampleSize();
        this.pKh = eVar.getSize();
        this.pKi = eVar.eyp();
    }

    public static boolean d(e eVar) {
        return eVar.pCL >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
