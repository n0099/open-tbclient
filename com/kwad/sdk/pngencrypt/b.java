package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;
/* loaded from: classes10.dex */
public abstract class b implements f, Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public byte[] ajA;
    public int ajB;
    public boolean ajC;
    public boolean ajD;
    public int ajE;
    public long ajF;
    public DeflatedChunksSet ajG;
    public ChunkReader ajH;
    public long ajI;
    public ErrorBehaviour ajJ;
    public final byte[] ajy;
    public final int ajz;
    public boolean closed;

    public b() {
        this(n.yx());
    }

    public b(byte[] bArr) {
        this.ajA = new byte[8];
        this.ajB = 0;
        this.ajC = false;
        this.ajD = false;
        this.closed = false;
        this.ajE = 0;
        this.ajF = 0L;
        this.ajJ = ErrorBehaviour.STRICT;
        this.ajy = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.ajz = length;
        this.ajC = length <= 0;
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i2, byte[] bArr, int i3, int i4) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException("should never happen"));
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void xU() {
                b.this.a(this);
            }
        };
    }

    public static void h(byte[] bArr) {
        if (Arrays.equals(bArr, n.yx())) {
            return;
        }
        com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    public static String xY() {
        return "IHDR";
    }

    public static String xZ() {
        return "IEND";
    }

    public void a(int i, String str, long j) {
        com.kwad.sdk.core.e.b.d("PNG_ENCRYPT", "New chunk: " + str + " " + i + " off:" + j);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.alz.matcher(str).matches()) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i < 0) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("Bad chunk len: " + i));
        }
        if (str.equals("IDAT")) {
            this.ajI += i;
        }
        boolean xV = xV();
        boolean j2 = j(i, str);
        boolean dm = dm(str);
        DeflatedChunksSet deflatedChunksSet = this.ajG;
        boolean dp = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.ajG.dp(str);
        if (!dm || j2) {
            this.ajH = a(str, i, j, j2);
        } else {
            if (!dp) {
                DeflatedChunksSet deflatedChunksSet2 = this.ajG;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.e.b.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.ajG = dl(str);
            }
            this.ajH = new d(i, str, xV, j, this.ajG) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void xU() {
                    super.xU();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.ajH;
        if (chunkReader == null || xV) {
            return;
        }
        chunkReader.aW(false);
    }

    public void a(ChunkReader chunkReader) {
        if (this.ajE == 1 && !xY().equals(chunkReader.xT().alB)) {
            String str = "Bad first chunk: " + chunkReader.xT().alB + " expected: " + xY();
            if (this.ajJ.c < ErrorBehaviour.SUPER_LENIENT.c) {
                com.kwad.sdk.core.e.b.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.e.b.d("PNG_ENCRYPT", str);
            }
        }
        xZ();
        if (chunkReader.xT().alB.equals(xZ())) {
            this.ajD = true;
            close();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i, int i2) {
        int i3;
        long j;
        long j2;
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.e.b.printStackTrace(new PngjException("This should not happen. Bad length: " + i2));
        }
        if (this.ajC) {
            ChunkReader chunkReader = this.ajH;
            if (chunkReader == null || chunkReader.isDone()) {
                int i4 = 8 - this.ajB;
                if (i4 <= i2) {
                    i2 = i4;
                }
                System.arraycopy(bArr, i, this.ajA, this.ajB, i2);
                int i5 = this.ajB + i2;
                this.ajB = i5;
                i3 = i2 + 0;
                this.ajF += i2;
                if (i5 == 8) {
                    this.ajE++;
                    a(n.g(this.ajA, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.ajA, 4), this.ajF - 8);
                    this.ajB = 0;
                }
                return i3;
            }
            int b = this.ajH.b(bArr, i, i2);
            if (b < 0) {
                return -1;
            }
            i3 = b + 0;
            j = this.ajF;
            j2 = b;
        } else {
            int i6 = this.ajz - this.ajB;
            if (i6 <= i2) {
                i2 = i6;
            }
            System.arraycopy(bArr, i, this.ajA, this.ajB, i2);
            int i7 = this.ajB + i2;
            this.ajB = i7;
            if (i7 == this.ajz) {
                h(this.ajA);
                this.ajB = 0;
                this.ajC = true;
            }
            i3 = i2 + 0;
            j = this.ajF;
            j2 = i2;
        }
        this.ajF = j + j2;
        return i3;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.ajG;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    public abstract DeflatedChunksSet dl(String str);

    public boolean dm(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.ajD;
    }

    public boolean j(int i, String str) {
        return false;
    }

    public boolean xV() {
        return true;
    }

    public final long xW() {
        return this.ajF;
    }

    public final DeflatedChunksSet xX() {
        return this.ajG;
    }
}
