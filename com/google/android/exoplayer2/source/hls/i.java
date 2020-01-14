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
    private u lXY;
    private int lYt;
    private final int mqJ;
    private final com.google.android.exoplayer2.upstream.b mqM;
    private k.a mqn;
    private final b.a msS;
    private com.google.android.exoplayer2.source.e mtn;
    private final f muU;
    private final HlsPlaylistTracker muZ;
    private final e mvD;
    private final IdentityHashMap<p, Integer> mvE = new IdentityHashMap<>();
    private final m muX = new m();
    private final Handler mvF = new Handler();
    private l[] mvG = new l[0];
    private l[] mvH = new l[0];

    public i(f fVar, HlsPlaylistTracker hlsPlaylistTracker, e eVar, int i, b.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.muU = fVar;
        this.muZ = hlsPlaylistTracker;
        this.mvD = eVar;
        this.mqJ = i;
        this.msS = aVar;
        this.mqM = bVar;
    }

    public void release() {
        this.muZ.b(this);
        this.mvF.removeCallbacksAndMessages(null);
        for (l lVar : this.mvG) {
            lVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqn = aVar;
        this.muZ.a(this);
        gv(j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duS() throws IOException {
        for (l lVar : this.mvG) {
            lVar.duS();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duT() {
        return this.lXY;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mvE.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dvT = fVarArr[i2].dvT();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mvG.length) {
                        if (this.mvG[i3].duT().a(dvT) == -1) {
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
        this.mvE.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        int i4 = 0;
        l[] lVarArr = new l[this.mvG.length];
        int i5 = 0;
        while (true) {
            int i6 = i4;
            if (i5 < this.mvG.length) {
                for (int i7 = 0; i7 < fVarArr.length; i7++) {
                    pVarArr3[i7] = iArr[i7] == i5 ? pVarArr[i7] : null;
                    fVarArr2[i7] = iArr2[i7] == i5 ? fVarArr[i7] : null;
                }
                l lVar = this.mvG[i5];
                boolean a = lVar.a(fVarArr2, zArr, pVarArr3, zArr2, j, z);
                boolean z2 = false;
                for (int i8 = 0; i8 < fVarArr.length; i8++) {
                    if (iArr2[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] != null);
                        pVarArr2[i8] = pVarArr3[i8];
                        z2 = true;
                        this.mvE.put(pVarArr3[i8], Integer.valueOf(i5));
                    } else if (iArr[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] == null);
                    }
                }
                if (z2) {
                    lVarArr[i6] = lVar;
                    int i9 = i6 + 1;
                    if (i6 == 0) {
                        lVar.vE(true);
                        if (a || this.mvH.length == 0 || lVar != this.mvH[0]) {
                            this.muX.reset();
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
                this.mvH = (l[]) Arrays.copyOf(lVarArr, i6);
                this.mtn = new com.google.android.exoplayer2.source.e(this.mvH);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        for (l lVar : this.mvH) {
            lVar.gd(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        return this.mtn.gf(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duW() {
        return this.mtn.duW();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duU() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duV() {
        return this.mtn.duV();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        if (this.mvH.length > 0) {
            boolean p = this.mvH[0].p(j, false);
            for (int i = 1; i < this.mvH.length; i++) {
                this.mvH[i].p(j, p);
            }
            if (p) {
                this.muX.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void onPrepared() {
        int i = this.lYt - 1;
        this.lYt = i;
        if (i <= 0) {
            int i2 = 0;
            for (l lVar : this.mvG) {
                i2 += lVar.duT().length;
            }
            t[] tVarArr = new t[i2];
            l[] lVarArr = this.mvG;
            int length = lVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                l lVar2 = lVarArr[i3];
                int i5 = lVar2.duT().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = lVar2.duT().KM(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lXY = new u(tVarArr);
            this.mqn.a((com.google.android.exoplayer2.source.k) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void a(a.C0673a c0673a) {
        this.muZ.e(c0673a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(l lVar) {
        if (this.lXY != null) {
            this.mqn.a((k.a) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void dwc() {
        dwd();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void a(a.C0673a c0673a, long j) {
        for (l lVar : this.mvG) {
            lVar.a(c0673a, j);
        }
        dwd();
    }

    private void gv(long j) {
        ArrayList arrayList;
        int i;
        com.google.android.exoplayer2.source.hls.playlist.a dwk = this.muZ.dwk();
        ArrayList arrayList2 = new ArrayList(dwk.mvZ);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList2.size()) {
                break;
            }
            a.C0673a c0673a = (a.C0673a) arrayList2.get(i3);
            if (c0673a.lYQ.height > 0 || a(c0673a, "avc")) {
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
        List<a.C0673a> list = dwk.audios;
        List<a.C0673a> list2 = dwk.mwa;
        this.mvG = new l[list.size() + 1 + list2.size()];
        this.lYt = this.mvG.length;
        com.google.android.exoplayer2.util.a.checkArgument(!arrayList.isEmpty());
        a.C0673a[] c0673aArr = new a.C0673a[arrayList.size()];
        arrayList.toArray(c0673aArr);
        l a = a(0, c0673aArr, dwk.mvM, dwk.mvb, j);
        int i4 = 1;
        this.mvG[0] = a;
        a.vE(true);
        a.dwe();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i = i4;
            if (i6 >= list.size()) {
                break;
            }
            l a2 = a(1, new a.C0673a[]{list.get(i6)}, (Format) null, Collections.emptyList(), j);
            i4 = i + 1;
            this.mvG[i] = a2;
            a2.dwe();
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (i7 < list2.size()) {
            a.C0673a c0673a2 = list2.get(i7);
            l a3 = a(3, new a.C0673a[]{c0673a2}, (Format) null, Collections.emptyList(), j);
            a3.o(c0673a2.lYQ);
            this.mvG[i] = a3;
            i7++;
            i++;
        }
        this.mvH = this.mvG;
    }

    private l a(int i, a.C0673a[] c0673aArr, Format format, List<Format> list, long j) {
        return new l(i, this, new d(this.muU, this.muZ, c0673aArr, this.mvD, this.muX, list), this.mqM, j, format, this.mqJ, this.msS);
    }

    private void dwd() {
        if (this.lXY != null) {
            this.mqn.a((k.a) this);
            return;
        }
        for (l lVar : this.mvG) {
            lVar.dwe();
        }
    }

    private static boolean a(a.C0673a c0673a, String str) {
        String str2 = c0673a.lYQ.codecs;
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
