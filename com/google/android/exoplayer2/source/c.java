package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.k;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class c implements k, k.a {
    public final k lYA;
    private k.a mqn;
    private long mqo = -9223372036854775807L;
    private long mqp = -9223372036854775807L;
    private a[] mqq = new a[0];
    private boolean mqr;

    public c(k kVar, boolean z) {
        this.lYA = kVar;
        this.mqr = z;
    }

    public void S(long j, long j2) {
        this.mqo = j;
        this.mqp = j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqn = aVar;
        this.lYA.a(this, this.mqo + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duS() throws IOException {
        this.lYA.duS();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duT() {
        return this.lYA.duT();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        p pVar;
        this.mqq = new a[pVarArr.length];
        p[] pVarArr2 = new p[pVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pVarArr.length) {
                break;
            }
            this.mqq[i2] = (a) pVarArr[i2];
            if (this.mqq[i2] == null) {
                pVar = null;
            } else {
                pVar = this.mqq[i2].lXs;
            }
            pVarArr2[i2] = pVar;
            i = i2 + 1;
        }
        long a2 = this.lYA.a(fVarArr, zArr, pVarArr2, zArr2, j + this.mqo);
        if (this.mqr) {
            this.mqr = this.mqo != 0 && a(fVarArr);
        }
        com.google.android.exoplayer2.util.a.checkState(a2 == this.mqo + j || (a2 >= this.mqo && (this.mqp == Long.MIN_VALUE || a2 <= this.mqp)));
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr2[i3] == null) {
                this.mqq[i3] = null;
            } else if (pVarArr[i3] == null || this.mqq[i3].lXs != pVarArr2[i3]) {
                this.mqq[i3] = new a(this, pVarArr2[i3], this.mqo, this.mqp, this.mqr);
            }
            pVarArr[i3] = this.mqq[i3];
        }
        return a2 - this.mqo;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        this.lYA.gd(this.mqo + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duU() {
        a[] aVarArr;
        boolean z = false;
        if (this.mqr) {
            for (a aVar : this.mqq) {
                if (aVar != null) {
                    aVar.duX();
                }
            }
            this.mqr = false;
            long duU = duU();
            if (duU == -9223372036854775807L) {
                return 0L;
            }
            return duU;
        }
        long duU2 = this.lYA.duU();
        if (duU2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.util.a.checkState(duU2 >= this.mqo);
        com.google.android.exoplayer2.util.a.checkState((this.mqp == Long.MIN_VALUE || duU2 <= this.mqp) ? true : true);
        return duU2 - this.mqo;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duV() {
        long duV = this.lYA.duV();
        if (duV != Long.MIN_VALUE) {
            if (this.mqp == Long.MIN_VALUE || duV < this.mqp) {
                return Math.max(0L, duV - this.mqo);
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        a[] aVarArr;
        boolean z = false;
        for (a aVar : this.mqq) {
            if (aVar != null) {
                aVar.duY();
            }
        }
        long ge = this.lYA.ge(this.mqo + j);
        if (ge == this.mqo + j || (ge >= this.mqo && (this.mqp == Long.MIN_VALUE || ge <= this.mqp))) {
            z = true;
        }
        com.google.android.exoplayer2.util.a.checkState(z);
        return ge - this.mqo;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duW() {
        long duW = this.lYA.duW();
        if (duW != Long.MIN_VALUE) {
            if (this.mqp == Long.MIN_VALUE || duW < this.mqp) {
                return duW - this.mqo;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.lYA.gf(this.mqo + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        com.google.android.exoplayer2.util.a.checkState((this.mqo == -9223372036854775807L || this.mqp == -9223372036854775807L) ? false : true);
        this.mqn.a((k) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        this.mqn.a((k.a) this);
    }

    private static boolean a(com.google.android.exoplayer2.b.f[] fVarArr) {
        for (com.google.android.exoplayer2.b.f fVar : fVarArr) {
            if (fVar != null && !com.google.android.exoplayer2.util.i.Qb(fVar.dxl().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes5.dex */
    private static final class a implements p {
        private final p lXs;
        private final k lYA;
        private final long mqo;
        private final long mqp;
        private boolean mqs;
        private boolean mqt;

        public a(k kVar, p pVar, long j, long j2, boolean z) {
            this.lYA = kVar;
            this.lXs = pVar;
            this.mqo = j;
            this.mqp = j2;
            this.mqs = z;
        }

        public void duX() {
            this.mqs = false;
        }

        public void duY() {
            this.mqt = false;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return this.lXs.isReady();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void duZ() throws IOException {
            this.lXs.duZ();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (this.mqs) {
                return -3;
            }
            if (this.mqt) {
                eVar.setFlags(4);
                return -4;
            }
            int b = this.lXs.b(mVar, eVar, z);
            if (b == -5) {
                Format format = mVar.lYQ;
                mVar.lYQ = format.dC(this.mqo != 0 ? 0 : format.encoderDelay, this.mqp == Long.MIN_VALUE ? format.encoderPadding : 0);
                return -5;
            } else if (this.mqp != Long.MIN_VALUE && ((b == -4 && eVar.mcV >= this.mqp) || (b == -3 && this.lYA.duV() == Long.MIN_VALUE))) {
                eVar.clear();
                eVar.setFlags(4);
                this.mqt = true;
                return -4;
            } else {
                if (b == -4 && !eVar.dth()) {
                    eVar.mcV -= this.mqo;
                }
                return b;
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gg(long j) {
            return this.lXs.gg(this.mqo + j);
        }
    }
}
