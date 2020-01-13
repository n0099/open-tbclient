package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.source.n;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public final class o implements com.google.android.exoplayer2.extractor.m {
    private final com.google.android.exoplayer2.upstream.b mqH;
    private final int mrS;
    private a mrV;
    private a mrW;
    private a mrX;
    private Format mrY;
    private boolean mrZ;
    private Format msa;
    private long msb;
    private boolean msc;
    private b msd;
    private long totalBytesWritten;
    private final n mrT = new n();
    private final n.a mrU = new n.a();
    private final com.google.android.exoplayer2.util.l mdM = new com.google.android.exoplayer2.util.l(32);

    /* loaded from: classes5.dex */
    public interface b {
        void k(Format format);
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.mqH = bVar;
        this.mrS = bVar.dxF();
        this.mrV = new a(0L, this.mrS);
        this.mrW = this.mrV;
        this.mrX = this.mrV;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.mrT.reset(z);
        a(this.mrV);
        this.mrV = new a(0L, this.mrS);
        this.mrW = this.mrV;
        this.mrX = this.mrV;
        this.totalBytesWritten = 0L;
        this.mqH.trim();
    }

    public void KC(int i) {
        this.mrT.KC(i);
    }

    public void dvp() {
        this.msc = true;
    }

    public int dvh() {
        return this.mrT.dvh();
    }

    public void KG(int i) {
        this.totalBytesWritten = this.mrT.KB(i);
        if (this.totalBytesWritten == 0 || this.totalBytesWritten == this.mrV.startPosition) {
            a(this.mrV);
            this.mrV = new a(this.totalBytesWritten, this.mrS);
            this.mrW = this.mrV;
            this.mrX = this.mrV;
            return;
        }
        a aVar = this.mrV;
        while (this.totalBytesWritten > aVar.endPosition) {
            aVar = aVar.msh;
        }
        a aVar2 = aVar.msh;
        a(aVar2);
        aVar.msh = new a(aVar.endPosition, this.mrS);
        this.mrX = this.totalBytesWritten == aVar.endPosition ? aVar.msh : aVar;
        if (this.mrW == aVar2) {
            this.mrW = aVar.msh;
        }
    }

    public boolean dvk() {
        return this.mrT.dvk();
    }

    public int dvi() {
        return this.mrT.dvi();
    }

    public int dvj() {
        return this.mrT.dvj();
    }

    public Format dvl() {
        return this.mrT.dvl();
    }

    public long dvd() {
        return this.mrT.dvd();
    }

    public void rewind() {
        this.mrT.rewind();
        this.mrW = this.mrV;
    }

    public void c(long j, boolean z, boolean z2) {
        gl(this.mrT.b(j, z, z2));
    }

    public void dvq() {
        gl(this.mrT.dvn());
    }

    public void dvr() {
        gl(this.mrT.dvo());
    }

    public int dvm() {
        return this.mrT.dvm();
    }

    public int a(long j, boolean z, boolean z2) {
        return this.mrT.a(j, z, z2);
    }

    public int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, long j) {
        switch (this.mrT.a(mVar, eVar, z, z2, this.mrY, this.mrU)) {
            case -5:
                this.mrY = mVar.lYL;
                return -5;
            case -4:
                if (!eVar.dtf()) {
                    if (eVar.mcQ < j) {
                        eVar.aH(Integer.MIN_VALUE);
                    }
                    if (eVar.dtp()) {
                        a(eVar, this.mrU);
                    }
                    eVar.Jj(this.mrU.size);
                    a(this.mrU.offset, eVar.data, this.mrU.size);
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
        this.mdM.reset(1);
        a(j3, this.mdM.data, 1);
        long j4 = j3 + 1;
        byte b2 = this.mdM.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (eVar.mcP.iv == null) {
            eVar.mcP.iv = new byte[16];
        }
        a(j4, eVar.mcP.iv, i2);
        long j5 = j4 + i2;
        if (z) {
            this.mdM.reset(2);
            a(j5, this.mdM.data, 2);
            i = this.mdM.readUnsignedShort();
            j = j5 + 2;
        } else {
            j = j5;
        }
        int[] iArr = eVar.mcP.mcy;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.mcP.mcz;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.mdM.reset(i3);
            a(j, this.mdM.data, i3);
            long j6 = j + i3;
            this.mdM.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.mdM.readUnsignedShort();
                iArr2[i4] = this.mdM.dyq();
            }
            j2 = j6;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.offset));
            j2 = j;
        }
        m.a aVar2 = aVar.mfo;
        eVar.mcP.a(i, iArr, iArr2, aVar2.mdF, eVar.mcP.iv, aVar2.mdE, aVar2.mcB, aVar2.mcC);
        int i5 = (int) (j2 - aVar.offset);
        aVar.offset += i5;
        aVar.size -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        gk(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.mrW.endPosition - j));
            byteBuffer.put(this.mrW.msf.data, this.mrW.gn(j), min);
            i -= min;
            j += min;
            if (j == this.mrW.endPosition) {
                this.mrW = this.mrW.msh;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        gk(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.mrW.endPosition - j));
            System.arraycopy(this.mrW.msf.data, this.mrW.gn(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == this.mrW.endPosition) {
                this.mrW = this.mrW.msh;
            }
        }
    }

    private void gk(long j) {
        while (j >= this.mrW.endPosition) {
            this.mrW = this.mrW.msh;
        }
    }

    private void gl(long j) {
        if (j != -1) {
            while (j >= this.mrV.endPosition) {
                this.mqH.a(this.mrV.msf);
                this.mrV = this.mrV.dvs();
            }
            if (this.mrW.startPosition < this.mrV.startPosition) {
                this.mrW = this.mrV;
            }
        }
    }

    public void a(b bVar) {
        this.msd = bVar;
    }

    public void gm(long j) {
        if (this.msb != j) {
            this.msb = j;
            this.mrZ = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
        Format a2 = a(format, this.msb);
        boolean l = this.mrT.l(a2);
        this.msa = format;
        this.mrZ = false;
        if (this.msd != null && l) {
            this.msd.k(a2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
        int read = fVar.read(this.mrX.msf.data, this.mrX.gn(this.totalBytesWritten), KH(i));
        if (read == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        KI(read);
        return read;
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(com.google.android.exoplayer2.util.l lVar, int i) {
        while (i > 0) {
            int KH = KH(i);
            lVar.C(this.mrX.msf.data, this.mrX.gn(this.totalBytesWritten), KH);
            i -= KH;
            KI(KH);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.mrZ) {
            h(this.msa);
        }
        if (this.msc) {
            if ((i & 1) != 0 && this.mrT.gj(j)) {
                this.msc = false;
            } else {
                return;
            }
        }
        this.mrT.a(j + this.msb, i, (this.totalBytesWritten - i2) - i3, i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.mse) {
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[(this.mrX.mse ? 1 : 0) + (((int) (this.mrX.startPosition - aVar.startPosition)) / this.mrS)];
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr[i] = aVar.msf;
                aVar = aVar.dvs();
            }
            this.mqH.a(aVarArr);
        }
    }

    private int KH(int i) {
        if (!this.mrX.mse) {
            this.mrX.a(this.mqH.dxE(), new a(this.mrX.endPosition, this.mrS));
        }
        return Math.min(i, (int) (this.mrX.endPosition - this.totalBytesWritten));
    }

    private void KI(int i) {
        this.totalBytesWritten += i;
        if (this.totalBytesWritten == this.mrX.endPosition) {
            this.mrX = this.mrX.msh;
        }
    }

    private static Format a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j != 0 && format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
            return format.fz(format.subsampleOffsetUs + j);
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final long endPosition;
        public boolean mse;
        @Nullable
        public com.google.android.exoplayer2.upstream.a msf;
        @Nullable
        public a msh;
        public final long startPosition;

        public a(long j, int i) {
            this.startPosition = j;
            this.endPosition = i + j;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.msf = aVar;
            this.msh = aVar2;
            this.mse = true;
        }

        public int gn(long j) {
            return ((int) (j - this.startPosition)) + this.msf.offset;
        }

        public a dvs() {
            this.msf = null;
            a aVar = this.msh;
            this.msh = null;
            return aVar;
        }
    }
}
