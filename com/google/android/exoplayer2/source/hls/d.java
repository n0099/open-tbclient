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
    private byte[] meD;
    private com.google.android.exoplayer2.b.f muI;
    private IOException muL;
    private long muN = -9223372036854775807L;
    private byte[] mvL;
    private final f mvN;
    private final com.google.android.exoplayer2.upstream.e mvO;
    private final com.google.android.exoplayer2.upstream.e mvP;
    private final m mvQ;
    private final a.C0681a[] mvR;
    private final HlsPlaylistTracker mvS;
    private final t mvT;
    private final List<Format> mvU;
    private boolean mvV;
    private byte[] mvW;
    private a.C0681a mvX;
    private boolean mvY;
    private Uri mvZ;
    private String mwa;

    /* loaded from: classes6.dex */
    public static final class b {
        public com.google.android.exoplayer2.source.a.c mtG;
        public boolean mtH;
        public a.C0681a mwd;

        public b() {
            clear();
        }

        public void clear() {
            this.mtG = null;
            this.mtH = false;
            this.mwd = null;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C0681a[] c0681aArr, e eVar, m mVar, List<Format> list) {
        this.mvN = fVar;
        this.mvS = hlsPlaylistTracker;
        this.mvR = c0681aArr;
        this.mvQ = mVar;
        this.mvU = list;
        Format[] formatArr = new Format[c0681aArr.length];
        int[] iArr = new int[c0681aArr.length];
        for (int i = 0; i < c0681aArr.length; i++) {
            formatArr[i] = c0681aArr[i].lZJ;
            iArr[i] = i;
        }
        this.mvO = eVar.Lf(1);
        this.mvP = eVar.Lf(3);
        this.mvT = new t(formatArr);
        this.muI = new c(this.mvT, iArr);
    }

    public void dwm() throws IOException {
        if (this.muL != null) {
            throw this.muL;
        }
        if (this.mvX != null) {
            this.mvS.d(this.mvX);
        }
    }

    public t dxg() {
        return this.mvT;
    }

    public void b(com.google.android.exoplayer2.b.f fVar) {
        this.muI = fVar;
    }

    public com.google.android.exoplayer2.b.f dxh() {
        return this.muI;
    }

    public void reset() {
        this.muL = null;
    }

    public void vI(boolean z) {
        this.mvV = z;
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
        int m = hVar == null ? -1 : this.mvT.m(hVar.mts);
        this.mvX = null;
        long j3 = j2 - j;
        long gr = gr(j);
        if (hVar != null && !this.mvY) {
            long durationUs = hVar.getDurationUs();
            j3 = Math.max(0L, j3 - durationUs);
            if (gr != -9223372036854775807L) {
                gr = Math.max(0L, gr - durationUs);
            }
        }
        this.muI.g(j, j3, gr);
        int dyz = this.muI.dyz();
        boolean z = m != dyz;
        a.C0681a c0681a3 = this.mvR[dyz];
        if (!this.mvS.c(c0681a3)) {
            bVar.mwd = c0681a3;
            this.mvX = c0681a3;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b b2 = this.mvS.b(c0681a3);
        this.mvY = b2.mxa;
        a(b2);
        if (hVar == null || z) {
            if (hVar != null && !this.mvY) {
                j2 = hVar.mtv;
            }
            if (!b2.mxb && j2 >= b2.dxv()) {
                i = b2.mwY + b2.mxe.size();
                bVar2 = b2;
                c0681a = c0681a3;
                i2 = dyz;
            } else {
                int a2 = v.a((List<? extends Comparable<? super Long>>) b2.mxe, Long.valueOf(j2 - b2.mtv), true, !this.mvS.dxz() || hVar == null) + b2.mwY;
                if (a2 >= b2.mwY || hVar == null) {
                    i = a2;
                    bVar2 = b2;
                    c0681a = c0681a3;
                    i2 = dyz;
                } else {
                    a.C0681a c0681a4 = this.mvR[m];
                    bVar2 = this.mvS.b(c0681a4);
                    c0681a = c0681a4;
                    i2 = m;
                    i = hVar.dwR();
                }
            }
            i3 = i;
            bVar3 = bVar2;
            c0681a2 = c0681a;
        } else {
            i3 = hVar.dwR();
            bVar3 = b2;
            c0681a2 = c0681a3;
            i2 = dyz;
        }
        if (i3 < bVar3.mwY) {
            this.muL = new BehindLiveWindowException();
            return;
        }
        int i4 = i3 - bVar3.mwY;
        if (i4 >= bVar3.mxe.size()) {
            if (bVar3.mxb) {
                bVar.mtH = true;
                return;
            }
            bVar.mwd = c0681a2;
            this.mvX = c0681a2;
            return;
        }
        b.a aVar = bVar3.mxe.get(i4);
        if (aVar.mxh != null) {
            Uri fs = u.fs(bVar3.mxl, aVar.mxh);
            if (!fs.equals(this.mvZ)) {
                bVar.mtG = a(fs, aVar.mxi, i2, this.muI.dxl(), this.muI.dxm());
                return;
            } else if (!v.h(aVar.mxi, this.mwa)) {
                a(fs, aVar.mxi, this.meD);
            }
        } else {
            dxi();
        }
        b.a aVar2 = bVar3.mxd;
        if (aVar2 == null) {
            gVar = null;
        } else {
            gVar = new com.google.android.exoplayer2.upstream.g(u.fs(bVar3.mxl, aVar2.url), aVar2.mxj, aVar2.mxk, null);
        }
        long j4 = bVar3.mtv + aVar.mxg;
        int i5 = bVar3.mwX + aVar.mxf;
        bVar.mtG = new h(this.mvN, this.mvO, new com.google.android.exoplayer2.upstream.g(u.fs(bVar3.mxl, aVar.url), aVar.mxj, aVar.mxk, null), gVar, c0681a2, this.mvU, this.muI.dxl(), this.muI.dxm(), j4, j4 + aVar.lZO, i3, i5, this.mvV, this.mvQ.Lg(i5), hVar, bVar3.drmInitData, this.meD, this.mvL);
    }

    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.mvW = aVar.dwT();
            a(aVar.dataSpec.uri, aVar.mwb, aVar.dxj());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        return z && com.google.android.exoplayer2.source.a.h.a(this.muI, this.muI.indexOf(this.mvT.m(cVar.mts)), iOException);
    }

    public void a(a.C0681a c0681a, long j) {
        int indexOf;
        int m = this.mvT.m(c0681a.lZJ);
        if (m != -1 && (indexOf = this.muI.indexOf(m)) != -1) {
            this.muI.H(indexOf, j);
        }
    }

    private long gr(long j) {
        if (this.muN != -9223372036854775807L) {
            return this.muN - j;
        }
        return -9223372036854775807L;
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.muN = bVar.mxb ? -9223372036854775807L : bVar.dxv();
    }

    private a a(Uri uri, String str, int i, int i2, Object obj) {
        return new a(this.mvP, new com.google.android.exoplayer2.upstream.g(uri, 0L, -1L, null, 1), this.mvR[i].lZJ, i2, obj, this.mvW, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.QC(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.mvZ = uri;
        this.meD = bArr;
        this.mwa = str;
        this.mvL = bArr2;
    }

    private void dxi() {
        this.mvZ = null;
        this.meD = null;
        this.mwa = null;
        this.mvL = null;
    }

    /* loaded from: classes6.dex */
    private static final class c extends com.google.android.exoplayer2.b.b {
        private int hxo;

        public c(t tVar, int[] iArr) {
            super(tVar, iArr);
            this.hxo = m(tVar.KQ(0));
        }

        @Override // com.google.android.exoplayer2.b.f
        public void g(long j, long j2, long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (I(this.hxo, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!I(i, elapsedRealtime)) {
                        this.hxo = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxk() {
            return this.hxo;
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxl() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b.f
        public Object dxm() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String mwb;
        private byte[] mwc;

        public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i, obj, bArr);
            this.mwb = str;
        }

        @Override // com.google.android.exoplayer2.source.a.j
        protected void B(byte[] bArr, int i) throws IOException {
            this.mwc = Arrays.copyOf(bArr, i);
        }

        public byte[] dxj() {
            return this.mwc;
        }
    }
}
