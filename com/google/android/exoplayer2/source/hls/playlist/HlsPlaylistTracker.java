package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.a.h;
import com.google.android.exoplayer2.source.b;
import com.google.android.exoplayer2.source.hls.e;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.util.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
/* loaded from: classes5.dex */
public final class HlsPlaylistTracker implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>> {
    private final b.a msN;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mvD;
    private com.google.android.exoplayer2.source.hls.playlist.a mvh;
    private final e mvy;
    private final Uri mwP;
    private final int mwQ;
    private final c mwT;
    private a.C0673a mwV;
    private com.google.android.exoplayer2.source.hls.playlist.b mwW;
    private boolean mwX;
    private final List<b> listeners = new ArrayList();
    private final Loader mwU = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<a.C0673a, a> mwR = new IdentityHashMap<>();
    private final Handler mwS = new Handler();

    /* loaded from: classes5.dex */
    public interface b {
        void a(a.C0673a c0673a, long j);

        void dwa();
    }

    /* loaded from: classes5.dex */
    public interface c {
        void b(com.google.android.exoplayer2.source.hls.playlist.b bVar);
    }

    /* loaded from: classes5.dex */
    public static final class PlaylistStuckException extends IOException {
        public final String url;

        private PlaylistStuckException(String str) {
            this.url = str;
        }
    }

    /* loaded from: classes5.dex */
    public static final class PlaylistResetException extends IOException {
        public final String url;

        private PlaylistResetException(String str) {
            this.url = str;
        }
    }

    public HlsPlaylistTracker(Uri uri, e eVar, b.a aVar, int i, c cVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar2) {
        this.mwP = uri;
        this.mvy = eVar;
        this.msN = aVar;
        this.mwQ = i;
        this.mwT = cVar;
        this.mvD = aVar2;
    }

    public void a(b bVar) {
        this.listeners.add(bVar);
    }

    public void b(b bVar) {
        this.listeners.remove(bVar);
    }

    public void start() {
        this.mwU.a(new p(this.mvy.La(4), this.mwP, 4, this.mvD), this, this.mwQ);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a dwi() {
        return this.mvh;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b b(a.C0673a c0673a) {
        com.google.android.exoplayer2.source.hls.playlist.b dwm = this.mwR.get(c0673a).dwm();
        if (dwm != null) {
            f(c0673a);
        }
        return dwm;
    }

    public boolean c(a.C0673a c0673a) {
        return this.mwR.get(c0673a).dwn();
    }

    public void release() {
        this.mwU.release();
        for (a aVar : this.mwR.values()) {
            aVar.release();
        }
        this.mwS.removeCallbacksAndMessages(null);
        this.mwR.clear();
    }

    public void dwj() throws IOException {
        this.mwU.duX();
        if (this.mwV != null) {
            d(this.mwV);
        }
    }

    public void d(a.C0673a c0673a) throws IOException {
        this.mwR.get(c0673a).dwp();
    }

    public void e(a.C0673a c0673a) {
        this.mwR.get(c0673a).dwo();
    }

    public boolean dwk() {
        return this.mwX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.a aVar;
        com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        if (z) {
            aVar = com.google.android.exoplayer2.source.hls.playlist.a.Py(result.mwn);
        } else {
            aVar = (com.google.android.exoplayer2.source.hls.playlist.a) result;
        }
        this.mvh = aVar;
        this.mwV = aVar.mvU.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.mvU);
        arrayList.addAll(aVar.audios);
        arrayList.addAll(aVar.mvV);
        fm(arrayList);
        a aVar2 = this.mwR.get(this.mwV);
        if (!z) {
            aVar2.dwo();
        } else {
            aVar2.d((com.google.android.exoplayer2.source.hls.playlist.b) result);
        }
        this.msN.a(pVar.dataSpec, 4, j, j2, pVar.dvx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
        this.msN.b(pVar.dataSpec, 4, j, j2, pVar.dvx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.msN.a(pVar.dataSpec, 4, j, j2, pVar.dvx(), iOException, z);
        return z ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwl() {
        List<a.C0673a> list = this.mvh.mvU;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = this.mwR.get(list.get(i));
            if (elapsedRealtime > aVar.mxf) {
                this.mwV = aVar.mwY;
                aVar.dwo();
                return true;
            }
        }
        return false;
    }

    private void f(a.C0673a c0673a) {
        if (c0673a == this.mwV || !this.mvh.mvU.contains(c0673a)) {
            return;
        }
        if (this.mwW == null || !this.mwW.mwd) {
            this.mwV = c0673a;
            this.mwR.get(this.mwV).dwo();
        }
    }

    private void fm(List<a.C0673a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.C0673a c0673a = list.get(i);
            this.mwR.put(c0673a, new a(c0673a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0673a c0673a, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (c0673a == this.mwV) {
            if (this.mwW == null) {
                this.mwX = !bVar.mwd;
            }
            this.mwW = bVar;
            this.mwT.b(bVar);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).dwa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0673a c0673a, long j) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).a(c0673a, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.exoplayer2.source.hls.playlist.b a(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (!bVar2.c(bVar)) {
            if (bVar2.mwd) {
                return bVar.dwh();
            }
            return bVar;
        }
        return bVar2.D(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.mwe) {
            return bVar2.msx;
        }
        long j = this.mwW != null ? this.mwW.msx : 0L;
        if (bVar != null) {
            int size = bVar.mwg.size();
            b.a d = d(bVar, bVar2);
            if (d != null) {
                return bVar.msx + d.mwi;
            }
            if (size == bVar2.mwa - bVar.mwa) {
                return bVar.dwg();
            }
            return j;
        }
        return j;
    }

    private int c(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.a d;
        if (bVar2.mvY) {
            return bVar2.mvZ;
        }
        int i = this.mwW != null ? this.mwW.mvZ : 0;
        if (bVar != null && (d = d(bVar, bVar2)) != null) {
            return (d.mwh + bVar.mvZ) - bVar2.mwg.get(0).mwh;
        }
        return i;
    }

    private static b.a d(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = bVar2.mwa - bVar.mwa;
        List<b.a> list = bVar.mwg;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class a implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>>, Runnable {
        private final a.C0673a mwY;
        private final Loader mwZ = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private final p<com.google.android.exoplayer2.source.hls.playlist.c> mxa;
        private com.google.android.exoplayer2.source.hls.playlist.b mxb;
        private long mxc;
        private long mxd;
        private long mxe;
        private long mxf;
        private boolean mxg;
        private IOException mxh;

        public a(a.C0673a c0673a) {
            this.mwY = c0673a;
            this.mxa = new p<>(HlsPlaylistTracker.this.mvy.La(4), u.fk(HlsPlaylistTracker.this.mvh.mwn, c0673a.url), 4, HlsPlaylistTracker.this.mvD);
        }

        public com.google.android.exoplayer2.source.hls.playlist.b dwm() {
            return this.mxb;
        }

        public boolean dwn() {
            if (this.mxb == null) {
                return false;
            }
            return this.mxb.mwd || this.mxb.mvW == 2 || this.mxb.mvW == 1 || Math.max(30000L, com.google.android.exoplayer2.b.fp(this.mxb.lYQ)) + this.mxc > SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mwZ.release();
        }

        public void dwo() {
            this.mxf = 0L;
            if (!this.mxg && !this.mwZ.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.mxe) {
                    this.mxg = true;
                    HlsPlaylistTracker.this.mwS.postDelayed(this, this.mxe - elapsedRealtime);
                    return;
                }
                dwq();
            }
        }

        public void dwp() throws IOException {
            this.mwZ.duX();
            if (this.mxh != null) {
                throw this.mxh;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                d((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.msN.a(pVar.dataSpec, 4, j, j2, pVar.dvx());
                return;
            }
            this.mxh = new ParserException("Loaded playlist has unexpected type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
            HlsPlaylistTracker.this.msN.b(pVar.dataSpec, 4, j, j2, pVar.dvx());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ParserException;
            HlsPlaylistTracker.this.msN.a(pVar.dataSpec, 4, j, j2, pVar.dvx(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.o(iOException)) {
                z2 = dwr();
            }
            return z2 ? 0 : 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mxg = false;
            dwq();
        }

        private void dwq() {
            this.mwZ.a(this.mxa, this, HlsPlaylistTracker.this.mwQ);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.mxb;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mxc = elapsedRealtime;
            this.mxb = HlsPlaylistTracker.this.a(bVar2, bVar);
            if (this.mxb != bVar2) {
                this.mxh = null;
                this.mxd = elapsedRealtime;
                HlsPlaylistTracker.this.a(this.mwY, this.mxb);
            } else if (!this.mxb.mwd) {
                if (bVar.mwa + bVar.mwg.size() < this.mxb.mwa) {
                    this.mxh = new PlaylistResetException(this.mwY.url);
                } else if (elapsedRealtime - this.mxd > com.google.android.exoplayer2.b.fp(this.mxb.mwb) * 3.5d) {
                    this.mxh = new PlaylistStuckException(this.mwY.url);
                    dwr();
                }
            }
            this.mxe = com.google.android.exoplayer2.b.fp(this.mxb != bVar2 ? this.mxb.mwb : this.mxb.mwb / 2) + elapsedRealtime;
            if (this.mwY == HlsPlaylistTracker.this.mwV && !this.mxb.mwd) {
                dwo();
            }
        }

        private boolean dwr() {
            this.mxf = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.b(this.mwY, 60000L);
            return HlsPlaylistTracker.this.mwV == this.mwY && !HlsPlaylistTracker.this.dwl();
        }
    }
}
