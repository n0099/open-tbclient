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
/* loaded from: classes6.dex */
public class e implements Closeable {
    private int bfz;
    private int mHeight;
    private int mWidth;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> pCP;
    @Nullable
    private final j<FileInputStream> pCQ;
    private com.facebook.c.c pCR;
    private int pCS;
    @Nullable
    private com.facebook.imagepipeline.common.a pCT;
    private int pwW;
    private int pwX;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.pCR = com.facebook.c.c.pzf;
        this.pwW = -1;
        this.pwX = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bfz = 1;
        this.pCS = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.pCP = aVar.clone();
        this.pCQ = null;
    }

    public e(j<FileInputStream> jVar) {
        this.pCR = com.facebook.c.c.pzf;
        this.pwW = -1;
        this.pwX = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bfz = 1;
        this.pCS = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.pCP = null;
        this.pCQ = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.pCS = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.ezh();
        }
        return null;
    }

    public e ezh() {
        e eVar;
        if (this.pCQ != null) {
            eVar = new e(this.pCQ, this.pCS);
        } else {
            com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pCP);
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
        com.facebook.common.references.a.c(this.pCP);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.pCP)) {
            z = this.pCQ != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> ezi() {
        return com.facebook.common.references.a.b(this.pCP);
    }

    public InputStream getInputStream() {
        if (this.pCQ != null) {
            return this.pCQ.get();
        }
        com.facebook.common.references.a b2 = com.facebook.common.references.a.b(this.pCP);
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
        this.pCR = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void QG(int i) {
        this.pwW = i;
    }

    public void QH(int i) {
        this.pwX = i;
    }

    public void setSampleSize(int i) {
        this.bfz = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pCT = aVar;
    }

    public com.facebook.c.c ezj() {
        return this.pCR;
    }

    public int ezf() {
        return this.pwW;
    }

    public int ezg() {
        return this.pwX;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.bfz;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezk() {
        return this.pCT;
    }

    public boolean QI(int i) {
        if (this.pCR == com.facebook.c.b.pyV && this.pCQ == null) {
            com.facebook.common.internal.g.checkNotNull(this.pCP);
            PooledByteBuffer pooledByteBuffer = this.pCP.get();
            return pooledByteBuffer.Qb(i + (-2)) == -1 && pooledByteBuffer.Qb(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.pCP == null || this.pCP.get() == null) ? this.pCS : this.pCP.get().size();
    }

    public String QJ(int i) {
        com.facebook.common.references.a<PooledByteBuffer> ezi = ezi();
        if (ezi == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = ezi.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            ezi.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            ezi.close();
        }
    }

    public void ezl() {
        Pair<Integer, Integer> ezn;
        com.facebook.c.c y = com.facebook.c.d.y(getInputStream());
        this.pCR = y;
        if (com.facebook.c.b.a(y)) {
            ezn = ezm();
        } else {
            ezn = ezn();
        }
        if (y == com.facebook.c.b.pyV && this.pwW == -1) {
            if (ezn != null) {
                this.pwX = com.facebook.d.b.C(getInputStream());
                this.pwW = com.facebook.d.b.Rm(this.pwX);
                return;
            }
            return;
        }
        this.pwW = 0;
    }

    private Pair<Integer, Integer> ezm() {
        Pair<Integer, Integer> E = com.facebook.d.e.E(getInputStream());
        if (E != null) {
            this.mWidth = ((Integer) E.first).intValue();
            this.mHeight = ((Integer) E.second).intValue();
        }
        return E;
    }

    private Pair<Integer, Integer> ezn() {
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
        this.pCR = eVar.ezj();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.pwW = eVar.ezf();
        this.pwX = eVar.ezg();
        this.bfz = eVar.getSampleSize();
        this.pCS = eVar.getSize();
        this.pCT = eVar.ezk();
    }

    public static boolean d(e eVar) {
        return eVar.pwW >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
