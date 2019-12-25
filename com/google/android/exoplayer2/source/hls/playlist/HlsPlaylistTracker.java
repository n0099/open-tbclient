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
/* loaded from: classes4.dex */
public final class HlsPlaylistTracker implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>> {
    private final b.a moY;
    private final e mrJ;
    private final p.a<com.google.android.exoplayer2.source.hls.playlist.c> mrO;
    private com.google.android.exoplayer2.source.hls.playlist.a mrs;
    private final Uri mtb;
    private final int mtc;
    private final c mtf;
    private a.C0667a mth;
    private com.google.android.exoplayer2.source.hls.playlist.b mti;
    private boolean mtj;
    private final List<b> listeners = new ArrayList();
    private final Loader mtg = new Loader("HlsPlaylistTracker:MasterPlaylist");
    private final IdentityHashMap<a.C0667a, a> mtd = new IdentityHashMap<>();
    private final Handler mte = new Handler();

    /* loaded from: classes4.dex */
    public interface b {
        void a(a.C0667a c0667a, long j);

        void duP();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void b(com.google.android.exoplayer2.source.hls.playlist.b bVar);
    }

    /* loaded from: classes4.dex */
    public static final class PlaylistStuckException extends IOException {
        public final String url;

        private PlaylistStuckException(String str) {
            this.url = str;
        }
    }

    /* loaded from: classes4.dex */
    public static final class PlaylistResetException extends IOException {
        public final String url;

        private PlaylistResetException(String str) {
            this.url = str;
        }
    }

    public HlsPlaylistTracker(Uri uri, e eVar, b.a aVar, int i, c cVar, p.a<com.google.android.exoplayer2.source.hls.playlist.c> aVar2) {
        this.mtb = uri;
        this.mrJ = eVar;
        this.moY = aVar;
        this.mtc = i;
        this.mtf = cVar;
        this.mrO = aVar2;
    }

    public void a(b bVar) {
        this.listeners.add(bVar);
    }

    public void b(b bVar) {
        this.listeners.remove(bVar);
    }

    public void start() {
        this.mtg.a(new p(this.mrJ.KR(4), this.mtb, 4, this.mrO), this, this.mtc);
    }

    public com.google.android.exoplayer2.source.hls.playlist.a duX() {
        return this.mrs;
    }

    public com.google.android.exoplayer2.source.hls.playlist.b b(a.C0667a c0667a) {
        com.google.android.exoplayer2.source.hls.playlist.b dvb = this.mtd.get(c0667a).dvb();
        if (dvb != null) {
            f(c0667a);
        }
        return dvb;
    }

    public boolean c(a.C0667a c0667a) {
        return this.mtd.get(c0667a).dvc();
    }

    public void release() {
        this.mtg.release();
        for (a aVar : this.mtd.values()) {
            aVar.release();
        }
        this.mte.removeCallbacksAndMessages(null);
        this.mtd.clear();
    }

    public void duY() throws IOException {
        this.mtg.dtM();
        if (this.mth != null) {
            d(this.mth);
        }
    }

    public void d(a.C0667a c0667a) throws IOException {
        this.mtd.get(c0667a).dve();
    }

    public void e(a.C0667a c0667a) {
        this.mtd.get(c0667a).dvd();
    }

    public boolean duZ() {
        return this.mtj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: d */
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
        com.google.android.exoplayer2.source.hls.playlist.a aVar;
        com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
        boolean z = result instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        if (z) {
            aVar = com.google.android.exoplayer2.source.hls.playlist.a.Pn(result.msz);
        } else {
            aVar = (com.google.android.exoplayer2.source.hls.playlist.a) result;
        }
        this.mrs = aVar;
        this.mth = aVar.msf.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.msf);
        arrayList.addAll(aVar.audios);
        arrayList.addAll(aVar.msh);
        fm(arrayList);
        a aVar2 = this.mtd.get(this.mth);
        if (!z) {
            aVar2.dvd();
        } else {
            aVar2.d((com.google.android.exoplayer2.source.hls.playlist.b) result);
        }
        this.moY.a(pVar.dataSpec, 4, j, j2, pVar.dum());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
        this.moY.b(pVar.dataSpec, 4, j, j2, pVar.dum());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.Loader.a
    /* renamed from: c */
    public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
        boolean z = iOException instanceof ParserException;
        this.moY.a(pVar.dataSpec, 4, j, j2, pVar.dum(), iOException, z);
        return z ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dva() {
        List<a.C0667a> list = this.mrs.msf;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            a aVar = this.mtd.get(list.get(i));
            if (elapsedRealtime > aVar.mtr) {
                this.mth = aVar.mtk;
                aVar.dvd();
                return true;
            }
        }
        return false;
    }

    private void f(a.C0667a c0667a) {
        if (c0667a == this.mth || !this.mrs.msf.contains(c0667a)) {
            return;
        }
        if (this.mti == null || !this.mti.msp) {
            this.mth = c0667a;
            this.mtd.get(this.mth).dvd();
        }
    }

    private void fm(List<a.C0667a> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a.C0667a c0667a = list.get(i);
            this.mtd.put(c0667a, new a(c0667a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a.C0667a c0667a, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (c0667a == this.mth) {
            if (this.mti == null) {
                this.mtj = !bVar.msp;
            }
            this.mti = bVar;
            this.mtf.b(bVar);
        }
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).duP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.C0667a c0667a, long j) {
        int size = this.listeners.size();
        for (int i = 0; i < size; i++) {
            this.listeners.get(i).a(c0667a, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.exoplayer2.source.hls.playlist.b a(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (!bVar2.c(bVar)) {
            if (bVar2.msp) {
                return bVar.duW();
            }
            return bVar;
        }
        return bVar2.D(b(bVar, bVar2), c(bVar, bVar2));
    }

    private long b(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.msq) {
            return bVar2.moI;
        }
        long j = this.mti != null ? this.mti.moI : 0L;
        if (bVar != null) {
            int size = bVar.mss.size();
            b.a d = d(bVar, bVar2);
            if (d != null) {
                return bVar.moI + d.msu;
            }
            if (size == bVar2.msm - bVar.msm) {
                return bVar.duV();
            }
            return j;
        }
        return j;
    }

    private int c(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.a d;
        if (bVar2.msk) {
            return bVar2.msl;
        }
        int i = this.mti != null ? this.mti.msl : 0;
        if (bVar != null && (d = d(bVar, bVar2)) != null) {
            return (d.mst + bVar.msl) - bVar2.mss.get(0).mst;
        }
        return i;
    }

    private static b.a d(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = bVar2.msm - bVar.msm;
        List<b.a> list = bVar.mss;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class a implements Loader.a<p<com.google.android.exoplayer2.source.hls.playlist.c>>, Runnable {
        private final a.C0667a mtk;
        private final Loader mtl = new Loader("HlsPlaylistTracker:MediaPlaylist");
        private final p<com.google.android.exoplayer2.source.hls.playlist.c> mtm;
        private com.google.android.exoplayer2.source.hls.playlist.b mtn;
        private long mto;
        private long mtp;
        private long mtq;
        private long mtr;
        private boolean mts;
        private IOException mtt;

        public a(a.C0667a c0667a) {
            this.mtk = c0667a;
            this.mtm = new p<>(HlsPlaylistTracker.this.mrJ.KR(4), u.fi(HlsPlaylistTracker.this.mrs.msz, c0667a.url), 4, HlsPlaylistTracker.this.mrO);
        }

        public com.google.android.exoplayer2.source.hls.playlist.b dvb() {
            return this.mtn;
        }

        public boolean dvc() {
            if (this.mtn == null) {
                return false;
            }
            return this.mtn.msp || this.mtn.msi == 2 || this.mtn.msi == 1 || Math.max(30000L, com.google.android.exoplayer2.b.fk(this.mtn.lUZ)) + this.mto > SystemClock.elapsedRealtime();
        }

        public void release() {
            this.mtl.release();
        }

        public void dvd() {
            this.mtr = 0L;
            if (!this.mts && !this.mtl.isLoading()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.mtq) {
                    this.mts = true;
                    HlsPlaylistTracker.this.mte.postDelayed(this, this.mtq - elapsedRealtime);
                    return;
                }
                dvf();
            }
        }

        public void dve() throws IOException {
            this.mtl.dtM();
            if (this.mtt != null) {
                throw this.mtt;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: d */
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2) {
            com.google.android.exoplayer2.source.hls.playlist.c result = pVar.getResult();
            if (result instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                d((com.google.android.exoplayer2.source.hls.playlist.b) result);
                HlsPlaylistTracker.this.moY.a(pVar.dataSpec, 4, j, j2, pVar.dum());
                return;
            }
            this.mtt = new ParserException("Loaded playlist has unexpected type.");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        public void a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, boolean z) {
            HlsPlaylistTracker.this.moY.b(pVar.dataSpec, 4, j, j2, pVar.dum());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.exoplayer2.upstream.Loader.a
        /* renamed from: c */
        public int a(p<com.google.android.exoplayer2.source.hls.playlist.c> pVar, long j, long j2, IOException iOException) {
            boolean z = iOException instanceof ParserException;
            HlsPlaylistTracker.this.moY.a(pVar.dataSpec, 4, j, j2, pVar.dum(), iOException, z);
            if (z) {
                return 3;
            }
            boolean z2 = true;
            if (h.o(iOException)) {
                z2 = dvg();
            }
            return z2 ? 0 : 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mts = false;
            dvf();
        }

        private void dvf() {
            this.mtl.a(this.mtm, this, HlsPlaylistTracker.this.mtc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(com.google.android.exoplayer2.source.hls.playlist.b bVar) {
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.mtn;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mto = elapsedRealtime;
            this.mtn = HlsPlaylistTracker.this.a(bVar2, bVar);
            if (this.mtn != bVar2) {
                this.mtt = null;
                this.mtp = elapsedRealtime;
                HlsPlaylistTracker.this.a(this.mtk, this.mtn);
            } else if (!this.mtn.msp) {
                if (bVar.msm + bVar.mss.size() < this.mtn.msm) {
                    this.mtt = new PlaylistResetException(this.mtk.url);
                } else if (elapsedRealtime - this.mtp > com.google.android.exoplayer2.b.fk(this.mtn.msn) * 3.5d) {
                    this.mtt = new PlaylistStuckException(this.mtk.url);
                    dvg();
                }
            }
            this.mtq = com.google.android.exoplayer2.b.fk(this.mtn != bVar2 ? this.mtn.msn : this.mtn.msn / 2) + elapsedRealtime;
            if (this.mtk == HlsPlaylistTracker.this.mth && !this.mtn.msp) {
                dvd();
            }
        }

        private boolean dvg() {
            this.mtr = SystemClock.elapsedRealtime() + 60000;
            HlsPlaylistTracker.this.b(this.mtk, 60000L);
            return HlsPlaylistTracker.this.mth == this.mtk && !HlsPlaylistTracker.this.dva();
        }
    }
}
