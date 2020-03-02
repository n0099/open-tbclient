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
/* loaded from: classes6.dex */
final class b implements k, q.a<com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a>> {
    final int id;
    private final u lYG;
    private k.a mqV;
    private final int mrr;
    private final com.google.android.exoplayer2.upstream.b mru;
    private final b.a mtB;
    private final a.InterfaceC0679a mtR;
    private final long mtS;
    private final o mtT;
    private final a[] mtU;
    private com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a>[] mtV = KU(0);
    private com.google.android.exoplayer2.source.e mtW = new com.google.android.exoplayer2.source.e(this.mtV);
    private com.google.android.exoplayer2.source.dash.manifest.b mtX;
    private int periodIndex;

    public b(int i, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i2, a.InterfaceC0679a interfaceC0679a, int i3, b.a aVar, long j, o oVar, com.google.android.exoplayer2.upstream.b bVar2) {
        this.id = i;
        this.mtX = bVar;
        this.periodIndex = i2;
        this.mtR = interfaceC0679a;
        this.mrr = i3;
        this.mtB = aVar;
        this.mtS = j;
        this.mtT = oVar;
        this.mru = bVar2;
        Pair<u, a[]> fc = fc(bVar.KZ(i2).mvc);
        this.lYG = (u) fc.first;
        this.mtU = (a[]) fc.second;
    }

    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        this.mtX = bVar;
        this.periodIndex = i;
        if (this.mtV != null) {
            for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mtV) {
                fVar.dwO().a(bVar, i);
            }
            this.mqV.a((k.a) this);
        }
    }

    public void release() {
        for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mtV) {
            fVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqV = aVar;
        aVar.a((k) this);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwe() throws IOException {
        this.mtT.dwl();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwf() {
        return this.lYG;
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
                    hashMap.put(Integer.valueOf(this.lYG.a(fVarArr[i].dxf())), fVar);
                }
            }
            if (pVarArr[i] == null && fVarArr[i] != null) {
                int a2 = this.lYG.a(fVarArr[i].dxf());
                a aVar = this.mtU[a2];
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
                a aVar2 = this.mtU[this.lYG.a(fVarArr[i2].dxf())];
                if (!aVar2.isPrimary) {
                    com.google.android.exoplayer2.source.a.f fVar2 = (com.google.android.exoplayer2.source.a.f) hashMap.get(Integer.valueOf(aVar2.mtZ));
                    p pVar = pVarArr[i2];
                    if (fVar2 == null) {
                        z = pVar instanceof g;
                    } else {
                        z = (pVar instanceof f.a) && ((f.a) pVar).mtJ == fVar2;
                    }
                    if (!z) {
                        a(pVar);
                        pVarArr[i2] = fVar2 == null ? new g() : fVar2.C(j, aVar2.lXY);
                        zArr2[i2] = true;
                    }
                }
            }
        }
        this.mtV = KU(hashMap.size());
        hashMap.values().toArray(this.mtV);
        this.mtW = new com.google.android.exoplayer2.source.e(this.mtV);
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mtV) {
            fVar.gm(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.mtW.gd(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        return this.mtW.dwi();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwg() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwh() {
        return this.mtW.dwh();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        for (com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar : this.mtV) {
            fVar.gn(j);
        }
        return j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a> fVar) {
        this.mqV.a((k.a) this);
    }

    private static Pair<u, a[]> fc(List<com.google.android.exoplayer2.source.dash.manifest.a> list) {
        int i;
        int i2;
        int[][] fd = fd(list);
        int length = fd.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        int i3 = length;
        for (int i4 = 0; i4 < length; i4++) {
            if (a(list, fd[i4])) {
                zArr[i4] = true;
                i3++;
            }
            if (b(list, fd[i4])) {
                zArr2[i4] = true;
                i3++;
            }
        }
        t[] tVarArr = new t[i3];
        a[] aVarArr = new a[i3];
        int i5 = 0;
        int i6 = 0;
        while (i6 < length) {
            int[] iArr = fd[i6];
            ArrayList arrayList = new ArrayList();
            for (int i7 : iArr) {
                arrayList.addAll(list.get(i7).muG);
            }
            Format[] formatArr = new Format[arrayList.size()];
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= formatArr.length) {
                    break;
                }
                formatArr[i9] = ((com.google.android.exoplayer2.source.dash.manifest.g) arrayList.get(i9)).lZy;
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

    private static int[][] fd(List<com.google.android.exoplayer2.source.dash.manifest.a> list) {
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
                com.google.android.exoplayer2.source.dash.manifest.d fe = fe(list.get(i3).muI);
                if (fe == null) {
                    i = i4 + 1;
                    int[] iArr2 = new int[1];
                    iArr2[0] = i3;
                    iArr[i4] = iArr2;
                } else {
                    String[] split = fe.value.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        boolean z = aVar.mua;
        if (!z) {
            i = 0;
        } else {
            i = 1;
            iArr[0] = 4;
        }
        boolean z2 = aVar.mub;
        if (z2) {
            iArr[i] = 3;
            i++;
        }
        return new com.google.android.exoplayer2.source.a.f<>(aVar.lXY, i < iArr.length ? Arrays.copyOf(iArr, i) : iArr, this.mtR.a(this.mtT, this.mtX, this.periodIndex, aVar.mtY, fVar, aVar.lXY, this.mtS, z, z2), this, this.mru, j, this.mrr, this.mtB);
    }

    private static com.google.android.exoplayer2.source.dash.manifest.d fe(List<com.google.android.exoplayer2.source.dash.manifest.d> list) {
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
            List<com.google.android.exoplayer2.source.dash.manifest.g> list2 = list.get(i).muG;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (!list2.get(i2).mvg.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b(List<com.google.android.exoplayer2.source.dash.manifest.a> list, int[] iArr) {
        for (int i : iArr) {
            List<com.google.android.exoplayer2.source.dash.manifest.d> list2 = list.get(i).muH;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if ("urn:scte:dash:cc:cea-608:2015".equals(list2.get(i2).schemeIdUri)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static com.google.android.exoplayer2.source.a.f<com.google.android.exoplayer2.source.dash.a>[] KU(int i) {
        return new com.google.android.exoplayer2.source.a.f[i];
    }

    private static void a(p pVar) {
        if (pVar instanceof f.a) {
            ((f.a) pVar).release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final boolean isPrimary;
        public final int lXY;
        public final int[] mtY;
        public final int mtZ;
        public final boolean mua;
        public final boolean mub;

        public a(int i, int[] iArr, int i2, boolean z, boolean z2, boolean z3) {
            this.lXY = i;
            this.mtY = iArr;
            this.mtZ = i2;
            this.isPrimary = z;
            this.mua = z2;
            this.mub = z3;
        }
    }
}
