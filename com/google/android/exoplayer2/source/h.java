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
    private final Handler lYz;
    private long lZD;
    private boolean lZo;
    private final com.google.android.exoplayer2.upstream.e mdW;
    private k.a mqV;
    private com.google.android.exoplayer2.extractor.l mrC;
    private boolean mrF;
    private int mrG;
    private boolean mrH;
    private boolean mrI;
    private int mrJ;
    private u mrK;
    private boolean[] mrL;
    private boolean[] mrM;
    private boolean mrN;
    private long mrO;
    private int mrQ;
    private boolean mrR;
    private final int mrr;
    private final i.a mrs;
    private final c mrt;
    private final com.google.android.exoplayer2.upstream.b mru;
    private final String mrv;
    private final long mrw;
    private final b mry;
    private boolean released;
    private final Uri uri;
    private final Loader mrx = new Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.e mrz = new com.google.android.exoplayer2.util.e();
    private final Runnable mrA = new Runnable() { // from class: com.google.android.exoplayer2.source.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.dwp();
        }
    };
    private final Runnable mrB = new Runnable() { // from class: com.google.android.exoplayer2.source.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (!h.this.released) {
                h.this.mqV.a((k.a) h.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] mrE = new int[0];
    private o[] mrD = new o[0];
    private long mrP = -9223372036854775807L;
    private long length = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface c {
        void p(long j, boolean z);
    }

    public h(Uri uri, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.extractor.e[] eVarArr, int i, Handler handler, i.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar, String str, int i2) {
        this.uri = uri;
        this.mdW = eVar;
        this.mrr = i;
        this.lYz = handler;
        this.mrs = aVar;
        this.mrt = cVar;
        this.mru = bVar;
        this.mrv = str;
        this.mrw = i2;
        this.mry = new b(eVarArr, this);
        this.mrG = i == -1 ? 3 : i;
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
        this.mry.release();
        for (o oVar : this.mrD) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqV = aVar;
        this.mrz.ib();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwe() throws IOException {
        dwl();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwf() {
        return this.mrK;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int i = 0;
        com.google.android.exoplayer2.util.a.checkState(this.lZo);
        int i2 = this.mrJ;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) pVarArr[i3]).track;
                com.google.android.exoplayer2.util.a.checkState(this.mrL[i4]);
                this.mrJ--;
                this.mrL[i4] = false;
                pVarArr[i3] = null;
            }
        }
        boolean z = this.mrH ? i2 == 0 : j != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (pVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.b.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.util.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.util.a.checkState(fVar.LG(0) == 0);
                int a2 = this.mrK.a(fVar.dxf());
                com.google.android.exoplayer2.util.a.checkState(!this.mrL[a2]);
                this.mrJ++;
                this.mrL[a2] = true;
                pVarArr[i5] = new d(a2);
                zArr2[i5] = true;
                if (!z) {
                    o oVar = this.mrD[a2];
                    oVar.rewind();
                    z = oVar.a(j, true, true) == -1 && oVar.dww() != 0;
                }
            }
        }
        if (this.mrJ == 0) {
            this.mrI = false;
            if (this.mrx.isLoading()) {
                o[] oVarArr = this.mrD;
                int length = oVarArr.length;
                while (i < length) {
                    oVarArr[i].dwF();
                    i++;
                }
                this.mrx.cNA();
            } else {
                o[] oVarArr2 = this.mrD;
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
        this.mrH = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        int length = this.mrD.length;
        for (int i = 0; i < length; i++) {
            this.mrD[i].c(j, false, this.mrL[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        if (this.mrR || (this.lZo && this.mrJ == 0)) {
            return false;
        }
        boolean ib = this.mrz.ib();
        if (!this.mrx.isLoading()) {
            startLoading();
            return true;
        }
        return ib;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        if (this.mrJ == 0) {
            return Long.MIN_VALUE;
        }
        return dwh();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwg() {
        if (this.mrI) {
            this.mrI = false;
            return this.mrO;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwh() {
        long dwr;
        if (this.mrR) {
            return Long.MIN_VALUE;
        }
        if (dws()) {
            return this.mrP;
        }
        if (this.mrN) {
            int length = this.mrD.length;
            dwr = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.mrM[i]) {
                    dwr = Math.min(dwr, this.mrD[i].dwr());
                }
            }
        } else {
            dwr = dwr();
        }
        return dwr == Long.MIN_VALUE ? this.mrO : dwr;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        if (!this.mrC.duQ()) {
            j = 0;
        }
        this.mrO = j;
        this.mrI = false;
        if (dws() || !gf(j)) {
            this.mrP = j;
            this.mrR = false;
            if (this.mrx.isLoading()) {
                this.mrx.cNA();
            } else {
                for (o oVar : this.mrD) {
                    oVar.reset();
                }
            }
        }
        return j;
    }

    boolean KE(int i) {
        return !dwo() && (this.mrR || this.mrD[i].dwy());
    }

    void dwl() throws IOException {
        this.mrx.LS(this.mrG);
    }

    int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwo()) {
            return -3;
        }
        return this.mrD[i].a(mVar, eVar, z, this.mrR, this.mrO);
    }

    int E(int i, long j) {
        if (dwo()) {
            return 0;
        }
        o oVar = this.mrD[i];
        if (this.mrR && j > oVar.dwr()) {
            return oVar.dwA();
        }
        int a2 = oVar.a(j, true, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean dwo() {
        return this.mrI || dws();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2) {
        a(aVar);
        this.mrR = true;
        if (this.lZD == -9223372036854775807L) {
            long dwr = dwr();
            this.lZD = dwr == Long.MIN_VALUE ? 0L : dwr + 10000;
            this.mrt.p(this.lZD, this.mrC.duQ());
        }
        this.mqV.a((k.a) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2, boolean z) {
        if (!z) {
            a(aVar);
            for (o oVar : this.mrD) {
                oVar.reset();
            }
            if (this.mrJ > 0) {
                this.mqV.a((k.a) this);
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
        boolean z = dwq() > this.mrQ;
        b(aVar);
        this.mrQ = dwq();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        int length = this.mrD.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mrE[i3] == i) {
                return this.mrD[i3];
            }
        }
        o oVar = new o(this.mru);
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
        this.mrC = lVar;
        this.handler.post(this.mrA);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mrA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwp() {
        if (!this.released && !this.lZo && this.mrC != null && this.mrF) {
            for (o oVar : this.mrD) {
                if (oVar.dwz() == null) {
                    return;
                }
            }
            this.mrz.OD();
            int length = this.mrD.length;
            t[] tVarArr = new t[length];
            this.mrM = new boolean[length];
            this.mrL = new boolean[length];
            this.lZD = this.mrC.getDurationUs();
            for (int i = 0; i < length; i++) {
                Format dwz = this.mrD[i].dwz();
                tVarArr[i] = new t(dwz);
                String str = dwz.sampleMimeType;
                boolean z = com.google.android.exoplayer2.util.i.OQ(str) || com.google.android.exoplayer2.util.i.Qo(str);
                this.mrM[i] = z;
                this.mrN = z | this.mrN;
            }
            this.mrK = new u(tVarArr);
            if (this.mrr == -1 && this.length == -1 && this.mrC.getDurationUs() == -9223372036854775807L) {
                this.mrG = 6;
            }
            this.lZo = true;
            this.mrt.p(this.lZD, this.mrC.duQ());
            this.mqV.a((k) this);
        }
    }

    private void a(a aVar) {
        if (this.length != -1) {
            return;
        }
        this.length = aVar.length;
    }

    private void startLoading() {
        a aVar = new a(this.uri, this.mdW, this.mry, this.mrz);
        if (this.lZo) {
            com.google.android.exoplayer2.util.a.checkState(dws());
            if (this.lZD != -9223372036854775807L && this.mrP >= this.lZD) {
                this.mrR = true;
                this.mrP = -9223372036854775807L;
                return;
            }
            aVar.S(this.mrC.fL(this.mrP), this.mrP);
            this.mrP = -9223372036854775807L;
        }
        this.mrQ = dwq();
        this.mrx.a(aVar, this, this.mrG);
    }

    private void b(a aVar) {
        if (this.length == -1) {
            if (this.mrC == null || this.mrC.getDurationUs() == -9223372036854775807L) {
                this.mrO = 0L;
                this.mrI = this.lZo;
                for (o oVar : this.mrD) {
                    oVar.reset();
                }
                aVar.S(0L, 0L);
            }
        }
    }

    private boolean gf(long j) {
        int length = this.mrD.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mrD[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mrM[i] || !this.mrN)) {
                return false;
            }
            oVar.dwE();
        }
        return true;
    }

    private int dwq() {
        int i = 0;
        for (o oVar : this.mrD) {
            i += oVar.dwv();
        }
        return i;
    }

    private long dwr() {
        long j = Long.MIN_VALUE;
        for (o oVar : this.mrD) {
            j = Math.max(j, oVar.dwr());
        }
        return j;
    }

    private boolean dws() {
        return this.mrP != -9223372036854775807L;
    }

    private boolean c(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private void d(final IOException iOException) {
        if (this.lYz != null && this.mrs != null) {
            this.lYz.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.mrs.a(iOException);
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
        public void dwl() throws IOException {
            h.this.dwl();
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
        private final com.google.android.exoplayer2.upstream.e mdW;
        private volatile boolean mrU;
        private long mrW;
        private final b mry;
        private final com.google.android.exoplayer2.util.e mrz;
        private final Uri uri;
        private final com.google.android.exoplayer2.extractor.k mrT = new com.google.android.exoplayer2.extractor.k();
        private boolean mrV = true;
        private long length = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.e eVar, b bVar, com.google.android.exoplayer2.util.e eVar2) {
            this.uri = (Uri) com.google.android.exoplayer2.util.a.checkNotNull(uri);
            this.mdW = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
            this.mry = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
            this.mrz = eVar2;
        }

        public void S(long j, long j2) {
            this.mrT.fOb = j;
            this.mrW = j2;
            this.mrV = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.mrU = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean dwt() {
            return this.mrU;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws IOException, InterruptedException {
            com.google.android.exoplayer2.extractor.b bVar;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.mrU) {
                try {
                    long j = this.mrT.fOb;
                    this.length = this.mdW.a(new com.google.android.exoplayer2.upstream.g(this.uri, j, -1L, h.this.mrv));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    com.google.android.exoplayer2.extractor.b bVar2 = new com.google.android.exoplayer2.extractor.b(this.mdW, j, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.e a = this.mry.a(bVar2, this.mdW.getUri());
                        if (this.mrV) {
                            a.N(j, this.mrW);
                            this.mrV = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.mrU) {
                                    break;
                                }
                                this.mrz.block();
                                i = a.a(bVar2, this.mrT);
                                try {
                                    if (bVar2.getPosition() > h.this.mrw + j2) {
                                        j2 = bVar2.getPosition();
                                        this.mrz.OD();
                                        h.this.handler.post(h.this.mrB);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    bVar = bVar2;
                                    th = th;
                                    if (i != 1 && bVar != null) {
                                        this.mrT.fOb = bVar.getPosition();
                                    }
                                    v.a(this.mdW);
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
                                this.mrT.fOb = bVar2.getPosition();
                            }
                            i2 = i4;
                        }
                        v.a(this.mdW);
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
        private final com.google.android.exoplayer2.extractor.g meD;
        private final com.google.android.exoplayer2.extractor.e[] mrX;
        private com.google.android.exoplayer2.extractor.e mrY;

        public b(com.google.android.exoplayer2.extractor.e[] eVarArr, com.google.android.exoplayer2.extractor.g gVar) {
            this.mrX = eVarArr;
            this.meD = gVar;
        }

        public com.google.android.exoplayer2.extractor.e a(com.google.android.exoplayer2.extractor.f fVar, Uri uri) throws IOException, InterruptedException {
            if (this.mrY != null) {
                return this.mrY;
            }
            com.google.android.exoplayer2.extractor.e[] eVarArr = this.mrX;
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
                    fVar.duR();
                }
                if (!eVar.a(fVar)) {
                    i++;
                } else {
                    this.mrY = eVar;
                    break;
                }
            }
            if (this.mrY == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.L(this.mrX) + ") could read the stream.", uri);
            }
            this.mrY.a(this.meD);
            return this.mrY;
        }

        public void release() {
            if (this.mrY != null) {
                this.mrY.release();
                this.mrY = null;
            }
        }
    }
}
