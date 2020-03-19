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
/* loaded from: classes6.dex */
public final class j implements HlsPlaylistTracker.c, com.google.android.exoplayer2.source.l {
    private l.a msW;
    private final int mtj;
    private final b.a mvs;
    private final Uri mwd;
    private final f mxt;
    private HlsPlaylistTracker mxy;
    private final e myc;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> myh;

    static {
        com.google.android.exoplayer2.l.Pm("goog.exo.hls");
    }

    public j(Uri uri, e.a aVar, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, 3, handler, bVar);
    }

    public j(Uri uri, e.a aVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, new b(aVar), f.mxK, i, handler, bVar, new com.google.android.exoplayer2.source.hls.playlist.d());
    }

    public j(Uri uri, e eVar, f fVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar) {
        this.mwd = uri;
        this.myc = eVar;
        this.mxt = fVar;
        this.mtj = i;
        this.myh = aVar;
        this.mvs = new b.a(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mxy == null);
        this.mxy = new HlsPlaylistTracker(this.mwd, this.myc, this.mvs, this.mtj, this, this.myh);
        this.msW = aVar;
        this.mxy.start();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwK() throws IOException {
        this.mxy.dxV();
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new i(this.mxt, this.mxy, this.myc, this.mtj, this.mvs, bVar2);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(com.google.android.exoplayer2.source.k kVar) {
        ((i) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        if (this.mxy != null) {
            this.mxy.release();
            this.mxy = null;
        }
        this.msW = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        s sVar;
        long j = bVar.myI ? 0L : -9223372036854775807L;
        long fo = bVar.myI ? com.google.android.exoplayer2.b.fo(bVar.mvc) : -9223372036854775807L;
        long j2 = bVar.myB;
        if (this.mxy.dxW()) {
            long j3 = bVar.myH ? bVar.mbx + bVar.mvc : -9223372036854775807L;
            List<b.a> list = bVar.myK;
            if (j2 == -9223372036854775807L) {
                j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).myM;
            }
            sVar = new s(j, fo, j3, bVar.mbx, bVar.mvc, j2, true, !bVar.myH);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            sVar = new s(j, fo, bVar.mvc + bVar.mbx, bVar.mbx, bVar.mvc, j2, true, false);
        }
        this.msW.a(this, sVar, new g(this.mxy.dxU(), bVar));
    }
}
