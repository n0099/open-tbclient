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
    private final com.google.android.exoplayer2.upstream.b mrF;
    private final int msR;
    private a msU;
    private a msV;
    private a msW;
    private Format msX;
    private boolean msY;
    private Format msZ;
    private long mta;
    private boolean mtb;
    private b mtc;
    private long totalBytesWritten;
    private final n msS = new n();
    private final n.a msT = new n.a();
    private final com.google.android.exoplayer2.util.l meK = new com.google.android.exoplayer2.util.l(32);

    /* loaded from: classes6.dex */
    public interface b {
        void k(Format format);
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.mrF = bVar;
        this.msR = bVar.dyU();
        this.msU = new a(0L, this.msR);
        this.msV = this.msU;
        this.msW = this.msU;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.msS.reset(z);
        a(this.msU);
        this.msU = new a(0L, this.msR);
        this.msV = this.msU;
        this.msW = this.msU;
        this.totalBytesWritten = 0L;
        this.mrF.trim();
    }

    public void KH(int i) {
        this.msS.KH(i);
    }

    public void dwE() {
        this.mtb = true;
    }

    public int dww() {
        return this.msS.dww();
    }

    public void KL(int i) {
        this.totalBytesWritten = this.msS.KG(i);
        if (this.totalBytesWritten == 0 || this.totalBytesWritten == this.msU.startPosition) {
            a(this.msU);
            this.msU = new a(this.totalBytesWritten, this.msR);
            this.msV = this.msU;
            this.msW = this.msU;
            return;
        }
        a aVar = this.msU;
        while (this.totalBytesWritten > aVar.endPosition) {
            aVar = aVar.mtf;
        }
        a aVar2 = aVar.mtf;
        a(aVar2);
        aVar.mtf = new a(aVar.endPosition, this.msR);
        this.msW = this.totalBytesWritten == aVar.endPosition ? aVar.mtf : aVar;
        if (this.msV == aVar2) {
            this.msV = aVar.mtf;
        }
    }

    public boolean dwz() {
        return this.msS.dwz();
    }

    public int dwx() {
        return this.msS.dwx();
    }

    public int dwy() {
        return this.msS.dwy();
    }

    public Format dwA() {
        return this.msS.dwA();
    }

    public long dws() {
        return this.msS.dws();
    }

    public void rewind() {
        this.msS.rewind();
        this.msV = this.msU;
    }

    public void c(long j, boolean z, boolean z2) {
        gj(this.msS.b(j, z, z2));
    }

    public void dwF() {
        gj(this.msS.dwC());
    }

    public void dwG() {
        gj(this.msS.dwD());
    }

    public int dwB() {
        return this.msS.dwB();
    }

    public int a(long j, boolean z, boolean z2) {
        return this.msS.a(j, z, z2);
    }

    public int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, long j) {
        switch (this.msS.a(mVar, eVar, z, z2, this.msX, this.msT)) {
            case -5:
                this.msX = mVar.lZJ;
                return -5;
            case -4:
                if (!eVar.duv()) {
                    if (eVar.mdO < j) {
                        eVar.aK(Integer.MIN_VALUE);
                    }
                    if (eVar.duF()) {
                        a(eVar, this.msT);
                    }
                    eVar.Jo(this.msT.size);
                    a(this.msT.offset, eVar.data, this.msT.size);
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
        this.meK.reset(1);
        a(j3, this.meK.data, 1);
        long j4 = j3 + 1;
        byte b2 = this.meK.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (eVar.mdN.iv == null) {
            eVar.mdN.iv = new byte[16];
        }
        a(j4, eVar.mdN.iv, i2);
        long j5 = j4 + i2;
        if (z) {
            this.meK.reset(2);
            a(j5, this.meK.data, 2);
            i = this.meK.readUnsignedShort();
            j = j5 + 2;
        } else {
            j = j5;
        }
        int[] iArr = eVar.mdN.mdw;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.mdN.mdx;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.meK.reset(i3);
            a(j, this.meK.data, i3);
            long j6 = j + i3;
            this.meK.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.meK.readUnsignedShort();
                iArr2[i4] = this.meK.dzF();
            }
            j2 = j6;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.offset));
            j2 = j;
        }
        m.a aVar2 = aVar.mgm;
        eVar.mdN.a(i, iArr, iArr2, aVar2.meD, eVar.mdN.iv, aVar2.meC, aVar2.mdz, aVar2.mdA);
        int i5 = (int) (j2 - aVar.offset);
        aVar.offset += i5;
        aVar.size -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        gi(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.msV.endPosition - j));
            byteBuffer.put(this.msV.mte.data, this.msV.gl(j), min);
            i -= min;
            j += min;
            if (j == this.msV.endPosition) {
                this.msV = this.msV.mtf;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        gi(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.msV.endPosition - j));
            System.arraycopy(this.msV.mte.data, this.msV.gl(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == this.msV.endPosition) {
                this.msV = this.msV.mtf;
            }
        }
    }

    private void gi(long j) {
        while (j >= this.msV.endPosition) {
            this.msV = this.msV.mtf;
        }
    }

    private void gj(long j) {
        if (j != -1) {
            while (j >= this.msU.endPosition) {
                this.mrF.a(this.msU.mte);
                this.msU = this.msU.dwH();
            }
            if (this.msV.startPosition < this.msU.startPosition) {
                this.msV = this.msU;
            }
        }
    }

    public void a(b bVar) {
        this.mtc = bVar;
    }

    public void gk(long j) {
        if (this.mta != j) {
            this.mta = j;
            this.msY = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
        Format a2 = a(format, this.mta);
        boolean l = this.msS.l(a2);
        this.msZ = format;
        this.msY = false;
        if (this.mtc != null && l) {
            this.mtc.k(a2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
        int read = fVar.read(this.msW.mte.data, this.msW.gl(this.totalBytesWritten), KM(i));
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
            lVar.G(this.msW.mte.data, this.msW.gl(this.totalBytesWritten), KM);
            i -= KM;
            KN(KM);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.msY) {
            h(this.msZ);
        }
        if (this.mtb) {
            if ((i & 1) != 0 && this.msS.gh(j)) {
                this.mtb = false;
            } else {
                return;
            }
        }
        this.msS.a(j + this.mta, i, (this.totalBytesWritten - i2) - i3, i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.mtd) {
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[(this.msW.mtd ? 1 : 0) + (((int) (this.msW.startPosition - aVar.startPosition)) / this.msR)];
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr[i] = aVar.mte;
                aVar = aVar.dwH();
            }
            this.mrF.a(aVarArr);
        }
    }

    private int KM(int i) {
        if (!this.msW.mtd) {
            this.msW.a(this.mrF.dyT(), new a(this.msW.endPosition, this.msR));
        }
        return Math.min(i, (int) (this.msW.endPosition - this.totalBytesWritten));
    }

    private void KN(int i) {
        this.totalBytesWritten += i;
        if (this.totalBytesWritten == this.msW.endPosition) {
            this.msW = this.msW.mtf;
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
        public boolean mtd;
        @Nullable
        public com.google.android.exoplayer2.upstream.a mte;
        @Nullable
        public a mtf;
        public final long startPosition;

        public a(long j, int i) {
            this.startPosition = j;
            this.endPosition = i + j;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.mte = aVar;
            this.mtf = aVar2;
            this.mtd = true;
        }

        public int gl(long j) {
            return ((int) (j - this.startPosition)) + this.mte.offset;
        }

        public a dwH() {
            this.mte = null;
            a aVar = this.mtf;
            this.mtf = null;
            return aVar;
        }
    }
}
