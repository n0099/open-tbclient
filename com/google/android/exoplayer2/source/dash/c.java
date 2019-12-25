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
/* loaded from: classes4.dex */
public final class c implements l {
    private Handler handler;
    private com.google.android.exoplayer2.upstream.e lZr;
    private l.a mmC;
    private final int mmP;
    private Loader mmV;
    private final b.a moY;
    private final e.a mpA;
    private final long mpB;
    private final p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> mpC;
    private final C0666c mpD;
    private final Object mpE;
    private final SparseArray<com.google.android.exoplayer2.source.dash.b> mpF;
    private final Runnable mpG;
    private final Runnable mpH;
    private o mpI;
    private Uri mpJ;
    private long mpK;
    private long mpL;
    private long mpM;
    private int mpN;
    private final a.InterfaceC0665a mpo;
    private com.google.android.exoplayer2.source.dash.manifest.b mpu;
    private final boolean mpz;

    static {
        com.google.android.exoplayer2.l.ON("goog.exo.dash");
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0665a interfaceC0665a, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, interfaceC0665a, 3, -1L, handler, bVar);
    }

    public c(Uri uri, e.a aVar, a.InterfaceC0665a interfaceC0665a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, new com.google.android.exoplayer2.source.dash.manifest.c(), interfaceC0665a, i, j, handler, bVar);
    }

    public c(Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0665a interfaceC0665a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(null, uri, aVar, aVar2, interfaceC0665a, i, j, handler, bVar);
    }

    private c(com.google.android.exoplayer2.source.dash.manifest.b bVar, Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> aVar2, a.InterfaceC0665a interfaceC0665a, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar2) {
        this.mpu = bVar;
        this.mpJ = uri;
        this.mpA = aVar;
        this.mpC = aVar2;
        this.mpo = interfaceC0665a;
        this.mmP = i;
        this.mpB = j;
        this.mpz = bVar != null;
        this.moY = new b.a(handler, bVar2);
        this.mpE = new Object();
        this.mpF = new SparseArray<>();
        if (this.mpz) {
            com.google.android.exoplayer2.util.a.checkState(bVar.mqi ? false : true);
            this.mpD = null;
            this.mpG = null;
            this.mpH = null;
            return;
        }
        this.mpD = new C0666c();
        this.mpG = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.duv();
            }
        };
        this.mpH = new Runnable() { // from class: com.google.android.exoplayer2.source.dash.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.vr(false);
            }
        };
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mmC = aVar;
        if (this.mpz) {
            this.mpI = new o.a();
            vr(false);
            return;
        }
        this.lZr = this.mpA.dww();
        this.mmV = new Loader("Loader:DashMediaSource");
        this.mpI = this.mmV;
        this.handler = new Handler();
        duv();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dtN() throws IOException {
        this.mpI.dtM();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        int i = bVar.periodIndex;
        com.google.android.exoplayer2.source.dash.b bVar3 = new com.google.android.exoplayer2.source.dash.b(this.mpN + i, this.mpu, i, this.mpo, this.mmP, this.moY.fW(this.mpu.KL(i).mqz), this.mpM, this.mpI, bVar2);
        this.mpF.put(bVar3.id, bVar3);
        return bVar3;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        com.google.android.exoplayer2.source.dash.b bVar = (com.google.android.exoplayer2.source.dash.b) kVar;
        bVar.release();
        this.mpF.remove(bVar.id);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.lZr = null;
        this.mpI = null;
        if (this.mmV != null) {
            this.mmV.release();
            this.mmV = null;
        }
        this.mpK = 0L;
        this.mpL = 0L;
        this.mpu = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.mpM = 0L;
        this.mpF.clear();
    }

    void a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2) {
        this.moY.a(pVar.dataSpec, pVar.type, j, j2, pVar.dum());
        com.google.android.exoplayer2.source.dash.manifest.b result = pVar.getResult();
        int dra = this.mpu == null ? 0 : this.mpu.dra();
        int i = 0;
        long j3 = result.KL(0).mqz;
        while (i < dra && this.mpu.KL(i).mqz < j3) {
            i++;
        }
        if (dra - i > result.dra()) {
            Log.w("DashMediaSource", "Out of sync manifest");
            duw();
            return;
        }
        this.mpu = result;
        this.mpK = j - j2;
        this.mpL = j;
        if (this.mpu.mqn != null) {
            synchronized (this.mpE) {
                if (pVar.dataSpec.uri == this.mpJ) {
                    this.mpJ = this.mpu.mqn;
                }
            }
        }
        if (dra == 0) {
            if (this.mpu.mqm != null) {
                a(this.mpu.mqm);
                return;
            } else {
                vr(true);
                return;
            }
        }
        this.mpN += i;
        vr(true);
    }

    int a(p<com.google.android.exoplayer2.source.dash.manifest.b> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.moY.a(pVar.dataSpec, pVar.type, j, j2, pVar.dum(), iOException, z);
        return z ? 3 : 0;
    }

    void b(p<Long> pVar, long j, long j2) {
        this.moY.a(pVar.dataSpec, pVar.type, j, j2, pVar.dum());
        gl(pVar.getResult().longValue() - j);
    }

    int b(p<Long> pVar, long j, long j2, IOException iOException) {
        this.moY.a(pVar.dataSpec, pVar.type, j, j2, pVar.dum(), iOException, true);
        e(iOException);
        return 2;
    }

    void c(p<?> pVar, long j, long j2) {
        this.moY.b(pVar.dataSpec, pVar.type, j, j2, pVar.dum());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duv() {
        Uri uri;
        synchronized (this.mpE) {
            uri = this.mpJ;
        }
        a(new p(this.lZr, uri, 4, this.mpC), this.mpD, this.mmP);
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
            gl(v.Qf(kVar.value) - this.mpL);
        } catch (ParserException e2) {
            e(e2);
        }
    }

    private void a(com.google.android.exoplayer2.source.dash.manifest.k kVar, p.a<Long> aVar) {
        a(new p(this.lZr, Uri.parse(kVar.value), 5, aVar), new e(), 1);
    }

    private void gl(long j) {
        this.mpM = j;
        vr(true);
    }

    private void e(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        vr(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vr(boolean z) {
        long j;
        boolean z2;
        long j2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mpF.size()) {
                break;
            }
            int keyAt = this.mpF.keyAt(i2);
            if (keyAt >= this.mpN) {
                this.mpF.valueAt(i2).a(this.mpu, keyAt - this.mpN);
            }
            i = i2 + 1;
        }
        int dra = this.mpu.dra() - 1;
        d a2 = d.a(this.mpu.KL(0), this.mpu.KN(0));
        d a3 = d.a(this.mpu.KL(dra), this.mpu.KN(dra));
        long j3 = a2.mpR;
        long j4 = a3.mpS;
        if (!this.mpu.mqi || a3.mpQ) {
            j = j3;
            z2 = false;
            j2 = j4;
        } else {
            long min = Math.min((dux() - com.google.android.exoplayer2.b.fl(this.mpu.mqg)) - com.google.android.exoplayer2.b.fl(this.mpu.KL(dra).mqz), j4);
            if (this.mpu.mqk != -9223372036854775807L) {
                long fl = min - com.google.android.exoplayer2.b.fl(this.mpu.mqk);
                int i3 = dra;
                while (fl < 0 && i3 > 0) {
                    i3--;
                    fl += this.mpu.KN(i3);
                }
                if (i3 == 0) {
                    j3 = Math.max(j3, fl);
                } else {
                    j3 = this.mpu.KN(0);
                }
            }
            j = j3;
            z2 = true;
            j2 = min;
        }
        long j5 = j2 - j;
        for (int i4 = 0; i4 < this.mpu.dra() - 1; i4++) {
            j5 += this.mpu.KN(i4);
        }
        long j6 = 0;
        if (this.mpu.mqi) {
            long j7 = this.mpB;
            if (j7 == -1) {
                j7 = this.mpu.mql != -9223372036854775807L ? this.mpu.mql : 30000L;
            }
            j6 = j5 - com.google.android.exoplayer2.b.fl(j7);
            if (j6 < 5000000) {
                j6 = Math.min(5000000L, j5 / 2);
            }
        }
        this.mmC.a(this, new a(this.mpu.mqg, this.mpu.mqg + this.mpu.KL(0).mqz + com.google.android.exoplayer2.b.fk(j), this.mpN, j, j5, j6, this.mpu), this.mpu);
        if (!this.mpz) {
            this.handler.removeCallbacks(this.mpH);
            if (z2) {
                this.handler.postDelayed(this.mpH, 5000L);
            }
            if (z) {
                duw();
            }
        }
    }

    private void duw() {
        if (this.mpu.mqi) {
            long j = this.mpu.mqj;
            if (j == 0) {
                j = 5000;
            }
            this.handler.postDelayed(this.mpG, Math.max(0L, (j + this.mpK) - SystemClock.elapsedRealtime()));
        }
    }

    private <T> void a(p<T> pVar, Loader.a<p<T>> aVar, int i) {
        this.moY.a(pVar.dataSpec, pVar.type, this.mmV.a(pVar, aVar, i));
    }

    private long dux() {
        return this.mpM != 0 ? com.google.android.exoplayer2.b.fl(SystemClock.elapsedRealtime() + this.mpM) : com.google.android.exoplayer2.b.fl(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d {
        public final boolean mpQ;
        public final long mpR;
        public final long mpS;

        public static d a(com.google.android.exoplayer2.source.dash.manifest.e eVar, long j) {
            boolean z;
            int size = eVar.mqA.size();
            long j2 = 0;
            long j3 = Format.OFFSET_SAMPLE_RELATIVE;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            while (i < size) {
                com.google.android.exoplayer2.source.dash.d duD = eVar.mqA.get(i).mqd.get(0).duD();
                if (duD == null) {
                    return new d(true, 0L, j);
                }
                boolean duz = duD.duz() | z2;
                int gn = duD.gn(j);
                if (gn == 0) {
                    z = true;
                    j2 = 0;
                    j3 = 0;
                } else {
                    if (!z3) {
                        int duy = duD.duy();
                        j2 = Math.max(j2, duD.KH(duy));
                        if (gn != -1) {
                            int i2 = (gn + duy) - 1;
                            j3 = Math.min(j3, duD.G(i2, j) + duD.KH(i2));
                            z = z3;
                        }
                    }
                    z = z3;
                }
                i++;
                z3 = z;
                z2 = duz;
            }
            return new d(z2, j2, j3);
        }

        private d(boolean z, long j, long j2) {
            this.mpQ = z;
            this.mpR = j;
            this.mpS = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a extends x {
        private final long lVM;
        private final long lVN;
        private final long mox;
        private final long moz;
        private final int mpN;
        private final long mpP;
        private final com.google.android.exoplayer2.source.dash.manifest.b mpu;

        public a(long j, long j2, int i, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.manifest.b bVar) {
            this.lVM = j;
            this.lVN = j2;
            this.mpN = i;
            this.mpP = j3;
            this.mox = j4;
            this.moz = j5;
            this.mpu = bVar;
        }

        @Override // com.google.android.exoplayer2.x
        public int dra() {
            return this.mpu.dra();
        }

        @Override // com.google.android.exoplayer2.x
        public x.a a(int i, x.a aVar, boolean z) {
            com.google.android.exoplayer2.util.a.ai(i, 0, this.mpu.dra());
            return aVar.a(z ? this.mpu.KL(i).id : null, z ? Integer.valueOf(this.mpN + com.google.android.exoplayer2.util.a.ai(i, 0, this.mpu.dra())) : null, 0, this.mpu.KN(i), com.google.android.exoplayer2.b.fl(this.mpu.KL(i).mqz - this.mpu.KL(0).mqz) - this.mpP);
        }

        @Override // com.google.android.exoplayer2.x
        public int dqZ() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.x
        public x.b a(int i, x.b bVar, boolean z, long j) {
            com.google.android.exoplayer2.util.a.ai(i, 0, 1);
            return bVar.a(null, this.lVM, this.lVN, true, this.mpu.mqi, gm(j), this.mox, 0, this.mpu.dra() - 1, this.mpP);
        }

        @Override // com.google.android.exoplayer2.x
        public int bt(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue()) >= this.mpN && intValue < this.mpN + dra()) {
                return intValue - this.mpN;
            }
            return -1;
        }

        private long gm(long j) {
            com.google.android.exoplayer2.source.dash.d duD;
            long j2 = this.moz;
            if (this.mpu.mqi) {
                if (j > 0) {
                    j2 += j;
                    if (j2 > this.mox) {
                        return -9223372036854775807L;
                    }
                }
                long j3 = j2;
                long j4 = this.mpP + j3;
                long KN = this.mpu.KN(0);
                int i = 0;
                while (i < this.mpu.dra() - 1 && j4 >= KN) {
                    long j5 = j4 - KN;
                    int i2 = i + 1;
                    long KN2 = this.mpu.KN(i2);
                    i = i2;
                    j4 = j5;
                    KN = KN2;
                }
                com.google.android.exoplayer2.source.dash.manifest.e KL = this.mpu.KL(i);
                int KO = KL.KO(2);
                return (KO == -1 || (duD = KL.mqA.get(KO).mqd.get(0).duD()) == null || duD.gn(KN) == 0) ? j3 : (duD.KH(duD.U(j4, KN)) + j3) - j4;
            }
            return j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.source.dash.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C0666c implements Loader.a<p<com.google.android.exoplayer2.source.dash.manifest.b>> {
        private C0666c() {
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
    /* loaded from: classes4.dex */
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
    /* loaded from: classes4.dex */
    public static final class f implements p.a<Long> {
        private f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.p.a
        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(v.Qf(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
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
