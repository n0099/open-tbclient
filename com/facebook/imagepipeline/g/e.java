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
    private int mUP;
    private int mUQ;
    private int mWidth;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> ncL;
    @Nullable
    private final j<FileInputStream> ncM;
    private com.facebook.c.c ncN;
    private int ncO;
    @Nullable
    private com.facebook.imagepipeline.common.a ncP;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.ncN = com.facebook.c.c.mYr;
        this.mUP = -1;
        this.mUQ = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aOt = 1;
        this.ncO = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.ncL = aVar.clone();
        this.ncM = null;
    }

    public e(j<FileInputStream> jVar) {
        this.ncN = com.facebook.c.c.mYr;
        this.mUP = -1;
        this.mUQ = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aOt = 1;
        this.ncO = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.ncL = null;
        this.ncM = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.ncO = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dIq();
        }
        return null;
    }

    public e dIq() {
        e eVar;
        if (this.ncM != null) {
            eVar = new e(this.ncM, this.ncO);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ncL);
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
        com.facebook.common.references.a.c(this.ncL);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.ncL)) {
            z = this.ncM != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dIr() {
        return com.facebook.common.references.a.b(this.ncL);
    }

    public InputStream getInputStream() {
        if (this.ncM != null) {
            return this.ncM.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.ncL);
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
        this.ncN = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Jj(int i) {
        this.mUP = i;
    }

    public void Jk(int i) {
        this.mUQ = i;
    }

    public void setSampleSize(int i) {
        this.aOt = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.ncP = aVar;
    }

    public com.facebook.c.c dIs() {
        return this.ncN;
    }

    public int dIo() {
        return this.mUP;
    }

    public int dIp() {
        return this.mUQ;
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
    public com.facebook.imagepipeline.common.a dIt() {
        return this.ncP;
    }

    public boolean Jl(int i) {
        if (this.ncN == com.facebook.c.b.mYh && this.ncM == null) {
            com.facebook.common.internal.g.checkNotNull(this.ncL);
            PooledByteBuffer pooledByteBuffer = this.ncL.get();
            return pooledByteBuffer.Iq(i + (-2)) == -1 && pooledByteBuffer.Iq(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.ncL == null || this.ncL.get() == null) ? this.ncO : this.ncL.get().size();
    }

    public String Jm(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dIr = dIr();
        if (dIr == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dIr.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dIr.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dIr.close();
        }
    }

    public void dIu() {
        Pair<Integer, Integer> dIw;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.ncN = s;
        if (com.facebook.c.b.a(s)) {
            dIw = dIv();
        } else {
            dIw = dIw();
        }
        if (s == com.facebook.c.b.mYh && this.mUP == -1) {
            if (dIw != null) {
                this.mUQ = com.facebook.d.b.w(getInputStream());
                this.mUP = com.facebook.d.b.JQ(this.mUQ);
                return;
            }
            return;
        }
        this.mUP = 0;
    }

    private Pair<Integer, Integer> dIv() {
        Pair<Integer, Integer> y = com.facebook.d.e.y(getInputStream());
        if (y != null) {
            this.mWidth = ((Integer) y.first).intValue();
            this.mHeight = ((Integer) y.second).intValue();
        }
        return y;
    }

    private Pair<Integer, Integer> dIw() {
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
        this.ncN = eVar.dIs();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.mUP = eVar.dIo();
        this.mUQ = eVar.dIp();
        this.aOt = eVar.getSampleSize();
        this.ncO = eVar.getSize();
        this.ncP = eVar.dIt();
    }

    public static boolean d(e eVar) {
        return eVar.mUP >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
