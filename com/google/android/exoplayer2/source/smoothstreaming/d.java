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
    private final ArrayList<c> mrb;
    private l.a mrc;
    private final int mrp;
    private o mtR;
    private final b.a mtz;
    private final e.a mub;
    private final long muc;
    private final p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> mud;
    private final Uri muk;
    private long mul;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mxW;
    private final b.a mxY;
    private e mxZ;
    private Loader mya;
    private Handler myb;

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
        com.google.android.exoplayer2.util.a.checkState(aVar == null || !aVar.mxI);
        this.mxW = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.QB(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.muk = uri;
        this.mub = aVar2;
        this.mud = aVar3;
        this.mxY = aVar4;
        this.mrp = i;
        this.muc = j;
        this.mtz = new b.a(handler, bVar);
        this.mrb = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mrc = aVar;
        if (this.mxW != null) {
            this.mtR = new o.a();
            dxE();
            return;
        }
        this.mxZ = this.mub.dyT();
        this.mya = new Loader("Loader:Manifest");
        this.mtR = this.mya;
        this.myb = new Handler();
        dwS();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwk() throws IOException {
        this.mtR.dwj();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        c cVar = new c(this.mxW, this.mxY, this.mrp, this.mtz, this.mtR, bVar2);
        this.mrb.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((c) kVar).release();
        this.mrb.remove(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mrc = null;
        this.mxW = null;
        this.mxZ = null;
        this.mul = 0L;
        if (this.mya != null) {
            this.mya.release();
            this.mya = null;
        }
        if (this.myb != null) {
            this.myb.removeCallbacksAndMessages(null);
            this.myb = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2) {
        this.mtz.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ());
        this.mxW = pVar.getResult();
        this.mul = j - j2;
        dxE();
        dwT();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, boolean z) {
        this.mtz.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtz.a(pVar.dataSpec, pVar.type, j, j2, pVar.dwJ(), iOException, z);
        return z ? 3 : 0;
    }

    private void dxE() {
        a.b[] bVarArr;
        s sVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mrb.size()) {
                break;
            }
            this.mrb.get(i2).a(this.mxW);
            i = i2 + 1;
        }
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = Long.MIN_VALUE;
        for (a.b bVar : this.mxW.myf) {
            if (bVar.mtK > 0) {
                j = Math.min(j, bVar.Lh(0));
                j2 = Math.max(j2, bVar.Lh(bVar.mtK - 1) + bVar.Li(bVar.mtK - 1));
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            sVar = new s(this.mxW.mxI ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.mxW.mxI);
        } else if (this.mxW.mxI) {
            if (this.mxW.myg != -9223372036854775807L && this.mxW.myg > 0) {
                j = Math.max(j, j2 - this.mxW.myg);
            }
            long j3 = j2 - j;
            long fo = j3 - com.google.android.exoplayer2.b.fo(this.muc);
            if (fo < 5000000) {
                fo = Math.min(5000000L, j3 / 2);
            }
            sVar = new s(-9223372036854775807L, j3, j, fo, true, true);
        } else {
            long j4 = this.mxW.lZB != -9223372036854775807L ? this.mxW.lZB : j2 - j;
            sVar = new s(j + j4, j4, j, 0L, true, false);
        }
        this.mrc.a(this, sVar, this.mxW);
    }

    private void dwT() {
        if (this.mxW.mxI) {
            this.myb.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dwS();
                }
            }, Math.max(0L, (this.mul + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwS() {
        p pVar = new p(this.mxZ, this.muk, 4, this.mud);
        this.mtz.a(pVar.dataSpec, pVar.type, this.mya.a(pVar, this, this.mrp));
    }
}
