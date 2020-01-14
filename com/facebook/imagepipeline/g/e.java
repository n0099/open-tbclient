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
    private int akb;
    private int lLA;
    private int lLB;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> lTi;
    @Nullable
    private final j<FileInputStream> lTj;
    private com.facebook.c.c lTk;
    private int lTl;
    @Nullable
    private com.facebook.imagepipeline.common.a lTm;
    private int mHeight;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.lTk = com.facebook.c.c.lOR;
        this.lLA = -1;
        this.lLB = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.akb = 1;
        this.lTl = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.lTi = aVar.clone();
        this.lTj = null;
    }

    public e(j<FileInputStream> jVar) {
        this.lTk = com.facebook.c.c.lOR;
        this.lLA = -1;
        this.lLB = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.akb = 1;
        this.lTl = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.lTi = null;
        this.lTj = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.lTl = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dpj();
        }
        return null;
    }

    public e dpj() {
        e eVar;
        if (this.lTj != null) {
            eVar = new e(this.lTj, this.lTl);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTi);
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
        com.facebook.common.references.a.c(this.lTi);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.lTi)) {
            z = this.lTj != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dpk() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTi);
    }

    public InputStream getInputStream() {
        if (this.lTj != null) {
            return this.lTj.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTi);
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
        this.lTk = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Ig(int i) {
        this.lLA = i;
    }

    public void Ih(int i) {
        this.lLB = i;
    }

    public void setSampleSize(int i) {
        this.akb = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTm = aVar;
    }

    public com.facebook.c.c dpl() {
        return this.lTk;
    }

    public int dph() {
        return this.lLA;
    }

    public int dpi() {
        return this.lLB;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.akb;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dpm() {
        return this.lTm;
    }

    public boolean Ii(int i) {
        if (this.lTk == com.facebook.c.b.lOH && this.lTj == null) {
            com.facebook.common.internal.g.checkNotNull(this.lTi);
            PooledByteBuffer pooledByteBuffer = this.lTi.get();
            return pooledByteBuffer.Ho(i + (-2)) == -1 && pooledByteBuffer.Ho(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.lTi == null || this.lTi.get() == null) ? this.lTl : this.lTi.get().size();
    }

    public String Ij(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dpk = dpk();
        if (dpk == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dpk.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dpk.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dpk.close();
        }
    }

    public void dpn() {
        Pair<Integer, Integer> dpp;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.lTk = v;
        if (com.facebook.c.b.a(v)) {
            dpp = dpo();
        } else {
            dpp = dpp();
        }
        if (v == com.facebook.c.b.lOH && this.lLA == -1) {
            if (dpp != null) {
                this.lLB = com.facebook.d.b.z(getInputStream());
                this.lLA = com.facebook.d.b.IM(this.lLB);
                return;
            }
            return;
        }
        this.lLA = 0;
    }

    private Pair<Integer, Integer> dpo() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> dpp() {
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
        this.lTk = eVar.dpl();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lLA = eVar.dph();
        this.lLB = eVar.dpi();
        this.akb = eVar.getSampleSize();
        this.lTl = eVar.getSize();
        this.lTm = eVar.dpm();
    }

    public static boolean d(e eVar) {
        return eVar.lLA >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
