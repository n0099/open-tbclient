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
    private final com.google.android.exoplayer2.upstream.b mtm;
    private a muB;
    private a muC;
    private a muD;
    private Format muE;
    private boolean muF;
    private Format muG;
    private long muH;
    private boolean muI;
    private b muJ;
    private final int muy;
    private long totalBytesWritten;
    private final n muz = new n();
    private final n.a muA = new n.a();
    private final com.google.android.exoplayer2.util.l mgq = new com.google.android.exoplayer2.util.l(32);

    /* loaded from: classes6.dex */
    public interface b {
        void k(Format format);
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.mtm = bVar;
        this.muy = bVar.dzr();
        this.muB = new a(0L, this.muy);
        this.muC = this.muB;
        this.muD = this.muB;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.muz.reset(z);
        a(this.muB);
        this.muB = new a(0L, this.muy);
        this.muC = this.muB;
        this.muD = this.muB;
        this.totalBytesWritten = 0L;
        this.mtm.trim();
    }

    public void KN(int i) {
        this.muz.KN(i);
    }

    public void dxb() {
        this.muI = true;
    }

    public int dwT() {
        return this.muz.dwT();
    }

    public void KR(int i) {
        this.totalBytesWritten = this.muz.KM(i);
        if (this.totalBytesWritten == 0 || this.totalBytesWritten == this.muB.startPosition) {
            a(this.muB);
            this.muB = new a(this.totalBytesWritten, this.muy);
            this.muC = this.muB;
            this.muD = this.muB;
            return;
        }
        a aVar = this.muB;
        while (this.totalBytesWritten > aVar.endPosition) {
            aVar = aVar.muM;
        }
        a aVar2 = aVar.muM;
        a(aVar2);
        aVar.muM = new a(aVar.endPosition, this.muy);
        this.muD = this.totalBytesWritten == aVar.endPosition ? aVar.muM : aVar;
        if (this.muC == aVar2) {
            this.muC = aVar.muM;
        }
    }

    public boolean dwW() {
        return this.muz.dwW();
    }

    public int dwU() {
        return this.muz.dwU();
    }

    public int dwV() {
        return this.muz.dwV();
    }

    public Format dwX() {
        return this.muz.dwX();
    }

    public long dwP() {
        return this.muz.dwP();
    }

    public void rewind() {
        this.muz.rewind();
        this.muC = this.muB;
    }

    public void c(long j, boolean z, boolean z2) {
        gk(this.muz.b(j, z, z2));
    }

    public void dxc() {
        gk(this.muz.dwZ());
    }

    public void dxd() {
        gk(this.muz.dxa());
    }

    public int dwY() {
        return this.muz.dwY();
    }

    public int a(long j, boolean z, boolean z2) {
        return this.muz.a(j, z, z2);
    }

    public int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, long j) {
        switch (this.muz.a(mVar, eVar, z, z2, this.muE, this.muA)) {
            case -5:
                this.muE = mVar.mbs;
                return -5;
            case -4:
                if (!eVar.duS()) {
                    if (eVar.mfu < j) {
                        eVar.aK(Integer.MIN_VALUE);
                    }
                    if (eVar.dvc()) {
                        a(eVar, this.muA);
                    }
                    eVar.Ju(this.muA.size);
                    a(this.muA.offset, eVar.data, this.muA.size);
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
        this.mgq.reset(1);
        a(j3, this.mgq.data, 1);
        long j4 = j3 + 1;
        byte b2 = this.mgq.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (eVar.mft.iv == null) {
            eVar.mft.iv = new byte[16];
        }
        a(j4, eVar.mft.iv, i2);
        long j5 = j4 + i2;
        if (z) {
            this.mgq.reset(2);
            a(j5, this.mgq.data, 2);
            i = this.mgq.readUnsignedShort();
            j = j5 + 2;
        } else {
            j = j5;
        }
        int[] iArr = eVar.mft.mfc;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.mft.mfd;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.mgq.reset(i3);
            a(j, this.mgq.data, i3);
            long j6 = j + i3;
            this.mgq.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.mgq.readUnsignedShort();
                iArr2[i4] = this.mgq.dAc();
            }
            j2 = j6;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.offset));
            j2 = j;
        }
        m.a aVar2 = aVar.mhS;
        eVar.mft.a(i, iArr, iArr2, aVar2.mgj, eVar.mft.iv, aVar2.mgi, aVar2.mff, aVar2.mfg);
        int i5 = (int) (j2 - aVar.offset);
        aVar.offset += i5;
        aVar.size -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        gj(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.muC.endPosition - j));
            byteBuffer.put(this.muC.muL.data, this.muC.gm(j), min);
            i -= min;
            j += min;
            if (j == this.muC.endPosition) {
                this.muC = this.muC.muM;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        gj(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.muC.endPosition - j));
            System.arraycopy(this.muC.muL.data, this.muC.gm(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == this.muC.endPosition) {
                this.muC = this.muC.muM;
            }
        }
    }

    private void gj(long j) {
        while (j >= this.muC.endPosition) {
            this.muC = this.muC.muM;
        }
    }

    private void gk(long j) {
        if (j != -1) {
            while (j >= this.muB.endPosition) {
                this.mtm.a(this.muB.muL);
                this.muB = this.muB.dxe();
            }
            if (this.muC.startPosition < this.muB.startPosition) {
                this.muC = this.muB;
            }
        }
    }

    public void a(b bVar) {
        this.muJ = bVar;
    }

    public void gl(long j) {
        if (this.muH != j) {
            this.muH = j;
            this.muF = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
        Format a2 = a(format, this.muH);
        boolean l = this.muz.l(a2);
        this.muG = format;
        this.muF = false;
        if (this.muJ != null && l) {
            this.muJ.k(a2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
        int read = fVar.read(this.muD.muL.data, this.muD.gm(this.totalBytesWritten), KS(i));
        if (read == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        KT(read);
        return read;
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(com.google.android.exoplayer2.util.l lVar, int i) {
        while (i > 0) {
            int KS = KS(i);
            lVar.G(this.muD.muL.data, this.muD.gm(this.totalBytesWritten), KS);
            i -= KS;
            KT(KS);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.muF) {
            h(this.muG);
        }
        if (this.muI) {
            if ((i & 1) != 0 && this.muz.gi(j)) {
                this.muI = false;
            } else {
                return;
            }
        }
        this.muz.a(j + this.muH, i, (this.totalBytesWritten - i2) - i3, i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.muK) {
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[(this.muD.muK ? 1 : 0) + (((int) (this.muD.startPosition - aVar.startPosition)) / this.muy)];
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr[i] = aVar.muL;
                aVar = aVar.dxe();
            }
            this.mtm.a(aVarArr);
        }
    }

    private int KS(int i) {
        if (!this.muD.muK) {
            this.muD.a(this.mtm.dzq(), new a(this.muD.endPosition, this.muy));
        }
        return Math.min(i, (int) (this.muD.endPosition - this.totalBytesWritten));
    }

    private void KT(int i) {
        this.totalBytesWritten += i;
        if (this.totalBytesWritten == this.muD.endPosition) {
            this.muD = this.muD.muM;
        }
    }

    private static Format a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j != 0 && format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
            return format.fy(format.subsampleOffsetUs + j);
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final long endPosition;
        public boolean muK;
        @Nullable
        public com.google.android.exoplayer2.upstream.a muL;
        @Nullable
        public a muM;
        public final long startPosition;

        public a(long j, int i) {
            this.startPosition = j;
            this.endPosition = i + j;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.muL = aVar;
            this.muM = aVar2;
            this.muK = true;
        }

        public int gm(long j) {
            return ((int) (j - this.startPosition)) + this.muL.offset;
        }

        public a dxe() {
            this.muL = null;
            a aVar = this.muM;
            this.muM = null;
            return aVar;
        }
    }
}
