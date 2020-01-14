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
    private final com.google.android.exoplayer2.upstream.b mqM;
    private final int mrX;
    private a msa;
    private a msb;
    private a msc;
    private Format msd;
    private boolean mse;
    private Format msf;
    private long msh;
    private boolean msi;
    private b msj;
    private long totalBytesWritten;
    private final n mrY = new n();
    private final n.a mrZ = new n.a();
    private final com.google.android.exoplayer2.util.l mdR = new com.google.android.exoplayer2.util.l(32);

    /* loaded from: classes5.dex */
    public interface b {
        void k(Format format);
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.mqM = bVar;
        this.mrX = bVar.dxH();
        this.msa = new a(0L, this.mrX);
        this.msb = this.msa;
        this.msc = this.msa;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.mrY.reset(z);
        a(this.msa);
        this.msa = new a(0L, this.mrX);
        this.msb = this.msa;
        this.msc = this.msa;
        this.totalBytesWritten = 0L;
        this.mqM.trim();
    }

    public void KC(int i) {
        this.mrY.KC(i);
    }

    public void dvr() {
        this.msi = true;
    }

    public int dvj() {
        return this.mrY.dvj();
    }

    public void KG(int i) {
        this.totalBytesWritten = this.mrY.KB(i);
        if (this.totalBytesWritten == 0 || this.totalBytesWritten == this.msa.startPosition) {
            a(this.msa);
            this.msa = new a(this.totalBytesWritten, this.mrX);
            this.msb = this.msa;
            this.msc = this.msa;
            return;
        }
        a aVar = this.msa;
        while (this.totalBytesWritten > aVar.endPosition) {
            aVar = aVar.msm;
        }
        a aVar2 = aVar.msm;
        a(aVar2);
        aVar.msm = new a(aVar.endPosition, this.mrX);
        this.msc = this.totalBytesWritten == aVar.endPosition ? aVar.msm : aVar;
        if (this.msb == aVar2) {
            this.msb = aVar.msm;
        }
    }

    public boolean dvm() {
        return this.mrY.dvm();
    }

    public int dvk() {
        return this.mrY.dvk();
    }

    public int dvl() {
        return this.mrY.dvl();
    }

    public Format dvn() {
        return this.mrY.dvn();
    }

    public long dvf() {
        return this.mrY.dvf();
    }

    public void rewind() {
        this.mrY.rewind();
        this.msb = this.msa;
    }

    public void c(long j, boolean z, boolean z2) {
        gl(this.mrY.b(j, z, z2));
    }

    public void dvs() {
        gl(this.mrY.dvp());
    }

    public void dvt() {
        gl(this.mrY.dvq());
    }

    public int dvo() {
        return this.mrY.dvo();
    }

    public int a(long j, boolean z, boolean z2) {
        return this.mrY.a(j, z, z2);
    }

    public int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, long j) {
        switch (this.mrY.a(mVar, eVar, z, z2, this.msd, this.mrZ)) {
            case -5:
                this.msd = mVar.lYQ;
                return -5;
            case -4:
                if (!eVar.dth()) {
                    if (eVar.mcV < j) {
                        eVar.aH(Integer.MIN_VALUE);
                    }
                    if (eVar.dtr()) {
                        a(eVar, this.mrZ);
                    }
                    eVar.Jj(this.mrZ.size);
                    a(this.mrZ.offset, eVar.data, this.mrZ.size);
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
        this.mdR.reset(1);
        a(j3, this.mdR.data, 1);
        long j4 = j3 + 1;
        byte b2 = this.mdR.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (eVar.mcU.iv == null) {
            eVar.mcU.iv = new byte[16];
        }
        a(j4, eVar.mcU.iv, i2);
        long j5 = j4 + i2;
        if (z) {
            this.mdR.reset(2);
            a(j5, this.mdR.data, 2);
            i = this.mdR.readUnsignedShort();
            j = j5 + 2;
        } else {
            j = j5;
        }
        int[] iArr = eVar.mcU.mcD;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.mcU.mcE;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.mdR.reset(i3);
            a(j, this.mdR.data, i3);
            long j6 = j + i3;
            this.mdR.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.mdR.readUnsignedShort();
                iArr2[i4] = this.mdR.dys();
            }
            j2 = j6;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.offset));
            j2 = j;
        }
        m.a aVar2 = aVar.mft;
        eVar.mcU.a(i, iArr, iArr2, aVar2.mdK, eVar.mcU.iv, aVar2.mdJ, aVar2.mcG, aVar2.mcH);
        int i5 = (int) (j2 - aVar.offset);
        aVar.offset += i5;
        aVar.size -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        gk(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.msb.endPosition - j));
            byteBuffer.put(this.msb.msl.data, this.msb.gn(j), min);
            i -= min;
            j += min;
            if (j == this.msb.endPosition) {
                this.msb = this.msb.msm;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        gk(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.msb.endPosition - j));
            System.arraycopy(this.msb.msl.data, this.msb.gn(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == this.msb.endPosition) {
                this.msb = this.msb.msm;
            }
        }
    }

    private void gk(long j) {
        while (j >= this.msb.endPosition) {
            this.msb = this.msb.msm;
        }
    }

    private void gl(long j) {
        if (j != -1) {
            while (j >= this.msa.endPosition) {
                this.mqM.a(this.msa.msl);
                this.msa = this.msa.dvu();
            }
            if (this.msb.startPosition < this.msa.startPosition) {
                this.msb = this.msa;
            }
        }
    }

    public void a(b bVar) {
        this.msj = bVar;
    }

    public void gm(long j) {
        if (this.msh != j) {
            this.msh = j;
            this.mse = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
        Format a2 = a(format, this.msh);
        boolean l = this.mrY.l(a2);
        this.msf = format;
        this.mse = false;
        if (this.msj != null && l) {
            this.msj.k(a2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
        int read = fVar.read(this.msc.msl.data, this.msc.gn(this.totalBytesWritten), KH(i));
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
            lVar.C(this.msc.msl.data, this.msc.gn(this.totalBytesWritten), KH);
            i -= KH;
            KI(KH);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.mse) {
            h(this.msf);
        }
        if (this.msi) {
            if ((i & 1) != 0 && this.mrY.gj(j)) {
                this.msi = false;
            } else {
                return;
            }
        }
        this.mrY.a(j + this.msh, i, (this.totalBytesWritten - i2) - i3, i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.msk) {
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[(this.msc.msk ? 1 : 0) + (((int) (this.msc.startPosition - aVar.startPosition)) / this.mrX)];
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr[i] = aVar.msl;
                aVar = aVar.dvu();
            }
            this.mqM.a(aVarArr);
        }
    }

    private int KH(int i) {
        if (!this.msc.msk) {
            this.msc.a(this.mqM.dxG(), new a(this.msc.endPosition, this.mrX));
        }
        return Math.min(i, (int) (this.msc.endPosition - this.totalBytesWritten));
    }

    private void KI(int i) {
        this.totalBytesWritten += i;
        if (this.totalBytesWritten == this.msc.endPosition) {
            this.msc = this.msc.msm;
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
        public boolean msk;
        @Nullable
        public com.google.android.exoplayer2.upstream.a msl;
        @Nullable
        public a msm;
        public final long startPosition;

        public a(long j, int i) {
            this.startPosition = j;
            this.endPosition = i + j;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.msl = aVar;
            this.msm = aVar2;
            this.msk = true;
        }

        public int gn(long j) {
            return ((int) (j - this.startPosition)) + this.msl.offset;
        }

        public a dvu() {
            this.msl = null;
            a aVar = this.msm;
            this.msm = null;
            return aVar;
        }
    }
}
