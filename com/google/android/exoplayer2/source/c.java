package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.k;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements k, k.a {
    public final k mbc;
    private k.a msN;
    private long msO = -9223372036854775807L;
    private long msP = -9223372036854775807L;
    private a[] msQ = new a[0];
    private boolean msR;

    public c(k kVar, boolean z) {
        this.mbc = kVar;
        this.msR = z;
    }

    public void R(long j, long j2) {
        this.msO = j;
        this.msP = j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.msN = aVar;
        this.mbc.a(this, this.msO + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwC() throws IOException {
        this.mbc.dwC();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwD() {
        return this.mbc.dwD();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        p pVar;
        this.msQ = new a[pVarArr.length];
        p[] pVarArr2 = new p[pVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pVarArr.length) {
                break;
            }
            this.msQ[i2] = (a) pVarArr[i2];
            if (this.msQ[i2] == null) {
                pVar = null;
            } else {
                pVar = this.msQ[i2].lZR;
            }
            pVarArr2[i2] = pVar;
            i = i2 + 1;
        }
        long a2 = this.mbc.a(fVarArr, zArr, pVarArr2, zArr2, j + this.msO);
        if (this.msR) {
            this.msR = this.msO != 0 && a(fVarArr);
        }
        com.google.android.exoplayer2.util.a.checkState(a2 == this.msO + j || (a2 >= this.msO && (this.msP == Long.MIN_VALUE || a2 <= this.msP)));
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr2[i3] == null) {
                this.msQ[i3] = null;
            } else if (pVarArr[i3] == null || this.msQ[i3].lZR != pVarArr2[i3]) {
                this.msQ[i3] = new a(this, pVarArr2[i3], this.msO, this.msP, this.msR);
            }
            pVarArr[i3] = this.msQ[i3];
        }
        return a2 - this.msO;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gc(long j) {
        this.mbc.gc(this.msO + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwE() {
        a[] aVarArr;
        boolean z = false;
        if (this.msR) {
            for (a aVar : this.msQ) {
                if (aVar != null) {
                    aVar.dwH();
                }
            }
            this.msR = false;
            long dwE = dwE();
            if (dwE == -9223372036854775807L) {
                return 0L;
            }
            return dwE;
        }
        long dwE2 = this.mbc.dwE();
        if (dwE2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.util.a.checkState(dwE2 >= this.msO);
        com.google.android.exoplayer2.util.a.checkState((this.msP == Long.MIN_VALUE || dwE2 <= this.msP) ? true : true);
        return dwE2 - this.msO;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwF() {
        long dwF = this.mbc.dwF();
        if (dwF != Long.MIN_VALUE) {
            if (this.msP == Long.MIN_VALUE || dwF < this.msP) {
                return Math.max(0L, dwF - this.msO);
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gd(long j) {
        a[] aVarArr;
        boolean z = false;
        for (a aVar : this.msQ) {
            if (aVar != null) {
                aVar.dwI();
            }
        }
        long gd = this.mbc.gd(this.msO + j);
        if (gd == this.msO + j || (gd >= this.msO && (this.msP == Long.MIN_VALUE || gd <= this.msP))) {
            z = true;
        }
        com.google.android.exoplayer2.util.a.checkState(z);
        return gd - this.msO;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwG() {
        long dwG = this.mbc.dwG();
        if (dwG != Long.MIN_VALUE) {
            if (this.msP == Long.MIN_VALUE || dwG < this.msP) {
                return dwG - this.msO;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ge(long j) {
        return this.mbc.ge(this.msO + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        com.google.android.exoplayer2.util.a.checkState((this.msO == -9223372036854775807L || this.msP == -9223372036854775807L) ? false : true);
        this.msN.a((k) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        this.msN.a((k.a) this);
    }

    private static boolean a(com.google.android.exoplayer2.b.f[] fVarArr) {
        for (com.google.android.exoplayer2.b.f fVar : fVarArr) {
            if (fVar != null && !com.google.android.exoplayer2.util.i.Qp(fVar.dyV().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private static final class a implements p {
        private final p lZR;
        private final k mbc;
        private final long msO;
        private final long msP;
        private boolean msS;
        private boolean msT;

        public a(k kVar, p pVar, long j, long j2, boolean z) {
            this.mbc = kVar;
            this.lZR = pVar;
            this.msO = j;
            this.msP = j2;
            this.msS = z;
        }

        public void dwH() {
            this.msS = false;
        }

        public void dwI() {
            this.msT = false;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return this.lZR.isReady();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwJ() throws IOException {
            this.lZR.dwJ();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (this.msS) {
                return -3;
            }
            if (this.msT) {
                eVar.setFlags(4);
                return -4;
            }
            int b = this.lZR.b(mVar, eVar, z);
            if (b == -5) {
                Format format = mVar.mbs;
                mVar.mbs = format.dG(this.msO != 0 ? 0 : format.encoderDelay, this.msP == Long.MIN_VALUE ? format.encoderPadding : 0);
                return -5;
            } else if (this.msP != Long.MIN_VALUE && ((b == -4 && eVar.mfu >= this.msP) || (b == -3 && this.mbc.dwF() == Long.MIN_VALUE))) {
                eVar.clear();
                eVar.setFlags(4);
                this.msT = true;
                return -4;
            } else {
                if (b == -4 && !eVar.duS()) {
                    eVar.mfu -= this.msO;
                }
                return b;
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gf(long j) {
            return this.lZR.gf(this.msO + j);
        }
    }
}
