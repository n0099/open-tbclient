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
    private byte[] mgj;
    private com.google.android.exoplayer2.b.f mwo;
    private IOException mwr;
    private long mwt = -9223372036854775807L;
    private final List<Format> mxA;
    private boolean mxB;
    private byte[] mxC;
    private a.C0682a mxD;
    private boolean mxE;
    private Uri mxF;
    private String mxG;
    private byte[] mxr;
    private final f mxt;
    private final com.google.android.exoplayer2.upstream.e mxu;
    private final com.google.android.exoplayer2.upstream.e mxv;
    private final m mxw;
    private final a.C0682a[] mxx;
    private final HlsPlaylistTracker mxy;
    private final t mxz;

    /* loaded from: classes6.dex */
    public static final class b {
        public com.google.android.exoplayer2.source.a.c mvm;
        public boolean mvn;
        public a.C0682a mxJ;

        public b() {
            clear();
        }

        public void clear() {
            this.mvm = null;
            this.mvn = false;
            this.mxJ = null;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C0682a[] c0682aArr, e eVar, m mVar, List<Format> list) {
        this.mxt = fVar;
        this.mxy = hlsPlaylistTracker;
        this.mxx = c0682aArr;
        this.mxw = mVar;
        this.mxA = list;
        Format[] formatArr = new Format[c0682aArr.length];
        int[] iArr = new int[c0682aArr.length];
        for (int i = 0; i < c0682aArr.length; i++) {
            formatArr[i] = c0682aArr[i].mbs;
            iArr[i] = i;
        }
        this.mxu = eVar.Ll(1);
        this.mxv = eVar.Ll(3);
        this.mxz = new t(formatArr);
        this.mwo = new c(this.mxz, iArr);
    }

    public void dwJ() throws IOException {
        if (this.mwr != null) {
            throw this.mwr;
        }
        if (this.mxD != null) {
            this.mxy.d(this.mxD);
        }
    }

    public t dxD() {
        return this.mxz;
    }

    public void b(com.google.android.exoplayer2.b.f fVar) {
        this.mwo = fVar;
    }

    public com.google.android.exoplayer2.b.f dxE() {
        return this.mwo;
    }

    public void reset() {
        this.mwr = null;
    }

    public void vP(boolean z) {
        this.mxB = z;
    }

    public void a(h hVar, long j, long j2, b bVar) {
        int i;
        com.google.android.exoplayer2.source.hls.playlist.b bVar2;
        a.C0682a c0682a;
        int i2;
        int i3;
        com.google.android.exoplayer2.source.hls.playlist.b bVar3;
        a.C0682a c0682a2;
        com.google.android.exoplayer2.upstream.g gVar;
        int m = hVar == null ? -1 : this.mxz.m(hVar.muZ);
        this.mxD = null;
        long j3 = j2 - j;
        long gs = gs(j);
        if (hVar != null && !this.mxE) {
            long durationUs = hVar.getDurationUs();
            j3 = Math.max(0L, j3 - durationUs);
            if (gs != -9223372036854775807L) {
                gs = Math.max(0L, gs - durationUs);
            }
        }
        this.mwo.g(j, j3, gs);
        int dyW = this.mwo.dyW();
        boolean z = m != dyW;
        a.C0682a c0682a3 = this.mxx[dyW];
        if (!this.mxy.c(c0682a3)) {
            bVar.mxJ = c0682a3;
            this.mxD = c0682a3;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b b2 = this.mxy.b(c0682a3);
        this.mxE = b2.myG;
        a(b2);
        if (hVar == null || z) {
            if (hVar != null && !this.mxE) {
                j2 = hVar.mvc;
            }
            if (!b2.myH && j2 >= b2.dxS()) {
                i = b2.myE + b2.myK.size();
                bVar2 = b2;
                c0682a = c0682a3;
                i2 = dyW;
            } else {
                int a2 = v.a((List<? extends Comparable<? super Long>>) b2.myK, Long.valueOf(j2 - b2.mvc), true, !this.mxy.dxW() || hVar == null) + b2.myE;
                if (a2 >= b2.myE || hVar == null) {
                    i = a2;
                    bVar2 = b2;
                    c0682a = c0682a3;
                    i2 = dyW;
                } else {
                    a.C0682a c0682a4 = this.mxx[m];
                    bVar2 = this.mxy.b(c0682a4);
                    c0682a = c0682a4;
                    i2 = m;
                    i = hVar.dxo();
                }
            }
            i3 = i;
            bVar3 = bVar2;
            c0682a2 = c0682a;
        } else {
            i3 = hVar.dxo();
            bVar3 = b2;
            c0682a2 = c0682a3;
            i2 = dyW;
        }
        if (i3 < bVar3.myE) {
            this.mwr = new BehindLiveWindowException();
            return;
        }
        int i4 = i3 - bVar3.myE;
        if (i4 >= bVar3.myK.size()) {
            if (bVar3.myH) {
                bVar.mvn = true;
                return;
            }
            bVar.mxJ = c0682a2;
            this.mxD = c0682a2;
            return;
        }
        b.a aVar = bVar3.myK.get(i4);
        if (aVar.myN != null) {
            Uri fq = u.fq(bVar3.myR, aVar.myN);
            if (!fq.equals(this.mxF)) {
                bVar.mvm = a(fq, aVar.myO, i2, this.mwo.dxI(), this.mwo.dxJ());
                return;
            } else if (!v.h(aVar.myO, this.mxG)) {
                a(fq, aVar.myO, this.mgj);
            }
        } else {
            dxF();
        }
        b.a aVar2 = bVar3.myJ;
        if (aVar2 == null) {
            gVar = null;
        } else {
            gVar = new com.google.android.exoplayer2.upstream.g(u.fq(bVar3.myR, aVar2.url), aVar2.myP, aVar2.myQ, null);
        }
        long j4 = bVar3.mvc + aVar.myM;
        int i5 = bVar3.myD + aVar.myL;
        bVar.mvm = new h(this.mxt, this.mxu, new com.google.android.exoplayer2.upstream.g(u.fq(bVar3.myR, aVar.url), aVar.myP, aVar.myQ, null), gVar, c0682a2, this.mxA, this.mwo.dxI(), this.mwo.dxJ(), j4, j4 + aVar.mbx, i3, i5, this.mxB, this.mxw.Lm(i5), hVar, bVar3.drmInitData, this.mgj, this.mxr);
    }

    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.mxC = aVar.dxq();
            a(aVar.dataSpec.uri, aVar.mxH, aVar.dxG());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        return z && com.google.android.exoplayer2.source.a.h.a(this.mwo, this.mwo.indexOf(this.mxz.m(cVar.muZ)), iOException);
    }

    public void a(a.C0682a c0682a, long j) {
        int indexOf;
        int m = this.mxz.m(c0682a.mbs);
        if (m != -1 && (indexOf = this.mwo.indexOf(m)) != -1) {
            this.mwo.H(indexOf, j);
        }
    }

    private long gs(long j) {
        if (this.mwt != -9223372036854775807L) {
            return this.mwt - j;
        }
        return -9223372036854775807L;
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.mwt = bVar.myH ? -9223372036854775807L : bVar.dxS();
    }

    private a a(Uri uri, String str, int i, int i2, Object obj) {
        return new a(this.mxv, new com.google.android.exoplayer2.upstream.g(uri, 0L, -1L, null, 1), this.mxx[i].mbs, i2, obj, this.mxC, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.QC(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.mxF = uri;
        this.mgj = bArr;
        this.mxG = str;
        this.mxr = bArr2;
    }

    private void dxF() {
        this.mxF = null;
        this.mgj = null;
        this.mxG = null;
        this.mxr = null;
    }

    /* loaded from: classes6.dex */
    private static final class c extends com.google.android.exoplayer2.b.b {
        private int hyO;

        public c(t tVar, int[] iArr) {
            super(tVar, iArr);
            this.hyO = m(tVar.KW(0));
        }

        @Override // com.google.android.exoplayer2.b.f
        public void g(long j, long j2, long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (I(this.hyO, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!I(i, elapsedRealtime)) {
                        this.hyO = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxH() {
            return this.hyO;
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dxI() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b.f
        public Object dxJ() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String mxH;
        private byte[] mxI;

        public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i, obj, bArr);
            this.mxH = str;
        }

        @Override // com.google.android.exoplayer2.source.a.j
        protected void B(byte[] bArr, int i) throws IOException {
            this.mxI = Arrays.copyOf(bArr, i);
        }

        public byte[] dxG() {
            return this.mxI;
        }
    }
}
