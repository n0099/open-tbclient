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
    private final int mqJ;
    private l.a mqw;
    private final b.a msS;
    private final Uri mtE;
    private final f muU;
    private HlsPlaylistTracker muZ;
    private final e mvD;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mvI;

    static {
        com.google.android.exoplayer2.l.OY("goog.exo.hls");
    }

    public j(Uri uri, e.a aVar, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, 3, handler, bVar);
    }

    public j(Uri uri, e.a aVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, new b(aVar), f.mvl, i, handler, bVar, new com.google.android.exoplayer2.source.hls.playlist.d());
    }

    public j(Uri uri, e eVar, f fVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar) {
        this.mtE = uri;
        this.mvD = eVar;
        this.muU = fVar;
        this.mqJ = i;
        this.mvI = aVar;
        this.msS = new b.a(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        com.google.android.exoplayer2.util.a.checkState(this.muZ == null);
        this.muZ = new HlsPlaylistTracker(this.mtE, this.mvD, this.msS, this.mqJ, this, this.mvI);
        this.mqw = aVar;
        this.muZ.start();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dva() throws IOException {
        this.muZ.dwl();
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new i(this.muU, this.muZ, this.mvD, this.mqJ, this.msS, bVar2);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(com.google.android.exoplayer2.source.k kVar) {
        ((i) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        if (this.muZ != null) {
            this.muZ.release();
            this.muZ = null;
        }
        this.mqw = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        s sVar;
        long j = bVar.mwj ? 0L : -9223372036854775807L;
        long fp = bVar.mwj ? com.google.android.exoplayer2.b.fp(bVar.msC) : -9223372036854775807L;
        long j2 = bVar.mwc;
        if (this.muZ.dwm()) {
            long j3 = bVar.mwi ? bVar.lYV + bVar.msC : -9223372036854775807L;
            List<b.a> list = bVar.mwl;
            if (j2 == -9223372036854775807L) {
                j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).mwn;
            }
            sVar = new s(j, fp, j3, bVar.lYV, bVar.msC, j2, true, !bVar.mwi);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            sVar = new s(j, fp, bVar.msC + bVar.lYV, bVar.lYV, bVar.msC, j2, true, false);
        }
        this.mqw.a(this, sVar, new g(this.muZ.dwk(), bVar));
    }
}
