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
    private int pfM;
    private int pfN;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pnk;
    @Nullable
    private final j<FileInputStream> pnl;
    private com.facebook.c.c pnm;
    private int pnn;
    @Nullable
    private com.facebook.imagepipeline.common.a pno;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pnm = com.facebook.c.c.pjc;
        this.pfM = -1;
        this.pfN = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdM = 1;
        this.pnn = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pnk = aVar.clone();
        this.pnl = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pnm = com.facebook.c.c.pjc;
        this.pfM = -1;
        this.pfN = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bdM = 1;
        this.pnn = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pnk = null;
        this.pnl = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pnn = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.evz();
        }
        return null;
    }

    public e evz() {
        e eVar;
        if (this.pnl != null) {
            eVar = new e(this.pnl, this.pnn);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.pnk);
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
        com.facebook.common.references.a.c(this.pnk);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pnk)) {
            z = this.pnl != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> evA() {
        return com.facebook.common.references.a.b(this.pnk);
    }

    public InputStream getInputStream() {
        if (this.pnl != null) {
            return this.pnl.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.pnk);
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
        this.pnm = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void QJ(int i) {
        this.pfM = i;
    }

    public void QK(int i) {
        this.pfN = i;
    }

    public void setSampleSize(int i) {
        this.bdM = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pno = aVar;
    }

    public com.facebook.c.c evB() {
        return this.pnm;
    }

    public int evx() {
        return this.pfM;
    }

    public int evy() {
        return this.pfN;
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
    public com.facebook.imagepipeline.common.a evC() {
        return this.pno;
    }

    public boolean QL(int i) {
        if (this.pnm == com.facebook.c.b.piS && this.pnl == null) {
            com.facebook.common.internal.g.checkNotNull(this.pnk);
            PooledByteBuffer pooledByteBuffer = this.pnk.get();
            return pooledByteBuffer.PS(i + (-2)) == -1 && pooledByteBuffer.PS(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pnk == null || this.pnk.get() == null) ? this.pnn : this.pnk.get().size();
    }

    public String QM(int i) {
        com.facebook.common.references.a<PooledByteBuffer> evA = evA();
        if (evA == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = evA.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            evA.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            evA.close();
        }
    }

    public void evD() {
        Pair<Integer, Integer> evF;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.pnm = v;
        if (com.facebook.c.b.a(v)) {
            evF = evE();
        } else {
            evF = evF();
        }
        if (v == com.facebook.c.b.piS && this.pfM == -1) {
            if (evF != null) {
                this.pfN = com.facebook.d.b.z(getInputStream());
                this.pfM = com.facebook.d.b.Rp(this.pfN);
                return;
            }
            return;
        }
        this.pfM = 0;
    }

    private Pair<Integer, Integer> evE() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> evF() {
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
        this.pnm = eVar.evB();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.pfM = eVar.evx();
        this.pfN = eVar.evy();
        this.bdM = eVar.getSampleSize();
        this.pnn = eVar.getSize();
        this.pno = eVar.evC();
    }

    public static boolean d(e eVar) {
        return eVar.pfM >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
