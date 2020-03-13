package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.k;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class c implements k, k.a {
    public final k lZt;
    private k.a mrg;
    private long mrh = -9223372036854775807L;
    private long mri = -9223372036854775807L;
    private a[] mrj = new a[0];
    private boolean mrk;

    public c(k kVar, boolean z) {
        this.lZt = kVar;
        this.mrk = z;
    }

    public void R(long j, long j2) {
        this.mrh = j;
        this.mri = j2;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mrg = aVar;
        this.lZt.a(this, this.mrh + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwf() throws IOException {
        this.lZt.dwf();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwg() {
        return this.lZt.dwg();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        p pVar;
        this.mrj = new a[pVarArr.length];
        p[] pVarArr2 = new p[pVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= pVarArr.length) {
                break;
            }
            this.mrj[i2] = (a) pVarArr[i2];
            if (this.mrj[i2] == null) {
                pVar = null;
            } else {
                pVar = this.mrj[i2].lYl;
            }
            pVarArr2[i2] = pVar;
            i = i2 + 1;
        }
        long a2 = this.lZt.a(fVarArr, zArr, pVarArr2, zArr2, j + this.mrh);
        if (this.mrk) {
            this.mrk = this.mrh != 0 && a(fVarArr);
        }
        com.google.android.exoplayer2.util.a.checkState(a2 == this.mrh + j || (a2 >= this.mrh && (this.mri == Long.MIN_VALUE || a2 <= this.mri)));
        for (int i3 = 0; i3 < pVarArr.length; i3++) {
            if (pVarArr2[i3] == null) {
                this.mrj[i3] = null;
            } else if (pVarArr[i3] == null || this.mrj[i3].lYl != pVarArr2[i3]) {
                this.mrj[i3] = new a(this, pVarArr2[i3], this.mrh, this.mri, this.mrk);
            }
            pVarArr[i3] = this.mrj[i3];
        }
        return a2 - this.mrh;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        this.lZt.gb(this.mrh + j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwh() {
        a[] aVarArr;
        boolean z = false;
        if (this.mrk) {
            for (a aVar : this.mrj) {
                if (aVar != null) {
                    aVar.dwk();
                }
            }
            this.mrk = false;
            long dwh = dwh();
            if (dwh == -9223372036854775807L) {
                return 0L;
            }
            return dwh;
        }
        long dwh2 = this.lZt.dwh();
        if (dwh2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        com.google.android.exoplayer2.util.a.checkState(dwh2 >= this.mrh);
        com.google.android.exoplayer2.util.a.checkState((this.mri == Long.MIN_VALUE || dwh2 <= this.mri) ? true : true);
        return dwh2 - this.mrh;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        long dwi = this.lZt.dwi();
        if (dwi != Long.MIN_VALUE) {
            if (this.mri == Long.MIN_VALUE || dwi < this.mri) {
                return Math.max(0L, dwi - this.mrh);
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        a[] aVarArr;
        boolean z = false;
        for (a aVar : this.mrj) {
            if (aVar != null) {
                aVar.dwl();
            }
        }
        long gc = this.lZt.gc(this.mrh + j);
        if (gc == this.mrh + j || (gc >= this.mrh && (this.mri == Long.MIN_VALUE || gc <= this.mri))) {
            z = true;
        }
        com.google.android.exoplayer2.util.a.checkState(z);
        return gc - this.mrh;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwj() {
        long dwj = this.lZt.dwj();
        if (dwj != Long.MIN_VALUE) {
            if (this.mri == Long.MIN_VALUE || dwj < this.mri) {
                return dwj - this.mrh;
            }
            return Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.lZt.gd(this.mrh + j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.source.k.a
    public void a(k kVar) {
        com.google.android.exoplayer2.util.a.checkState((this.mrh == -9223372036854775807L || this.mri == -9223372036854775807L) ? false : true);
        this.mrg.a((k) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(k kVar) {
        this.mrg.a((k.a) this);
    }

    private static boolean a(com.google.android.exoplayer2.b.f[] fVarArr) {
        for (com.google.android.exoplayer2.b.f fVar : fVarArr) {
            if (fVar != null && !com.google.android.exoplayer2.util.i.Qp(fVar.dyy().sampleMimeType)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes6.dex */
    private static final class a implements p {
        private final p lYl;
        private final k lZt;
        private final long mrh;
        private final long mri;
        private boolean mrl;
        private boolean mrm;

        public a(k kVar, p pVar, long j, long j2, boolean z) {
            this.lZt = kVar;
            this.lYl = pVar;
            this.mrh = j;
            this.mri = j2;
            this.mrl = z;
        }

        public void dwk() {
            this.mrl = false;
        }

        public void dwl() {
            this.mrm = false;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return this.lYl.isReady();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwm() throws IOException {
            this.lYl.dwm();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            if (this.mrl) {
                return -3;
            }
            if (this.mrm) {
                eVar.setFlags(4);
                return -4;
            }
            int b = this.lYl.b(mVar, eVar, z);
            if (b == -5) {
                Format format = mVar.lZJ;
                mVar.lZJ = format.dF(this.mrh != 0 ? 0 : format.encoderDelay, this.mri == Long.MIN_VALUE ? format.encoderPadding : 0);
                return -5;
            } else if (this.mri != Long.MIN_VALUE && ((b == -4 && eVar.mdO >= this.mri) || (b == -3 && this.lZt.dwi() == Long.MIN_VALUE))) {
                eVar.clear();
                eVar.setFlags(4);
                this.mrm = true;
                return -4;
            } else {
                if (b == -4 && !eVar.duv()) {
                    eVar.mdO -= this.mrh;
                }
                return b;
            }
        }

        @Override // com.google.android.exoplayer2.source.p
        public int ge(long j) {
            return this.lYl.ge(this.mrh + j);
        }
    }
}
