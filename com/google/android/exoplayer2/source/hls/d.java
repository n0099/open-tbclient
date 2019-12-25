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
/* loaded from: classes4.dex */
class d {
    private byte[] lZN;
    private com.google.android.exoplayer2.b.f mpU;
    private IOException mpX;
    private long mpZ = -9223372036854775807L;
    private byte[] mqY;
    private final f mra;
    private final com.google.android.exoplayer2.upstream.e mrb;
    private final com.google.android.exoplayer2.upstream.e mrc;
    private final m mrd;
    private final a.C0667a[] mre;
    private final HlsPlaylistTracker mrf;
    private final t mrg;
    private final List<Format> mrh;
    private boolean mri;
    private byte[] mrj;
    private a.C0667a mrk;
    private boolean mrl;
    private Uri mrm;
    private String mrn;

    /* loaded from: classes4.dex */
    public static final class b {
        public com.google.android.exoplayer2.source.a.c moS;
        public boolean moT;
        public a.C0667a mrq;

        public b() {
            clear();
        }

        public void clear() {
            this.moS = null;
            this.moT = false;
            this.mrq = null;
        }
    }

    public d(f fVar, HlsPlaylistTracker hlsPlaylistTracker, a.C0667a[] c0667aArr, e eVar, m mVar, List<Format> list) {
        this.mra = fVar;
        this.mrf = hlsPlaylistTracker;
        this.mre = c0667aArr;
        this.mrd = mVar;
        this.mrh = list;
        Format[] formatArr = new Format[c0667aArr.length];
        int[] iArr = new int[c0667aArr.length];
        for (int i = 0; i < c0667aArr.length; i++) {
            formatArr[i] = c0667aArr[i].lUU;
            iArr[i] = i;
        }
        this.mrb = eVar.KR(1);
        this.mrc = eVar.KR(3);
        this.mrg = new t(formatArr);
        this.mpU = new c(this.mrg, iArr);
    }

    public void dtM() throws IOException {
        if (this.mpX != null) {
            throw this.mpX;
        }
        if (this.mrk != null) {
            this.mrf.d(this.mrk);
        }
    }

    public t duG() {
        return this.mrg;
    }

    public void b(com.google.android.exoplayer2.b.f fVar) {
        this.mpU = fVar;
    }

    public com.google.android.exoplayer2.b.f duH() {
        return this.mpU;
    }

    public void reset() {
        this.mpX = null;
    }

    public void vs(boolean z) {
        this.mri = z;
    }

    public void a(h hVar, long j, long j2, b bVar) {
        int i;
        com.google.android.exoplayer2.source.hls.playlist.b bVar2;
        a.C0667a c0667a;
        int i2;
        int i3;
        com.google.android.exoplayer2.source.hls.playlist.b bVar3;
        a.C0667a c0667a2;
        com.google.android.exoplayer2.upstream.g gVar;
        int m = hVar == null ? -1 : this.mrg.m(hVar.moF);
        this.mrk = null;
        long j3 = j2 - j;
        long go = go(j);
        if (hVar != null && !this.mrl) {
            long drc = hVar.drc();
            j3 = Math.max(0L, j3 - drc);
            if (go != -9223372036854775807L) {
                go = Math.max(0L, go - drc);
            }
        }
        this.mpU.f(j, j3, go);
        int dvZ = this.mpU.dvZ();
        boolean z = m != dvZ;
        a.C0667a c0667a3 = this.mre[dvZ];
        if (!this.mrf.c(c0667a3)) {
            bVar.mrq = c0667a3;
            this.mrk = c0667a3;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b b2 = this.mrf.b(c0667a3);
        this.mrl = b2.mso;
        a(b2);
        if (hVar == null || z) {
            if (hVar != null && !this.mrl) {
                j2 = hVar.moI;
            }
            if (!b2.msp && j2 >= b2.duV()) {
                i = b2.msm + b2.mss.size();
                bVar2 = b2;
                c0667a = c0667a3;
                i2 = dvZ;
            } else {
                int a2 = v.a((List<? extends Comparable<? super Long>>) b2.mss, Long.valueOf(j2 - b2.moI), true, !this.mrf.duZ() || hVar == null) + b2.msm;
                if (a2 >= b2.msm || hVar == null) {
                    i = a2;
                    bVar2 = b2;
                    c0667a = c0667a3;
                    i2 = dvZ;
                } else {
                    a.C0667a c0667a4 = this.mre[m];
                    bVar2 = this.mrf.b(c0667a4);
                    c0667a = c0667a4;
                    i2 = m;
                    i = hVar.dur();
                }
            }
            i3 = i;
            bVar3 = bVar2;
            c0667a2 = c0667a;
        } else {
            i3 = hVar.dur();
            bVar3 = b2;
            c0667a2 = c0667a3;
            i2 = dvZ;
        }
        if (i3 < bVar3.msm) {
            this.mpX = new BehindLiveWindowException();
            return;
        }
        int i4 = i3 - bVar3.msm;
        if (i4 >= bVar3.mss.size()) {
            if (bVar3.msp) {
                bVar.moT = true;
                return;
            }
            bVar.mrq = c0667a2;
            this.mrk = c0667a2;
            return;
        }
        b.a aVar = bVar3.mss.get(i4);
        if (aVar.msv != null) {
            Uri fi = u.fi(bVar3.msz, aVar.msv);
            if (!fi.equals(this.mrm)) {
                bVar.moS = a(fi, aVar.msw, i2, this.mpU.duL(), this.mpU.duM());
                return;
            } else if (!v.h(aVar.msw, this.mrn)) {
                a(fi, aVar.msw, this.lZN);
            }
        } else {
            duI();
        }
        b.a aVar2 = bVar3.msr;
        if (aVar2 == null) {
            gVar = null;
        } else {
            gVar = new com.google.android.exoplayer2.upstream.g(u.fi(bVar3.msz, aVar2.url), aVar2.msx, aVar2.msy, null);
        }
        long j4 = bVar3.moI + aVar.msu;
        int i5 = bVar3.msl + aVar.mst;
        bVar.moS = new h(this.mra, this.mrb, new com.google.android.exoplayer2.upstream.g(u.fi(bVar3.msz, aVar.url), aVar.msx, aVar.msy, null), gVar, c0667a2, this.mrh, this.mpU.duL(), this.mpU.duM(), j4, j4 + aVar.lUZ, i3, i5, this.mri, this.mrd.KS(i5), hVar, bVar3.drmInitData, this.lZN, this.mqY);
    }

    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.mrj = aVar.dut();
            a(aVar.dataSpec.uri, aVar.mro, aVar.duJ());
        }
    }

    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, IOException iOException) {
        return z && com.google.android.exoplayer2.source.a.h.a(this.mpU, this.mpU.indexOf(this.mrg.m(cVar.moF)), iOException);
    }

    public void a(a.C0667a c0667a, long j) {
        int indexOf;
        int m = this.mrg.m(c0667a.lUU);
        if (m != -1 && (indexOf = this.mpU.indexOf(m)) != -1) {
            this.mpU.I(indexOf, j);
        }
    }

    private long go(long j) {
        if (this.mpZ != -9223372036854775807L) {
            return this.mpZ - j;
        }
        return -9223372036854775807L;
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        this.mpZ = bVar.msp ? -9223372036854775807L : bVar.duV();
    }

    private a a(Uri uri, String str, int i, int i2, Object obj) {
        return new a(this.mrc, new com.google.android.exoplayer2.upstream.g(uri, 0L, -1L, null, 1), this.mre[i].lUU, i2, obj, this.mrj, str);
    }

    private void a(Uri uri, String str, byte[] bArr) {
        byte[] byteArray = new BigInteger(v.Qd(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr2, (bArr2.length - byteArray.length) + length, byteArray.length - length);
        this.mrm = uri;
        this.lZN = bArr;
        this.mrn = str;
        this.mqY = bArr2;
    }

    private void duI() {
        this.mrm = null;
        this.lZN = null;
        this.mrn = null;
        this.mqY = null;
    }

    /* loaded from: classes4.dex */
    private static final class c extends com.google.android.exoplayer2.b.b {
        private int hry;

        public c(t tVar, int[] iArr) {
            super(tVar, iArr);
            this.hry = m(tVar.KC(0));
        }

        @Override // com.google.android.exoplayer2.b.f
        public void f(long j, long j2, long j3) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (J(this.hry, elapsedRealtime)) {
                for (int i = this.length - 1; i >= 0; i--) {
                    if (!J(i, elapsedRealtime)) {
                        this.hry = i;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.b.f
        public int duK() {
            return this.hry;
        }

        @Override // com.google.android.exoplayer2.b.f
        public int duL() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.b.f
        public Object duM() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a extends com.google.android.exoplayer2.source.a.j {
        public final String mro;
        private byte[] mrp;

        public a(com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.upstream.g gVar, Format format, int i, Object obj, byte[] bArr, String str) {
            super(eVar, gVar, 3, format, i, obj, bArr);
            this.mro = str;
        }

        @Override // com.google.android.exoplayer2.source.a.j
        protected void z(byte[] bArr, int i) throws IOException {
            this.mrp = Arrays.copyOf(bArr, i);
        }

        public byte[] duJ() {
            return this.mrp;
        }
    }
}
