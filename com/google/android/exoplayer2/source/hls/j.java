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
/* loaded from: classes5.dex */
public final class j implements HlsPlaylistTracker.c, com.google.android.exoplayer2.source.l {
    private final int mqE;
    private l.a mqr;
    private final b.a msN;
    private final Uri mtz;
    private final f muP;
    private HlsPlaylistTracker muU;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mvD;
    private final e mvy;

    static {
        com.google.android.exoplayer2.l.OY("goog.exo.hls");
    }

    public j(Uri uri, e.a aVar, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, 3, handler, bVar);
    }

    public j(Uri uri, e.a aVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, new b(aVar), f.mvg, i, handler, bVar, new com.google.android.exoplayer2.source.hls.playlist.d());
    }

    public j(Uri uri, e eVar, f fVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar) {
        this.mtz = uri;
        this.mvy = eVar;
        this.muP = fVar;
        this.mqE = i;
        this.mvD = aVar;
        this.msN = new b.a(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        com.google.android.exoplayer2.util.a.checkState(this.muU == null);
        this.muU = new HlsPlaylistTracker(this.mtz, this.mvy, this.msN, this.mqE, this, this.mvD);
        this.mqr = aVar;
        this.muU.start();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void duY() throws IOException {
        this.muU.dwj();
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new i(this.muP, this.muU, this.mvy, this.mqE, this.msN, bVar2);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(com.google.android.exoplayer2.source.k kVar) {
        ((i) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        if (this.muU != null) {
            this.muU.release();
            this.muU = null;
        }
        this.mqr = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        s sVar;
        long j = bVar.mwe ? 0L : -9223372036854775807L;
        long fp = bVar.mwe ? com.google.android.exoplayer2.b.fp(bVar.msx) : -9223372036854775807L;
        long j2 = bVar.mvX;
        if (this.muU.dwk()) {
            long j3 = bVar.mwd ? bVar.lYQ + bVar.msx : -9223372036854775807L;
            List<b.a> list = bVar.mwg;
            if (j2 == -9223372036854775807L) {
                j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).mwi;
            }
            sVar = new s(j, fp, j3, bVar.lYQ, bVar.msx, j2, true, !bVar.mwd);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            sVar = new s(j, fp, bVar.msx + bVar.lYQ, bVar.lYQ, bVar.msx, j2, true, false);
        }
        this.mqr.a(this, sVar, new g(this.muU.dwi(), bVar));
    }
}
