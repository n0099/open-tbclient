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
/* loaded from: classes4.dex */
final class h implements com.google.android.exoplayer2.extractor.g, k, o.b, Loader.a<a>, Loader.d {
    private final Handler lTV;
    private boolean lUK;
    private long lUZ;
    private final com.google.android.exoplayer2.upstream.e lZr;
    private final int mmP;
    private final i.a mmQ;
    private final c mmR;
    private final com.google.android.exoplayer2.upstream.b mmS;
    private final String mmT;
    private final long mmU;
    private final b mmW;
    private k.a mmt;
    private com.google.android.exoplayer2.extractor.l mna;
    private boolean mnd;
    private int mne;
    private boolean mnf;
    private boolean mng;
    private int mnh;
    private u mni;
    private boolean[] mnj;
    private boolean[] mnk;
    private boolean mnl;
    private long mnm;
    private int mno;
    private boolean mnp;
    private boolean released;
    private final Uri uri;
    private final Loader mmV = new Loader("Loader:ExtractorMediaPeriod");
    private final com.google.android.exoplayer2.util.e mmX = new com.google.android.exoplayer2.util.e();
    private final Runnable mmY = new Runnable() { // from class: com.google.android.exoplayer2.source.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.dtQ();
        }
    };
    private final Runnable mmZ = new Runnable() { // from class: com.google.android.exoplayer2.source.h.2
        @Override // java.lang.Runnable
        public void run() {
            if (!h.this.released) {
                h.this.mmt.a((k.a) h.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] mnc = new int[0];
    private o[] mnb = new o[0];
    private long mnn = -9223372036854775807L;
    private long length = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface c {
        void n(long j, boolean z);
    }

    public h(Uri uri, com.google.android.exoplayer2.upstream.e eVar, com.google.android.exoplayer2.extractor.e[] eVarArr, int i, Handler handler, i.a aVar, c cVar, com.google.android.exoplayer2.upstream.b bVar, String str, int i2) {
        this.uri = uri;
        this.lZr = eVar;
        this.mmP = i;
        this.lTV = handler;
        this.mmQ = aVar;
        this.mmR = cVar;
        this.mmS = bVar;
        this.mmT = str;
        this.mmU = i2;
        this.mmW = new b(eVarArr, this);
        this.mne = i == -1 ? 3 : i;
    }

    public void release() {
        boolean a2 = this.mmV.a(this);
        if (this.lUK && !a2) {
            for (o oVar : this.mnb) {
                oVar.dug();
            }
        }
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void dtO() {
        this.mmW.release();
        for (o oVar : this.mnb) {
            oVar.reset();
        }
    }

    @Override // com.google.android.exoplayer2.source.k
    public void a(k.a aVar, long j) {
        this.mmt = aVar;
        this.mmX.hO();
        startLoading();
    }

    @Override // com.google.android.exoplayer2.source.k
    public void dtF() throws IOException {
        dtM();
    }

    @Override // com.google.android.exoplayer2.source.k
    public u dtG() {
        return this.mni;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long a(com.google.android.exoplayer2.b.f[] fVarArr, boolean[] zArr, p[] pVarArr, boolean[] zArr2, long j) {
        int i = 0;
        com.google.android.exoplayer2.util.a.checkState(this.lUK);
        int i2 = this.mnh;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            if (pVarArr[i3] != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((d) pVarArr[i3]).track;
                com.google.android.exoplayer2.util.a.checkState(this.mnj[i4]);
                this.mnh--;
                this.mnj[i4] = false;
                pVarArr[i3] = null;
            }
        }
        boolean z = this.mnf ? i2 == 0 : j != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (pVarArr[i5] == null && fVarArr[i5] != null) {
                com.google.android.exoplayer2.b.f fVar = fVarArr[i5];
                com.google.android.exoplayer2.util.a.checkState(fVar.length() == 1);
                com.google.android.exoplayer2.util.a.checkState(fVar.Ls(0) == 0);
                int a2 = this.mni.a(fVar.duG());
                com.google.android.exoplayer2.util.a.checkState(!this.mnj[a2]);
                this.mnh++;
                this.mnj[a2] = true;
                pVarArr[i5] = new d(a2);
                zArr2[i5] = true;
                if (!z) {
                    o oVar = this.mnb[a2];
                    oVar.rewind();
                    z = oVar.a(j, true, true) == -1 && oVar.dtX() != 0;
                }
            }
        }
        if (this.mnh == 0) {
            this.mng = false;
            if (this.mmV.isLoading()) {
                o[] oVarArr = this.mnb;
                int length = oVarArr.length;
                while (i < length) {
                    oVarArr[i].dug();
                    i++;
                }
                this.mmV.cKW();
            } else {
                o[] oVarArr2 = this.mnb;
                int length2 = oVarArr2.length;
                while (i < length2) {
                    oVarArr2[i].reset();
                    i++;
                }
            }
        } else if (z) {
            j = fZ(j);
            while (i < pVarArr.length) {
                if (pVarArr[i] != null) {
                    zArr2[i] = true;
                }
                i++;
            }
        }
        this.mnf = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.k
    public void fY(long j) {
        int length = this.mnb.length;
        for (int i = 0; i < length; i++) {
            this.mnb[i].c(j, false, this.mnj[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public boolean ga(long j) {
        if (this.mnp || (this.lUK && this.mnh == 0)) {
            return false;
        }
        boolean hO = this.mmX.hO();
        if (!this.mmV.isLoading()) {
            startLoading();
            return true;
        }
        return hO;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtJ() {
        if (this.mnh == 0) {
            return Long.MIN_VALUE;
        }
        return dtI();
    }

    @Override // com.google.android.exoplayer2.source.k
    public long dtH() {
        if (this.mng) {
            this.mng = false;
            return this.mnm;
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.k, com.google.android.exoplayer2.source.q
    public long dtI() {
        long dtS;
        if (this.mnp) {
            return Long.MIN_VALUE;
        }
        if (dtT()) {
            return this.mnn;
        }
        if (this.mnl) {
            int length = this.mnb.length;
            dtS = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.mnk[i]) {
                    dtS = Math.min(dtS, this.mnb[i].dtS());
                }
            }
        } else {
            dtS = dtS();
        }
        return dtS == Long.MIN_VALUE ? this.mnm : dtS;
    }

    @Override // com.google.android.exoplayer2.source.k
    public long fZ(long j) {
        if (!this.mna.dsp()) {
            j = 0;
        }
        this.mnm = j;
        this.mng = false;
        if (dtT() || !gc(j)) {
            this.mnn = j;
            this.mnp = false;
            if (this.mmV.isLoading()) {
                this.mmV.cKW();
            } else {
                for (o oVar : this.mnb) {
                    oVar.reset();
                }
            }
        }
        return j;
    }

    boolean Kq(int i) {
        return !dtP() && (this.mnp || this.mnb[i].dtZ());
    }

    void dtM() throws IOException {
        this.mmV.LE(this.mne);
    }

    int a(int i, com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
        if (dtP()) {
            return -3;
        }
        return this.mnb[i].a(mVar, eVar, z, this.mnp, this.mnm);
    }

    int F(int i, long j) {
        if (dtP()) {
            return 0;
        }
        o oVar = this.mnb[i];
        if (this.mnp && j > oVar.dtS()) {
            return oVar.dub();
        }
        int a2 = oVar.a(j, true, true);
        if (a2 != -1) {
            return a2;
        }
        return 0;
    }

    private boolean dtP() {
        return this.mng || dtT();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2) {
        a(aVar);
        this.mnp = true;
        if (this.lUZ == -9223372036854775807L) {
            long dtS = dtS();
            this.lUZ = dtS == Long.MIN_VALUE ? 0L : dtS + 10000;
            this.mmR.n(this.lUZ, this.mna.dsp());
        }
        this.mmt.a((k.a) this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(a aVar, long j, long j2, boolean z) {
        if (!z) {
            a(aVar);
            for (o oVar : this.mnb) {
                oVar.reset();
            }
            if (this.mnh > 0) {
                this.mmt.a((k.a) this);
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
        boolean z = dtR() > this.mno;
        b(aVar);
        this.mno = dtR();
        return !z ? 0 : 1;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public com.google.android.exoplayer2.extractor.m dJ(int i, int i2) {
        int length = this.mnb.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.mnc[i3] == i) {
                return this.mnb[i3];
            }
        }
        o oVar = new o(this.mmS);
        oVar.a(this);
        this.mnc = Arrays.copyOf(this.mnc, length + 1);
        this.mnc[length] = i;
        this.mnb = (o[]) Arrays.copyOf(this.mnb, length + 1);
        this.mnb[length] = oVar;
        return oVar;
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void dst() {
        this.mnd = true;
        this.handler.post(this.mmY);
    }

    @Override // com.google.android.exoplayer2.extractor.g
    public void a(com.google.android.exoplayer2.extractor.l lVar) {
        this.mna = lVar;
        this.handler.post(this.mmY);
    }

    @Override // com.google.android.exoplayer2.source.o.b
    public void k(Format format) {
        this.handler.post(this.mmY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtQ() {
        if (!this.released && !this.lUK && this.mna != null && this.mnd) {
            for (o oVar : this.mnb) {
                if (oVar.dua() == null) {
                    return;
                }
            }
            this.mmX.LR();
            int length = this.mnb.length;
            t[] tVarArr = new t[length];
            this.mnk = new boolean[length];
            this.mnj = new boolean[length];
            this.lUZ = this.mna.drc();
            for (int i = 0; i < length; i++) {
                Format dua = this.mnb[i].dua();
                tVarArr[i] = new t(dua);
                String str = dua.sampleMimeType;
                boolean z = com.google.android.exoplayer2.util.i.Ot(str) || com.google.android.exoplayer2.util.i.PQ(str);
                this.mnk[i] = z;
                this.mnl = z | this.mnl;
            }
            this.mni = new u(tVarArr);
            if (this.mmP == -1 && this.length == -1 && this.mna.drc() == -9223372036854775807L) {
                this.mne = 6;
            }
            this.lUK = true;
            this.mmR.n(this.lUZ, this.mna.dsp());
            this.mmt.a((k) this);
        }
    }

    private void a(a aVar) {
        if (this.length != -1) {
            return;
        }
        this.length = aVar.length;
    }

    private void startLoading() {
        a aVar = new a(this.uri, this.lZr, this.mmW, this.mmX);
        if (this.lUK) {
            com.google.android.exoplayer2.util.a.checkState(dtT());
            if (this.lUZ != -9223372036854775807L && this.mnn >= this.lUZ) {
                this.mnp = true;
                this.mnn = -9223372036854775807L;
                return;
            }
            aVar.T(this.mna.fI(this.mnn), this.mnn);
            this.mnn = -9223372036854775807L;
        }
        this.mno = dtR();
        this.mmV.a(aVar, this, this.mne);
    }

    private void b(a aVar) {
        if (this.length == -1) {
            if (this.mna == null || this.mna.drc() == -9223372036854775807L) {
                this.mnm = 0L;
                this.mng = this.lUK;
                for (o oVar : this.mnb) {
                    oVar.reset();
                }
                aVar.T(0L, 0L);
            }
        }
    }

    private boolean gc(long j) {
        int length = this.mnb.length;
        for (int i = 0; i < length; i++) {
            o oVar = this.mnb[i];
            oVar.rewind();
            if (!(oVar.a(j, true, false) != -1) && (this.mnk[i] || !this.mnl)) {
                return false;
            }
            oVar.duf();
        }
        return true;
    }

    private int dtR() {
        int i = 0;
        for (o oVar : this.mnb) {
            i += oVar.dtW();
        }
        return i;
    }

    private long dtS() {
        long j = Long.MIN_VALUE;
        for (o oVar : this.mnb) {
            j = Math.max(j, oVar.dtS());
        }
        return j;
    }

    private boolean dtT() {
        return this.mnn != -9223372036854775807L;
    }

    private boolean c(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private void d(final IOException iOException) {
        if (this.lTV != null && this.mmQ != null) {
            this.lTV.post(new Runnable() { // from class: com.google.android.exoplayer2.source.h.3
                @Override // java.lang.Runnable
                public void run() {
                    h.this.mmQ.a(iOException);
                }
            });
        }
    }

    /* loaded from: classes4.dex */
    private final class d implements p {
        private final int track;

        public d(int i) {
            this.track = i;
        }

        @Override // com.google.android.exoplayer2.source.p
        public boolean isReady() {
            return h.this.Kq(this.track);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void dtM() throws IOException {
            h.this.dtM();
        }

        @Override // com.google.android.exoplayer2.source.p
        public int b(com.google.android.exoplayer2.m mVar, com.google.android.exoplayer2.a.e eVar, boolean z) {
            return h.this.a(this.track, mVar, eVar, z);
        }

        @Override // com.google.android.exoplayer2.source.p
        public int gb(long j) {
            return h.this.F(this.track, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public final class a implements Loader.c {
        private final com.google.android.exoplayer2.upstream.e lZr;
        private final b mmW;
        private final com.google.android.exoplayer2.util.e mmX;
        private volatile boolean mns;
        private long mnu;
        private final Uri uri;
        private final com.google.android.exoplayer2.extractor.k mnr = new com.google.android.exoplayer2.extractor.k();
        private boolean mnt = true;
        private long length = -1;

        public a(Uri uri, com.google.android.exoplayer2.upstream.e eVar, b bVar, com.google.android.exoplayer2.util.e eVar2) {
            this.uri = (Uri) com.google.android.exoplayer2.util.a.checkNotNull(uri);
            this.lZr = (com.google.android.exoplayer2.upstream.e) com.google.android.exoplayer2.util.a.checkNotNull(eVar);
            this.mmW = (b) com.google.android.exoplayer2.util.a.checkNotNull(bVar);
            this.mmX = eVar2;
        }

        public void T(long j, long j2) {
            this.mnr.fIt = j;
            this.mnu = j2;
            this.mnt = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void cancelLoad() {
            this.mns = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public boolean dtU() {
            return this.mns;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.c
        public void load() throws IOException, InterruptedException {
            com.google.android.exoplayer2.extractor.b bVar;
            int i;
            int i2;
            int i3 = 0;
            while (i3 == 0 && !this.mns) {
                try {
                    long j = this.mnr.fIt;
                    this.length = this.lZr.a(new com.google.android.exoplayer2.upstream.g(this.uri, j, -1L, h.this.mmT));
                    if (this.length != -1) {
                        this.length += j;
                    }
                    com.google.android.exoplayer2.extractor.b bVar2 = new com.google.android.exoplayer2.extractor.b(this.lZr, j, this.length);
                    try {
                        com.google.android.exoplayer2.extractor.e a = this.mmW.a(bVar2, this.lZr.getUri());
                        if (this.mnt) {
                            a.O(j, this.mnu);
                            this.mnt = false;
                        }
                        long j2 = j;
                        int i4 = i3;
                        while (i4 == 0) {
                            try {
                                if (this.mns) {
                                    break;
                                }
                                this.mmX.dwN();
                                i = a.a(bVar2, this.mnr);
                                try {
                                    if (bVar2.getPosition() > h.this.mmU + j2) {
                                        j2 = bVar2.getPosition();
                                        this.mmX.LR();
                                        h.this.handler.post(h.this.mmZ);
                                        i4 = i;
                                    } else {
                                        i4 = i;
                                    }
                                } catch (Throwable th) {
                                    bVar = bVar2;
                                    th = th;
                                    if (i != 1 && bVar != null) {
                                        this.mnr.fIt = bVar.getPosition();
                                    }
                                    v.a(this.lZr);
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
                                this.mnr.fIt = bVar2.getPosition();
                            }
                            i2 = i4;
                        }
                        v.a(this.lZr);
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
    /* loaded from: classes4.dex */
    public static final class b {
        private final com.google.android.exoplayer2.extractor.g lZY;
        private final com.google.android.exoplayer2.extractor.e[] mnv;
        private com.google.android.exoplayer2.extractor.e mnw;

        public b(com.google.android.exoplayer2.extractor.e[] eVarArr, com.google.android.exoplayer2.extractor.g gVar) {
            this.mnv = eVarArr;
            this.lZY = gVar;
        }

        public com.google.android.exoplayer2.extractor.e a(com.google.android.exoplayer2.extractor.f fVar, Uri uri) throws IOException, InterruptedException {
            if (this.mnw != null) {
                return this.mnw;
            }
            com.google.android.exoplayer2.extractor.e[] eVarArr = this.mnv;
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
                    fVar.dsq();
                }
                if (!eVar.a(fVar)) {
                    i++;
                } else {
                    this.mnw = eVar;
                    break;
                }
            }
            if (this.mnw == null) {
                throw new UnrecognizedInputFormatException("None of the available extractors (" + v.L(this.mnv) + ") could read the stream.", uri);
            }
            this.mnw.a(this.lZY);
            return this.mnw;
        }

        public void release() {
            if (this.mnw != null) {
                this.mnw.release();
                this.mnw = null;
            }
        }
    }
}
