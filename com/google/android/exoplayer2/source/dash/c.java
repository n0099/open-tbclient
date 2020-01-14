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
    private com.google.android.exoplayer2.upstream.e mdo;
    private final int mqJ;
    private Loader mqP;
    private l.a mqw;
    private final b.a msS;
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> mtA;
    private final Runnable mtB;
    private final Runnable mtC;
    private o mtD;
    private Uri mtE;
    private long mtF;
    private long mtG;
    private long mtH;
    private int mtI;
    private final a.InterfaceC0671a mti;
    private com.google.android.exoplayer2.source.dash.manifest.b mto;
    private final boolean mtt;
    private final e.a mtu;
    private final long mtv;
    private final p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> mtw;
    private final C0672c mty;
    private final Object mtz;

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
        this.mto = bVar;
        this.mtE = uri;
        this.mtu = aVar;
        this.mtw = aVar2;
        this.mti = interfaceC0671a;
        this.mqJ = i;
        this.mtv = j;
        this.mtt = bVar != null;
        this.msS = new b.a(handler, bVar2);
        this.mtz = new Object();
        this.mtA = new SparseArray<>();
        if (this.mtt) {
            com.google.android.exoplayer2.util.a.checkState(bVar.mud ? false : true);
            this.mty = null;
            this.mtB = null;
            this.mtC = null;
            return;
        }
        this.mty = new C0672c();
        this.mtB = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.dvI();
            }
        };
        this.mtC = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.vD(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mqw = aVar;
        if (this.mtt) {
            this.mtD = new o.a();
            vD(false);
            return;
        }
        this.mdo = this.mtu.dxJ();
        this.mqP = new Loader("Loader:DashMediaSource");
        this.mtD = this.mqP;
        this.handler = new Handler();
        dvI();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dva() throws IOException {
        this.mtD.duZ();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int i = bVar.periodIndex;
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(this.mtI + i, this.mto, i, this.mti, this.mqJ, this.msS.gb(this.mto.KU(i).mut), this.mtH, this.mtD, bVar2);
        this.mtA.put(bVar3.id, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.release();
        this.mtA.remove(bVar.id);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mdo = null;
        this.mtD = null;
        if (this.mqP != null) {
            this.mqP.release();
            this.mqP = null;
        }
        this.mtF = 0L;
        this.mtG = 0L;
        this.mto = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.mtH = 0L;
        this.mtA.clear();
    }

    void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
        this.msS.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvz());
        com.google.android.exoplayer2.source.dash.manifest.b result = pVar.getResult();
        int dso = this.mto == null ? 0 : this.mto.dso();
        int i = 0;
        long j3 = result.KU(0).mut;
        while (i < dso && this.mto.KU(i).mut < j3) {
            i++;
        }
        if (dso - i > result.dso()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            dvJ();
            return;
        }
        this.mto = result;
        this.mtF = j - j2;
        this.mtG = j;
        if (this.mto.mui != null) {
            synchronized (this.mtz) {
                if (pVar.dataSpec.uri == this.mtE) {
                    this.mtE = this.mto.mui;
                }
            }
        }
        if (dso == 0) {
            if (this.mto.muh != null) {
                a(this.mto.muh);
                return;
            } else {
                vD(true);
                return;
            }
        }
        this.mtI += i;
        vD(true);
    }

    int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.msS.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvz(), iOException, z);
        return z ? 3 : 0;
    }

    void b(p<Long> pVar, long j, long j2) {
        this.msS.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvz());
        gq(pVar.getResult().longValue() - j);
    }

    int b(p<Long> pVar, long j, long j2, IOException iOException) {
        this.msS.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvz(), iOException, true);
        e(iOException);
        return 2;
    }

    void c(p<?> pVar, long j, long j2) {
        this.msS.b(pVar.dataSpec, pVar.type, j, j2, pVar.dvz());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvI() {
        Uri uri;
        synchronized (this.mtz) {
            uri = this.mtE;
        }
        a(new p(this.mdo, uri, 4, this.mtw), this.mty, this.mqJ);
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
            gq(v.Qq(kVar.value) - this.mtG);
        } catch (ParserException e2) {
            e(e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, p.a<Long> aVar) {
        a(new p(this.mdo, Uri.parse(kVar.value), 5, aVar), new e(), 1);
    }

    private void gq(long j) {
        this.mtH = j;
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
            if (i2 >= this.mtA.size()) {
                break;
            }
            int keyAt = this.mtA.keyAt(i2);
            if (keyAt >= this.mtI) {
                this.mtA.valueAt(i2).a(this.mto, keyAt - this.mtI);
            }
            i = i2 + 1;
        }
        int dso = this.mto.dso() - 1;
        d a2 = d.a(this.mto.KU(0), this.mto.KW(0));
        d a3 = d.a(this.mto.KU(dso), this.mto.KW(dso));
        long j3 = a2.mtM;
        long j4 = a3.mtN;
        if (!this.mto.mud || a3.mtL) {
            j = j3;
            z2 = false;
            j2 = j4;
        } else {
            long min = Math.min((dvK() - com.google.android.exoplayer2.b.fq(this.mto.mub)) - com.google.android.exoplayer2.b.fq(this.mto.KU(dso).mut), j4);
            if (this.mto.muf != -9223372036854775807L) {
                long fq = min - com.google.android.exoplayer2.b.fq(this.mto.muf);
                int i3 = dso;
                while (fq < 0 && i3 > 0) {
                    i3--;
                    fq += this.mto.KW(i3);
                }
                if (i3 == 0) {
                    j3 = Math.max(j3, fq);
                } else {
                    j3 = this.mto.KW(0);
                }
            }
            j = j3;
            z2 = true;
            j2 = min;
        }
        long j5 = j2 - j;
        for (int i4 = 0; i4 < this.mto.dso() - 1; i4++) {
            j5 += this.mto.KW(i4);
        }
        long j6 = 0;
        if (this.mto.mud) {
            long j7 = this.mtv;
            if (j7 == -1) {
                j7 = this.mto.mug != -9223372036854775807L ? this.mto.mug : 30000L;
            }
            j6 = j5 - com.google.android.exoplayer2.b.fq(j7);
            if (j6 < 5000000) {
                j6 = Math.min(5000000L, j5 / 2);
            }
        }
        this.mqw.a(this, new a(this.mto.mub, this.mto.mub + this.mto.KU(0).mut + com.google.android.exoplayer2.b.fp(j), this.mtI, j, j5, j6, this.mto), this.mto);
        if (!this.mtt) {
            this.handler.removeCallbacks(this.mtC);
            if (z2) {
                this.handler.postDelayed(this.mtC, 5000L);
            }
            if (z) {
                dvJ();
            }
        }
    }

    private void dvJ() {
        if (this.mto.mud) {
            long j = this.mto.mue;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.mtB, Math.max(0L, (j + this.mtF) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(p<T> pVar, Loader.a<p<T>> aVar, int i) {
        this.msS.a(pVar.dataSpec, pVar.type, this.mqP.a(pVar, aVar, i));
    }

    private long dvK() {
        return this.mtH != 0 ? com.google.android.exoplayer2.b.fq(SystemClock.elapsedRealtime() + this.mtH) : com.google.android.exoplayer2.b.fq(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d {
        public final boolean mtL;
        public final long mtM;
        public final long mtN;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            boolean z;
            int size = eVar.muu.size();
            long j2 = 0;
            long j3 = Format.OFFSET_SAMPLE_RELATIVE;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                com.google.android.exoplayer2.source.dash.d dvQ = eVar.muu.get(i).mtY.get(0).dvQ();
                if (dvQ == null) {
                    return new d(true, 0L, j);
                }
                boolean dvM = dvQ.dvM() | z2;
                int gs = dvQ.gs(j);
                if (gs == 0) {
                    z = true;
                    j2 = 0;
                    j3 = 0;
                } else {
                    if (!z3) {
                        int dvL = dvQ.dvL();
                        j2 = Math.max(j2, dvQ.KQ(dvL));
                        if (gs != -1) {
                            int i2 = (gs + dvL) - 1;
                            j3 = Math.min(j3, dvQ.G(i2, j) + dvQ.KQ(i2));
                            z = z3;
                        }
                    }
                    z = z3;
                }
                i++;
                z3 = z;
                z2 = dvM;
            }
            return new d(z2, j2, j3);
        }

        private d(boolean z, long j, long j2) {
            this.mtL = z;
            this.mtM = j;
            this.mtN = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a extends x {
        private final long lZG;
        private final long lZH;
        private final long msr;
        private final long mst;
        private final int mtI;
        private final long mtK;
        private final com.google.android.exoplayer2.source.dash.manifest.b mto;

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.lZG = j;
            this.lZH = j2;
            this.mtI = i;
            this.mtK = j3;
            this.msr = j4;
            this.mst = j5;
            this.mto = bVar;
        }

        @Override // com.google.android.exoplayer2.x
        public int dso() {
            return this.mto.dso();
        }

        @Override // com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.util.a.ai(i, 0, this.mto.dso());
            return aVar.a(z ? this.mto.KU(i).id : null, z ? Integer.valueOf(this.mtI + com.google.android.exoplayer2.util.a.ai(i, 0, this.mto.dso())) : null, 0, this.mto.KW(i), com.google.android.exoplayer2.b.fq(this.mto.KU(i).mut - this.mto.KU(0).mut) - this.mtK);
        }

        @Override // com.google.android.exoplayer2.x
        public int dsn() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.util.a.ai(i, 0, 1);
            return bVar.a(null, this.lZG, this.lZH, true, this.mto.mud, gr(j), this.msr, 0, this.mto.dso() - 1, this.mtK);
        }

        @Override // com.google.android.exoplayer2.x
        public int bu(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.mtI && intValue < this.mtI + dso()) {
                return intValue - this.mtI;
            }
            return -1;
        }

        private long gr(long j) {
            com.google.android.exoplayer2.source.dash.d dvQ;
            long j2 = this.mst;
            if (this.mto.mud) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.msr) {
                        return -9223372036854775807L;
                    }
                }
                long j3 = j2;
                long j4 = this.mtK + j3;
                long KW = this.mto.KW(0);
                int i = 0;
                while (i < this.mto.dso() - 1 && j4 >= KW) {
                    long j5 = j4 - KW;
                    int i2 = i + 1;
                    long KW2 = this.mto.KW(i2);
                    i = i2;
                    j4 = j5;
                    KW = KW2;
                }
                com.google.android.exoplayer2.source.dash.manifest.e KU = this.mto.KU(i);
                int KX = KU.KX(2);
                return (KX == -1 || (dvQ = KU.muu.get(KX).mtY.get(0).dvQ()) == null || dvQ.gs(KW) == 0) ? j3 : (dvQ.KQ(dvQ.U(j4, KW)) + j3) - j4;
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
