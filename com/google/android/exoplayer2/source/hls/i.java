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
/* loaded from: classes4.dex */
public final class i implements l.a, HlsPlaylistTracker.b, com.google.android.exoplayer2.source.k {
    private u lUc;
    private int lUx;
    private final int mmP;
    private final com.google.android.exoplayer2.upstream.b mmS;
    private k.a mmt;
    private final b.a moY;
    private com.google.android.exoplayer2.source.e mpt;
    private final e mrJ;
    private final f mra;
    private final HlsPlaylistTracker mrf;
    private final IdentityHashMap<p, Integer> mrK = new IdentityHashMap<>();
    private final m mrd = new m();
    private final Handler mrL = new Handler();
    private l[] mrM = new l[0];
    private l[] mrN = new l[0];

    public i(f fVar, HlsPlaylistTracker hlsPlaylistTracker, e eVar, int i, b.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mra = fVar;
        this.mrf = hlsPlaylistTracker;
        this.mrJ = eVar;
        this.mmP = i;
        this.moY = aVar;
        this.mmS = bVar;
    }

    public void release() {
        this.mrf.b(this);
        this.mrL.removeCallbacksAndMessages(null);
        for (l lVar : this.mrM) {
            lVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mmt = aVar;
        this.mrf.a(this);
        gq(j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dtF() throws IOException {
        for (l lVar : this.mrM) {
            lVar.dtF();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dtG() {
        return this.lUc;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mrK.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t duG = fVarArr[i2].duG();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mrM.length) {
                        if (this.mrM[i3].dtG().a(duG) == -1) {
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
        this.mrK.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        int i4 = 0;
        l[] lVarArr = new l[this.mrM.length];
        int i5 = 0;
        while (true) {
            int i6 = i4;
            if (i5 < this.mrM.length) {
                for (int i7 = 0; i7 < fVarArr.length; i7++) {
                    pVarArr3[i7] = iArr[i7] == i5 ? pVarArr[i7] : null;
                    fVarArr2[i7] = iArr2[i7] == i5 ? fVarArr[i7] : null;
                }
                l lVar = this.mrM[i5];
                boolean a = lVar.a(fVarArr2, zArr, pVarArr3, zArr2, j, z);
                boolean z2 = false;
                for (int i8 = 0; i8 < fVarArr.length; i8++) {
                    if (iArr2[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] != null);
                        pVarArr2[i8] = pVarArr3[i8];
                        z2 = true;
                        this.mrK.put(pVarArr3[i8], Integer.valueOf(i5));
                    } else if (iArr[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] == null);
                    }
                }
                if (z2) {
                    lVarArr[i6] = lVar;
                    int i9 = i6 + 1;
                    if (i6 == 0) {
                        lVar.vs(true);
                        if (a || this.mrN.length == 0 || lVar != this.mrN[0]) {
                            this.mrd.reset();
                            z = true;
                            i4 = i9;
                        }
                    } else {
                        lVar.vs(false);
                    }
                    i4 = i9;
                } else {
                    i4 = i6;
                }
                i5++;
            } else {
                System.arraycopy(pVarArr2, 0, pVarArr, 0, pVarArr2.length);
                this.mrN = (l[]) Arrays.copyOf(lVarArr, i6);
                this.mpt = new com.google.android.exoplayer2.source.e(this.mrN);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void fY(long j) {
        for (l lVar : this.mrN) {
            lVar.fY(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ga(long j) {
        return this.mpt.ga(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtJ() {
        return this.mpt.dtJ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dtH() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtI() {
        return this.mpt.dtI();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long fZ(long j) {
        if (this.mrN.length > 0) {
            boolean p = this.mrN[0].p(j, false);
            for (int i = 1; i < this.mrN.length; i++) {
                this.mrN[i].p(j, p);
            }
            if (p) {
                this.mrd.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void onPrepared() {
        int i = this.lUx - 1;
        this.lUx = i;
        if (i <= 0) {
            int i2 = 0;
            for (l lVar : this.mrM) {
                i2 += lVar.dtG().length;
            }
            t[] tVarArr = new t[i2];
            l[] lVarArr = this.mrM;
            int length = lVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                l lVar2 = lVarArr[i3];
                int i5 = lVar2.dtG().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = lVar2.dtG().KD(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lUc = new u(tVarArr);
            this.mmt.a((com.google.android.exoplayer2.source.k) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void a(a.C0667a c0667a) {
        this.mrf.e(c0667a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(l lVar) {
        if (this.lUc != null) {
            this.mmt.a((k.a) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void duP() {
        duQ();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void a(a.C0667a c0667a, long j) {
        for (l lVar : this.mrM) {
            lVar.a(c0667a, j);
        }
        duQ();
    }

    private void gq(long j) {
        ArrayList arrayList;
        int i;
        com.google.android.exoplayer2.source.hls.playlist.a duX = this.mrf.duX();
        ArrayList arrayList2 = new ArrayList(duX.msf);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList2.size()) {
                break;
            }
            a.C0667a c0667a = (a.C0667a) arrayList2.get(i3);
            if (c0667a.lUU.height > 0 || a(c0667a, "avc")) {
                arrayList3.add(c0667a);
            } else if (a(c0667a, AudioSampleEntry.TYPE3)) {
                arrayList4.add(c0667a);
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
        List<a.C0667a> list = duX.audios;
        List<a.C0667a> list2 = duX.msh;
        this.mrM = new l[list.size() + 1 + list2.size()];
        this.lUx = this.mrM.length;
        com.google.android.exoplayer2.util.a.checkArgument(!arrayList.isEmpty());
        a.C0667a[] c0667aArr = new a.C0667a[arrayList.size()];
        arrayList.toArray(c0667aArr);
        l a = a(0, c0667aArr, duX.mrS, duX.mrh, j);
        int i4 = 1;
        this.mrM[0] = a;
        a.vs(true);
        a.duR();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i = i4;
            if (i6 >= list.size()) {
                break;
            }
            l a2 = a(1, new a.C0667a[]{list.get(i6)}, (Format) null, Collections.emptyList(), j);
            i4 = i + 1;
            this.mrM[i] = a2;
            a2.duR();
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (i7 < list2.size()) {
            a.C0667a c0667a2 = list2.get(i7);
            l a3 = a(3, new a.C0667a[]{c0667a2}, (Format) null, Collections.emptyList(), j);
            a3.o(c0667a2.lUU);
            this.mrM[i] = a3;
            i7++;
            i++;
        }
        this.mrN = this.mrM;
    }

    private l a(int i, a.C0667a[] c0667aArr, Format format, List<Format> list, long j) {
        return new l(i, this, new d(this.mra, this.mrf, c0667aArr, this.mrJ, this.mrd, list), this.mmS, j, format, this.mmP, this.moY);
    }

    private void duQ() {
        if (this.lUc != null) {
            this.mmt.a((k.a) this);
            return;
        }
        for (l lVar : this.mrM) {
            lVar.duR();
        }
    }

    private static boolean a(a.C0667a c0667a, String str) {
        String str2 = c0667a.lUU.codecs;
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
