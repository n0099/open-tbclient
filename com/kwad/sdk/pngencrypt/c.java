package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class c extends b {
    public k aIB;
    public k aIC;
    public e aID;
    public int aIE = -1;
    public com.kwad.sdk.pngencrypt.chunk.e aIF = null;
    public long aIH = 0;
    public boolean aII = true;
    public boolean aIJ = false;
    public Set<String> aIK = new HashSet();
    public long aIL = 0;
    public long aIM = 0;
    public long aIN = 0;
    public ChunkLoadBehaviour aIP = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    public final boolean aIG = false;
    public g aIO = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] aIQ;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aIQ = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aIQ[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
    }

    public static boolean fy(String str) {
        if (!com.kwad.sdk.pngencrypt.chunk.b.fB(str)) {
            return true;
        }
        return false;
    }

    public final void as(long j) {
        this.aIL = j;
    }

    public final void at(long j) {
        this.aIM = j;
    }

    public final void au(long j) {
        this.aIN = j;
    }

    public final void bE(boolean z) {
        this.aII = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet fv(String str) {
        return new j(str, this.aIG, Ii(), this.aID);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean fw(String str) {
        return str.equals("IDAT");
    }

    private int Id() {
        return this.aIE;
    }

    private k Ii() {
        return this.aIC;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean HY() {
        return this.aII;
    }

    public final boolean Ie() {
        if (Id() < 4) {
            return true;
        }
        return false;
    }

    public final j If() {
        DeflatedChunksSet Ia = Ia();
        if (Ia instanceof j) {
            return (j) Ia;
        }
        return null;
    }

    public final k Ig() {
        return this.aIB;
    }

    public final e Ih() {
        return this.aID;
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.aIE != 6) {
            this.aIE = 6;
        }
        super.close();
    }

    private void fx(String str) {
        if (str.equals("IHDR")) {
            if (this.aIE < 0) {
                this.aIE = 0;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("PLTE")) {
            int i = this.aIE;
            if (i != 0 && i != 1) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk here " + str));
                return;
            }
            this.aIE = 2;
        } else if (str.equals("IDAT")) {
            int i2 = this.aIE;
            if (i2 >= 0 && i2 <= 4) {
                this.aIE = 4;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("IEND")) {
            if (this.aIE >= 4) {
                this.aIE = 6;
                return;
            }
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("unexpected chunk " + str));
        } else {
            int i3 = this.aIE;
            if (i3 <= 1) {
                this.aIE = 1;
            } else if (i3 <= 3) {
                this.aIE = 3;
            } else {
                this.aIE = 5;
            }
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.HW().agT.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.HW());
            k IR = iVar.IR();
            this.aIB = IR;
            this.aIC = IR;
            if (iVar.IP()) {
                this.aID = new e(this.aIC);
            }
            this.aIF = new com.kwad.sdk.pngencrypt.chunk.e(this.aIB);
        }
        if (chunkReader.aIi == ChunkReader.ChunkReaderMode.BUFFER && fy(chunkReader.HW().agT)) {
            this.aIH += chunkReader.HW().len;
        }
        if (chunkReader.aIi != ChunkReader.ChunkReaderMode.BUFFER && !this.aIJ) {
            return;
        }
        try {
            this.aIF.a(this.aIO.a(chunkReader.HW(), Ig()), this.aIE);
        } catch (PngjException e) {
            throw e;
        }
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        return super.b(bArr, i, i2);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i, String str, long j) {
        fx(str);
        super.c(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean t(int i, String str) {
        if (super.t(i, str)) {
            return true;
        }
        if (this.aIL > 0 && i + HZ() > this.aIL) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.aIL + " offset:" + HZ() + " len=" + i));
        }
        if (this.aIK.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.fB(str)) {
            return false;
        }
        long j = this.aIM;
        if (j > 0 && i > j) {
            return true;
        }
        long j2 = this.aIN;
        if (j2 > 0 && i > j2 - this.aIH) {
            return true;
        }
        int i2 = AnonymousClass1.aIQ[this.aIP.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return true;
            }
        } else if (!com.kwad.sdk.pngencrypt.chunk.b.fD(str)) {
            return true;
        }
        return false;
    }
}
