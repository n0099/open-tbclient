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
    private final b.a mtM;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mwB;
    private com.google.android.exoplayer2.source.hls.playlist.a mwf;
    private final e mww;
    private final Uri mxN;
    private final int mxO;
    private final c mxR;
    private a.C0681a mxT;
    private com.google.android.exoplayer2.source.hls.playlist.b mxU;
    private boolean mxV;
    private final List<b> listeners = new ArrayList();
    private final Loader mxS = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<a.C0681a, a> mxP = new IdentityHashMap<>();
    private final Handler mxQ = new Handler();

    /* loaded from: classes6.dex */
    public interface b {
        void a(a.C0681a c0681a, long j);

        void dxp();
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
        this.mxN = uri;
        this.mww = eVar;
        this.mtM = aVar;
        this.mxO = i;
        this.mxR = cVar;
        this.mwB = aVar2;
    }

    public void a(b bVar) {
        this.listeners.add(bVar);
    }

    public void b(b bVar) {
        this.listeners.remove(bVar);
    }

    public void start() {
        this.mxS.a(new p(this.mww.Lf(4), this.mxN, 4, this.mwB), this, this.mxO);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a dxx() {
        return this.mwf;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b b(a.C0681a c0681a) {
        com.google.android.exoplayer2.source.hls.playlist.b dxB = this.mxP.get(c0681a).dxB();
        if (dxB != null) {
            f(c0681a);
        }
        return dxB;
    }

    public boolean c(a.C0681a c0681a) {
        return this.mxP.get(c0681a).dxC();
    }

    public void release() {
        this.mxS.release();
        for (a aVar : this.mxP.values()) {
            aVar.release();
        }
        this.mxQ.removeCallbacksAndMessages(null);
        this.mxP.clear();
    }

    public void dxy() throws IOException {
        this.mxS.dwm();
        if (this.mxT != null) {
            d(this.mxT);
        }
    }

    public void d(a.C0681a c0681a) throws IOException {
        this.mxP.get(c0681a).dxE();
    }

    public void e(a.C0681a c0681a) {
        this.mxP.get(c0681a).dxD();
    }

    public boolean dxz() {
        return this.mxV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.a aVar;
        com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        if (z) {
            aVar = com.google.android.exoplayer2.source.hls.playlist.a.PM(result.mxl);
        } else {
            aVar = (com.google.android.exoplayer2.source.hls.playlist.a) result;
        }
        this.mwf = aVar;
        this.mxT = aVar.mwS.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.mwS);
        arrayList.addAll(aVar.audios);
        arrayList.addAll(aVar.mwT);
        fh(arrayList);
        a aVar2 = this.mxP.get(this.mxT);
        if (!z) {
            aVar2.dxD();
        } else {
            aVar2.d((com.google.android.exoplayer2.source.hls.playlist.b) result);
        }
        this.mtM.a(pVar.dataSpec, 4, j, j2, pVar.dwM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
        this.mtM.b(pVar.dataSpec, 4, j, j2, pVar.dwM());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.mtM.a(pVar.dataSpec, 4, j, j2, pVar.dwM(), iOException, z);
        return z ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dxA() {
        List<a.C0681a> list = this.mwf.mwS;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = this.mxP.get(list.get(i));
            if (elapsedRealtime > aVar.myd) {
                this.mxT = aVar.mxW;
                aVar.dxD();
                return true;
            }
        }
        return false;
    }

    private void f(a.C0681a c0681a) {
        if (c0681a == this.mxT || !this.mwf.mwS.contains(c0681a)) {
            return;
        }
        if (this.mxU == null || !this.mxU.mxb) {
            this.mxT = c0681a;
            this.mxP.get(this.mxT).dxD();
        }
    }

    private void fh(List<a.C0681a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.C0681a c0681a = list.get(i);
            this.mxP.put(c0681a, new a(c0681a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0681a c0681a, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (c0681a == this.mxT) {
            if (this.mxU == null) {
                this.mxV = !bVar.mxb;
            }
            this.mxU = bVar;
            this.mxR.b(bVar);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).dxp();
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
            if (bVar2.mxb) {
                return bVar.dxw();
            }
            return bVar;
        }
        return bVar2.D(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.mxc) {
            return bVar2.mtv;
        }
        long j = this.mxU != null ? this.mxU.mtv : 0L;
        if (bVar != null) {
            int size = bVar.mxe.size();
            b.a d = d(bVar, bVar2);
            if (d != null) {
                return bVar.mtv + d.mxg;
            }
            if (size == bVar2.mwY - bVar.mwY) {
                return bVar.dxv();
            }
            return j;
        }
        return j;
    }

    private int c(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.a d;
        if (bVar2.mwW) {
            return bVar2.mwX;
        }
        int i = this.mxU != null ? this.mxU.mwX : 0;
        if (bVar != null && (d = d(bVar, bVar2)) != null) {
            return (d.mxf + bVar.mwX) - bVar2.mxe.get(0).mxf;
        }
        return i;
    }

    private static b.a d(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = bVar2.mwY - bVar.mwY;
        List<b.a> list = bVar.mxe;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public final class a implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>>, Runnable {
        private final a.C0681a mxW;
        private final Loader mxX = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private final p<com.google.android.exoplayer2.source.hls.playlist.c> mxY;
        private com.google.android.exoplayer2.source.hls.playlist.b mxZ;
        private long mya;
        private long myb;
        private long myc;
        private long myd;
        private boolean mye;
        private IOException myf;

        public a(a.C0681a c0681a) {
            this.mxW = c0681a;
            this.mxY = new p<>(HlsPlaylistTracker.this.mww.Lf(4), u.fs(HlsPlaylistTracker.this.mwf.mxl, c0681a.url), 4, HlsPlaylistTracker.this.mwB);
        }

        public com.google.android.exoplayer2.source.hls.playlist.b dxB() {
            return this.mxZ;
        }

        public boolean dxC() {
            if (this.mxZ == null) {
                return false;
            }
            return this.mxZ.mxb || this.mxZ.mwU == 2 || this.mxZ.mwU == 1 || Math.max(30000L, com.google.android.exoplayer2.b.fn(this.mxZ.lZO)) + this.mya > SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mxX.release();
        }

        public void dxD() {
            this.myd = 0L;
            if (!this.mye && !this.mxX.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.myc) {
                    this.mye = true;
                    HlsPlaylistTracker.this.mxQ.postDelayed(this, this.myc - elapsedRealtime);
                    return;
                }
                dxF();
            }
        }

        public void dxE() throws IOException {
            this.mxX.dwm();
            if (this.myf != null) {
                throw this.myf;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                d((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.mtM.a(pVar.dataSpec, 4, j, j2, pVar.dwM());
                return;
            }
            this.myf = new ParserException("Loaded playlist has unexpected type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
            HlsPlaylistTracker.this.mtM.b(pVar.dataSpec, 4, j, j2, pVar.dwM());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ParserException;
            HlsPlaylistTracker.this.mtM.a(pVar.dataSpec, 4, j, j2, pVar.dwM(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.o(iOException)) {
                z2 = dxG();
            }
            return z2 ? 0 : 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mye = false;
            dxF();
        }

        private void dxF() {
            this.mxX.a(this.mxY, this, HlsPlaylistTracker.this.mxO);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.mxZ;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mya = elapsedRealtime;
            this.mxZ = HlsPlaylistTracker.this.a(bVar2, bVar);
            if (this.mxZ != bVar2) {
                this.myf = null;
                this.myb = elapsedRealtime;
                HlsPlaylistTracker.this.a(this.mxW, this.mxZ);
            } else if (!this.mxZ.mxb) {
                if (bVar.mwY + bVar.mxe.size() < this.mxZ.mwY) {
                    this.myf = new PlaylistResetException(this.mxW.url);
                } else if (elapsedRealtime - this.myb > com.google.android.exoplayer2.b.fn(this.mxZ.mwZ) * 3.5d) {
                    this.myf = new PlaylistStuckException(this.mxW.url);
                    dxG();
                }
            }
            this.myc = com.google.android.exoplayer2.b.fn(this.mxZ != bVar2 ? this.mxZ.mwZ : this.mxZ.mwZ / 2) + elapsedRealtime;
            if (this.mxW == HlsPlaylistTracker.this.mxT && !this.mxZ.mxb) {
                dxD();
            }
        }

        private boolean dxG() {
            this.myd = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.b(this.mxW, 60000L);
            return HlsPlaylistTracker.this.mxT == this.mxW && !HlsPlaylistTracker.this.dxA();
        }
    }
}
