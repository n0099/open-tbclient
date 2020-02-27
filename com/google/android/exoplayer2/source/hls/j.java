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
    private l.a mrc;
    private final int mrp;
    private final b.a mtz;
    private final Uri muk;
    private final f mvA;
    private HlsPlaylistTracker mvF;
    private final e mwj;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mwo;

    static {
        com.google.android.exoplayer2.l.Pl("goog.exo.hls");
    }

    public j(Uri uri, e.a aVar, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, 3, handler, bVar);
    }

    public j(Uri uri, e.a aVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, new b(aVar), f.mvR, i, handler, bVar, new com.google.android.exoplayer2.source.hls.playlist.d());
    }

    public j(Uri uri, e eVar, f fVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar) {
        this.muk = uri;
        this.mwj = eVar;
        this.mvA = fVar;
        this.mrp = i;
        this.mwo = aVar;
        this.mtz = new b.a(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mvF == null);
        this.mvF = new HlsPlaylistTracker(this.muk, this.mwj, this.mtz, this.mrp, this, this.mwo);
        this.mrc = aVar;
        this.mvF.start();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwk() throws IOException {
        this.mvF.dxv();
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new i(this.mvA, this.mvF, this.mwj, this.mrp, this.mtz, bVar2);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(com.google.android.exoplayer2.source.k kVar) {
        ((i) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        if (this.mvF != null) {
            this.mvF.release();
            this.mvF = null;
        }
        this.mrc = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        s sVar;
        long j = bVar.mwP ? 0L : -9223372036854775807L;
        long fn = bVar.mwP ? com.google.android.exoplayer2.b.fn(bVar.mti) : -9223372036854775807L;
        long j2 = bVar.mwI;
        if (this.mvF.dxw()) {
            long j3 = bVar.mwO ? bVar.lZB + bVar.mti : -9223372036854775807L;
            List<b.a> list = bVar.mwR;
            if (j2 == -9223372036854775807L) {
                j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).mwT;
            }
            sVar = new s(j, fn, j3, bVar.lZB, bVar.mti, j2, true, !bVar.mwO);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            sVar = new s(j, fn, bVar.mti + bVar.lZB, bVar.lZB, bVar.mti, j2, true, false);
        }
        this.mrc.a(this, sVar, new g(this.mvF.dxu(), bVar));
    }
}
