package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.hls.d;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.t;
import com.google.android.exoplayer2.source.u;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.v;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class l implements com.google.android.exoplayer2.extractor.g, o.b, q, Loader.a<com.google.android.exoplayer2.source.a.c>, Loader.d {
    private final int lZP;
    private u maA;
    private boolean mbi;
    private boolean mtA;
    private int mtC;
    private long mtH;
    private long mtI;
    private boolean mtK;
    private final int mtj;
    private final com.google.android.exoplayer2.upstream.b mtm;
    private boolean mty;
    private long muH;
    private int mvQ;
    private final b.a mvs;
    private final a myj;
    private final d myk;
    private final Format myl;
    private Format myn;
    private boolean myo;
    private boolean[] myp;
    private boolean[] myq;
    private boolean myr;
    private boolean released;
    private final Loader mtp = new Loader("Loader:HlsSampleStreamWrapper");
    private final d.b mym = new d.b();
    private int[] mtw = new int[0];
    private o[] mtv = new o[0];
    private final LinkedList<h> mvu = new LinkedList<>();
    private final Runnable mts = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.dwN();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes6.dex */
    public interface a extends q.a<l> {
        void a(a.C0682a c0682a);

        void onPrepared();
    }

    public l(int i, a aVar, d dVar, com.google.android.exoplayer2.upstream.b bVar, long j, Format format, int i2, b.a aVar2) {
        this.lZP = i;
        this.myj = aVar;
        this.myk = dVar;
        this.mtm = bVar;
        this.myl = format;
        this.mtj = i2;
        this.mvs = aVar2;
        this.mtH = j;
        this.mtI = j;
    }

    public void dxO() {
        if (!this.mbi) {
            ge(this.mtH);
        }
    }

    public void o(Format format) {
        dL(0, -1).h(format);
        this.mty = true;
        dwN();
    }

    public void dwC() throws IOException {
        dwJ();
    }

    public u dwD() {
        return this.maA;
    }

    public boolean a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.util.a.checkState(this.mbi);
        int i = this.mtC;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= fVarArr.length) {
                break;
            }
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                ae(((k) pVarArr[i3]).group, false);
                pVarArr[i3] = null;
            }
            i2 = i3 + 1;
        }
        boolean z4 = z || (!this.mtA ? j == this.mtH : i != 0);
        com.google.android.exoplayer2.b.f dxE = this.myk.dxE();
        boolean z5 = z4;
        int i4 = 0;
        com.google.android.exoplayer2.b.f fVar = dxE;
        while (i4 < fVarArr.length) {
            if (pVarArr[i4] == null && fVarArr[i4] != null) {
                com.google.android.exoplayer2.b.f fVar2 = fVarArr[i4];
                int a2 = this.maA.a(fVar2.dxD());
                ae(a2, true);
                if (a2 == this.mvQ) {
                    this.myk.b(fVar2);
                    fVar = fVar2;
                }
                pVarArr[i4] = new k(this, a2);
                zArr2[i4] = true;
                if (!z5) {
                    o oVar = this.mtv[a2];
                    oVar.rewind();
                    z3 = oVar.a(j, true, true) == -1 && oVar.dwU() != 0;
                    i4++;
                    z5 = z3;
                }
            }
            z3 = z5;
            i4++;
            z5 = z3;
        }
        if (this.mtC == 0) {
            this.myk.reset();
            this.myn = null;
            this.mvu.clear();
            if (this.mtp.isLoading()) {
                for (o oVar2 : this.mtv) {
                    oVar2.dxd();
                }
                this.mtp.cNV();
            } else {
                dxP();
            }
        } else {
            if (!this.mvu.isEmpty() && !v.h(fVar, dxE)) {
                if (!this.mtA) {
                    fVar.g(j, j < 0 ? -j : 0L, -9223372036854775807L);
                    if (fVar.dyW() == this.myk.dxD().m(this.mvu.getLast().muZ)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    z = true;
                    z5 = true;
                    this.myr = true;
                }
            }
            if (z5) {
                s(j, z);
                for (int i5 = 0; i5 < pVarArr.length; i5++) {
                    if (pVarArr[i5] != null) {
                        zArr2[i5] = true;
                    }
                }
            }
        }
        this.mtA = true;
        return z5;
    }

    public void gc(long j) {
        int length = this.mtv.length;
        for (int i = 0; i < length; i++) {
            this.mtv[i].c(j, false, this.myp[i]);
        }
    }

    public boolean s(long j, boolean z) {
        this.mtH = j;
        if (z || dwQ() || !gg(j)) {
            this.mtI = j;
            this.mtK = false;
            this.mvu.clear();
            if (this.mtp.isLoading()) {
                this.mtp.cNV();
            } else {
                dxP();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwF() {
        if (this.mtK) {
            return Long.MIN_VALUE;
        }
        if (dwQ()) {
            return this.mtI;
        }
        long j = this.mtH;
        h last = this.mvu.getLast();
        if (!last.dxp()) {
            last = this.mvu.size() > 1 ? this.mvu.get(this.mvu.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.mvd) : j;
        o[] oVarArr = this.mtv;
        int length = oVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, oVarArr[i].dwP());
            i++;
            max = max2;
        }
        return max;
    }

    public void release() {
        boolean a2 = this.mtp.a(this);
        if (this.mbi && !a2) {
            for (o oVar : this.mtv) {
                oVar.dxd();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwL() {
        dxP();
    }

    public void vP(boolean z) {
        this.myk.vP(z);
    }

    public void a(a.C0682a c0682a, long j) {
        this.myk.a(c0682a, j);
    }

    public boolean KK(int i) {
        return this.mtK || (!dwQ() && this.mtv[i].dwW());
    }

    public void dwJ() throws IOException {
        this.mtp.dwJ();
        this.myk.dwJ();
    }

    public int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwQ()) {
            return -3;
        }
        int a2 = this.mtv[i].a(mVar, eVar, z, this.mtK, this.mtH);
        if (a2 == -4) {
            dxc();
            return a2;
        }
        return a2;
    }

    public int E(int i, long j) {
        int i2 = 0;
        if (!dwQ()) {
            o oVar = this.mtv[i];
            if (this.mtK && j > oVar.dwP()) {
                i2 = oVar.dwY();
            } else {
                int a2 = oVar.a(j, true, true);
                if (a2 != -1) {
                    i2 = a2;
                }
            }
            if (i2 > 0) {
                dxc();
            }
        }
        return i2;
    }

    private void dxc() {
        if (!this.mvu.isEmpty()) {
            while (this.mvu.size() > 1 && a(this.mvu.getFirst())) {
                this.mvu.removeFirst();
            }
            h first = this.mvu.getFirst();
            Format format = first.muZ;
            if (!format.equals(this.myn)) {
                this.mvs.b(this.lZP, format, first.mva, first.mvb, first.mvc);
            }
            this.myn = format;
        }
    }

    private boolean a(h hVar) {
        int i = hVar.uid;
        for (int i2 = 0; i2 < this.mtv.length; i2++) {
            if (this.myp[i2] && this.mtv[i2].dwV() == i) {
                return false;
            }
        }
        return true;
    }

    private void dxP() {
        for (o oVar : this.mtv) {
            oVar.reset(this.myr);
        }
        this.myr = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean ge(long j) {
        long j2;
        h hVar;
        if (this.mtK || this.mtp.isLoading()) {
            return false;
        }
        if (dwQ()) {
            hVar = null;
            j2 = this.mtI;
        } else {
            h last = this.mvu.getLast();
            j2 = last.mvd;
            hVar = last;
        }
        this.myk.a(hVar, j, j2, this.mym);
        boolean z = this.mym.mvn;
        com.google.android.exoplayer2.source.a.c cVar = this.mym.mvm;
        a.C0682a c0682a = this.mym.mxJ;
        this.mym.clear();
        if (z) {
            this.mtI = -9223372036854775807L;
            this.mtK = true;
            return true;
        } else if (cVar == null) {
            if (c0682a != null) {
                this.myj.a(c0682a);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.mtI = -9223372036854775807L;
                h hVar2 = (h) cVar;
                hVar2.a(this);
                this.mvu.add(hVar2);
            }
            this.mvs.b(cVar.dataSpec, cVar.type, this.lZP, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, this.mtp.a(cVar, this, this.mtj));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwG() {
        if (dwQ()) {
            return this.mtI;
        }
        if (this.mtK) {
            return Long.MIN_VALUE;
        }
        return this.mvu.getLast().mvd;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2) {
        this.myk.b(cVar);
        this.mvs.c(cVar.dataSpec, cVar.type, this.lZP, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, j, j2, cVar.dxj());
        if (!this.mbi) {
            ge(this.mtH);
        } else {
            this.myj.a((a) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, boolean z) {
        this.mvs.d(cVar.dataSpec, cVar.type, this.lZP, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, j, j2, cVar.dxj());
        if (!z) {
            dxP();
            if (this.mtC > 0) {
                this.myj.a((a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, IOException iOException) {
        long dxj = cVar.dxj();
        boolean a2 = a(cVar);
        boolean z = false;
        if (this.myk.a(cVar, !a2 || dxj == 0, iOException)) {
            if (a2) {
                com.google.android.exoplayer2.util.a.checkState(this.mvu.removeLast() == cVar);
                if (this.mvu.isEmpty()) {
                    this.mtI = this.mtH;
                }
            }
            z = true;
        }
        this.mvs.b(cVar.dataSpec, cVar.type, this.lZP, cVar.muZ, cVar.mva, cVar.mvb, cVar.mvc, cVar.mvd, j, j2, cVar.dxj(), iOException, z);
        if (z) {
            if (!this.mbi) {
                ge(this.mtH);
            } else {
                this.myj.a((a) this);
            }
            return 2;
        }
        return 0;
    }

    public void ad(int i, boolean z) {
        for (o oVar : this.mtv) {
            oVar.KN(i);
        }
        if (z) {
            for (o oVar2 : this.mtv) {
                oVar2.dxb();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.g
    /* renamed from: dQ */
    public o dL(int i, int i2) {
        int length = this.mtv.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mtw[i3] == i) {
                return this.mtv[i3];
            }
        }
        o oVar = new o(this.mtm);
        oVar.gl(this.muH);
        oVar.a(this);
        this.mtw = Arrays.copyOf(this.mtw, length + 1);
        this.mtw[length] = i;
        this.mtv = (o[]) Arrays.copyOf(this.mtv, length + 1);
        this.mtv[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dvs() {
        this.mty = true;
        this.handler.post(this.mts);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mts);
    }

    public void gl(long j) {
        this.muH = j;
        for (o oVar : this.mtv) {
            oVar.gl(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwN() {
        if (!this.released && !this.mbi && this.mty) {
            for (o oVar : this.mtv) {
                if (oVar.dwX() == null) {
                    return;
                }
            }
            dxQ();
            this.mbi = true;
            this.myj.onPrepared();
        }
    }

    private void dxQ() {
        char c;
        int length = this.mtv.length;
        int i = 0;
        int i2 = -1;
        char c2 = 0;
        while (i < length) {
            String str = this.mtv[i].dwX().sampleMimeType;
            if (com.google.android.exoplayer2.util.i.OQ(str)) {
                c = 3;
            } else if (com.google.android.exoplayer2.util.i.Qo(str)) {
                c = 2;
            } else {
                c = com.google.android.exoplayer2.util.i.Qp(str) ? (char) 1 : (char) 0;
            }
            if (c > c2) {
                i2 = i;
            } else if (c != c2 || i2 == -1) {
                c = c2;
            } else {
                i2 = -1;
                c = c2;
            }
            i++;
            c2 = c;
        }
        t dxD = this.myk.dxD();
        int i3 = dxD.length;
        this.mvQ = -1;
        this.myp = new boolean[length];
        this.myq = new boolean[length];
        t[] tVarArr = new t[length];
        for (int i4 = 0; i4 < length; i4++) {
            Format dwX = this.mtv[i4].dwX();
            String str2 = dwX.sampleMimeType;
            boolean z = com.google.android.exoplayer2.util.i.OQ(str2) || com.google.android.exoplayer2.util.i.Qo(str2);
            this.myq[i4] = z;
            this.myo = z | this.myo;
            if (i4 == i2) {
                Format[] formatArr = new Format[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    formatArr[i5] = a(dxD.KW(i5), dwX);
                }
                tVarArr[i4] = new t(formatArr);
                this.mvQ = i4;
            } else {
                tVarArr[i4] = new t(a((c2 == 3 && com.google.android.exoplayer2.util.i.Qo(dwX.sampleMimeType)) ? this.myl : null, dwX));
            }
        }
        this.maA = new u(tVarArr);
    }

    private void ae(int i, boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.myp[i] != z);
        this.myp[i] = z;
        this.mtC += z ? 1 : -1;
    }

    private static Format a(Format format, Format format2) {
        if (format != null) {
            String str = null;
            int Qt = com.google.android.exoplayer2.util.i.Qt(format2.sampleMimeType);
            if (Qt == 1) {
                str = PJ(format.codecs);
            } else if (Qt == 2) {
                str = PK(format.codecs);
            }
            return format2.a(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return format2;
    }

    private boolean a(com.google.android.exoplayer2.source.a.c cVar) {
        return cVar instanceof h;
    }

    private boolean dwQ() {
        return this.mtI != -9223372036854775807L;
    }

    private boolean gg(long j) {
        int length = this.mtv.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mtv[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.myq[i] || !this.myo)) {
                return false;
            }
            oVar.dxc();
        }
        return true;
    }

    private static String PJ(String str) {
        return bI(str, 1);
    }

    private static String PK(String str) {
        return bI(str, 2);
    }

    private static String bI(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i == com.google.android.exoplayer2.util.i.Qu(str2)) {
                if (sb.length() > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
