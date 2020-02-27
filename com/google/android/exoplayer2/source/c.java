package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.k;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements k, k.a {
    public final k lZg;
    private k.a mqT;
    private long mqU = -9223372036854775807L;
    private long mqV = -9223372036854775807L;
    private a[] mqW = new a[0];
    private boolean mqX;

    public c(k kVar, boolean z) {
        this.lZg = kVar;
        this.mqX = z;
    }

    public void R(long j, long j2) {
        this.mqU = j;
        this.mqV = j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqT = aVar;
        this.lZg.a(this, this.mqU + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwc() throws IOException {
        this.lZg.dwc();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwd() {
        return this.lZg.dwd();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        p pVar;
        this.mqW = new a[pVarArr.length];
        p[] pVarArr2 = new p[pVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pVarArr.length) {
                break;
            }
            this.mqW[i2] = (a) pVarArr[i2];
            if (this.mqW[i2] == null) {
                pVar = null;
            } else {
                pVar = this.mqW[i2].lXY;
            }
            pVarArr2[i2] = pVar;
            i = i2 + 1;
        }
        long a2 = this.lZg.a(fVarArr, zArr, pVarArr2, zArr2, j + this.mqU);
        if (this.mqX) {
            this.mqX = this.mqU != 0 && a(fVarArr);
        }
        com.google.android.exoplayer2.util.a.checkState(a2 == this.mqU + j || (a2 >= this.mqU && (this.mqV == Long.MIN_VALUE || a2 <= this.mqV)));
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr2[i3] == null) {
                this.mqW[i3] = null;
            } else if (pVarArr[i3] == null || this.mqW[i3].lXY != pVarArr2[i3]) {
                this.mqW[i3] = new a(this, pVarArr2[i3], this.mqU, this.mqV, this.mqX);
            }
            pVarArr[i3] = this.mqW[i3];
        }
        return a2 - this.mqU;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        this.lZg.gb(this.mqU + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwe() {
        a[] aVarArr;
        boolean z = false;
        if (this.mqX) {
            for (a aVar : this.mqW) {
                if (aVar != null) {
                    aVar.dwh();
                }
            }
            this.mqX = false;
            long dwe = dwe();
            if (dwe == -9223372036854775807L) {
                return 0L;
            }
            return dwe;
        }
        long dwe2 = this.lZg.dwe();
        if (dwe2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.util.a.checkState(dwe2 >= this.mqU);
        com.google.android.exoplayer2.util.a.checkState((this.mqV == Long.MIN_VALUE || dwe2 <= this.mqV) ? true : true);
        return dwe2 - this.mqU;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwf() {
        long dwf = this.lZg.dwf();
        if (dwf != Long.MIN_VALUE) {
            if (this.mqV == Long.MIN_VALUE || dwf < this.mqV) {
                return Math.max(0L, dwf - this.mqU);
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        a[] aVarArr;
        boolean z = false;
        for (a aVar : this.mqW) {
            if (aVar != null) {
                aVar.dwi();
            }
        }
        long gc = this.lZg.gc(this.mqU + j);
        if (gc == this.mqU + j || (gc >= this.mqU && (this.mqV == Long.MIN_VALUE || gc <= this.mqV))) {
            z = true;
        }
        com.google.android.exoplayer2.util.a.checkState(z);
        return gc - this.mqU;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwg() {
        long dwg = this.lZg.dwg();
        if (dwg != Long.MIN_VALUE) {
            if (this.mqV == Long.MIN_VALUE || dwg < this.mqV) {
                return dwg - this.mqU;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.lZg.gd(this.mqU + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        com.google.android.exoplayer2.util.a.checkState((this.mqU == -9223372036854775807L || this.mqV == -9223372036854775807L) ? false : true);
        this.mqT.a((k) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        this.mqT.a((k.a) this);
    }

    private static boolean a(com.google.android.exoplayer2.b.f[] fVarArr) {
        for (com.google.android.exoplayer2.b.f fVar : fVarArr) {
            if (fVar != null && !com.google.android.exoplayer2.util.i.Qo(fVar.dyv().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private static final class a implements p {
        private final p lXY;
        private final k lZg;
        private final long mqU;
        private final long mqV;
        private boolean mqY;
        private boolean mqZ;

        public a(k kVar, p pVar, long j, long j2, boolean z) {
            this.lZg = kVar;
            this.lXY = pVar;
            this.mqU = j;
            this.mqV = j2;
            this.mqY = z;
        }

        public void dwh() {
            this.mqY = false;
        }

        public void dwi() {
            this.mqZ = false;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return this.lXY.isReady();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwj() throws IOException {
            this.lXY.dwj();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (this.mqY) {
                return -3;
            }
            if (this.mqZ) {
                eVar.setFlags(4);
                return -4;
            }
            int b = this.lXY.b(mVar, eVar, z);
            if (b == -5) {
                Format format = mVar.lZw;
                mVar.lZw = format.dF(this.mqU != 0 ? 0 : format.encoderDelay, this.mqV == Long.MIN_VALUE ? format.encoderPadding : 0);
                return -5;
            } else if (this.mqV != Long.MIN_VALUE && ((b == -4 && eVar.mdB >= this.mqV) || (b == -3 && this.lZg.dwf() == Long.MIN_VALUE))) {
                eVar.clear();
                eVar.setFlags(4);
                this.mqZ = true;
                return -4;
            } else {
                if (b == -4 && !eVar.dus()) {
                    eVar.mdB -= this.mqU;
                }
                return b;
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public int ge(long j) {
            return this.lXY.ge(this.mqU + j);
        }
    }
}
