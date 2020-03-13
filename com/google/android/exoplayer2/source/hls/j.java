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
    private final int mrC;
    private l.a mrp;
    private final b.a mtM;
    private final Uri mux;
    private final f mvN;
    private HlsPlaylistTracker mvS;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mwB;
    private final e mww;

    static {
        com.google.android.exoplayer2.l.Pm("goog.exo.hls");
    }

    public j(Uri uri, e.a aVar, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, aVar, 3, handler, bVar);
    }

    public j(Uri uri, e.a aVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar) {
        this(uri, new b(aVar), f.mwe, i, handler, bVar, new com.google.android.exoplayer2.source.hls.playlist.d());
    }

    public j(Uri uri, e eVar, f fVar, int i, Handler handler, com.google.android.exoplayer2.source.b bVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar) {
        this.mux = uri;
        this.mww = eVar;
        this.mvN = fVar;
        this.mrC = i;
        this.mwB = aVar;
        this.mtM = new b.a(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void a(com.google.android.exoplayer2.g gVar, boolean z, l.a aVar) {
        com.google.android.exoplayer2.util.a.checkState(this.mvS == null);
        this.mvS = new HlsPlaylistTracker(this.mux, this.mww, this.mtM, this.mrC, this, this.mwB);
        this.mrp = aVar;
        this.mvS.start();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void dwn() throws IOException {
        this.mvS.dxy();
    }

    @Override // com.google.android.exoplayer2.source.l
    public com.google.android.exoplayer2.source.k a(l.b bVar, com.google.android.exoplayer2.upstream.b bVar2) {
        com.google.android.exoplayer2.util.a.checkArgument(bVar.periodIndex == 0);
        return new i(this.mvN, this.mvS, this.mww, this.mrC, this.mtM, bVar2);
    }

    @Override // com.google.android.exoplayer2.source.l
    public void e(com.google.android.exoplayer2.source.k kVar) {
        ((i) kVar).release();
    }

    @Override // com.google.android.exoplayer2.source.l
    public void releaseSource() {
        if (this.mvS != null) {
            this.mvS.release();
            this.mvS = null;
        }
        this.mrp = null;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void b(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        s sVar;
        long j = bVar.mxc ? 0L : -9223372036854775807L;
        long fn = bVar.mxc ? com.google.android.exoplayer2.b.fn(bVar.mtv) : -9223372036854775807L;
        long j2 = bVar.mwV;
        if (this.mvS.dxz()) {
            long j3 = bVar.mxb ? bVar.lZO + bVar.mtv : -9223372036854775807L;
            List<b.a> list = bVar.mxe;
            if (j2 == -9223372036854775807L) {
                j2 = list.isEmpty() ? 0L : list.get(Math.max(0, list.size() - 3)).mxg;
            }
            sVar = new s(j, fn, j3, bVar.lZO, bVar.mtv, j2, true, !bVar.mxb);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            sVar = new s(j, fn, bVar.mtv + bVar.lZO, bVar.lZO, bVar.mtv, j2, true, false);
        }
        this.mrp.a(this, sVar, new g(this.mvS.dxx(), bVar));
    }
}
