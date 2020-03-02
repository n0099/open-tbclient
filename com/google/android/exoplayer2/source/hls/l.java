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
    private final int lXY;
    private u lYG;
    private boolean lZo;
    private boolean mrF;
    private boolean mrH;
    private int mrJ;
    private long mrO;
    private long mrP;
    private boolean mrR;
    private final int mrr;
    private final com.google.android.exoplayer2.upstream.b mru;
    private long msP;
    private final b.a mtB;
    private int mtZ;
    private boolean mwA;
    private final a mws;
    private final d mwt;
    private final Format mwu;
    private Format mww;
    private boolean mwx;
    private boolean[] mwy;
    private boolean[] mwz;
    private boolean released;
    private final Loader mrx = new Loader("Loader:HlsSampleStreamWrapper");
    private final d.b mwv = new d.b();
    private int[] mrE = new int[0];
    private o[] mrD = new o[0];
    private final LinkedList<h> mtD = new LinkedList<>();
    private final Runnable mrA = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.dwp();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes6.dex */
    public interface a extends q.a<l> {
        void a(a.C0681a c0681a);

        void onPrepared();
    }

    public l(int i, a aVar, d dVar, com.google.android.exoplayer2.upstream.b bVar, long j, Format format, int i2, b.a aVar2) {
        this.lXY = i;
        this.mws = aVar;
        this.mwt = dVar;
        this.mru = bVar;
        this.mwu = format;
        this.mrr = i2;
        this.mtB = aVar2;
        this.mrO = j;
        this.mrP = j;
    }

    public void dxq() {
        if (!this.lZo) {
            gd(this.mrO);
        }
    }

    public void o(Format format) {
        dK(0, -1).h(format);
        this.mrF = true;
        dwp();
    }

    public void dwe() throws IOException {
        dwl();
    }

    public u dwf() {
        return this.lYG;
    }

    public boolean a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.util.a.checkState(this.lZo);
        int i = this.mrJ;
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
        boolean z4 = z || (!this.mrH ? j == this.mrO : i != 0);
        com.google.android.exoplayer2.b.f dxg = this.mwt.dxg();
        boolean z5 = z4;
        int i4 = 0;
        com.google.android.exoplayer2.b.f fVar = dxg;
        while (i4 < fVarArr.length) {
            if (pVarArr[i4] == null && fVarArr[i4] != null) {
                com.google.android.exoplayer2.b.f fVar2 = fVarArr[i4];
                int a2 = this.lYG.a(fVar2.dxf());
                ae(a2, true);
                if (a2 == this.mtZ) {
                    this.mwt.b(fVar2);
                    fVar = fVar2;
                }
                pVarArr[i4] = new k(this, a2);
                zArr2[i4] = true;
                if (!z5) {
                    o oVar = this.mrD[a2];
                    oVar.rewind();
                    z3 = oVar.a(j, true, true) == -1 && oVar.dww() != 0;
                    i4++;
                    z5 = z3;
                }
            }
            z3 = z5;
            i4++;
            z5 = z3;
        }
        if (this.mrJ == 0) {
            this.mwt.reset();
            this.mww = null;
            this.mtD.clear();
            if (this.mrx.isLoading()) {
                for (o oVar2 : this.mrD) {
                    oVar2.dwF();
                }
                this.mrx.cNA();
            } else {
                dxr();
            }
        } else {
            if (!this.mtD.isEmpty() && !v.h(fVar, dxg)) {
                if (!this.mrH) {
                    fVar.g(j, j < 0 ? -j : 0L, -9223372036854775807L);
                    if (fVar.dyy() == this.mwt.dxf().m(this.mtD.getLast().mth)) {
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
                    this.mwA = true;
                }
            }
            if (z5) {
                r(j, z);
                for (int i5 = 0; i5 < pVarArr.length; i5++) {
                    if (pVarArr[i5] != null) {
                        zArr2[i5] = true;
                    }
                }
            }
        }
        this.mrH = true;
        return z5;
    }

    public void gb(long j) {
        int length = this.mrD.length;
        for (int i = 0; i < length; i++) {
            this.mrD[i].c(j, false, this.mwy[i]);
        }
    }

    public boolean r(long j, boolean z) {
        this.mrO = j;
        if (z || dws() || !gf(j)) {
            this.mrP = j;
            this.mrR = false;
            this.mtD.clear();
            if (this.mrx.isLoading()) {
                this.mrx.cNA();
            } else {
                dxr();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwh() {
        if (this.mrR) {
            return Long.MIN_VALUE;
        }
        if (dws()) {
            return this.mrP;
        }
        long j = this.mrO;
        h last = this.mtD.getLast();
        if (!last.dwR()) {
            last = this.mtD.size() > 1 ? this.mtD.get(this.mtD.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.mtl) : j;
        o[] oVarArr = this.mrD;
        int length = oVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, oVarArr[i].dwr());
            i++;
            max = max2;
        }
        return max;
    }

    public void release() {
        boolean a2 = this.mrx.a(this);
        if (this.lZo && !a2) {
            for (o oVar : this.mrD) {
                oVar.dwF();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwn() {
        dxr();
    }

    public void vI(boolean z) {
        this.mwt.vI(z);
    }

    public void a(a.C0681a c0681a, long j) {
        this.mwt.a(c0681a, j);
    }

    public boolean KE(int i) {
        return this.mrR || (!dws() && this.mrD[i].dwy());
    }

    public void dwl() throws IOException {
        this.mrx.dwl();
        this.mwt.dwl();
    }

    public int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dws()) {
            return -3;
        }
        int a2 = this.mrD[i].a(mVar, eVar, z, this.mrR, this.mrO);
        if (a2 == -4) {
            dwE();
            return a2;
        }
        return a2;
    }

    public int E(int i, long j) {
        int i2 = 0;
        if (!dws()) {
            o oVar = this.mrD[i];
            if (this.mrR && j > oVar.dwr()) {
                i2 = oVar.dwA();
            } else {
                int a2 = oVar.a(j, true, true);
                if (a2 != -1) {
                    i2 = a2;
                }
            }
            if (i2 > 0) {
                dwE();
            }
        }
        return i2;
    }

    private void dwE() {
        if (!this.mtD.isEmpty()) {
            while (this.mtD.size() > 1 && a(this.mtD.getFirst())) {
                this.mtD.removeFirst();
            }
            h first = this.mtD.getFirst();
            Format format = first.mth;
            if (!format.equals(this.mww)) {
                this.mtB.b(this.lXY, format, first.mti, first.mtj, first.mtk);
            }
            this.mww = format;
        }
    }

    private boolean a(h hVar) {
        int i = hVar.uid;
        for (int i2 = 0; i2 < this.mrD.length; i2++) {
            if (this.mwy[i2] && this.mrD[i2].dwx() == i) {
                return false;
            }
        }
        return true;
    }

    private void dxr() {
        for (o oVar : this.mrD) {
            oVar.reset(this.mwA);
        }
        this.mwA = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        long j2;
        h hVar;
        if (this.mrR || this.mrx.isLoading()) {
            return false;
        }
        if (dws()) {
            hVar = null;
            j2 = this.mrP;
        } else {
            h last = this.mtD.getLast();
            j2 = last.mtl;
            hVar = last;
        }
        this.mwt.a(hVar, j, j2, this.mwv);
        boolean z = this.mwv.mtv;
        com.google.android.exoplayer2.source.a.c cVar = this.mwv.mtu;
        a.C0681a c0681a = this.mwv.mvS;
        this.mwv.clear();
        if (z) {
            this.mrP = -9223372036854775807L;
            this.mrR = true;
            return true;
        } else if (cVar == null) {
            if (c0681a != null) {
                this.mws.a(c0681a);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.mrP = -9223372036854775807L;
                h hVar2 = (h) cVar;
                hVar2.a(this);
                this.mtD.add(hVar2);
            }
            this.mtB.b(cVar.dataSpec, cVar.type, this.lXY, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, this.mrx.a(cVar, this, this.mrr));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwi() {
        if (dws()) {
            return this.mrP;
        }
        if (this.mrR) {
            return Long.MIN_VALUE;
        }
        return this.mtD.getLast().mtl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2) {
        this.mwt.b(cVar);
        this.mtB.c(cVar.dataSpec, cVar.type, this.lXY, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, j, j2, cVar.dwL());
        if (!this.lZo) {
            gd(this.mrO);
        } else {
            this.mws.a((a) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, boolean z) {
        this.mtB.d(cVar.dataSpec, cVar.type, this.lXY, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, j, j2, cVar.dwL());
        if (!z) {
            dxr();
            if (this.mrJ > 0) {
                this.mws.a((a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, IOException iOException) {
        long dwL = cVar.dwL();
        boolean a2 = a(cVar);
        boolean z = false;
        if (this.mwt.a(cVar, !a2 || dwL == 0, iOException)) {
            if (a2) {
                com.google.android.exoplayer2.util.a.checkState(this.mtD.removeLast() == cVar);
                if (this.mtD.isEmpty()) {
                    this.mrP = this.mrO;
                }
            }
            z = true;
        }
        this.mtB.b(cVar.dataSpec, cVar.type, this.lXY, cVar.mth, cVar.mti, cVar.mtj, cVar.mtk, cVar.mtl, j, j2, cVar.dwL(), iOException, z);
        if (z) {
            if (!this.lZo) {
                gd(this.mrO);
            } else {
                this.mws.a((a) this);
            }
            return 2;
        }
        return 0;
    }

    public void ad(int i, boolean z) {
        for (o oVar : this.mrD) {
            oVar.KH(i);
        }
        if (z) {
            for (o oVar2 : this.mrD) {
                oVar2.dwD();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.g
    /* renamed from: dP */
    public o dK(int i, int i2) {
        int length = this.mrD.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mrE[i3] == i) {
                return this.mrD[i3];
            }
        }
        o oVar = new o(this.mru);
        oVar.gk(this.msP);
        oVar.a(this);
        this.mrE = Arrays.copyOf(this.mrE, length + 1);
        this.mrE[length] = i;
        this.mrD = (o[]) Arrays.copyOf(this.mrD, length + 1);
        this.mrD[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void duU() {
        this.mrF = true;
        this.handler.post(this.mrA);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mrA);
    }

    public void gk(long j) {
        this.msP = j;
        for (o oVar : this.mrD) {
            oVar.gk(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwp() {
        if (!this.released && !this.lZo && this.mrF) {
            for (o oVar : this.mrD) {
                if (oVar.dwz() == null) {
                    return;
                }
            }
            dxs();
            this.lZo = true;
            this.mws.onPrepared();
        }
    }

    private void dxs() {
        char c;
        int length = this.mrD.length;
        int i = 0;
        int i2 = -1;
        char c2 = 0;
        while (i < length) {
            String str = this.mrD[i].dwz().sampleMimeType;
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
        t dxf = this.mwt.dxf();
        int i3 = dxf.length;
        this.mtZ = -1;
        this.mwy = new boolean[length];
        this.mwz = new boolean[length];
        t[] tVarArr = new t[length];
        for (int i4 = 0; i4 < length; i4++) {
            Format dwz = this.mrD[i4].dwz();
            String str2 = dwz.sampleMimeType;
            boolean z = com.google.android.exoplayer2.util.i.OQ(str2) || com.google.android.exoplayer2.util.i.Qo(str2);
            this.mwz[i4] = z;
            this.mwx = z | this.mwx;
            if (i4 == i2) {
                Format[] formatArr = new Format[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    formatArr[i5] = a(dxf.KQ(i5), dwz);
                }
                tVarArr[i4] = new t(formatArr);
                this.mtZ = i4;
            } else {
                tVarArr[i4] = new t(a((c2 == 3 && com.google.android.exoplayer2.util.i.Qo(dwz.sampleMimeType)) ? this.mwu : null, dwz));
            }
        }
        this.lYG = new u(tVarArr);
    }

    private void ae(int i, boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mwy[i] != z);
        this.mwy[i] = z;
        this.mrJ += z ? 1 : -1;
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

    private boolean dws() {
        return this.mrP != -9223372036854775807L;
    }

    private boolean gf(long j) {
        int length = this.mrD.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mrD[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mwz[i] || !this.mwx)) {
                return false;
            }
            oVar.dwE();
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
