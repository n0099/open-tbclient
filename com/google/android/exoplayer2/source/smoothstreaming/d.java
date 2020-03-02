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
    private final ArrayList<c> mrd;
    private l.a mre;
    private final int mrr;
    private final b.a mtB;
    private o mtT;
    private final e.a mud;
    private final long mue;
    private final p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> muf;
    private final Uri mum;
    private long mun;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxY;
    private final b.a mya;
    private e myb;
    private Loader myc;
    private Handler myd;

    static {
        com.google.android.exoplayer2.l.Pl("goog.exo.smoothstreaming");
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
        com.google.android.exoplayer2.util.a.checkState(aVar == null || !aVar.mxK);
        this.mxY = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.QB(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.mum = uri;
        this.mud = aVar2;
        this.muf = aVar3;
        this.mya = aVar4;
        this.mrr = i;
        this.mue = j;
        this.mtB = new b.a(handler, bVar);
        this.mrd = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mre = aVar;
        if (this.mxY != null) {
            this.mtT = new o.a();
            dxG();
            return;
        }
        this.myb = this.mud.dyV();
        this.myc = new Loader("Loader:Manifest");
        this.mtT = this.myc;
        this.myd = new Handler();
        dwU();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwm() throws IOException {
        this.mtT.dwl();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        c cVar = new c(this.mxY, this.mya, this.mrr, this.mtB, this.mtT, bVar2);
        this.mrd.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((c) kVar).release();
        this.mrd.remove(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mre = null;
        this.mxY = null;
        this.myb = null;
        this.mun = 0L;
        if (this.myc != null) {
            this.myc.release();
            this.myc = null;
        }
        if (this.myd != null) {
            this.myd.removeCallbacksAndMessages(null);
            this.myd = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2) {
        this.mtB.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwL());
        this.mxY = pVar.getResult();
        this.mun = j - j2;
        dxG();
        dwV();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, boolean z) {
        this.mtB.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwL());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtB.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwL(), iOException, z);
        return z ? 3 : 0;
    }

    private void dxG() {
        a.b[] bVarArr;
        s sVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mrd.size()) {
                break;
            }
            this.mrd.get(i2).a(this.mxY);
            i = i2 + 1;
        }
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = Long.MIN_VALUE;
        for (a.b bVar : this.mxY.myh) {
            if (bVar.mtM > 0) {
                j = Math.min(j, bVar.Lh(0));
                j2 = Math.max(j2, bVar.Lh(bVar.mtM - 1) + bVar.Li(bVar.mtM - 1));
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            sVar = new s(this.mxY.mxK ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.mxY.mxK);
        } else if (this.mxY.mxK) {
            if (this.mxY.myi != -9223372036854775807L && this.mxY.myi > 0) {
                j = Math.max(j, j2 - this.mxY.myi);
            }
            long j3 = j2 - j;
            long fo = j3 - com.google.android.exoplayer2.b.fo(this.mue);
            if (fo < 5000000) {
                fo = Math.min(5000000L, j3 / 2);
            }
            sVar = new s(-9223372036854775807L, j3, j, fo, true, true);
        } else {
            long j4 = this.mxY.lZD != -9223372036854775807L ? this.mxY.lZD : j2 - j;
            sVar = new s(j + j4, j4, j, 0L, true, false);
        }
        this.mre.a(this, sVar, this.mxY);
    }

    private void dwV() {
        if (this.mxY.mxK) {
            this.myd.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dwU();
                }
            }, Math.max(0L, (this.mun + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwU() {
        p pVar = new p(this.myb, this.mum, 4, this.muf);
        this.mtB.a(pVar.dataSpec, pVar.type, this.myc.a(pVar, this, this.mrr));
    }
}
