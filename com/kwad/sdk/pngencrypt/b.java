package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;
/* loaded from: classes10.dex */
public abstract class b implements f, Closeable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final byte[] aIo;
    public final int aIp;
    public byte[] aIq;
    public int aIr;
    public boolean aIs;
    public boolean aIt;
    public int aIu;
    public long aIv;
    public DeflatedChunksSet aIw;
    public ChunkReader aIx;
    public long aIy;
    public ErrorBehaviour aIz;
    public boolean closed;

    public static String Ib() {
        return "IHDR";
    }

    public static String Ic() {
        return "IEND";
    }

    public boolean HY() {
        return true;
    }

    public abstract DeflatedChunksSet fv(String str);

    public boolean fw(String str) {
        return false;
    }

    public boolean t(int i, String str) {
        return false;
    }

    public b() {
        this(n.IA());
    }

    public final long HZ() {
        return this.aIv;
    }

    public final DeflatedChunksSet Ia() {
        return this.aIw;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.aIw;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.aIt;
    }

    public b(byte[] bArr) {
        int length;
        this.aIq = new byte[8];
        this.aIr = 0;
        this.aIs = false;
        this.aIt = false;
        this.closed = false;
        this.aIu = 0;
        this.aIv = 0L;
        this.aIz = ErrorBehaviour.STRICT;
        this.aIo = bArr;
        if (bArr == null) {
            length = 0;
        } else {
            length = bArr.length;
        }
        this.aIp = length;
        this.aIs = length <= 0;
    }

    public static void h(byte[] bArr) {
        if (!Arrays.equals(bArr, n.IA())) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
        }
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        ChunkReader.ChunkReaderMode chunkReaderMode;
        if (z) {
            chunkReaderMode = ChunkReader.ChunkReaderMode.SKIP;
        } else {
            chunkReaderMode = ChunkReader.ChunkReaderMode.BUFFER;
        }
        return new ChunkReader(i, str, j, chunkReaderMode) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void HX() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            public final void a(int i2, byte[] bArr, int i3, int i4) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    public void a(ChunkReader chunkReader) {
        if (this.aIu == 1 && !Ib().equals(chunkReader.HW().agT)) {
            String str = "Bad first chunk: " + chunkReader.HW().agT + " expected: " + Ib();
            if (this.aIz.c < ErrorBehaviour.SUPER_LENIENT.c) {
                com.kwad.sdk.core.e.c.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", str);
            }
        }
        Ic();
        if (chunkReader.HW().agT.equals(Ic())) {
            this.aIt = true;
            close();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i, int i2) {
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("This should not happen. Bad length: " + i2));
        }
        if (this.aIs) {
            ChunkReader chunkReader = this.aIx;
            if (chunkReader != null && !chunkReader.isDone()) {
                int b = this.aIx.b(bArr, i, i2);
                if (b < 0) {
                    return -1;
                }
                int i3 = b + 0;
                this.aIv += b;
                return i3;
            }
            int i4 = 8 - this.aIr;
            if (i4 <= i2) {
                i2 = i4;
            }
            System.arraycopy(bArr, i, this.aIq, this.aIr, i2);
            int i5 = this.aIr + i2;
            this.aIr = i5;
            int i6 = i2 + 0;
            this.aIv += i2;
            if (i5 == 8) {
                this.aIu++;
                c(n.g(this.aIq, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.aIq, 4), this.aIv - 8);
                this.aIr = 0;
                return i6;
            }
            return i6;
        }
        int i7 = this.aIp - this.aIr;
        if (i7 <= i2) {
            i2 = i7;
        }
        System.arraycopy(bArr, i, this.aIq, this.aIr, i2);
        int i8 = this.aIr + i2;
        this.aIr = i8;
        if (i8 == this.aIp) {
            h(this.aIq);
            this.aIr = 0;
            this.aIs = true;
        }
        int i9 = i2 + 0;
        this.aIv += i2;
        return i9;
    }

    public void c(int i, String str, long j) {
        boolean z;
        com.kwad.sdk.core.e.c.d("PNG_ENCRYPT", "New chunk: " + str + " " + i + " off:" + j);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.aKp.matcher(str).matches()) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i < 0) {
            com.kwad.sdk.core.e.c.printStackTrace(new PngjException("Bad chunk len: " + i));
        }
        if (str.equals("IDAT")) {
            this.aIy += i;
        }
        boolean HY = HY();
        boolean t = t(i, str);
        boolean fw = fw(str);
        DeflatedChunksSet deflatedChunksSet = this.aIw;
        if (deflatedChunksSet != null && !deflatedChunksSet.isClosed()) {
            z = this.aIw.fz(str);
        } else {
            z = false;
        }
        if (fw && !t) {
            if (!z) {
                DeflatedChunksSet deflatedChunksSet2 = this.aIw;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.e.c.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.aIw = fv(str);
            }
            this.aIx = new d(i, str, HY, j, this.aIw) { // from class: com.kwad.sdk.pngencrypt.b.1
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void HX() {
                    super.HX();
                    b.this.a(this);
                }
            };
        } else {
            this.aIx = a(str, i, j, t);
        }
        ChunkReader chunkReader = this.aIx;
        if (chunkReader != null && !HY) {
            chunkReader.bD(false);
        }
    }
}
