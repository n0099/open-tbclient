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
/* loaded from: classes8.dex */
public class e implements Closeable {
    private int aTG;
    private int mHeight;
    private int mWidth;
    private int noF;
    private int noG;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> nwB;
    @Nullable
    private final j<FileInputStream> nwC;
    private com.facebook.c.c nwD;
    private int nwE;
    @Nullable
    private com.facebook.imagepipeline.common.a nwF;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.nwD = com.facebook.c.c.nsg;
        this.noF = -1;
        this.noG = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aTG = 1;
        this.nwE = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.nwB = aVar.clone();
        this.nwC = null;
    }

    public e(j<FileInputStream> jVar) {
        this.nwD = com.facebook.c.c.nsg;
        this.noF = -1;
        this.noG = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aTG = 1;
        this.nwE = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.nwB = null;
        this.nwC = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.nwE = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dUp();
        }
        return null;
    }

    public e dUp() {
        e eVar;
        if (this.nwC != null) {
            eVar = new e(this.nwC, this.nwE);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nwB);
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
        com.facebook.common.references.a.c(this.nwB);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.nwB)) {
            z = this.nwC != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dUq() {
        return com.facebook.common.references.a.b(this.nwB);
    }

    public InputStream getInputStream() {
        if (this.nwC != null) {
            return this.nwC.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.nwB);
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
        this.nwD = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void LN(int i) {
        this.noF = i;
    }

    public void LO(int i) {
        this.noG = i;
    }

    public void setSampleSize(int i) {
        this.aTG = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.nwF = aVar;
    }

    public com.facebook.c.c dUr() {
        return this.nwD;
    }

    public int dUn() {
        return this.noF;
    }

    public int dUo() {
        return this.noG;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aTG;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dUs() {
        return this.nwF;
    }

    public boolean LP(int i) {
        if (this.nwD == com.facebook.c.b.nrW && this.nwC == null) {
            com.facebook.common.internal.g.checkNotNull(this.nwB);
            PooledByteBuffer pooledByteBuffer = this.nwB.get();
            return pooledByteBuffer.KU(i + (-2)) == -1 && pooledByteBuffer.KU(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.nwB == null || this.nwB.get() == null) ? this.nwE : this.nwB.get().size();
    }

    public String LQ(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dUq = dUq();
        if (dUq == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dUq.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dUq.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dUq.close();
        }
    }

    public void dUt() {
        Pair<Integer, Integer> dUv;
        com.facebook.c.c t = com.facebook.c.d.t(getInputStream());
        this.nwD = t;
        if (com.facebook.c.b.a(t)) {
            dUv = dUu();
        } else {
            dUv = dUv();
        }
        if (t == com.facebook.c.b.nrW && this.noF == -1) {
            if (dUv != null) {
                this.noG = com.facebook.d.b.x(getInputStream());
                this.noF = com.facebook.d.b.Mu(this.noG);
                return;
            }
            return;
        }
        this.noF = 0;
    }

    private Pair<Integer, Integer> dUu() {
        Pair<Integer, Integer> z = com.facebook.d.e.z(getInputStream());
        if (z != null) {
            this.mWidth = ((Integer) z.first).intValue();
            this.mHeight = ((Integer) z.second).intValue();
        }
        return z;
    }

    private Pair<Integer, Integer> dUv() {
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
        this.nwD = eVar.dUr();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.noF = eVar.dUn();
        this.noG = eVar.dUo();
        this.aTG = eVar.getSampleSize();
        this.nwE = eVar.getSize();
        this.nwF = eVar.dUs();
    }

    public static boolean d(e eVar) {
        return eVar.noF >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
