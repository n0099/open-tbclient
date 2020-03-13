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
    private final Handler lYK;
    private long lZO;
    private boolean lZz;
    private final com.google.android.exoplayer2.upstream.e meh;
    private final int mrC;
    private final i.a mrD;
    private final c mrE;
    private final com.google.android.exoplayer2.upstream.b mrF;
    private final String mrG;
    private final long mrH;
    private final b mrJ;
    private com.google.android.exoplayer2.extractor.l mrN;
    private boolean mrQ;
    private int mrR;
    private boolean mrS;
    private boolean mrT;
    private int mrU;
    private u mrV;
    private boolean[] mrW;
    private boolean[] mrX;
    private boolean mrY;
    private long mrZ;
    private k.a mrg;
    private int msb;
    private boolean msc;
    private boolean released;
    private final Uri uri;
    private final Loader mrI = new Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.e mrK = new com.google.android.exoplayer2.util.e();
    private final Runnable mrL = new Runnable() { // from class: com.google.android.exoplayer2.source.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.dwq();
        }
    };
    private final Runnable mrM = new Runnable() { // from class: com.google.android.exoplayer2.source.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (!h.this.released) {
                h.this.mrg.a((k.a) h.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] mrP = new int[0];
    private o[] mrO = new o[0];
    private long msa = -9223372036854775807L;
    private long length = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface c {
        void p(long j, boolean z);
    }

    public h(Uri uri, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.extractor.e[] eVarArr, int i, Handler handler, i.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar, String str, int i2) {
        this.uri = uri;
        this.meh = eVar;
        this.mrC = i;
        this.lYK = handler;
        this.mrD = aVar;
        this.mrE = cVar;
        this.mrF = bVar;
        this.mrG = str;
        this.mrH = i2;
        this.mrJ = new b(eVarArr, this);
        this.mrR = i == -1 ? 3 : i;
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
        this.mrJ.release();
        for (o oVar : this.mrO) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mrg = aVar;
        this.mrK.ib();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dwf() throws IOException {
        dwm();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dwg() {
        return this.mrV;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int i = 0;
        com.google.android.exoplayer2.util.a.checkState(this.lZz);
        int i2 = this.mrU;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) pVarArr[i3]).track;
                com.google.android.exoplayer2.util.a.checkState(this.mrW[i4]);
                this.mrU--;
                this.mrW[i4] = false;
                pVarArr[i3] = null;
            }
        }
        boolean z = this.mrS ? i2 == 0 : j != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (pVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.b.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.util.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.util.a.checkState(fVar.LG(0) == 0);
                int a2 = this.mrV.a(fVar.dxg());
                com.google.android.exoplayer2.util.a.checkState(!this.mrW[a2]);
                this.mrU++;
                this.mrW[a2] = true;
                pVarArr[i5] = new d(a2);
                zArr2[i5] = true;
                if (!z) {
                    o oVar = this.mrO[a2];
                    oVar.rewind();
                    z = oVar.a(j, true, true) == -1 && oVar.dwx() != 0;
                }
            }
        }
        if (this.mrU == 0) {
            this.mrT = false;
            if (this.mrI.isLoading()) {
                o[] oVarArr = this.mrO;
                int length = oVarArr.length;
                while (i < length) {
                    oVarArr[i].dwG();
                    i++;
                }
                this.mrI.cNB();
            } else {
                o[] oVarArr2 = this.mrO;
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
        this.mrS = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gb(long j) {
        int length = this.mrO.length;
        for (int i = 0; i < length; i++) {
            this.mrO[i].c(j, false, this.mrW[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gd(long j) {
        if (this.msc || (this.lZz && this.mrU == 0)) {
            return false;
        }
        boolean ib = this.mrK.ib();
        if (!this.mrI.isLoading()) {
            startLoading();
            return true;
        }
        return ib;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwj() {
        if (this.mrU == 0) {
            return Long.MIN_VALUE;
        }
        return dwi();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dwh() {
        if (this.mrT) {
            this.mrT = false;
            return this.mrZ;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dwi() {
        long dws;
        if (this.msc) {
            return Long.MIN_VALUE;
        }
        if (dwt()) {
            return this.msa;
        }
        if (this.mrY) {
            int length = this.mrO.length;
            dws = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.mrX[i]) {
                    dws = Math.min(dws, this.mrO[i].dws());
                }
            }
        } else {
            dws = dws();
        }
        return dws == Long.MIN_VALUE ? this.mrZ : dws;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long gc(long j) {
        if (!this.mrN.duR()) {
            j = 0;
        }
        this.mrZ = j;
        this.mrT = false;
        if (dwt() || !gf(j)) {
            this.msa = j;
            this.msc = false;
            if (this.mrI.isLoading()) {
                this.mrI.cNB();
            } else {
                for (o oVar : this.mrO) {
                    oVar.reset();
                }
            }
        }
        return j;
    }

    boolean KE(int i) {
        return !dwp() && (this.msc || this.mrO[i].dwz());
    }

    void dwm() throws IOException {
        this.mrI.LS(this.mrR);
    }

    int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dwp()) {
            return -3;
        }
        return this.mrO[i].a(mVar, eVar, z, this.msc, this.mrZ);
    }

    int E(int i, long j) {
        if (dwp()) {
            return 0;
        }
        o oVar = this.mrO[i];
        if (this.msc && j > oVar.dws()) {
            return oVar.dwB();
        }
        int a2 = oVar.a(j, true, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean dwp() {
        return this.mrT || dwt();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2) {
        a(aVar);
        this.msc = true;
        if (this.lZO == -9223372036854775807L) {
            long dws = dws();
            this.lZO = dws == Long.MIN_VALUE ? 0L : dws + 10000;
            this.mrE.p(this.lZO, this.mrN.duR());
        }
        this.mrg.a((k.a) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2, boolean z) {
        if (!z) {
            a(aVar);
            for (o oVar : this.mrO) {
                oVar.reset();
            }
            if (this.mrU > 0) {
                this.mrg.a((k.a) this);
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
        boolean z = dwr() > this.msb;
        b(aVar);
        this.msb = dwr();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dK(int i, int i2) {
        int length = this.mrO.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mrP[i3] == i) {
                return this.mrO[i3];
            }
        }
        o oVar = new o(this.mrF);
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
        this.mrN = lVar;
        this.handler.post(this.mrL);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mrL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwq() {
        if (!this.released && !this.lZz && this.mrN != null && this.mrQ) {
            for (o oVar : this.mrO) {
                if (oVar.dwA() == null) {
                    return;
                }
            }
            this.mrK.OD();
            int length = this.mrO.length;
            t[] tVarArr = new t[length];
            this.mrX = new boolean[length];
            this.mrW = new boolean[length];
            this.lZO = this.mrN.getDurationUs();
            for (int i = 0; i < length; i++) {
                Format dwA = this.mrO[i].dwA();
                tVarArr[i] = new t(dwA);
                String str = dwA.sampleMimeType;
                boolean z = com.google.android.exoplayer2.util.i.OR(str) || com.google.android.exoplayer2.util.i.Qp(str);
                this.mrX[i] = z;
                this.mrY = z | this.mrY;
            }
            this.mrV = new u(tVarArr);
            if (this.mrC == -1 && this.length == -1 && this.mrN.getDurationUs() == -9223372036854775807L) {
                this.mrR = 6;
            }
            this.lZz = true;
            this.mrE.p(this.lZO, this.mrN.duR());
            this.mrg.a((k) this);
        }
    }

    private void a(a aVar) {
        if (this.length != -1) {
            return;
        }
        this.length = aVar.length;
    }

    private void startLoading() {
        a aVar = new a(this.uri, this.meh, this.mrJ, this.mrK);
        if (this.lZz) {
            com.google.android.exoplayer2.util.a.checkState(dwt());
            if (this.lZO != -9223372036854775807L && this.msa >= this.lZO) {
                this.msc = true;
                this.msa = -9223372036854775807L;
                return;
            }
            aVar.S(this.mrN.fL(this.msa), this.msa);
            this.msa = -9223372036854775807L;
        }
        this.msb = dwr();
        this.mrI.a(aVar, this, this.mrR);
    }

    private void b(a aVar) {
        if (this.length == -1) {
            if (this.mrN == null || this.mrN.getDurationUs() == -9223372036854775807L) {
                this.mrZ = 0L;
                this.mrT = this.lZz;
                for (o oVar : this.mrO) {
                    oVar.reset();
                }
                aVar.S(0L, 0L);
            }
        }
    }

    private boolean gf(long j) {
        int length = this.mrO.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mrO[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mrX[i] || !this.mrY)) {
                return false;
            }
            oVar.dwF();
        }
        return true;
    }

    private int dwr() {
        int i = 0;
        for (o oVar : this.mrO) {
            i += oVar.dww();
        }
        return i;
    }

    private long dws() {
        long j = Long.MIN_VALUE;
        for (o oVar : this.mrO) {
            j = Math.max(j, oVar.dws());
        }
        return j;
    }

    private boolean dwt() {
        return this.msa != -9223372036854775807L;
    }

    private boolean c(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private void d(final IOException iOException) {
        if (this.lYK != null && this.mrD != null) {
            this.lYK.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.mrD.a(iOException);
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
        public void dwm() throws IOException {
            h.this.dwm();
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
        private final com.google.android.exoplayer2.upstream.e meh;
        private final b mrJ;
        private final com.google.android.exoplayer2.util.e mrK;
        private volatile boolean msf;
        private long msi;
        private final Uri uri;
        private final com.google.android.exoplayer2.extractor.k mse = new com.google.android.exoplayer2.extractor.k();
        private boolean msh = true;
        private long length = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.e eVar, b bVar, com.google.android.exoplayer2.util.e eVar2) {
            this.uri = (Uri) com.google.android.exoplayer2.util.a.checkNotNull(uri);
            this.meh = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
            this.mrJ = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
            this.mrK = eVar2;
        }

        public void S(long j, long j2) {
            this.mse.fOo = j;
            this.msi = j2;
            this.msh = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.msf = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean dwu() {
            return this.msf;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws IOException, InterruptedException {
            com.google.android.exoplayer2.extractor.b bVar;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.msf) {
                try {
                    long j = this.mse.fOo;
                    this.length = this.meh.a(new com.google.android.exoplayer2.upstream.g(this.uri, j, -1L, h.this.mrG));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    com.google.android.exoplayer2.extractor.b bVar2 = new com.google.android.exoplayer2.extractor.b(this.meh, j, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.e a = this.mrJ.a(bVar2, this.meh.getUri());
                        if (this.msh) {
                            a.N(j, this.msi);
                            this.msh = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.msf) {
                                    break;
                                }
                                this.mrK.block();
                                i = a.a(bVar2, this.mse);
                                try {
                                    if (bVar2.getPosition() > h.this.mrH + j2) {
                                        j2 = bVar2.getPosition();
                                        this.mrK.OD();
                                        h.this.handler.post(h.this.mrM);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    bVar = bVar2;
                                    th = th;
                                    if (i != 1 && bVar != null) {
                                        this.mse.fOo = bVar.getPosition();
                                    }
                                    v.a(this.meh);
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
                                this.mse.fOo = bVar2.getPosition();
                            }
                            i2 = i4;
                        }
                        v.a(this.meh);
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
        private final com.google.android.exoplayer2.extractor.g meO;
        private final com.google.android.exoplayer2.extractor.e[] msj;
        private com.google.android.exoplayer2.extractor.e msk;

        public b(com.google.android.exoplayer2.extractor.e[] eVarArr, com.google.android.exoplayer2.extractor.g gVar) {
            this.msj = eVarArr;
            this.meO = gVar;
        }

        public com.google.android.exoplayer2.extractor.e a(com.google.android.exoplayer2.extractor.f fVar, Uri uri) throws IOException, InterruptedException {
            if (this.msk != null) {
                return this.msk;
            }
            com.google.android.exoplayer2.extractor.e[] eVarArr = this.msj;
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
                    fVar.duS();
                }
                if (!eVar.a(fVar)) {
                    i++;
                } else {
                    this.msk = eVar;
                    break;
                }
            }
            if (this.msk == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.L(this.msj) + ") could read the stream.", uri);
            }
            this.msk.a(this.meO);
            return this.msk;
        }

        public void release() {
            if (this.msk != null) {
                this.msk.release();
                this.msk = null;
            }
        }
    }
}
