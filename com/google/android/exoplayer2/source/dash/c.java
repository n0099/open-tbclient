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
    private com.google.android.exoplayer2.upstream.e meh;
    private final int mrC;
    private Loader mrI;
    private l.a mrp;
    private final b.a mtM;
    private long muA;
    private int muB;
    private final a.InterfaceC0679a muc;
    private com.google.android.exoplayer2.source.dash.manifest.b mui;
    private final boolean mun;
    private final e.a muo;
    private final long mup;
    private final p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> muq;
    private final C0680c mur;
    private final Object mus;
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> mut;
    private final Runnable muu;
    private final Runnable muv;
    private o muw;
    private Uri mux;
    private long muy;
    private long muz;

    static {
        com.google.android.exoplayer2.l.Pm("goog.exo.dash");
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
        this.mui = bVar;
        this.mux = uri;
        this.muo = aVar;
        this.muq = aVar2;
        this.muc = interfaceC0679a;
        this.mrC = i;
        this.mup = j;
        this.mun = bVar != null;
        this.mtM = new b.a(handler, bVar2);
        this.mus = new Object();
        this.mut = new SparseArray<>();
        if (this.mun) {
            com.google.android.exoplayer2.util.a.checkState(bVar.muW ? false : true);
            this.mur = null;
            this.muu = null;
            this.muv = null;
            return;
        }
        this.mur = new C0680c();
        this.muu = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.dwV();
            }
        };
        this.muv = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.vH(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mrp = aVar;
        if (this.mun) {
            this.muw = new o.a();
            vH(false);
            return;
        }
        this.meh = this.muo.dyW();
        this.mrI = new Loader("Loader:DashMediaSource");
        this.muw = this.mrI;
        this.handler = new Handler();
        dwV();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwn() throws IOException {
        this.muw.dwm();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int i = bVar.periodIndex;
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(this.muB + i, this.mui, i, this.muc, this.mrC, this.mtM.fZ(this.mui.KZ(i).mvm), this.muA, this.muw, bVar2);
        this.mut.put(bVar3.id, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.release();
        this.mut.remove(bVar.id);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.meh = null;
        this.muw = null;
        if (this.mrI != null) {
            this.mrI.release();
            this.mrI = null;
        }
        this.muy = 0L;
        this.muz = 0L;
        this.mui = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.muA = 0L;
        this.mut.clear();
    }

    void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
        this.mtM.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwM());
        com.google.android.exoplayer2.source.dash.manifest.b result = pVar.getResult();
        int dtD = this.mui == null ? 0 : this.mui.dtD();
        int i = 0;
        long j3 = result.KZ(0).mvm;
        while (i < dtD && this.mui.KZ(i).mvm < j3) {
            i++;
        }
        if (dtD - i > result.dtD()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            dwW();
            return;
        }
        this.mui = result;
        this.muy = j - j2;
        this.muz = j;
        if (this.mui.mvb != null) {
            synchronized (this.mus) {
                if (pVar.dataSpec.uri == this.mux) {
                    this.mux = this.mui.mvb;
                }
            }
        }
        if (dtD == 0) {
            if (this.mui.mva != null) {
                a(this.mui.mva);
                return;
            } else {
                vH(true);
                return;
            }
        }
        this.muB += i;
        vH(true);
    }

    int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtM.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwM(), iOException, z);
        return z ? 3 : 0;
    }

    void b(p<Long> pVar, long j, long j2) {
        this.mtM.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwM());
        go(pVar.getResult().longValue() - j);
    }

    int b(p<Long> pVar, long j, long j2, IOException iOException) {
        this.mtM.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwM(), iOException, true);
        e(iOException);
        return 2;
    }

    void c(p<?> pVar, long j, long j2) {
        this.mtM.b(pVar.dataSpec, pVar.type, j, j2, pVar.dwM());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwV() {
        Uri uri;
        synchronized (this.mus) {
            uri = this.mux;
        }
        a(new p(this.meh, uri, 4, this.muq), this.mur, this.mrC);
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
            go(v.QE(kVar.value) - this.muz);
        } catch (ParserException e2) {
            e(e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, p.a<Long> aVar) {
        a(new p(this.meh, Uri.parse(kVar.value), 5, aVar), new e(), 1);
    }

    private void go(long j) {
        this.muA = j;
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
            if (i2 >= this.mut.size()) {
                break;
            }
            int keyAt = this.mut.keyAt(i2);
            if (keyAt >= this.muB) {
                this.mut.valueAt(i2).a(this.mui, keyAt - this.muB);
            }
            i = i2 + 1;
        }
        int dtD = this.mui.dtD() - 1;
        d a2 = d.a(this.mui.KZ(0), this.mui.Lb(0));
        d a3 = d.a(this.mui.KZ(dtD), this.mui.Lb(dtD));
        long j3 = a2.muF;
        long j4 = a3.muG;
        if (!this.mui.muW || a3.muE) {
            j = j3;
            z2 = false;
            j2 = j4;
        } else {
            long min = Math.min((dwX() - com.google.android.exoplayer2.b.fo(this.mui.muU)) - com.google.android.exoplayer2.b.fo(this.mui.KZ(dtD).mvm), j4);
            if (this.mui.muY != -9223372036854775807L) {
                long fo = min - com.google.android.exoplayer2.b.fo(this.mui.muY);
                int i3 = dtD;
                while (fo < 0 && i3 > 0) {
                    i3--;
                    fo += this.mui.Lb(i3);
                }
                if (i3 == 0) {
                    j3 = Math.max(j3, fo);
                } else {
                    j3 = this.mui.Lb(0);
                }
            }
            j = j3;
            z2 = true;
            j2 = min;
        }
        long j5 = j2 - j;
        for (int i4 = 0; i4 < this.mui.dtD() - 1; i4++) {
            j5 += this.mui.Lb(i4);
        }
        long j6 = 0;
        if (this.mui.muW) {
            long j7 = this.mup;
            if (j7 == -1) {
                j7 = this.mui.muZ != -9223372036854775807L ? this.mui.muZ : 30000L;
            }
            j6 = j5 - com.google.android.exoplayer2.b.fo(j7);
            if (j6 < 5000000) {
                j6 = Math.min(5000000L, j5 / 2);
            }
        }
        this.mrp.a(this, new a(this.mui.muU, this.mui.muU + this.mui.KZ(0).mvm + com.google.android.exoplayer2.b.fn(j), this.muB, j, j5, j6, this.mui), this.mui);
        if (!this.mun) {
            this.handler.removeCallbacks(this.muv);
            if (z2) {
                this.handler.postDelayed(this.muv, 5000L);
            }
            if (z) {
                dwW();
            }
        }
    }

    private void dwW() {
        if (this.mui.muW) {
            long j = this.mui.muX;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.muu, Math.max(0L, (j + this.muy) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(p<T> pVar, Loader.a<p<T>> aVar, int i) {
        this.mtM.a(pVar.dataSpec, pVar.type, this.mrI.a(pVar, aVar, i));
    }

    private long dwX() {
        return this.muA != 0 ? com.google.android.exoplayer2.b.fo(SystemClock.elapsedRealtime() + this.muA) : com.google.android.exoplayer2.b.fo(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class d {
        public final boolean muE;
        public final long muF;
        public final long muG;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            boolean z;
            int size = eVar.mvn.size();
            long j2 = 0;
            long j3 = Format.OFFSET_SAMPLE_RELATIVE;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                com.google.android.exoplayer2.source.dash.d dxd = eVar.mvn.get(i).muR.get(0).dxd();
                if (dxd == null) {
                    return new d(true, 0L, j);
                }
                boolean dwZ = dxd.dwZ() | z2;
                int gq = dxd.gq(j);
                if (gq == 0) {
                    z = true;
                    j2 = 0;
                    j3 = 0;
                } else {
                    if (!z3) {
                        int dwY = dxd.dwY();
                        j2 = Math.max(j2, dxd.KV(dwY));
                        if (gq != -1) {
                            int i2 = (gq + dwY) - 1;
                            j3 = Math.min(j3, dxd.F(i2, j) + dxd.KV(i2));
                            z = z3;
                        }
                    }
                    z = z3;
                }
                i++;
                z3 = z;
                z2 = dwZ;
            }
            return new d(z2, j2, j3);
        }

        private d(boolean z, long j, long j2) {
            this.muE = z;
            this.muF = j;
            this.muG = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a extends x {
        private final long maC;
        private final long maD;
        private final long mtk;
        private final long mtm;
        private final int muB;
        private final long muD;
        private final com.google.android.exoplayer2.source.dash.manifest.b mui;

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.maC = j;
            this.maD = j2;
            this.muB = i;
            this.muD = j3;
            this.mtk = j4;
            this.mtm = j5;
            this.mui = bVar;
        }

        @Override // com.google.android.exoplayer2.x
        public int dtD() {
            return this.mui.dtD();
        }

        @Override // com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.util.a.aj(i, 0, this.mui.dtD());
            return aVar.a(z ? this.mui.KZ(i).id : null, z ? Integer.valueOf(this.muB + com.google.android.exoplayer2.util.a.aj(i, 0, this.mui.dtD())) : null, 0, this.mui.Lb(i), com.google.android.exoplayer2.b.fo(this.mui.KZ(i).mvm - this.mui.KZ(0).mvm) - this.muD);
        }

        @Override // com.google.android.exoplayer2.x
        public int dtC() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.util.a.aj(i, 0, 1);
            return bVar.a(null, this.maC, this.maD, true, this.mui.muW, gp(j), this.mtk, 0, this.mui.dtD() - 1, this.muD);
        }

        @Override // com.google.android.exoplayer2.x
        public int bw(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.muB && intValue < this.muB + dtD()) {
                return intValue - this.muB;
            }
            return -1;
        }

        private long gp(long j) {
            com.google.android.exoplayer2.source.dash.d dxd;
            long j2 = this.mtm;
            if (this.mui.muW) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.mtk) {
                        return -9223372036854775807L;
                    }
                }
                long j3 = j2;
                long j4 = this.muD + j3;
                long Lb = this.mui.Lb(0);
                int i = 0;
                while (i < this.mui.dtD() - 1 && j4 >= Lb) {
                    long j5 = j4 - Lb;
                    int i2 = i + 1;
                    long Lb2 = this.mui.Lb(i2);
                    i = i2;
                    j4 = j5;
                    Lb = Lb2;
                }
                com.google.android.exoplayer2.source.dash.manifest.e KZ = this.mui.KZ(i);
                int Lc = KZ.Lc(2);
                return (Lc == -1 || (dxd = KZ.mvn.get(Lc).muR.get(0).dxd()) == null || dxd.gq(Lb) == 0) ? j3 : (dxd.KV(dxd.T(j4, Lb)) + j3) - j4;
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
            return Long.valueOf(v.QE(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
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
