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
    private com.google.android.exoplayer2.upstream.e mdW;
    private l.a mre;
    private final int mrr;
    private Loader mrx;
    private final b.a mtB;
    private final a.InterfaceC0679a mtR;
    private com.google.android.exoplayer2.source.dash.manifest.b mtX;
    private final boolean muc;
    private final e.a mud;
    private final long mue;
    private final p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> muf;
    private final C0680c mug;
    private final Object muh;
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> mui;
    private final Runnable muj;
    private final Runnable muk;
    private o mul;
    private Uri mum;
    private long mun;
    private long muo;
    private long mup;
    private int muq;

    static {
        com.google.android.exoplayer2.l.Pl("goog.exo.dash");
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0679a interfaceC0679a, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, interfaceC0679a, 3, -1L, handler, bVar);
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0679a interfaceC0679a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, new com.google.android.exoplayer2.source.dash.manifest.c(), interfaceC0679a, i, j, handler, bVar);
    }

    public c(Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0679a interfaceC0679a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(null, uri, aVar, aVar2, interfaceC0679a, i, j, handler, bVar);
    }

    private c(com.google.android.exoplayer2.source.dash.manifest.b bVar, Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0679a interfaceC0679a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar2) {
        this.mtX = bVar;
        this.mum = uri;
        this.mud = aVar;
        this.muf = aVar2;
        this.mtR = interfaceC0679a;
        this.mrr = i;
        this.mue = j;
        this.muc = bVar != null;
        this.mtB = new b.a(handler, bVar2);
        this.muh = new Object();
        this.mui = new SparseArray<>();
        if (this.muc) {
            com.google.android.exoplayer2.util.a.checkState(bVar.muL ? false : true);
            this.mug = null;
            this.muj = null;
            this.muk = null;
            return;
        }
        this.mug = new C0680c();
        this.muj = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.dwU();
            }
        };
        this.muk = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.vH(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mre = aVar;
        if (this.muc) {
            this.mul = new o.a();
            vH(false);
            return;
        }
        this.mdW = this.mud.dyV();
        this.mrx = new Loader("Loader:DashMediaSource");
        this.mul = this.mrx;
        this.handler = new Handler();
        dwU();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwm() throws IOException {
        this.mul.dwl();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int i = bVar.periodIndex;
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(this.muq + i, this.mtX, i, this.mtR, this.mrr, this.mtB.fZ(this.mtX.KZ(i).mvb), this.mup, this.mul, bVar2);
        this.mui.put(bVar3.id, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.release();
        this.mui.remove(bVar.id);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mdW = null;
        this.mul = null;
        if (this.mrx != null) {
            this.mrx.release();
            this.mrx = null;
        }
        this.mun = 0L;
        this.muo = 0L;
        this.mtX = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.mup = 0L;
        this.mui.clear();
    }

    void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
        this.mtB.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwL());
        com.google.android.exoplayer2.source.dash.manifest.b result = pVar.getResult();
        int dtC = this.mtX == null ? 0 : this.mtX.dtC();
        int i = 0;
        long j3 = result.KZ(0).mvb;
        while (i < dtC && this.mtX.KZ(i).mvb < j3) {
            i++;
        }
        if (dtC - i > result.dtC()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            dwV();
            return;
        }
        this.mtX = result;
        this.mun = j - j2;
        this.muo = j;
        if (this.mtX.muQ != null) {
            synchronized (this.muh) {
                if (pVar.dataSpec.uri == this.mum) {
                    this.mum = this.mtX.muQ;
                }
            }
        }
        if (dtC == 0) {
            if (this.mtX.muP != null) {
                a(this.mtX.muP);
                return;
            } else {
                vH(true);
                return;
            }
        }
        this.muq += i;
        vH(true);
    }

    int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtB.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwL(), iOException, z);
        return z ? 3 : 0;
    }

    void b(p<Long> pVar, long j, long j2) {
        this.mtB.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwL());
        go(pVar.getResult().longValue() - j);
    }

    int b(p<Long> pVar, long j, long j2, IOException iOException) {
        this.mtB.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwL(), iOException, true);
        e(iOException);
        return 2;
    }

    void c(p<?> pVar, long j, long j2) {
        this.mtB.b(pVar.dataSpec, pVar.type, j, j2, pVar.dwL());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwU() {
        Uri uri;
        synchronized (this.muh) {
            uri = this.mum;
        }
        a(new p(this.mdW, uri, 4, this.muf), this.mug, this.mrr);
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
            go(v.QD(kVar.value) - this.muo);
        } catch (ParserException e2) {
            e(e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, p.a<Long> aVar) {
        a(new p(this.mdW, Uri.parse(kVar.value), 5, aVar), new e(), 1);
    }

    private void go(long j) {
        this.mup = j;
        vH(true);
    }

    private void e(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        vH(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vH(boolean z) {
        long j;
        boolean z2;
        long j2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mui.size()) {
                break;
            }
            int keyAt = this.mui.keyAt(i2);
            if (keyAt >= this.muq) {
                this.mui.valueAt(i2).a(this.mtX, keyAt - this.muq);
            }
            i = i2 + 1;
        }
        int dtC = this.mtX.dtC() - 1;
        d a2 = d.a(this.mtX.KZ(0), this.mtX.Lb(0));
        d a3 = d.a(this.mtX.KZ(dtC), this.mtX.Lb(dtC));
        long j3 = a2.muu;
        long j4 = a3.muv;
        if (!this.mtX.muL || a3.mut) {
            j = j3;
            z2 = false;
            j2 = j4;
        } else {
            long min = Math.min((dwW() - com.google.android.exoplayer2.b.fo(this.mtX.muJ)) - com.google.android.exoplayer2.b.fo(this.mtX.KZ(dtC).mvb), j4);
            if (this.mtX.muN != -9223372036854775807L) {
                long fo = min - com.google.android.exoplayer2.b.fo(this.mtX.muN);
                int i3 = dtC;
                while (fo < 0 && i3 > 0) {
                    i3--;
                    fo += this.mtX.Lb(i3);
                }
                if (i3 == 0) {
                    j3 = Math.max(j3, fo);
                } else {
                    j3 = this.mtX.Lb(0);
                }
            }
            j = j3;
            z2 = true;
            j2 = min;
        }
        long j5 = j2 - j;
        for (int i4 = 0; i4 < this.mtX.dtC() - 1; i4++) {
            j5 += this.mtX.Lb(i4);
        }
        long j6 = 0;
        if (this.mtX.muL) {
            long j7 = this.mue;
            if (j7 == -1) {
                j7 = this.mtX.muO != -9223372036854775807L ? this.mtX.muO : 30000L;
            }
            j6 = j5 - com.google.android.exoplayer2.b.fo(j7);
            if (j6 < 5000000) {
                j6 = Math.min(5000000L, j5 / 2);
            }
        }
        this.mre.a(this, new a(this.mtX.muJ, this.mtX.muJ + this.mtX.KZ(0).mvb + com.google.android.exoplayer2.b.fn(j), this.muq, j, j5, j6, this.mtX), this.mtX);
        if (!this.muc) {
            this.handler.removeCallbacks(this.muk);
            if (z2) {
                this.handler.postDelayed(this.muk, 5000L);
            }
            if (z) {
                dwV();
            }
        }
    }

    private void dwV() {
        if (this.mtX.muL) {
            long j = this.mtX.muM;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.muj, Math.max(0L, (j + this.mun) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(p<T> pVar, Loader.a<p<T>> aVar, int i) {
        this.mtB.a(pVar.dataSpec, pVar.type, this.mrx.a(pVar, aVar, i));
    }

    private long dwW() {
        return this.mup != 0 ? com.google.android.exoplayer2.b.fo(SystemClock.elapsedRealtime() + this.mup) : com.google.android.exoplayer2.b.fo(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class d {
        public final boolean mut;
        public final long muu;
        public final long muv;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            boolean z;
            int size = eVar.mvc.size();
            long j2 = 0;
            long j3 = Format.OFFSET_SAMPLE_RELATIVE;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                com.google.android.exoplayer2.source.dash.d dxc = eVar.mvc.get(i).muG.get(0).dxc();
                if (dxc == null) {
                    return new d(true, 0L, j);
                }
                boolean dwY = dxc.dwY() | z2;
                int gq = dxc.gq(j);
                if (gq == 0) {
                    z = true;
                    j2 = 0;
                    j3 = 0;
                } else {
                    if (!z3) {
                        int dwX = dxc.dwX();
                        j2 = Math.max(j2, dxc.KV(dwX));
                        if (gq != -1) {
                            int i2 = (gq + dwX) - 1;
                            j3 = Math.min(j3, dxc.F(i2, j) + dxc.KV(i2));
                            z = z3;
                        }
                    }
                    z = z3;
                }
                i++;
                z3 = z;
                z2 = dwY;
            }
            return new d(z2, j2, j3);
        }

        private d(boolean z, long j, long j2) {
            this.mut = z;
            this.muu = j;
            this.muv = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends x {
        private final long maq;
        private final long mar;
        private final long msZ;
        private final com.google.android.exoplayer2.source.dash.manifest.b mtX;
        private final long mtb;
        private final int muq;
        private final long mus;

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.maq = j;
            this.mar = j2;
            this.muq = i;
            this.mus = j3;
            this.msZ = j4;
            this.mtb = j5;
            this.mtX = bVar;
        }

        @Override // com.google.android.exoplayer2.x
        public int dtC() {
            return this.mtX.dtC();
        }

        @Override // com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.util.a.aj(i, 0, this.mtX.dtC());
            return aVar.a(z ? this.mtX.KZ(i).id : null, z ? Integer.valueOf(this.muq + com.google.android.exoplayer2.util.a.aj(i, 0, this.mtX.dtC())) : null, 0, this.mtX.Lb(i), com.google.android.exoplayer2.b.fo(this.mtX.KZ(i).mvb - this.mtX.KZ(0).mvb) - this.mus);
        }

        @Override // com.google.android.exoplayer2.x
        public int dtB() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.util.a.aj(i, 0, 1);
            return bVar.a(null, this.maq, this.mar, true, this.mtX.muL, gp(j), this.msZ, 0, this.mtX.dtC() - 1, this.mus);
        }

        @Override // com.google.android.exoplayer2.x
        public int bw(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.muq && intValue < this.muq + dtC()) {
                return intValue - this.muq;
            }
            return -1;
        }

        private long gp(long j) {
            com.google.android.exoplayer2.source.dash.d dxc;
            long j2 = this.mtb;
            if (this.mtX.muL) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.msZ) {
                        return -9223372036854775807L;
                    }
                }
                long j3 = j2;
                long j4 = this.mus + j3;
                long Lb = this.mtX.Lb(0);
                int i = 0;
                while (i < this.mtX.dtC() - 1 && j4 >= Lb) {
                    long j5 = j4 - Lb;
                    int i2 = i + 1;
                    long Lb2 = this.mtX.Lb(i2);
                    i = i2;
                    j4 = j5;
                    Lb = Lb2;
                }
                com.google.android.exoplayer2.source.dash.manifest.e KZ = this.mtX.KZ(i);
                int Lc = KZ.Lc(2);
                return (Lc == -1 || (dxc = KZ.mvc.get(Lc).muG.get(0).dxc()) == null || dxc.gq(Lb) == 0) ? j3 : (dxc.KV(dxc.T(j4, Lb)) + j3) - j4;
            }
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.source.dash.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C0680c implements Loader.a<p<com.google.android.exoplayer2.source.dash.manifest.b>> {
        private C0680c() {
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
