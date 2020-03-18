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
    private final l[] msY;
    private final x[] msZ;
    private final r msv;
    private final Object[] mta;
    private final Map<k, Integer> mtb;
    private final boolean[] mtc;
    private final boolean mtd;
    private l.a mte;
    private a mtf;

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
        com.google.android.exoplayer2.util.a.checkArgument(rVar.bTt() == lVarArr.length);
        this.msY = lVarArr;
        this.mtd = z;
        this.msv = rVar;
        this.msZ = new x[lVarArr.length];
        this.mta = new Object[lVarArr.length];
        this.mtb = new HashMap();
        this.mtc = a(lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mte = aVar;
        if (this.msY.length == 0) {
            aVar.a(this, x.mbZ, null);
            return;
        }
        for (final int i = 0; i < this.msY.length; i++) {
            if (!this.mtc[i]) {
                this.msY[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.f.1
                    @Override // com.google.android.exoplayer2.source.l.a
                    public void a(l lVar, x xVar, Object obj) {
                        f.this.a(i, xVar, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwK() throws IOException {
        for (int i = 0; i < this.msY.length; i++) {
            if (!this.mtc[i]) {
                this.msY[i].dwK();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int KE = this.mtf.KE(bVar.periodIndex);
        k a2 = this.msY[KE].a(bVar.KL(bVar.periodIndex - this.mtf.KH(KE)), bVar2);
        this.mtb.put(a2, Integer.valueOf(KE));
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        int intValue = this.mtb.get(kVar).intValue();
        this.mtb.remove(kVar);
        this.msY[intValue].e(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (int i = 0; i < this.msY.length; i++) {
            if (!this.mtc[i]) {
                this.msY[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        this.msZ[i] = xVar;
        this.mta[i] = obj;
        for (int i2 = i + 1; i2 < this.msY.length; i2++) {
            if (this.msY[i2] == this.msY[i]) {
                this.msZ[i2] = xVar;
                this.mta[i2] = obj;
            }
        }
        for (x xVar2 : this.msZ) {
            if (xVar2 == null) {
                return;
            }
        }
        this.mtf = new a((x[]) this.msZ.clone(), this.mtd, this.msv);
        this.mte.a(this, this.mtf, this.mta.clone());
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
        private final x[] msZ;
        private final boolean mtd;
        private final int[] mth;
        private final int[] mti;

        public a(x[] xVarArr, boolean z, r rVar) {
            super(rVar);
            int[] iArr = new int[xVarArr.length];
            int[] iArr2 = new int[xVarArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < xVarArr.length; i2++) {
                x xVar = xVarArr[i2];
                j += xVar.dua();
                com.google.android.exoplayer2.util.a.d(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += xVar.dtZ();
                iArr2[i2] = i;
            }
            this.msZ = xVarArr;
            this.mth = iArr;
            this.mti = iArr2;
            this.mtd = z;
        }

        @Override // com.google.android.exoplayer2.x
        public int dtZ() {
            return this.mti[this.mti.length - 1];
        }

        @Override // com.google.android.exoplayer2.x
        public int dua() {
            return this.mth[this.mth.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int p(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mtd && i2 == 1) {
                i2 = 2;
            }
            return super.p(i, i2, (this.mtd || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int q(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mtd && i2 == 1) {
                i2 = 2;
            }
            return super.q(i, i2, (this.mtd || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vK(boolean z) {
            return super.vK(!this.mtd && z);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vL(boolean z) {
            return super.vL(!this.mtd && z);
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KE(int i) {
            return v.a(this.mth, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KF(int i) {
            return v.a(this.mti, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int by(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected x KG(int i) {
            return this.msZ[i];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KH(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mth[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KI(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mti[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected Object KJ(int i) {
            return Integer.valueOf(i);
        }
    }
}
