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
    private int bbY;
    private int mHeight;
    private int mWidth;
    private int oPa;
    private int oPb;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> oWS;
    @Nullable
    private final j<FileInputStream> oWT;
    private com.facebook.c.c oWU;
    private int oWV;
    @Nullable
    private com.facebook.imagepipeline.common.a oWW;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.oWU = com.facebook.c.c.oSA;
        this.oPa = -1;
        this.oPb = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bbY = 1;
        this.oWV = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.oWS = aVar.clone();
        this.oWT = null;
    }

    public e(j<FileInputStream> jVar) {
        this.oWU = com.facebook.c.c.oSA;
        this.oPa = -1;
        this.oPb = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.bbY = 1;
        this.oWV = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.oWS = null;
        this.oWT = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.oWV = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.epW();
        }
        return null;
    }

    public e epW() {
        e eVar;
        if (this.oWT != null) {
            eVar = new e(this.oWT, this.oWV);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.oWS);
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
        com.facebook.common.references.a.c(this.oWS);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.oWS)) {
            z = this.oWT != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> epX() {
        return com.facebook.common.references.a.b(this.oWS);
    }

    public InputStream getInputStream() {
        if (this.oWT != null) {
            return this.oWT.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.oWS);
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
        this.oWU = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void Pk(int i) {
        this.oPa = i;
    }

    public void Pl(int i) {
        this.oPb = i;
    }

    public void setSampleSize(int i) {
        this.bbY = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.oWW = aVar;
    }

    public com.facebook.c.c epY() {
        return this.oWU;
    }

    public int epU() {
        return this.oPa;
    }

    public int epV() {
        return this.oPb;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.bbY;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a epZ() {
        return this.oWW;
    }

    public boolean Pm(int i) {
        if (this.oWU == com.facebook.c.b.oSq && this.oWT == null) {
            com.facebook.common.internal.g.checkNotNull(this.oWS);
            PooledByteBuffer pooledByteBuffer = this.oWS.get();
            return pooledByteBuffer.Or(i + (-2)) == -1 && pooledByteBuffer.Or(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.oWS == null || this.oWS.get() == null) ? this.oWV : this.oWS.get().size();
    }

    public String Pn(int i) {
        com.facebook.common.references.a<PooledByteBuffer> epX = epX();
        if (epX == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = epX.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            epX.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            epX.close();
        }
    }

    public void eqa() {
        Pair<Integer, Integer> eqc;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.oWU = u;
        if (com.facebook.c.b.a(u)) {
            eqc = eqb();
        } else {
            eqc = eqc();
        }
        if (u == com.facebook.c.b.oSq && this.oPa == -1) {
            if (eqc != null) {
                this.oPb = com.facebook.d.b.y(getInputStream());
                this.oPa = com.facebook.d.b.PR(this.oPb);
                return;
            }
            return;
        }
        this.oPa = 0;
    }

    private Pair<Integer, Integer> eqb() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> eqc() {
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
        this.oWU = eVar.epY();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.oPa = eVar.epU();
        this.oPb = eVar.epV();
        this.bbY = eVar.getSampleSize();
        this.oWV = eVar.getSize();
        this.oWW = eVar.epZ();
    }

    public static boolean d(e eVar) {
        return eVar.oPa >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
