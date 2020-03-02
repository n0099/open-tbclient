package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.k;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements k, k.a {
    public final k lZi;
    private k.a mqV;
    private long mqW = -9223372036854775807L;
    private long mqX = -9223372036854775807L;
    private a[] mqY = new a[0];
    private boolean mqZ;

    public c(k kVar, boolean z) {
        this.lZi = kVar;
        this.mqZ = z;
    }

    public void R(long j, long j2) {
        this.mqW = j;
        this.mqX = j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqV = aVar;
        this.lZi.a(this, this.mqW + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwe() throws IOException {
        this.lZi.dwe();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwf() {
        return this.lZi.dwf();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        p pVar;
        this.mqY = new a[pVarArr.length];
        p[] pVarArr2 = new p[pVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pVarArr.length) {
                break;
            }
            this.mqY[i2] = (a) pVarArr[i2];
            if (this.mqY[i2] == null) {
                pVar = null;
            } else {
                pVar = this.mqY[i2].lYa;
            }
            pVarArr2[i2] = pVar;
            i = i2 + 1;
        }
        long a2 = this.lZi.a(fVarArr, zArr, pVarArr2, zArr2, j + this.mqW);
        if (this.mqZ) {
            this.mqZ = this.mqW != 0 && a(fVarArr);
        }
        com.google.android.exoplayer2.util.a.checkState(a2 == this.mqW + j || (a2 >= this.mqW && (this.mqX == Long.MIN_VALUE || a2 <= this.mqX)));
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr2[i3] == null) {
                this.mqY[i3] = null;
            } else if (pVarArr[i3] == null || this.mqY[i3].lYa != pVarArr2[i3]) {
                this.mqY[i3] = new a(this, pVarArr2[i3], this.mqW, this.mqX, this.mqZ);
            }
            pVarArr[i3] = this.mqY[i3];
        }
        return a2 - this.mqW;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        this.lZi.gb(this.mqW + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwg() {
        a[] aVarArr;
        boolean z = false;
        if (this.mqZ) {
            for (a aVar : this.mqY) {
                if (aVar != null) {
                    aVar.dwj();
                }
            }
            this.mqZ = false;
            long dwg = dwg();
            if (dwg == -9223372036854775807L) {
                return 0L;
            }
            return dwg;
        }
        long dwg2 = this.lZi.dwg();
        if (dwg2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.util.a.checkState(dwg2 >= this.mqW);
        com.google.android.exoplayer2.util.a.checkState((this.mqX == Long.MIN_VALUE || dwg2 <= this.mqX) ? true : true);
        return dwg2 - this.mqW;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwh() {
        long dwh = this.lZi.dwh();
        if (dwh != Long.MIN_VALUE) {
            if (this.mqX == Long.MIN_VALUE || dwh < this.mqX) {
                return Math.max(0L, dwh - this.mqW);
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        a[] aVarArr;
        boolean z = false;
        for (a aVar : this.mqY) {
            if (aVar != null) {
                aVar.dwk();
            }
        }
        long gc = this.lZi.gc(this.mqW + j);
        if (gc == this.mqW + j || (gc >= this.mqW && (this.mqX == Long.MIN_VALUE || gc <= this.mqX))) {
            z = true;
        }
        com.google.android.exoplayer2.util.a.checkState(z);
        return gc - this.mqW;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        long dwi = this.lZi.dwi();
        if (dwi != Long.MIN_VALUE) {
            if (this.mqX == Long.MIN_VALUE || dwi < this.mqX) {
                return dwi - this.mqW;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.lZi.gd(this.mqW + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        com.google.android.exoplayer2.util.a.checkState((this.mqW == -9223372036854775807L || this.mqX == -9223372036854775807L) ? false : true);
        this.mqV.a((k) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        this.mqV.a((k.a) this);
    }

    private static boolean a(com.google.android.exoplayer2.b.f[] fVarArr) {
        for (com.google.android.exoplayer2.b.f fVar : fVarArr) {
            if (fVar != null && !com.google.android.exoplayer2.util.i.Qo(fVar.dyx().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private static final class a implements p {
        private final p lYa;
        private final k lZi;
        private final long mqW;
        private final long mqX;
        private boolean mra;
        private boolean mrb;

        public a(k kVar, p pVar, long j, long j2, boolean z) {
            this.lZi = kVar;
            this.lYa = pVar;
            this.mqW = j;
            this.mqX = j2;
            this.mra = z;
        }

        public void dwj() {
            this.mra = false;
        }

        public void dwk() {
            this.mrb = false;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return this.lYa.isReady();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwl() throws IOException {
            this.lYa.dwl();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (this.mra) {
                return -3;
            }
            if (this.mrb) {
                eVar.setFlags(4);
                return -4;
            }
            int b = this.lYa.b(mVar, eVar, z);
            if (b == -5) {
                Format format = mVar.lZy;
                mVar.lZy = format.dF(this.mqW != 0 ? 0 : format.encoderDelay, this.mqX == Long.MIN_VALUE ? format.encoderPadding : 0);
                return -5;
            } else if (this.mqX != Long.MIN_VALUE && ((b == -4 && eVar.mdD >= this.mqX) || (b == -3 && this.lZi.dwh() == Long.MIN_VALUE))) {
                eVar.clear();
                eVar.setFlags(4);
                this.mrb = true;
                return -4;
            } else {
                if (b == -4 && !eVar.duu()) {
                    eVar.mdD -= this.mqW;
                }
                return b;
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public int ge(long j) {
            return this.lYa.ge(this.mqW + j);
        }
    }
}
