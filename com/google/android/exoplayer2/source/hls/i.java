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
/* loaded from: classes5.dex */
public final class i implements l.a, HlsPlaylistTracker.b, com.google.android.exoplayer2.source.k {
    private u lXT;
    private int lYo;
    private final int mqE;
    private final com.google.android.exoplayer2.upstream.b mqH;
    private k.a mqi;
    private final b.a msN;
    private com.google.android.exoplayer2.source.e mti;
    private final f muP;
    private final HlsPlaylistTracker muU;
    private final e mvy;
    private final IdentityHashMap<p, Integer> mvz = new IdentityHashMap<>();
    private final m muS = new m();
    private final Handler mvA = new Handler();
    private l[] mvB = new l[0];
    private l[] mvC = new l[0];

    public i(f fVar, HlsPlaylistTracker hlsPlaylistTracker, e eVar, int i, b.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.muP = fVar;
        this.muU = hlsPlaylistTracker;
        this.mvy = eVar;
        this.mqE = i;
        this.msN = aVar;
        this.mqH = bVar;
    }

    public void release() {
        this.muU.b(this);
        this.mvA.removeCallbacksAndMessages(null);
        for (l lVar : this.mvB) {
            lVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqi = aVar;
        this.muU.a(this);
        gv(j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duQ() throws IOException {
        for (l lVar : this.mvB) {
            lVar.duQ();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duR() {
        return this.lXT;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mvz.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dvR = fVarArr[i2].dvR();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mvB.length) {
                        if (this.mvB[i3].duR().a(dvR) == -1) {
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
        this.mvz.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        int i4 = 0;
        l[] lVarArr = new l[this.mvB.length];
        int i5 = 0;
        while (true) {
            int i6 = i4;
            if (i5 < this.mvB.length) {
                for (int i7 = 0; i7 < fVarArr.length; i7++) {
                    pVarArr3[i7] = iArr[i7] == i5 ? pVarArr[i7] : null;
                    fVarArr2[i7] = iArr2[i7] == i5 ? fVarArr[i7] : null;
                }
                l lVar = this.mvB[i5];
                boolean a = lVar.a(fVarArr2, zArr, pVarArr3, zArr2, j, z);
                boolean z2 = false;
                for (int i8 = 0; i8 < fVarArr.length; i8++) {
                    if (iArr2[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] != null);
                        pVarArr2[i8] = pVarArr3[i8];
                        z2 = true;
                        this.mvz.put(pVarArr3[i8], Integer.valueOf(i5));
                    } else if (iArr[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] == null);
                    }
                }
                if (z2) {
                    lVarArr[i6] = lVar;
                    int i9 = i6 + 1;
                    if (i6 == 0) {
                        lVar.vE(true);
                        if (a || this.mvC.length == 0 || lVar != this.mvC[0]) {
                            this.muS.reset();
                            z = true;
                            i4 = i9;
                        }
                    } else {
                        lVar.vE(false);
                    }
                    i4 = i9;
                } else {
                    i4 = i6;
                }
                i5++;
            } else {
                System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
                this.mvC = (l[]) Arrays.copyOf(lVarArr, i6);
                this.mti = new com.google.android.exoplayer2.source.e(this.mvC);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        for (l lVar : this.mvC) {
            lVar.gd(j);
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
        if (this.mvC.length > 0) {
            boolean p = this.mvC[0].p(j, false);
            for (int i = 1; i < this.mvC.length; i++) {
                this.mvC[i].p(j, p);
            }
            if (p) {
                this.muS.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void onPrepared() {
        int i = this.lYo - 1;
        this.lYo = i;
        if (i <= 0) {
            int i2 = 0;
            for (l lVar : this.mvB) {
                i2 += lVar.duR().length;
            }
            t[] tVarArr = new t[i2];
            l[] lVarArr = this.mvB;
            int length = lVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                l lVar2 = lVarArr[i3];
                int i5 = lVar2.duR().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = lVar2.duR().KM(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lXT = new u(tVarArr);
            this.mqi.a((com.google.android.exoplayer2.source.k) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void a(a.C0673a c0673a) {
        this.muU.e(c0673a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(l lVar) {
        if (this.lXT != null) {
            this.mqi.a((k.a) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void dwa() {
        dwb();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void a(a.C0673a c0673a, long j) {
        for (l lVar : this.mvB) {
            lVar.a(c0673a, j);
        }
        dwb();
    }

    private void gv(long j) {
        ArrayList arrayList;
        int i;
        com.google.android.exoplayer2.source.hls.playlist.a dwi = this.muU.dwi();
        ArrayList arrayList2 = new ArrayList(dwi.mvU);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList2.size()) {
                break;
            }
            a.C0673a c0673a = (a.C0673a) arrayList2.get(i3);
            if (c0673a.lYL.height > 0 || a(c0673a, "avc")) {
                arrayList3.add(c0673a);
            } else if (a(c0673a, AudioSampleEntry.TYPE3)) {
                arrayList4.add(c0673a);
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
        List<a.C0673a> list = dwi.audios;
        List<a.C0673a> list2 = dwi.mvV;
        this.mvB = new l[list.size() + 1 + list2.size()];
        this.lYo = this.mvB.length;
        com.google.android.exoplayer2.util.a.checkArgument(!arrayList.isEmpty());
        a.C0673a[] c0673aArr = new a.C0673a[arrayList.size()];
        arrayList.toArray(c0673aArr);
        l a = a(0, c0673aArr, dwi.mvH, dwi.muW, j);
        int i4 = 1;
        this.mvB[0] = a;
        a.vE(true);
        a.dwc();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i = i4;
            if (i6 >= list.size()) {
                break;
            }
            l a2 = a(1, new a.C0673a[]{list.get(i6)}, (Format) null, Collections.emptyList(), j);
            i4 = i + 1;
            this.mvB[i] = a2;
            a2.dwc();
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (i7 < list2.size()) {
            a.C0673a c0673a2 = list2.get(i7);
            l a3 = a(3, new a.C0673a[]{c0673a2}, (Format) null, Collections.emptyList(), j);
            a3.o(c0673a2.lYL);
            this.mvB[i] = a3;
            i7++;
            i++;
        }
        this.mvC = this.mvB;
    }

    private l a(int i, a.C0673a[] c0673aArr, Format format, List<Format> list, long j) {
        return new l(i, this, new d(this.muP, this.muU, c0673aArr, this.mvy, this.muS, list), this.mqH, j, format, this.mqE, this.msN);
    }

    private void dwb() {
        if (this.lXT != null) {
            this.mqi.a((k.a) this);
            return;
        }
        for (l lVar : this.mvB) {
            lVar.dwc();
        }
    }

    private static boolean a(a.C0673a c0673a, String str) {
        String str2 = c0673a.lYL.codecs;
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
