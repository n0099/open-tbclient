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
/* loaded from: classes6.dex */
public final class HlsPlaylistTracker implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>> {
    private final b.a mtB;
    private com.google.android.exoplayer2.source.hls.playlist.a mvU;
    private final e mwl;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mwq;
    private final Uri mxC;
    private final int mxD;
    private final c mxG;
    private a.C0681a mxI;
    private com.google.android.exoplayer2.source.hls.playlist.b mxJ;
    private boolean mxK;
    private final List<b> listeners = new ArrayList();
    private final Loader mxH = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<a.C0681a, a> mxE = new IdentityHashMap<>();
    private final Handler mxF = new Handler();

    /* loaded from: classes6.dex */
    public interface b {
        void a(a.C0681a c0681a, long j);

        void dxo();
    }

    /* loaded from: classes6.dex */
    public interface c {
        void b(com.google.android.exoplayer2.source.hls.playlist.b bVar);
    }

    /* loaded from: classes6.dex */
    public static final class PlaylistStuckException extends IOException {
        public final String url;

        private PlaylistStuckException(String str) {
            this.url = str;
        }
    }

    /* loaded from: classes6.dex */
    public static final class PlaylistResetException extends IOException {
        public final String url;

        private PlaylistResetException(String str) {
            this.url = str;
        }
    }

    public HlsPlaylistTracker(Uri uri, e eVar, b.a aVar, int i, c cVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar2) {
        this.mxC = uri;
        this.mwl = eVar;
        this.mtB = aVar;
        this.mxD = i;
        this.mxG = cVar;
        this.mwq = aVar2;
    }

    public void a(b bVar) {
        this.listeners.add(bVar);
    }

    public void b(b bVar) {
        this.listeners.remove(bVar);
    }

    public void start() {
        this.mxH.a(new p(this.mwl.Lf(4), this.mxC, 4, this.mwq), this, this.mxD);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a dxw() {
        return this.mvU;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b b(a.C0681a c0681a) {
        com.google.android.exoplayer2.source.hls.playlist.b dxA = this.mxE.get(c0681a).dxA();
        if (dxA != null) {
            f(c0681a);
        }
        return dxA;
    }

    public boolean c(a.C0681a c0681a) {
        return this.mxE.get(c0681a).dxB();
    }

    public void release() {
        this.mxH.release();
        for (a aVar : this.mxE.values()) {
            aVar.release();
        }
        this.mxF.removeCallbacksAndMessages(null);
        this.mxE.clear();
    }

    public void dxx() throws IOException {
        this.mxH.dwl();
        if (this.mxI != null) {
            d(this.mxI);
        }
    }

    public void d(a.C0681a c0681a) throws IOException {
        this.mxE.get(c0681a).dxD();
    }

    public void e(a.C0681a c0681a) {
        this.mxE.get(c0681a).dxC();
    }

    public boolean dxy() {
        return this.mxK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.a aVar;
        com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        if (z) {
            aVar = com.google.android.exoplayer2.source.hls.playlist.a.PL(result.mxa);
        } else {
            aVar = (com.google.android.exoplayer2.source.hls.playlist.a) result;
        }
        this.mvU = aVar;
        this.mxI = aVar.mwH.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.mwH);
        arrayList.addAll(aVar.audios);
        arrayList.addAll(aVar.mwI);
        fh(arrayList);
        a aVar2 = this.mxE.get(this.mxI);
        if (!z) {
            aVar2.dxC();
        } else {
            aVar2.d((com.google.android.exoplayer2.source.hls.playlist.b) result);
        }
        this.mtB.a(pVar.dataSpec, 4, j, j2, pVar.dwL());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
        this.mtB.b(pVar.dataSpec, 4, j, j2, pVar.dwL());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtB.a(pVar.dataSpec, 4, j, j2, pVar.dwL(), iOException, z);
        return z ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxz() {
        List<a.C0681a> list = this.mvU.mwH;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = this.mxE.get(list.get(i));
            if (elapsedRealtime > aVar.mxS) {
                this.mxI = aVar.mxL;
                aVar.dxC();
                return true;
            }
        }
        return false;
    }

    private void f(a.C0681a c0681a) {
        if (c0681a == this.mxI || !this.mvU.mwH.contains(c0681a)) {
            return;
        }
        if (this.mxJ == null || !this.mxJ.mwQ) {
            this.mxI = c0681a;
            this.mxE.get(this.mxI).dxC();
        }
    }

    private void fh(List<a.C0681a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.C0681a c0681a = list.get(i);
            this.mxE.put(c0681a, new a(c0681a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0681a c0681a, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (c0681a == this.mxI) {
            if (this.mxJ == null) {
                this.mxK = !bVar.mwQ;
            }
            this.mxJ = bVar;
            this.mxG.b(bVar);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).dxo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0681a c0681a, long j) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).a(c0681a, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.exoplayer2.source.hls.playlist.b a(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (!bVar2.c(bVar)) {
            if (bVar2.mwQ) {
                return bVar.dxv();
            }
            return bVar;
        }
        return bVar2.D(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.mwR) {
            return bVar2.mtk;
        }
        long j = this.mxJ != null ? this.mxJ.mtk : 0L;
        if (bVar != null) {
            int size = bVar.mwT.size();
            b.a d = d(bVar, bVar2);
            if (d != null) {
                return bVar.mtk + d.mwV;
            }
            if (size == bVar2.mwN - bVar.mwN) {
                return bVar.dxu();
            }
            return j;
        }
        return j;
    }

    private int c(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.a d;
        if (bVar2.mwL) {
            return bVar2.mwM;
        }
        int i = this.mxJ != null ? this.mxJ.mwM : 0;
        if (bVar != null && (d = d(bVar, bVar2)) != null) {
            return (d.mwU + bVar.mwM) - bVar2.mwT.get(0).mwU;
        }
        return i;
    }

    private static b.a d(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = bVar2.mwN - bVar.mwN;
        List<b.a> list = bVar.mwT;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>>, Runnable {
        private final a.C0681a mxL;
        private final Loader mxM = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private final p<com.google.android.exoplayer2.source.hls.playlist.c> mxN;
        private com.google.android.exoplayer2.source.hls.playlist.b mxO;
        private long mxP;
        private long mxQ;
        private long mxR;
        private long mxS;
        private boolean mxT;
        private IOException mxU;

        public a(a.C0681a c0681a) {
            this.mxL = c0681a;
            this.mxN = new p<>(HlsPlaylistTracker.this.mwl.Lf(4), u.fs(HlsPlaylistTracker.this.mvU.mxa, c0681a.url), 4, HlsPlaylistTracker.this.mwq);
        }

        public com.google.android.exoplayer2.source.hls.playlist.b dxA() {
            return this.mxO;
        }

        public boolean dxB() {
            if (this.mxO == null) {
                return false;
            }
            return this.mxO.mwQ || this.mxO.mwJ == 2 || this.mxO.mwJ == 1 || Math.max(30000L, com.google.android.exoplayer2.b.fn(this.mxO.lZD)) + this.mxP > SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mxM.release();
        }

        public void dxC() {
            this.mxS = 0L;
            if (!this.mxT && !this.mxM.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.mxR) {
                    this.mxT = true;
                    HlsPlaylistTracker.this.mxF.postDelayed(this, this.mxR - elapsedRealtime);
                    return;
                }
                dxE();
            }
        }

        public void dxD() throws IOException {
            this.mxM.dwl();
            if (this.mxU != null) {
                throw this.mxU;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                d((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.mtB.a(pVar.dataSpec, 4, j, j2, pVar.dwL());
                return;
            }
            this.mxU = new ParserException("Loaded playlist has unexpected type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
            HlsPlaylistTracker.this.mtB.b(pVar.dataSpec, 4, j, j2, pVar.dwL());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ParserException;
            HlsPlaylistTracker.this.mtB.a(pVar.dataSpec, 4, j, j2, pVar.dwL(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.o(iOException)) {
                z2 = dxF();
            }
            return z2 ? 0 : 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mxT = false;
            dxE();
        }

        private void dxE() {
            this.mxM.a(this.mxN, this, HlsPlaylistTracker.this.mxD);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.mxO;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mxP = elapsedRealtime;
            this.mxO = HlsPlaylistTracker.this.a(bVar2, bVar);
            if (this.mxO != bVar2) {
                this.mxU = null;
                this.mxQ = elapsedRealtime;
                HlsPlaylistTracker.this.a(this.mxL, this.mxO);
            } else if (!this.mxO.mwQ) {
                if (bVar.mwN + bVar.mwT.size() < this.mxO.mwN) {
                    this.mxU = new PlaylistResetException(this.mxL.url);
                } else if (elapsedRealtime - this.mxQ > com.google.android.exoplayer2.b.fn(this.mxO.mwO) * 3.5d) {
                    this.mxU = new PlaylistStuckException(this.mxL.url);
                    dxF();
                }
            }
            this.mxR = com.google.android.exoplayer2.b.fn(this.mxO != bVar2 ? this.mxO.mwO : this.mxO.mwO / 2) + elapsedRealtime;
            if (this.mxL == HlsPlaylistTracker.this.mxI && !this.mxO.mwQ) {
                dxC();
            }
        }

        private boolean dxF() {
            this.mxS = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.b(this.mxL, 60000L);
            return HlsPlaylistTracker.this.mxI == this.mxL && !HlsPlaylistTracker.this.dxz();
        }
    }
}
