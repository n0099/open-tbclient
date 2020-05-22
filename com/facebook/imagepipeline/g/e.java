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
    private int aKs;
    private int mHeight;
    private int mWidth;
    private int mps;
    private int mpt;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> mxo;
    @Nullable
    private final j<FileInputStream> mxp;
    private com.facebook.c.c mxq;
    private int mxr;
    @Nullable
    private com.facebook.imagepipeline.common.a mxs;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.mxq = com.facebook.c.c.msV;
        this.mps = -1;
        this.mpt = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aKs = 1;
        this.mxr = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.mxo = aVar.clone();
        this.mxp = null;
    }

    public e(j<FileInputStream> jVar) {
        this.mxq = com.facebook.c.c.msV;
        this.mps = -1;
        this.mpt = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aKs = 1;
        this.mxr = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.mxo = null;
        this.mxp = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.mxr = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dAj();
        }
        return null;
    }

    public e dAj() {
        e eVar;
        if (this.mxp != null) {
            eVar = new e(this.mxp, this.mxr);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mxo);
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
        com.facebook.common.references.a.c(this.mxo);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.mxo)) {
            z = this.mxp != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dAk() {
        return com.facebook.common.references.a.b(this.mxo);
    }

    public InputStream getInputStream() {
        if (this.mxp != null) {
            return this.mxp.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mxo);
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
        this.mxq = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void HF(int i) {
        this.mps = i;
    }

    public void HG(int i) {
        this.mpt = i;
    }

    public void setSampleSize(int i) {
        this.aKs = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mxs = aVar;
    }

    public com.facebook.c.c dAl() {
        return this.mxq;
    }

    public int dAh() {
        return this.mps;
    }

    public int dAi() {
        return this.mpt;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aKs;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dAm() {
        return this.mxs;
    }

    public boolean HH(int i) {
        if (this.mxq == com.facebook.c.b.msL && this.mxp == null) {
            com.facebook.common.internal.g.checkNotNull(this.mxo);
            PooledByteBuffer pooledByteBuffer = this.mxo.get();
            return pooledByteBuffer.GM(i + (-2)) == -1 && pooledByteBuffer.GM(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.mxo == null || this.mxo.get() == null) ? this.mxr : this.mxo.get().size();
    }

    public String HI(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dAk = dAk();
        if (dAk == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dAk.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dAk.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dAk.close();
        }
    }

    public void dAn() {
        Pair<Integer, Integer> dAp;
        com.facebook.c.c t = com.facebook.c.d.t(getInputStream());
        this.mxq = t;
        if (com.facebook.c.b.a(t)) {
            dAp = dAo();
        } else {
            dAp = dAp();
        }
        if (t == com.facebook.c.b.msL && this.mps == -1) {
            if (dAp != null) {
                this.mpt = com.facebook.d.b.x(getInputStream());
                this.mps = com.facebook.d.b.Im(this.mpt);
                return;
            }
            return;
        }
        this.mps = 0;
    }

    private Pair<Integer, Integer> dAo() {
        Pair<Integer, Integer> z = com.facebook.d.e.z(getInputStream());
        if (z != null) {
            this.mWidth = ((Integer) z.first).intValue();
            this.mHeight = ((Integer) z.second).intValue();
        }
        return z;
    }

    private Pair<Integer, Integer> dAp() {
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
        this.mxq = eVar.dAl();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.mps = eVar.dAh();
        this.mpt = eVar.dAi();
        this.aKs = eVar.getSampleSize();
        this.mxr = eVar.getSize();
        this.mxs = eVar.dAm();
    }

    public static boolean d(e eVar) {
        return eVar.mps >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
