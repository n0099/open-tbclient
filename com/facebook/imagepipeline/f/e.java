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
/* loaded from: classes7.dex */
public class e implements Closeable {
    private int bdM;
    private int mHeight;
    private int mWidth;
    private int pfO;
    private int pfP;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pnm;
    @Nullable
    private final j<FileInputStream> pnn;
    private com.facebook.c.c pno;
    private int pnp;
    @Nullable
    private com.facebook.imagepipeline.common.a pnq;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pno = com.facebook.c.c.pje;
        this.pfO = -1;
        this.pfP = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdM = 1;
        this.pnp = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pnm = aVar.clone();
        this.pnn = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pno = com.facebook.c.c.pje;
        this.pfO = -1;
        this.pfP = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdM = 1;
        this.pnp = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pnm = null;
        this.pnn = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pnp = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.evA();
        }
        return null;
    }

    public e evA() {
        e eVar;
        if (this.pnn != null) {
            eVar = new e(this.pnn, this.pnp);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.pnm);
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
        com.facebook.common.references.a.c(this.pnm);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pnm)) {
            z = this.pnn != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> evB() {
        return com.facebook.common.references.a.b(this.pnm);
    }

    public InputStream getInputStream() {
        if (this.pnn != null) {
            return this.pnn.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.pnm);
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
        this.pno = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void QJ(int i) {
        this.pfO = i;
    }

    public void QK(int i) {
        this.pfP = i;
    }

    public void setSampleSize(int i) {
        this.bdM = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pnq = aVar;
    }

    public com.facebook.c.c evC() {
        return this.pno;
    }

    public int evy() {
        return this.pfO;
    }

    public int evz() {
        return this.pfP;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.bdM;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evD() {
        return this.pnq;
    }

    public boolean QL(int i) {
        if (this.pno == com.facebook.c.b.piU && this.pnn == null) {
            com.facebook.common.internal.g.checkNotNull(this.pnm);
            PooledByteBuffer pooledByteBuffer = this.pnm.get();
            return pooledByteBuffer.PS(i + (-2)) == -1 && pooledByteBuffer.PS(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pnm == null || this.pnm.get() == null) ? this.pnp : this.pnm.get().size();
    }

    public String QM(int i) {
        com.facebook.common.references.a<PooledByteBuffer> evB = evB();
        if (evB == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = evB.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            evB.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            evB.close();
        }
    }

    public void evE() {
        Pair<Integer, Integer> evG;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.pno = v;
        if (com.facebook.c.b.a(v)) {
            evG = evF();
        } else {
            evG = evG();
        }
        if (v == com.facebook.c.b.piU && this.pfO == -1) {
            if (evG != null) {
                this.pfP = com.facebook.d.b.z(getInputStream());
                this.pfO = com.facebook.d.b.Rp(this.pfP);
                return;
            }
            return;
        }
        this.pfO = 0;
    }

    private Pair<Integer, Integer> evF() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> evG() {
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
        this.pno = eVar.evC();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.pfO = eVar.evy();
        this.pfP = eVar.evz();
        this.bdM = eVar.getSampleSize();
        this.pnp = eVar.getSize();
        this.pnq = eVar.evD();
    }

    public static boolean d(e eVar) {
        return eVar.pfO >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
