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
    private final int mrC;
    private final ArrayList<c> mro;
    private l.a mrp;
    private final b.a mtM;
    private o mue;
    private final e.a muo;
    private final long mup;
    private final p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> muq;
    private final Uri mux;
    private long muy;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a myj;
    private final b.a myl;
    private e mym;
    private Loader myn;
    private Handler myo;

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
        com.google.android.exoplayer2.util.a.checkState(aVar == null || !aVar.mxV);
        this.myj = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.QC(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.mux = uri;
        this.muo = aVar2;
        this.muq = aVar3;
        this.myl = aVar4;
        this.mrC = i;
        this.mup = j;
        this.mtM = new b.a(handler, bVar);
        this.mro = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mrp = aVar;
        if (this.myj != null) {
            this.mue = new o.a();
            dxH();
            return;
        }
        this.mym = this.muo.dyW();
        this.myn = new Loader("Loader:Manifest");
        this.mue = this.myn;
        this.myo = new Handler();
        dwV();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwn() throws IOException {
        this.mue.dwm();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        c cVar = new c(this.myj, this.myl, this.mrC, this.mtM, this.mue, bVar2);
        this.mro.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((c) kVar).release();
        this.mro.remove(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mrp = null;
        this.myj = null;
        this.mym = null;
        this.muy = 0L;
        if (this.myn != null) {
            this.myn.release();
            this.myn = null;
        }
        if (this.myo != null) {
            this.myo.removeCallbacksAndMessages(null);
            this.myo = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2) {
        this.mtM.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwM());
        this.myj = pVar.getResult();
        this.muy = j - j2;
        dxH();
        dwW();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, boolean z) {
        this.mtM.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtM.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwM(), iOException, z);
        return z ? 3 : 0;
    }

    private void dxH() {
        a.b[] bVarArr;
        s sVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mro.size()) {
                break;
            }
            this.mro.get(i2).a(this.myj);
            i = i2 + 1;
        }
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = Long.MIN_VALUE;
        for (a.b bVar : this.myj.mys) {
            if (bVar.mtX > 0) {
                j = Math.min(j, bVar.Lh(0));
                j2 = Math.max(j2, bVar.Lh(bVar.mtX - 1) + bVar.Li(bVar.mtX - 1));
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            sVar = new s(this.myj.mxV ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.myj.mxV);
        } else if (this.myj.mxV) {
            if (this.myj.myt != -9223372036854775807L && this.myj.myt > 0) {
                j = Math.max(j, j2 - this.myj.myt);
            }
            long j3 = j2 - j;
            long fo = j3 - com.google.android.exoplayer2.b.fo(this.mup);
            if (fo < 5000000) {
                fo = Math.min(5000000L, j3 / 2);
            }
            sVar = new s(-9223372036854775807L, j3, j, fo, true, true);
        } else {
            long j4 = this.myj.lZO != -9223372036854775807L ? this.myj.lZO : j2 - j;
            sVar = new s(j + j4, j4, j, 0L, true, false);
        }
        this.mrp.a(this, sVar, this.myj);
    }

    private void dwW() {
        if (this.myj.mxV) {
            this.myo.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dwV();
                }
            }, Math.max(0L, (this.muy + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwV() {
        p pVar = new p(this.mym, this.mux, 4, this.muq);
        this.mtM.a(pVar.dataSpec, pVar.type, this.myn.a(pVar, this, this.mrC));
    }
}
