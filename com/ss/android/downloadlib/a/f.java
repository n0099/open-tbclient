package com.ss.android.downloadlib.a;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.a.a.a.q;
import com.ss.android.a.a.a.s;
import com.ss.android.a.a.b.f;
import com.ss.android.b.a.a.a;
import com.ss.android.downloadlib.a.b.d;
import com.ss.android.downloadlib.a.h;
import com.ss.android.downloadlib.f.j;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.g.c;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class f implements g, j.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13256a = f.class.getSimpleName();
    private WeakReference<Context> e;
    private boolean k;
    private long l;
    private com.ss.android.a.a.d.e pVV;
    private com.ss.android.socialbase.downloader.g.c pVW;
    private c pVX;
    private SoftReference<s> pWc;
    private boolean r;
    private final com.ss.android.downloadlib.f.j pVT = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private final com.ss.android.socialbase.downloader.d.b pVY = new h.a(this.pVT);
    private long m = -1;
    private com.ss.android.a.a.b.c pVZ = null;
    private com.ss.android.a.a.b.b pWa = null;
    private com.ss.android.a.a.b.a pWb = null;
    private h pVU = new h();
    private e pVQ = new e(this.pVT);
    private final boolean s = com.ss.android.socialbase.downloader.k.a.eJW().a("ttdownloader_callback_twice");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface b {
        void a(long j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: iw */
    public f ix(Context context) {
        if (context != null) {
            this.e = new WeakReference<>(context);
        }
        j.b(context);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(int i, com.ss.android.a.a.b.d dVar) {
        if (dVar != null) {
            if (j.i().optInt("back_use_softref_listener") == 1) {
                this.f.put(Integer.valueOf(i), dVar);
            } else {
                this.f.put(Integer.valueOf(i), new SoftReference(dVar));
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: c */
    public f d(com.ss.android.a.a.b.c cVar) {
        if (cVar != null) {
            com.ss.android.downloadlib.a.b.d.eFT().a(cVar);
            this.m = cVar.d();
            this.pVZ = cVar;
            if (i.b(cVar)) {
                ((com.ss.android.b.a.a.c) cVar).a(3L);
                com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eFT().jb(this.m);
                if (jb != null && jb.k() != 3) {
                    jb.e(3L);
                    com.ss.android.downloadlib.a.b.g.eFW().d(jb);
                }
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.a aVar) {
        this.pWb = aVar;
        com.ss.android.downloadlib.a.b.d.eFT().a(this.m, eGb());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.pWa = bVar;
        this.r = eGa().k() == 0;
        com.ss.android.downloadlib.a.b.d.eFT().a(this.m, eGa());
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public g a(s sVar) {
        if (sVar == null) {
            this.pWc = null;
        } else {
            this.pWc = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.a.b.d.eFT().a(this.m, eGa());
        com.ss.android.downloadlib.a.b.d.eFT().a(this.m, eGb());
        this.pVU.a(this.m);
        p();
        if (j.i().optInt("enable_empty_listener", 1) == 1 && this.f.get(Integer.MIN_VALUE) == null) {
            b(Integer.MIN_VALUE, new com.ss.android.a.a.a.a());
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean a(int i) {
        if (i == 0) {
            this.f.clear();
        } else {
            this.f.remove(Integer.valueOf(i));
        }
        if (this.f.isEmpty()) {
            this.k = false;
            this.l = System.currentTimeMillis();
            if (this.pVW != null) {
                com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).k(this.pVW.g());
            }
            if (this.pVX != null && this.pVX.getStatus() != AsyncTask.Status.FINISHED) {
                this.pVX.cancel(true);
            }
            this.pVU.a(this.pVW);
            com.ss.android.downloadlib.f.h.i(f13256a, "onUnbind removeCallbacksAndMessages, downloadUrl:" + (this.pVW == null ? "" : this.pVW.j()), null);
            this.pVT.removeCallbacksAndMessages(null);
            this.pVV = null;
            this.pVW = null;
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(boolean z) {
        if (this.pVW != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d eGI = com.ss.android.socialbase.appdownloader.d.eGM().eGI();
                if (eGI != null) {
                    eGI.a(this.pVW);
                }
                com.ss.android.socialbase.downloader.downloader.f.iA(com.ss.android.socialbase.downloader.downloader.b.eHT()).a(this.pVW.g(), true);
                return;
            }
            Intent intent = new Intent(j.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.pVW.g());
            j.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.pVW != null;
    }

    @Override // com.ss.android.downloadlib.a.g
    public long d() {
        return this.l;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(long j, int i) {
        if (i != 2 && i != 1) {
            throw new IllegalArgumentException("error actionType");
        }
        if (j > 0) {
            com.ss.android.a.a.b.c iY = com.ss.android.downloadlib.a.b.d.eFT().iY(j);
            if (iY != null) {
                this.pVZ = iY;
                this.m = j;
                this.pVU.a(this.m);
            }
        } else {
            com.ss.android.downloadlib.f.i.b();
        }
        if (!this.pVU.e(k(), i, this.r)) {
            boolean b2 = b(i);
            switch (i) {
                case 1:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f13256a, "handleDownload id:" + j + ",tryPerformItemClick:", null);
                        c(true);
                        return;
                    }
                    return;
                case 2:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f13256a, "handleDownload id:" + j + ",tryPerformButtonClick:", null);
                        b(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean i() {
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && com.ss.android.downloadlib.a.c.b(this.pVZ) && com.ss.android.downloadlib.a.c.a(this.pVW);
    }

    private boolean b(int i) {
        if (i()) {
            int i2 = -1;
            String a2 = this.pVZ.eFy().a();
            switch (i) {
                case 1:
                    i2 = 5;
                    break;
                case 2:
                    i2 = 4;
                    break;
            }
            com.ss.android.downloadlib.e.a.eGB().a(this.m, i);
            boolean c2 = com.ss.android.downloadlib.f.f.c(j.a(), a2);
            if (c2) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.pVZ.d());
                this.pVT.sendMessageDelayed(obtain, com.ss.android.downloadlib.a.c.eFX().b());
                com.ss.android.downloadlib.a.c.eFX().a(i2, this.pVZ, this.pWa);
            } else {
                com.ss.android.downloadlib.e.a.eGB().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void b(boolean z) {
        switch (this.pVU.a(this.r)) {
            case 1:
                if (z) {
                    com.ss.android.downloadlib.e.a.eGB().a(this.m, 1);
                }
                j();
                return;
            default:
                d(z);
                return;
        }
    }

    private void j() {
        if (this.pWc != null && this.pWc.get() != null) {
            this.pWc.get().a(this.pVZ, eGa(), eGb());
            this.pWc = null;
            return;
        }
        j.eGe().a(k(), this.pVZ, eGb(), eGa());
    }

    private void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.eGB().a(this.m, 1);
        }
        e(z);
    }

    private void d(boolean z) {
        f(z);
    }

    public void e() {
        this.pVT.post(new Runnable() { // from class: com.ss.android.downloadlib.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                    dVar.b(f.this.eGc());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null && this.k) {
            switch (message.what) {
                case 3:
                    this.pVW = (com.ss.android.socialbase.downloader.g.c) message.obj;
                    this.pVU.a(message, eGc(), this.f);
                    return;
                case 4:
                    if (j.eGm() == null || !j.eGm().a()) {
                        com.ss.android.downloadlib.e.a.eGB().a(this.m, false, 2);
                        b(false);
                        return;
                    }
                    return;
                case 5:
                    if (j.eGm() == null || !j.eGm().a()) {
                        com.ss.android.downloadlib.e.a.eGB().a(this.m, false, 1);
                        c(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context k() {
        return (this.e == null || this.e.get() == null) ? j.a() : this.e.get();
    }

    @NonNull
    private com.ss.android.a.a.b.b eGa() {
        return this.pWa == null ? new f.a().eFA() : this.pWa;
    }

    @NonNull
    private com.ss.android.a.a.b.a eGb() {
        return this.pWb == null ? new a.C1231a().eFE() : this.pWb;
    }

    private void e(boolean z) {
        com.ss.android.downloadlib.f.h.i(f13256a, "performItemClickWithNewDownloader", null);
        if (this.pVU.c(this.pVW)) {
            com.ss.android.downloadlib.f.h.i(f13256a, "performItemClickWithNewDownloader ButtonClick", null);
            f(z);
            return;
        }
        com.ss.android.downloadlib.f.h.i(f13256a, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(boolean z) {
        com.ss.android.downloadlib.f.h.i(f13256a, "performButtonClickWithNewDownloader", null);
        if (this.pVW == null || (this.pVW.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).d(this.pVW.g()))) {
            if (z) {
                com.ss.android.downloadlib.e.a.eGB().a(this.m, 2);
            }
            if (com.ss.android.downloadlib.f.d.i(this.pVZ) != 0) {
                n();
                return;
            }
            com.ss.android.downloadlib.f.h.i(f13256a, "performButtonClickWithNewDownloader not start", null);
            this.pVU.a(new q() { // from class: com.ss.android.downloadlib.a.f.2
                @Override // com.ss.android.a.a.a.q
                public void a() {
                    com.ss.android.downloadlib.f.h.i(f.f13256a, "performButtonClickWithNewDownloader start download", null);
                    f.this.n();
                }

                @Override // com.ss.android.a.a.a.q
                public void a(String str) {
                    com.ss.android.downloadlib.f.h.i(f.f13256a, "performButtonClickWithNewDownloader onDenied", null);
                }
            });
            return;
        }
        com.ss.android.downloadlib.f.h.i(f13256a, "performButtonClickWithNewDownloader continue download, status:" + this.pVW.q(), null);
        this.pVU.d(this.pVW);
        if (this.pVW != null && this.pVZ != null) {
            this.pVW.c(this.pVZ.m());
        }
        final int q = this.pVW.q();
        final int g = this.pVW.g();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eFT().j(this.pVW);
        if (q == -4 || q == -2 || q == -1) {
            if (j != null) {
                j.h(System.currentTimeMillis());
                j.iX(this.pVW.eIz());
            }
            this.pVW.d(false);
            this.pVQ.a(new d.a(this.m, this.pVZ, eGa(), eGb()));
            this.pVQ.a(g, this.pVW.eIz(), this.pVW.ejL(), new a() { // from class: com.ss.android.downloadlib.a.f.3
                @Override // com.ss.android.downloadlib.a.f.a
                public void a() {
                    if (!f.this.pVQ.a()) {
                        com.ss.android.socialbase.appdownloader.d.eGM().e(j.a(), g, q);
                    }
                }
            });
            return;
        }
        if (l.a(q)) {
            this.pVQ.a(true);
        }
        com.ss.android.socialbase.appdownloader.d.eGM().e(j.a(), g, q);
        l.a(j, this.pVW, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.pVQ.a(new d.a(this.m, this.pVZ, eGa(), eGb()));
        this.pVQ.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.a.f.4
            @Override // com.ss.android.downloadlib.a.f.a
            public void a() {
                if (!f.this.pVQ.a()) {
                    f.this.o();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
            dVar.a(this.pVZ, eGb());
        }
        int a2 = this.pVU.a(j.a(), this.pVY);
        com.ss.android.b.a.b.a a3 = a(this.pVZ, a2);
        com.ss.android.downloadlib.a.b.d.eFT().d(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.iX(0L);
        com.ss.android.downloadlib.f.h.i(f13256a, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.pVW == null) {
                this.pVU.b();
            } else {
                this.pVU.d(this.pVW);
            }
        } else {
            com.ss.android.socialbase.downloader.g.c a4 = new c.a(this.pVZ.a()).a();
            a4.c(-1);
            a(a4);
            com.ss.android.downloadlib.e.a.eGB().a(this.m, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
            com.ss.android.downloadlib.f.i.b();
        }
        if (this.pVU.b(c())) {
            com.ss.android.downloadlib.f.h.i(f13256a, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    private com.ss.android.b.a.b.a a(com.ss.android.a.a.b.c cVar, int i) {
        com.ss.android.b.a.b.a aVar = new com.ss.android.b.a.b.a(cVar, eGa(), eGb(), i);
        if (com.ss.android.socialbase.downloader.k.a.Th(i).a("download_event_opt", 1) > 1) {
            try {
                String v = this.pVZ.v();
                if (!TextUtils.isEmpty(v)) {
                    aVar.f(j.a().getPackageManager().getPackageInfo(v, 0) != null);
                }
            } catch (Throwable th) {
            }
        }
        return aVar;
    }

    public void f() {
        if (this.f.size() != 0) {
            for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
                dVar.a();
            }
            if (this.pVW != null) {
                this.pVW.c(-4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c extends AsyncTask<String, Void, com.ss.android.socialbase.downloader.g.c> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: ai */
        public com.ss.android.socialbase.downloader.g.c doInBackground(String... strArr) {
            com.ss.android.socialbase.downloader.g.c cVar = null;
            if (strArr != null) {
                if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                    String str = strArr[0];
                    if (f.this.pVZ != null && !TextUtils.isEmpty(f.this.pVZ.n())) {
                        cVar = com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).ht(str, f.this.pVZ.n());
                    }
                    if (cVar == null) {
                        return com.ss.android.socialbase.appdownloader.d.eGM().bH(j.a(), str);
                    }
                    return cVar;
                }
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(com.ss.android.socialbase.downloader.g.c cVar) {
            super.onPostExecute(cVar);
            if (!isCancelled() && f.this.pVZ != null) {
                try {
                    com.ss.android.downloadlib.a.b.b A = com.ss.android.downloadlib.f.i.A(f.this.pVZ.v(), f.this.pVZ.r(), f.this.pVZ.s());
                    com.ss.android.downloadlib.a.b.f.eFV().a(f.this.pVZ.r(), A.b(), com.ss.android.downloadlib.a.b.d.eFT().j(cVar));
                    boolean a2 = A.a();
                    if (cVar != null && cVar.g() != 0 && (a2 || !com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(cVar))) {
                        com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).k(cVar.g());
                        if (f.this.pVW == null || f.this.pVW.q() != -4) {
                            f.this.pVW = cVar;
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(f.this.pVW.g(), f.this.pVY, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(f.this.pVW.g(), f.this.pVY);
                            }
                        } else {
                            f.this.pVW = null;
                        }
                        f.this.pVU.a(f.this.pVW, f.this.eGc(), h.a(f.this.f));
                    } else {
                        if (cVar != null && com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(cVar)) {
                            com.ss.android.socialbase.downloader.notification.b.eKa().f(cVar.g());
                            f.this.pVW = null;
                        }
                        if (f.this.pVW != null) {
                            com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).k(f.this.pVW.g());
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iA(f.this.k()).a(f.this.pVW.g(), f.this.pVY, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iA(f.this.k()).a(f.this.pVW.g(), f.this.pVY);
                            }
                        }
                        if (!a2) {
                            for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.pVW = null;
                        } else {
                            f.this.pVW = new c.a(f.this.pVZ.a()).a();
                            f.this.pVW.c(-3);
                            f.this.pVU.a(f.this.pVW, f.this.eGc(), h.a(f.this.f));
                        }
                    }
                    f.this.pVU.b(f.this.pVW);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.g.c cVar) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = cVar;
        this.pVT.sendMessage(obtain);
    }

    private void p() {
        if (this.pVX != null && this.pVX.getStatus() != AsyncTask.Status.FINISHED) {
            this.pVX.cancel(true);
        }
        this.pVX = new c();
        com.ss.android.downloadlib.f.b.a(this.pVX, this.pVZ.a(), this.pVZ.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.a.a.d.e eGc() {
        if (this.pVV == null) {
            this.pVV = new com.ss.android.a.a.d.e();
        }
        return this.pVV;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void g() {
        com.ss.android.downloadlib.a.b.d.eFT().f(this.m);
    }
}
