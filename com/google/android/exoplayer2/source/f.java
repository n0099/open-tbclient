package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class f implements l {
    private final l[] mmE;
    private final x[] mmF;
    private final Object[] mmG;
    private final Map<k, Integer> mmH;
    private final boolean[] mmI;
    private final boolean mmJ;
    private l.a mmK;
    private a mmL;
    private final r mmb;

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
        com.google.android.exoplayer2.util.a.checkArgument(rVar.bQo() == lVarArr.length);
        this.mmE = lVarArr;
        this.mmJ = z;
        this.mmb = rVar;
        this.mmF = new x[lVarArr.length];
        this.mmG = new Object[lVarArr.length];
        this.mmH = new HashMap();
        this.mmI = a(lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mmK = aVar;
        if (this.mmE.length == 0) {
            aVar.a(this, x.lVD, null);
            return;
        }
        for (final int i = 0; i < this.mmE.length; i++) {
            if (!this.mmI[i]) {
                this.mmE[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.f.1
                    @Override // com.google.android.exoplayer2.source.l.a
                    public void a(l lVar, x xVar, Object obj) {
                        f.this.a(i, xVar, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dtN() throws IOException {
        for (int i = 0; i < this.mmE.length; i++) {
            if (!this.mmI[i]) {
                this.mmE[i].dtN();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int Kk = this.mmL.Kk(bVar.periodIndex);
        k a2 = this.mmE[Kk].a(bVar.Kr(bVar.periodIndex - this.mmL.Kn(Kk)), bVar2);
        this.mmH.put(a2, Integer.valueOf(Kk));
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        int intValue = this.mmH.get(kVar).intValue();
        this.mmH.remove(kVar);
        this.mmE[intValue].e(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (int i = 0; i < this.mmE.length; i++) {
            if (!this.mmI[i]) {
                this.mmE[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        this.mmF[i] = xVar;
        this.mmG[i] = obj;
        for (int i2 = i + 1; i2 < this.mmE.length; i2++) {
            if (this.mmE[i2] == this.mmE[i]) {
                this.mmF[i2] = xVar;
                this.mmG[i2] = obj;
            }
        }
        for (x xVar2 : this.mmF) {
            if (xVar2 == null) {
                return;
            }
        }
        this.mmL = new a((x[]) this.mmF.clone(), this.mmJ, this.mmb);
        this.mmK.a(this, this.mmL, this.mmG.clone());
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
    /* loaded from: classes4.dex */
    public static final class a extends com.google.android.exoplayer2.source.a {
        private final x[] mmF;
        private final boolean mmJ;
        private final int[] mmN;
        private final int[] mmO;

        public a(x[] xVarArr, boolean z, r rVar) {
            super(rVar);
            int[] iArr = new int[xVarArr.length];
            int[] iArr2 = new int[xVarArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < xVarArr.length; i2++) {
                x xVar = xVarArr[i2];
                j += xVar.dra();
                com.google.android.exoplayer2.util.a.d(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += xVar.dqZ();
                iArr2[i2] = i;
            }
            this.mmF = xVarArr;
            this.mmN = iArr;
            this.mmO = iArr2;
            this.mmJ = z;
        }

        @Override // com.google.android.exoplayer2.x
        public int dqZ() {
            return this.mmO[this.mmO.length - 1];
        }

        @Override // com.google.android.exoplayer2.x
        public int dra() {
            return this.mmN[this.mmN.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int p(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mmJ && i2 == 1) {
                i2 = 2;
            }
            return super.p(i, i2, (this.mmJ || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int q(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mmJ && i2 == 1) {
                i2 = 2;
            }
            return super.q(i, i2, (this.mmJ || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vn(boolean z) {
            return super.vn(!this.mmJ && z);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vo(boolean z) {
            return super.vo(!this.mmJ && z);
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kk(int i) {
            return v.a(this.mmN, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kl(int i) {
            return v.a(this.mmO, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int bv(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected x Km(int i) {
            return this.mmF[i];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kn(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mmN[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Ko(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mmO[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected Object Kp(int i) {
            return Integer.valueOf(i);
        }
    }
}
