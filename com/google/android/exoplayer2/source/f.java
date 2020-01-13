package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class f implements l {
    private final r mpQ;
    private a mqA;
    private final l[] mqt;
    private final x[] mqu;
    private final Object[] mqv;
    private final Map<k, Integer> mqw;
    private final boolean[] mqx;
    private final boolean mqy;
    private l.a mqz;

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
        com.google.android.exoplayer2.util.a.checkArgument(rVar.bRx() == lVarArr.length);
        this.mqt = lVarArr;
        this.mqy = z;
        this.mpQ = rVar;
        this.mqu = new x[lVarArr.length];
        this.mqv = new Object[lVarArr.length];
        this.mqw = new HashMap();
        this.mqx = a(lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mqz = aVar;
        if (this.mqt.length == 0) {
            aVar.a(this, x.lZs, null);
            return;
        }
        for (final int i = 0; i < this.mqt.length; i++) {
            if (!this.mqx[i]) {
                this.mqt[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.f.1
                    @Override // com.google.android.exoplayer2.source.l.a
                    public void a(l lVar, x xVar, Object obj) {
                        f.this.a(i, xVar, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void duY() throws IOException {
        for (int i = 0; i < this.mqt.length; i++) {
            if (!this.mqx[i]) {
                this.mqt[i].duY();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int Kt = this.mqA.Kt(bVar.periodIndex);
        k a2 = this.mqt[Kt].a(bVar.KA(bVar.periodIndex - this.mqA.Kw(Kt)), bVar2);
        this.mqw.put(a2, Integer.valueOf(Kt));
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        int intValue = this.mqw.get(kVar).intValue();
        this.mqw.remove(kVar);
        this.mqt[intValue].e(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (int i = 0; i < this.mqt.length; i++) {
            if (!this.mqx[i]) {
                this.mqt[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        this.mqu[i] = xVar;
        this.mqv[i] = obj;
        for (int i2 = i + 1; i2 < this.mqt.length; i2++) {
            if (this.mqt[i2] == this.mqt[i]) {
                this.mqu[i2] = xVar;
                this.mqv[i2] = obj;
            }
        }
        for (x xVar2 : this.mqu) {
            if (xVar2 == null) {
                return;
            }
        }
        this.mqA = new a((x[]) this.mqu.clone(), this.mqy, this.mpQ);
        this.mqz.a(this, this.mqA, this.mqv.clone());
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
    /* loaded from: classes5.dex */
    public static final class a extends com.google.android.exoplayer2.source.a {
        private final int[] mqC;
        private final int[] mqD;
        private final x[] mqu;
        private final boolean mqy;

        public a(x[] xVarArr, boolean z, r rVar) {
            super(rVar);
            int[] iArr = new int[xVarArr.length];
            int[] iArr2 = new int[xVarArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < xVarArr.length; i2++) {
                x xVar = xVarArr[i2];
                j += xVar.dsm();
                com.google.android.exoplayer2.util.a.d(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += xVar.dsl();
                iArr2[i2] = i;
            }
            this.mqu = xVarArr;
            this.mqC = iArr;
            this.mqD = iArr2;
            this.mqy = z;
        }

        @Override // com.google.android.exoplayer2.x
        public int dsl() {
            return this.mqD[this.mqD.length - 1];
        }

        @Override // com.google.android.exoplayer2.x
        public int dsm() {
            return this.mqC[this.mqC.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int p(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mqy && i2 == 1) {
                i2 = 2;
            }
            return super.p(i, i2, (this.mqy || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int q(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mqy && i2 == 1) {
                i2 = 2;
            }
            return super.q(i, i2, (this.mqy || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vz(boolean z) {
            return super.vz(!this.mqy && z);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vA(boolean z) {
            return super.vA(!this.mqy && z);
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kt(int i) {
            return v.a(this.mqC, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Ku(int i) {
            return v.a(this.mqD, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int bw(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected x Kv(int i) {
            return this.mqu[i];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kw(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mqC[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kx(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mqD[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected Object Ky(int i) {
            return Integer.valueOf(i);
        }
    }
}
