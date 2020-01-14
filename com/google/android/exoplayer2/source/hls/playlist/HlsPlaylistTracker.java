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
    private final b.a msS;
    private final e mvD;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mvI;
    private com.google.android.exoplayer2.source.hls.playlist.a mvm;
    private final Uri mwU;
    private final int mwV;
    private final c mwY;
    private a.C0673a mxa;
    private com.google.android.exoplayer2.source.hls.playlist.b mxb;
    private boolean mxc;
    private final List<b> listeners = new ArrayList();
    private final Loader mwZ = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<a.C0673a, a> mwW = new IdentityHashMap<>();
    private final Handler mwX = new Handler();

    /* loaded from: classes5.dex */
    public interface b {
        void a(a.C0673a c0673a, long j);

        void dwc();
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
        this.mwU = uri;
        this.mvD = eVar;
        this.msS = aVar;
        this.mwV = i;
        this.mwY = cVar;
        this.mvI = aVar2;
    }

    public void a(b bVar) {
        this.listeners.add(bVar);
    }

    public void b(b bVar) {
        this.listeners.remove(bVar);
    }

    public void start() {
        this.mwZ.a(new p(this.mvD.La(4), this.mwU, 4, this.mvI), this, this.mwV);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a dwk() {
        return this.mvm;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b b(a.C0673a c0673a) {
        com.google.android.exoplayer2.source.hls.playlist.b dwo = this.mwW.get(c0673a).dwo();
        if (dwo != null) {
            f(c0673a);
        }
        return dwo;
    }

    public boolean c(a.C0673a c0673a) {
        return this.mwW.get(c0673a).dwp();
    }

    public void release() {
        this.mwZ.release();
        for (a aVar : this.mwW.values()) {
            aVar.release();
        }
        this.mwX.removeCallbacksAndMessages(null);
        this.mwW.clear();
    }

    public void dwl() throws IOException {
        this.mwZ.duZ();
        if (this.mxa != null) {
            d(this.mxa);
        }
    }

    public void d(a.C0673a c0673a) throws IOException {
        this.mwW.get(c0673a).dwr();
    }

    public void e(a.C0673a c0673a) {
        this.mwW.get(c0673a).dwq();
    }

    public boolean dwm() {
        return this.mxc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.a aVar;
        com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        if (z) {
            aVar = com.google.android.exoplayer2.source.hls.playlist.a.Py(result.mws);
        } else {
            aVar = (com.google.android.exoplayer2.source.hls.playlist.a) result;
        }
        this.mvm = aVar;
        this.mxa = aVar.mvZ.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.mvZ);
        arrayList.addAll(aVar.audios);
        arrayList.addAll(aVar.mwa);
        fm(arrayList);
        a aVar2 = this.mwW.get(this.mxa);
        if (!z) {
            aVar2.dwq();
        } else {
            aVar2.d((com.google.android.exoplayer2.source.hls.playlist.b) result);
        }
        this.msS.a(pVar.dataSpec, 4, j, j2, pVar.dvz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
        this.msS.b(pVar.dataSpec, 4, j, j2, pVar.dvz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.msS.a(pVar.dataSpec, 4, j, j2, pVar.dvz(), iOException, z);
        return z ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwn() {
        List<a.C0673a> list = this.mvm.mvZ;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = this.mwW.get(list.get(i));
            if (elapsedRealtime > aVar.mxk) {
                this.mxa = aVar.mxd;
                aVar.dwq();
                return true;
            }
        }
        return false;
    }

    private void f(a.C0673a c0673a) {
        if (c0673a == this.mxa || !this.mvm.mvZ.contains(c0673a)) {
            return;
        }
        if (this.mxb == null || !this.mxb.mwi) {
            this.mxa = c0673a;
            this.mwW.get(this.mxa).dwq();
        }
    }

    private void fm(List<a.C0673a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.C0673a c0673a = list.get(i);
            this.mwW.put(c0673a, new a(c0673a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0673a c0673a, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (c0673a == this.mxa) {
            if (this.mxb == null) {
                this.mxc = !bVar.mwi;
            }
            this.mxb = bVar;
            this.mwY.b(bVar);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).dwc();
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
            if (bVar2.mwi) {
                return bVar.dwj();
            }
            return bVar;
        }
        return bVar2.D(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.mwj) {
            return bVar2.msC;
        }
        long j = this.mxb != null ? this.mxb.msC : 0L;
        if (bVar != null) {
            int size = bVar.mwl.size();
            b.a d = d(bVar, bVar2);
            if (d != null) {
                return bVar.msC + d.mwn;
            }
            if (size == bVar2.mwf - bVar.mwf) {
                return bVar.dwi();
            }
            return j;
        }
        return j;
    }

    private int c(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.a d;
        if (bVar2.mwd) {
            return bVar2.mwe;
        }
        int i = this.mxb != null ? this.mxb.mwe : 0;
        if (bVar != null && (d = d(bVar, bVar2)) != null) {
            return (d.mwm + bVar.mwe) - bVar2.mwl.get(0).mwm;
        }
        return i;
    }

    private static b.a d(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = bVar2.mwf - bVar.mwf;
        List<b.a> list = bVar.mwl;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class a implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>>, Runnable {
        private final a.C0673a mxd;
        private final Loader mxe = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private final p<com.google.android.exoplayer2.source.hls.playlist.c> mxf;
        private com.google.android.exoplayer2.source.hls.playlist.b mxg;
        private long mxh;
        private long mxi;
        private long mxj;
        private long mxk;
        private boolean mxl;
        private IOException mxm;

        public a(a.C0673a c0673a) {
            this.mxd = c0673a;
            this.mxf = new p<>(HlsPlaylistTracker.this.mvD.La(4), u.fk(HlsPlaylistTracker.this.mvm.mws, c0673a.url), 4, HlsPlaylistTracker.this.mvI);
        }

        public com.google.android.exoplayer2.source.hls.playlist.b dwo() {
            return this.mxg;
        }

        public boolean dwp() {
            if (this.mxg == null) {
                return false;
            }
            return this.mxg.mwi || this.mxg.mwb == 2 || this.mxg.mwb == 1 || Math.max(30000L, com.google.android.exoplayer2.b.fp(this.mxg.lYV)) + this.mxh > SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mxe.release();
        }

        public void dwq() {
            this.mxk = 0L;
            if (!this.mxl && !this.mxe.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.mxj) {
                    this.mxl = true;
                    HlsPlaylistTracker.this.mwX.postDelayed(this, this.mxj - elapsedRealtime);
                    return;
                }
                dws();
            }
        }

        public void dwr() throws IOException {
            this.mxe.duZ();
            if (this.mxm != null) {
                throw this.mxm;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                d((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.msS.a(pVar.dataSpec, 4, j, j2, pVar.dvz());
                return;
            }
            this.mxm = new ParserException("Loaded playlist has unexpected type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
            HlsPlaylistTracker.this.msS.b(pVar.dataSpec, 4, j, j2, pVar.dvz());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ParserException;
            HlsPlaylistTracker.this.msS.a(pVar.dataSpec, 4, j, j2, pVar.dvz(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.o(iOException)) {
                z2 = dwt();
            }
            return z2 ? 0 : 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mxl = false;
            dws();
        }

        private void dws() {
            this.mxe.a(this.mxf, this, HlsPlaylistTracker.this.mwV);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.mxg;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mxh = elapsedRealtime;
            this.mxg = HlsPlaylistTracker.this.a(bVar2, bVar);
            if (this.mxg != bVar2) {
                this.mxm = null;
                this.mxi = elapsedRealtime;
                HlsPlaylistTracker.this.a(this.mxd, this.mxg);
            } else if (!this.mxg.mwi) {
                if (bVar.mwf + bVar.mwl.size() < this.mxg.mwf) {
                    this.mxm = new PlaylistResetException(this.mxd.url);
                } else if (elapsedRealtime - this.mxi > com.google.android.exoplayer2.b.fp(this.mxg.mwg) * 3.5d) {
                    this.mxm = new PlaylistStuckException(this.mxd.url);
                    dwt();
                }
            }
            this.mxj = com.google.android.exoplayer2.b.fp(this.mxg != bVar2 ? this.mxg.mwg : this.mxg.mwg / 2) + elapsedRealtime;
            if (this.mxd == HlsPlaylistTracker.this.mxa && !this.mxg.mwi) {
                dwq();
            }
        }

        private boolean dwt() {
            this.mxk = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.b(this.mxd, 60000L);
            return HlsPlaylistTracker.this.mxa == this.mxd && !HlsPlaylistTracker.this.dwn();
        }
    }
}
