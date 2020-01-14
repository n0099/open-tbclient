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
    private byte[] mdK;
    private com.google.android.exoplayer2.b.f mtP;
    private IOException mtS;
    private long mtU = -9223372036854775807L;
    private byte[] muS;
    private final f muU;
    private final com.google.android.exoplayer2.upstream.e muV;
    private final com.google.android.exoplayer2.upstream.e muW;
    private final m muX;
    private final a.C0673a[] muY;
    private final HlsPlaylistTracker muZ;
    private final t mva;
    private final List<Format> mvb;
    private boolean mvc;
    private byte[] mvd;
    private a.C0673a mve;
    private boolean mvf;
    private Uri mvg;
    private String mvh;

    /* loaded from: classes5.dex */
    public static final class b {
        public com.google.android.exoplayer2.source.a.c msM;
        public boolean msN;
        public a.C0673a mvk;

        public b() {
            clear();
        }

        public void clear() {
            this.msM = null;
            this.msN = false;
            this.mvk = null;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C0673a[] c0673aArr, e eVar, m mVar, List<Format> list) {
        this.muU = fVar;
        this.muZ = hlsPlaylistTracker;
        this.muY = c0673aArr;
        this.muX = mVar;
        this.mvb = list;
        Format[] formatArr = new Format[c0673aArr.length];
        int[] iArr = new int[c0673aArr.length];
        for (int i = 0; i < c0673aArr.length; i++) {
            formatArr[i] = c0673aArr[i].lYQ;
            iArr[i] = i;
        }
        this.muV = eVar.La(1);
        this.muW = eVar.La(3);
        this.mva = new t(formatArr);
        this.mtP = new c(this.mva, iArr);
    }

    public void duZ() throws IOException {
        if (this.mtS != null) {
            throw this.mtS;
        }
        if (this.mve != null) {
            this.muZ.d(this.mve);
        }
    }

    public t dvT() {
        return this.mva;
    }

    public void b(com.google.android.exoplayer2.b.f fVar) {
        this.mtP = fVar;
    }

    public com.google.android.exoplayer2.b.f dvU() {
        return this.mtP;
    }

    public void reset() {
        this.mtS = null;
    }

    public void vE(boolean z) {
        this.mvc = z;
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
        int m = hVar == null ? -1 : this.mva.m(hVar.msz);
        this.mve = null;
        long j3 = j2 - j;
        long gt = gt(j);
        if (hVar != null && !this.mvf) {
            long dsq = hVar.dsq();
            j3 = Math.max(0L, j3 - dsq);
            if (gt != -9223372036854775807L) {
                gt = Math.max(0L, gt - dsq);
            }
        }
        this.mtP.f(j, j3, gt);
        int dxm = this.mtP.dxm();
        boolean z = m != dxm;
        a.C0673a c0673a3 = this.muY[dxm];
        if (!this.muZ.c(c0673a3)) {
            bVar.mvk = c0673a3;
            this.mve = c0673a3;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b b2 = this.muZ.b(c0673a3);
        this.mvf = b2.mwh;
        a(b2);
        if (hVar == null || z) {
            if (hVar != null && !this.mvf) {
                j2 = hVar.msC;
            }
            if (!b2.mwi && j2 >= b2.dwi()) {
                i = b2.mwf + b2.mwl.size();
                bVar2 = b2;
                c0673a = c0673a3;
                i2 = dxm;
            } else {
                int a2 = v.a((List<? extends Comparable<? super Long>>) b2.mwl, Long.valueOf(j2 - b2.msC), true, !this.muZ.dwm() || hVar == null) + b2.mwf;
                if (a2 >= b2.mwf || hVar == null) {
                    i = a2;
                    bVar2 = b2;
                    c0673a = c0673a3;
                    i2 = dxm;
                } else {
                    a.C0673a c0673a4 = this.muY[m];
                    bVar2 = this.muZ.b(c0673a4);
                    c0673a = c0673a4;
                    i2 = m;
                    i = hVar.dvE();
                }
            }
            i3 = i;
            bVar3 = bVar2;
            c0673a2 = c0673a;
        } else {
            i3 = hVar.dvE();
            bVar3 = b2;
            c0673a2 = c0673a3;
            i2 = dxm;
        }
        if (i3 < bVar3.mwf) {
            this.mtS = new BehindLiveWindowException();
            return;
        }
        int i4 = i3 - bVar3.mwf;
        if (i4 >= bVar3.mwl.size()) {
            if (bVar3.mwi) {
                bVar.msN = true;
                return;
            }
            bVar.mvk = c0673a2;
            this.mve = c0673a2;
            return;
        }
        b.a aVar = bVar3.mwl.get(i4);
        if (aVar.mwo != null) {
            Uri fk = u.fk(bVar3.mws, aVar.mwo);
            if (!fk.equals(this.mvg)) {
                bVar.msM = a(fk, aVar.mwp, i2, this.mtP.dvY(), this.mtP.dvZ());
                return;
            } else if (!v.h(aVar.mwp, this.mvh)) {
                a(fk, aVar.mwp, this.mdK);
            }
        } else {
            dvV();
        }
        b.a aVar2 = bVar3.mwk;
        if (aVar2 == null) {
            gVar = null;
        } else {
            gVar = new com.google.android.exoplayer2.upstream.g(u.fk(bVar3.mws, aVar2.url), aVar2.mwq, aVar2.mwr, null);
        }
        long j4 = bVar3.msC + aVar.mwn;
        int i5 = bVar3.mwe + aVar.mwm;
        bVar.msM = new h(this.muU, this.muV, new com.google.android.exoplayer2.upstream.g(u.fk(bVar3.mws, aVar.url), aVar.mwq, aVar.mwr, null), gVar, c0673a2, this.mvb, this.mtP.dvY(), this.mtP.dvZ(), j4, j4 + aVar.lYV, i3, i5, this.mvc, this.muX.Lb(i5), hVar, bVar3.drmInitData, this.mdK, this.muS);
    }

    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.mvd = aVar.dvG();
            a(aVar.dataSpec.uri, aVar.mvi, aVar.dvW());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        return z && com.google.android.exoplayer2.source.a.h.a(this.mtP, this.mtP.indexOf(this.mva.m(cVar.msz)), iOException);
    }

    public void a(a.C0673a c0673a, long j) {
        int indexOf;
        int m = this.mva.m(c0673a.lYQ);
        if (m != -1 && (indexOf = this.mtP.indexOf(m)) != -1) {
            this.mtP.I(indexOf, j);
        }
    }

    private long gt(long j) {
        if (this.mtU != -9223372036854775807L) {
            return this.mtU - j;
        }
        return -9223372036854775807L;
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.mtU = bVar.mwi ? -9223372036854775807L : bVar.dwi();
    }

    private a a(Uri uri, String str, int i, int i2, Object obj) {
        return new a(this.muW, new com.google.android.exoplayer2.upstream.g(uri, 0L, -1L, null, 1), this.muY[i].lYQ, i2, obj, this.mvd, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.Qo(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.mvg = uri;
        this.mdK = bArr;
        this.mvh = str;
        this.muS = bArr2;
    }

    private void dvV() {
        this.mvg = null;
        this.mdK = null;
        this.mvh = null;
        this.muS = null;
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
        public int dvX() {
            return this.hvb;
        }

        @Override // com.google.android.exoplayer2.b.f
        public int dvY() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b.f
        public Object dvZ() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String mvi;
        private byte[] mvj;

        public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i, obj, bArr);
            this.mvi = str;
        }

        @Override // com.google.android.exoplayer2.source.a.j
        protected void z(byte[] bArr, int i) throws IOException {
            this.mvj = Arrays.copyOf(bArr, i);
        }

        public byte[] dvW() {
            return this.mvj;
        }
    }
}
