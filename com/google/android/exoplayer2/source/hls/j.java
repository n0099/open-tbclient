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
    private l.a mre;
    private final int mrr;
    private final b.a mtB;
    private final Uri mum;
    private final f mvC;
    private HlsPlaylistTracker mvH;
    private final e mwl;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mwq;

    static {
        com.google.android.exoplayer2.l.Pl("goog.exo.hls");
    }

    public j(Uri uri, e.a aVar, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, 3, handler, bVar);
    }

    public j(Uri uri, e.a aVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, new b(aVar), f.mvT, i, handler, bVar, new com.google.android.exoplayer2.source.hls.playlist.d());
    }

    public j(Uri uri, e eVar, f fVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar) {
        this.mum = uri;
        this.mwl = eVar;
        this.mvC = fVar;
        this.mrr = i;
        this.mwq = aVar;
        this.mtB = new b.a(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mvH == null);
        this.mvH = new HlsPlaylistTracker(this.mum, this.mwl, this.mtB, this.mrr, this, this.mwq);
        this.mre = aVar;
        this.mvH.start();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwm() throws IOException {
        this.mvH.dxx();
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new i(this.mvC, this.mvH, this.mwl, this.mrr, this.mtB, bVar2);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(com.google.android.exoplayer2.source.k kVar) {
        ((i) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        if (this.mvH != null) {
            this.mvH.release();
            this.mvH = null;
        }
        this.mre = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        s sVar;
        long j = bVar.mwR ? 0L : -9223372036854775807L;
        long fn = bVar.mwR ? com.google.android.exoplayer2.b.fn(bVar.mtk) : -9223372036854775807L;
        long j2 = bVar.mwK;
        if (this.mvH.dxy()) {
            long j3 = bVar.mwQ ? bVar.lZD + bVar.mtk : -9223372036854775807L;
            List<b.a> list = bVar.mwT;
            if (j2 == -9223372036854775807L) {
                j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).mwV;
            }
            sVar = new s(j, fn, j3, bVar.lZD, bVar.mtk, j2, true, !bVar.mwQ);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            sVar = new s(j, fn, bVar.mtk + bVar.lZD, bVar.lZD, bVar.mtk, j2, true, false);
        }
        this.mre.a(this, sVar, new g(this.mvH.dxw(), bVar));
    }
}
