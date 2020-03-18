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
    private int ams;
    private int lOa;
    private int lOb;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> lVI;
    @Nullable
    private final j<FileInputStream> lVJ;
    private com.facebook.c.c lVK;
    private int lVL;
    @Nullable
    private com.facebook.imagepipeline.common.a lVM;
    private int mHeight;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.lVK = com.facebook.c.c.lRr;
        this.lOa = -1;
        this.lOb = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.ams = 1;
        this.lVL = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.lVI = aVar.clone();
        this.lVJ = null;
    }

    public e(j<FileInputStream> jVar) {
        this.lVK = com.facebook.c.c.lRr;
        this.lOa = -1;
        this.lOb = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.ams = 1;
        this.lVL = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.lVI = null;
        this.lVJ = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.lVL = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dqV();
        }
        return null;
    }

    public e dqV() {
        e eVar;
        if (this.lVJ != null) {
            eVar = new e(this.lVJ, this.lVL);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lVI);
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
        com.facebook.common.references.a.c(this.lVI);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.lVI)) {
            z = this.lVJ != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dqW() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lVI);
    }

    public InputStream getInputStream() {
        if (this.lVJ != null) {
            return this.lVJ.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lVI);
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
        this.lVK = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Ir(int i) {
        this.lOa = i;
    }

    public void Is(int i) {
        this.lOb = i;
    }

    public void setSampleSize(int i) {
        this.ams = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lVM = aVar;
    }

    public com.facebook.c.c dqX() {
        return this.lVK;
    }

    public int dqT() {
        return this.lOa;
    }

    public int dqU() {
        return this.lOb;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.ams;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqY() {
        return this.lVM;
    }

    public boolean It(int i) {
        if (this.lVK == com.facebook.c.b.lRh && this.lVJ == null) {
            com.facebook.common.internal.g.checkNotNull(this.lVI);
            PooledByteBuffer pooledByteBuffer = this.lVI.get();
            return pooledByteBuffer.Hz(i + (-2)) == -1 && pooledByteBuffer.Hz(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.lVI == null || this.lVI.get() == null) ? this.lVL : this.lVI.get().size();
    }

    public String Iu(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dqW = dqW();
        if (dqW == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dqW.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dqW.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dqW.close();
        }
    }

    public void dqZ() {
        Pair<Integer, Integer> drb;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.lVK = v;
        if (com.facebook.c.b.a(v)) {
            drb = dra();
        } else {
            drb = drb();
        }
        if (v == com.facebook.c.b.lRh && this.lOa == -1) {
            if (drb != null) {
                this.lOb = com.facebook.d.b.z(getInputStream());
                this.lOa = com.facebook.d.b.IX(this.lOb);
                return;
            }
            return;
        }
        this.lOa = 0;
    }

    private Pair<Integer, Integer> dra() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> drb() {
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
        this.lVK = eVar.dqX();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lOa = eVar.dqT();
        this.lOb = eVar.dqU();
        this.ams = eVar.getSampleSize();
        this.lVL = eVar.getSize();
        this.lVM = eVar.dqY();
    }

    public static boolean d(e eVar) {
        return eVar.lOa >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
