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
    private int psB;
    private int psC;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pzV;
    @Nullable
    private final j<FileInputStream> pzW;
    private com.facebook.c.c pzX;
    private int pzY;
    @Nullable
    private com.facebook.imagepipeline.common.a pzZ;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pzX = com.facebook.c.c.pvP;
        this.psB = -1;
        this.psC = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.baJ = 1;
        this.pzY = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pzV = aVar.clone();
        this.pzW = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pzX = com.facebook.c.c.pvP;
        this.psB = -1;
        this.psC = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.baJ = 1;
        this.pzY = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pzV = null;
        this.pzW = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pzY = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.evT();
        }
        return null;
    }

    public e evT() {
        e eVar;
        if (this.pzW != null) {
            eVar = new e(this.pzW, this.pzY);
        } else {
            com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pzV);
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
        com.facebook.common.references.a.c(this.pzV);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pzV)) {
            z = this.pzW != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> evU() {
        return com.facebook.common.references.a.b(this.pzV);
    }

    public InputStream getInputStream() {
        if (this.pzW != null) {
            return this.pzW.get();
        }
        com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pzV);
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
        this.pzX = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Pq(int i) {
        this.psB = i;
    }

    public void Pr(int i) {
        this.psC = i;
    }

    public void setSampleSize(int i) {
        this.baJ = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pzZ = aVar;
    }

    public com.facebook.c.c evV() {
        return this.pzX;
    }

    public int evR() {
        return this.psB;
    }

    public int evS() {
        return this.psC;
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
        return this.pzZ;
    }

    public boolean Ps(int i) {
        if (this.pzX == com.facebook.c.b.pvF && this.pzW == null) {
            com.facebook.common.internal.g.checkNotNull(this.pzV);
            PooledByteBuffer pooledByteBuffer = this.pzV.get();
            return pooledByteBuffer.Oz(i + (-2)) == -1 && pooledByteBuffer.Oz(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pzV == null || this.pzV.get() == null) ? this.pzY : this.pzV.get().size();
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
        this.pzX = y;
        if (com.facebook.c.b.a(y)) {
            evZ = evY();
        } else {
            evZ = evZ();
        }
        if (y == com.facebook.c.b.pvF && this.psB == -1) {
            if (evZ != null) {
                this.psC = com.facebook.d.b.C(getInputStream());
                this.psB = com.facebook.d.b.PV(this.psC);
                return;
            }
            return;
        }
        this.psB = 0;
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
        this.pzX = eVar.evV();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.psB = eVar.evR();
        this.psC = eVar.evS();
        this.baJ = eVar.getSampleSize();
        this.pzY = eVar.getSize();
        this.pzZ = eVar.evW();
    }

    public static boolean d(e eVar) {
        return eVar.psB >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
