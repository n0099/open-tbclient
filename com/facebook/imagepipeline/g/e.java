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
/* loaded from: classes11.dex */
public class e implements Closeable {
    private int ajr;
    private int lHX;
    private int lHY;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> lPr;
    @Nullable
    private final j<FileInputStream> lPs;
    private com.facebook.c.c lPt;
    private int lPu;
    @Nullable
    private com.facebook.imagepipeline.common.a lPv;
    private int mHeight;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.lPt = com.facebook.c.c.lLb;
        this.lHX = -1;
        this.lHY = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.ajr = 1;
        this.lPu = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.lPr = aVar.clone();
        this.lPs = null;
    }

    public e(j<FileInputStream> jVar) {
        this.lPt = com.facebook.c.c.lLb;
        this.lHX = -1;
        this.lHY = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.ajr = 1;
        this.lPu = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.lPr = null;
        this.lPs = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.lPu = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dob();
        }
        return null;
    }

    public e dob() {
        e eVar;
        if (this.lPs != null) {
            eVar = new e(this.lPs, this.lPu);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPr);
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
        com.facebook.common.references.a.c(this.lPr);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.lPr)) {
            z = this.lPs != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> doc() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPr);
    }

    public InputStream getInputStream() {
        if (this.lPs != null) {
            return this.lPs.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b((com.facebook.common.references.a) this.lPr);
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
        this.lPt = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void HX(int i) {
        this.lHX = i;
    }

    public void HY(int i) {
        this.lHY = i;
    }

    public void setSampleSize(int i) {
        this.ajr = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lPv = aVar;
    }

    public com.facebook.c.c dod() {
        return this.lPt;
    }

    public int dnZ() {
        return this.lHX;
    }

    public int doa() {
        return this.lHY;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.ajr;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a doe() {
        return this.lPv;
    }

    public boolean HZ(int i) {
        if (this.lPt == com.facebook.c.b.lKR && this.lPs == null) {
            com.facebook.common.internal.g.checkNotNull(this.lPr);
            PooledByteBuffer pooledByteBuffer = this.lPr.get();
            return pooledByteBuffer.Hj(i + (-2)) == -1 && pooledByteBuffer.Hj(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.lPr == null || this.lPr.get() == null) ? this.lPu : this.lPr.get().size();
    }

    public String Ia(int i) {
        com.facebook.common.references.a<PooledByteBuffer> doc = doc();
        if (doc == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = doc.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            doc.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            doc.close();
        }
    }

    public void dof() {
        Pair<Integer, Integer> doh;
        com.facebook.c.c v = com.facebook.c.d.v(getInputStream());
        this.lPt = v;
        if (com.facebook.c.b.a(v)) {
            doh = dog();
        } else {
            doh = doh();
        }
        if (v == com.facebook.c.b.lKR && this.lHX == -1) {
            if (doh != null) {
                this.lHY = com.facebook.d.b.z(getInputStream());
                this.lHX = com.facebook.d.b.ID(this.lHY);
                return;
            }
            return;
        }
        this.lHX = 0;
    }

    private Pair<Integer, Integer> dog() {
        Pair<Integer, Integer> B = com.facebook.d.e.B(getInputStream());
        if (B != null) {
            this.mWidth = ((Integer) B.first).intValue();
            this.mHeight = ((Integer) B.second).intValue();
        }
        return B;
    }

    private Pair<Integer, Integer> doh() {
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
        this.lPt = eVar.dod();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lHX = eVar.dnZ();
        this.lHY = eVar.doa();
        this.ajr = eVar.getSampleSize();
        this.lPu = eVar.getSize();
        this.lPv = eVar.doe();
    }

    public static boolean d(e eVar) {
        return eVar.lHX >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
