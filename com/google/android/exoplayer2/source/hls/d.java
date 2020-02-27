package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
class d {
    private byte[] meq;
    private long muA = -9223372036854775807L;
    private com.google.android.exoplayer2.b.f muv;
    private IOException muy;
    private final f mvA;
    private final com.google.android.exoplayer2.upstream.e mvB;
    private final com.google.android.exoplayer2.upstream.e mvC;
    private final m mvD;
    private final a.C0681a[] mvE;
    private final HlsPlaylistTracker mvF;
    private final t mvG;
    private final List<Format> mvH;
    private boolean mvI;
    private byte[] mvJ;
    private a.C0681a mvK;
    private boolean mvL;
    private Uri mvM;
    private String mvN;
    private byte[] mvy;

    /* loaded from: classes6.dex */
    public static final class b {
        public com.google.android.exoplayer2.source.a.c mts;
        public boolean mtt;
        public a.C0681a mvQ;

        public b() {
            clear();
        }

        public void clear() {
            this.mts = null;
            this.mtt = false;
            this.mvQ = null;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C0681a[] c0681aArr, e eVar, m mVar, List<Format> list) {
        this.mvA = fVar;
        this.mvF = hlsPlaylistTracker;
        this.mvE = c0681aArr;
        this.mvD = mVar;
        this.mvH = list;
        Format[] formatArr = new Format[c0681aArr.length];
        int[] iArr = new int[c0681aArr.length];
        for (int i = 0; i < c0681aArr.length; i++) {
            formatArr[i] = c0681aArr[i].lZw;
            iArr[i] = i;
        }
        this.mvB = eVar.Lf(1);
        this.mvC = eVar.Lf(3);
        this.mvG = new t(formatArr);
        this.muv = new c(this.mvG, iArr);
    }

    public void dwj() throws IOException {
        if (this.muy != null) {
            throw this.muy;
        }
        if (this.mvK != null) {
            this.mvF.d(this.mvK);
        }
    }

    public t dxd() {
        return this.mvG;
    }

    public void b(com.google.android.exoplayer2.b.f fVar) {
        this.muv = fVar;
    }

    public com.google.android.exoplayer2.b.f dxe() {
        return this.muv;
    }

    public void reset() {
        this.muy = null;
    }

    public void vI(boolean z) {
        this.mvI = z;
    }

    public void a(h hVar, long j, long j2, b bVar) {
        int i;
        com.google.android.exoplayer2.source.hls.playlist.b bVar2;
        a.C0681a c0681a;
        int i2;
        int i3;
        com.google.android.exoplayer2.source.hls.playlist.b bVar3;
        a.C0681a c0681a2;
        com.google.android.exoplayer2.upstream.g gVar;
        int m = hVar == null ? -1 : this.mvG.m(hVar.mtf);
        this.mvK = null;
        long j3 = j2 - j;
        long gr = gr(j);
        if (hVar != null && !this.mvL) {
            long durationUs = hVar.getDurationUs();
            j3 = Math.max(0L, j3 - durationUs);
            if (gr != -9223372036854775807L) {
                gr = Math.max(0L, gr - durationUs);
            }
        }
        this.muv.g(j, j3, gr);
        int dyw = this.muv.dyw();
        boolean z = m != dyw;
        a.C0681a c0681a3 = this.mvE[dyw];
        if (!this.mvF.c(c0681a3)) {
            bVar.mvQ = c0681a3;
            this.mvK = c0681a3;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b b2 = this.mvF.b(c0681a3);
        this.mvL = b2.mwN;
        a(b2);
        if (hVar == null || z) {
            if (hVar != null && !this.mvL) {
                j2 = hVar.mti;
            }
            if (!b2.mwO && j2 >= b2.dxs()) {
                i = b2.mwL + b2.mwR.size();
                bVar2 = b2;
                c0681a = c0681a3;
                i2 = dyw;
            } else {
                int a2 = v.a((List<? extends Comparable<? super Long>>) b2.mwR, Long.valueOf(j2 - b2.mti), true, !this.mvF.dxw() || hVar == null) + b2.mwL;
                if (a2 >= b2.mwL || hVar == null) {
                    i = a2;
                    bVar2 = b2;
                    c0681a = c0681a3;
                    i2 = dyw;
                } else {
                    a.C0681a c0681a4 = this.mvE[m];
                    bVar2 = this.mvF.b(c0681a4);
                    c0681a = c0681a4;
                    i2 = m;
                    i = hVar.dwO();
                }
            }
            i3 = i;
            bVar3 = bVar2;
            c0681a2 = c0681a;
        } else {
            i3 = hVar.dwO();
            bVar3 = b2;
            c0681a2 = c0681a3;
            i2 = dyw;
        }
        if (i3 < bVar3.mwL) {
            this.muy = new BehindLiveWindowException();
            return;
        }
        int i4 = i3 - bVar3.mwL;
        if (i4 >= bVar3.mwR.size()) {
            if (bVar3.mwO) {
                bVar.mtt = true;
                return;
            }
            bVar.mvQ = c0681a2;
            this.mvK = c0681a2;
            return;
        }
        b.a aVar = bVar3.mwR.get(i4);
        if (aVar.mwU != null) {
            Uri fs = u.fs(bVar3.mwY, aVar.mwU);
            if (!fs.equals(this.mvM)) {
                bVar.mts = a(fs, aVar.mwV, i2, this.muv.dxi(), this.muv.dxj());
                return;
            } else if (!v.h(aVar.mwV, this.mvN)) {
                a(fs, aVar.mwV, this.meq);
            }
        } else {
            dxf();
        }
        b.a aVar2 = bVar3.mwQ;
        if (aVar2 == null) {
            gVar = null;
        } else {
            gVar = new com.google.android.exoplayer2.upstream.g(u.fs(bVar3.mwY, aVar2.url), aVar2.mwW, aVar2.mwX, null);
        }
        long j4 = bVar3.mti + aVar.mwT;
        int i5 = bVar3.mwK + aVar.mwS;
        bVar.mts = new h(this.mvA, this.mvB, new com.google.android.exoplayer2.upstream.g(u.fs(bVar3.mwY, aVar.url), aVar.mwW, aVar.mwX, null), gVar, c0681a2, this.mvH, this.muv.dxi(), this.muv.dxj(), j4, j4 + aVar.lZB, i3, i5, this.mvI, this.mvD.Lg(i5), hVar, bVar3.drmInitData, this.meq, this.mvy);
    }

    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.mvJ = aVar.dwQ();
            a(aVar.dataSpec.uri, aVar.mvO, aVar.dxg());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        return z && com.google.android.exoplayer2.source.a.h.a(this.muv, this.muv.indexOf(this.mvG.m(cVar.mtf)), iOException);
    }

    public void a(a.C0681a c0681a, long j) {
        int indexOf;
        int m = this.mvG.m(c0681a.lZw);
        if (m != -1 && (indexOf = this.muv.indexOf(m)) != -1) {
            this.muv.H(indexOf, j);
        }
    }

    private long gr(long j) {
        if (this.muA != -9223372036854775807L) {
            return this.muA - j;
        }
        return -9223372036854775807L;
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.muA = bVar.mwO ? -9223372036854775807L : bVar.dxs();
    }

    private a a(Uri uri, String str, int i, int i2, Object obj) {
        return new a(this.mvC, new com.google.android.exoplayer2.upstream.g(uri, 0L, -1L, null, 1), this.mvE[i].lZw, i2, obj, this.mvJ, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.QB(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.mvM = uri;
        this.meq = bArr;
        this.mvN = str;
        this.mvy = bArr2;
    }

    private void dxf() {
        this.mvM = null;
        this.meq = null;
        this.mvN = null;
        this.mvy = null;
    }

    /* loaded from: classes6.dex */
    private static final class c extends com.google.android.exoplayer2.b.b {
        private int hxa;

        public c(t tVar, int[] iArr) {
            super(tVar, iArr);
            this.hxa = m(tVar.KQ(0));
        }

        @Override // com.google.android.exoplayer2.b.f
        public void g(long j, long j2, long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (I(this.hxa, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!I(i, elapsedRealtime)) {
                        this.hxa = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxh() {
            return this.hxa;
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxi() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b.f
        public Object dxj() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String mvO;
        private byte[] mvP;

        public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i, obj, bArr);
            this.mvO = str;
        }

        @Override // com.google.android.exoplayer2.source.a.j
        protected void B(byte[] bArr, int i) throws IOException {
            this.mvP = Arrays.copyOf(bArr, i);
        }

        public byte[] dxg() {
            return this.mvP;
        }
    }
}
