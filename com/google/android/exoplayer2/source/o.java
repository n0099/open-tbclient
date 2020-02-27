package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.source.n;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public final class o implements com.google.android.exoplayer2.extractor.m {
    private final com.google.android.exoplayer2.upstream.b mrs;
    private final int msE;
    private a msH;
    private a msI;
    private a msJ;
    private Format msK;
    private boolean msL;
    private Format msM;
    private long msN;
    private boolean msO;
    private b msP;
    private long totalBytesWritten;
    private final n msF = new n();
    private final n.a msG = new n.a();
    private final com.google.android.exoplayer2.util.l mex = new com.google.android.exoplayer2.util.l(32);

    /* loaded from: classes6.dex */
    public interface b {
        void k(Format format);
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.mrs = bVar;
        this.msE = bVar.dyR();
        this.msH = new a(0L, this.msE);
        this.msI = this.msH;
        this.msJ = this.msH;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.msF.reset(z);
        a(this.msH);
        this.msH = new a(0L, this.msE);
        this.msI = this.msH;
        this.msJ = this.msH;
        this.totalBytesWritten = 0L;
        this.mrs.trim();
    }

    public void KH(int i) {
        this.msF.KH(i);
    }

    public void dwB() {
        this.msO = true;
    }

    public int dwt() {
        return this.msF.dwt();
    }

    public void KL(int i) {
        this.totalBytesWritten = this.msF.KG(i);
        if (this.totalBytesWritten == 0 || this.totalBytesWritten == this.msH.startPosition) {
            a(this.msH);
            this.msH = new a(this.totalBytesWritten, this.msE);
            this.msI = this.msH;
            this.msJ = this.msH;
            return;
        }
        a aVar = this.msH;
        while (this.totalBytesWritten > aVar.endPosition) {
            aVar = aVar.msS;
        }
        a aVar2 = aVar.msS;
        a(aVar2);
        aVar.msS = new a(aVar.endPosition, this.msE);
        this.msJ = this.totalBytesWritten == aVar.endPosition ? aVar.msS : aVar;
        if (this.msI == aVar2) {
            this.msI = aVar.msS;
        }
    }

    public boolean dww() {
        return this.msF.dww();
    }

    public int dwu() {
        return this.msF.dwu();
    }

    public int dwv() {
        return this.msF.dwv();
    }

    public Format dwx() {
        return this.msF.dwx();
    }

    public long dwp() {
        return this.msF.dwp();
    }

    public void rewind() {
        this.msF.rewind();
        this.msI = this.msH;
    }

    public void c(long j, boolean z, boolean z2) {
        gj(this.msF.b(j, z, z2));
    }

    public void dwC() {
        gj(this.msF.dwz());
    }

    public void dwD() {
        gj(this.msF.dwA());
    }

    public int dwy() {
        return this.msF.dwy();
    }

    public int a(long j, boolean z, boolean z2) {
        return this.msF.a(j, z, z2);
    }

    public int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, long j) {
        switch (this.msF.a(mVar, eVar, z, z2, this.msK, this.msG)) {
            case -5:
                this.msK = mVar.lZw;
                return -5;
            case -4:
                if (!eVar.dus()) {
                    if (eVar.mdB < j) {
                        eVar.aK(Integer.MIN_VALUE);
                    }
                    if (eVar.duC()) {
                        a(eVar, this.msG);
                    }
                    eVar.Jo(this.msG.size);
                    a(this.msG.offset, eVar.data, this.msG.size);
                }
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    private void a(com.google.android.exoplayer2.a.e eVar, n.a aVar) {
        long j;
        long j2;
        int i = 1;
        long j3 = aVar.offset;
        this.mex.reset(1);
        a(j3, this.mex.data, 1);
        long j4 = j3 + 1;
        byte b2 = this.mex.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (eVar.mdA.iv == null) {
            eVar.mdA.iv = new byte[16];
        }
        a(j4, eVar.mdA.iv, i2);
        long j5 = j4 + i2;
        if (z) {
            this.mex.reset(2);
            a(j5, this.mex.data, 2);
            i = this.mex.readUnsignedShort();
            j = j5 + 2;
        } else {
            j = j5;
        }
        int[] iArr = eVar.mdA.mdj;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.mdA.mdk;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.mex.reset(i3);
            a(j, this.mex.data, i3);
            long j6 = j + i3;
            this.mex.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.mex.readUnsignedShort();
                iArr2[i4] = this.mex.dzC();
            }
            j2 = j6;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.offset));
            j2 = j;
        }
        m.a aVar2 = aVar.mfZ;
        eVar.mdA.a(i, iArr, iArr2, aVar2.meq, eVar.mdA.iv, aVar2.mep, aVar2.mdm, aVar2.mdn);
        int i5 = (int) (j2 - aVar.offset);
        aVar.offset += i5;
        aVar.size -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        gi(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.msI.endPosition - j));
            byteBuffer.put(this.msI.msR.data, this.msI.gl(j), min);
            i -= min;
            j += min;
            if (j == this.msI.endPosition) {
                this.msI = this.msI.msS;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        gi(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.msI.endPosition - j));
            System.arraycopy(this.msI.msR.data, this.msI.gl(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == this.msI.endPosition) {
                this.msI = this.msI.msS;
            }
        }
    }

    private void gi(long j) {
        while (j >= this.msI.endPosition) {
            this.msI = this.msI.msS;
        }
    }

    private void gj(long j) {
        if (j != -1) {
            while (j >= this.msH.endPosition) {
                this.mrs.a(this.msH.msR);
                this.msH = this.msH.dwE();
            }
            if (this.msI.startPosition < this.msH.startPosition) {
                this.msI = this.msH;
            }
        }
    }

    public void a(b bVar) {
        this.msP = bVar;
    }

    public void gk(long j) {
        if (this.msN != j) {
            this.msN = j;
            this.msL = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
        Format a2 = a(format, this.msN);
        boolean l = this.msF.l(a2);
        this.msM = format;
        this.msL = false;
        if (this.msP != null && l) {
            this.msP.k(a2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
        int read = fVar.read(this.msJ.msR.data, this.msJ.gl(this.totalBytesWritten), KM(i));
        if (read == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        KN(read);
        return read;
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(com.google.android.exoplayer2.util.l lVar, int i) {
        while (i > 0) {
            int KM = KM(i);
            lVar.G(this.msJ.msR.data, this.msJ.gl(this.totalBytesWritten), KM);
            i -= KM;
            KN(KM);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.msL) {
            h(this.msM);
        }
        if (this.msO) {
            if ((i & 1) != 0 && this.msF.gh(j)) {
                this.msO = false;
            } else {
                return;
            }
        }
        this.msF.a(j + this.msN, i, (this.totalBytesWritten - i2) - i3, i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.msQ) {
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[(this.msJ.msQ ? 1 : 0) + (((int) (this.msJ.startPosition - aVar.startPosition)) / this.msE)];
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr[i] = aVar.msR;
                aVar = aVar.dwE();
            }
            this.mrs.a(aVarArr);
        }
    }

    private int KM(int i) {
        if (!this.msJ.msQ) {
            this.msJ.a(this.mrs.dyQ(), new a(this.msJ.endPosition, this.msE));
        }
        return Math.min(i, (int) (this.msJ.endPosition - this.totalBytesWritten));
    }

    private void KN(int i) {
        this.totalBytesWritten += i;
        if (this.totalBytesWritten == this.msJ.endPosition) {
            this.msJ = this.msJ.msS;
        }
    }

    private static Format a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j != 0 && format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
            return format.fx(format.subsampleOffsetUs + j);
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final long endPosition;
        public boolean msQ;
        @Nullable
        public com.google.android.exoplayer2.upstream.a msR;
        @Nullable
        public a msS;
        public final long startPosition;

        public a(long j, int i) {
            this.startPosition = j;
            this.endPosition = i + j;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.msR = aVar;
            this.msS = aVar2;
            this.msQ = true;
        }

        public int gl(long j) {
            return ((int) (j - this.startPosition)) + this.msR.offset;
        }

        public a dwE() {
            this.msR = null;
            a aVar = this.msS;
            this.msS = null;
            return aVar;
        }
    }
}
