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
    private final b.a mvs;
    private com.google.android.exoplayer2.source.hls.playlist.a mxL;
    private final e myc;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> myh;
    private com.google.android.exoplayer2.source.hls.playlist.b mzA;
    private boolean mzB;
    private final Uri mzt;
    private final int mzu;
    private final c mzx;
    private a.C0682a mzz;
    private final List<b> listeners = new ArrayList();
    private final Loader mzy = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<a.C0682a, a> mzv = new IdentityHashMap<>();
    private final Handler mzw = new Handler();

    /* loaded from: classes6.dex */
    public interface b {
        void a(a.C0682a c0682a, long j);

        void dxM();
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
        this.mzt = uri;
        this.myc = eVar;
        this.mvs = aVar;
        this.mzu = i;
        this.mzx = cVar;
        this.myh = aVar2;
    }

    public void a(b bVar) {
        this.listeners.add(bVar);
    }

    public void b(b bVar) {
        this.listeners.remove(bVar);
    }

    public void start() {
        this.mzy.a(new p(this.myc.Ll(4), this.mzt, 4, this.myh), this, this.mzu);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a dxU() {
        return this.mxL;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b b(a.C0682a c0682a) {
        com.google.android.exoplayer2.source.hls.playlist.b dxY = this.mzv.get(c0682a).dxY();
        if (dxY != null) {
            f(c0682a);
        }
        return dxY;
    }

    public boolean c(a.C0682a c0682a) {
        return this.mzv.get(c0682a).dxZ();
    }

    public void release() {
        this.mzy.release();
        for (a aVar : this.mzv.values()) {
            aVar.release();
        }
        this.mzw.removeCallbacksAndMessages(null);
        this.mzv.clear();
    }

    public void dxV() throws IOException {
        this.mzy.dwJ();
        if (this.mzz != null) {
            d(this.mzz);
        }
    }

    public void d(a.C0682a c0682a) throws IOException {
        this.mzv.get(c0682a).dyb();
    }

    public void e(a.C0682a c0682a) {
        this.mzv.get(c0682a).dya();
    }

    public boolean dxW() {
        return this.mzB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.a aVar;
        com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        if (z) {
            aVar = com.google.android.exoplayer2.source.hls.playlist.a.PL(result.myR);
        } else {
            aVar = (com.google.android.exoplayer2.source.hls.playlist.a) result;
        }
        this.mxL = aVar;
        this.mzz = aVar.myy.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.myy);
        arrayList.addAll(aVar.audios);
        arrayList.addAll(aVar.myz);
        fh(arrayList);
        a aVar2 = this.mzv.get(this.mzz);
        if (!z) {
            aVar2.dya();
        } else {
            aVar2.d((com.google.android.exoplayer2.source.hls.playlist.b) result);
        }
        this.mvs.a(pVar.dataSpec, 4, j, j2, pVar.dxj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
        this.mvs.b(pVar.dataSpec, 4, j, j2, pVar.dxj());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mvs.a(pVar.dataSpec, 4, j, j2, pVar.dxj(), iOException, z);
        return z ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxX() {
        List<a.C0682a> list = this.mxL.myy;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = this.mzv.get(list.get(i));
            if (elapsedRealtime > aVar.mzJ) {
                this.mzz = aVar.mzC;
                aVar.dya();
                return true;
            }
        }
        return false;
    }

    private void f(a.C0682a c0682a) {
        if (c0682a == this.mzz || !this.mxL.myy.contains(c0682a)) {
            return;
        }
        if (this.mzA == null || !this.mzA.myH) {
            this.mzz = c0682a;
            this.mzv.get(this.mzz).dya();
        }
    }

    private void fh(List<a.C0682a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.C0682a c0682a = list.get(i);
            this.mzv.put(c0682a, new a(c0682a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0682a c0682a, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (c0682a == this.mzz) {
            if (this.mzA == null) {
                this.mzB = !bVar.myH;
            }
            this.mzA = bVar;
            this.mzx.b(bVar);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).dxM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0682a c0682a, long j) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).a(c0682a, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.exoplayer2.source.hls.playlist.b a(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (!bVar2.c(bVar)) {
            if (bVar2.myH) {
                return bVar.dxT();
            }
            return bVar;
        }
        return bVar2.D(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.myI) {
            return bVar2.mvc;
        }
        long j = this.mzA != null ? this.mzA.mvc : 0L;
        if (bVar != null) {
            int size = bVar.myK.size();
            b.a d = d(bVar, bVar2);
            if (d != null) {
                return bVar.mvc + d.myM;
            }
            if (size == bVar2.myE - bVar.myE) {
                return bVar.dxS();
            }
            return j;
        }
        return j;
    }

    private int c(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.a d;
        if (bVar2.myC) {
            return bVar2.myD;
        }
        int i = this.mzA != null ? this.mzA.myD : 0;
        if (bVar != null && (d = d(bVar, bVar2)) != null) {
            return (d.myL + bVar.myD) - bVar2.myK.get(0).myL;
        }
        return i;
    }

    private static b.a d(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = bVar2.myE - bVar.myE;
        List<b.a> list = bVar.myK;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>>, Runnable {
        private final a.C0682a mzC;
        private final Loader mzD = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private final p<com.google.android.exoplayer2.source.hls.playlist.c> mzE;
        private com.google.android.exoplayer2.source.hls.playlist.b mzF;
        private long mzG;
        private long mzH;
        private long mzI;
        private long mzJ;
        private boolean mzK;
        private IOException mzL;

        public a(a.C0682a c0682a) {
            this.mzC = c0682a;
            this.mzE = new p<>(HlsPlaylistTracker.this.myc.Ll(4), u.fq(HlsPlaylistTracker.this.mxL.myR, c0682a.url), 4, HlsPlaylistTracker.this.myh);
        }

        public com.google.android.exoplayer2.source.hls.playlist.b dxY() {
            return this.mzF;
        }

        public boolean dxZ() {
            if (this.mzF == null) {
                return false;
            }
            return this.mzF.myH || this.mzF.myA == 2 || this.mzF.myA == 1 || Math.max(30000L, com.google.android.exoplayer2.b.fo(this.mzF.mbx)) + this.mzG > SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mzD.release();
        }

        public void dya() {
            this.mzJ = 0L;
            if (!this.mzK && !this.mzD.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.mzI) {
                    this.mzK = true;
                    HlsPlaylistTracker.this.mzw.postDelayed(this, this.mzI - elapsedRealtime);
                    return;
                }
                dyc();
            }
        }

        public void dyb() throws IOException {
            this.mzD.dwJ();
            if (this.mzL != null) {
                throw this.mzL;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                d((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.mvs.a(pVar.dataSpec, 4, j, j2, pVar.dxj());
                return;
            }
            this.mzL = new ParserException("Loaded playlist has unexpected type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
            HlsPlaylistTracker.this.mvs.b(pVar.dataSpec, 4, j, j2, pVar.dxj());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ParserException;
            HlsPlaylistTracker.this.mvs.a(pVar.dataSpec, 4, j, j2, pVar.dxj(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.o(iOException)) {
                z2 = dyd();
            }
            return z2 ? 0 : 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mzK = false;
            dyc();
        }

        private void dyc() {
            this.mzD.a(this.mzE, this, HlsPlaylistTracker.this.mzu);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.mzF;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mzG = elapsedRealtime;
            this.mzF = HlsPlaylistTracker.this.a(bVar2, bVar);
            if (this.mzF != bVar2) {
                this.mzL = null;
                this.mzH = elapsedRealtime;
                HlsPlaylistTracker.this.a(this.mzC, this.mzF);
            } else if (!this.mzF.myH) {
                if (bVar.myE + bVar.myK.size() < this.mzF.myE) {
                    this.mzL = new PlaylistResetException(this.mzC.url);
                } else if (elapsedRealtime - this.mzH > com.google.android.exoplayer2.b.fo(this.mzF.myF) * 3.5d) {
                    this.mzL = new PlaylistStuckException(this.mzC.url);
                    dyd();
                }
            }
            this.mzI = com.google.android.exoplayer2.b.fo(this.mzF != bVar2 ? this.mzF.myF : this.mzF.myF / 2) + elapsedRealtime;
            if (this.mzC == HlsPlaylistTracker.this.mzz && !this.mzF.myH) {
                dya();
            }
        }

        private boolean dyd() {
            this.mzJ = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.b(this.mzC, 60000L);
            return HlsPlaylistTracker.this.mzz == this.mzC && !HlsPlaylistTracker.this.dxX();
        }
    }
}
