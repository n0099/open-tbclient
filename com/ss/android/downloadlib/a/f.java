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
    private static final String f13255a = f.class.getSimpleName();
    private WeakReference<Context> e;
    private boolean k;
    private long l;
    private com.ss.android.a.a.d.e pUn;
    private com.ss.android.socialbase.downloader.g.c pUo;
    private c pUp;
    private SoftReference<s> pUu;
    private boolean r;
    private final com.ss.android.downloadlib.f.j pUl = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private final com.ss.android.socialbase.downloader.d.b pUq = new h.a(this.pUl);
    private long m = -1;
    private com.ss.android.a.a.b.c pUr = null;
    private com.ss.android.a.a.b.b pUs = null;
    private com.ss.android.a.a.b.a pUt = null;
    private h pUm = new h();
    private e pUi = new e(this.pUl);
    private final boolean s = com.ss.android.socialbase.downloader.k.a.eJs().a("ttdownloader_callback_twice");

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
            com.ss.android.downloadlib.a.b.d.eFp().a(cVar);
            this.m = cVar.d();
            this.pUr = cVar;
            if (i.b(cVar)) {
                ((com.ss.android.b.a.a.c) cVar).a(3L);
                com.ss.android.b.a.b.a iY = com.ss.android.downloadlib.a.b.d.eFp().iY(this.m);
                if (iY != null && iY.k() != 3) {
                    iY.e(3L);
                    com.ss.android.downloadlib.a.b.g.eFs().d(iY);
                }
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.a aVar) {
        this.pUt = aVar;
        com.ss.android.downloadlib.a.b.d.eFp().a(this.m, eFx());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.pUs = bVar;
        this.r = eFw().k() == 0;
        com.ss.android.downloadlib.a.b.d.eFp().a(this.m, eFw());
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public g a(s sVar) {
        if (sVar == null) {
            this.pUu = null;
        } else {
            this.pUu = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.a.b.d.eFp().a(this.m, eFw());
        com.ss.android.downloadlib.a.b.d.eFp().a(this.m, eFx());
        this.pUm.a(this.m);
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
            if (this.pUo != null) {
                com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).k(this.pUo.g());
            }
            if (this.pUp != null && this.pUp.getStatus() != AsyncTask.Status.FINISHED) {
                this.pUp.cancel(true);
            }
            this.pUm.a(this.pUo);
            com.ss.android.downloadlib.f.h.i(f13255a, "onUnbind removeCallbacksAndMessages, downloadUrl:" + (this.pUo == null ? "" : this.pUo.j()), null);
            this.pUl.removeCallbacksAndMessages(null);
            this.pUn = null;
            this.pUo = null;
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(boolean z) {
        if (this.pUo != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d eGe = com.ss.android.socialbase.appdownloader.d.eGi().eGe();
                if (eGe != null) {
                    eGe.a(this.pUo);
                }
                com.ss.android.socialbase.downloader.downloader.f.iA(com.ss.android.socialbase.downloader.downloader.b.eHp()).a(this.pUo.g(), true);
                return;
            }
            Intent intent = new Intent(j.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.pUo.g());
            j.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.pUo != null;
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
            com.ss.android.a.a.b.c iV = com.ss.android.downloadlib.a.b.d.eFp().iV(j);
            if (iV != null) {
                this.pUr = iV;
                this.m = j;
                this.pUm.a(this.m);
            }
        } else {
            com.ss.android.downloadlib.f.i.b();
        }
        if (!this.pUm.e(k(), i, this.r)) {
            boolean b2 = b(i);
            switch (i) {
                case 1:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f13255a, "handleDownload id:" + j + ",tryPerformItemClick:", null);
                        c(true);
                        return;
                    }
                    return;
                case 2:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f13255a, "handleDownload id:" + j + ",tryPerformButtonClick:", null);
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
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && com.ss.android.downloadlib.a.c.b(this.pUr) && com.ss.android.downloadlib.a.c.a(this.pUo);
    }

    private boolean b(int i) {
        if (i()) {
            int i2 = -1;
            String a2 = this.pUr.eEU().a();
            switch (i) {
                case 1:
                    i2 = 5;
                    break;
                case 2:
                    i2 = 4;
                    break;
            }
            com.ss.android.downloadlib.e.a.eFX().a(this.m, i);
            boolean c2 = com.ss.android.downloadlib.f.f.c(j.a(), a2);
            if (c2) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.pUr.d());
                this.pUl.sendMessageDelayed(obtain, com.ss.android.downloadlib.a.c.eFt().b());
                com.ss.android.downloadlib.a.c.eFt().a(i2, this.pUr, this.pUs);
            } else {
                com.ss.android.downloadlib.e.a.eFX().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void b(boolean z) {
        switch (this.pUm.a(this.r)) {
            case 1:
                if (z) {
                    com.ss.android.downloadlib.e.a.eFX().a(this.m, 1);
                }
                j();
                return;
            default:
                d(z);
                return;
        }
    }

    private void j() {
        if (this.pUu != null && this.pUu.get() != null) {
            this.pUu.get().a(this.pUr, eFw(), eFx());
            this.pUu = null;
            return;
        }
        j.eFA().a(k(), this.pUr, eFx(), eFw());
    }

    private void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.eFX().a(this.m, 1);
        }
        e(z);
    }

    private void d(boolean z) {
        f(z);
    }

    public void e() {
        this.pUl.post(new Runnable() { // from class: com.ss.android.downloadlib.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                    dVar.b(f.this.eFy());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null && this.k) {
            switch (message.what) {
                case 3:
                    this.pUo = (com.ss.android.socialbase.downloader.g.c) message.obj;
                    this.pUm.a(message, eFy(), this.f);
                    return;
                case 4:
                    if (j.eFI() == null || !j.eFI().a()) {
                        com.ss.android.downloadlib.e.a.eFX().a(this.m, false, 2);
                        b(false);
                        return;
                    }
                    return;
                case 5:
                    if (j.eFI() == null || !j.eFI().a()) {
                        com.ss.android.downloadlib.e.a.eFX().a(this.m, false, 1);
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
    private com.ss.android.a.a.b.b eFw() {
        return this.pUs == null ? new f.a().eEW() : this.pUs;
    }

    @NonNull
    private com.ss.android.a.a.b.a eFx() {
        return this.pUt == null ? new a.C1190a().eFa() : this.pUt;
    }

    private void e(boolean z) {
        com.ss.android.downloadlib.f.h.i(f13255a, "performItemClickWithNewDownloader", null);
        if (this.pUm.c(this.pUo)) {
            com.ss.android.downloadlib.f.h.i(f13255a, "performItemClickWithNewDownloader ButtonClick", null);
            f(z);
            return;
        }
        com.ss.android.downloadlib.f.h.i(f13255a, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(boolean z) {
        com.ss.android.downloadlib.f.h.i(f13255a, "performButtonClickWithNewDownloader", null);
        if (this.pUo == null || (this.pUo.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).d(this.pUo.g()))) {
            if (z) {
                com.ss.android.downloadlib.e.a.eFX().a(this.m, 2);
            }
            if (com.ss.android.downloadlib.f.d.i(this.pUr) != 0) {
                n();
                return;
            }
            com.ss.android.downloadlib.f.h.i(f13255a, "performButtonClickWithNewDownloader not start", null);
            this.pUm.a(new q() { // from class: com.ss.android.downloadlib.a.f.2
                @Override // com.ss.android.a.a.a.q
                public void a() {
                    com.ss.android.downloadlib.f.h.i(f.f13255a, "performButtonClickWithNewDownloader start download", null);
                    f.this.n();
                }

                @Override // com.ss.android.a.a.a.q
                public void a(String str) {
                    com.ss.android.downloadlib.f.h.i(f.f13255a, "performButtonClickWithNewDownloader onDenied", null);
                }
            });
            return;
        }
        com.ss.android.downloadlib.f.h.i(f13255a, "performButtonClickWithNewDownloader continue download, status:" + this.pUo.q(), null);
        this.pUm.d(this.pUo);
        if (this.pUo != null && this.pUr != null) {
            this.pUo.c(this.pUr.m());
        }
        final int q = this.pUo.q();
        final int g = this.pUo.g();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eFp().j(this.pUo);
        if (q == -4 || q == -2 || q == -1) {
            if (j != null) {
                j.h(System.currentTimeMillis());
                j.iU(this.pUo.eHV());
            }
            this.pUo.d(false);
            this.pUi.a(new d.a(this.m, this.pUr, eFw(), eFx()));
            this.pUi.a(g, this.pUo.eHV(), this.pUo.ejK(), new a() { // from class: com.ss.android.downloadlib.a.f.3
                @Override // com.ss.android.downloadlib.a.f.a
                public void a() {
                    if (!f.this.pUi.a()) {
                        com.ss.android.socialbase.appdownloader.d.eGi().e(j.a(), g, q);
                    }
                }
            });
            return;
        }
        if (l.a(q)) {
            this.pUi.a(true);
        }
        com.ss.android.socialbase.appdownloader.d.eGi().e(j.a(), g, q);
        l.a(j, this.pUo, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.pUi.a(new d.a(this.m, this.pUr, eFw(), eFx()));
        this.pUi.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.a.f.4
            @Override // com.ss.android.downloadlib.a.f.a
            public void a() {
                if (!f.this.pUi.a()) {
                    f.this.o();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
            dVar.a(this.pUr, eFx());
        }
        int a2 = this.pUm.a(j.a(), this.pUq);
        com.ss.android.b.a.b.a a3 = a(this.pUr, a2);
        com.ss.android.downloadlib.a.b.d.eFp().d(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.iU(0L);
        com.ss.android.downloadlib.f.h.i(f13255a, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.pUo == null) {
                this.pUm.b();
            } else {
                this.pUm.d(this.pUo);
            }
        } else {
            com.ss.android.socialbase.downloader.g.c a4 = new c.a(this.pUr.a()).a();
            a4.c(-1);
            a(a4);
            com.ss.android.downloadlib.e.a.eFX().a(this.m, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
            com.ss.android.downloadlib.f.i.b();
        }
        if (this.pUm.b(c())) {
            com.ss.android.downloadlib.f.h.i(f13255a, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    private com.ss.android.b.a.b.a a(com.ss.android.a.a.b.c cVar, int i) {
        com.ss.android.b.a.b.a aVar = new com.ss.android.b.a.b.a(cVar, eFw(), eFx(), i);
        if (com.ss.android.socialbase.downloader.k.a.SR(i).a("download_event_opt", 1) > 1) {
            try {
                String v = this.pUr.v();
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
            if (this.pUo != null) {
                this.pUo.c(-4);
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
                    if (f.this.pUr != null && !TextUtils.isEmpty(f.this.pUr.n())) {
                        cVar = com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).hs(str, f.this.pUr.n());
                    }
                    if (cVar == null) {
                        return com.ss.android.socialbase.appdownloader.d.eGi().bH(j.a(), str);
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
            if (!isCancelled() && f.this.pUr != null) {
                try {
                    com.ss.android.downloadlib.a.b.b A = com.ss.android.downloadlib.f.i.A(f.this.pUr.v(), f.this.pUr.r(), f.this.pUr.s());
                    com.ss.android.downloadlib.a.b.f.eFr().a(f.this.pUr.r(), A.b(), com.ss.android.downloadlib.a.b.d.eFp().j(cVar));
                    boolean a2 = A.a();
                    if (cVar != null && cVar.g() != 0 && (a2 || !com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(cVar))) {
                        com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).k(cVar.g());
                        if (f.this.pUo == null || f.this.pUo.q() != -4) {
                            f.this.pUo = cVar;
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(f.this.pUo.g(), f.this.pUq, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(f.this.pUo.g(), f.this.pUq);
                            }
                        } else {
                            f.this.pUo = null;
                        }
                        f.this.pUm.a(f.this.pUo, f.this.eFy(), h.a(f.this.f));
                    } else {
                        if (cVar != null && com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).a(cVar)) {
                            com.ss.android.socialbase.downloader.notification.b.eJw().f(cVar.g());
                            f.this.pUo = null;
                        }
                        if (f.this.pUo != null) {
                            com.ss.android.socialbase.downloader.downloader.f.iA(j.a()).k(f.this.pUo.g());
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iA(f.this.k()).a(f.this.pUo.g(), f.this.pUq, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iA(f.this.k()).a(f.this.pUo.g(), f.this.pUq);
                            }
                        }
                        if (!a2) {
                            for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.pUo = null;
                        } else {
                            f.this.pUo = new c.a(f.this.pUr.a()).a();
                            f.this.pUo.c(-3);
                            f.this.pUm.a(f.this.pUo, f.this.eFy(), h.a(f.this.f));
                        }
                    }
                    f.this.pUm.b(f.this.pUo);
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
        this.pUl.sendMessage(obtain);
    }

    private void p() {
        if (this.pUp != null && this.pUp.getStatus() != AsyncTask.Status.FINISHED) {
            this.pUp.cancel(true);
        }
        this.pUp = new c();
        com.ss.android.downloadlib.f.b.a(this.pUp, this.pUr.a(), this.pUr.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.a.a.d.e eFy() {
        if (this.pUn == null) {
            this.pUn = new com.ss.android.a.a.d.e();
        }
        return this.pUn;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void g() {
        com.ss.android.downloadlib.a.b.d.eFp().f(this.m);
    }
}
