package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.g;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.v;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class d implements l, Loader.a<p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {
    private final int mqJ;
    private final ArrayList<c> mqv;
    private l.a mqw;
    private final b.a msS;
    private final Uri mtE;
    private long mtF;
    private o mtk;
    private final e.a mtu;
    private final long mtv;
    private final p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> mtw;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxq;
    private final b.a mxs;
    private e mxt;
    private Loader mxu;
    private Handler mxv;

    static {
        com.google.android.exoplayer2.l.OY("goog.exo.smoothstreaming");
    }

    public d(Uri uri, e.a aVar, b.a aVar2, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, aVar2, 3, 30000L, handler, bVar);
    }

    public d(Uri uri, e.a aVar, b.a aVar2, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, new SsManifestParser(), aVar2, i, j, handler, bVar);
    }

    public d(Uri uri, e.a aVar, p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar2, b.a aVar3, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(null, uri, aVar, aVar2, aVar3, i, j, handler, bVar);
    }

    private d(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, Uri uri, e.a aVar2, p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar3, b.a aVar4, int i, long j, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        com.google.android.exoplayer2.util.a.checkState(aVar == null || !aVar.mxc);
        this.mxq = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.Qo(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.mtE = uri;
        this.mtu = aVar2;
        this.mtw = aVar3;
        this.mxs = aVar4;
        this.mqJ = i;
        this.mtv = j;
        this.msS = new b.a(handler, bVar);
        this.mqv = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mqw = aVar;
        if (this.mxq != null) {
            this.mtk = new o.a();
            dwu();
            return;
        }
        this.mxt = this.mtu.dxJ();
        this.mxu = new Loader("Loader:Manifest");
        this.mtk = this.mxu;
        this.mxv = new Handler();
        dvI();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dva() throws IOException {
        this.mtk.duZ();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        c cVar = new c(this.mxq, this.mxs, this.mqJ, this.msS, this.mtk, bVar2);
        this.mqv.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((c) kVar).release();
        this.mqv.remove(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mqw = null;
        this.mxq = null;
        this.mxt = null;
        this.mtF = 0L;
        if (this.mxu != null) {
            this.mxu.release();
            this.mxu = null;
        }
        if (this.mxv != null) {
            this.mxv.removeCallbacksAndMessages(null);
            this.mxv = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2) {
        this.msS.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvz());
        this.mxq = pVar.getResult();
        this.mtF = j - j2;
        dwu();
        dvJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, boolean z) {
        this.msS.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.msS.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvz(), iOException, z);
        return z ? 3 : 0;
    }

    private void dwu() {
        a.b[] bVarArr;
        s sVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mqv.size()) {
                break;
            }
            this.mqv.get(i2).a(this.mxq);
            i = i2 + 1;
        }
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = Long.MIN_VALUE;
        for (a.b bVar : this.mxq.mxz) {
            if (bVar.mtd > 0) {
                j = Math.min(j, bVar.Lc(0));
                j2 = Math.max(j2, bVar.Lc(bVar.mtd - 1) + bVar.Ld(bVar.mtd - 1));
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            sVar = new s(this.mxq.mxc ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.mxq.mxc);
        } else if (this.mxq.mxc) {
            if (this.mxq.mxA != -9223372036854775807L && this.mxq.mxA > 0) {
                j = Math.max(j, j2 - this.mxq.mxA);
            }
            long j3 = j2 - j;
            long fq = j3 - com.google.android.exoplayer2.b.fq(this.mtv);
            if (fq < 5000000) {
                fq = Math.min(5000000L, j3 / 2);
            }
            sVar = new s(-9223372036854775807L, j3, j, fq, true, true);
        } else {
            long j4 = this.mxq.lYV != -9223372036854775807L ? this.mxq.lYV : j2 - j;
            sVar = new s(j + j4, j4, j, 0L, true, false);
        }
        this.mqw.a(this, sVar, this.mxq);
    }

    private void dvJ() {
        if (this.mxq.mxc) {
            this.mxv.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dvI();
                }
            }, Math.max(0L, (this.mtF + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvI() {
        p pVar = new p(this.mxt, this.mtE, 4, this.mtw);
        this.msS.a(pVar.dataSpec, pVar.type, this.mxu.a(pVar, this, this.mqJ));
    }
}
