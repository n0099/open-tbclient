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
/* loaded from: classes5.dex */
public class e implements Closeable {
    private int baJ;
    private int mHeight;
    private int mWidth;
    @Nullable
    private com.facebook.imagepipeline.common.a pAa;
    private int psC;
    private int psD;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pzW;
    @Nullable
    private final j<FileInputStream> pzX;
    private com.facebook.c.c pzY;
    private int pzZ;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pzY = com.facebook.c.c.pvQ;
        this.psC = -1;
        this.psD = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.baJ = 1;
        this.pzZ = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pzW = aVar.clone();
        this.pzX = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pzY = com.facebook.c.c.pvQ;
        this.psC = -1;
        this.psD = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.baJ = 1;
        this.pzZ = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pzW = null;
        this.pzX = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pzZ = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.evT();
        }
        return null;
    }

    public e evT() {
        e eVar;
        if (this.pzX != null) {
            eVar = new e(this.pzX, this.pzZ);
        } else {
            com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pzW);
            if (b2 == null) {
                eVar = null;
            } else {
                try {
                    eVar = new e(b2);
                } finally {
                    com.facebook.common.references.a.c(b2);
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
        com.facebook.common.references.a.c(this.pzW);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pzW)) {
            z = this.pzX != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> evU() {
        return com.facebook.common.references.a.b(this.pzW);
    }

    public InputStream getInputStream() {
        if (this.pzX != null) {
            return this.pzX.get();
        }
        com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pzW);
        if (b2 != null) {
            try {
                return new com.facebook.common.memory.h((PooledByteBuffer) b2.get());
            } finally {
                com.facebook.common.references.a.c(b2);
            }
        }
        return null;
    }

    public void c(com.facebook.c.c cVar) {
        this.pzY = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Pq(int i) {
        this.psC = i;
    }

    public void Pr(int i) {
        this.psD = i;
    }

    public void setSampleSize(int i) {
        this.baJ = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pAa = aVar;
    }

    public com.facebook.c.c evV() {
        return this.pzY;
    }

    public int evR() {
        return this.psC;
    }

    public int evS() {
        return this.psD;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.baJ;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evW() {
        return this.pAa;
    }

    public boolean Ps(int i) {
        if (this.pzY == com.facebook.c.b.pvG && this.pzX == null) {
            com.facebook.common.internal.g.checkNotNull(this.pzW);
            PooledByteBuffer pooledByteBuffer = this.pzW.get();
            return pooledByteBuffer.Oz(i + (-2)) == -1 && pooledByteBuffer.Oz(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pzW == null || this.pzW.get() == null) ? this.pzZ : this.pzW.get().size();
    }

    public String Pt(int i) {
        com.facebook.common.references.a<PooledByteBuffer> evU = evU();
        if (evU == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = evU.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            evU.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            evU.close();
        }
    }

    public void evX() {
        Pair<Integer, Integer> evZ;
        com.facebook.c.c y = com.facebook.c.d.y(getInputStream());
        this.pzY = y;
        if (com.facebook.c.b.a(y)) {
            evZ = evY();
        } else {
            evZ = evZ();
        }
        if (y == com.facebook.c.b.pvG && this.psC == -1) {
            if (evZ != null) {
                this.psD = com.facebook.d.b.C(getInputStream());
                this.psC = com.facebook.d.b.PV(this.psD);
                return;
            }
            return;
        }
        this.psC = 0;
    }

    private Pair<Integer, Integer> evY() {
        Pair<Integer, Integer> E = com.facebook.d.e.E(getInputStream());
        if (E != null) {
            this.mWidth = ((Integer) E.first).intValue();
            this.mHeight = ((Integer) E.second).intValue();
        }
        return E;
    }

    private Pair<Integer, Integer> evZ() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> B = com.facebook.d.a.B(inputStream);
            if (B != null) {
                this.mWidth = ((Integer) B.first).intValue();
                this.mHeight = ((Integer) B.second).intValue();
            }
            return B;
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
        this.pzY = eVar.evV();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.psC = eVar.evR();
        this.psD = eVar.evS();
        this.baJ = eVar.getSampleSize();
        this.pzZ = eVar.getSize();
        this.pAa = eVar.evW();
    }

    public static boolean d(e eVar) {
        return eVar.psC >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
