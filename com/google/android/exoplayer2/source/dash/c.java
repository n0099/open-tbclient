package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes6.dex */
public final class c implements l {
    private Handler handler;
    private com.google.android.exoplayer2.upstream.e mfN;
    private l.a msW;
    private final int mtj;
    private Loader mtp;
    private final a.InterfaceC0680a mvI;
    private com.google.android.exoplayer2.source.dash.manifest.b mvO;
    private final boolean mvT;
    private final e.a mvU;
    private final long mvV;
    private final p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> mvW;
    private final C0681c mvX;
    private final Object mvY;
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> mvZ;
    private final b.a mvs;
    private final Runnable mwa;
    private final Runnable mwb;
    private o mwc;
    private Uri mwd;
    private long mwe;
    private long mwf;
    private long mwg;
    private int mwh;

    static {
        com.google.android.exoplayer2.l.Pl("goog.exo.dash");
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0680a interfaceC0680a, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, interfaceC0680a, 3, -1L, handler, bVar);
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0680a interfaceC0680a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, new com.google.android.exoplayer2.source.dash.manifest.c(), interfaceC0680a, i, j, handler, bVar);
    }

    public c(Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0680a interfaceC0680a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(null, uri, aVar, aVar2, interfaceC0680a, i, j, handler, bVar);
    }

    private c(com.google.android.exoplayer2.source.dash.manifest.b bVar, Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0680a interfaceC0680a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar2) {
        this.mvO = bVar;
        this.mwd = uri;
        this.mvU = aVar;
        this.mvW = aVar2;
        this.mvI = interfaceC0680a;
        this.mtj = i;
        this.mvV = j;
        this.mvT = bVar != null;
        this.mvs = new b.a(handler, bVar2);
        this.mvY = new Object();
        this.mvZ = new SparseArray<>();
        if (this.mvT) {
            com.google.android.exoplayer2.util.a.checkState(bVar.mwC ? false : true);
            this.mvX = null;
            this.mwa = null;
            this.mwb = null;
            return;
        }
        this.mvX = new C0681c();
        this.mwa = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.dxs();
            }
        };
        this.mwb = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.vO(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.msW = aVar;
        if (this.mvT) {
            this.mwc = new o.a();
            vO(false);
            return;
        }
        this.mfN = this.mvU.dzt();
        this.mtp = new Loader("Loader:DashMediaSource");
        this.mwc = this.mtp;
        this.handler = new Handler();
        dxs();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwK() throws IOException {
        this.mwc.dwJ();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int i = bVar.periodIndex;
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(this.mwh + i, this.mvO, i, this.mvI, this.mtj, this.mvs.ga(this.mvO.Lf(i).mwS), this.mwg, this.mwc, bVar2);
        this.mvZ.put(bVar3.id, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.release();
        this.mvZ.remove(bVar.id);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mfN = null;
        this.mwc = null;
        if (this.mtp != null) {
            this.mtp.release();
            this.mtp = null;
        }
        this.mwe = 0L;
        this.mwf = 0L;
        this.mvO = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.mwg = 0L;
        this.mvZ.clear();
    }

    void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
        this.mvs.a(pVar.dataSpec, pVar.type, j, j2, pVar.dxj());
        com.google.android.exoplayer2.source.dash.manifest.b result = pVar.getResult();
        int dua = this.mvO == null ? 0 : this.mvO.dua();
        int i = 0;
        long j3 = result.Lf(0).mwS;
        while (i < dua && this.mvO.Lf(i).mwS < j3) {
            i++;
        }
        if (dua - i > result.dua()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            dxt();
            return;
        }
        this.mvO = result;
        this.mwe = j - j2;
        this.mwf = j;
        if (this.mvO.mwH != null) {
            synchronized (this.mvY) {
                if (pVar.dataSpec.uri == this.mwd) {
                    this.mwd = this.mvO.mwH;
                }
            }
        }
        if (dua == 0) {
            if (this.mvO.mwG != null) {
                a(this.mvO.mwG);
                return;
            } else {
                vO(true);
                return;
            }
        }
        this.mwh += i;
        vO(true);
    }

    int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mvs.a(pVar.dataSpec, pVar.type, j, j2, pVar.dxj(), iOException, z);
        return z ? 3 : 0;
    }

    void b(p<Long> pVar, long j, long j2) {
        this.mvs.a(pVar.dataSpec, pVar.type, j, j2, pVar.dxj());
        gp(pVar.getResult().longValue() - j);
    }

    int b(p<Long> pVar, long j, long j2, IOException iOException) {
        this.mvs.a(pVar.dataSpec, pVar.type, j, j2, pVar.dxj(), iOException, true);
        e(iOException);
        return 2;
    }

    void c(p<?> pVar, long j, long j2) {
        this.mvs.b(pVar.dataSpec, pVar.type, j, j2, pVar.dxj());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxs() {
        Uri uri;
        synchronized (this.mvY) {
            uri = this.mwd;
        }
        a(new p(this.mfN, uri, 4, this.mvW), this.mvX, this.mtj);
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar) {
        String str = kVar.schemeIdUri;
        if (v.h(str, "urn:mpeg:dash:utc:direct:2014") || v.h(str, "urn:mpeg:dash:utc:direct:2012")) {
            b(kVar);
        } else if (v.h(str, "urn:mpeg:dash:utc:http-iso:2014") || v.h(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            a(kVar, new b());
        } else if (v.h(str, "urn:mpeg:dash:utc:http-xsdate:2014") || v.h(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            a(kVar, new f());
        } else {
            e(new IOException("Unsupported UTC timing scheme"));
        }
    }

    private void b(com.google.android.exoplayer2.source.dash.manifest.k kVar) {
        try {
            gp(v.QD(kVar.value) - this.mwf);
        } catch (ParserException e2) {
            e(e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, p.a<Long> aVar) {
        a(new p(this.mfN, Uri.parse(kVar.value), 5, aVar), new e(), 1);
    }

    private void gp(long j) {
        this.mwg = j;
        vO(true);
    }

    private void e(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        vO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(boolean z) {
        long j;
        boolean z2;
        long j2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mvZ.size()) {
                break;
            }
            int keyAt = this.mvZ.keyAt(i2);
            if (keyAt >= this.mwh) {
                this.mvZ.valueAt(i2).a(this.mvO, keyAt - this.mwh);
            }
            i = i2 + 1;
        }
        int dua = this.mvO.dua() - 1;
        d a2 = d.a(this.mvO.Lf(0), this.mvO.Lh(0));
        d a3 = d.a(this.mvO.Lf(dua), this.mvO.Lh(dua));
        long j3 = a2.mwl;
        long j4 = a3.mwm;
        if (!this.mvO.mwC || a3.mwk) {
            j = j3;
            z2 = false;
            j2 = j4;
        } else {
            long min = Math.min((dxu() - com.google.android.exoplayer2.b.fp(this.mvO.mwA)) - com.google.android.exoplayer2.b.fp(this.mvO.Lf(dua).mwS), j4);
            if (this.mvO.mwE != -9223372036854775807L) {
                long fp = min - com.google.android.exoplayer2.b.fp(this.mvO.mwE);
                int i3 = dua;
                while (fp < 0 && i3 > 0) {
                    i3--;
                    fp += this.mvO.Lh(i3);
                }
                if (i3 == 0) {
                    j3 = Math.max(j3, fp);
                } else {
                    j3 = this.mvO.Lh(0);
                }
            }
            j = j3;
            z2 = true;
            j2 = min;
        }
        long j5 = j2 - j;
        for (int i4 = 0; i4 < this.mvO.dua() - 1; i4++) {
            j5 += this.mvO.Lh(i4);
        }
        long j6 = 0;
        if (this.mvO.mwC) {
            long j7 = this.mvV;
            if (j7 == -1) {
                j7 = this.mvO.mwF != -9223372036854775807L ? this.mvO.mwF : 30000L;
            }
            j6 = j5 - com.google.android.exoplayer2.b.fp(j7);
            if (j6 < 5000000) {
                j6 = Math.min(5000000L, j5 / 2);
            }
        }
        this.msW.a(this, new a(this.mvO.mwA, this.mvO.mwA + this.mvO.Lf(0).mwS + com.google.android.exoplayer2.b.fo(j), this.mwh, j, j5, j6, this.mvO), this.mvO);
        if (!this.mvT) {
            this.handler.removeCallbacks(this.mwb);
            if (z2) {
                this.handler.postDelayed(this.mwb, 5000L);
            }
            if (z) {
                dxt();
            }
        }
    }

    private void dxt() {
        if (this.mvO.mwC) {
            long j = this.mvO.mwD;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.mwa, Math.max(0L, (j + this.mwe) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(p<T> pVar, Loader.a<p<T>> aVar, int i) {
        this.mvs.a(pVar.dataSpec, pVar.type, this.mtp.a(pVar, aVar, i));
    }

    private long dxu() {
        return this.mwg != 0 ? com.google.android.exoplayer2.b.fp(SystemClock.elapsedRealtime() + this.mwg) : com.google.android.exoplayer2.b.fp(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class d {
        public final boolean mwk;
        public final long mwl;
        public final long mwm;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            boolean z;
            int size = eVar.mwT.size();
            long j2 = 0;
            long j3 = Format.OFFSET_SAMPLE_RELATIVE;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                com.google.android.exoplayer2.source.dash.d dxA = eVar.mwT.get(i).mwx.get(0).dxA();
                if (dxA == null) {
                    return new d(true, 0L, j);
                }
                boolean dxw = dxA.dxw() | z2;
                int gr = dxA.gr(j);
                if (gr == 0) {
                    z = true;
                    j2 = 0;
                    j3 = 0;
                } else {
                    if (!z3) {
                        int dxv = dxA.dxv();
                        j2 = Math.max(j2, dxA.Lb(dxv));
                        if (gr != -1) {
                            int i2 = (gr + dxv) - 1;
                            j3 = Math.min(j3, dxA.F(i2, j) + dxA.Lb(i2));
                            z = z3;
                        }
                    }
                    z = z3;
                }
                i++;
                z3 = z;
                z2 = dxw;
            }
            return new d(z2, j2, j3);
        }

        private d(boolean z, long j, long j2) {
            this.mwk = z;
            this.mwl = j;
            this.mwm = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends x {
        private final long mci;
        private final long mcj;
        private final long muR;
        private final long muT;
        private final com.google.android.exoplayer2.source.dash.manifest.b mvO;
        private final int mwh;
        private final long mwj;

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.mci = j;
            this.mcj = j2;
            this.mwh = i;
            this.mwj = j3;
            this.muR = j4;
            this.muT = j5;
            this.mvO = bVar;
        }

        @Override // com.google.android.exoplayer2.x
        public int dua() {
            return this.mvO.dua();
        }

        @Override // com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.util.a.aj(i, 0, this.mvO.dua());
            return aVar.a(z ? this.mvO.Lf(i).id : null, z ? Integer.valueOf(this.mwh + com.google.android.exoplayer2.util.a.aj(i, 0, this.mvO.dua())) : null, 0, this.mvO.Lh(i), com.google.android.exoplayer2.b.fp(this.mvO.Lf(i).mwS - this.mvO.Lf(0).mwS) - this.mwj);
        }

        @Override // com.google.android.exoplayer2.x
        public int dtZ() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.util.a.aj(i, 0, 1);
            return bVar.a(null, this.mci, this.mcj, true, this.mvO.mwC, gq(j), this.muR, 0, this.mvO.dua() - 1, this.mwj);
        }

        @Override // com.google.android.exoplayer2.x
        public int bw(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.mwh && intValue < this.mwh + dua()) {
                return intValue - this.mwh;
            }
            return -1;
        }

        private long gq(long j) {
            com.google.android.exoplayer2.source.dash.d dxA;
            long j2 = this.muT;
            if (this.mvO.mwC) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.muR) {
                        return -9223372036854775807L;
                    }
                }
                long j3 = j2;
                long j4 = this.mwj + j3;
                long Lh = this.mvO.Lh(0);
                int i = 0;
                while (i < this.mvO.dua() - 1 && j4 >= Lh) {
                    long j5 = j4 - Lh;
                    int i2 = i + 1;
                    long Lh2 = this.mvO.Lh(i2);
                    i = i2;
                    j4 = j5;
                    Lh = Lh2;
                }
                com.google.android.exoplayer2.source.dash.manifest.e Lf = this.mvO.Lf(i);
                int Li = Lf.Li(2);
                return (Li == -1 || (dxA = Lf.mwT.get(Li).mwx.get(0).dxA()) == null || dxA.gr(Lh) == 0) ? j3 : (dxA.Lb(dxA.T(j4, Lh)) + j3) - j4;
            }
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.source.dash.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C0681c implements Loader.a<p<com.google.android.exoplayer2.source.dash.manifest.b>> {
        private C0681c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
            c.this.a(pVar, j, j2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, boolean z) {
            c.this.c(pVar, j, j2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
            return c.this.a(pVar, j, j2, iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class e implements Loader.a<p<Long>> {
        private e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<Long> pVar, long j, long j2) {
            c.this.b(pVar, j, j2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<Long> pVar, long j, long j2, boolean z) {
            c.this.c(pVar, j, j2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<Long> pVar, long j, long j2, IOException iOException) {
            return c.this.b(pVar, j, j2, iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class f implements p.a<Long> {
        private f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.p.a
        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(v.QD(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b implements p.a<Long> {
        private b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.p.a
        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                return Long.valueOf(simpleDateFormat.parse(readLine).getTime());
            } catch (ParseException e) {
                throw new ParserException(e);
            }
        }
    }
}
