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
    private final com.google.android.exoplayer2.upstream.b mru;
    private final int msG;
    private a msJ;
    private a msK;
    private a msL;
    private Format msM;
    private boolean msN;
    private Format msO;
    private long msP;
    private boolean msQ;
    private b msR;
    private long totalBytesWritten;
    private final n msH = new n();
    private final n.a msI = new n.a();
    private final com.google.android.exoplayer2.util.l mez = new com.google.android.exoplayer2.util.l(32);

    /* loaded from: classes6.dex */
    public interface b {
        void k(Format format);
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.mru = bVar;
        this.msG = bVar.dyT();
        this.msJ = new a(0L, this.msG);
        this.msK = this.msJ;
        this.msL = this.msJ;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.msH.reset(z);
        a(this.msJ);
        this.msJ = new a(0L, this.msG);
        this.msK = this.msJ;
        this.msL = this.msJ;
        this.totalBytesWritten = 0L;
        this.mru.trim();
    }

    public void KH(int i) {
        this.msH.KH(i);
    }

    public void dwD() {
        this.msQ = true;
    }

    public int dwv() {
        return this.msH.dwv();
    }

    public void KL(int i) {
        this.totalBytesWritten = this.msH.KG(i);
        if (this.totalBytesWritten == 0 || this.totalBytesWritten == this.msJ.startPosition) {
            a(this.msJ);
            this.msJ = new a(this.totalBytesWritten, this.msG);
            this.msK = this.msJ;
            this.msL = this.msJ;
            return;
        }
        a aVar = this.msJ;
        while (this.totalBytesWritten > aVar.endPosition) {
            aVar = aVar.msU;
        }
        a aVar2 = aVar.msU;
        a(aVar2);
        aVar.msU = new a(aVar.endPosition, this.msG);
        this.msL = this.totalBytesWritten == aVar.endPosition ? aVar.msU : aVar;
        if (this.msK == aVar2) {
            this.msK = aVar.msU;
        }
    }

    public boolean dwy() {
        return this.msH.dwy();
    }

    public int dww() {
        return this.msH.dww();
    }

    public int dwx() {
        return this.msH.dwx();
    }

    public Format dwz() {
        return this.msH.dwz();
    }

    public long dwr() {
        return this.msH.dwr();
    }

    public void rewind() {
        this.msH.rewind();
        this.msK = this.msJ;
    }

    public void c(long j, boolean z, boolean z2) {
        gj(this.msH.b(j, z, z2));
    }

    public void dwE() {
        gj(this.msH.dwB());
    }

    public void dwF() {
        gj(this.msH.dwC());
    }

    public int dwA() {
        return this.msH.dwA();
    }

    public int a(long j, boolean z, boolean z2) {
        return this.msH.a(j, z, z2);
    }

    public int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, long j) {
        switch (this.msH.a(mVar, eVar, z, z2, this.msM, this.msI)) {
            case -5:
                this.msM = mVar.lZy;
                return -5;
            case -4:
                if (!eVar.duu()) {
                    if (eVar.mdD < j) {
                        eVar.aK(Integer.MIN_VALUE);
                    }
                    if (eVar.duE()) {
                        a(eVar, this.msI);
                    }
                    eVar.Jo(this.msI.size);
                    a(this.msI.offset, eVar.data, this.msI.size);
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
        this.mez.reset(1);
        a(j3, this.mez.data, 1);
        long j4 = j3 + 1;
        byte b2 = this.mez.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (eVar.mdC.iv == null) {
            eVar.mdC.iv = new byte[16];
        }
        a(j4, eVar.mdC.iv, i2);
        long j5 = j4 + i2;
        if (z) {
            this.mez.reset(2);
            a(j5, this.mez.data, 2);
            i = this.mez.readUnsignedShort();
            j = j5 + 2;
        } else {
            j = j5;
        }
        int[] iArr = eVar.mdC.mdl;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.mdC.mdm;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.mez.reset(i3);
            a(j, this.mez.data, i3);
            long j6 = j + i3;
            this.mez.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.mez.readUnsignedShort();
                iArr2[i4] = this.mez.dzE();
            }
            j2 = j6;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.offset));
            j2 = j;
        }
        m.a aVar2 = aVar.mgb;
        eVar.mdC.a(i, iArr, iArr2, aVar2.mes, eVar.mdC.iv, aVar2.mer, aVar2.mdo, aVar2.mdp);
        int i5 = (int) (j2 - aVar.offset);
        aVar.offset += i5;
        aVar.size -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        gi(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.msK.endPosition - j));
            byteBuffer.put(this.msK.msT.data, this.msK.gl(j), min);
            i -= min;
            j += min;
            if (j == this.msK.endPosition) {
                this.msK = this.msK.msU;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        gi(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.msK.endPosition - j));
            System.arraycopy(this.msK.msT.data, this.msK.gl(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == this.msK.endPosition) {
                this.msK = this.msK.msU;
            }
        }
    }

    private void gi(long j) {
        while (j >= this.msK.endPosition) {
            this.msK = this.msK.msU;
        }
    }

    private void gj(long j) {
        if (j != -1) {
            while (j >= this.msJ.endPosition) {
                this.mru.a(this.msJ.msT);
                this.msJ = this.msJ.dwG();
            }
            if (this.msK.startPosition < this.msJ.startPosition) {
                this.msK = this.msJ;
            }
        }
    }

    public void a(b bVar) {
        this.msR = bVar;
    }

    public void gk(long j) {
        if (this.msP != j) {
            this.msP = j;
            this.msN = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
        Format a2 = a(format, this.msP);
        boolean l = this.msH.l(a2);
        this.msO = format;
        this.msN = false;
        if (this.msR != null && l) {
            this.msR.k(a2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
        int read = fVar.read(this.msL.msT.data, this.msL.gl(this.totalBytesWritten), KM(i));
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
            lVar.G(this.msL.msT.data, this.msL.gl(this.totalBytesWritten), KM);
            i -= KM;
            KN(KM);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.msN) {
            h(this.msO);
        }
        if (this.msQ) {
            if ((i & 1) != 0 && this.msH.gh(j)) {
                this.msQ = false;
            } else {
                return;
            }
        }
        this.msH.a(j + this.msP, i, (this.totalBytesWritten - i2) - i3, i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.msS) {
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[(this.msL.msS ? 1 : 0) + (((int) (this.msL.startPosition - aVar.startPosition)) / this.msG)];
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr[i] = aVar.msT;
                aVar = aVar.dwG();
            }
            this.mru.a(aVarArr);
        }
    }

    private int KM(int i) {
        if (!this.msL.msS) {
            this.msL.a(this.mru.dyS(), new a(this.msL.endPosition, this.msG));
        }
        return Math.min(i, (int) (this.msL.endPosition - this.totalBytesWritten));
    }

    private void KN(int i) {
        this.totalBytesWritten += i;
        if (this.totalBytesWritten == this.msL.endPosition) {
            this.msL = this.msL.msU;
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
        public boolean msS;
        @Nullable
        public com.google.android.exoplayer2.upstream.a msT;
        @Nullable
        public a msU;
        public final long startPosition;

        public a(long j, int i) {
            this.startPosition = j;
            this.endPosition = i + j;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.msT = aVar;
            this.msU = aVar2;
            this.msS = true;
        }

        public int gl(long j) {
            return ((int) (j - this.startPosition)) + this.msT.offset;
        }

        public a dwG() {
            this.msT = null;
            a aVar = this.msU;
            this.msU = null;
            return aVar;
        }
    }
}
