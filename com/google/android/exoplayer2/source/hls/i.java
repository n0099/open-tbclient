package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.text.TextUtils;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.hls.l;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes6.dex */
public final class i implements l.a, HlsPlaylistTracker.b, com.google.android.exoplayer2.source.k {
    private u maA;
    private int maV;
    private k.a msN;
    private final int mtj;
    private final com.google.android.exoplayer2.upstream.b mtm;
    private com.google.android.exoplayer2.source.e mvN;
    private final b.a mvs;
    private final f mxt;
    private final HlsPlaylistTracker mxy;
    private final e myc;
    private final IdentityHashMap<p, Integer> myd = new IdentityHashMap<>();
    private final m mxw = new m();
    private final Handler mye = new Handler();
    private l[] myf = new l[0];
    private l[] myg = new l[0];

    public i(f fVar, HlsPlaylistTracker hlsPlaylistTracker, e eVar, int i, b.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mxt = fVar;
        this.mxy = hlsPlaylistTracker;
        this.myc = eVar;
        this.mtj = i;
        this.mvs = aVar;
        this.mtm = bVar;
    }

    public void release() {
        this.mxy.b(this);
        this.mye.removeCallbacksAndMessages(null);
        for (l lVar : this.myf) {
            lVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.msN = aVar;
        this.mxy.a(this);
        gu(j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwC() throws IOException {
        for (l lVar : this.myf) {
            lVar.dwC();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwD() {
        return this.maA;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fVarArr.length) {
                break;
            }
            iArr[i2] = pVarArr[i2] == null ? -1 : this.myd.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dxD = fVarArr[i2].dxD();
                int i3 = 0;
                while (true) {
                    if (i3 < this.myf.length) {
                        if (this.myf[i3].dwD().a(dxD) == -1) {
                            i3++;
                        } else {
                            iArr2[i2] = i3;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            i = i2 + 1;
        }
        boolean z = false;
        this.myd.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        int i4 = 0;
        l[] lVarArr = new l[this.myf.length];
        int i5 = 0;
        while (true) {
            int i6 = i4;
            if (i5 < this.myf.length) {
                for (int i7 = 0; i7 < fVarArr.length; i7++) {
                    pVarArr3[i7] = iArr[i7] == i5 ? pVarArr[i7] : null;
                    fVarArr2[i7] = iArr2[i7] == i5 ? fVarArr[i7] : null;
                }
                l lVar = this.myf[i5];
                boolean a = lVar.a(fVarArr2, zArr, pVarArr3, zArr2, j, z);
                boolean z2 = false;
                for (int i8 = 0; i8 < fVarArr.length; i8++) {
                    if (iArr2[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] != null);
                        pVarArr2[i8] = pVarArr3[i8];
                        z2 = true;
                        this.myd.put(pVarArr3[i8], Integer.valueOf(i5));
                    } else if (iArr[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] == null);
                    }
                }
                if (z2) {
                    lVarArr[i6] = lVar;
                    int i9 = i6 + 1;
                    if (i6 == 0) {
                        lVar.vP(true);
                        if (a || this.myg.length == 0 || lVar != this.myg[0]) {
                            this.mxw.reset();
                            z = true;
                            i4 = i9;
                        }
                    } else {
                        lVar.vP(false);
                    }
                    i4 = i9;
                } else {
                    i4 = i6;
                }
                i5++;
            } else {
                System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
                this.myg = (l[]) Arrays.copyOf(lVarArr, i6);
                this.mvN = new com.google.android.exoplayer2.source.e(this.myg);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gc(long j) {
        for (l lVar : this.myg) {
            lVar.gc(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ge(long j) {
        return this.mvN.ge(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwG() {
        return this.mvN.dwG();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwE() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwF() {
        return this.mvN.dwF();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gd(long j) {
        if (this.myg.length > 0) {
            boolean s = this.myg[0].s(j, false);
            for (int i = 1; i < this.myg.length; i++) {
                this.myg[i].s(j, s);
            }
            if (s) {
                this.mxw.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void onPrepared() {
        int i = this.maV - 1;
        this.maV = i;
        if (i <= 0) {
            int i2 = 0;
            for (l lVar : this.myf) {
                i2 += lVar.dwD().length;
            }
            t[] tVarArr = new t[i2];
            l[] lVarArr = this.myf;
            int length = lVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                l lVar2 = lVarArr[i3];
                int i5 = lVar2.dwD().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = lVar2.dwD().KX(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.maA = new u(tVarArr);
            this.msN.a((com.google.android.exoplayer2.source.k) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void a(a.C0682a c0682a) {
        this.mxy.e(c0682a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(l lVar) {
        if (this.maA != null) {
            this.msN.a((k.a) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void dxM() {
        dxN();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void a(a.C0682a c0682a, long j) {
        for (l lVar : this.myf) {
            lVar.a(c0682a, j);
        }
        dxN();
    }

    private void gu(long j) {
        ArrayList arrayList;
        int i;
        com.google.android.exoplayer2.source.hls.playlist.a dxU = this.mxy.dxU();
        ArrayList arrayList2 = new ArrayList(dxU.myy);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList2.size()) {
                break;
            }
            a.C0682a c0682a = (a.C0682a) arrayList2.get(i3);
            if (c0682a.mbs.height > 0 || a(c0682a, "avc")) {
                arrayList3.add(c0682a);
            } else if (a(c0682a, AudioSampleEntry.TYPE3)) {
                arrayList4.add(c0682a);
            }
            i2 = i3 + 1;
        }
        if (arrayList3.isEmpty()) {
            if (arrayList4.size() < arrayList2.size()) {
                arrayList2.removeAll(arrayList4);
            }
            arrayList = arrayList2;
        } else {
            arrayList = arrayList3;
        }
        List<a.C0682a> list = dxU.audios;
        List<a.C0682a> list2 = dxU.myz;
        this.myf = new l[list.size() + 1 + list2.size()];
        this.maV = this.myf.length;
        com.google.android.exoplayer2.util.a.checkArgument(!arrayList.isEmpty());
        a.C0682a[] c0682aArr = new a.C0682a[arrayList.size()];
        arrayList.toArray(c0682aArr);
        l a = a(0, c0682aArr, dxU.myl, dxU.mxA, j);
        int i4 = 1;
        this.myf[0] = a;
        a.vP(true);
        a.dxO();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i = i4;
            if (i6 >= list.size()) {
                break;
            }
            l a2 = a(1, new a.C0682a[]{list.get(i6)}, (Format) null, Collections.emptyList(), j);
            i4 = i + 1;
            this.myf[i] = a2;
            a2.dxO();
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (i7 < list2.size()) {
            a.C0682a c0682a2 = list2.get(i7);
            l a3 = a(3, new a.C0682a[]{c0682a2}, (Format) null, Collections.emptyList(), j);
            a3.o(c0682a2.mbs);
            this.myf[i] = a3;
            i7++;
            i++;
        }
        this.myg = this.myf;
    }

    private l a(int i, a.C0682a[] c0682aArr, Format format, List<Format> list, long j) {
        return new l(i, this, new d(this.mxt, this.mxy, c0682aArr, this.myc, this.mxw, list), this.mtm, j, format, this.mtj, this.mvs);
    }

    private void dxN() {
        if (this.maA != null) {
            this.msN.a((k.a) this);
            return;
        }
        for (l lVar : this.myf) {
            lVar.dxO();
        }
    }

    private static boolean a(a.C0682a c0682a, String str) {
        String str2 = c0682a.mbs.codecs;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        String[] split = str2.split("(\\s*,\\s*)|(\\s*$)");
        for (String str3 : split) {
            if (str3.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
