package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.p;
import java.io.IOException;
import java.util.List;
/* loaded from: classes4.dex */
public final class j implements HlsPlaylistTracker.c, com.google.android.exoplayer2.source.l {
    private l.a mmC;
    private final int mmP;
    private final b.a moY;
    private final Uri mpJ;
    private final e mrJ;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mrO;
    private final f mra;
    private HlsPlaylistTracker mrf;

    static {
        com.google.android.exoplayer2.l.ON("goog.exo.hls");
    }

    public j(Uri uri, e.a aVar, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, 3, handler, bVar);
    }

    public j(Uri uri, e.a aVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, new b(aVar), f.mrr, i, handler, bVar, new com.google.android.exoplayer2.source.hls.playlist.d());
    }

    public j(Uri uri, e eVar, f fVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar) {
        this.mpJ = uri;
        this.mrJ = eVar;
        this.mra = fVar;
        this.mmP = i;
        this.mrO = aVar;
        this.moY = new b.a(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mrf == null);
        this.mrf = new HlsPlaylistTracker(this.mpJ, this.mrJ, this.moY, this.mmP, this, this.mrO);
        this.mmC = aVar;
        this.mrf.start();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dtN() throws IOException {
        this.mrf.duY();
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new i(this.mra, this.mrf, this.mrJ, this.mmP, this.moY, bVar2);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(com.google.android.exoplayer2.source.k kVar) {
        ((i) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        if (this.mrf != null) {
            this.mrf.release();
            this.mrf = null;
        }
        this.mmC = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        s sVar;
        long j = bVar.msq ? 0L : -9223372036854775807L;
        long fk = bVar.msq ? com.google.android.exoplayer2.b.fk(bVar.moI) : -9223372036854775807L;
        long j2 = bVar.msj;
        if (this.mrf.duZ()) {
            long j3 = bVar.msp ? bVar.lUZ + bVar.moI : -9223372036854775807L;
            List<b.a> list = bVar.mss;
            if (j2 == -9223372036854775807L) {
                j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).msu;
            }
            sVar = new s(j, fk, j3, bVar.lUZ, bVar.moI, j2, true, !bVar.msp);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            sVar = new s(j, fk, bVar.moI + bVar.lUZ, bVar.lUZ, bVar.moI, j2, true, false);
        }
        this.mmC.a(this, sVar, new g(this.mrf.duX(), bVar));
    }
}
