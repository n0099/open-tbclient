package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.k;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class c implements k, k.a {
    public final k lUE;
    private k.a mmt;
    private long mmu = -9223372036854775807L;
    private long mmv = -9223372036854775807L;
    private a[] mmw = new a[0];
    private boolean mmx;

    public c(k kVar, boolean z) {
        this.lUE = kVar;
        this.mmx = z;
    }

    public void S(long j, long j2) {
        this.mmu = j;
        this.mmv = j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mmt = aVar;
        this.lUE.a(this, this.mmu + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dtF() throws IOException {
        this.lUE.dtF();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dtG() {
        return this.lUE.dtG();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        p pVar;
        this.mmw = new a[pVarArr.length];
        p[] pVarArr2 = new p[pVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pVarArr.length) {
                break;
            }
            this.mmw[i2] = (a) pVarArr[i2];
            if (this.mmw[i2] == null) {
                pVar = null;
            } else {
                pVar = this.mmw[i2].lTw;
            }
            pVarArr2[i2] = pVar;
            i = i2 + 1;
        }
        long a2 = this.lUE.a(fVarArr, zArr, pVarArr2, zArr2, j + this.mmu);
        if (this.mmx) {
            this.mmx = this.mmu != 0 && a(fVarArr);
        }
        com.google.android.exoplayer2.util.a.checkState(a2 == this.mmu + j || (a2 >= this.mmu && (this.mmv == Long.MIN_VALUE || a2 <= this.mmv)));
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr2[i3] == null) {
                this.mmw[i3] = null;
            } else if (pVarArr[i3] == null || this.mmw[i3].lTw != pVarArr2[i3]) {
                this.mmw[i3] = new a(this, pVarArr2[i3], this.mmu, this.mmv, this.mmx);
            }
            pVarArr[i3] = this.mmw[i3];
        }
        return a2 - this.mmu;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void fY(long j) {
        this.lUE.fY(this.mmu + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dtH() {
        a[] aVarArr;
        boolean z = false;
        if (this.mmx) {
            for (a aVar : this.mmw) {
                if (aVar != null) {
                    aVar.dtK();
                }
            }
            this.mmx = false;
            long dtH = dtH();
            if (dtH == -9223372036854775807L) {
                return 0L;
            }
            return dtH;
        }
        long dtH2 = this.lUE.dtH();
        if (dtH2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.util.a.checkState(dtH2 >= this.mmu);
        com.google.android.exoplayer2.util.a.checkState((this.mmv == Long.MIN_VALUE || dtH2 <= this.mmv) ? true : true);
        return dtH2 - this.mmu;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtI() {
        long dtI = this.lUE.dtI();
        if (dtI != Long.MIN_VALUE) {
            if (this.mmv == Long.MIN_VALUE || dtI < this.mmv) {
                return Math.max(0L, dtI - this.mmu);
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long fZ(long j) {
        a[] aVarArr;
        boolean z = false;
        for (a aVar : this.mmw) {
            if (aVar != null) {
                aVar.dtL();
            }
        }
        long fZ = this.lUE.fZ(this.mmu + j);
        if (fZ == this.mmu + j || (fZ >= this.mmu && (this.mmv == Long.MIN_VALUE || fZ <= this.mmv))) {
            z = true;
        }
        com.google.android.exoplayer2.util.a.checkState(z);
        return fZ - this.mmu;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtJ() {
        long dtJ = this.lUE.dtJ();
        if (dtJ != Long.MIN_VALUE) {
            if (this.mmv == Long.MIN_VALUE || dtJ < this.mmv) {
                return dtJ - this.mmu;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ga(long j) {
        return this.lUE.ga(this.mmu + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        com.google.android.exoplayer2.util.a.checkState((this.mmu == -9223372036854775807L || this.mmv == -9223372036854775807L) ? false : true);
        this.mmt.a((k) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        this.mmt.a((k.a) this);
    }

    private static boolean a(com.google.android.exoplayer2.b.f[] fVarArr) {
        for (com.google.android.exoplayer2.b.f fVar : fVarArr) {
            if (fVar != null && !com.google.android.exoplayer2.util.i.PQ(fVar.dvY().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes4.dex */
    private static final class a implements p {
        private final p lTw;
        private final k lUE;
        private final long mmu;
        private final long mmv;
        private boolean mmy;
        private boolean mmz;

        public a(k kVar, p pVar, long j, long j2, boolean z) {
            this.lUE = kVar;
            this.lTw = pVar;
            this.mmu = j;
            this.mmv = j2;
            this.mmy = z;
        }

        public void dtK() {
            this.mmy = false;
        }

        public void dtL() {
            this.mmz = false;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return this.lTw.isReady();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dtM() throws IOException {
            this.lTw.dtM();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (this.mmy) {
                return -3;
            }
            if (this.mmz) {
                eVar.setFlags(4);
                return -4;
            }
            int b = this.lTw.b(mVar, eVar, z);
            if (b == -5) {
                Format format = mVar.lUU;
                mVar.lUU = format.dE(this.mmu != 0 ? 0 : format.encoderDelay, this.mmv == Long.MIN_VALUE ? format.encoderPadding : 0);
                return -5;
            } else if (this.mmv != Long.MIN_VALUE && ((b == -4 && eVar.lYY >= this.mmv) || (b == -3 && this.lUE.dtI() == Long.MIN_VALUE))) {
                eVar.clear();
                eVar.setFlags(4);
                this.mmz = true;
                return -4;
            } else {
                if (b == -4 && !eVar.drT()) {
                    eVar.lYY -= this.mmu;
                }
                return b;
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gb(long j) {
            return this.lTw.gb(this.mmu + j);
        }
    }
}
