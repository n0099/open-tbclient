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
    private final r mpV;
    private final Object[] mqA;
    private final Map<k, Integer> mqB;
    private final boolean[] mqC;
    private final boolean mqD;
    private l.a mqE;
    private a mqF;
    private final l[] mqy;
    private final x[] mqz;

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
        this.mqy = lVarArr;
        this.mqD = z;
        this.mpV = rVar;
        this.mqz = new x[lVarArr.length];
        this.mqA = new Object[lVarArr.length];
        this.mqB = new HashMap();
        this.mqC = a(lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mqE = aVar;
        if (this.mqy.length == 0) {
            aVar.a(this, x.lZx, null);
            return;
        }
        for (final int i = 0; i < this.mqy.length; i++) {
            if (!this.mqC[i]) {
                this.mqy[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.f.1
                    @Override // com.google.android.exoplayer2.source.l.a
                    public void a(l lVar, x xVar, Object obj) {
                        f.this.a(i, xVar, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dva() throws IOException {
        for (int i = 0; i < this.mqy.length; i++) {
            if (!this.mqC[i]) {
                this.mqy[i].dva();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int Kt = this.mqF.Kt(bVar.periodIndex);
        k a2 = this.mqy[Kt].a(bVar.KA(bVar.periodIndex - this.mqF.Kw(Kt)), bVar2);
        this.mqB.put(a2, Integer.valueOf(Kt));
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        int intValue = this.mqB.get(kVar).intValue();
        this.mqB.remove(kVar);
        this.mqy[intValue].e(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (int i = 0; i < this.mqy.length; i++) {
            if (!this.mqC[i]) {
                this.mqy[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        this.mqz[i] = xVar;
        this.mqA[i] = obj;
        for (int i2 = i + 1; i2 < this.mqy.length; i2++) {
            if (this.mqy[i2] == this.mqy[i]) {
                this.mqz[i2] = xVar;
                this.mqA[i2] = obj;
            }
        }
        for (x xVar2 : this.mqz) {
            if (xVar2 == null) {
                return;
            }
        }
        this.mqF = new a((x[]) this.mqz.clone(), this.mqD, this.mpV);
        this.mqE.a(this, this.mqF, this.mqA.clone());
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
        private final boolean mqD;
        private final int[] mqH;
        private final int[] mqI;
        private final x[] mqz;

        public a(x[] xVarArr, boolean z, r rVar) {
            super(rVar);
            int[] iArr = new int[xVarArr.length];
            int[] iArr2 = new int[xVarArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < xVarArr.length; i2++) {
                x xVar = xVarArr[i2];
                j += xVar.dso();
                com.google.android.exoplayer2.util.a.d(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += xVar.dsn();
                iArr2[i2] = i;
            }
            this.mqz = xVarArr;
            this.mqH = iArr;
            this.mqI = iArr2;
            this.mqD = z;
        }

        @Override // com.google.android.exoplayer2.x
        public int dsn() {
            return this.mqI[this.mqI.length - 1];
        }

        @Override // com.google.android.exoplayer2.x
        public int dso() {
            return this.mqH[this.mqH.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int p(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mqD && i2 == 1) {
                i2 = 2;
            }
            return super.p(i, i2, (this.mqD || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int q(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mqD && i2 == 1) {
                i2 = 2;
            }
            return super.q(i, i2, (this.mqD || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vz(boolean z) {
            return super.vz(!this.mqD && z);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vA(boolean z) {
            return super.vA(!this.mqD && z);
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kt(int i) {
            return v.a(this.mqH, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Ku(int i) {
            return v.a(this.mqI, i + 1, false, false) + 1;
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
            return this.mqz[i];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kw(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mqH[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kx(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mqI[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected Object Ky(int i) {
            return Integer.valueOf(i);
        }
    }
}
