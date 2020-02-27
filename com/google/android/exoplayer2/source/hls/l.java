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
    private final int lXW;
    private u lYE;
    private boolean lZm;
    private boolean mrD;
    private boolean mrF;
    private int mrH;
    private long mrM;
    private long mrN;
    private boolean mrP;
    private final int mrp;
    private final com.google.android.exoplayer2.upstream.b mrs;
    private long msN;
    private int mtX;
    private final b.a mtz;
    private final a mwq;
    private final d mwr;
    private final Format mws;
    private Format mwu;
    private boolean mwv;
    private boolean[] mww;
    private boolean[] mwx;
    private boolean mwy;
    private boolean released;
    private final Loader mrv = new Loader("Loader:HlsSampleStreamWrapper");
    private final d.b mwt = new d.b();
    private int[] mrC = new int[0];
    private o[] mrB = new o[0];
    private final LinkedList<h> mtB = new LinkedList<>();
    private final Runnable mry = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.dwn();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes6.dex */
    public interface a extends q.a<l> {
        void a(a.C0681a c0681a);

        void onPrepared();
    }

    public l(int i, a aVar, d dVar, com.google.android.exoplayer2.upstream.b bVar, long j, Format format, int i2, b.a aVar2) {
        this.lXW = i;
        this.mwq = aVar;
        this.mwr = dVar;
        this.mrs = bVar;
        this.mws = format;
        this.mrp = i2;
        this.mtz = aVar2;
        this.mrM = j;
        this.mrN = j;
    }

    public void dxo() {
        if (!this.lZm) {
            gd(this.mrM);
        }
    }

    public void o(Format format) {
        dK(0, -1).h(format);
        this.mrD = true;
        dwn();
    }

    public void dwc() throws IOException {
        dwj();
    }

    public u dwd() {
        return this.lYE;
    }

    public boolean a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.util.a.checkState(this.lZm);
        int i = this.mrH;
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
        boolean z4 = z || (!this.mrF ? j == this.mrM : i != 0);
        com.google.android.exoplayer2.b.f dxe = this.mwr.dxe();
        boolean z5 = z4;
        int i4 = 0;
        com.google.android.exoplayer2.b.f fVar = dxe;
        while (i4 < fVarArr.length) {
            if (pVarArr[i4] == null && fVarArr[i4] != null) {
                com.google.android.exoplayer2.b.f fVar2 = fVarArr[i4];
                int a2 = this.lYE.a(fVar2.dxd());
                ae(a2, true);
                if (a2 == this.mtX) {
                    this.mwr.b(fVar2);
                    fVar = fVar2;
                }
                pVarArr[i4] = new k(this, a2);
                zArr2[i4] = true;
                if (!z5) {
                    o oVar = this.mrB[a2];
                    oVar.rewind();
                    z3 = oVar.a(j, true, true) == -1 && oVar.dwu() != 0;
                    i4++;
                    z5 = z3;
                }
            }
            z3 = z5;
            i4++;
            z5 = z3;
        }
        if (this.mrH == 0) {
            this.mwr.reset();
            this.mwu = null;
            this.mtB.clear();
            if (this.mrv.isLoading()) {
                for (o oVar2 : this.mrB) {
                    oVar2.dwD();
                }
                this.mrv.cNy();
            } else {
                dxp();
            }
        } else {
            if (!this.mtB.isEmpty() && !v.h(fVar, dxe)) {
                if (!this.mrF) {
                    fVar.g(j, j < 0 ? -j : 0L, -9223372036854775807L);
                    if (fVar.dyw() == this.mwr.dxd().m(this.mtB.getLast().mtf)) {
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
                    this.mwy = true;
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
        this.mrF = true;
        return z5;
    }

    public void gb(long j) {
        int length = this.mrB.length;
        for (int i = 0; i < length; i++) {
            this.mrB[i].c(j, false, this.mww[i]);
        }
    }

    public boolean r(long j, boolean z) {
        this.mrM = j;
        if (z || dwq() || !gf(j)) {
            this.mrN = j;
            this.mrP = false;
            this.mtB.clear();
            if (this.mrv.isLoading()) {
                this.mrv.cNy();
            } else {
                dxp();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwf() {
        if (this.mrP) {
            return Long.MIN_VALUE;
        }
        if (dwq()) {
            return this.mrN;
        }
        long j = this.mrM;
        h last = this.mtB.getLast();
        if (!last.dwP()) {
            last = this.mtB.size() > 1 ? this.mtB.get(this.mtB.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.mtj) : j;
        o[] oVarArr = this.mrB;
        int length = oVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, oVarArr[i].dwp());
            i++;
            max = max2;
        }
        return max;
    }

    public void release() {
        boolean a2 = this.mrv.a(this);
        if (this.lZm && !a2) {
            for (o oVar : this.mrB) {
                oVar.dwD();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwl() {
        dxp();
    }

    public void vI(boolean z) {
        this.mwr.vI(z);
    }

    public void a(a.C0681a c0681a, long j) {
        this.mwr.a(c0681a, j);
    }

    public boolean KE(int i) {
        return this.mrP || (!dwq() && this.mrB[i].dww());
    }

    public void dwj() throws IOException {
        this.mrv.dwj();
        this.mwr.dwj();
    }

    public int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwq()) {
            return -3;
        }
        int a2 = this.mrB[i].a(mVar, eVar, z, this.mrP, this.mrM);
        if (a2 == -4) {
            dwC();
            return a2;
        }
        return a2;
    }

    public int E(int i, long j) {
        int i2 = 0;
        if (!dwq()) {
            o oVar = this.mrB[i];
            if (this.mrP && j > oVar.dwp()) {
                i2 = oVar.dwy();
            } else {
                int a2 = oVar.a(j, true, true);
                if (a2 != -1) {
                    i2 = a2;
                }
            }
            if (i2 > 0) {
                dwC();
            }
        }
        return i2;
    }

    private void dwC() {
        if (!this.mtB.isEmpty()) {
            while (this.mtB.size() > 1 && a(this.mtB.getFirst())) {
                this.mtB.removeFirst();
            }
            h first = this.mtB.getFirst();
            Format format = first.mtf;
            if (!format.equals(this.mwu)) {
                this.mtz.b(this.lXW, format, first.mtg, first.mth, first.mti);
            }
            this.mwu = format;
        }
    }

    private boolean a(h hVar) {
        int i = hVar.uid;
        for (int i2 = 0; i2 < this.mrB.length; i2++) {
            if (this.mww[i2] && this.mrB[i2].dwv() == i) {
                return false;
            }
        }
        return true;
    }

    private void dxp() {
        for (o oVar : this.mrB) {
            oVar.reset(this.mwy);
        }
        this.mwy = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        long j2;
        h hVar;
        if (this.mrP || this.mrv.isLoading()) {
            return false;
        }
        if (dwq()) {
            hVar = null;
            j2 = this.mrN;
        } else {
            h last = this.mtB.getLast();
            j2 = last.mtj;
            hVar = last;
        }
        this.mwr.a(hVar, j, j2, this.mwt);
        boolean z = this.mwt.mtt;
        com.google.android.exoplayer2.source.a.c cVar = this.mwt.mts;
        a.C0681a c0681a = this.mwt.mvQ;
        this.mwt.clear();
        if (z) {
            this.mrN = -9223372036854775807L;
            this.mrP = true;
            return true;
        } else if (cVar == null) {
            if (c0681a != null) {
                this.mwq.a(c0681a);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.mrN = -9223372036854775807L;
                h hVar2 = (h) cVar;
                hVar2.a(this);
                this.mtB.add(hVar2);
            }
            this.mtz.b(cVar.dataSpec, cVar.type, this.lXW, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, this.mrv.a(cVar, this, this.mrp));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwg() {
        if (dwq()) {
            return this.mrN;
        }
        if (this.mrP) {
            return Long.MIN_VALUE;
        }
        return this.mtB.getLast().mtj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2) {
        this.mwr.b(cVar);
        this.mtz.c(cVar.dataSpec, cVar.type, this.lXW, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, j, j2, cVar.dwJ());
        if (!this.lZm) {
            gd(this.mrM);
        } else {
            this.mwq.a((a) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, boolean z) {
        this.mtz.d(cVar.dataSpec, cVar.type, this.lXW, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, j, j2, cVar.dwJ());
        if (!z) {
            dxp();
            if (this.mrH > 0) {
                this.mwq.a((a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, IOException iOException) {
        long dwJ = cVar.dwJ();
        boolean a2 = a(cVar);
        boolean z = false;
        if (this.mwr.a(cVar, !a2 || dwJ == 0, iOException)) {
            if (a2) {
                com.google.android.exoplayer2.util.a.checkState(this.mtB.removeLast() == cVar);
                if (this.mtB.isEmpty()) {
                    this.mrN = this.mrM;
                }
            }
            z = true;
        }
        this.mtz.b(cVar.dataSpec, cVar.type, this.lXW, cVar.mtf, cVar.mtg, cVar.mth, cVar.mti, cVar.mtj, j, j2, cVar.dwJ(), iOException, z);
        if (z) {
            if (!this.lZm) {
                gd(this.mrM);
            } else {
                this.mwq.a((a) this);
            }
            return 2;
        }
        return 0;
    }

    public void ad(int i, boolean z) {
        for (o oVar : this.mrB) {
            oVar.KH(i);
        }
        if (z) {
            for (o oVar2 : this.mrB) {
                oVar2.dwB();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.g
    /* renamed from: dP */
    public o dK(int i, int i2) {
        int length = this.mrB.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mrC[i3] == i) {
                return this.mrB[i3];
            }
        }
        o oVar = new o(this.mrs);
        oVar.gk(this.msN);
        oVar.a(this);
        this.mrC = Arrays.copyOf(this.mrC, length + 1);
        this.mrC[length] = i;
        this.mrB = (o[]) Arrays.copyOf(this.mrB, length + 1);
        this.mrB[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void duS() {
        this.mrD = true;
        this.handler.post(this.mry);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mry);
    }

    public void gk(long j) {
        this.msN = j;
        for (o oVar : this.mrB) {
            oVar.gk(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwn() {
        if (!this.released && !this.lZm && this.mrD) {
            for (o oVar : this.mrB) {
                if (oVar.dwx() == null) {
                    return;
                }
            }
            dxq();
            this.lZm = true;
            this.mwq.onPrepared();
        }
    }

    private void dxq() {
        char c;
        int length = this.mrB.length;
        int i = 0;
        int i2 = -1;
        char c2 = 0;
        while (i < length) {
            String str = this.mrB[i].dwx().sampleMimeType;
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
        t dxd = this.mwr.dxd();
        int i3 = dxd.length;
        this.mtX = -1;
        this.mww = new boolean[length];
        this.mwx = new boolean[length];
        t[] tVarArr = new t[length];
        for (int i4 = 0; i4 < length; i4++) {
            Format dwx = this.mrB[i4].dwx();
            String str2 = dwx.sampleMimeType;
            boolean z = com.google.android.exoplayer2.util.i.OQ(str2) || com.google.android.exoplayer2.util.i.Qo(str2);
            this.mwx[i4] = z;
            this.mwv = z | this.mwv;
            if (i4 == i2) {
                Format[] formatArr = new Format[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    formatArr[i5] = a(dxd.KQ(i5), dwx);
                }
                tVarArr[i4] = new t(formatArr);
                this.mtX = i4;
            } else {
                tVarArr[i4] = new t(a((c2 == 3 && com.google.android.exoplayer2.util.i.Qo(dwx.sampleMimeType)) ? this.mws : null, dwx));
            }
        }
        this.lYE = new u(tVarArr);
    }

    private void ae(int i, boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mww[i] != z);
        this.mww[i] = z;
        this.mrH += z ? 1 : -1;
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

    private boolean dwq() {
        return this.mrN != -9223372036854775807L;
    }

    private boolean gf(long j) {
        int length = this.mrB.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mrB[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mwx[i] || !this.mwv)) {
                return false;
            }
            oVar.dwC();
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
