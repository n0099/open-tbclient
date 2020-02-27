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
    private final b.a mtz;
    private com.google.android.exoplayer2.source.hls.playlist.a mvS;
    private final e mwj;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mwo;
    private final Uri mxA;
    private final int mxB;
    private final c mxE;
    private a.C0681a mxG;
    private com.google.android.exoplayer2.source.hls.playlist.b mxH;
    private boolean mxI;
    private final List<b> listeners = new ArrayList();
    private final Loader mxF = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<a.C0681a, a> mxC = new IdentityHashMap<>();
    private final Handler mxD = new Handler();

    /* loaded from: classes6.dex */
    public interface b {
        void a(a.C0681a c0681a, long j);

        void dxm();
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
        this.mxA = uri;
        this.mwj = eVar;
        this.mtz = aVar;
        this.mxB = i;
        this.mxE = cVar;
        this.mwo = aVar2;
    }

    public void a(b bVar) {
        this.listeners.add(bVar);
    }

    public void b(b bVar) {
        this.listeners.remove(bVar);
    }

    public void start() {
        this.mxF.a(new p(this.mwj.Lf(4), this.mxA, 4, this.mwo), this, this.mxB);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a dxu() {
        return this.mvS;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b b(a.C0681a c0681a) {
        com.google.android.exoplayer2.source.hls.playlist.b dxy = this.mxC.get(c0681a).dxy();
        if (dxy != null) {
            f(c0681a);
        }
        return dxy;
    }

    public boolean c(a.C0681a c0681a) {
        return this.mxC.get(c0681a).dxz();
    }

    public void release() {
        this.mxF.release();
        for (a aVar : this.mxC.values()) {
            aVar.release();
        }
        this.mxD.removeCallbacksAndMessages(null);
        this.mxC.clear();
    }

    public void dxv() throws IOException {
        this.mxF.dwj();
        if (this.mxG != null) {
            d(this.mxG);
        }
    }

    public void d(a.C0681a c0681a) throws IOException {
        this.mxC.get(c0681a).dxB();
    }

    public void e(a.C0681a c0681a) {
        this.mxC.get(c0681a).dxA();
    }

    public boolean dxw() {
        return this.mxI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.a aVar;
        com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        if (z) {
            aVar = com.google.android.exoplayer2.source.hls.playlist.a.PL(result.mwY);
        } else {
            aVar = (com.google.android.exoplayer2.source.hls.playlist.a) result;
        }
        this.mvS = aVar;
        this.mxG = aVar.mwF.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.mwF);
        arrayList.addAll(aVar.audios);
        arrayList.addAll(aVar.mwG);
        fh(arrayList);
        a aVar2 = this.mxC.get(this.mxG);
        if (!z) {
            aVar2.dxA();
        } else {
            aVar2.d((com.google.android.exoplayer2.source.hls.playlist.b) result);
        }
        this.mtz.a(pVar.dataSpec, 4, j, j2, pVar.dwJ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
        this.mtz.b(pVar.dataSpec, 4, j, j2, pVar.dwJ());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtz.a(pVar.dataSpec, 4, j, j2, pVar.dwJ(), iOException, z);
        return z ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxx() {
        List<a.C0681a> list = this.mvS.mwF;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = this.mxC.get(list.get(i));
            if (elapsedRealtime > aVar.mxQ) {
                this.mxG = aVar.mxJ;
                aVar.dxA();
                return true;
            }
        }
        return false;
    }

    private void f(a.C0681a c0681a) {
        if (c0681a == this.mxG || !this.mvS.mwF.contains(c0681a)) {
            return;
        }
        if (this.mxH == null || !this.mxH.mwO) {
            this.mxG = c0681a;
            this.mxC.get(this.mxG).dxA();
        }
    }

    private void fh(List<a.C0681a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.C0681a c0681a = list.get(i);
            this.mxC.put(c0681a, new a(c0681a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0681a c0681a, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (c0681a == this.mxG) {
            if (this.mxH == null) {
                this.mxI = !bVar.mwO;
            }
            this.mxH = bVar;
            this.mxE.b(bVar);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).dxm();
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
            if (bVar2.mwO) {
                return bVar.dxt();
            }
            return bVar;
        }
        return bVar2.D(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.mwP) {
            return bVar2.mti;
        }
        long j = this.mxH != null ? this.mxH.mti : 0L;
        if (bVar != null) {
            int size = bVar.mwR.size();
            b.a d = d(bVar, bVar2);
            if (d != null) {
                return bVar.mti + d.mwT;
            }
            if (size == bVar2.mwL - bVar.mwL) {
                return bVar.dxs();
            }
            return j;
        }
        return j;
    }

    private int c(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.a d;
        if (bVar2.mwJ) {
            return bVar2.mwK;
        }
        int i = this.mxH != null ? this.mxH.mwK : 0;
        if (bVar != null && (d = d(bVar, bVar2)) != null) {
            return (d.mwS + bVar.mwK) - bVar2.mwR.get(0).mwS;
        }
        return i;
    }

    private static b.a d(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = bVar2.mwL - bVar.mwL;
        List<b.a> list = bVar.mwR;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>>, Runnable {
        private final a.C0681a mxJ;
        private final Loader mxK = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private final p<com.google.android.exoplayer2.source.hls.playlist.c> mxL;
        private com.google.android.exoplayer2.source.hls.playlist.b mxM;
        private long mxN;
        private long mxO;
        private long mxP;
        private long mxQ;
        private boolean mxR;
        private IOException mxS;

        public a(a.C0681a c0681a) {
            this.mxJ = c0681a;
            this.mxL = new p<>(HlsPlaylistTracker.this.mwj.Lf(4), u.fs(HlsPlaylistTracker.this.mvS.mwY, c0681a.url), 4, HlsPlaylistTracker.this.mwo);
        }

        public com.google.android.exoplayer2.source.hls.playlist.b dxy() {
            return this.mxM;
        }

        public boolean dxz() {
            if (this.mxM == null) {
                return false;
            }
            return this.mxM.mwO || this.mxM.mwH == 2 || this.mxM.mwH == 1 || Math.max(30000L, com.google.android.exoplayer2.b.fn(this.mxM.lZB)) + this.mxN > SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mxK.release();
        }

        public void dxA() {
            this.mxQ = 0L;
            if (!this.mxR && !this.mxK.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.mxP) {
                    this.mxR = true;
                    HlsPlaylistTracker.this.mxD.postDelayed(this, this.mxP - elapsedRealtime);
                    return;
                }
                dxC();
            }
        }

        public void dxB() throws IOException {
            this.mxK.dwj();
            if (this.mxS != null) {
                throw this.mxS;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                d((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.mtz.a(pVar.dataSpec, 4, j, j2, pVar.dwJ());
                return;
            }
            this.mxS = new ParserException("Loaded playlist has unexpected type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
            HlsPlaylistTracker.this.mtz.b(pVar.dataSpec, 4, j, j2, pVar.dwJ());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ParserException;
            HlsPlaylistTracker.this.mtz.a(pVar.dataSpec, 4, j, j2, pVar.dwJ(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.o(iOException)) {
                z2 = dxD();
            }
            return z2 ? 0 : 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mxR = false;
            dxC();
        }

        private void dxC() {
            this.mxK.a(this.mxL, this, HlsPlaylistTracker.this.mxB);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.mxM;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mxN = elapsedRealtime;
            this.mxM = HlsPlaylistTracker.this.a(bVar2, bVar);
            if (this.mxM != bVar2) {
                this.mxS = null;
                this.mxO = elapsedRealtime;
                HlsPlaylistTracker.this.a(this.mxJ, this.mxM);
            } else if (!this.mxM.mwO) {
                if (bVar.mwL + bVar.mwR.size() < this.mxM.mwL) {
                    this.mxS = new PlaylistResetException(this.mxJ.url);
                } else if (elapsedRealtime - this.mxO > com.google.android.exoplayer2.b.fn(this.mxM.mwM) * 3.5d) {
                    this.mxS = new PlaylistStuckException(this.mxJ.url);
                    dxD();
                }
            }
            this.mxP = com.google.android.exoplayer2.b.fn(this.mxM != bVar2 ? this.mxM.mwM : this.mxM.mwM / 2) + elapsedRealtime;
            if (this.mxJ == HlsPlaylistTracker.this.mxG && !this.mxM.mwO) {
                dxA();
            }
        }

        private boolean dxD() {
            this.mxQ = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.b(this.mxJ, 60000L);
            return HlsPlaylistTracker.this.mxG == this.mxJ && !HlsPlaylistTracker.this.dxx();
        }
    }
}
