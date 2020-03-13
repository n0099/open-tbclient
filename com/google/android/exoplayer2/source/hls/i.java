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
    private u lYR;
    private int lZm;
    private final int mrC;
    private final com.google.android.exoplayer2.upstream.b mrF;
    private k.a mrg;
    private final b.a mtM;
    private com.google.android.exoplayer2.source.e muh;
    private final f mvN;
    private final HlsPlaylistTracker mvS;
    private final e mww;
    private final IdentityHashMap<p, Integer> mwx = new IdentityHashMap<>();
    private final m mvQ = new m();
    private final Handler mwy = new Handler();
    private l[] mwz = new l[0];
    private l[] mwA = new l[0];

    public i(f fVar, HlsPlaylistTracker hlsPlaylistTracker, e eVar, int i, b.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mvN = fVar;
        this.mvS = hlsPlaylistTracker;
        this.mww = eVar;
        this.mrC = i;
        this.mtM = aVar;
        this.mrF = bVar;
    }

    public void release() {
        this.mvS.b(this);
        this.mwy.removeCallbacksAndMessages(null);
        for (l lVar : this.mwz) {
            lVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mrg = aVar;
        this.mvS.a(this);
        gt(j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwf() throws IOException {
        for (l lVar : this.mwz) {
            lVar.dwf();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwg() {
        return this.lYR;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mwx.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dxg = fVarArr[i2].dxg();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mwz.length) {
                        if (this.mwz[i3].dwg().a(dxg) == -1) {
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
        this.mwx.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        int i4 = 0;
        l[] lVarArr = new l[this.mwz.length];
        int i5 = 0;
        while (true) {
            int i6 = i4;
            if (i5 < this.mwz.length) {
                for (int i7 = 0; i7 < fVarArr.length; i7++) {
                    pVarArr3[i7] = iArr[i7] == i5 ? pVarArr[i7] : null;
                    fVarArr2[i7] = iArr2[i7] == i5 ? fVarArr[i7] : null;
                }
                l lVar = this.mwz[i5];
                boolean a = lVar.a(fVarArr2, zArr, pVarArr3, zArr2, j, z);
                boolean z2 = false;
                for (int i8 = 0; i8 < fVarArr.length; i8++) {
                    if (iArr2[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] != null);
                        pVarArr2[i8] = pVarArr3[i8];
                        z2 = true;
                        this.mwx.put(pVarArr3[i8], Integer.valueOf(i5));
                    } else if (iArr[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] == null);
                    }
                }
                if (z2) {
                    lVarArr[i6] = lVar;
                    int i9 = i6 + 1;
                    if (i6 == 0) {
                        lVar.vI(true);
                        if (a || this.mwA.length == 0 || lVar != this.mwA[0]) {
                            this.mvQ.reset();
                            z = true;
                            i4 = i9;
                        }
                    } else {
                        lVar.vI(false);
                    }
                    i4 = i9;
                } else {
                    i4 = i6;
                }
                i5++;
            } else {
                System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
                this.mwA = (l[]) Arrays.copyOf(lVarArr, i6);
                this.muh = new com.google.android.exoplayer2.source.e(this.mwA);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        for (l lVar : this.mwA) {
            lVar.gb(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.muh.gd(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwj() {
        return this.muh.dwj();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwh() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        return this.muh.dwi();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        if (this.mwA.length > 0) {
            boolean r = this.mwA[0].r(j, false);
            for (int i = 1; i < this.mwA.length; i++) {
                this.mwA[i].r(j, r);
            }
            if (r) {
                this.mvQ.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void onPrepared() {
        int i = this.lZm - 1;
        this.lZm = i;
        if (i <= 0) {
            int i2 = 0;
            for (l lVar : this.mwz) {
                i2 += lVar.dwg().length;
            }
            t[] tVarArr = new t[i2];
            l[] lVarArr = this.mwz;
            int length = lVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                l lVar2 = lVarArr[i3];
                int i5 = lVar2.dwg().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = lVar2.dwg().KR(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lYR = new u(tVarArr);
            this.mrg.a((com.google.android.exoplayer2.source.k) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void a(a.C0681a c0681a) {
        this.mvS.e(c0681a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(l lVar) {
        if (this.lYR != null) {
            this.mrg.a((k.a) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void dxp() {
        dxq();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void a(a.C0681a c0681a, long j) {
        for (l lVar : this.mwz) {
            lVar.a(c0681a, j);
        }
        dxq();
    }

    private void gt(long j) {
        ArrayList arrayList;
        int i;
        com.google.android.exoplayer2.source.hls.playlist.a dxx = this.mvS.dxx();
        ArrayList arrayList2 = new ArrayList(dxx.mwS);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList2.size()) {
                break;
            }
            a.C0681a c0681a = (a.C0681a) arrayList2.get(i3);
            if (c0681a.lZJ.height > 0 || a(c0681a, "avc")) {
                arrayList3.add(c0681a);
            } else if (a(c0681a, AudioSampleEntry.TYPE3)) {
                arrayList4.add(c0681a);
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
        List<a.C0681a> list = dxx.audios;
        List<a.C0681a> list2 = dxx.mwT;
        this.mwz = new l[list.size() + 1 + list2.size()];
        this.lZm = this.mwz.length;
        com.google.android.exoplayer2.util.a.checkArgument(!arrayList.isEmpty());
        a.C0681a[] c0681aArr = new a.C0681a[arrayList.size()];
        arrayList.toArray(c0681aArr);
        l a = a(0, c0681aArr, dxx.mwF, dxx.mvU, j);
        int i4 = 1;
        this.mwz[0] = a;
        a.vI(true);
        a.dxr();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i = i4;
            if (i6 >= list.size()) {
                break;
            }
            l a2 = a(1, new a.C0681a[]{list.get(i6)}, (Format) null, Collections.emptyList(), j);
            i4 = i + 1;
            this.mwz[i] = a2;
            a2.dxr();
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (i7 < list2.size()) {
            a.C0681a c0681a2 = list2.get(i7);
            l a3 = a(3, new a.C0681a[]{c0681a2}, (Format) null, Collections.emptyList(), j);
            a3.o(c0681a2.lZJ);
            this.mwz[i] = a3;
            i7++;
            i++;
        }
        this.mwA = this.mwz;
    }

    private l a(int i, a.C0681a[] c0681aArr, Format format, List<Format> list, long j) {
        return new l(i, this, new d(this.mvN, this.mvS, c0681aArr, this.mww, this.mvQ, list), this.mrF, j, format, this.mrC, this.mtM);
    }

    private void dxq() {
        if (this.lYR != null) {
            this.mrg.a((k.a) this);
            return;
        }
        for (l lVar : this.mwz) {
            lVar.dxr();
        }
    }

    private static boolean a(a.C0681a c0681a, String str) {
        String str2 = c0681a.lZJ.codecs;
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
