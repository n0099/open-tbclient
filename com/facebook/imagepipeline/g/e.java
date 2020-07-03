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
    private int aMY;
    private int mHeight;
    private int mMB;
    private int mMC;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> mUF;
    @Nullable
    private final j<FileInputStream> mUG;
    private com.facebook.c.c mUH;
    private int mUI;
    @Nullable
    private com.facebook.imagepipeline.common.a mUJ;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.mUH = com.facebook.c.c.mQe;
        this.mMB = -1;
        this.mMC = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aMY = 1;
        this.mUI = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.mUF = aVar.clone();
        this.mUG = null;
    }

    public e(j<FileInputStream> jVar) {
        this.mUH = com.facebook.c.c.mQe;
        this.mMB = -1;
        this.mMC = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aMY = 1;
        this.mUI = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.mUF = null;
        this.mUG = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.mUI = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dEZ();
        }
        return null;
    }

    public e dEZ() {
        e eVar;
        if (this.mUG != null) {
            eVar = new e(this.mUG, this.mUI);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mUF);
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
        com.facebook.common.references.a.c(this.mUF);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.mUF)) {
            z = this.mUG != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dFa() {
        return com.facebook.common.references.a.b(this.mUF);
    }

    public InputStream getInputStream() {
        if (this.mUG != null) {
            return this.mUG.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mUF);
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
        this.mUH = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void IO(int i) {
        this.mMB = i;
    }

    public void IP(int i) {
        this.mMC = i;
    }

    public void setSampleSize(int i) {
        this.aMY = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mUJ = aVar;
    }

    public com.facebook.c.c dFb() {
        return this.mUH;
    }

    public int dEX() {
        return this.mMB;
    }

    public int dEY() {
        return this.mMC;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.aMY;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dFc() {
        return this.mUJ;
    }

    public boolean IQ(int i) {
        if (this.mUH == com.facebook.c.b.mPU && this.mUG == null) {
            com.facebook.common.internal.g.checkNotNull(this.mUF);
            PooledByteBuffer pooledByteBuffer = this.mUF.get();
            return pooledByteBuffer.HV(i + (-2)) == -1 && pooledByteBuffer.HV(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.mUF == null || this.mUF.get() == null) ? this.mUI : this.mUF.get().size();
    }

    public String IR(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dFa = dFa();
        if (dFa == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dFa.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dFa.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dFa.close();
        }
    }

    public void dFd() {
        Pair<Integer, Integer> dFf;
        com.facebook.c.c t = com.facebook.c.d.t(getInputStream());
        this.mUH = t;
        if (com.facebook.c.b.a(t)) {
            dFf = dFe();
        } else {
            dFf = dFf();
        }
        if (t == com.facebook.c.b.mPU && this.mMB == -1) {
            if (dFf != null) {
                this.mMC = com.facebook.d.b.x(getInputStream());
                this.mMB = com.facebook.d.b.Jv(this.mMC);
                return;
            }
            return;
        }
        this.mMB = 0;
    }

    private Pair<Integer, Integer> dFe() {
        Pair<Integer, Integer> z = com.facebook.d.e.z(getInputStream());
        if (z != null) {
            this.mWidth = ((Integer) z.first).intValue();
            this.mHeight = ((Integer) z.second).intValue();
        }
        return z;
    }

    private Pair<Integer, Integer> dFf() {
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
        this.mUH = eVar.dFb();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.mMB = eVar.dEX();
        this.mMC = eVar.dEY();
        this.aMY = eVar.getSampleSize();
        this.mUI = eVar.getSize();
        this.mUJ = eVar.dFc();
    }

    public static boolean d(e eVar) {
        return eVar.mMB >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
