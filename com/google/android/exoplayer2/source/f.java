package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class f implements l {
    private final r mqD;
    private final l[] mrg;
    private final x[] mrh;
    private final Object[] mri;
    private final Map<k, Integer> mrj;
    private final boolean[] mrk;
    private final boolean mrl;
    private l.a mrm;
    private a mrn;

    public f(l... lVarArr) {
        this(false, lVarArr);
    }

    public f(boolean z, l... lVarArr) {
        this(z, new r.a(lVarArr.length), lVarArr);
    }

    public f(boolean z, r rVar, l... lVarArr) {
        for (l lVar : lVarArr) {
            com.google.android.exoplayer2.util.a.checkNotNull(lVar);
        }
        com.google.android.exoplayer2.util.a.checkArgument(rVar.bTa() == lVarArr.length);
        this.mrg = lVarArr;
        this.mrl = z;
        this.mqD = rVar;
        this.mrh = new x[lVarArr.length];
        this.mri = new Object[lVarArr.length];
        this.mrj = new HashMap();
        this.mrk = a(lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mrm = aVar;
        if (this.mrg.length == 0) {
            aVar.a(this, x.mag, null);
            return;
        }
        for (final int i = 0; i < this.mrg.length; i++) {
            if (!this.mrk[i]) {
                this.mrg[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.f.1
                    @Override // com.google.android.exoplayer2.source.l.a
                    public void a(l lVar, x xVar, Object obj) {
                        f.this.a(i, xVar, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwm() throws IOException {
        for (int i = 0; i < this.mrg.length; i++) {
            if (!this.mrk[i]) {
                this.mrg[i].dwm();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int Ky = this.mrn.Ky(bVar.periodIndex);
        k a2 = this.mrg[Ky].a(bVar.KF(bVar.periodIndex - this.mrn.KB(Ky)), bVar2);
        this.mrj.put(a2, Integer.valueOf(Ky));
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        int intValue = this.mrj.get(kVar).intValue();
        this.mrj.remove(kVar);
        this.mrg[intValue].e(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (int i = 0; i < this.mrg.length; i++) {
            if (!this.mrk[i]) {
                this.mrg[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        this.mrh[i] = xVar;
        this.mri[i] = obj;
        for (int i2 = i + 1; i2 < this.mrg.length; i2++) {
            if (this.mrg[i2] == this.mrg[i]) {
                this.mrh[i2] = xVar;
                this.mri[i2] = obj;
            }
        }
        for (x xVar2 : this.mrh) {
            if (xVar2 == null) {
                return;
            }
        }
        this.mrn = new a((x[]) this.mrh.clone(), this.mrl, this.mqD);
        this.mrm.a(this, this.mrn, this.mri.clone());
    }

    private static boolean[] a(l[] lVarArr) {
        boolean[] zArr = new boolean[lVarArr.length];
        IdentityHashMap identityHashMap = new IdentityHashMap(lVarArr.length);
        for (int i = 0; i < lVarArr.length; i++) {
            l lVar = lVarArr[i];
            if (!identityHashMap.containsKey(lVar)) {
                identityHashMap.put(lVar, null);
            } else {
                zArr[i] = true;
            }
        }
        return zArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.android.exoplayer2.source.a {
        private final x[] mrh;
        private final boolean mrl;
        private final int[] mrp;
        private final int[] mrq;

        public a(x[] xVarArr, boolean z, r rVar) {
            super(rVar);
            int[] iArr = new int[xVarArr.length];
            int[] iArr2 = new int[xVarArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < xVarArr.length; i2++) {
                x xVar = xVarArr[i2];
                j += xVar.dtC();
                com.google.android.exoplayer2.util.a.d(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += xVar.dtB();
                iArr2[i2] = i;
            }
            this.mrh = xVarArr;
            this.mrp = iArr;
            this.mrq = iArr2;
            this.mrl = z;
        }

        @Override // com.google.android.exoplayer2.x
        public int dtB() {
            return this.mrq[this.mrq.length - 1];
        }

        @Override // com.google.android.exoplayer2.x
        public int dtC() {
            return this.mrp[this.mrp.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int p(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mrl && i2 == 1) {
                i2 = 2;
            }
            return super.p(i, i2, (this.mrl || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int q(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mrl && i2 == 1) {
                i2 = 2;
            }
            return super.q(i, i2, (this.mrl || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vD(boolean z) {
            return super.vD(!this.mrl && z);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vE(boolean z) {
            return super.vE(!this.mrl && z);
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Ky(int i) {
            return v.a(this.mrp, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kz(int i) {
            return v.a(this.mrq, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int by(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected x KA(int i) {
            return this.mrh[i];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KB(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mrp[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KC(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mrq[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected Object KD(int i) {
            return Integer.valueOf(i);
        }
    }
}
