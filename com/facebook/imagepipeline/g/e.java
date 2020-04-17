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
    private int aEK;
    private int lVv;
    private int lVw;
    private int mHeight;
    private int mWidth;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> mdt;
    @Nullable
    private final j<FileInputStream> mdu;
    private com.facebook.c.c mdv;
    private int mdw;
    @Nullable
    private com.facebook.imagepipeline.common.a mdx;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.mdv = com.facebook.c.c.lYW;
        this.lVv = -1;
        this.lVw = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aEK = 1;
        this.mdw = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.mdt = aVar.clone();
        this.mdu = null;
    }

    public e(j<FileInputStream> jVar) {
        this.mdv = com.facebook.c.c.lYW;
        this.lVv = -1;
        this.lVw = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aEK = 1;
        this.mdw = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.mdt = null;
        this.mdu = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.mdw = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dsT();
        }
        return null;
    }

    public e dsT() {
        e eVar;
        if (this.mdu != null) {
            eVar = new e(this.mdu, this.mdw);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mdt);
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
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) this.mdt);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.mdt)) {
            z = this.mdu != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dsU() {
        return com.facebook.common.references.a.b(this.mdt);
    }

    public InputStream getInputStream() {
        if (this.mdu != null) {
            return this.mdu.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mdt);
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
        this.mdv = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void GT(int i) {
        this.lVv = i;
    }

    public void GU(int i) {
        this.lVw = i;
    }

    public void setSampleSize(int i) {
        this.aEK = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mdx = aVar;
    }

    public com.facebook.c.c dsV() {
        return this.mdv;
    }

    public int dsR() {
        return this.lVv;
    }

    public int dsS() {
        return this.lVw;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aEK;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dsW() {
        return this.mdx;
    }

    public boolean GV(int i) {
        if (this.mdv == com.facebook.c.b.lYM && this.mdu == null) {
            com.facebook.common.internal.g.checkNotNull(this.mdt);
            PooledByteBuffer pooledByteBuffer = this.mdt.get();
            return pooledByteBuffer.Ga(i + (-2)) == -1 && pooledByteBuffer.Ga(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.mdt == null || this.mdt.get() == null) ? this.mdw : this.mdt.get().size();
    }

    public String GW(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dsU = dsU();
        if (dsU == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dsU.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dsU.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dsU.close();
        }
    }

    public void dsX() {
        Pair<Integer, Integer> dsZ;
        com.facebook.c.c s = com.facebook.c.d.s(getInputStream());
        this.mdv = s;
        if (com.facebook.c.b.a(s)) {
            dsZ = dsY();
        } else {
            dsZ = dsZ();
        }
        if (s == com.facebook.c.b.lYM && this.lVv == -1) {
            if (dsZ != null) {
                this.lVw = com.facebook.d.b.w(getInputStream());
                this.lVv = com.facebook.d.b.HA(this.lVw);
                return;
            }
            return;
        }
        this.lVv = 0;
    }

    private Pair<Integer, Integer> dsY() {
        Pair<Integer, Integer> y = com.facebook.d.e.y(getInputStream());
        if (y != null) {
            this.mWidth = ((Integer) y.first).intValue();
            this.mHeight = ((Integer) y.second).intValue();
        }
        return y;
    }

    private Pair<Integer, Integer> dsZ() {
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
        this.mdv = eVar.dsV();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.lVv = eVar.dsR();
        this.lVw = eVar.dsS();
        this.aEK = eVar.getSampleSize();
        this.mdw = eVar.getSize();
        this.mdx = eVar.dsW();
    }

    public static boolean d(e eVar) {
        return eVar.lVv >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
