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
    private com.google.android.exoplayer2.upstream.e mdU;
    private l.a mrc;
    private final int mrp;
    private Loader mrv;
    private final a.InterfaceC0679a mtP;
    private com.google.android.exoplayer2.source.dash.manifest.b mtV;
    private final b.a mtz;
    private final boolean mua;
    private final e.a mub;
    private final long muc;
    private final p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> mud;
    private final C0680c mue;
    private final Object muf;
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> mug;
    private final Runnable muh;
    private final Runnable mui;
    private o muj;
    private Uri muk;
    private long mul;
    private long mum;
    private long mun;
    private int muo;

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
        this.mtV = bVar;
        this.muk = uri;
        this.mub = aVar;
        this.mud = aVar2;
        this.mtP = interfaceC0679a;
        this.mrp = i;
        this.muc = j;
        this.mua = bVar != null;
        this.mtz = new b.a(handler, bVar2);
        this.muf = new Object();
        this.mug = new SparseArray<>();
        if (this.mua) {
            com.google.android.exoplayer2.util.a.checkState(bVar.muJ ? false : true);
            this.mue = null;
            this.muh = null;
            this.mui = null;
            return;
        }
        this.mue = new C0680c();
        this.muh = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.dwS();
            }
        };
        this.mui = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.vH(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mrc = aVar;
        if (this.mua) {
            this.muj = new o.a();
            vH(false);
            return;
        }
        this.mdU = this.mub.dyT();
        this.mrv = new Loader("Loader:DashMediaSource");
        this.muj = this.mrv;
        this.handler = new Handler();
        dwS();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwk() throws IOException {
        this.muj.dwj();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int i = bVar.periodIndex;
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(this.muo + i, this.mtV, i, this.mtP, this.mrp, this.mtz.fZ(this.mtV.KZ(i).muZ), this.mun, this.muj, bVar2);
        this.mug.put(bVar3.id, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.release();
        this.mug.remove(bVar.id);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mdU = null;
        this.muj = null;
        if (this.mrv != null) {
            this.mrv.release();
            this.mrv = null;
        }
        this.mul = 0L;
        this.mum = 0L;
        this.mtV = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.mun = 0L;
        this.mug.clear();
    }

    void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
        this.mtz.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ());
        com.google.android.exoplayer2.source.dash.manifest.b result = pVar.getResult();
        int dtA = this.mtV == null ? 0 : this.mtV.dtA();
        int i = 0;
        long j3 = result.KZ(0).muZ;
        while (i < dtA && this.mtV.KZ(i).muZ < j3) {
            i++;
        }
        if (dtA - i > result.dtA()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            dwT();
            return;
        }
        this.mtV = result;
        this.mul = j - j2;
        this.mum = j;
        if (this.mtV.muO != null) {
            synchronized (this.muf) {
                if (pVar.dataSpec.uri == this.muk) {
                    this.muk = this.mtV.muO;
                }
            }
        }
        if (dtA == 0) {
            if (this.mtV.muN != null) {
                a(this.mtV.muN);
                return;
            } else {
                vH(true);
                return;
            }
        }
        this.muo += i;
        vH(true);
    }

    int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtz.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ(), iOException, z);
        return z ? 3 : 0;
    }

    void b(p<Long> pVar, long j, long j2) {
        this.mtz.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ());
        go(pVar.getResult().longValue() - j);
    }

    int b(p<Long> pVar, long j, long j2, IOException iOException) {
        this.mtz.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ(), iOException, true);
        e(iOException);
        return 2;
    }

    void c(p<?> pVar, long j, long j2) {
        this.mtz.b(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwS() {
        Uri uri;
        synchronized (this.muf) {
            uri = this.muk;
        }
        a(new p(this.mdU, uri, 4, this.mud), this.mue, this.mrp);
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
            go(v.QD(kVar.value) - this.mum);
        } catch (ParserException e2) {
            e(e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, p.a<Long> aVar) {
        a(new p(this.mdU, Uri.parse(kVar.value), 5, aVar), new e(), 1);
    }

    private void go(long j) {
        this.mun = j;
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
            if (i2 >= this.mug.size()) {
                break;
            }
            int keyAt = this.mug.keyAt(i2);
            if (keyAt >= this.muo) {
                this.mug.valueAt(i2).a(this.mtV, keyAt - this.muo);
            }
            i = i2 + 1;
        }
        int dtA = this.mtV.dtA() - 1;
        d a2 = d.a(this.mtV.KZ(0), this.mtV.Lb(0));
        d a3 = d.a(this.mtV.KZ(dtA), this.mtV.Lb(dtA));
        long j3 = a2.mus;
        long j4 = a3.mut;
        if (!this.mtV.muJ || a3.mur) {
            j = j3;
            z2 = false;
            j2 = j4;
        } else {
            long min = Math.min((dwU() - com.google.android.exoplayer2.b.fo(this.mtV.muH)) - com.google.android.exoplayer2.b.fo(this.mtV.KZ(dtA).muZ), j4);
            if (this.mtV.muL != -9223372036854775807L) {
                long fo = min - com.google.android.exoplayer2.b.fo(this.mtV.muL);
                int i3 = dtA;
                while (fo < 0 && i3 > 0) {
                    i3--;
                    fo += this.mtV.Lb(i3);
                }
                if (i3 == 0) {
                    j3 = Math.max(j3, fo);
                } else {
                    j3 = this.mtV.Lb(0);
                }
            }
            j = j3;
            z2 = true;
            j2 = min;
        }
        long j5 = j2 - j;
        for (int i4 = 0; i4 < this.mtV.dtA() - 1; i4++) {
            j5 += this.mtV.Lb(i4);
        }
        long j6 = 0;
        if (this.mtV.muJ) {
            long j7 = this.muc;
            if (j7 == -1) {
                j7 = this.mtV.muM != -9223372036854775807L ? this.mtV.muM : 30000L;
            }
            j6 = j5 - com.google.android.exoplayer2.b.fo(j7);
            if (j6 < 5000000) {
                j6 = Math.min(5000000L, j5 / 2);
            }
        }
        this.mrc.a(this, new a(this.mtV.muH, this.mtV.muH + this.mtV.KZ(0).muZ + com.google.android.exoplayer2.b.fn(j), this.muo, j, j5, j6, this.mtV), this.mtV);
        if (!this.mua) {
            this.handler.removeCallbacks(this.mui);
            if (z2) {
                this.handler.postDelayed(this.mui, 5000L);
            }
            if (z) {
                dwT();
            }
        }
    }

    private void dwT() {
        if (this.mtV.muJ) {
            long j = this.mtV.muK;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.muh, Math.max(0L, (j + this.mul) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(p<T> pVar, Loader.a<p<T>> aVar, int i) {
        this.mtz.a(pVar.dataSpec, pVar.type, this.mrv.a(pVar, aVar, i));
    }

    private long dwU() {
        return this.mun != 0 ? com.google.android.exoplayer2.b.fo(SystemClock.elapsedRealtime() + this.mun) : com.google.android.exoplayer2.b.fo(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class d {
        public final boolean mur;
        public final long mus;
        public final long mut;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            boolean z;
            int size = eVar.mva.size();
            long j2 = 0;
            long j3 = Format.OFFSET_SAMPLE_RELATIVE;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                com.google.android.exoplayer2.source.dash.d dxa = eVar.mva.get(i).muE.get(0).dxa();
                if (dxa == null) {
                    return new d(true, 0L, j);
                }
                boolean dwW = dxa.dwW() | z2;
                int gq = dxa.gq(j);
                if (gq == 0) {
                    z = true;
                    j2 = 0;
                    j3 = 0;
                } else {
                    if (!z3) {
                        int dwV = dxa.dwV();
                        j2 = Math.max(j2, dxa.KV(dwV));
                        if (gq != -1) {
                            int i2 = (gq + dwV) - 1;
                            j3 = Math.min(j3, dxa.F(i2, j) + dxa.KV(i2));
                            z = z3;
                        }
                    }
                    z = z3;
                }
                i++;
                z3 = z;
                z2 = dwW;
            }
            return new d(z2, j2, j3);
        }

        private d(boolean z, long j, long j2) {
            this.mur = z;
            this.mus = j;
            this.mut = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends x {
        private final long man;
        private final long mao;
        private final long msX;
        private final long msZ;
        private final com.google.android.exoplayer2.source.dash.manifest.b mtV;
        private final int muo;
        private final long muq;

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.man = j;
            this.mao = j2;
            this.muo = i;
            this.muq = j3;
            this.msX = j4;
            this.msZ = j5;
            this.mtV = bVar;
        }

        @Override // com.google.android.exoplayer2.x
        public int dtA() {
            return this.mtV.dtA();
        }

        @Override // com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.util.a.aj(i, 0, this.mtV.dtA());
            return aVar.a(z ? this.mtV.KZ(i).id : null, z ? Integer.valueOf(this.muo + com.google.android.exoplayer2.util.a.aj(i, 0, this.mtV.dtA())) : null, 0, this.mtV.Lb(i), com.google.android.exoplayer2.b.fo(this.mtV.KZ(i).muZ - this.mtV.KZ(0).muZ) - this.muq);
        }

        @Override // com.google.android.exoplayer2.x
        public int dtz() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.util.a.aj(i, 0, 1);
            return bVar.a(null, this.man, this.mao, true, this.mtV.muJ, gp(j), this.msX, 0, this.mtV.dtA() - 1, this.muq);
        }

        @Override // com.google.android.exoplayer2.x
        public int bw(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.muo && intValue < this.muo + dtA()) {
                return intValue - this.muo;
            }
            return -1;
        }

        private long gp(long j) {
            com.google.android.exoplayer2.source.dash.d dxa;
            long j2 = this.msZ;
            if (this.mtV.muJ) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.msX) {
                        return -9223372036854775807L;
                    }
                }
                long j3 = j2;
                long j4 = this.muq + j3;
                long Lb = this.mtV.Lb(0);
                int i = 0;
                while (i < this.mtV.dtA() - 1 && j4 >= Lb) {
                    long j5 = j4 - Lb;
                    int i2 = i + 1;
                    long Lb2 = this.mtV.Lb(i2);
                    i = i2;
                    j4 = j5;
                    Lb = Lb2;
                }
                com.google.android.exoplayer2.source.dash.manifest.e KZ = this.mtV.KZ(i);
                int Lc = KZ.Lc(2);
                return (Lc == -1 || (dxa = KZ.mva.get(Lc).muE.get(0).dxa()) == null || dxa.gq(Lb) == 0) ? j3 : (dxa.KV(dxa.T(j4, Lb)) + j3) - j4;
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
