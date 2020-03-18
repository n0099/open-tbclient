package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class h implements com.google.android.exoplayer2.extractor.g, k, o.b, Loader.a<a>, Loader.d {
    private final Handler mas;
    private boolean mbi;
    private long mbx;
    private final com.google.android.exoplayer2.upstream.e mfN;
    private k.a msN;
    private boolean mtA;
    private boolean mtB;
    private int mtC;
    private u mtD;
    private boolean[] mtE;
    private boolean[] mtF;
    private boolean mtG;
    private long mtH;
    private int mtJ;
    private boolean mtK;
    private final int mtj;
    private final i.a mtk;
    private final c mtl;
    private final com.google.android.exoplayer2.upstream.b mtm;
    private final String mtn;
    private final long mto;
    private final b mtq;
    private com.google.android.exoplayer2.extractor.l mtu;
    private boolean mty;
    private int mtz;
    private boolean released;
    private final Uri uri;
    private final Loader mtp = new Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.e mtr = new com.google.android.exoplayer2.util.e();
    private final Runnable mts = new Runnable() { // from class: com.google.android.exoplayer2.source.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.dwN();
        }
    };
    private final Runnable mtt = new Runnable() { // from class: com.google.android.exoplayer2.source.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (!h.this.released) {
                h.this.msN.a((k.a) h.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] mtw = new int[0];
    private o[] mtv = new o[0];
    private long mtI = -9223372036854775807L;
    private long length = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface c {
        void q(long j, boolean z);
    }

    public h(Uri uri, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.extractor.e[] eVarArr, int i, Handler handler, i.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar, String str, int i2) {
        this.uri = uri;
        this.mfN = eVar;
        this.mtj = i;
        this.mas = handler;
        this.mtk = aVar;
        this.mtl = cVar;
        this.mtm = bVar;
        this.mtn = str;
        this.mto = i2;
        this.mtq = new b(eVarArr, this);
        this.mtz = i == -1 ? 3 : i;
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
        this.mtq.release();
        for (o oVar : this.mtv) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.msN = aVar;
        this.mtr.ib();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwC() throws IOException {
        dwJ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwD() {
        return this.mtD;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int i = 0;
        com.google.android.exoplayer2.util.a.checkState(this.mbi);
        int i2 = this.mtC;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) pVarArr[i3]).track;
                com.google.android.exoplayer2.util.a.checkState(this.mtE[i4]);
                this.mtC--;
                this.mtE[i4] = false;
                pVarArr[i3] = null;
            }
        }
        boolean z = this.mtA ? i2 == 0 : j != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (pVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.b.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.util.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.util.a.checkState(fVar.LM(0) == 0);
                int a2 = this.mtD.a(fVar.dxD());
                com.google.android.exoplayer2.util.a.checkState(!this.mtE[a2]);
                this.mtC++;
                this.mtE[a2] = true;
                pVarArr[i5] = new d(a2);
                zArr2[i5] = true;
                if (!z) {
                    o oVar = this.mtv[a2];
                    oVar.rewind();
                    z = oVar.a(j, true, true) == -1 && oVar.dwU() != 0;
                }
            }
        }
        if (this.mtC == 0) {
            this.mtB = false;
            if (this.mtp.isLoading()) {
                o[] oVarArr = this.mtv;
                int length = oVarArr.length;
                while (i < length) {
                    oVarArr[i].dxd();
                    i++;
                }
                this.mtp.cNV();
            } else {
                o[] oVarArr2 = this.mtv;
                int length2 = oVarArr2.length;
                while (i < length2) {
                    oVarArr2[i].reset();
                    i++;
                }
            }
        } else if (z) {
            j = gd(j);
            while (i < pVarArr.length) {
                if (pVarArr[i] != null) {
                    zArr2[i] = true;
                }
                i++;
            }
        }
        this.mtA = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gc(long j) {
        int length = this.mtv.length;
        for (int i = 0; i < length; i++) {
            this.mtv[i].c(j, false, this.mtE[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ge(long j) {
        if (this.mtK || (this.mbi && this.mtC == 0)) {
            return false;
        }
        boolean ib = this.mtr.ib();
        if (!this.mtp.isLoading()) {
            startLoading();
            return true;
        }
        return ib;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwG() {
        if (this.mtC == 0) {
            return Long.MIN_VALUE;
        }
        return dwF();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwE() {
        if (this.mtB) {
            this.mtB = false;
            return this.mtH;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwF() {
        long dwP;
        if (this.mtK) {
            return Long.MIN_VALUE;
        }
        if (dwQ()) {
            return this.mtI;
        }
        if (this.mtG) {
            int length = this.mtv.length;
            dwP = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.mtF[i]) {
                    dwP = Math.min(dwP, this.mtv[i].dwP());
                }
            }
        } else {
            dwP = dwP();
        }
        return dwP == Long.MIN_VALUE ? this.mtH : dwP;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gd(long j) {
        if (!this.mtu.dvo()) {
            j = 0;
        }
        this.mtH = j;
        this.mtB = false;
        if (dwQ() || !gg(j)) {
            this.mtI = j;
            this.mtK = false;
            if (this.mtp.isLoading()) {
                this.mtp.cNV();
            } else {
                for (o oVar : this.mtv) {
                    oVar.reset();
                }
            }
        }
        return j;
    }

    boolean KK(int i) {
        return !dwM() && (this.mtK || this.mtv[i].dwW());
    }

    void dwJ() throws IOException {
        this.mtp.LY(this.mtz);
    }

    int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwM()) {
            return -3;
        }
        return this.mtv[i].a(mVar, eVar, z, this.mtK, this.mtH);
    }

    int E(int i, long j) {
        if (dwM()) {
            return 0;
        }
        o oVar = this.mtv[i];
        if (this.mtK && j > oVar.dwP()) {
            return oVar.dwY();
        }
        int a2 = oVar.a(j, true, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean dwM() {
        return this.mtB || dwQ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2) {
        a(aVar);
        this.mtK = true;
        if (this.mbx == -9223372036854775807L) {
            long dwP = dwP();
            this.mbx = dwP == Long.MIN_VALUE ? 0L : dwP + 10000;
            this.mtl.q(this.mbx, this.mtu.dvo());
        }
        this.msN.a((k.a) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2, boolean z) {
        if (!z) {
            a(aVar);
            for (o oVar : this.mtv) {
                oVar.reset();
            }
            if (this.mtC > 0) {
                this.msN.a((k.a) this);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public int a(a aVar, long j, long j2, IOException iOException) {
        a(aVar);
        d(iOException);
        if (c(iOException)) {
            return 3;
        }
        boolean z = dwO() > this.mtJ;
        b(aVar);
        this.mtJ = dwO();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dL(int i, int i2) {
        int length = this.mtv.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mtw[i3] == i) {
                return this.mtv[i3];
            }
        }
        o oVar = new o(this.mtm);
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
        this.mtu = lVar;
        this.handler.post(this.mts);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mts);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwN() {
        if (!this.released && !this.mbi && this.mtu != null && this.mty) {
            for (o oVar : this.mtv) {
                if (oVar.dwX() == null) {
                    return;
                }
            }
            this.mtr.OG();
            int length = this.mtv.length;
            t[] tVarArr = new t[length];
            this.mtF = new boolean[length];
            this.mtE = new boolean[length];
            this.mbx = this.mtu.getDurationUs();
            for (int i = 0; i < length; i++) {
                Format dwX = this.mtv[i].dwX();
                tVarArr[i] = new t(dwX);
                String str = dwX.sampleMimeType;
                boolean z = com.google.android.exoplayer2.util.i.OQ(str) || com.google.android.exoplayer2.util.i.Qo(str);
                this.mtF[i] = z;
                this.mtG = z | this.mtG;
            }
            this.mtD = new u(tVarArr);
            if (this.mtj == -1 && this.length == -1 && this.mtu.getDurationUs() == -9223372036854775807L) {
                this.mtz = 6;
            }
            this.mbi = true;
            this.mtl.q(this.mbx, this.mtu.dvo());
            this.msN.a((k) this);
        }
    }

    private void a(a aVar) {
        if (this.length != -1) {
            return;
        }
        this.length = aVar.length;
    }

    private void startLoading() {
        a aVar = new a(this.uri, this.mfN, this.mtq, this.mtr);
        if (this.mbi) {
            com.google.android.exoplayer2.util.a.checkState(dwQ());
            if (this.mbx != -9223372036854775807L && this.mtI >= this.mbx) {
                this.mtK = true;
                this.mtI = -9223372036854775807L;
                return;
            }
            aVar.S(this.mtu.fM(this.mtI), this.mtI);
            this.mtI = -9223372036854775807L;
        }
        this.mtJ = dwO();
        this.mtp.a(aVar, this, this.mtz);
    }

    private void b(a aVar) {
        if (this.length == -1) {
            if (this.mtu == null || this.mtu.getDurationUs() == -9223372036854775807L) {
                this.mtH = 0L;
                this.mtB = this.mbi;
                for (o oVar : this.mtv) {
                    oVar.reset();
                }
                aVar.S(0L, 0L);
            }
        }
    }

    private boolean gg(long j) {
        int length = this.mtv.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mtv[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mtF[i] || !this.mtG)) {
                return false;
            }
            oVar.dxc();
        }
        return true;
    }

    private int dwO() {
        int i = 0;
        for (o oVar : this.mtv) {
            i += oVar.dwT();
        }
        return i;
    }

    private long dwP() {
        long j = Long.MIN_VALUE;
        for (o oVar : this.mtv) {
            j = Math.max(j, oVar.dwP());
        }
        return j;
    }

    private boolean dwQ() {
        return this.mtI != -9223372036854775807L;
    }

    private boolean c(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private void d(final IOException iOException) {
        if (this.mas != null && this.mtk != null) {
            this.mas.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.mtk.a(iOException);
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    private final class d implements p {
        private final int track;

        public d(int i) {
            this.track = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return h.this.KK(this.track);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwJ() throws IOException {
            h.this.dwJ();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            return h.this.a(this.track, mVar, eVar, z);
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gf(long j) {
            return h.this.E(this.track, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements Loader.c {
        private final com.google.android.exoplayer2.upstream.e mfN;
        private volatile boolean mtN;
        private long mtP;
        private final b mtq;
        private final com.google.android.exoplayer2.util.e mtr;
        private final Uri uri;
        private final com.google.android.exoplayer2.extractor.k mtM = new com.google.android.exoplayer2.extractor.k();
        private boolean mtO = true;
        private long length = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.e eVar, b bVar, com.google.android.exoplayer2.util.e eVar2) {
            this.uri = (Uri) com.google.android.exoplayer2.util.a.checkNotNull(uri);
            this.mfN = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
            this.mtq = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
            this.mtr = eVar2;
        }

        public void S(long j, long j2) {
            this.mtM.fOW = j;
            this.mtP = j2;
            this.mtO = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.mtN = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean dwR() {
            return this.mtN;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws IOException, InterruptedException {
            com.google.android.exoplayer2.extractor.b bVar;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.mtN) {
                try {
                    long j = this.mtM.fOW;
                    this.length = this.mfN.a(new com.google.android.exoplayer2.upstream.g(this.uri, j, -1L, h.this.mtn));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    com.google.android.exoplayer2.extractor.b bVar2 = new com.google.android.exoplayer2.extractor.b(this.mfN, j, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.e a = this.mtq.a(bVar2, this.mfN.getUri());
                        if (this.mtO) {
                            a.N(j, this.mtP);
                            this.mtO = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.mtN) {
                                    break;
                                }
                                this.mtr.block();
                                i = a.a(bVar2, this.mtM);
                                try {
                                    if (bVar2.getPosition() > h.this.mto + j2) {
                                        j2 = bVar2.getPosition();
                                        this.mtr.OG();
                                        h.this.handler.post(h.this.mtt);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    bVar = bVar2;
                                    th = th;
                                    if (i != 1 && bVar != null) {
                                        this.mtM.fOW = bVar.getPosition();
                                    }
                                    v.a(this.mfN);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                i = i4;
                                bVar = bVar2;
                                th = th2;
                            }
                        }
                        if (i4 == 1) {
                            i2 = 0;
                        } else {
                            if (bVar2 != null) {
                                this.mtM.fOW = bVar2.getPosition();
                            }
                            i2 = i4;
                        }
                        v.a(this.mfN);
                        i3 = i2;
                    } catch (Throwable th3) {
                        i = i3;
                        th = th3;
                        bVar = bVar2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bVar = null;
                    i = i3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {
        private final com.google.android.exoplayer2.extractor.g mgu;
        private final com.google.android.exoplayer2.extractor.e[] mtQ;
        private com.google.android.exoplayer2.extractor.e mtR;

        public b(com.google.android.exoplayer2.extractor.e[] eVarArr, com.google.android.exoplayer2.extractor.g gVar) {
            this.mtQ = eVarArr;
            this.mgu = gVar;
        }

        public com.google.android.exoplayer2.extractor.e a(com.google.android.exoplayer2.extractor.f fVar, Uri uri) throws IOException, InterruptedException {
            if (this.mtR != null) {
                return this.mtR;
            }
            com.google.android.exoplayer2.extractor.e[] eVarArr = this.mtQ;
            int length = eVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.google.android.exoplayer2.extractor.e eVar = eVarArr[i];
                try {
                } catch (EOFException e) {
                } finally {
                    fVar.dvp();
                }
                if (!eVar.a(fVar)) {
                    i++;
                } else {
                    this.mtR = eVar;
                    break;
                }
            }
            if (this.mtR == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.M(this.mtQ) + ") could read the stream.", uri);
            }
            this.mtR.a(this.mgu);
            return this.mtR;
        }

        public void release() {
            if (this.mtR != null) {
                this.mtR.release();
                this.mtR = null;
            }
        }
    }
}
