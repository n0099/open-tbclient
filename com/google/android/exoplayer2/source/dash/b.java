package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.a.f;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.o;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
final class b implements k, q.a<com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a>> {
    final int id;
    private final u lXT;
    private final int mqE;
    private final com.google.android.exoplayer2.upstream.b mqH;
    private k.a mqi;
    private final b.a msN;
    private final a.InterfaceC0671a mtd;
    private final long mte;
    private final o mtf;
    private final a[] mtg;
    private com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a>[] mth = KP(0);
    private com.google.android.exoplayer2.source.e mti = new com.google.android.exoplayer2.source.e(this.mth);
    private com.google.android.exoplayer2.source.dash.manifest.b mtj;
    private int periodIndex;

    public b(int i, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i2, a.InterfaceC0671a interfaceC0671a, int i3, b.a aVar, long j, o oVar, com.google.android.exoplayer2.upstream.b bVar2) {
        this.id = i;
        this.mtj = bVar;
        this.periodIndex = i2;
        this.mtd = interfaceC0671a;
        this.mqE = i3;
        this.msN = aVar;
        this.mte = j;
        this.mtf = oVar;
        this.mqH = bVar2;
        Pair<u, a[]> fh = fh(bVar.KU(i2).mup);
        this.lXT = (u) fh.first;
        this.mtg = (a[]) fh.second;
    }

    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        this.mtj = bVar;
        this.periodIndex = i;
        if (this.mth != null) {
            for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mth) {
                fVar.dvA().a(bVar, i);
            }
            this.mqi.a((k.a) this);
        }
    }

    public void release() {
        for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mth) {
            fVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqi = aVar;
        aVar.a((k) this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duQ() throws IOException {
        this.mtf.duX();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duR() {
        return this.lXT;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        boolean z;
        HashMap hashMap = new HashMap();
        for (int i = 0; i < fVarArr.length; i++) {
            if (pVarArr[i] instanceof com.google.android.exoplayer2.source.a.f) {
                com.google.android.exoplayer2.source.a.f fVar = (com.google.android.exoplayer2.source.a.f) pVarArr[i];
                if (fVarArr[i] == null || !zArr[i]) {
                    fVar.release();
                    pVarArr[i] = null;
                } else {
                    hashMap.put(Integer.valueOf(this.lXT.a(fVarArr[i].dvR())), fVar);
                }
            }
            if (pVarArr[i] == null && fVarArr[i] != null) {
                int a2 = this.lXT.a(fVarArr[i].dvR());
                a aVar = this.mtg[a2];
                if (aVar.isPrimary) {
                    com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> a3 = a(aVar, fVarArr[i], j);
                    hashMap.put(Integer.valueOf(a2), a3);
                    pVarArr[i] = a3;
                    zArr2[i] = true;
                }
            }
        }
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            if (((pVarArr[i2] instanceof f.a) || (pVarArr[i2] instanceof g)) && (fVarArr[i2] == null || !zArr[i2])) {
                a(pVarArr[i2]);
                pVarArr[i2] = null;
            }
            if (fVarArr[i2] != null) {
                a aVar2 = this.mtg[this.lXT.a(fVarArr[i2].dvR())];
                if (!aVar2.isPrimary) {
                    com.google.android.exoplayer2.source.a.f fVar2 = (com.google.android.exoplayer2.source.a.f) hashMap.get(Integer.valueOf(aVar2.mtl));
                    p pVar = pVarArr[i2];
                    if (fVar2 == null) {
                        z = pVar instanceof g;
                    } else {
                        z = (pVar instanceof f.a) && ((f.a) pVar).msV == fVar2;
                    }
                    if (!z) {
                        a(pVar);
                        pVarArr[i2] = fVar2 == null ? new g() : fVar2.C(j, aVar2.lXl);
                        zArr2[i2] = true;
                    }
                }
            }
        }
        this.mth = KP(hashMap.size());
        hashMap.values().toArray(this.mth);
        this.mti = new com.google.android.exoplayer2.source.e(this.mth);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mth) {
            fVar.go(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.mti.gf(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duU() {
        return this.mti.duU();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duS() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duT() {
        return this.mti.duT();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mth) {
            fVar.gp(j);
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar) {
        this.mqi.a((k.a) this);
    }

    private static Pair<u, a[]> fh(List<com.google.android.exoplayer2.source.dash.manifest.a> list) {
        int i;
        int i2;
        int[][] fi = fi(list);
        int length = fi.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        int i3 = length;
        for (int i4 = 0; i4 < length; i4++) {
            if (a(list, fi[i4])) {
                zArr[i4] = true;
                i3++;
            }
            if (b(list, fi[i4])) {
                zArr2[i4] = true;
                i3++;
            }
        }
        t[] tVarArr = new t[i3];
        a[] aVarArr = new a[i3];
        int i5 = 0;
        int i6 = 0;
        while (i6 < length) {
            int[] iArr = fi[i6];
            ArrayList arrayList = new ArrayList();
            for (int i7 : iArr) {
                arrayList.addAll(list.get(i7).mtT);
            }
            Format[] formatArr = new Format[arrayList.size()];
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= formatArr.length) {
                    break;
                }
                formatArr[i9] = ((com.google.android.exoplayer2.source.dash.manifest.g) arrayList.get(i9)).lYL;
                i8 = i9 + 1;
            }
            com.google.android.exoplayer2.source.dash.manifest.a aVar = list.get(iArr[0]);
            boolean z = zArr[i6];
            boolean z2 = zArr2[i6];
            tVarArr[i5] = new t(formatArr);
            int i10 = i5 + 1;
            aVarArr[i5] = new a(aVar.type, iArr, i5, true, z, z2);
            if (z) {
                tVarArr[i10] = new t(Format.a(aVar.id + ":emsg", "application/x-emsg", (String) null, -1, (DrmInitData) null));
                aVarArr[i10] = new a(4, iArr, i5, false, false, false);
                i = i10 + 1;
            } else {
                i = i10;
            }
            if (z2) {
                tVarArr[i] = new t(Format.a(aVar.id + ":cea608", "application/cea-608", 0, null));
                aVarArr[i] = new a(3, iArr, i5, false, false, false);
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i6++;
            i5 = i2;
        }
        return Pair.create(new u(tVarArr), aVarArr);
    }

    private static int[][] fi(List<com.google.android.exoplayer2.source.dash.manifest.a> list) {
        int i;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            sparseIntArray.put(list.get(i2).id, i2);
        }
        int[][] iArr = new int[size];
        boolean[] zArr = new boolean[size];
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (zArr[i3]) {
                i = i4;
            } else {
                zArr[i3] = true;
                com.google.android.exoplayer2.source.dash.manifest.d fj = fj(list.get(i3).mtV);
                if (fj == null) {
                    i = i4 + 1;
                    int[] iArr2 = new int[1];
                    iArr2[0] = i3;
                    iArr[i4] = iArr2;
                } else {
                    String[] split = fj.value.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    int[] iArr3 = new int[split.length + 1];
                    iArr3[0] = i3;
                    for (int i5 = 0; i5 < split.length; i5++) {
                        int i6 = sparseIntArray.get(Integer.parseInt(split[i5]));
                        zArr[i6] = true;
                        iArr3[i5 + 1] = i6;
                    }
                    i = i4 + 1;
                    iArr[i4] = iArr3;
                }
            }
            i3++;
            i4 = i;
        }
        return i4 < size ? (int[][]) Arrays.copyOf(iArr, i4) : iArr;
    }

    private com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> a(a aVar, com.google.android.exoplayer2.b.f fVar, long j) {
        int i;
        int[] iArr = new int[2];
        boolean z = aVar.mtm;
        if (!z) {
            i = 0;
        } else {
            i = 1;
            iArr[0] = 4;
        }
        boolean z2 = aVar.mtn;
        if (z2) {
            iArr[i] = 3;
            i++;
        }
        return new com.google.android.exoplayer2.source.a.f<>(aVar.lXl, i < iArr.length ? Arrays.copyOf(iArr, i) : iArr, this.mtd.a(this.mtf, this.mtj, this.periodIndex, aVar.mtk, fVar, aVar.lXl, this.mte, z, z2), this, this.mqH, j, this.mqE, this.msN);
    }

    private static com.google.android.exoplayer2.source.dash.manifest.d fj(List<com.google.android.exoplayer2.source.dash.manifest.d> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                com.google.android.exoplayer2.source.dash.manifest.d dVar = list.get(i2);
                if (!"urn:mpeg:dash:adaptation-set-switching:2016".equals(dVar.schemeIdUri)) {
                    i = i2 + 1;
                } else {
                    return dVar;
                }
            } else {
                return null;
            }
        }
    }

    private static boolean a(List<com.google.android.exoplayer2.source.dash.manifest.a> list, int[] iArr) {
        for (int i : iArr) {
            List<com.google.android.exoplayer2.source.dash.manifest.g> list2 = list.get(i).mtT;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).mut.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b(List<com.google.android.exoplayer2.source.dash.manifest.a> list, int[] iArr) {
        for (int i : iArr) {
            List<com.google.android.exoplayer2.source.dash.manifest.d> list2 = list.get(i).mtU;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i2).schemeIdUri)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a>[] KP(int i) {
        return new com.google.android.exoplayer2.source.a.f[i];
    }

    private static void a(p pVar) {
        if (pVar instanceof f.a) {
            ((f.a) pVar).release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final boolean isPrimary;
        public final int lXl;
        public final int[] mtk;
        public final int mtl;
        public final boolean mtm;
        public final boolean mtn;

        public a(int i, int[] iArr, int i2, boolean z, boolean z2, boolean z3) {
            this.lXl = i;
            this.mtk = iArr;
            this.mtl = i2;
            this.isPrimary = z;
            this.mtm = z2;
            this.mtn = z3;
        }
    }
}
