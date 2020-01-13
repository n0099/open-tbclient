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
    private int lLv;
    private int lLw;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> lTd;
    @Nullable
    private final j<FileInputStream> lTe;
    private com.facebook.c.c lTf;
    private int lTg;
    @Nullable
    private com.facebook.imagepipeline.common.a lTh;
    private int mHeight;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.lTf = com.facebook.c.c.lOM;
        this.lLv = -1;
        this.lLw = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.akb = 1;
        this.lTg = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.lTd = aVar.clone();
        this.lTe = null;
    }

    public e(j<FileInputStream> jVar) {
        this.lTf = com.facebook.c.c.lOM;
        this.lLv = -1;
        this.lLw = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.akb = 1;
        this.lTg = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.lTd = null;
        this.lTe = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.lTg = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dph();
        }
        return null;
    }

    public e dph() {
        e eVar;
        if (this.lTe != null) {
            eVar = new e(this.lTe, this.lTg);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTd);
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
        com.facebook.common.references.a.c(this.lTd);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.lTd)) {
            z = this.lTe != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dpi() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTd);
    }

    public InputStream getInputStream() {
        if (this.lTe != null) {
            return this.lTe.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lTd);
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
        this.lTf = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Ig(int i) {
        this.lLv = i;
    }

    public void Ih(int i) {
        this.lLw = i;
    }

    public void setSampleSize(int i) {
        this.akb = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTh = aVar;
    }

    public com.facebook.c.c dpj() {
        return this.lTf;
    }

    public int dpf() {
        return this.lLv;
    }

    public int dpg() {
        return this.lLw;
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
    public com.facebook.imagepipeline.common.a dpk() {
        return this.lTh;
    }

    public boolean Ii(int i) {
        if (this.lTf == com.facebook.c.b.lOC && this.lTe == null) {
            com.facebook.common.internal.g.checkNotNull(this.lTd);
            PooledByteBuffer pooledByteBuffer = this.lTd.get();
            return pooledByteBuffer.Ho(i + (-2)) == -1 && pooledByteBuffer.Ho(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.lTd == null || this.lTd.get() == null) ? this.lTg : this.lTd.get().size();
    }

    public String Ij(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dpi = dpi();
        if (dpi == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dpi.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dpi.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dpi.close();
        }
    }

    public void dpl() {
        Pair<Integer, Integer> dpn;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.lTf = v;
        if (com.facebook.c.b.a(v)) {
            dpn = dpm();
        } else {
            dpn = dpn();
        }
        if (v == com.facebook.c.b.lOC && this.lLv == -1) {
            if (dpn != null) {
                this.lLw = com.facebook.d.b.z(getInputStream());
                this.lLv = com.facebook.d.b.IM(this.lLw);
                return;
            }
            return;
        }
        this.lLv = 0;
    }

    private Pair<Integer, Integer> dpm() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> dpn() {
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
        this.lTf = eVar.dpj();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lLv = eVar.dpf();
        this.lLw = eVar.dpg();
        this.akb = eVar.getSampleSize();
        this.lTg = eVar.getSize();
        this.lTh = eVar.dpk();
    }

    public static boolean d(e eVar) {
        return eVar.lLv >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
