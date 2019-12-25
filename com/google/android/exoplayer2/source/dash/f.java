package com.google.android.exoplayer2.source.dash;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.a.i;
import com.google.android.exoplayer2.source.a.k;
import com.google.android.exoplayer2.source.a.l;
import com.google.android.exoplayer2.source.a.m;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.manifest.g;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.google.android.exoplayer2.source.dash.a {
    private final int lTu;
    private final com.google.android.exoplayer2.upstream.e lZr;
    private final long mpM;
    private final com.google.android.exoplayer2.b.f mpU;
    private final int mpV;
    protected final b[] mpW;
    private IOException mpX;
    private boolean mpY;
    private long mpZ;
    private final o mpq;
    private com.google.android.exoplayer2.source.dash.manifest.b mpu;
    private final int[] mpv;
    private int periodIndex;

    /* loaded from: classes4.dex */
    public static final class a implements a.InterfaceC0665a {
        private final e.a mnx;
        private final int mpV;

        public a(e.a aVar) {
            this(aVar, 1);
        }

        public a(e.a aVar, int i) {
            this.mnx = aVar;
            this.mpV = i;
        }

        @Override // com.google.android.exoplayer2.source.dash.a.InterfaceC0665a
        public com.google.android.exoplayer2.source.dash.a a(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, long j, boolean z, boolean z2) {
            return new f(oVar, bVar, i, iArr, fVar, i2, this.mnx.dww(), j, this.mpV, z, z2);
        }
    }

    public f(o oVar, com.google.android.exoplayer2.source.dash.manifest.b bVar, int i, int[] iArr, com.google.android.exoplayer2.b.f fVar, int i2, com.google.android.exoplayer2.upstream.e eVar, long j, int i3, boolean z, boolean z2) {
        this.mpq = oVar;
        this.mpu = bVar;
        this.mpv = iArr;
        this.mpU = fVar;
        this.lTu = i2;
        this.lZr = eVar;
        this.periodIndex = i;
        this.mpM = j;
        this.mpV = i3;
        long KN = bVar.KN(i);
        this.mpZ = -9223372036854775807L;
        ArrayList<g> duA = duA();
        this.mpW = new b[fVar.length()];
        for (int i4 = 0; i4 < this.mpW.length; i4++) {
            this.mpW[i4] = new b(KN, i2, duA.get(fVar.Ls(i4)), z, z2);
        }
    }

    @Override // com.google.android.exoplayer2.source.dash.a
    public void a(com.google.android.exoplayer2.source.dash.manifest.b bVar, int i) {
        try {
            this.mpu = bVar;
            this.periodIndex = i;
            long KN = this.mpu.KN(this.periodIndex);
            ArrayList<g> duA = duA();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.mpW.length) {
                    this.mpW[i3].a(KN, duA.get(this.mpU.Ls(i3)));
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } catch (BehindLiveWindowException e) {
            this.mpX = e;
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void dtM() throws IOException {
        if (this.mpX != null) {
            throw this.mpX;
        }
        this.mpq.dtM();
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void a(l lVar, long j, long j2, com.google.android.exoplayer2.source.a.e eVar) {
        int i;
        int i2;
        int dur;
        if (this.mpX == null) {
            this.mpU.f(j, j2 - j, go(j));
            b bVar = this.mpW[this.mpU.duK()];
            if (bVar.mpk != null) {
                g gVar = bVar.mqa;
                com.google.android.exoplayer2.source.dash.manifest.f fVar = null;
                com.google.android.exoplayer2.source.dash.manifest.f fVar2 = null;
                if (bVar.mpk.duo() == null) {
                    fVar = gVar.duB();
                }
                if (bVar.mqb == null) {
                    fVar2 = gVar.duC();
                }
                if (fVar != null || fVar2 != null) {
                    eVar.moS = a(bVar, this.lZr, this.mpU.dvY(), this.mpU.duL(), this.mpU.duM(), fVar, fVar2);
                    return;
                }
            }
            int segmentCount = bVar.getSegmentCount();
            if (segmentCount == 0) {
                eVar.moT = !this.mpu.mqi || this.periodIndex < this.mpu.dra() + (-1);
                return;
            }
            int duy = bVar.duy();
            if (segmentCount == -1) {
                long dux = (dux() - com.google.android.exoplayer2.b.fl(this.mpu.mqg)) - com.google.android.exoplayer2.b.fl(this.mpu.KL(this.periodIndex).mqz);
                if (this.mpu.mqk != -9223372036854775807L) {
                    duy = Math.max(duy, bVar.gp(dux - com.google.android.exoplayer2.b.fl(this.mpu.mqk)));
                }
                int gp = bVar.gp(dux) - 1;
                i = duy;
                i2 = gp;
            } else {
                int i3 = (segmentCount + duy) - 1;
                i = duy;
                i2 = i3;
            }
            a(bVar, i2);
            if (lVar == null) {
                dur = v.al(bVar.gp(j2), i, i2);
            } else {
                dur = lVar.dur();
                if (dur < i) {
                    this.mpX = new BehindLiveWindowException();
                    return;
                }
            }
            if (dur > i2 || (this.mpY && dur >= i2)) {
                eVar.moT = !this.mpu.mqi || this.periodIndex < this.mpu.dra() + (-1);
            } else {
                eVar.moS = a(bVar, this.lZr, this.lTu, this.mpU.dvY(), this.mpU.duL(), this.mpU.duM(), dur, Math.min(this.mpV, (i2 - dur) + 1));
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public void b(com.google.android.exoplayer2.source.a.c cVar) {
        com.google.android.exoplayer2.extractor.l dun;
        if (cVar instanceof k) {
            b bVar = this.mpW[this.mpU.m(((k) cVar).moF)];
            if (bVar.mqb == null && (dun = bVar.mpk.dun()) != null) {
                bVar.mqb = new e((com.google.android.exoplayer2.extractor.a) dun);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.a.g
    public boolean a(com.google.android.exoplayer2.source.a.c cVar, boolean z, Exception exc) {
        b bVar;
        int segmentCount;
        if (!z) {
            return false;
        }
        if (!this.mpu.mqi && (cVar instanceof l) && (exc instanceof HttpDataSource.InvalidResponseCodeException) && ((HttpDataSource.InvalidResponseCodeException) exc).responseCode == 404 && (segmentCount = (bVar = this.mpW[this.mpU.m(cVar.moF)]).getSegmentCount()) != -1 && segmentCount != 0) {
            if (((l) cVar).dur() > (bVar.duy() + segmentCount) - 1) {
                this.mpY = true;
                return true;
            }
        }
        return h.a(this.mpU, this.mpU.m(cVar.moF), exc);
    }

    private ArrayList<g> duA() {
        List<com.google.android.exoplayer2.source.dash.manifest.a> list = this.mpu.KL(this.periodIndex).mqA;
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i : this.mpv) {
            arrayList.addAll(list.get(i).mqd);
        }
        return arrayList;
    }

    private void a(b bVar, int i) {
        this.mpZ = this.mpu.mqi ? bVar.KK(i) : -9223372036854775807L;
    }

    private long dux() {
        return this.mpM != 0 ? (SystemClock.elapsedRealtime() + this.mpM) * 1000 : System.currentTimeMillis() * 1000;
    }

    private long go(long j) {
        if (this.mpu.mqi && this.mpZ != -9223372036854775807L) {
            return this.mpZ - j;
        }
        return -9223372036854775807L;
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, Format format, int i, Object obj, com.google.android.exoplayer2.source.dash.manifest.f fVar, com.google.android.exoplayer2.source.dash.manifest.f fVar2) {
        String str = bVar.mqa.mqu;
        if (fVar != null) {
            com.google.android.exoplayer2.source.dash.manifest.f a2 = fVar.a(fVar2, str);
            if (a2 != null) {
                fVar = a2;
            }
        } else {
            fVar = fVar2;
        }
        return new k(eVar, new com.google.android.exoplayer2.upstream.g(fVar.Pi(str), fVar.start, fVar.length, bVar.mqa.getCacheKey()), format, i, obj, bVar.mpk);
    }

    protected static com.google.android.exoplayer2.source.a.c a(b bVar, com.google.android.exoplayer2.upstream.e eVar, int i, Format format, int i2, Object obj, int i3, int i4) {
        com.google.android.exoplayer2.source.dash.manifest.f a2;
        g gVar = bVar.mqa;
        long KJ = bVar.KJ(i3);
        com.google.android.exoplayer2.source.dash.manifest.f KI = bVar.KI(i3);
        String str = gVar.mqu;
        if (bVar.mpk == null) {
            return new m(eVar, new com.google.android.exoplayer2.upstream.g(KI.Pi(str), KI.start, KI.length, gVar.getCacheKey()), format, i2, obj, KJ, bVar.KK(i3), i3, i, format);
        }
        int i5 = 1;
        int i6 = 1;
        while (i6 < i4 && (a2 = KI.a(bVar.KI(i3 + i6), str)) != null) {
            i5++;
            i6++;
            KI = a2;
        }
        return new i(eVar, new com.google.android.exoplayer2.upstream.g(KI.Pi(str), KI.start, KI.length, gVar.getCacheKey()), format, i2, obj, KJ, bVar.KK((i3 + i5) - 1), i3, i5, -gVar.mqD, bVar.mpk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static final class b {
        private long mow;
        final com.google.android.exoplayer2.source.a.d mpk;
        public g mqa;
        public d mqb;
        private int mqc;

        b(long j, int i, g gVar, boolean z, boolean z2) {
            com.google.android.exoplayer2.extractor.e eVar;
            this.mow = j;
            this.mqa = gVar;
            String str = gVar.lUU.containerMimeType;
            if (Ph(str)) {
                this.mpk = null;
            } else {
                if ("application/x-rawcc".equals(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.e.a(gVar.lUU);
                } else if (Pg(str)) {
                    eVar = new com.google.android.exoplayer2.extractor.a.d(1);
                } else {
                    int i2 = z ? 4 : 0;
                    eVar = new com.google.android.exoplayer2.extractor.c.e(z2 ? i2 | 8 : i2);
                }
                this.mpk = new com.google.android.exoplayer2.source.a.d(eVar, i, gVar.lUU);
            }
            this.mqb = gVar.duD();
        }

        void a(long j, g gVar) throws BehindLiveWindowException {
            int gn;
            d duD = this.mqa.duD();
            d duD2 = gVar.duD();
            this.mow = j;
            this.mqa = gVar;
            if (duD != null) {
                this.mqb = duD2;
                if (duD.duz() && (gn = duD.gn(this.mow)) != 0) {
                    int duy = (gn + duD.duy()) - 1;
                    long KH = duD.KH(duy) + duD.G(duy, this.mow);
                    int duy2 = duD2.duy();
                    long KH2 = duD2.KH(duy2);
                    if (KH == KH2) {
                        this.mqc += (duy + 1) - duy2;
                    } else if (KH < KH2) {
                        throw new BehindLiveWindowException();
                    } else {
                        this.mqc = (duD.U(KH2, this.mow) - duy2) + this.mqc;
                    }
                }
            }
        }

        public int duy() {
            return this.mqb.duy() + this.mqc;
        }

        public int getSegmentCount() {
            return this.mqb.gn(this.mow);
        }

        public long KJ(int i) {
            return this.mqb.KH(i - this.mqc);
        }

        public long KK(int i) {
            return KJ(i) + this.mqb.G(i - this.mqc, this.mow);
        }

        public int gp(long j) {
            return this.mqb.U(j, this.mow) + this.mqc;
        }

        public com.google.android.exoplayer2.source.dash.manifest.f KI(int i) {
            return this.mqb.KI(i - this.mqc);
        }

        private static boolean Pg(String str) {
            return str.startsWith("video/webm") || str.startsWith("audio/webm") || str.startsWith("application/webm");
        }

        private static boolean Ph(String str) {
            return com.google.android.exoplayer2.util.i.PR(str) || "application/ttml+xml".equals(str);
        }
    }
}
