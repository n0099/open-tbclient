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
    private int mqC;
    private int mqD;
    private com.facebook.c.c myA;
    private int myB;
    @Nullable
    private com.facebook.imagepipeline.common.a myC;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> myy;
    @Nullable
    private final j<FileInputStream> myz;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.myA = com.facebook.c.c.muf;
        this.mqC = -1;
        this.mqD = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aKs = 1;
        this.myB = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.myy = aVar.clone();
        this.myz = null;
    }

    public e(j<FileInputStream> jVar) {
        this.myA = com.facebook.c.c.muf;
        this.mqC = -1;
        this.mqD = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aKs = 1;
        this.myB = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.myy = null;
        this.myz = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.myB = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dAx();
        }
        return null;
    }

    public e dAx() {
        e eVar;
        if (this.myz != null) {
            eVar = new e(this.myz, this.myB);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.myy);
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
        com.facebook.common.references.a.c(this.myy);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.myy)) {
            z = this.myz != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dAy() {
        return com.facebook.common.references.a.b(this.myy);
    }

    public InputStream getInputStream() {
        if (this.myz != null) {
            return this.myz.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.myy);
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
        this.myA = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void HH(int i) {
        this.mqC = i;
    }

    public void HI(int i) {
        this.mqD = i;
    }

    public void setSampleSize(int i) {
        this.aKs = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.myC = aVar;
    }

    public com.facebook.c.c dAz() {
        return this.myA;
    }

    public int dAv() {
        return this.mqC;
    }

    public int dAw() {
        return this.mqD;
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
    public com.facebook.imagepipeline.common.a dAA() {
        return this.myC;
    }

    public boolean HJ(int i) {
        if (this.myA == com.facebook.c.b.mtV && this.myz == null) {
            com.facebook.common.internal.g.checkNotNull(this.myy);
            PooledByteBuffer pooledByteBuffer = this.myy.get();
            return pooledByteBuffer.GO(i + (-2)) == -1 && pooledByteBuffer.GO(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.myy == null || this.myy.get() == null) ? this.myB : this.myy.get().size();
    }

    public String HK(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dAy = dAy();
        if (dAy == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dAy.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dAy.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dAy.close();
        }
    }

    public void dAB() {
        Pair<Integer, Integer> dAD;
        com.facebook.c.c t = com.facebook.c.d.t(getInputStream());
        this.myA = t;
        if (com.facebook.c.b.a(t)) {
            dAD = dAC();
        } else {
            dAD = dAD();
        }
        if (t == com.facebook.c.b.mtV && this.mqC == -1) {
            if (dAD != null) {
                this.mqD = com.facebook.d.b.x(getInputStream());
                this.mqC = com.facebook.d.b.Io(this.mqD);
                return;
            }
            return;
        }
        this.mqC = 0;
    }

    private Pair<Integer, Integer> dAC() {
        Pair<Integer, Integer> z = com.facebook.d.e.z(getInputStream());
        if (z != null) {
            this.mWidth = ((Integer) z.first).intValue();
            this.mHeight = ((Integer) z.second).intValue();
        }
        return z;
    }

    private Pair<Integer, Integer> dAD() {
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
        this.myA = eVar.dAz();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.mqC = eVar.dAv();
        this.mqD = eVar.dAw();
        this.aKs = eVar.getSampleSize();
        this.myB = eVar.getSize();
        this.myC = eVar.dAA();
    }

    public static boolean d(e eVar) {
        return eVar.mqC >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
