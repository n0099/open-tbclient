package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.k;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class c implements k, k.a {
    public final k lYv;
    private k.a mqi;
    private long mqj = -9223372036854775807L;
    private long mqk = -9223372036854775807L;
    private a[] mql = new a[0];
    private boolean mqm;

    public c(k kVar, boolean z) {
        this.lYv = kVar;
        this.mqm = z;
    }

    public void S(long j, long j2) {
        this.mqj = j;
        this.mqk = j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqi = aVar;
        this.lYv.a(this, this.mqj + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duQ() throws IOException {
        this.lYv.duQ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duR() {
        return this.lYv.duR();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        p pVar;
        this.mql = new a[pVarArr.length];
        p[] pVarArr2 = new p[pVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pVarArr.length) {
                break;
            }
            this.mql[i2] = (a) pVarArr[i2];
            if (this.mql[i2] == null) {
                pVar = null;
            } else {
                pVar = this.mql[i2].lXn;
            }
            pVarArr2[i2] = pVar;
            i = i2 + 1;
        }
        long a2 = this.lYv.a(fVarArr, zArr, pVarArr2, zArr2, j + this.mqj);
        if (this.mqm) {
            this.mqm = this.mqj != 0 && a(fVarArr);
        }
        com.google.android.exoplayer2.util.a.checkState(a2 == this.mqj + j || (a2 >= this.mqj && (this.mqk == Long.MIN_VALUE || a2 <= this.mqk)));
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr2[i3] == null) {
                this.mql[i3] = null;
            } else if (pVarArr[i3] == null || this.mql[i3].lXn != pVarArr2[i3]) {
                this.mql[i3] = new a(this, pVarArr2[i3], this.mqj, this.mqk, this.mqm);
            }
            pVarArr[i3] = this.mql[i3];
        }
        return a2 - this.mqj;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        this.lYv.gd(this.mqj + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duS() {
        a[] aVarArr;
        boolean z = false;
        if (this.mqm) {
            for (a aVar : this.mql) {
                if (aVar != null) {
                    aVar.duV();
                }
            }
            this.mqm = false;
            long duS = duS();
            if (duS == -9223372036854775807L) {
                return 0L;
            }
            return duS;
        }
        long duS2 = this.lYv.duS();
        if (duS2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.util.a.checkState(duS2 >= this.mqj);
        com.google.android.exoplayer2.util.a.checkState((this.mqk == Long.MIN_VALUE || duS2 <= this.mqk) ? true : true);
        return duS2 - this.mqj;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duT() {
        long duT = this.lYv.duT();
        if (duT != Long.MIN_VALUE) {
            if (this.mqk == Long.MIN_VALUE || duT < this.mqk) {
                return Math.max(0L, duT - this.mqj);
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        a[] aVarArr;
        boolean z = false;
        for (a aVar : this.mql) {
            if (aVar != null) {
                aVar.duW();
            }
        }
        long ge = this.lYv.ge(this.mqj + j);
        if (ge == this.mqj + j || (ge >= this.mqj && (this.mqk == Long.MIN_VALUE || ge <= this.mqk))) {
            z = true;
        }
        com.google.android.exoplayer2.util.a.checkState(z);
        return ge - this.mqj;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duU() {
        long duU = this.lYv.duU();
        if (duU != Long.MIN_VALUE) {
            if (this.mqk == Long.MIN_VALUE || duU < this.mqk) {
                return duU - this.mqj;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.lYv.gf(this.mqj + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        com.google.android.exoplayer2.util.a.checkState((this.mqj == -9223372036854775807L || this.mqk == -9223372036854775807L) ? false : true);
        this.mqi.a((k) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        this.mqi.a((k.a) this);
    }

    private static boolean a(com.google.android.exoplayer2.b.f[] fVarArr) {
        for (com.google.android.exoplayer2.b.f fVar : fVarArr) {
            if (fVar != null && !com.google.android.exoplayer2.util.i.Qb(fVar.dxj().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes5.dex */
    private static final class a implements p {
        private final p lXn;
        private final k lYv;
        private final long mqj;
        private final long mqk;
        private boolean mqn;
        private boolean mqo;

        public a(k kVar, p pVar, long j, long j2, boolean z) {
            this.lYv = kVar;
            this.lXn = pVar;
            this.mqj = j;
            this.mqk = j2;
            this.mqn = z;
        }

        public void duV() {
            this.mqn = false;
        }

        public void duW() {
            this.mqo = false;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return this.lXn.isReady();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void duX() throws IOException {
            this.lXn.duX();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (this.mqn) {
                return -3;
            }
            if (this.mqo) {
                eVar.setFlags(4);
                return -4;
            }
            int b = this.lXn.b(mVar, eVar, z);
            if (b == -5) {
                Format format = mVar.lYL;
                mVar.lYL = format.dC(this.mqj != 0 ? 0 : format.encoderDelay, this.mqk == Long.MIN_VALUE ? format.encoderPadding : 0);
                return -5;
            } else if (this.mqk != Long.MIN_VALUE && ((b == -4 && eVar.mcQ >= this.mqk) || (b == -3 && this.lYv.duT() == Long.MIN_VALUE))) {
                eVar.clear();
                eVar.setFlags(4);
                this.mqo = true;
                return -4;
            } else {
                if (b == -4 && !eVar.dtf()) {
                    eVar.mcQ -= this.mqj;
                }
                return b;
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gg(long j) {
            return this.lXn.gg(this.mqj + j);
        }
    }
}
