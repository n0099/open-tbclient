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
    private final r mqO;
    private final l[] mrr;
    private final x[] mrs;
    private final Object[] mrt;
    private final Map<k, Integer> mru;
    private final boolean[] mrv;
    private final boolean mrw;
    private l.a mrx;
    private a mry;

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
        com.google.android.exoplayer2.util.a.checkArgument(rVar.bTb() == lVarArr.length);
        this.mrr = lVarArr;
        this.mrw = z;
        this.mqO = rVar;
        this.mrs = new x[lVarArr.length];
        this.mrt = new Object[lVarArr.length];
        this.mru = new HashMap();
        this.mrv = a(lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mrx = aVar;
        if (this.mrr.length == 0) {
            aVar.a(this, x.mas, null);
            return;
        }
        for (final int i = 0; i < this.mrr.length; i++) {
            if (!this.mrv[i]) {
                this.mrr[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.f.1
                    @Override // com.google.android.exoplayer2.source.l.a
                    public void a(l lVar, x xVar, Object obj) {
                        f.this.a(i, xVar, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwn() throws IOException {
        for (int i = 0; i < this.mrr.length; i++) {
            if (!this.mrv[i]) {
                this.mrr[i].dwn();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int Ky = this.mry.Ky(bVar.periodIndex);
        k a2 = this.mrr[Ky].a(bVar.KF(bVar.periodIndex - this.mry.KB(Ky)), bVar2);
        this.mru.put(a2, Integer.valueOf(Ky));
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        int intValue = this.mru.get(kVar).intValue();
        this.mru.remove(kVar);
        this.mrr[intValue].e(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (int i = 0; i < this.mrr.length; i++) {
            if (!this.mrv[i]) {
                this.mrr[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        this.mrs[i] = xVar;
        this.mrt[i] = obj;
        for (int i2 = i + 1; i2 < this.mrr.length; i2++) {
            if (this.mrr[i2] == this.mrr[i]) {
                this.mrs[i2] = xVar;
                this.mrt[i2] = obj;
            }
        }
        for (x xVar2 : this.mrs) {
            if (xVar2 == null) {
                return;
            }
        }
        this.mry = new a((x[]) this.mrs.clone(), this.mrw, this.mqO);
        this.mrx.a(this, this.mry, this.mrt.clone());
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
        private final int[] mrA;
        private final int[] mrB;
        private final x[] mrs;
        private final boolean mrw;

        public a(x[] xVarArr, boolean z, r rVar) {
            super(rVar);
            int[] iArr = new int[xVarArr.length];
            int[] iArr2 = new int[xVarArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < xVarArr.length; i2++) {
                x xVar = xVarArr[i2];
                j += xVar.dtD();
                com.google.android.exoplayer2.util.a.d(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += xVar.dtC();
                iArr2[i2] = i;
            }
            this.mrs = xVarArr;
            this.mrA = iArr;
            this.mrB = iArr2;
            this.mrw = z;
        }

        @Override // com.google.android.exoplayer2.x
        public int dtC() {
            return this.mrB[this.mrB.length - 1];
        }

        @Override // com.google.android.exoplayer2.x
        public int dtD() {
            return this.mrA[this.mrA.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int p(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mrw && i2 == 1) {
                i2 = 2;
            }
            return super.p(i, i2, (this.mrw || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int q(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mrw && i2 == 1) {
                i2 = 2;
            }
            return super.q(i, i2, (this.mrw || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vD(boolean z) {
            return super.vD(!this.mrw && z);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vE(boolean z) {
            return super.vE(!this.mrw && z);
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Ky(int i) {
            return v.a(this.mrA, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kz(int i) {
            return v.a(this.mrB, i + 1, false, false) + 1;
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
            return this.mrs[i];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KB(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mrA[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KC(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mrB[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected Object KD(int i) {
            return Integer.valueOf(i);
        }
    }
}
