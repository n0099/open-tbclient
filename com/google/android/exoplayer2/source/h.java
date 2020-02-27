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
    private final Handler lYx;
    private long lZB;
    private boolean lZm;
    private final com.google.android.exoplayer2.upstream.e mdU;
    private k.a mqT;
    private com.google.android.exoplayer2.extractor.l mrA;
    private boolean mrD;
    private int mrE;
    private boolean mrF;
    private boolean mrG;
    private int mrH;
    private u mrI;
    private boolean[] mrJ;
    private boolean[] mrK;
    private boolean mrL;
    private long mrM;
    private int mrO;
    private boolean mrP;
    private final int mrp;
    private final i.a mrq;
    private final c mrr;
    private final com.google.android.exoplayer2.upstream.b mrs;
    private final String mrt;
    private final long mru;
    private final b mrw;
    private boolean released;
    private final Uri uri;
    private final Loader mrv = new Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.e mrx = new com.google.android.exoplayer2.util.e();
    private final Runnable mry = new Runnable() { // from class: com.google.android.exoplayer2.source.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.dwn();
        }
    };
    private final Runnable mrz = new Runnable() { // from class: com.google.android.exoplayer2.source.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (!h.this.released) {
                h.this.mqT.a((k.a) h.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] mrC = new int[0];
    private o[] mrB = new o[0];
    private long mrN = -9223372036854775807L;
    private long length = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface c {
        void p(long j, boolean z);
    }

    public h(Uri uri, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.extractor.e[] eVarArr, int i, Handler handler, i.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar, String str, int i2) {
        this.uri = uri;
        this.mdU = eVar;
        this.mrp = i;
        this.lYx = handler;
        this.mrq = aVar;
        this.mrr = cVar;
        this.mrs = bVar;
        this.mrt = str;
        this.mru = i2;
        this.mrw = new b(eVarArr, this);
        this.mrE = i == -1 ? 3 : i;
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
        this.mrw.release();
        for (o oVar : this.mrB) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqT = aVar;
        this.mrx.ib();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwc() throws IOException {
        dwj();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwd() {
        return this.mrI;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int i = 0;
        com.google.android.exoplayer2.util.a.checkState(this.lZm);
        int i2 = this.mrH;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) pVarArr[i3]).track;
                com.google.android.exoplayer2.util.a.checkState(this.mrJ[i4]);
                this.mrH--;
                this.mrJ[i4] = false;
                pVarArr[i3] = null;
            }
        }
        boolean z = this.mrF ? i2 == 0 : j != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (pVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.b.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.util.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.util.a.checkState(fVar.LG(0) == 0);
                int a2 = this.mrI.a(fVar.dxd());
                com.google.android.exoplayer2.util.a.checkState(!this.mrJ[a2]);
                this.mrH++;
                this.mrJ[a2] = true;
                pVarArr[i5] = new d(a2);
                zArr2[i5] = true;
                if (!z) {
                    o oVar = this.mrB[a2];
                    oVar.rewind();
                    z = oVar.a(j, true, true) == -1 && oVar.dwu() != 0;
                }
            }
        }
        if (this.mrH == 0) {
            this.mrG = false;
            if (this.mrv.isLoading()) {
                o[] oVarArr = this.mrB;
                int length = oVarArr.length;
                while (i < length) {
                    oVarArr[i].dwD();
                    i++;
                }
                this.mrv.cNy();
            } else {
                o[] oVarArr2 = this.mrB;
                int length2 = oVarArr2.length;
                while (i < length2) {
                    oVarArr2[i].reset();
                    i++;
                }
            }
        } else if (z) {
            j = gc(j);
            while (i < pVarArr.length) {
                if (pVarArr[i] != null) {
                    zArr2[i] = true;
                }
                i++;
            }
        }
        this.mrF = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        int length = this.mrB.length;
        for (int i = 0; i < length; i++) {
            this.mrB[i].c(j, false, this.mrJ[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        if (this.mrP || (this.lZm && this.mrH == 0)) {
            return false;
        }
        boolean ib = this.mrx.ib();
        if (!this.mrv.isLoading()) {
            startLoading();
            return true;
        }
        return ib;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwg() {
        if (this.mrH == 0) {
            return Long.MIN_VALUE;
        }
        return dwf();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwe() {
        if (this.mrG) {
            this.mrG = false;
            return this.mrM;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwf() {
        long dwp;
        if (this.mrP) {
            return Long.MIN_VALUE;
        }
        if (dwq()) {
            return this.mrN;
        }
        if (this.mrL) {
            int length = this.mrB.length;
            dwp = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.mrK[i]) {
                    dwp = Math.min(dwp, this.mrB[i].dwp());
                }
            }
        } else {
            dwp = dwp();
        }
        return dwp == Long.MIN_VALUE ? this.mrM : dwp;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        if (!this.mrA.duO()) {
            j = 0;
        }
        this.mrM = j;
        this.mrG = false;
        if (dwq() || !gf(j)) {
            this.mrN = j;
            this.mrP = false;
            if (this.mrv.isLoading()) {
                this.mrv.cNy();
            } else {
                for (o oVar : this.mrB) {
                    oVar.reset();
                }
            }
        }
        return j;
    }

    boolean KE(int i) {
        return !dwm() && (this.mrP || this.mrB[i].dww());
    }

    void dwj() throws IOException {
        this.mrv.LS(this.mrE);
    }

    int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwm()) {
            return -3;
        }
        return this.mrB[i].a(mVar, eVar, z, this.mrP, this.mrM);
    }

    int E(int i, long j) {
        if (dwm()) {
            return 0;
        }
        o oVar = this.mrB[i];
        if (this.mrP && j > oVar.dwp()) {
            return oVar.dwy();
        }
        int a2 = oVar.a(j, true, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean dwm() {
        return this.mrG || dwq();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2) {
        a(aVar);
        this.mrP = true;
        if (this.lZB == -9223372036854775807L) {
            long dwp = dwp();
            this.lZB = dwp == Long.MIN_VALUE ? 0L : dwp + 10000;
            this.mrr.p(this.lZB, this.mrA.duO());
        }
        this.mqT.a((k.a) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2, boolean z) {
        if (!z) {
            a(aVar);
            for (o oVar : this.mrB) {
                oVar.reset();
            }
            if (this.mrH > 0) {
                this.mqT.a((k.a) this);
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
        boolean z = dwo() > this.mrO;
        b(aVar);
        this.mrO = dwo();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        int length = this.mrB.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mrC[i3] == i) {
                return this.mrB[i3];
            }
        }
        o oVar = new o(this.mrs);
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
        this.mrA = lVar;
        this.handler.post(this.mry);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwn() {
        if (!this.released && !this.lZm && this.mrA != null && this.mrD) {
            for (o oVar : this.mrB) {
                if (oVar.dwx() == null) {
                    return;
                }
            }
            this.mrx.OB();
            int length = this.mrB.length;
            t[] tVarArr = new t[length];
            this.mrK = new boolean[length];
            this.mrJ = new boolean[length];
            this.lZB = this.mrA.getDurationUs();
            for (int i = 0; i < length; i++) {
                Format dwx = this.mrB[i].dwx();
                tVarArr[i] = new t(dwx);
                String str = dwx.sampleMimeType;
                boolean z = com.google.android.exoplayer2.util.i.OQ(str) || com.google.android.exoplayer2.util.i.Qo(str);
                this.mrK[i] = z;
                this.mrL = z | this.mrL;
            }
            this.mrI = new u(tVarArr);
            if (this.mrp == -1 && this.length == -1 && this.mrA.getDurationUs() == -9223372036854775807L) {
                this.mrE = 6;
            }
            this.lZm = true;
            this.mrr.p(this.lZB, this.mrA.duO());
            this.mqT.a((k) this);
        }
    }

    private void a(a aVar) {
        if (this.length != -1) {
            return;
        }
        this.length = aVar.length;
    }

    private void startLoading() {
        a aVar = new a(this.uri, this.mdU, this.mrw, this.mrx);
        if (this.lZm) {
            com.google.android.exoplayer2.util.a.checkState(dwq());
            if (this.lZB != -9223372036854775807L && this.mrN >= this.lZB) {
                this.mrP = true;
                this.mrN = -9223372036854775807L;
                return;
            }
            aVar.S(this.mrA.fL(this.mrN), this.mrN);
            this.mrN = -9223372036854775807L;
        }
        this.mrO = dwo();
        this.mrv.a(aVar, this, this.mrE);
    }

    private void b(a aVar) {
        if (this.length == -1) {
            if (this.mrA == null || this.mrA.getDurationUs() == -9223372036854775807L) {
                this.mrM = 0L;
                this.mrG = this.lZm;
                for (o oVar : this.mrB) {
                    oVar.reset();
                }
                aVar.S(0L, 0L);
            }
        }
    }

    private boolean gf(long j) {
        int length = this.mrB.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mrB[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mrK[i] || !this.mrL)) {
                return false;
            }
            oVar.dwC();
        }
        return true;
    }

    private int dwo() {
        int i = 0;
        for (o oVar : this.mrB) {
            i += oVar.dwt();
        }
        return i;
    }

    private long dwp() {
        long j = Long.MIN_VALUE;
        for (o oVar : this.mrB) {
            j = Math.max(j, oVar.dwp());
        }
        return j;
    }

    private boolean dwq() {
        return this.mrN != -9223372036854775807L;
    }

    private boolean c(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private void d(final IOException iOException) {
        if (this.lYx != null && this.mrq != null) {
            this.lYx.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.mrq.a(iOException);
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
            return h.this.KE(this.track);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dwj() throws IOException {
            h.this.dwj();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            return h.this.a(this.track, mVar, eVar, z);
        }

        @Override // com.google.android.exoplayer2.source.p
        public int ge(long j) {
            return h.this.E(this.track, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public final class a implements Loader.c {
        private final com.google.android.exoplayer2.upstream.e mdU;
        private volatile boolean mrS;
        private long mrU;
        private final b mrw;
        private final com.google.android.exoplayer2.util.e mrx;
        private final Uri uri;
        private final com.google.android.exoplayer2.extractor.k mrR = new com.google.android.exoplayer2.extractor.k();
        private boolean mrT = true;
        private long length = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.e eVar, b bVar, com.google.android.exoplayer2.util.e eVar2) {
            this.uri = (Uri) com.google.android.exoplayer2.util.a.checkNotNull(uri);
            this.mdU = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
            this.mrw = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
            this.mrx = eVar2;
        }

        public void S(long j, long j2) {
            this.mrR.fNZ = j;
            this.mrU = j2;
            this.mrT = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.mrS = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean dwr() {
            return this.mrS;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws IOException, InterruptedException {
            com.google.android.exoplayer2.extractor.b bVar;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.mrS) {
                try {
                    long j = this.mrR.fNZ;
                    this.length = this.mdU.a(new com.google.android.exoplayer2.upstream.g(this.uri, j, -1L, h.this.mrt));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    com.google.android.exoplayer2.extractor.b bVar2 = new com.google.android.exoplayer2.extractor.b(this.mdU, j, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.e a = this.mrw.a(bVar2, this.mdU.getUri());
                        if (this.mrT) {
                            a.N(j, this.mrU);
                            this.mrT = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.mrS) {
                                    break;
                                }
                                this.mrx.block();
                                i = a.a(bVar2, this.mrR);
                                try {
                                    if (bVar2.getPosition() > h.this.mru + j2) {
                                        j2 = bVar2.getPosition();
                                        this.mrx.OB();
                                        h.this.handler.post(h.this.mrz);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    bVar = bVar2;
                                    th = th;
                                    if (i != 1 && bVar != null) {
                                        this.mrR.fNZ = bVar.getPosition();
                                    }
                                    v.a(this.mdU);
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
                                this.mrR.fNZ = bVar2.getPosition();
                            }
                            i2 = i4;
                        }
                        v.a(this.mdU);
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
        private final com.google.android.exoplayer2.extractor.g meB;
        private final com.google.android.exoplayer2.extractor.e[] mrV;
        private com.google.android.exoplayer2.extractor.e mrW;

        public b(com.google.android.exoplayer2.extractor.e[] eVarArr, com.google.android.exoplayer2.extractor.g gVar) {
            this.mrV = eVarArr;
            this.meB = gVar;
        }

        public com.google.android.exoplayer2.extractor.e a(com.google.android.exoplayer2.extractor.f fVar, Uri uri) throws IOException, InterruptedException {
            if (this.mrW != null) {
                return this.mrW;
            }
            com.google.android.exoplayer2.extractor.e[] eVarArr = this.mrV;
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
                    fVar.duP();
                }
                if (!eVar.a(fVar)) {
                    i++;
                } else {
                    this.mrW = eVar;
                    break;
                }
            }
            if (this.mrW == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.L(this.mrV) + ") could read the stream.", uri);
            }
            this.mrW.a(this.meB);
            return this.mrW;
        }

        public void release() {
            if (this.mrW != null) {
                this.mrW.release();
                this.mrW = null;
            }
        }
    }
}
