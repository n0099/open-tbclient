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
    private u lYR;
    private final int lYj;
    private boolean lZz;
    private final int mrC;
    private final com.google.android.exoplayer2.upstream.b mrF;
    private boolean mrQ;
    private boolean mrS;
    private int mrU;
    private long mrZ;
    private long msa;
    private boolean msc;
    private final b.a mtM;
    private long mta;
    private int muk;
    private final a mwD;
    private final d mwE;
    private final Format mwF;
    private Format mwH;
    private boolean mwI;
    private boolean[] mwJ;
    private boolean[] mwK;
    private boolean mwL;
    private boolean released;
    private final Loader mrI = new Loader("Loader:HlsSampleStreamWrapper");
    private final d.b mwG = new d.b();
    private int[] mrP = new int[0];
    private o[] mrO = new o[0];
    private final LinkedList<h> mtO = new LinkedList<>();
    private final Runnable mrL = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.l.1
        @Override // java.lang.Runnable
        public void run() {
            l.this.dwq();
        }
    };
    private final Handler handler = new Handler();

    /* loaded from: classes6.dex */
    public interface a extends q.a<l> {
        void a(a.C0681a c0681a);

        void onPrepared();
    }

    public l(int i, a aVar, d dVar, com.google.android.exoplayer2.upstream.b bVar, long j, Format format, int i2, b.a aVar2) {
        this.lYj = i;
        this.mwD = aVar;
        this.mwE = dVar;
        this.mrF = bVar;
        this.mwF = format;
        this.mrC = i2;
        this.mtM = aVar2;
        this.mrZ = j;
        this.msa = j;
    }

    public void dxr() {
        if (!this.lZz) {
            gd(this.mrZ);
        }
    }

    public void o(Format format) {
        dK(0, -1).h(format);
        this.mrQ = true;
        dwq();
    }

    public void dwf() throws IOException {
        dwm();
    }

    public u dwg() {
        return this.lYR;
    }

    public boolean a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.util.a.checkState(this.lZz);
        int i = this.mrU;
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
        boolean z4 = z || (!this.mrS ? j == this.mrZ : i != 0);
        com.google.android.exoplayer2.b.f dxh = this.mwE.dxh();
        boolean z5 = z4;
        int i4 = 0;
        com.google.android.exoplayer2.b.f fVar = dxh;
        while (i4 < fVarArr.length) {
            if (pVarArr[i4] == null && fVarArr[i4] != null) {
                com.google.android.exoplayer2.b.f fVar2 = fVarArr[i4];
                int a2 = this.lYR.a(fVar2.dxg());
                ae(a2, true);
                if (a2 == this.muk) {
                    this.mwE.b(fVar2);
                    fVar = fVar2;
                }
                pVarArr[i4] = new k(this, a2);
                zArr2[i4] = true;
                if (!z5) {
                    o oVar = this.mrO[a2];
                    oVar.rewind();
                    z3 = oVar.a(j, true, true) == -1 && oVar.dwx() != 0;
                    i4++;
                    z5 = z3;
                }
            }
            z3 = z5;
            i4++;
            z5 = z3;
        }
        if (this.mrU == 0) {
            this.mwE.reset();
            this.mwH = null;
            this.mtO.clear();
            if (this.mrI.isLoading()) {
                for (o oVar2 : this.mrO) {
                    oVar2.dwG();
                }
                this.mrI.cNB();
            } else {
                dxs();
            }
        } else {
            if (!this.mtO.isEmpty() && !v.h(fVar, dxh)) {
                if (!this.mrS) {
                    fVar.g(j, j < 0 ? -j : 0L, -9223372036854775807L);
                    if (fVar.dyz() == this.mwE.dxg().m(this.mtO.getLast().mts)) {
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
                    this.mwL = true;
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
        this.mrS = true;
        return z5;
    }

    public void gb(long j) {
        int length = this.mrO.length;
        for (int i = 0; i < length; i++) {
            this.mrO[i].c(j, false, this.mwJ[i]);
        }
    }

    public boolean r(long j, boolean z) {
        this.mrZ = j;
        if (z || dwt() || !gf(j)) {
            this.msa = j;
            this.msc = false;
            this.mtO.clear();
            if (this.mrI.isLoading()) {
                this.mrI.cNB();
            } else {
                dxs();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwi() {
        if (this.msc) {
            return Long.MIN_VALUE;
        }
        if (dwt()) {
            return this.msa;
        }
        long j = this.mrZ;
        h last = this.mtO.getLast();
        if (!last.dwS()) {
            last = this.mtO.size() > 1 ? this.mtO.get(this.mtO.size() - 2) : null;
        }
        long max = last != null ? Math.max(j, last.mtw) : j;
        o[] oVarArr = this.mrO;
        int length = oVarArr.length;
        int i = 0;
        while (i < length) {
            long max2 = Math.max(max, oVarArr[i].dws());
            i++;
            max = max2;
        }
        return max;
    }

    public void release() {
        boolean a2 = this.mrI.a(this);
        if (this.lZz && !a2) {
            for (o oVar : this.mrO) {
                oVar.dwG();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dwo() {
        dxs();
    }

    public void vI(boolean z) {
        this.mwE.vI(z);
    }

    public void a(a.C0681a c0681a, long j) {
        this.mwE.a(c0681a, j);
    }

    public boolean KE(int i) {
        return this.msc || (!dwt() && this.mrO[i].dwz());
    }

    public void dwm() throws IOException {
        this.mrI.dwm();
        this.mwE.dwm();
    }

    public int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwt()) {
            return -3;
        }
        int a2 = this.mrO[i].a(mVar, eVar, z, this.msc, this.mrZ);
        if (a2 == -4) {
            dwF();
            return a2;
        }
        return a2;
    }

    public int E(int i, long j) {
        int i2 = 0;
        if (!dwt()) {
            o oVar = this.mrO[i];
            if (this.msc && j > oVar.dws()) {
                i2 = oVar.dwB();
            } else {
                int a2 = oVar.a(j, true, true);
                if (a2 != -1) {
                    i2 = a2;
                }
            }
            if (i2 > 0) {
                dwF();
            }
        }
        return i2;
    }

    private void dwF() {
        if (!this.mtO.isEmpty()) {
            while (this.mtO.size() > 1 && a(this.mtO.getFirst())) {
                this.mtO.removeFirst();
            }
            h first = this.mtO.getFirst();
            Format format = first.mts;
            if (!format.equals(this.mwH)) {
                this.mtM.b(this.lYj, format, first.mtt, first.mtu, first.mtv);
            }
            this.mwH = format;
        }
    }

    private boolean a(h hVar) {
        int i = hVar.uid;
        for (int i2 = 0; i2 < this.mrO.length; i2++) {
            if (this.mwJ[i2] && this.mrO[i2].dwy() == i) {
                return false;
            }
        }
        return true;
    }

    private void dxs() {
        for (o oVar : this.mrO) {
            oVar.reset(this.mwL);
        }
        this.mwL = false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        long j2;
        h hVar;
        if (this.msc || this.mrI.isLoading()) {
            return false;
        }
        if (dwt()) {
            hVar = null;
            j2 = this.msa;
        } else {
            h last = this.mtO.getLast();
            j2 = last.mtw;
            hVar = last;
        }
        this.mwE.a(hVar, j, j2, this.mwG);
        boolean z = this.mwG.mtH;
        com.google.android.exoplayer2.source.a.c cVar = this.mwG.mtG;
        a.C0681a c0681a = this.mwG.mwd;
        this.mwG.clear();
        if (z) {
            this.msa = -9223372036854775807L;
            this.msc = true;
            return true;
        } else if (cVar == null) {
            if (c0681a != null) {
                this.mwD.a(c0681a);
            }
            return false;
        } else {
            if (a(cVar)) {
                this.msa = -9223372036854775807L;
                h hVar2 = (h) cVar;
                hVar2.a(this);
                this.mtO.add(hVar2);
            }
            this.mtM.b(cVar.dataSpec, cVar.type, this.lYj, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, this.mrI.a(cVar, this, this.mrC));
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.source.q
    public long dwj() {
        if (dwt()) {
            return this.msa;
        }
        if (this.msc) {
            return Long.MIN_VALUE;
        }
        return this.mtO.getLast().mtw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2) {
        this.mwE.b(cVar);
        this.mtM.c(cVar.dataSpec, cVar.type, this.lYj, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, j, j2, cVar.dwM());
        if (!this.lZz) {
            gd(this.mrZ);
        } else {
            this.mwD.a((a) this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, boolean z) {
        this.mtM.d(cVar.dataSpec, cVar.type, this.lYj, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, j, j2, cVar.dwM());
        if (!z) {
            dxs();
            if (this.mrU > 0) {
                this.mwD.a((a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(com.google.android.exoplayer2.source.a.c cVar, long j, long j2, IOException iOException) {
        long dwM = cVar.dwM();
        boolean a2 = a(cVar);
        boolean z = false;
        if (this.mwE.a(cVar, !a2 || dwM == 0, iOException)) {
            if (a2) {
                com.google.android.exoplayer2.util.a.checkState(this.mtO.removeLast() == cVar);
                if (this.mtO.isEmpty()) {
                    this.msa = this.mrZ;
                }
            }
            z = true;
        }
        this.mtM.b(cVar.dataSpec, cVar.type, this.lYj, cVar.mts, cVar.mtt, cVar.mtu, cVar.mtv, cVar.mtw, j, j2, cVar.dwM(), iOException, z);
        if (z) {
            if (!this.lZz) {
                gd(this.mrZ);
            } else {
                this.mwD.a((a) this);
            }
            return 2;
        }
        return 0;
    }

    public void ad(int i, boolean z) {
        for (o oVar : this.mrO) {
            oVar.KH(i);
        }
        if (z) {
            for (o oVar2 : this.mrO) {
                oVar2.dwE();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.extractor.g
    /* renamed from: dP */
    public o dK(int i, int i2) {
        int length = this.mrO.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mrP[i3] == i) {
                return this.mrO[i3];
            }
        }
        o oVar = new o(this.mrF);
        oVar.gk(this.mta);
        oVar.a(this);
        this.mrP = Arrays.copyOf(this.mrP, length + 1);
        this.mrP[length] = i;
        this.mrO = (o[]) Arrays.copyOf(this.mrO, length + 1);
        this.mrO[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void duV() {
        this.mrQ = true;
        this.handler.post(this.mrL);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mrL);
    }

    public void gk(long j) {
        this.mta = j;
        for (o oVar : this.mrO) {
            oVar.gk(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwq() {
        if (!this.released && !this.lZz && this.mrQ) {
            for (o oVar : this.mrO) {
                if (oVar.dwA() == null) {
                    return;
                }
            }
            dxt();
            this.lZz = true;
            this.mwD.onPrepared();
        }
    }

    private void dxt() {
        char c;
        int length = this.mrO.length;
        int i = 0;
        int i2 = -1;
        char c2 = 0;
        while (i < length) {
            String str = this.mrO[i].dwA().sampleMimeType;
            if (com.google.android.exoplayer2.util.i.OR(str)) {
                c = 3;
            } else if (com.google.android.exoplayer2.util.i.Qp(str)) {
                c = 2;
            } else {
                c = com.google.android.exoplayer2.util.i.Qq(str) ? (char) 1 : (char) 0;
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
        t dxg = this.mwE.dxg();
        int i3 = dxg.length;
        this.muk = -1;
        this.mwJ = new boolean[length];
        this.mwK = new boolean[length];
        t[] tVarArr = new t[length];
        for (int i4 = 0; i4 < length; i4++) {
            Format dwA = this.mrO[i4].dwA();
            String str2 = dwA.sampleMimeType;
            boolean z = com.google.android.exoplayer2.util.i.OR(str2) || com.google.android.exoplayer2.util.i.Qp(str2);
            this.mwK[i4] = z;
            this.mwI = z | this.mwI;
            if (i4 == i2) {
                Format[] formatArr = new Format[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    formatArr[i5] = a(dxg.KQ(i5), dwA);
                }
                tVarArr[i4] = new t(formatArr);
                this.muk = i4;
            } else {
                tVarArr[i4] = new t(a((c2 == 3 && com.google.android.exoplayer2.util.i.Qp(dwA.sampleMimeType)) ? this.mwF : null, dwA));
            }
        }
        this.lYR = new u(tVarArr);
    }

    private void ae(int i, boolean z) {
        com.google.android.exoplayer2.util.a.checkState(this.mwJ[i] != z);
        this.mwJ[i] = z;
        this.mrU += z ? 1 : -1;
    }

    private static Format a(Format format, Format format2) {
        if (format != null) {
            String str = null;
            int Qu = com.google.android.exoplayer2.util.i.Qu(format2.sampleMimeType);
            if (Qu == 1) {
                str = PK(format.codecs);
            } else if (Qu == 2) {
                str = PL(format.codecs);
            }
            return format2.a(format.id, str, format.bitrate, format.width, format.height, format.selectionFlags, format.language);
        }
        return format2;
    }

    private boolean a(com.google.android.exoplayer2.source.a.c cVar) {
        return cVar instanceof h;
    }

    private boolean dwt() {
        return this.msa != -9223372036854775807L;
    }

    private boolean gf(long j) {
        int length = this.mrO.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mrO[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mwK[i] || !this.mwI)) {
                return false;
            }
            oVar.dwF();
        }
        return true;
    }

    private static String PK(String str) {
        return bI(str, 1);
    }

    private static String PL(String str) {
        return bI(str, 2);
    }

    private static String bI(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i == com.google.android.exoplayer2.util.i.Qv(str2)) {
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
