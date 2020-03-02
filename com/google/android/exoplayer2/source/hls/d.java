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
    private byte[] mes;
    private IOException muA;
    private long muC = -9223372036854775807L;
    private com.google.android.exoplayer2.b.f mux;
    private byte[] mvA;
    private final f mvC;
    private final com.google.android.exoplayer2.upstream.e mvD;
    private final com.google.android.exoplayer2.upstream.e mvE;
    private final m mvF;
    private final a.C0681a[] mvG;
    private final HlsPlaylistTracker mvH;
    private final t mvI;
    private final List<Format> mvJ;
    private boolean mvK;
    private byte[] mvL;
    private a.C0681a mvM;
    private boolean mvN;
    private Uri mvO;
    private String mvP;

    /* loaded from: classes6.dex */
    public static final class b {
        public com.google.android.exoplayer2.source.a.c mtu;
        public boolean mtv;
        public a.C0681a mvS;

        public b() {
            clear();
        }

        public void clear() {
            this.mtu = null;
            this.mtv = false;
            this.mvS = null;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C0681a[] c0681aArr, e eVar, m mVar, List<Format> list) {
        this.mvC = fVar;
        this.mvH = hlsPlaylistTracker;
        this.mvG = c0681aArr;
        this.mvF = mVar;
        this.mvJ = list;
        Format[] formatArr = new Format[c0681aArr.length];
        int[] iArr = new int[c0681aArr.length];
        for (int i = 0; i < c0681aArr.length; i++) {
            formatArr[i] = c0681aArr[i].lZy;
            iArr[i] = i;
        }
        this.mvD = eVar.Lf(1);
        this.mvE = eVar.Lf(3);
        this.mvI = new t(formatArr);
        this.mux = new c(this.mvI, iArr);
    }

    public void dwl() throws IOException {
        if (this.muA != null) {
            throw this.muA;
        }
        if (this.mvM != null) {
            this.mvH.d(this.mvM);
        }
    }

    public t dxf() {
        return this.mvI;
    }

    public void b(com.google.android.exoplayer2.b.f fVar) {
        this.mux = fVar;
    }

    public com.google.android.exoplayer2.b.f dxg() {
        return this.mux;
    }

    public void reset() {
        this.muA = null;
    }

    public void vI(boolean z) {
        this.mvK = z;
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
        int m = hVar == null ? -1 : this.mvI.m(hVar.mth);
        this.mvM = null;
        long j3 = j2 - j;
        long gr = gr(j);
        if (hVar != null && !this.mvN) {
            long durationUs = hVar.getDurationUs();
            j3 = Math.max(0L, j3 - durationUs);
            if (gr != -9223372036854775807L) {
                gr = Math.max(0L, gr - durationUs);
            }
        }
        this.mux.g(j, j3, gr);
        int dyy = this.mux.dyy();
        boolean z = m != dyy;
        a.C0681a c0681a3 = this.mvG[dyy];
        if (!this.mvH.c(c0681a3)) {
            bVar.mvS = c0681a3;
            this.mvM = c0681a3;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b b2 = this.mvH.b(c0681a3);
        this.mvN = b2.mwP;
        a(b2);
        if (hVar == null || z) {
            if (hVar != null && !this.mvN) {
                j2 = hVar.mtk;
            }
            if (!b2.mwQ && j2 >= b2.dxu()) {
                i = b2.mwN + b2.mwT.size();
                bVar2 = b2;
                c0681a = c0681a3;
                i2 = dyy;
            } else {
                int a2 = v.a((List<? extends Comparable<? super Long>>) b2.mwT, Long.valueOf(j2 - b2.mtk), true, !this.mvH.dxy() || hVar == null) + b2.mwN;
                if (a2 >= b2.mwN || hVar == null) {
                    i = a2;
                    bVar2 = b2;
                    c0681a = c0681a3;
                    i2 = dyy;
                } else {
                    a.C0681a c0681a4 = this.mvG[m];
                    bVar2 = this.mvH.b(c0681a4);
                    c0681a = c0681a4;
                    i2 = m;
                    i = hVar.dwQ();
                }
            }
            i3 = i;
            bVar3 = bVar2;
            c0681a2 = c0681a;
        } else {
            i3 = hVar.dwQ();
            bVar3 = b2;
            c0681a2 = c0681a3;
            i2 = dyy;
        }
        if (i3 < bVar3.mwN) {
            this.muA = new BehindLiveWindowException();
            return;
        }
        int i4 = i3 - bVar3.mwN;
        if (i4 >= bVar3.mwT.size()) {
            if (bVar3.mwQ) {
                bVar.mtv = true;
                return;
            }
            bVar.mvS = c0681a2;
            this.mvM = c0681a2;
            return;
        }
        b.a aVar = bVar3.mwT.get(i4);
        if (aVar.mwW != null) {
            Uri fs = u.fs(bVar3.mxa, aVar.mwW);
            if (!fs.equals(this.mvO)) {
                bVar.mtu = a(fs, aVar.mwX, i2, this.mux.dxk(), this.mux.dxl());
                return;
            } else if (!v.h(aVar.mwX, this.mvP)) {
                a(fs, aVar.mwX, this.mes);
            }
        } else {
            dxh();
        }
        b.a aVar2 = bVar3.mwS;
        if (aVar2 == null) {
            gVar = null;
        } else {
            gVar = new com.google.android.exoplayer2.upstream.g(u.fs(bVar3.mxa, aVar2.url), aVar2.mwY, aVar2.mwZ, null);
        }
        long j4 = bVar3.mtk + aVar.mwV;
        int i5 = bVar3.mwM + aVar.mwU;
        bVar.mtu = new h(this.mvC, this.mvD, new com.google.android.exoplayer2.upstream.g(u.fs(bVar3.mxa, aVar.url), aVar.mwY, aVar.mwZ, null), gVar, c0681a2, this.mvJ, this.mux.dxk(), this.mux.dxl(), j4, j4 + aVar.lZD, i3, i5, this.mvK, this.mvF.Lg(i5), hVar, bVar3.drmInitData, this.mes, this.mvA);
    }

    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.mvL = aVar.dwS();
            a(aVar.dataSpec.uri, aVar.mvQ, aVar.dxi());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        return z && com.google.android.exoplayer2.source.a.h.a(this.mux, this.mux.indexOf(this.mvI.m(cVar.mth)), iOException);
    }

    public void a(a.C0681a c0681a, long j) {
        int indexOf;
        int m = this.mvI.m(c0681a.lZy);
        if (m != -1 && (indexOf = this.mux.indexOf(m)) != -1) {
            this.mux.H(indexOf, j);
        }
    }

    private long gr(long j) {
        if (this.muC != -9223372036854775807L) {
            return this.muC - j;
        }
        return -9223372036854775807L;
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.muC = bVar.mwQ ? -9223372036854775807L : bVar.dxu();
    }

    private a a(Uri uri, String str, int i, int i2, Object obj) {
        return new a(this.mvE, new com.google.android.exoplayer2.upstream.g(uri, 0L, -1L, null, 1), this.mvG[i].lZy, i2, obj, this.mvL, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.QB(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.mvO = uri;
        this.mes = bArr;
        this.mvP = str;
        this.mvA = bArr2;
    }

    private void dxh() {
        this.mvO = null;
        this.mes = null;
        this.mvP = null;
        this.mvA = null;
    }

    /* loaded from: classes6.dex */
    private static final class c extends com.google.android.exoplayer2.b.b {
        private int hxc;

        public c(t tVar, int[] iArr) {
            super(tVar, iArr);
            this.hxc = m(tVar.KQ(0));
        }

        @Override // com.google.android.exoplayer2.b.f
        public void g(long j, long j2, long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (I(this.hxc, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!I(i, elapsedRealtime)) {
                        this.hxc = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxj() {
            return this.hxc;
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxk() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b.f
        public Object dxl() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String mvQ;
        private byte[] mvR;

        public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i, obj, bArr);
            this.mvQ = str;
        }

        @Override // com.google.android.exoplayer2.source.a.j
        protected void B(byte[] bArr, int i) throws IOException {
            this.mvR = Arrays.copyOf(bArr, i);
        }

        public byte[] dxi() {
            return this.mvR;
        }
    }
}
