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
    private int aEQ;
    private int lVA;
    private int lVz;
    private int mHeight;
    private int mWidth;
    private int mdA;
    @Nullable
    private com.facebook.imagepipeline.common.a mdB;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> mdx;
    @Nullable
    private final j<FileInputStream> mdy;
    private com.facebook.c.c mdz;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.mdz = com.facebook.c.c.lZa;
        this.lVz = -1;
        this.lVA = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aEQ = 1;
        this.mdA = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.mdx = aVar.clone();
        this.mdy = null;
    }

    public e(j<FileInputStream> jVar) {
        this.mdz = com.facebook.c.c.lZa;
        this.lVz = -1;
        this.lVA = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aEQ = 1;
        this.mdA = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.mdx = null;
        this.mdy = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.mdA = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dsQ();
        }
        return null;
    }

    public e dsQ() {
        e eVar;
        if (this.mdy != null) {
            eVar = new e(this.mdy, this.mdA);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mdx);
            if (b == null) {
                eVar = null;
            } else {
                try {
                    eVar = new e(b);
                } finally {
                    com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.mdx);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.mdx)) {
            z = this.mdy != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dsR() {
        return com.facebook.common.references.a.b(this.mdx);
    }

    public InputStream getInputStream() {
        if (this.mdy != null) {
            return this.mdy.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mdx);
        if (b != null) {
            try {
                return new com.facebook.common.memory.h((PooledByteBuffer) b.get());
            } finally {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) b);
            }
        }
        return null;
    }

    public void c(com.facebook.c.c cVar) {
        this.mdz = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void GT(int i) {
        this.lVz = i;
    }

    public void GU(int i) {
        this.lVA = i;
    }

    public void setSampleSize(int i) {
        this.aEQ = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mdB = aVar;
    }

    public com.facebook.c.c dsS() {
        return this.mdz;
    }

    public int dsO() {
        return this.lVz;
    }

    public int dsP() {
        return this.lVA;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aEQ;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dsT() {
        return this.mdB;
    }

    public boolean GV(int i) {
        if (this.mdz == com.facebook.c.b.lYQ && this.mdy == null) {
            com.facebook.common.internal.g.checkNotNull(this.mdx);
            PooledByteBuffer pooledByteBuffer = this.mdx.get();
            return pooledByteBuffer.Ga(i + (-2)) == -1 && pooledByteBuffer.Ga(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.mdx == null || this.mdx.get() == null) ? this.mdA : this.mdx.get().size();
    }

    public String GW(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dsR = dsR();
        if (dsR == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dsR.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dsR.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dsR.close();
        }
    }

    public void dsU() {
        Pair<Integer, Integer> dsW;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.mdz = s;
        if (com.facebook.c.b.a(s)) {
            dsW = dsV();
        } else {
            dsW = dsW();
        }
        if (s == com.facebook.c.b.lYQ && this.lVz == -1) {
            if (dsW != null) {
                this.lVA = com.facebook.d.b.w(getInputStream());
                this.lVz = com.facebook.d.b.HA(this.lVA);
                return;
            }
            return;
        }
        this.lVz = 0;
    }

    private Pair<Integer, Integer> dsV() {
        Pair<Integer, Integer> y = com.facebook.d.e.y(getInputStream());
        if (y != null) {
            this.mWidth = ((Integer) y.first).intValue();
            this.mHeight = ((Integer) y.second).intValue();
        }
        return y;
    }

    private Pair<Integer, Integer> dsW() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> v = com.facebook.d.a.v(inputStream);
            if (v != null) {
                this.mWidth = ((Integer) v.first).intValue();
                this.mHeight = ((Integer) v.second).intValue();
            }
            return v;
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
        this.mdz = eVar.dsS();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lVz = eVar.dsO();
        this.lVA = eVar.dsP();
        this.aEQ = eVar.getSampleSize();
        this.mdA = eVar.getSize();
        this.mdB = eVar.dsT();
    }

    public static boolean d(e eVar) {
        return eVar.lVz >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
