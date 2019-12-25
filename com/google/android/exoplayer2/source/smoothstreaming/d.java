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
/* loaded from: classes4.dex */
public final class d implements l, Loader.a<p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {
    private final ArrayList<c> mmB;
    private l.a mmC;
    private final int mmP;
    private final b.a moY;
    private final e.a mpA;
    private final long mpB;
    private final p.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> mpC;
    private final Uri mpJ;
    private long mpK;
    private o mpq;
    private final b.a mtA;
    private e mtB;
    private Loader mtC;
    private Handler mtD;
    private com.google.android.exoplayer2.source.smoothstreaming.manifest.a mty;

    static {
        com.google.android.exoplayer2.l.ON("goog.exo.smoothstreaming");
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
        com.google.android.exoplayer2.util.a.checkState(aVar == null || !aVar.mtj);
        this.mty = aVar;
        if (uri == null) {
            uri = null;
        } else if (!v.Qd(uri.getLastPathSegment()).matches("manifest(\\(.+\\))?")) {
            uri = Uri.withAppendedPath(uri, "Manifest");
        }
        this.mpJ = uri;
        this.mpA = aVar2;
        this.mpC = aVar3;
        this.mtA = aVar4;
        this.mmP = i;
        this.mpB = j;
        this.moY = new b.a(handler, bVar);
        this.mmB = new ArrayList<>();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(g gVar, boolean z, l.a aVar) {
        this.mmC = aVar;
        if (this.mty != null) {
            this.mpq = new o.a();
            dvh();
            return;
        }
        this.mtB = this.mpA.dww();
        this.mtC = new Loader("Loader:Manifest");
        this.mpq = this.mtC;
        this.mtD = new Handler();
        duv();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dtN() throws IOException {
        this.mpq.dtM();
    }

    @Override // com.google.android.exoplayer2.source.l
    public k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        c cVar = new c(this.mty, this.mtA, this.mmP, this.moY, this.mpq, bVar2);
        this.mmB.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(k kVar) {
        ((c) kVar).release();
        this.mmB.remove(kVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        this.mmC = null;
        this.mty = null;
        this.mtB = null;
        this.mpK = 0L;
        if (this.mtC != null) {
            this.mtC.release();
            this.mtC = null;
        }
        if (this.mtD != null) {
            this.mtD.removeCallbacksAndMessages(null);
            this.mtD = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2) {
        this.moY.a(pVar.dataSpec, pVar.type, j, j2, pVar.dum());
        this.mty = pVar.getResult();
        this.mpK = j - j2;
        dvh();
        duw();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, boolean z) {
        this.moY.a(pVar.dataSpec, pVar.type, j, j2, pVar.dum());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.moY.a(pVar.dataSpec, pVar.type, j, j2, pVar.dum(), iOException, z);
        return z ? 3 : 0;
    }

    private void dvh() {
        a.b[] bVarArr;
        s sVar;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mmB.size()) {
                break;
            }
            this.mmB.get(i2).a(this.mty);
            i = i2 + 1;
        }
        long j = Format.OFFSET_SAMPLE_RELATIVE;
        long j2 = Long.MIN_VALUE;
        for (a.b bVar : this.mty.mtH) {
            if (bVar.mpj > 0) {
                j = Math.min(j, bVar.KT(0));
                j2 = Math.max(j2, bVar.KT(bVar.mpj - 1) + bVar.KU(bVar.mpj - 1));
            }
        }
        if (j == Format.OFFSET_SAMPLE_RELATIVE) {
            sVar = new s(this.mty.mtj ? -9223372036854775807L : 0L, 0L, 0L, 0L, true, this.mty.mtj);
        } else if (this.mty.mtj) {
            if (this.mty.mtI != -9223372036854775807L && this.mty.mtI > 0) {
                j = Math.max(j, j2 - this.mty.mtI);
            }
            long j3 = j2 - j;
            long fl = j3 - com.google.android.exoplayer2.b.fl(this.mpB);
            if (fl < 5000000) {
                fl = Math.min(5000000L, j3 / 2);
            }
            sVar = new s(-9223372036854775807L, j3, j, fl, true, true);
        } else {
            long j4 = this.mty.lUZ != -9223372036854775807L ? this.mty.lUZ : j2 - j;
            sVar = new s(j + j4, j4, j, 0L, true, false);
        }
        this.mmC.a(this, sVar, this.mty);
    }

    private void duw() {
        if (this.mty.mtj) {
            this.mtD.postDelayed(new Runnable() { // from class: com.google.android.exoplayer2.source.smoothstreaming.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.duv();
                }
            }, Math.max(0L, (this.mpK + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duv() {
        p pVar = new p(this.mtB, this.mpJ, 4, this.mpC);
        this.moY.a(pVar.dataSpec, pVar.type, this.mtC.a(pVar, this, this.mmP));
    }
}
