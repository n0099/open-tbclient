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
    private final Handler lXM;
    private boolean lYB;
    private long lYQ;
    private final com.google.android.exoplayer2.upstream.e mdj;
    private final int mqE;
    private final i.a mqF;
    private final c mqG;
    private final com.google.android.exoplayer2.upstream.b mqH;
    private final String mqI;
    private final long mqJ;
    private final b mqL;
    private com.google.android.exoplayer2.extractor.l mqP;
    private boolean mqS;
    private int mqT;
    private boolean mqU;
    private boolean mqV;
    private int mqW;
    private u mqX;
    private boolean[] mqY;
    private boolean[] mqZ;
    private k.a mqi;
    private boolean mra;
    private long mrb;
    private int mrd;
    private boolean mre;
    private boolean released;
    private final Uri uri;
    private final Loader mqK = new Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.e mqM = new com.google.android.exoplayer2.util.e();
    private final Runnable mqN = new Runnable() { // from class: com.google.android.exoplayer2.source.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.dvb();
        }
    };
    private final Runnable mqO = new Runnable() { // from class: com.google.android.exoplayer2.source.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (!h.this.released) {
                h.this.mqi.a((k.a) h.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] mqR = new int[0];
    private o[] mqQ = new o[0];
    private long mrc = -9223372036854775807L;
    private long length = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface c {
        void n(long j, boolean z);
    }

    public h(Uri uri, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.extractor.e[] eVarArr, int i, Handler handler, i.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar, String str, int i2) {
        this.uri = uri;
        this.mdj = eVar;
        this.mqE = i;
        this.lXM = handler;
        this.mqF = aVar;
        this.mqG = cVar;
        this.mqH = bVar;
        this.mqI = str;
        this.mqJ = i2;
        this.mqL = new b(eVarArr, this);
        this.mqT = i == -1 ? 3 : i;
    }

    public void release() {
        boolean a2 = this.mqK.a(this);
        if (this.lYB && !a2) {
            for (o oVar : this.mqQ) {
                oVar.dvr();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void duZ() {
        this.mqL.release();
        for (o oVar : this.mqQ) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mqi = aVar;
        this.mqM.hN();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void duQ() throws IOException {
        duX();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u duR() {
        return this.mqX;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int i = 0;
        com.google.android.exoplayer2.util.a.checkState(this.lYB);
        int i2 = this.mqW;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) pVarArr[i3]).track;
                com.google.android.exoplayer2.util.a.checkState(this.mqY[i4]);
                this.mqW--;
                this.mqY[i4] = false;
                pVarArr[i3] = null;
            }
        }
        boolean z = this.mqU ? i2 == 0 : j != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (pVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.b.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.util.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.util.a.checkState(fVar.LB(0) == 0);
                int a2 = this.mqX.a(fVar.dvR());
                com.google.android.exoplayer2.util.a.checkState(!this.mqY[a2]);
                this.mqW++;
                this.mqY[a2] = true;
                pVarArr[i5] = new d(a2);
                zArr2[i5] = true;
                if (!z) {
                    o oVar = this.mqQ[a2];
                    oVar.rewind();
                    z = oVar.a(j, true, true) == -1 && oVar.dvi() != 0;
                }
            }
        }
        if (this.mqW == 0) {
            this.mqV = false;
            if (this.mqK.isLoading()) {
                o[] oVarArr = this.mqQ;
                int length = oVarArr.length;
                while (i < length) {
                    oVarArr[i].dvr();
                    i++;
                }
                this.mqK.cMb();
            } else {
                o[] oVarArr2 = this.mqQ;
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
        this.mqU = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void gd(long j) {
        int length = this.mqQ.length;
        for (int i = 0; i < length; i++) {
            this.mqQ[i].c(j, false, this.mqY[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean gf(long j) {
        if (this.mre || (this.lYB && this.mqW == 0)) {
            return false;
        }
        boolean hN = this.mqM.hN();
        if (!this.mqK.isLoading()) {
            startLoading();
            return true;
        }
        return hN;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duU() {
        if (this.mqW == 0) {
            return Long.MIN_VALUE;
        }
        return duT();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long duS() {
        if (this.mqV) {
            this.mqV = false;
            return this.mrb;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long duT() {
        long dvd;
        if (this.mre) {
            return Long.MIN_VALUE;
        }
        if (dve()) {
            return this.mrc;
        }
        if (this.mra) {
            int length = this.mqQ.length;
            dvd = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.mqZ[i]) {
                    dvd = Math.min(dvd, this.mqQ[i].dvd());
                }
            }
        } else {
            dvd = dvd();
        }
        return dvd == Long.MIN_VALUE ? this.mrb : dvd;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long ge(long j) {
        if (!this.mqP.dtB()) {
            j = 0;
        }
        this.mrb = j;
        this.mqV = false;
        if (dve() || !gh(j)) {
            this.mrc = j;
            this.mre = false;
            if (this.mqK.isLoading()) {
                this.mqK.cMb();
            } else {
                for (o oVar : this.mqQ) {
                    oVar.reset();
                }
            }
        }
        return j;
    }

    boolean Kz(int i) {
        return !dva() && (this.mre || this.mqQ[i].dvk());
    }

    void duX() throws IOException {
        this.mqK.LN(this.mqT);
    }

    int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dva()) {
            return -3;
        }
        return this.mqQ[i].a(mVar, eVar, z, this.mre, this.mrb);
    }

    int F(int i, long j) {
        if (dva()) {
            return 0;
        }
        o oVar = this.mqQ[i];
        if (this.mre && j > oVar.dvd()) {
            return oVar.dvm();
        }
        int a2 = oVar.a(j, true, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean dva() {
        return this.mqV || dve();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2) {
        a(aVar);
        this.mre = true;
        if (this.lYQ == -9223372036854775807L) {
            long dvd = dvd();
            this.lYQ = dvd == Long.MIN_VALUE ? 0L : dvd + 10000;
            this.mqG.n(this.lYQ, this.mqP.dtB());
        }
        this.mqi.a((k.a) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2, boolean z) {
        if (!z) {
            a(aVar);
            for (o oVar : this.mqQ) {
                oVar.reset();
            }
            if (this.mqW > 0) {
                this.mqi.a((k.a) this);
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
        boolean z = dvc() > this.mrd;
        b(aVar);
        this.mrd = dvc();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dH(int i, int i2) {
        int length = this.mqQ.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mqR[i3] == i) {
                return this.mqQ[i3];
            }
        }
        o oVar = new o(this.mqH);
        oVar.a(this);
        this.mqR = Arrays.copyOf(this.mqR, length + 1);
        this.mqR[length] = i;
        this.mqQ = (o[]) Arrays.copyOf(this.mqQ, length + 1);
        this.mqQ[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dtF() {
        this.mqS = true;
        this.handler.post(this.mqN);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mqP = lVar;
        this.handler.post(this.mqN);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mqN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvb() {
        if (!this.released && !this.lYB && this.mqP != null && this.mqS) {
            for (o oVar : this.mqQ) {
                if (oVar.dvl() == null) {
                    return;
                }
            }
            this.mqM.Mn();
            int length = this.mqQ.length;
            t[] tVarArr = new t[length];
            this.mqZ = new boolean[length];
            this.mqY = new boolean[length];
            this.lYQ = this.mqP.dso();
            for (int i = 0; i < length; i++) {
                Format dvl = this.mqQ[i].dvl();
                tVarArr[i] = new t(dvl);
                String str = dvl.sampleMimeType;
                boolean z = com.google.android.exoplayer2.util.i.OD(str) || com.google.android.exoplayer2.util.i.Qb(str);
                this.mqZ[i] = z;
                this.mra = z | this.mra;
            }
            this.mqX = new u(tVarArr);
            if (this.mqE == -1 && this.length == -1 && this.mqP.dso() == -9223372036854775807L) {
                this.mqT = 6;
            }
            this.lYB = true;
            this.mqG.n(this.lYQ, this.mqP.dtB());
            this.mqi.a((k) this);
        }
    }

    private void a(a aVar) {
        if (this.length != -1) {
            return;
        }
        this.length = aVar.length;
    }

    private void startLoading() {
        a aVar = new a(this.uri, this.mdj, this.mqL, this.mqM);
        if (this.lYB) {
            com.google.android.exoplayer2.util.a.checkState(dve());
            if (this.lYQ != -9223372036854775807L && this.mrc >= this.lYQ) {
                this.mre = true;
                this.mrc = -9223372036854775807L;
                return;
            }
            aVar.T(this.mqP.fN(this.mrc), this.mrc);
            this.mrc = -9223372036854775807L;
        }
        this.mrd = dvc();
        this.mqK.a(aVar, this, this.mqT);
    }

    private void b(a aVar) {
        if (this.length == -1) {
            if (this.mqP == null || this.mqP.dso() == -9223372036854775807L) {
                this.mrb = 0L;
                this.mqV = this.lYB;
                for (o oVar : this.mqQ) {
                    oVar.reset();
                }
                aVar.T(0L, 0L);
            }
        }
    }

    private boolean gh(long j) {
        int length = this.mqQ.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mqQ[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mqZ[i] || !this.mra)) {
                return false;
            }
            oVar.dvq();
        }
        return true;
    }

    private int dvc() {
        int i = 0;
        for (o oVar : this.mqQ) {
            i += oVar.dvh();
        }
        return i;
    }

    private long dvd() {
        long j = Long.MIN_VALUE;
        for (o oVar : this.mqQ) {
            j = Math.max(j, oVar.dvd());
        }
        return j;
    }

    private boolean dve() {
        return this.mrc != -9223372036854775807L;
    }

    private boolean c(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private void d(final IOException iOException) {
        if (this.lXM != null && this.mqF != null) {
            this.lXM.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.mqF.a(iOException);
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
        public void duX() throws IOException {
            h.this.duX();
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
        private final com.google.android.exoplayer2.upstream.e mdj;
        private final b mqL;
        private final com.google.android.exoplayer2.util.e mqM;
        private volatile boolean mrh;
        private long mrj;
        private final Uri uri;
        private final com.google.android.exoplayer2.extractor.k mrg = new com.google.android.exoplayer2.extractor.k();
        private boolean mri = true;
        private long length = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.e eVar, b bVar, com.google.android.exoplayer2.util.e eVar2) {
            this.uri = (Uri) com.google.android.exoplayer2.util.a.checkNotNull(uri);
            this.mdj = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
            this.mqL = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
            this.mqM = eVar2;
        }

        public void T(long j, long j2) {
            this.mrg.fLD = j;
            this.mrj = j2;
            this.mri = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.mrh = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean dvf() {
            return this.mrh;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws IOException, InterruptedException {
            com.google.android.exoplayer2.extractor.b bVar;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.mrh) {
                try {
                    long j = this.mrg.fLD;
                    this.length = this.mdj.a(new com.google.android.exoplayer2.upstream.g(this.uri, j, -1L, h.this.mqI));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    com.google.android.exoplayer2.extractor.b bVar2 = new com.google.android.exoplayer2.extractor.b(this.mdj, j, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.e a = this.mqL.a(bVar2, this.mdj.getUri());
                        if (this.mri) {
                            a.O(j, this.mrj);
                            this.mri = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.mrh) {
                                    break;
                                }
                                this.mqM.block();
                                i = a.a(bVar2, this.mrg);
                                try {
                                    if (bVar2.getPosition() > h.this.mqJ + j2) {
                                        j2 = bVar2.getPosition();
                                        this.mqM.Mn();
                                        h.this.handler.post(h.this.mqO);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    bVar = bVar2;
                                    th = th;
                                    if (i != 1 && bVar != null) {
                                        this.mrg.fLD = bVar.getPosition();
                                    }
                                    v.a(this.mdj);
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
                                this.mrg.fLD = bVar2.getPosition();
                            }
                            i2 = i4;
                        }
                        v.a(this.mdj);
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
        private final com.google.android.exoplayer2.extractor.g mdQ;
        private final com.google.android.exoplayer2.extractor.e[] mrk;
        private com.google.android.exoplayer2.extractor.e mrl;

        public b(com.google.android.exoplayer2.extractor.e[] eVarArr, com.google.android.exoplayer2.extractor.g gVar) {
            this.mrk = eVarArr;
            this.mdQ = gVar;
        }

        public com.google.android.exoplayer2.extractor.e a(com.google.android.exoplayer2.extractor.f fVar, Uri uri) throws IOException, InterruptedException {
            if (this.mrl != null) {
                return this.mrl;
            }
            com.google.android.exoplayer2.extractor.e[] eVarArr = this.mrk;
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
                    fVar.dtC();
                }
                if (!eVar.a(fVar)) {
                    i++;
                } else {
                    this.mrl = eVar;
                    break;
                }
            }
            if (this.mrl == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.L(this.mrk) + ") could read the stream.", uri);
            }
            this.mrl.a(this.mdQ);
            return this.mrl;
        }

        public void release() {
            if (this.mrl != null) {
                this.mrl.release();
                this.mrl = null;
            }
        }
    }
}
