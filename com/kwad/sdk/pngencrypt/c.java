package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public final class c extends b {
    public k ajL;
    public k ajM;
    public e ajN;
    public int ajO = -1;
    public com.kwad.sdk.pngencrypt.chunk.e ajP = null;
    public long ajR = 0;
    public boolean ajS = true;
    public boolean ajT = false;
    public Set<String> ajU = new HashSet();
    public long ajV = 0;
    public long ajW = 0;
    public long ajX = 0;
    public ChunkLoadBehaviour ajZ = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    public final boolean ajQ = false;
    public g ajY = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] aka;

        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            aka = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aka[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(boolean z) {
    }

    private void dn(String str) {
        if (str.equals("IHDR")) {
            if (this.ajO < 0) {
                this.ajO = 0;
                return;
            }
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("PLTE")) {
            int i = this.ajO;
            if (i == 0 || i == 1) {
                this.ajO = 2;
                return;
            }
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("unexpected chunk here " + str));
        } else if (str.equals("IDAT")) {
            int i2 = this.ajO;
            if (i2 >= 0 && i2 <= 4) {
                this.ajO = 4;
                return;
            }
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("IEND")) {
            if (this.ajO >= 4) {
                this.ajO = 6;
                return;
            }
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("unexpected chunk " + str));
        } else {
            int i3 = this.ajO;
            if (i3 <= 1) {
                this.ajO = 1;
            } else if (i3 <= 3) {
                this.ajO = 3;
            } else {
                this.ajO = 5;
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static boolean m90do(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.dr(str);
    }

    private int ya() {
        return this.ajO;
    }

    private k yf() {
        return this.ajM;
    }

    public final void O(long j) {
        this.ajV = j;
    }

    public final void P(long j) {
        this.ajW = j;
    }

    public final void Q(long j) {
        this.ajX = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(int i, String str, long j) {
        dn(str);
        super.a(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.xT().alB.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.xT());
            k yO = iVar.yO();
            this.ajL = yO;
            this.ajM = yO;
            if (iVar.yM()) {
                this.ajN = new e(this.ajM);
            }
            this.ajP = new com.kwad.sdk.pngencrypt.chunk.e(this.ajL);
        }
        if (chunkReader.ajs == ChunkReader.ChunkReaderMode.BUFFER && m90do(chunkReader.xT().alB)) {
            this.ajR += chunkReader.xT().len;
        }
        if (chunkReader.ajs == ChunkReader.ChunkReaderMode.BUFFER || this.ajT) {
            try {
                this.ajP.a(this.ajY.a(chunkReader.xT(), yd()), this.ajO);
            } catch (PngjException e) {
                throw e;
            }
        }
    }

    public final void aX(boolean z) {
        this.ajS = false;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        return super.b(bArr, i, i2);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.ajO != 6) {
            this.ajO = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final DeflatedChunksSet dl(String str) {
        return new j(str, this.ajQ, yf(), this.ajN);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean dm(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean j(int i, String str) {
        if (super.j(i, str)) {
            return true;
        }
        if (this.ajV > 0 && i + xW() > this.ajV) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.ajV + " offset:" + xW() + " len=" + i));
        }
        if (this.ajU.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.dr(str)) {
            return false;
        }
        long j = this.ajW;
        if (j <= 0 || i <= j) {
            long j2 = this.ajX;
            if (j2 <= 0 || i <= j2 - this.ajR) {
                int i2 = AnonymousClass1.aka[this.ajZ.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        return true;
                    }
                } else if (!com.kwad.sdk.pngencrypt.chunk.b.dt(str)) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean xV() {
        return this.ajS;
    }

    public final boolean yb() {
        return ya() < 4;
    }

    public final j yc() {
        DeflatedChunksSet xX = xX();
        if (xX instanceof j) {
            return (j) xX;
        }
        return null;
    }

    public final k yd() {
        return this.ajL;
    }

    public final e ye() {
        return this.ajN;
    }
}
