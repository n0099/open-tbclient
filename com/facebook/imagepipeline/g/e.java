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
/* loaded from: classes3.dex */
public class e implements Closeable {
    private int aOt;
    private int mHeight;
    private int mUN;
    private int mUO;
    private int mWidth;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> ncJ;
    @Nullable
    private final j<FileInputStream> ncK;
    private com.facebook.c.c ncL;
    private int ncM;
    @Nullable
    private com.facebook.imagepipeline.common.a ncN;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.ncL = com.facebook.c.c.mYp;
        this.mUN = -1;
        this.mUO = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aOt = 1;
        this.ncM = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.ncJ = aVar.clone();
        this.ncK = null;
    }

    public e(j<FileInputStream> jVar) {
        this.ncL = com.facebook.c.c.mYp;
        this.mUN = -1;
        this.mUO = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aOt = 1;
        this.ncM = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.ncJ = null;
        this.ncK = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.ncM = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dIp();
        }
        return null;
    }

    public e dIp() {
        e eVar;
        if (this.ncK != null) {
            eVar = new e(this.ncK, this.ncM);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ncJ);
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
        com.facebook.common.references.a.c(this.ncJ);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.ncJ)) {
            z = this.ncK != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dIq() {
        return com.facebook.common.references.a.b(this.ncJ);
    }

    public InputStream getInputStream() {
        if (this.ncK != null) {
            return this.ncK.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ncJ);
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
        this.ncL = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Jj(int i) {
        this.mUN = i;
    }

    public void Jk(int i) {
        this.mUO = i;
    }

    public void setSampleSize(int i) {
        this.aOt = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.ncN = aVar;
    }

    public com.facebook.c.c dIr() {
        return this.ncL;
    }

    public int dIn() {
        return this.mUN;
    }

    public int dIo() {
        return this.mUO;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aOt;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dIs() {
        return this.ncN;
    }

    public boolean Jl(int i) {
        if (this.ncL == com.facebook.c.b.mYf && this.ncK == null) {
            com.facebook.common.internal.g.checkNotNull(this.ncJ);
            PooledByteBuffer pooledByteBuffer = this.ncJ.get();
            return pooledByteBuffer.Iq(i + (-2)) == -1 && pooledByteBuffer.Iq(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.ncJ == null || this.ncJ.get() == null) ? this.ncM : this.ncJ.get().size();
    }

    public String Jm(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dIq = dIq();
        if (dIq == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dIq.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dIq.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dIq.close();
        }
    }

    public void dIt() {
        Pair<Integer, Integer> dIv;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.ncL = s;
        if (com.facebook.c.b.a(s)) {
            dIv = dIu();
        } else {
            dIv = dIv();
        }
        if (s == com.facebook.c.b.mYf && this.mUN == -1) {
            if (dIv != null) {
                this.mUO = com.facebook.d.b.w(getInputStream());
                this.mUN = com.facebook.d.b.JQ(this.mUO);
                return;
            }
            return;
        }
        this.mUN = 0;
    }

    private Pair<Integer, Integer> dIu() {
        Pair<Integer, Integer> y = com.facebook.d.e.y(getInputStream());
        if (y != null) {
            this.mWidth = ((Integer) y.first).intValue();
            this.mHeight = ((Integer) y.second).intValue();
        }
        return y;
    }

    private Pair<Integer, Integer> dIv() {
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
        this.ncL = eVar.dIr();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.mUN = eVar.dIn();
        this.mUO = eVar.dIo();
        this.aOt = eVar.getSampleSize();
        this.ncM = eVar.getSize();
        this.ncN = eVar.dIs();
    }

    public static boolean d(e eVar) {
        return eVar.mUN >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
