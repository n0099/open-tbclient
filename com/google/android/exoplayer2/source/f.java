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
    private final r mqB;
    private final l[] mre;
    private final x[] mrf;
    private final Object[] mrg;
    private final Map<k, Integer> mrh;
    private final boolean[] mri;
    private final boolean mrj;
    private l.a mrk;
    private a mrl;

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
        com.google.android.exoplayer2.util.a.checkArgument(rVar.bSY() == lVarArr.length);
        this.mre = lVarArr;
        this.mrj = z;
        this.mqB = rVar;
        this.mrf = new x[lVarArr.length];
        this.mrg = new Object[lVarArr.length];
        this.mrh = new HashMap();
        this.mri = a(lVarArr);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        this.mrk = aVar;
        if (this.mre.length == 0) {
            aVar.a(this, x.mae, null);
            return;
        }
        for (final int i = 0; i < this.mre.length; i++) {
            if (!this.mri[i]) {
                this.mre[i].a(gVar, false, new l.a() { // from class: com.google.android.exoplayer2.source.f.1
                    @Override // com.google.android.exoplayer2.source.l.a
                    public void a(l lVar, x xVar, Object obj) {
                        f.this.a(i, xVar, obj);
                    }
                });
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwk() throws IOException {
        for (int i = 0; i < this.mre.length; i++) {
            if (!this.mri[i]) {
                this.mre[i].dwk();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int Ky = this.mrl.Ky(bVar.periodIndex);
        k a2 = this.mre[Ky].a(bVar.KF(bVar.periodIndex - this.mrl.KB(Ky)), bVar2);
        this.mrh.put(a2, Integer.valueOf(Ky));
        return a2;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        int intValue = this.mrh.get(kVar).intValue();
        this.mrh.remove(kVar);
        this.mre[intValue].e(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        for (int i = 0; i < this.mre.length; i++) {
            if (!this.mri[i]) {
                this.mre[i].releaseSource();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, x xVar, Object obj) {
        this.mrf[i] = xVar;
        this.mrg[i] = obj;
        for (int i2 = i + 1; i2 < this.mre.length; i2++) {
            if (this.mre[i2] == this.mre[i]) {
                this.mrf[i2] = xVar;
                this.mrg[i2] = obj;
            }
        }
        for (x xVar2 : this.mrf) {
            if (xVar2 == null) {
                return;
            }
        }
        this.mrl = new a((x[]) this.mrf.clone(), this.mrj, this.mqB);
        this.mrk.a(this, this.mrl, this.mrg.clone());
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
        private final x[] mrf;
        private final boolean mrj;
        private final int[] mrn;
        private final int[] mro;

        public a(x[] xVarArr, boolean z, r rVar) {
            super(rVar);
            int[] iArr = new int[xVarArr.length];
            int[] iArr2 = new int[xVarArr.length];
            long j = 0;
            int i = 0;
            for (int i2 = 0; i2 < xVarArr.length; i2++) {
                x xVar = xVarArr[i2];
                j += xVar.dtA();
                com.google.android.exoplayer2.util.a.d(j <= 2147483647L, "ConcatenatingMediaSource children contain too many periods");
                iArr[i2] = (int) j;
                i += xVar.dtz();
                iArr2[i2] = i;
            }
            this.mrf = xVarArr;
            this.mrn = iArr;
            this.mro = iArr2;
            this.mrj = z;
        }

        @Override // com.google.android.exoplayer2.x
        public int dtz() {
            return this.mro[this.mro.length - 1];
        }

        @Override // com.google.android.exoplayer2.x
        public int dtA() {
            return this.mrn[this.mrn.length - 1];
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int p(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mrj && i2 == 1) {
                i2 = 2;
            }
            return super.p(i, i2, (this.mrj || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int q(int i, int i2, boolean z) {
            boolean z2 = true;
            if (this.mrj && i2 == 1) {
                i2 = 2;
            }
            return super.q(i, i2, (this.mrj || !z) ? false : false);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vD(boolean z) {
            return super.vD(!this.mrj && z);
        }

        @Override // com.google.android.exoplayer2.source.a, com.google.android.exoplayer2.x
        public int vE(boolean z) {
            return super.vE(!this.mrj && z);
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Ky(int i) {
            return v.a(this.mrn, i + 1, false, false) + 1;
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int Kz(int i) {
            return v.a(this.mro, i + 1, false, false) + 1;
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
            return this.mrf[i];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KB(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mrn[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected int KC(int i) {
            if (i == 0) {
                return 0;
            }
            return this.mro[i - 1];
        }

        @Override // com.google.android.exoplayer2.source.a
        protected Object KD(int i) {
            return Integer.valueOf(i);
        }
    }
}
