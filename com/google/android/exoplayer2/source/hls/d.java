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
/* loaded from: classes5.dex */
class d {
    private byte[] mdF;
    private com.google.android.exoplayer2.b.f mtK;
    private IOException mtN;
    private long mtP = -9223372036854775807L;
    private byte[] muN;
    private final f muP;
    private final com.google.android.exoplayer2.upstream.e muQ;
    private final com.google.android.exoplayer2.upstream.e muR;
    private final m muS;
    private final a.C0673a[] muT;
    private final HlsPlaylistTracker muU;
    private final t muV;
    private final List<Format> muW;
    private boolean muX;
    private byte[] muY;
    private a.C0673a muZ;
    private boolean mva;
    private Uri mvb;
    private String mvc;

    /* loaded from: classes5.dex */
    public static final class b {
        public com.google.android.exoplayer2.source.a.c msH;
        public boolean msI;
        public a.C0673a mvf;

        public b() {
            clear();
        }

        public void clear() {
            this.msH = null;
            this.msI = false;
            this.mvf = null;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C0673a[] c0673aArr, e eVar, m mVar, List<Format> list) {
        this.muP = fVar;
        this.muU = hlsPlaylistTracker;
        this.muT = c0673aArr;
        this.muS = mVar;
        this.muW = list;
        Format[] formatArr = new Format[c0673aArr.length];
        int[] iArr = new int[c0673aArr.length];
        for (int i = 0; i < c0673aArr.length; i++) {
            formatArr[i] = c0673aArr[i].lYL;
            iArr[i] = i;
        }
        this.muQ = eVar.La(1);
        this.muR = eVar.La(3);
        this.muV = new t(formatArr);
        this.mtK = new c(this.muV, iArr);
    }

    public void duX() throws IOException {
        if (this.mtN != null) {
            throw this.mtN;
        }
        if (this.muZ != null) {
            this.muU.d(this.muZ);
        }
    }

    public t dvR() {
        return this.muV;
    }

    public void b(com.google.android.exoplayer2.b.f fVar) {
        this.mtK = fVar;
    }

    public com.google.android.exoplayer2.b.f dvS() {
        return this.mtK;
    }

    public void reset() {
        this.mtN = null;
    }

    public void vE(boolean z) {
        this.muX = z;
    }

    public void a(h hVar, long j, long j2, b bVar) {
        int i;
        com.google.android.exoplayer2.source.hls.playlist.b bVar2;
        a.C0673a c0673a;
        int i2;
        int i3;
        com.google.android.exoplayer2.source.hls.playlist.b bVar3;
        a.C0673a c0673a2;
        com.google.android.exoplayer2.upstream.g gVar;
        int m = hVar == null ? -1 : this.muV.m(hVar.msu);
        this.muZ = null;
        long j3 = j2 - j;
        long gt = gt(j);
        if (hVar != null && !this.mva) {
            long dso = hVar.dso();
            j3 = Math.max(0L, j3 - dso);
            if (gt != -9223372036854775807L) {
                gt = Math.max(0L, gt - dso);
            }
        }
        this.mtK.f(j, j3, gt);
        int dxk = this.mtK.dxk();
        boolean z = m != dxk;
        a.C0673a c0673a3 = this.muT[dxk];
        if (!this.muU.c(c0673a3)) {
            bVar.mvf = c0673a3;
            this.muZ = c0673a3;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b b2 = this.muU.b(c0673a3);
        this.mva = b2.mwc;
        a(b2);
        if (hVar == null || z) {
            if (hVar != null && !this.mva) {
                j2 = hVar.msx;
            }
            if (!b2.mwd && j2 >= b2.dwg()) {
                i = b2.mwa + b2.mwg.size();
                bVar2 = b2;
                c0673a = c0673a3;
                i2 = dxk;
            } else {
                int a2 = v.a((List<? extends Comparable<? super Long>>) b2.mwg, Long.valueOf(j2 - b2.msx), true, !this.muU.dwk() || hVar == null) + b2.mwa;
                if (a2 >= b2.mwa || hVar == null) {
                    i = a2;
                    bVar2 = b2;
                    c0673a = c0673a3;
                    i2 = dxk;
                } else {
                    a.C0673a c0673a4 = this.muT[m];
                    bVar2 = this.muU.b(c0673a4);
                    c0673a = c0673a4;
                    i2 = m;
                    i = hVar.dvC();
                }
            }
            i3 = i;
            bVar3 = bVar2;
            c0673a2 = c0673a;
        } else {
            i3 = hVar.dvC();
            bVar3 = b2;
            c0673a2 = c0673a3;
            i2 = dxk;
        }
        if (i3 < bVar3.mwa) {
            this.mtN = new BehindLiveWindowException();
            return;
        }
        int i4 = i3 - bVar3.mwa;
        if (i4 >= bVar3.mwg.size()) {
            if (bVar3.mwd) {
                bVar.msI = true;
                return;
            }
            bVar.mvf = c0673a2;
            this.muZ = c0673a2;
            return;
        }
        b.a aVar = bVar3.mwg.get(i4);
        if (aVar.mwj != null) {
            Uri fk = u.fk(bVar3.mwn, aVar.mwj);
            if (!fk.equals(this.mvb)) {
                bVar.msH = a(fk, aVar.mwk, i2, this.mtK.dvW(), this.mtK.dvX());
                return;
            } else if (!v.h(aVar.mwk, this.mvc)) {
                a(fk, aVar.mwk, this.mdF);
            }
        } else {
            dvT();
        }
        b.a aVar2 = bVar3.mwf;
        if (aVar2 == null) {
            gVar = null;
        } else {
            gVar = new com.google.android.exoplayer2.upstream.g(u.fk(bVar3.mwn, aVar2.url), aVar2.mwl, aVar2.mwm, null);
        }
        long j4 = bVar3.msx + aVar.mwi;
        int i5 = bVar3.mvZ + aVar.mwh;
        bVar.msH = new h(this.muP, this.muQ, new com.google.android.exoplayer2.upstream.g(u.fk(bVar3.mwn, aVar.url), aVar.mwl, aVar.mwm, null), gVar, c0673a2, this.muW, this.mtK.dvW(), this.mtK.dvX(), j4, j4 + aVar.lYQ, i3, i5, this.muX, this.muS.Lb(i5), hVar, bVar3.drmInitData, this.mdF, this.muN);
    }

    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.muY = aVar.dvE();
            a(aVar.dataSpec.uri, aVar.mvd, aVar.dvU());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        return z && com.google.android.exoplayer2.source.a.h.a(this.mtK, this.mtK.indexOf(this.muV.m(cVar.msu)), iOException);
    }

    public void a(a.C0673a c0673a, long j) {
        int indexOf;
        int m = this.muV.m(c0673a.lYL);
        if (m != -1 && (indexOf = this.mtK.indexOf(m)) != -1) {
            this.mtK.I(indexOf, j);
        }
    }

    private long gt(long j) {
        if (this.mtP != -9223372036854775807L) {
            return this.mtP - j;
        }
        return -9223372036854775807L;
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.mtP = bVar.mwd ? -9223372036854775807L : bVar.dwg();
    }

    private a a(Uri uri, String str, int i, int i2, Object obj) {
        return new a(this.muR, new com.google.android.exoplayer2.upstream.g(uri, 0L, -1L, null, 1), this.muT[i].lYL, i2, obj, this.muY, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.Qo(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.mvb = uri;
        this.mdF = bArr;
        this.mvc = str;
        this.muN = bArr2;
    }

    private void dvT() {
        this.mvb = null;
        this.mdF = null;
        this.mvc = null;
        this.muN = null;
    }

    /* loaded from: classes5.dex */
    private static final class c extends com.google.android.exoplayer2.b.b {
        private int hvb;

        public c(t tVar, int[] iArr) {
            super(tVar, iArr);
            this.hvb = m(tVar.KL(0));
        }

        @Override // com.google.android.exoplayer2.b.f
        public void f(long j, long j2, long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (J(this.hvb, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!J(i, elapsedRealtime)) {
                        this.hvb = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dvV() {
            return this.hvb;
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dvW() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b.f
        public Object dvX() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String mvd;
        private byte[] mve;

        public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i, obj, bArr);
            this.mvd = str;
        }

        @Override // com.google.android.exoplayer2.source.a.j
        protected void z(byte[] bArr, int i) throws IOException {
            this.mve = Arrays.copyOf(bArr, i);
        }

        public byte[] dvU() {
            return this.mve;
        }
    }
}
