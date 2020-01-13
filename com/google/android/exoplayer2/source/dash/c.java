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
/* loaded from: classes5.dex */
public final class c implements l {
    private Handler handler;
    private com.google.android.exoplayer2.upstream.e mdj;
    private final int mqE;
    private Loader mqK;
    private l.a mqr;
    private final b.a msN;
    private long mtA;
    private long mtB;
    private long mtC;
    private int mtD;
    private final a.InterfaceC0671a mtd;
    private com.google.android.exoplayer2.source.dash.manifest.b mtj;
    private final boolean mto;
    private final e.a mtp;
    private final long mtq;
    private final p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> mtr;
    private final C0672c mts;
    private final Object mtt;
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> mtu;
    private final Runnable mtv;
    private final Runnable mtw;
    private o mty;
    private Uri mtz;

    static {
        com.google.android.exoplayer2.l.OY("goog.exo.dash");
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0671a interfaceC0671a, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, interfaceC0671a, 3, -1L, handler, bVar);
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0671a interfaceC0671a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, new com.google.android.exoplayer2.source.dash.manifest.c(), interfaceC0671a, i, j, handler, bVar);
    }

    public c(Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0671a interfaceC0671a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(null, uri, aVar, aVar2, interfaceC0671a, i, j, handler, bVar);
    }

    private c(com.google.android.exoplayer2.source.dash.manifest.b bVar, Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0671a interfaceC0671a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar2) {
        this.mtj = bVar;
        this.mtz = uri;
        this.mtp = aVar;
        this.mtr = aVar2;
        this.mtd = interfaceC0671a;
        this.mqE = i;
        this.mtq = j;
        this.mto = bVar != null;
        this.msN = new b.a(handler, bVar2);
        this.mtt = new Object();
        this.mtu = new SparseArray<>();
        if (this.mto) {
            com.google.android.exoplayer2.util.a.checkState(bVar.mtY ? false : true);
            this.mts = null;
            this.mtv = null;
            this.mtw = null;
            return;
        }
        this.mts = new C0672c();
        this.mtv = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.dvG();
            }
        };
        this.mtw = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.vD(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mqr = aVar;
        if (this.mto) {
            this.mty = new o.a();
            vD(false);
            return;
        }
        this.mdj = this.mtp.dxH();
        this.mqK = new Loader("Loader:DashMediaSource");
        this.mty = this.mqK;
        this.handler = new Handler();
        dvG();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void duY() throws IOException {
        this.mty.duX();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int i = bVar.periodIndex;
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(this.mtD + i, this.mtj, i, this.mtd, this.mqE, this.msN.gb(this.mtj.KU(i).muo), this.mtC, this.mty, bVar2);
        this.mtu.put(bVar3.id, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.release();
        this.mtu.remove(bVar.id);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mdj = null;
        this.mty = null;
        if (this.mqK != null) {
            this.mqK.release();
            this.mqK = null;
        }
        this.mtA = 0L;
        this.mtB = 0L;
        this.mtj = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.mtC = 0L;
        this.mtu.clear();
    }

    void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
        this.msN.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvx());
        com.google.android.exoplayer2.source.dash.manifest.b result = pVar.getResult();
        int dsm = this.mtj == null ? 0 : this.mtj.dsm();
        int i = 0;
        long j3 = result.KU(0).muo;
        while (i < dsm && this.mtj.KU(i).muo < j3) {
            i++;
        }
        if (dsm - i > result.dsm()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            dvH();
            return;
        }
        this.mtj = result;
        this.mtA = j - j2;
        this.mtB = j;
        if (this.mtj.mud != null) {
            synchronized (this.mtt) {
                if (pVar.dataSpec.uri == this.mtz) {
                    this.mtz = this.mtj.mud;
                }
            }
        }
        if (dsm == 0) {
            if (this.mtj.muc != null) {
                a(this.mtj.muc);
                return;
            } else {
                vD(true);
                return;
            }
        }
        this.mtD += i;
        vD(true);
    }

    int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.msN.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvx(), iOException, z);
        return z ? 3 : 0;
    }

    void b(p<Long> pVar, long j, long j2) {
        this.msN.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvx());
        gq(pVar.getResult().longValue() - j);
    }

    int b(p<Long> pVar, long j, long j2, IOException iOException) {
        this.msN.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvx(), iOException, true);
        e(iOException);
        return 2;
    }

    void c(p<?> pVar, long j, long j2) {
        this.msN.b(pVar.dataSpec, pVar.type, j, j2, pVar.dvx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvG() {
        Uri uri;
        synchronized (this.mtt) {
            uri = this.mtz;
        }
        a(new p(this.mdj, uri, 4, this.mtr), this.mts, this.mqE);
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
            gq(v.Qq(kVar.value) - this.mtB);
        } catch (ParserException e2) {
            e(e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, p.a<Long> aVar) {
        a(new p(this.mdj, Uri.parse(kVar.value), 5, aVar), new e(), 1);
    }

    private void gq(long j) {
        this.mtC = j;
        vD(true);
    }

    private void e(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        vD(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vD(boolean z) {
        long j;
        boolean z2;
        long j2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mtu.size()) {
                break;
            }
            int keyAt = this.mtu.keyAt(i2);
            if (keyAt >= this.mtD) {
                this.mtu.valueAt(i2).a(this.mtj, keyAt - this.mtD);
            }
            i = i2 + 1;
        }
        int dsm = this.mtj.dsm() - 1;
        d a2 = d.a(this.mtj.KU(0), this.mtj.KW(0));
        d a3 = d.a(this.mtj.KU(dsm), this.mtj.KW(dsm));
        long j3 = a2.mtH;
        long j4 = a3.mtI;
        if (!this.mtj.mtY || a3.mtG) {
            j = j3;
            z2 = false;
            j2 = j4;
        } else {
            long min = Math.min((dvI() - com.google.android.exoplayer2.b.fq(this.mtj.mtW)) - com.google.android.exoplayer2.b.fq(this.mtj.KU(dsm).muo), j4);
            if (this.mtj.mua != -9223372036854775807L) {
                long fq = min - com.google.android.exoplayer2.b.fq(this.mtj.mua);
                int i3 = dsm;
                while (fq < 0 && i3 > 0) {
                    i3--;
                    fq += this.mtj.KW(i3);
                }
                if (i3 == 0) {
                    j3 = Math.max(j3, fq);
                } else {
                    j3 = this.mtj.KW(0);
                }
            }
            j = j3;
            z2 = true;
            j2 = min;
        }
        long j5 = j2 - j;
        for (int i4 = 0; i4 < this.mtj.dsm() - 1; i4++) {
            j5 += this.mtj.KW(i4);
        }
        long j6 = 0;
        if (this.mtj.mtY) {
            long j7 = this.mtq;
            if (j7 == -1) {
                j7 = this.mtj.mub != -9223372036854775807L ? this.mtj.mub : 30000L;
            }
            j6 = j5 - com.google.android.exoplayer2.b.fq(j7);
            if (j6 < 5000000) {
                j6 = Math.min(5000000L, j5 / 2);
            }
        }
        this.mqr.a(this, new a(this.mtj.mtW, this.mtj.mtW + this.mtj.KU(0).muo + com.google.android.exoplayer2.b.fp(j), this.mtD, j, j5, j6, this.mtj), this.mtj);
        if (!this.mto) {
            this.handler.removeCallbacks(this.mtw);
            if (z2) {
                this.handler.postDelayed(this.mtw, 5000L);
            }
            if (z) {
                dvH();
            }
        }
    }

    private void dvH() {
        if (this.mtj.mtY) {
            long j = this.mtj.mtZ;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.mtv, Math.max(0L, (j + this.mtA) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(p<T> pVar, Loader.a<p<T>> aVar, int i) {
        this.msN.a(pVar.dataSpec, pVar.type, this.mqK.a(pVar, aVar, i));
    }

    private long dvI() {
        return this.mtC != 0 ? com.google.android.exoplayer2.b.fq(SystemClock.elapsedRealtime() + this.mtC) : com.google.android.exoplayer2.b.fq(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d {
        public final boolean mtG;
        public final long mtH;
        public final long mtI;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            boolean z;
            int size = eVar.mup.size();
            long j2 = 0;
            long j3 = Format.OFFSET_SAMPLE_RELATIVE;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                com.google.android.exoplayer2.source.dash.d dvO = eVar.mup.get(i).mtT.get(0).dvO();
                if (dvO == null) {
                    return new d(true, 0L, j);
                }
                boolean dvK = dvO.dvK() | z2;
                int gs = dvO.gs(j);
                if (gs == 0) {
                    z = true;
                    j2 = 0;
                    j3 = 0;
                } else {
                    if (!z3) {
                        int dvJ = dvO.dvJ();
                        j2 = Math.max(j2, dvO.KQ(dvJ));
                        if (gs != -1) {
                            int i2 = (gs + dvJ) - 1;
                            j3 = Math.min(j3, dvO.G(i2, j) + dvO.KQ(i2));
                            z = z3;
                        }
                    }
                    z = z3;
                }
                i++;
                z3 = z;
                z2 = dvK;
            }
            return new d(z2, j2, j3);
        }

        private d(boolean z, long j, long j2) {
            this.mtG = z;
            this.mtH = j;
            this.mtI = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a extends x {
        private final long lZB;
        private final long lZC;
        private final long msm;
        private final long mso;
        private final int mtD;
        private final long mtF;
        private final com.google.android.exoplayer2.source.dash.manifest.b mtj;

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.lZB = j;
            this.lZC = j2;
            this.mtD = i;
            this.mtF = j3;
            this.msm = j4;
            this.mso = j5;
            this.mtj = bVar;
        }

        @Override // com.google.android.exoplayer2.x
        public int dsm() {
            return this.mtj.dsm();
        }

        @Override // com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.util.a.ai(i, 0, this.mtj.dsm());
            return aVar.a(z ? this.mtj.KU(i).id : null, z ? Integer.valueOf(this.mtD + com.google.android.exoplayer2.util.a.ai(i, 0, this.mtj.dsm())) : null, 0, this.mtj.KW(i), com.google.android.exoplayer2.b.fq(this.mtj.KU(i).muo - this.mtj.KU(0).muo) - this.mtF);
        }

        @Override // com.google.android.exoplayer2.x
        public int dsl() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.util.a.ai(i, 0, 1);
            return bVar.a(null, this.lZB, this.lZC, true, this.mtj.mtY, gr(j), this.msm, 0, this.mtj.dsm() - 1, this.mtF);
        }

        @Override // com.google.android.exoplayer2.x
        public int bu(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.mtD && intValue < this.mtD + dsm()) {
                return intValue - this.mtD;
            }
            return -1;
        }

        private long gr(long j) {
            com.google.android.exoplayer2.source.dash.d dvO;
            long j2 = this.mso;
            if (this.mtj.mtY) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.msm) {
                        return -9223372036854775807L;
                    }
                }
                long j3 = j2;
                long j4 = this.mtF + j3;
                long KW = this.mtj.KW(0);
                int i = 0;
                while (i < this.mtj.dsm() - 1 && j4 >= KW) {
                    long j5 = j4 - KW;
                    int i2 = i + 1;
                    long KW2 = this.mtj.KW(i2);
                    i = i2;
                    j4 = j5;
                    KW = KW2;
                }
                com.google.android.exoplayer2.source.dash.manifest.e KU = this.mtj.KU(i);
                int KX = KU.KX(2);
                return (KX == -1 || (dvO = KU.mup.get(KX).mtT.get(0).dvO()) == null || dvO.gs(KW) == 0) ? j3 : (dvO.KQ(dvO.U(j4, KW)) + j3) - j4;
            }
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.source.dash.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public final class C0672c implements Loader.a<p<com.google.android.exoplayer2.source.dash.manifest.b>> {
        private C0672c() {
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
    /* loaded from: classes5.dex */
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
    /* loaded from: classes5.dex */
    public static final class f implements p.a<Long> {
        private f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.p.a
        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(v.Qq(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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
