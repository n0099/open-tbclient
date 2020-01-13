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
    private final int mqE;
    private final ArrayList<c> mqq;
    private l.a mqr;
    private final b.a msN;
    private long mtA;
    private o mtf;
    private final e.a mtp;
    private final long mtq;
    private final p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> mtr;
    private final Uri mtz;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxl;
    private final b.a mxn;
    private e mxo;
    private Loader mxp;
    private Handler mxq;

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
        com.google.android.exoplayer2.util.a.checkState(aVar == null || !aVar.mwX);
        this.mxl = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.Qo(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.mtz = uri;
        this.mtp = aVar2;
        this.mtr = aVar3;
        this.mxn = aVar4;
        this.mqE = i;
        this.mtq = j;
        this.msN = new b.a(handler, bVar);
        this.mqq = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mqr = aVar;
        if (this.mxl != null) {
            this.mtf = new o.a();
            dws();
            return;
        }
        this.mxo = this.mtp.dxH();
        this.mxp = new Loader("Loader:Manifest");
        this.mtf = this.mxp;
        this.mxq = new Handler();
        dvG();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void duY() throws IOException {
        this.mtf.duX();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        c cVar = new c(this.mxl, this.mxn, this.mqE, this.msN, this.mtf, bVar2);
        this.mqq.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((c) kVar).release();
        this.mqq.remove(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mqr = null;
        this.mxl = null;
        this.mxo = null;
        this.mtA = 0L;
        if (this.mxp != null) {
            this.mxp.release();
            this.mxp = null;
        }
        if (this.mxq != null) {
            this.mxq.removeCallbacksAndMessages(null);
            this.mxq = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2) {
        this.msN.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvx());
        this.mxl = pVar.getResult();
        this.mtA = j - j2;
        dws();
        dvH();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, boolean z) {
        this.msN.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.msN.a(pVar.dataSpec, pVar.type, j, j2, pVar.dvx(), iOException, z);
        return z ? 3 : 0;
    }

    private void dws() {
        a.b[] bVarArr;
        s sVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mqq.size()) {
                break;
            }
            this.mqq.get(i2).a(this.mxl);
            i = i2 + 1;
        }
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = Long.MIN_VALUE;
        for (a.b bVar : this.mxl.mxu) {
            if (bVar.msY > 0) {
                j = Math.min(j, bVar.Lc(0));
                j2 = Math.max(j2, bVar.Lc(bVar.msY - 1) + bVar.Ld(bVar.msY - 1));
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            sVar = new s(this.mxl.mwX ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.mxl.mwX);
        } else if (this.mxl.mwX) {
            if (this.mxl.mxv != -9223372036854775807L && this.mxl.mxv > 0) {
                j = Math.max(j, j2 - this.mxl.mxv);
            }
            long j3 = j2 - j;
            long fq = j3 - com.google.android.exoplayer2.b.fq(this.mtq);
            if (fq < 5000000) {
                fq = Math.min(5000000L, j3 / 2);
            }
            sVar = new s(-9223372036854775807L, j3, j, fq, true, true);
        } else {
            long j4 = this.mxl.lYQ != -9223372036854775807L ? this.mxl.lYQ : j2 - j;
            sVar = new s(j + j4, j4, j, 0L, true, false);
        }
        this.mqr.a(this, sVar, this.mxl);
    }

    private void dvH() {
        if (this.mxl.mwX) {
            this.mxq.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dvG();
                }
            }, Math.max(0L, (this.mtA + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvG() {
        p pVar = new p(this.mxo, this.mtz, 4, this.mtr);
        this.msN.a(pVar.dataSpec, pVar.type, this.mxp.a(pVar, this, this.mqE));
    }
}
