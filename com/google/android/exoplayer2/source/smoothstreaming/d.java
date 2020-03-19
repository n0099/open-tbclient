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
/* loaded from: classes6.dex */
public final class d implements l, Loader.a<p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {
    private final ArrayList<c> msV;
    private l.a msW;
    private final int mtj;
    private o mvK;
    private final e.a mvU;
    private final long mvV;
    private final p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> mvW;
    private final b.a mvs;
    private final Uri mwd;
    private long mwe;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mzP;
    private final b.a mzR;
    private e mzS;
    private Loader mzT;
    private Handler mzU;

    static {
        com.google.android.exoplayer2.l.Pm("goog.exo.smoothstreaming");
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
        com.google.android.exoplayer2.util.a.checkState(aVar == null || !aVar.mzB);
        this.mzP = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.QC(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.mwd = uri;
        this.mvU = aVar2;
        this.mvW = aVar3;
        this.mzR = aVar4;
        this.mtj = i;
        this.mvV = j;
        this.mvs = new b.a(handler, bVar);
        this.msV = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.msW = aVar;
        if (this.mzP != null) {
            this.mvK = new o.a();
            dye();
            return;
        }
        this.mzS = this.mvU.dzt();
        this.mzT = new Loader("Loader:Manifest");
        this.mvK = this.mzT;
        this.mzU = new Handler();
        dxs();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwK() throws IOException {
        this.mvK.dwJ();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        c cVar = new c(this.mzP, this.mzR, this.mtj, this.mvs, this.mvK, bVar2);
        this.msV.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((c) kVar).release();
        this.msV.remove(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.msW = null;
        this.mzP = null;
        this.mzS = null;
        this.mwe = 0L;
        if (this.mzT != null) {
            this.mzT.release();
            this.mzT = null;
        }
        if (this.mzU != null) {
            this.mzU.removeCallbacksAndMessages(null);
            this.mzU = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2) {
        this.mvs.a(pVar.dataSpec, pVar.type, j, j2, pVar.dxj());
        this.mzP = pVar.getResult();
        this.mwe = j - j2;
        dye();
        dxt();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, boolean z) {
        this.mvs.a(pVar.dataSpec, pVar.type, j, j2, pVar.dxj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mvs.a(pVar.dataSpec, pVar.type, j, j2, pVar.dxj(), iOException, z);
        return z ? 3 : 0;
    }

    private void dye() {
        a.b[] bVarArr;
        s sVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.msV.size()) {
                break;
            }
            this.msV.get(i2).a(this.mzP);
            i = i2 + 1;
        }
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = Long.MIN_VALUE;
        for (a.b bVar : this.mzP.mzY) {
            if (bVar.mvD > 0) {
                j = Math.min(j, bVar.Ln(0));
                j2 = Math.max(j2, bVar.Ln(bVar.mvD - 1) + bVar.Lo(bVar.mvD - 1));
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            sVar = new s(this.mzP.mzB ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.mzP.mzB);
        } else if (this.mzP.mzB) {
            if (this.mzP.mzZ != -9223372036854775807L && this.mzP.mzZ > 0) {
                j = Math.max(j, j2 - this.mzP.mzZ);
            }
            long j3 = j2 - j;
            long fp = j3 - com.google.android.exoplayer2.b.fp(this.mvV);
            if (fp < 5000000) {
                fp = Math.min(5000000L, j3 / 2);
            }
            sVar = new s(-9223372036854775807L, j3, j, fp, true, true);
        } else {
            long j4 = this.mzP.mbx != -9223372036854775807L ? this.mzP.mbx : j2 - j;
            sVar = new s(j + j4, j4, j, 0L, true, false);
        }
        this.msW.a(this, sVar, this.mzP);
    }

    private void dxt() {
        if (this.mzP.mzB) {
            this.mzU.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dxs();
                }
            }, Math.max(0L, (this.mwe + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxs() {
        p pVar = new p(this.mzS, this.mwd, 4, this.mvW);
        this.mvs.a(pVar.dataSpec, pVar.type, this.mzT.a(pVar, this, this.mtj));
    }
}
