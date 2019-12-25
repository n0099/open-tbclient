package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.source.n;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public final class o implements com.google.android.exoplayer2.extractor.m {
    private final com.google.android.exoplayer2.upstream.b mmS;
    private final int mod;
    private a mog;
    private a moh;
    private a moi;
    private Format moj;
    private boolean mok;
    private Format mol;
    private long mom;
    private boolean moo;
    private b mop;
    private long totalBytesWritten;
    private final n moe = new n();
    private final n.a mof = new n.a();
    private final com.google.android.exoplayer2.util.l lZU = new com.google.android.exoplayer2.util.l(32);

    /* loaded from: classes4.dex */
    public interface b {
        void k(Format format);
    }

    public o(com.google.android.exoplayer2.upstream.b bVar) {
        this.mmS = bVar;
        this.mod = bVar.dwu();
        this.mog = new a(0L, this.mod);
        this.moh = this.mog;
        this.moi = this.mog;
    }

    public void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.moe.reset(z);
        a(this.mog);
        this.mog = new a(0L, this.mod);
        this.moh = this.mog;
        this.moi = this.mog;
        this.totalBytesWritten = 0L;
        this.mmS.trim();
    }

    public void Kt(int i) {
        this.moe.Kt(i);
    }

    public void due() {
        this.moo = true;
    }

    public int dtW() {
        return this.moe.dtW();
    }

    public void Kx(int i) {
        this.totalBytesWritten = this.moe.Ks(i);
        if (this.totalBytesWritten == 0 || this.totalBytesWritten == this.mog.startPosition) {
            a(this.mog);
            this.mog = new a(this.totalBytesWritten, this.mod);
            this.moh = this.mog;
            this.moi = this.mog;
            return;
        }
        a aVar = this.mog;
        while (this.totalBytesWritten > aVar.endPosition) {
            aVar = aVar.mos;
        }
        a aVar2 = aVar.mos;
        a(aVar2);
        aVar.mos = new a(aVar.endPosition, this.mod);
        this.moi = this.totalBytesWritten == aVar.endPosition ? aVar.mos : aVar;
        if (this.moh == aVar2) {
            this.moh = aVar.mos;
        }
    }

    public boolean dtZ() {
        return this.moe.dtZ();
    }

    public int dtX() {
        return this.moe.dtX();
    }

    public int dtY() {
        return this.moe.dtY();
    }

    public Format dua() {
        return this.moe.dua();
    }

    public long dtS() {
        return this.moe.dtS();
    }

    public void rewind() {
        this.moe.rewind();
        this.moh = this.mog;
    }

    public void c(long j, boolean z, boolean z2) {
        gg(this.moe.b(j, z, z2));
    }

    public void duf() {
        gg(this.moe.duc());
    }

    public void dug() {
        gg(this.moe.dud());
    }

    public int dub() {
        return this.moe.dub();
    }

    public int a(long j, boolean z, boolean z2) {
        return this.moe.a(j, z, z2);
    }

    public int a(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z, boolean z2, long j) {
        switch (this.moe.a(mVar, eVar, z, z2, this.moj, this.mof)) {
            case -5:
                this.moj = mVar.lUU;
                return -5;
            case -4:
                if (!eVar.drT()) {
                    if (eVar.lYY < j) {
                        eVar.aH(Integer.MIN_VALUE);
                    }
                    if (eVar.dsd()) {
                        a(eVar, this.mof);
                    }
                    eVar.Ja(this.mof.size);
                    a(this.mof.offset, eVar.data, this.mof.size);
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
        this.lZU.reset(1);
        a(j3, this.lZU.data, 1);
        long j4 = j3 + 1;
        byte b2 = this.lZU.data[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        if (eVar.lYX.iv == null) {
            eVar.lYX.iv = new byte[16];
        }
        a(j4, eVar.lYX.iv, i2);
        long j5 = j4 + i2;
        if (z) {
            this.lZU.reset(2);
            a(j5, this.lZU.data, 2);
            i = this.lZU.readUnsignedShort();
            j = j5 + 2;
        } else {
            j = j5;
        }
        int[] iArr = eVar.lYX.lYG;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = eVar.lYX.lYH;
        if (iArr2 == null || iArr2.length < i) {
            iArr2 = new int[i];
        }
        if (z) {
            int i3 = i * 6;
            this.lZU.reset(i3);
            a(j, this.lZU.data, i3);
            long j6 = j + i3;
            this.lZU.setPosition(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr[i4] = this.lZU.readUnsignedShort();
                iArr2[i4] = this.lZU.dxg();
            }
            j2 = j6;
        } else {
            iArr[0] = 0;
            iArr2[0] = aVar.size - ((int) (j - aVar.offset));
            j2 = j;
        }
        m.a aVar2 = aVar.mbz;
        eVar.lYX.a(i, iArr, iArr2, aVar2.lZN, eVar.lYX.iv, aVar2.lZM, aVar2.lYJ, aVar2.lYK);
        int i5 = (int) (j2 - aVar.offset);
        aVar.offset += i5;
        aVar.size -= i5;
    }

    private void a(long j, ByteBuffer byteBuffer, int i) {
        gf(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.moh.endPosition - j));
            byteBuffer.put(this.moh.mor.data, this.moh.gi(j), min);
            i -= min;
            j += min;
            if (j == this.moh.endPosition) {
                this.moh = this.moh.mos;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        gf(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.moh.endPosition - j));
            System.arraycopy(this.moh.mor.data, this.moh.gi(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            if (j == this.moh.endPosition) {
                this.moh = this.moh.mos;
            }
        }
    }

    private void gf(long j) {
        while (j >= this.moh.endPosition) {
            this.moh = this.moh.mos;
        }
    }

    private void gg(long j) {
        if (j != -1) {
            while (j >= this.mog.endPosition) {
                this.mmS.a(this.mog.mor);
                this.mog = this.mog.duh();
            }
            if (this.moh.startPosition < this.mog.startPosition) {
                this.moh = this.mog;
            }
        }
    }

    public void a(b bVar) {
        this.mop = bVar;
    }

    public void gh(long j) {
        if (this.mom != j) {
            this.mom = j;
            this.mok = true;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void h(Format format) {
        Format a2 = a(format, this.mom);
        boolean l = this.moe.l(a2);
        this.mol = format;
        this.mok = false;
        if (this.mop != null && l) {
            this.mop.k(a2);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public int a(com.google.android.exoplayer2.extractor.f fVar, int i, boolean z) throws IOException, InterruptedException {
        int read = fVar.read(this.moi.mor.data, this.moi.gi(this.totalBytesWritten), Ky(i));
        if (read == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        Kz(read);
        return read;
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(com.google.android.exoplayer2.util.l lVar, int i) {
        while (i > 0) {
            int Ky = Ky(i);
            lVar.D(this.moi.mor.data, this.moi.gi(this.totalBytesWritten), Ky);
            i -= Ky;
            Kz(Ky);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.m
    public void a(long j, int i, int i2, int i3, m.a aVar) {
        if (this.mok) {
            h(this.mol);
        }
        if (this.moo) {
            if ((i & 1) != 0 && this.moe.ge(j)) {
                this.moo = false;
            } else {
                return;
            }
        }
        this.moe.a(j + this.mom, i, (this.totalBytesWritten - i2) - i3, i2, aVar);
    }

    private void a(a aVar) {
        if (aVar.moq) {
            com.google.android.exoplayer2.upstream.a[] aVarArr = new com.google.android.exoplayer2.upstream.a[(this.moi.moq ? 1 : 0) + (((int) (this.moi.startPosition - aVar.startPosition)) / this.mod)];
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr[i] = aVar.mor;
                aVar = aVar.duh();
            }
            this.mmS.a(aVarArr);
        }
    }

    private int Ky(int i) {
        if (!this.moi.moq) {
            this.moi.a(this.mmS.dwt(), new a(this.moi.endPosition, this.mod));
        }
        return Math.min(i, (int) (this.moi.endPosition - this.totalBytesWritten));
    }

    private void Kz(int i) {
        this.totalBytesWritten += i;
        if (this.totalBytesWritten == this.moi.endPosition) {
            this.moi = this.moi.mos;
        }
    }

    private static Format a(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j != 0 && format.subsampleOffsetUs != Format.OFFSET_SAMPLE_RELATIVE) {
            return format.fu(format.subsampleOffsetUs + j);
        }
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        public final long endPosition;
        public boolean moq;
        @Nullable
        public com.google.android.exoplayer2.upstream.a mor;
        @Nullable
        public a mos;
        public final long startPosition;

        public a(long j, int i) {
            this.startPosition = j;
            this.endPosition = i + j;
        }

        public void a(com.google.android.exoplayer2.upstream.a aVar, a aVar2) {
            this.mor = aVar;
            this.mos = aVar2;
            this.moq = true;
        }

        public int gi(long j) {
            return ((int) (j - this.startPosition)) + this.mor.offset;
        }

        public a duh() {
            this.mor = null;
            a aVar = this.mos;
            this.mos = null;
            return aVar;
        }
    }
}
