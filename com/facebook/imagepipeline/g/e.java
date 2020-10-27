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
    private int baG;
    private int mHeight;
    private int mWidth;
    private int oFH;
    private int oFI;
    @Nullable
    private final j<FileInputStream> oNA;
    private com.facebook.c.c oNB;
    private int oNC;
    @Nullable
    private com.facebook.imagepipeline.common.a oND;
    @Nullable
    private final com.facebook.common.references.a<PooledByteBuffer> oNz;

    public e(com.facebook.common.references.a<PooledByteBuffer> aVar) {
        this.oNB = com.facebook.c.c.oJh;
        this.oFH = -1;
        this.oFI = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.baG = 1;
        this.oNC = -1;
        com.facebook.common.internal.g.checkArgument(com.facebook.common.references.a.a(aVar));
        this.oNz = aVar.clone();
        this.oNA = null;
    }

    public e(j<FileInputStream> jVar) {
        this.oNB = com.facebook.c.c.oJh;
        this.oFH = -1;
        this.oFI = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.baG = 1;
        this.oNC = -1;
        com.facebook.common.internal.g.checkNotNull(jVar);
        this.oNz = null;
        this.oNA = jVar;
    }

    public e(j<FileInputStream> jVar, int i) {
        this(jVar);
        this.oNC = i;
    }

    public static e b(e eVar) {
        if (eVar != null) {
            return eVar.emf();
        }
        return null;
    }

    public e emf() {
        e eVar;
        if (this.oNA != null) {
            eVar = new e(this.oNA, this.oNC);
        } else {
            com.facebook.common.references.a b = com.facebook.common.references.a.b(this.oNz);
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
        com.facebook.common.references.a.c(this.oNz);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!com.facebook.common.references.a.a(this.oNz)) {
            z = this.oNA != null;
        }
        return z;
    }

    public com.facebook.common.references.a<PooledByteBuffer> emg() {
        return com.facebook.common.references.a.b(this.oNz);
    }

    public InputStream getInputStream() {
        if (this.oNA != null) {
            return this.oNA.get();
        }
        com.facebook.common.references.a b = com.facebook.common.references.a.b(this.oNz);
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
        this.oNB = cVar;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void OP(int i) {
        this.oFH = i;
    }

    public void OQ(int i) {
        this.oFI = i;
    }

    public void setSampleSize(int i) {
        this.baG = i;
    }

    public void b(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.oND = aVar;
    }

    public com.facebook.c.c emh() {
        return this.oNB;
    }

    public int emd() {
        return this.oFH;
    }

    public int eme() {
        return this.oFI;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getSampleSize() {
        return this.baG;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a emi() {
        return this.oND;
    }

    public boolean OR(int i) {
        if (this.oNB == com.facebook.c.b.oIX && this.oNA == null) {
            com.facebook.common.internal.g.checkNotNull(this.oNz);
            PooledByteBuffer pooledByteBuffer = this.oNz.get();
            return pooledByteBuffer.NW(i + (-2)) == -1 && pooledByteBuffer.NW(i + (-1)) == -39;
        }
        return true;
    }

    public int getSize() {
        return (this.oNz == null || this.oNz.get() == null) ? this.oNC : this.oNz.get().size();
    }

    public String OS(int i) {
        com.facebook.common.references.a<PooledByteBuffer> emg = emg();
        if (emg == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = emg.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.c(0, bArr, 0, min);
            emg.close();
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            emg.close();
        }
    }

    public void emj() {
        Pair<Integer, Integer> eml;
        com.facebook.c.c u = com.facebook.c.d.u(getInputStream());
        this.oNB = u;
        if (com.facebook.c.b.a(u)) {
            eml = emk();
        } else {
            eml = eml();
        }
        if (u == com.facebook.c.b.oIX && this.oFH == -1) {
            if (eml != null) {
                this.oFI = com.facebook.d.b.y(getInputStream());
                this.oFH = com.facebook.d.b.Pw(this.oFI);
                return;
            }
            return;
        }
        this.oFH = 0;
    }

    private Pair<Integer, Integer> emk() {
        Pair<Integer, Integer> A = com.facebook.d.e.A(getInputStream());
        if (A != null) {
            this.mWidth = ((Integer) A.first).intValue();
            this.mHeight = ((Integer) A.second).intValue();
        }
        return A;
    }

    private Pair<Integer, Integer> eml() {
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
        this.oNB = eVar.emh();
        this.mWidth = eVar.getWidth();
        this.mHeight = eVar.getHeight();
        this.oFH = eVar.emd();
        this.oFI = eVar.eme();
        this.baG = eVar.getSampleSize();
        this.oNC = eVar.getSize();
        this.oND = eVar.emi();
    }

    public static boolean d(e eVar) {
        return eVar.oFH >= 0 && eVar.mWidth >= 0 && eVar.mHeight >= 0;
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
