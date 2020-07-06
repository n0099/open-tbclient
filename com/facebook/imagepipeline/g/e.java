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
    private int mME;
    private int mMF;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> mUI;
    @Nullable
    private final j<FileInputStream> mUJ;
    private com.facebook.c.c mUK;
    private int mUL;
    @Nullable
    private com.facebook.imagepipeline.common.a mUM;
    private int mWidth;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.mUK = com.facebook.c.c.mQh;
        this.mME = -1;
        this.mMF = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aMY = 1;
        this.mUL = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.mUI = aVar.clone();
        this.mUJ = null;
    }

    public e(j<FileInputStream> jVar) {
        this.mUK = com.facebook.c.c.mQh;
        this.mME = -1;
        this.mMF = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.aMY = 1;
        this.mUL = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.mUI = null;
        this.mUJ = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.mUL = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.dFd();
        }
        return null;
    }

    public e dFd() {
        e eVar;
        if (this.mUJ != null) {
            eVar = new e(this.mUJ, this.mUL);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mUI);
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
        com.facebook.common.references.a.c(this.mUI);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.mUI)) {
            z = this.mUJ != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> dFe() {
        return com.facebook.common.references.a.b(this.mUI);
    }

    public InputStream getInputStream() {
        if (this.mUJ != null) {
            return this.mUJ.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.mUI);
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
        this.mUK = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void IO(int i) {
        this.mME = i;
    }

    public void IP(int i) {
        this.mMF = i;
    }

    public void setSampleSize(int i) {
        this.aMY = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mUM = aVar;
    }

    public com.facebook.c.c dFf() {
        return this.mUK;
    }

    public int dFb() {
        return this.mME;
    }

    public int dFc() {
        return this.mMF;
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
    public com.facebook.imagepipeline.common.a dFg() {
        return this.mUM;
    }

    public boolean IQ(int i) {
        if (this.mUK == com.facebook.c.b.mPX && this.mUJ == null) {
            com.facebook.common.internal.g.checkNotNull(this.mUI);
            PooledByteBuffer pooledByteBuffer = this.mUI.get();
            return pooledByteBuffer.HV(i + (-2)) == -1 && pooledByteBuffer.HV(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.mUI == null || this.mUI.get() == null) ? this.mUL : this.mUI.get().size();
    }

    public String IR(int i) {
        com.facebook.common.references.a<PooledByteBuffer> dFe = dFe();
        if (dFe == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = dFe.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            dFe.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            dFe.close();
        }
    }

    public void dFh() {
        Pair<Integer, Integer> dFj;
        com.facebook.c.c t = com.facebook.c.d.t(getInputStream());
        this.mUK = t;
        if (com.facebook.c.b.a(t)) {
            dFj = dFi();
        } else {
            dFj = dFj();
        }
        if (t == com.facebook.c.b.mPX && this.mME == -1) {
            if (dFj != null) {
                this.mMF = com.facebook.d.b.x(getInputStream());
                this.mME = com.facebook.d.b.Jv(this.mMF);
                return;
            }
            return;
        }
        this.mME = 0;
    }

    private Pair<Integer, Integer> dFi() {
        Pair<Integer, Integer> z = com.facebook.d.e.z(getInputStream());
        if (z != null) {
            this.mWidth = ((Integer) z.first).intValue();
            this.mHeight = ((Integer) z.second).intValue();
        }
        return z;
    }

    private Pair<Integer, Integer> dFj() {
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
        this.mUK = eVar.dFf();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.mME = eVar.dFb();
        this.mMF = eVar.dFc();
        this.aMY = eVar.getSampleSize();
        this.mUL = eVar.getSize();
        this.mUM = eVar.dFg();
    }

    public static boolean d(e eVar) {
        return eVar.mME >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
