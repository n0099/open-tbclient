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
/* loaded from: classes5.dex */
final class h implements com.google.android.exoplayer2.extractor.g, k, o.b, Loader.a<a>, Loader.d {
    private final Handler lXR;
    private boolean lYG;
    private long lYV;
    private final com.google.android.exoplayer2.upstream.e mdo;
    private final int mqJ;
    private final i.a mqK;
    private final c mqL;
    private final com.google.android.exoplayer2.upstream.b mqM;
    private final String mqN;
    private final long mqO;
    private final b mqQ;
    private com.google.android.exoplayer2.extractor.l mqU;
    private boolean mqX;
    private int mqY;
    private boolean mqZ;
    private k.a mqn;
    private boolean mra;
    private int mrb;
    private u mrc;
    private boolean[] mrd;
    private boolean[] mre;
    private boolean mrf;
    private long mrg;
    private int mri;
    private boolean mrj;
    private boolean released;
    private final Uri uri;
    private final Loader mqP = new Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.e mqR = new com.google.android.exoplayer2.util.e();
    private final Runnable mqS = new Runnable() { // from class: com.google.android.exoplayer2.source.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.dvd();
        }
    };
    private final Runnable mqT = new Runnable() { // from class: com.google.android.exoplayer2.source.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (!h.this.released) {
                h.this.mqn.a((k.a) h.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] mqW = new int[0];
    private o[] mqV = new o[0];
    private long mrh = -9223372036854775807L;
    private long length = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface c {
        void n(long j, boolean z);
    }

    public h(Uri uri, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.extractor.e[] eVarArr, int i, Handler handler, i.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar, String str, int i2) {
        this.uri = uri;
        this.mdo = eVar;
        this.mqJ = i;
        this.lXR = handler;
        this.mqK = aVar;
        this.mqL = cVar;
        this.mqM = bVar;
        this.mqN = str;
        this.mqO = i2;
        this.mqQ = new b(eVarArr, this);
        this.mqY = i == -1 ? 3 : i;
    }

    public void release() {
        boolean a2 = this.mqP.a(this);
        if (this.lYG && !a2) {
            for (o oVar : this.mqV) {
                oVar.dvt();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dvb() {
        this.mqQ.release();
        for (o oVar : this.mqV) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqn = aVar;
        this.mqR.hN();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duS() throws IOException {
        duZ();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duT() {
        return this.mrc;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int i = 0;
        com.google.android.exoplayer2.util.a.checkState(this.lYG);
        int i2 = this.mrb;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) pVarArr[i3]).track;
                com.google.android.exoplayer2.util.a.checkState(this.mrd[i4]);
                this.mrb--;
                this.mrd[i4] = false;
                pVarArr[i3] = null;
            }
        }
        boolean z = this.mqZ ? i2 == 0 : j != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (pVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.b.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.util.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.util.a.checkState(fVar.LB(0) == 0);
                int a2 = this.mrc.a(fVar.dvT());
                com.google.android.exoplayer2.util.a.checkState(!this.mrd[a2]);
                this.mrb++;
                this.mrd[a2] = true;
                pVarArr[i5] = new d(a2);
                zArr2[i5] = true;
                if (!z) {
                    o oVar = this.mqV[a2];
                    oVar.rewind();
                    z = oVar.a(j, true, true) == -1 && oVar.dvk() != 0;
                }
            }
        }
        if (this.mrb == 0) {
            this.mra = false;
            if (this.mqP.isLoading()) {
                o[] oVarArr = this.mqV;
                int length = oVarArr.length;
                while (i < length) {
                    oVarArr[i].dvt();
                    i++;
                }
                this.mqP.cMd();
            } else {
                o[] oVarArr2 = this.mqV;
                int length2 = oVarArr2.length;
                while (i < length2) {
                    oVarArr2[i].reset();
                    i++;
                }
            }
        } else if (z) {
            j = ge(j);
            while (i < pVarArr.length) {
                if (pVarArr[i] != null) {
                    zArr2[i] = true;
                }
                i++;
            }
        }
        this.mqZ = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        int length = this.mqV.length;
        for (int i = 0; i < length; i++) {
            this.mqV[i].c(j, false, this.mrd[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        if (this.mrj || (this.lYG && this.mrb == 0)) {
            return false;
        }
        boolean hN = this.mqR.hN();
        if (!this.mqP.isLoading()) {
            startLoading();
            return true;
        }
        return hN;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duW() {
        if (this.mrb == 0) {
            return Long.MIN_VALUE;
        }
        return duV();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duU() {
        if (this.mra) {
            this.mra = false;
            return this.mrg;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duV() {
        long dvf;
        if (this.mrj) {
            return Long.MIN_VALUE;
        }
        if (dvg()) {
            return this.mrh;
        }
        if (this.mrf) {
            int length = this.mqV.length;
            dvf = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.mre[i]) {
                    dvf = Math.min(dvf, this.mqV[i].dvf());
                }
            }
        } else {
            dvf = dvf();
        }
        return dvf == Long.MIN_VALUE ? this.mrg : dvf;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        if (!this.mqU.dtD()) {
            j = 0;
        }
        this.mrg = j;
        this.mra = false;
        if (dvg() || !gh(j)) {
            this.mrh = j;
            this.mrj = false;
            if (this.mqP.isLoading()) {
                this.mqP.cMd();
            } else {
                for (o oVar : this.mqV) {
                    oVar.reset();
                }
            }
        }
        return j;
    }

    boolean Kz(int i) {
        return !dvc() && (this.mrj || this.mqV[i].dvm());
    }

    void duZ() throws IOException {
        this.mqP.LN(this.mqY);
    }

    int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dvc()) {
            return -3;
        }
        return this.mqV[i].a(mVar, eVar, z, this.mrj, this.mrg);
    }

    int F(int i, long j) {
        if (dvc()) {
            return 0;
        }
        o oVar = this.mqV[i];
        if (this.mrj && j > oVar.dvf()) {
            return oVar.dvo();
        }
        int a2 = oVar.a(j, true, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean dvc() {
        return this.mra || dvg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2) {
        a(aVar);
        this.mrj = true;
        if (this.lYV == -9223372036854775807L) {
            long dvf = dvf();
            this.lYV = dvf == Long.MIN_VALUE ? 0L : dvf + 10000;
            this.mqL.n(this.lYV, this.mqU.dtD());
        }
        this.mqn.a((k.a) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2, boolean z) {
        if (!z) {
            a(aVar);
            for (o oVar : this.mqV) {
                oVar.reset();
            }
            if (this.mrb > 0) {
                this.mqn.a((k.a) this);
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
        boolean z = dve() > this.mri;
        b(aVar);
        this.mri = dve();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dH(int i, int i2) {
        int length = this.mqV.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mqW[i3] == i) {
                return this.mqV[i3];
            }
        }
        o oVar = new o(this.mqM);
        oVar.a(this);
        this.mqW = Arrays.copyOf(this.mqW, length + 1);
        this.mqW[length] = i;
        this.mqV = (o[]) Arrays.copyOf(this.mqV, length + 1);
        this.mqV[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dtH() {
        this.mqX = true;
        this.handler.post(this.mqS);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mqU = lVar;
        this.handler.post(this.mqS);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mqS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvd() {
        if (!this.released && !this.lYG && this.mqU != null && this.mqX) {
            for (o oVar : this.mqV) {
                if (oVar.dvn() == null) {
                    return;
                }
            }
            this.mqR.Mn();
            int length = this.mqV.length;
            t[] tVarArr = new t[length];
            this.mre = new boolean[length];
            this.mrd = new boolean[length];
            this.lYV = this.mqU.dsq();
            for (int i = 0; i < length; i++) {
                Format dvn = this.mqV[i].dvn();
                tVarArr[i] = new t(dvn);
                String str = dvn.sampleMimeType;
                boolean z = com.google.android.exoplayer2.util.i.OD(str) || com.google.android.exoplayer2.util.i.Qb(str);
                this.mre[i] = z;
                this.mrf = z | this.mrf;
            }
            this.mrc = new u(tVarArr);
            if (this.mqJ == -1 && this.length == -1 && this.mqU.dsq() == -9223372036854775807L) {
                this.mqY = 6;
            }
            this.lYG = true;
            this.mqL.n(this.lYV, this.mqU.dtD());
            this.mqn.a((k) this);
        }
    }

    private void a(a aVar) {
        if (this.length != -1) {
            return;
        }
        this.length = aVar.length;
    }

    private void startLoading() {
        a aVar = new a(this.uri, this.mdo, this.mqQ, this.mqR);
        if (this.lYG) {
            com.google.android.exoplayer2.util.a.checkState(dvg());
            if (this.lYV != -9223372036854775807L && this.mrh >= this.lYV) {
                this.mrj = true;
                this.mrh = -9223372036854775807L;
                return;
            }
            aVar.T(this.mqU.fN(this.mrh), this.mrh);
            this.mrh = -9223372036854775807L;
        }
        this.mri = dve();
        this.mqP.a(aVar, this, this.mqY);
    }

    private void b(a aVar) {
        if (this.length == -1) {
            if (this.mqU == null || this.mqU.dsq() == -9223372036854775807L) {
                this.mrg = 0L;
                this.mra = this.lYG;
                for (o oVar : this.mqV) {
                    oVar.reset();
                }
                aVar.T(0L, 0L);
            }
        }
    }

    private boolean gh(long j) {
        int length = this.mqV.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mqV[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mre[i] || !this.mrf)) {
                return false;
            }
            oVar.dvs();
        }
        return true;
    }

    private int dve() {
        int i = 0;
        for (o oVar : this.mqV) {
            i += oVar.dvj();
        }
        return i;
    }

    private long dvf() {
        long j = Long.MIN_VALUE;
        for (o oVar : this.mqV) {
            j = Math.max(j, oVar.dvf());
        }
        return j;
    }

    private boolean dvg() {
        return this.mrh != -9223372036854775807L;
    }

    private boolean c(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private void d(final IOException iOException) {
        if (this.lXR != null && this.mqK != null) {
            this.lXR.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.mqK.a(iOException);
                }
            });
        }
    }

    /* loaded from: classes5.dex */
    private final class d implements p {
        private final int track;

        public d(int i) {
            this.track = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return h.this.Kz(this.track);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void duZ() throws IOException {
            h.this.duZ();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            return h.this.a(this.track, mVar, eVar, z);
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gg(long j) {
            return h.this.F(this.track, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class a implements Loader.c {
        private final com.google.android.exoplayer2.upstream.e mdo;
        private final b mqQ;
        private final com.google.android.exoplayer2.util.e mqR;
        private volatile boolean mrm;
        private long mro;
        private final Uri uri;
        private final com.google.android.exoplayer2.extractor.k mrl = new com.google.android.exoplayer2.extractor.k();
        private boolean mrn = true;
        private long length = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.e eVar, b bVar, com.google.android.exoplayer2.util.e eVar2) {
            this.uri = (Uri) com.google.android.exoplayer2.util.a.checkNotNull(uri);
            this.mdo = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
            this.mqQ = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
            this.mqR = eVar2;
        }

        public void T(long j, long j2) {
            this.mrl.fLD = j;
            this.mro = j2;
            this.mrn = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.mrm = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean dvh() {
            return this.mrm;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws IOException, InterruptedException {
            com.google.android.exoplayer2.extractor.b bVar;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.mrm) {
                try {
                    long j = this.mrl.fLD;
                    this.length = this.mdo.a(new com.google.android.exoplayer2.upstream.g(this.uri, j, -1L, h.this.mqN));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    com.google.android.exoplayer2.extractor.b bVar2 = new com.google.android.exoplayer2.extractor.b(this.mdo, j, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.e a = this.mqQ.a(bVar2, this.mdo.getUri());
                        if (this.mrn) {
                            a.O(j, this.mro);
                            this.mrn = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.mrm) {
                                    break;
                                }
                                this.mqR.block();
                                i = a.a(bVar2, this.mrl);
                                try {
                                    if (bVar2.getPosition() > h.this.mqO + j2) {
                                        j2 = bVar2.getPosition();
                                        this.mqR.Mn();
                                        h.this.handler.post(h.this.mqT);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    bVar = bVar2;
                                    th = th;
                                    if (i != 1 && bVar != null) {
                                        this.mrl.fLD = bVar.getPosition();
                                    }
                                    v.a(this.mdo);
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
                                this.mrl.fLD = bVar2.getPosition();
                            }
                            i2 = i4;
                        }
                        v.a(this.mdo);
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
    /* loaded from: classes5.dex */
    public static final class b {
        private final com.google.android.exoplayer2.extractor.g mdV;
        private final com.google.android.exoplayer2.extractor.e[] mrp;
        private com.google.android.exoplayer2.extractor.e mrq;

        public b(com.google.android.exoplayer2.extractor.e[] eVarArr, com.google.android.exoplayer2.extractor.g gVar) {
            this.mrp = eVarArr;
            this.mdV = gVar;
        }

        public com.google.android.exoplayer2.extractor.e a(com.google.android.exoplayer2.extractor.f fVar, Uri uri) throws IOException, InterruptedException {
            if (this.mrq != null) {
                return this.mrq;
            }
            com.google.android.exoplayer2.extractor.e[] eVarArr = this.mrp;
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
                    fVar.dtE();
                }
                if (!eVar.a(fVar)) {
                    i++;
                } else {
                    this.mrq = eVar;
                    break;
                }
            }
            if (this.mrq == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.L(this.mrp) + ") could read the stream.", uri);
            }
            this.mrq.a(this.mdV);
            return this.mrq;
        }

        public void release() {
            if (this.mrq != null) {
                this.mrq.release();
                this.mrq = null;
            }
        }
    }
}
