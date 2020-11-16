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
/* loaded from: classes17.dex */
public class e implements Closeable {
    private int bam;
    private int mHeight;
    private int mWidth;
    private int oQE;
    private int oQF;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> oYv;
    @Nullable
    private final j<FileInputStream> oYw;
    private com.facebook.c.c oYx;
    private int oYy;
    @Nullable
    private com.facebook.imagepipeline.common.a oYz;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.oYx = com.facebook.c.c.oUd;
        this.oQE = -1;
        this.oQF = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bam = 1;
        this.oYy = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.oYv = aVar.clone();
        this.oYw = null;
    }

    public e(j<FileInputStream> jVar) {
        this.oYx = com.facebook.c.c.oUd;
        this.oQE = -1;
        this.oQF = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bam = 1;
        this.oYy = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.oYv = null;
        this.oYw = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.oYy = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.epU();
        }
        return null;
    }

    public e epU() {
        e eVar;
        if (this.oYw != null) {
            eVar = new e(this.oYw, this.oYy);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.oYv);
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
        com.facebook.common.references.a.c(this.oYv);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.oYv)) {
            z = this.oYw != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> epV() {
        return com.facebook.common.references.a.b(this.oYv);
    }

    public InputStream getInputStream() {
        if (this.oYw != null) {
            return this.oYw.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.oYv);
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
        this.oYx = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void PN(int i) {
        this.oQE = i;
    }

    public void PO(int i) {
        this.oQF = i;
    }

    public void setSampleSize(int i) {
        this.bam = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.oYz = aVar;
    }

    public com.facebook.c.c epW() {
        return this.oYx;
    }

    public int epS() {
        return this.oQE;
    }

    public int epT() {
        return this.oQF;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.bam;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a epX() {
        return this.oYz;
    }

    public boolean PP(int i) {
        if (this.oYx == com.facebook.c.b.oTT && this.oYw == null) {
            com.facebook.common.internal.g.checkNotNull(this.oYv);
            PooledByteBuffer pooledByteBuffer = this.oYv.get();
            return pooledByteBuffer.OU(i + (-2)) == -1 && pooledByteBuffer.OU(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.oYv == null || this.oYv.get() == null) ? this.oYy : this.oYv.get().size();
    }

    public String PQ(int i) {
        com.facebook.common.references.a<PooledByteBuffer> epV = epV();
        if (epV == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = epV.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            epV.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            epV.close();
        }
    }

    public void epY() {
        Pair<Integer, Integer> eqa;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.oYx = u;
        if (com.facebook.c.b.a(u)) {
            eqa = epZ();
        } else {
            eqa = eqa();
        }
        if (u == com.facebook.c.b.oTT && this.oQE == -1) {
            if (eqa != null) {
                this.oQF = com.facebook.d.b.y(getInputStream());
                this.oQE = com.facebook.d.b.Qu(this.oQF);
                return;
            }
            return;
        }
        this.oQE = 0;
    }

    private Pair<Integer, Integer> epZ() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> eqa() {
        InputStream inputStream = null;
        try {
            inputStream = getInputStream();
            Pair<Integer, Integer> x = com.facebook.d.a.x(inputStream);
            if (x != null) {
                this.mWidth = ((Integer) x.first).intValue();
                this.mHeight = ((Integer) x.second).intValue();
            }
            return x;
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
        this.oYx = eVar.epW();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.oQE = eVar.epS();
        this.oQF = eVar.epT();
        this.bam = eVar.getSampleSize();
        this.oYy = eVar.getSize();
        this.oYz = eVar.epX();
    }

    public static boolean d(e eVar) {
        return eVar.oQE >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
