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
    private u lYE;
    private int lYZ;
    private k.a mqT;
    private final int mrp;
    private final com.google.android.exoplayer2.upstream.b mrs;
    private com.google.android.exoplayer2.source.e mtU;
    private final b.a mtz;
    private final f mvA;
    private final HlsPlaylistTracker mvF;
    private final e mwj;
    private final IdentityHashMap<p, Integer> mwk = new IdentityHashMap<>();
    private final m mvD = new m();
    private final Handler mwl = new Handler();
    private l[] mwm = new l[0];
    private l[] mwn = new l[0];

    public i(f fVar, HlsPlaylistTracker hlsPlaylistTracker, e eVar, int i, b.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.mvA = fVar;
        this.mvF = hlsPlaylistTracker;
        this.mwj = eVar;
        this.mrp = i;
        this.mtz = aVar;
        this.mrs = bVar;
    }

    public void release() {
        this.mvF.b(this);
        this.mwl.removeCallbacksAndMessages(null);
        for (l lVar : this.mwm) {
            lVar.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqT = aVar;
        this.mvF.a(this);
        gt(j);
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwc() throws IOException {
        for (l lVar : this.mwm) {
            lVar.dwc();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwd() {
        return this.lYE;
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
            iArr[i2] = pVarArr[i2] == null ? -1 : this.mwk.get(pVarArr[i2]).intValue();
            iArr2[i2] = -1;
            if (fVarArr[i2] != null) {
                t dxd = fVarArr[i2].dxd();
                int i3 = 0;
                while (true) {
                    if (i3 < this.mwm.length) {
                        if (this.mwm[i3].dwd().a(dxd) == -1) {
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
        this.mwk.clear();
        p[] pVarArr2 = new p[fVarArr.length];
        p[] pVarArr3 = new p[fVarArr.length];
        com.google.android.exoplayer2.b.f[] fVarArr2 = new com.google.android.exoplayer2.b.f[fVarArr.length];
        int i4 = 0;
        l[] lVarArr = new l[this.mwm.length];
        int i5 = 0;
        while (true) {
            int i6 = i4;
            if (i5 < this.mwm.length) {
                for (int i7 = 0; i7 < fVarArr.length; i7++) {
                    pVarArr3[i7] = iArr[i7] == i5 ? pVarArr[i7] : null;
                    fVarArr2[i7] = iArr2[i7] == i5 ? fVarArr[i7] : null;
                }
                l lVar = this.mwm[i5];
                boolean a = lVar.a(fVarArr2, zArr, pVarArr3, zArr2, j, z);
                boolean z2 = false;
                for (int i8 = 0; i8 < fVarArr.length; i8++) {
                    if (iArr2[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] != null);
                        pVarArr2[i8] = pVarArr3[i8];
                        z2 = true;
                        this.mwk.put(pVarArr3[i8], Integer.valueOf(i5));
                    } else if (iArr[i8] == i5) {
                        com.google.android.exoplayer2.util.a.checkState(pVarArr3[i8] == null);
                    }
                }
                if (z2) {
                    lVarArr[i6] = lVar;
                    int i9 = i6 + 1;
                    if (i6 == 0) {
                        lVar.vI(true);
                        if (a || this.mwn.length == 0 || lVar != this.mwn[0]) {
                            this.mvD.reset();
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
                this.mwn = (l[]) Arrays.copyOf(lVarArr, i6);
                this.mtU = new com.google.android.exoplayer2.source.e(this.mwn);
                return j;
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        for (l lVar : this.mwn) {
            lVar.gb(j);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        return this.mtU.gd(j);
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwg() {
        return this.mtU.dwg();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwe() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwf() {
        return this.mtU.dwf();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        if (this.mwn.length > 0) {
            boolean r = this.mwn[0].r(j, false);
            for (int i = 1; i < this.mwn.length; i++) {
                this.mwn[i].r(j, r);
            }
            if (r) {
                this.mvD.reset();
            }
        }
        return j;
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void onPrepared() {
        int i = this.lYZ - 1;
        this.lYZ = i;
        if (i <= 0) {
            int i2 = 0;
            for (l lVar : this.mwm) {
                i2 += lVar.dwd().length;
            }
            t[] tVarArr = new t[i2];
            l[] lVarArr = this.mwm;
            int length = lVarArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                l lVar2 = lVarArr[i3];
                int i5 = lVar2.dwd().length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    tVarArr[i6] = lVar2.dwd().KR(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.lYE = new u(tVarArr);
            this.mqT.a((com.google.android.exoplayer2.source.k) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.l.a
    public void a(a.C0681a c0681a) {
        this.mvF.e(c0681a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.source.q.a
    /* renamed from: b */
    public void a(l lVar) {
        if (this.lYE != null) {
            this.mqT.a((k.a) this);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void dxm() {
        dxn();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void a(a.C0681a c0681a, long j) {
        for (l lVar : this.mwm) {
            lVar.a(c0681a, j);
        }
        dxn();
    }

    private void gt(long j) {
        ArrayList arrayList;
        int i;
        com.google.android.exoplayer2.source.hls.playlist.a dxu = this.mvF.dxu();
        ArrayList arrayList2 = new ArrayList(dxu.mwF);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList2.size()) {
                break;
            }
            a.C0681a c0681a = (a.C0681a) arrayList2.get(i3);
            if (c0681a.lZw.height > 0 || a(c0681a, "avc")) {
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
        List<a.C0681a> list = dxu.audios;
        List<a.C0681a> list2 = dxu.mwG;
        this.mwm = new l[list.size() + 1 + list2.size()];
        this.lYZ = this.mwm.length;
        com.google.android.exoplayer2.util.a.checkArgument(!arrayList.isEmpty());
        a.C0681a[] c0681aArr = new a.C0681a[arrayList.size()];
        arrayList.toArray(c0681aArr);
        l a = a(0, c0681aArr, dxu.mws, dxu.mvH, j);
        int i4 = 1;
        this.mwm[0] = a;
        a.vI(true);
        a.dxo();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            i = i4;
            if (i6 >= list.size()) {
                break;
            }
            l a2 = a(1, new a.C0681a[]{list.get(i6)}, (Format) null, Collections.emptyList(), j);
            i4 = i + 1;
            this.mwm[i] = a2;
            a2.dxo();
            i5 = i6 + 1;
        }
        int i7 = 0;
        while (i7 < list2.size()) {
            a.C0681a c0681a2 = list2.get(i7);
            l a3 = a(3, new a.C0681a[]{c0681a2}, (Format) null, Collections.emptyList(), j);
            a3.o(c0681a2.lZw);
            this.mwm[i] = a3;
            i7++;
            i++;
        }
        this.mwn = this.mwm;
    }

    private l a(int i, a.C0681a[] c0681aArr, Format format, List<Format> list, long j) {
        return new l(i, this, new d(this.mvA, this.mvF, c0681aArr, this.mwj, this.mvD, list), this.mrs, j, format, this.mrp, this.mtz);
    }

    private void dxn() {
        if (this.lYE != null) {
            this.mqT.a((k.a) this);
            return;
        }
        for (l lVar : this.mwm) {
            lVar.dxo();
        }
    }

    private static boolean a(a.C0681a c0681a, String str) {
        String str2 = c0681a.lZw.codecs;
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
