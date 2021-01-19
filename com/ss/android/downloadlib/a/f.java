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
    private static final String f12956a = f.class.getSimpleName();
    private WeakReference<Context> e;
    private boolean k;
    private long l;
    private SoftReference<s> pRC;
    private com.ss.android.a.a.d.e pRv;
    private com.ss.android.socialbase.downloader.g.c pRw;
    private c pRx;
    private boolean r;
    private final com.ss.android.downloadlib.f.j pRt = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private final com.ss.android.socialbase.downloader.d.b pRy = new h.a(this.pRt);
    private long m = -1;
    private com.ss.android.a.a.b.c pRz = null;
    private com.ss.android.a.a.b.b pRA = null;
    private com.ss.android.a.a.b.a pRB = null;
    private h pRu = new h();
    private e pRq = new e(this.pRt);
    private final boolean s = com.ss.android.socialbase.downloader.k.a.eGg().a("ttdownloader_callback_twice");

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
    /* renamed from: iu */
    public f iv(Context context) {
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
            com.ss.android.downloadlib.a.b.d.eCc().a(cVar);
            this.m = cVar.d();
            this.pRz = cVar;
            if (i.b(cVar)) {
                ((com.ss.android.b.a.a.c) cVar).a(3L);
                com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eCc().jb(this.m);
                if (jb != null && jb.k() != 3) {
                    jb.e(3L);
                    com.ss.android.downloadlib.a.b.g.eCf().d(jb);
                }
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.a aVar) {
        this.pRB = aVar;
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCk());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.pRA = bVar;
        this.r = eCj().k() == 0;
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCj());
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public g a(s sVar) {
        if (sVar == null) {
            this.pRC = null;
        } else {
            this.pRC = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCj());
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCk());
        this.pRu.a(this.m);
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
            if (this.pRw != null) {
                com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).k(this.pRw.g());
            }
            if (this.pRx != null && this.pRx.getStatus() != AsyncTask.Status.FINISHED) {
                this.pRx.cancel(true);
            }
            this.pRu.a(this.pRw);
            com.ss.android.downloadlib.f.h.i(f12956a, "onUnbind removeCallbacksAndMessages, downloadUrl:" + (this.pRw == null ? "" : this.pRw.j()), null);
            this.pRt.removeCallbacksAndMessages(null);
            this.pRv = null;
            this.pRw = null;
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(boolean z) {
        if (this.pRw != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d eCS = com.ss.android.socialbase.appdownloader.d.eCW().eCS();
                if (eCS != null) {
                    eCS.a(this.pRw);
                }
                com.ss.android.socialbase.downloader.downloader.f.iy(com.ss.android.socialbase.downloader.downloader.b.eEd()).a(this.pRw.g(), true);
                return;
            }
            Intent intent = new Intent(j.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.pRw.g());
            j.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.pRw != null;
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
            com.ss.android.a.a.b.c iY = com.ss.android.downloadlib.a.b.d.eCc().iY(j);
            if (iY != null) {
                this.pRz = iY;
                this.m = j;
                this.pRu.a(this.m);
            }
        } else {
            com.ss.android.downloadlib.f.i.b();
        }
        if (!this.pRu.e(k(), i, this.r)) {
            boolean b2 = b(i);
            switch (i) {
                case 1:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f12956a, "handleDownload id:" + j + ",tryPerformItemClick:", null);
                        c(true);
                        return;
                    }
                    return;
                case 2:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f12956a, "handleDownload id:" + j + ",tryPerformButtonClick:", null);
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
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && com.ss.android.downloadlib.a.c.b(this.pRz) && com.ss.android.downloadlib.a.c.a(this.pRw);
    }

    private boolean b(int i) {
        if (i()) {
            int i2 = -1;
            String a2 = this.pRz.eBH().a();
            switch (i) {
                case 1:
                    i2 = 5;
                    break;
                case 2:
                    i2 = 4;
                    break;
            }
            com.ss.android.downloadlib.e.a.eCL().a(this.m, i);
            boolean c2 = com.ss.android.downloadlib.f.f.c(j.a(), a2);
            if (c2) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.pRz.d());
                this.pRt.sendMessageDelayed(obtain, com.ss.android.downloadlib.a.c.eCg().b());
                com.ss.android.downloadlib.a.c.eCg().a(i2, this.pRz, this.pRA);
            } else {
                com.ss.android.downloadlib.e.a.eCL().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void b(boolean z) {
        switch (this.pRu.a(this.r)) {
            case 1:
                if (z) {
                    com.ss.android.downloadlib.e.a.eCL().a(this.m, 1);
                }
                j();
                return;
            default:
                d(z);
                return;
        }
    }

    private void j() {
        if (this.pRC != null && this.pRC.get() != null) {
            this.pRC.get().a(this.pRz, eCj(), eCk());
            this.pRC = null;
            return;
        }
        j.eCn().a(k(), this.pRz, eCk(), eCj());
    }

    private void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.eCL().a(this.m, 1);
        }
        e(z);
    }

    private void d(boolean z) {
        f(z);
    }

    public void e() {
        this.pRt.post(new Runnable() { // from class: com.ss.android.downloadlib.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                    dVar.b(f.this.eCl());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null && this.k) {
            switch (message.what) {
                case 3:
                    this.pRw = (com.ss.android.socialbase.downloader.g.c) message.obj;
                    this.pRu.a(message, eCl(), this.f);
                    return;
                case 4:
                    if (j.eCv() == null || !j.eCv().a()) {
                        com.ss.android.downloadlib.e.a.eCL().a(this.m, false, 2);
                        b(false);
                        return;
                    }
                    return;
                case 5:
                    if (j.eCv() == null || !j.eCv().a()) {
                        com.ss.android.downloadlib.e.a.eCL().a(this.m, false, 1);
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
    private com.ss.android.a.a.b.b eCj() {
        return this.pRA == null ? new f.a().eBJ() : this.pRA;
    }

    @NonNull
    private com.ss.android.a.a.b.a eCk() {
        return this.pRB == null ? new a.C1214a().eBN() : this.pRB;
    }

    private void e(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12956a, "performItemClickWithNewDownloader", null);
        if (this.pRu.c(this.pRw)) {
            com.ss.android.downloadlib.f.h.i(f12956a, "performItemClickWithNewDownloader ButtonClick", null);
            f(z);
            return;
        }
        com.ss.android.downloadlib.f.h.i(f12956a, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12956a, "performButtonClickWithNewDownloader", null);
        if (this.pRw == null || (this.pRw.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).d(this.pRw.g()))) {
            if (z) {
                com.ss.android.downloadlib.e.a.eCL().a(this.m, 2);
            }
            if (com.ss.android.downloadlib.f.d.i(this.pRz) != 0) {
                n();
                return;
            }
            com.ss.android.downloadlib.f.h.i(f12956a, "performButtonClickWithNewDownloader not start", null);
            this.pRu.a(new q() { // from class: com.ss.android.downloadlib.a.f.2
                @Override // com.ss.android.a.a.a.q
                public void a() {
                    com.ss.android.downloadlib.f.h.i(f.f12956a, "performButtonClickWithNewDownloader start download", null);
                    f.this.n();
                }

                @Override // com.ss.android.a.a.a.q
                public void a(String str) {
                    com.ss.android.downloadlib.f.h.i(f.f12956a, "performButtonClickWithNewDownloader onDenied", null);
                }
            });
            return;
        }
        com.ss.android.downloadlib.f.h.i(f12956a, "performButtonClickWithNewDownloader continue download, status:" + this.pRw.q(), null);
        this.pRu.d(this.pRw);
        if (this.pRw != null && this.pRz != null) {
            this.pRw.c(this.pRz.m());
        }
        final int q = this.pRw.q();
        final int g = this.pRw.g();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eCc().j(this.pRw);
        if (q == -4 || q == -2 || q == -1) {
            if (j != null) {
                j.h(System.currentTimeMillis());
                j.iX(this.pRw.eEJ());
            }
            this.pRw.d(false);
            this.pRq.a(new d.a(this.m, this.pRz, eCj(), eCk()));
            this.pRq.a(g, this.pRw.eEJ(), this.pRw.efR(), new a() { // from class: com.ss.android.downloadlib.a.f.3
                @Override // com.ss.android.downloadlib.a.f.a
                public void a() {
                    if (!f.this.pRq.a()) {
                        com.ss.android.socialbase.appdownloader.d.eCW().e(j.a(), g, q);
                    }
                }
            });
            return;
        }
        if (l.a(q)) {
            this.pRq.a(true);
        }
        com.ss.android.socialbase.appdownloader.d.eCW().e(j.a(), g, q);
        l.a(j, this.pRw, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.pRq.a(new d.a(this.m, this.pRz, eCj(), eCk()));
        this.pRq.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.a.f.4
            @Override // com.ss.android.downloadlib.a.f.a
            public void a() {
                if (!f.this.pRq.a()) {
                    f.this.o();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
            dVar.a(this.pRz, eCk());
        }
        int a2 = this.pRu.a(j.a(), this.pRy);
        com.ss.android.b.a.b.a a3 = a(this.pRz, a2);
        com.ss.android.downloadlib.a.b.d.eCc().d(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.iX(0L);
        com.ss.android.downloadlib.f.h.i(f12956a, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.pRw == null) {
                this.pRu.b();
            } else {
                this.pRu.d(this.pRw);
            }
        } else {
            com.ss.android.socialbase.downloader.g.c a4 = new c.a(this.pRz.a()).a();
            a4.c(-1);
            a(a4);
            com.ss.android.downloadlib.e.a.eCL().a(this.m, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
            com.ss.android.downloadlib.f.i.b();
        }
        if (this.pRu.b(c())) {
            com.ss.android.downloadlib.f.h.i(f12956a, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    private com.ss.android.b.a.b.a a(com.ss.android.a.a.b.c cVar, int i) {
        com.ss.android.b.a.b.a aVar = new com.ss.android.b.a.b.a(cVar, eCj(), eCk(), i);
        if (com.ss.android.socialbase.downloader.k.a.RA(i).a("download_event_opt", 1) > 1) {
            try {
                String v = this.pRz.v();
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
            if (this.pRw != null) {
                this.pRw.c(-4);
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
                    if (f.this.pRz != null && !TextUtils.isEmpty(f.this.pRz.n())) {
                        cVar = com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).hs(str, f.this.pRz.n());
                    }
                    if (cVar == null) {
                        return com.ss.android.socialbase.appdownloader.d.eCW().bH(j.a(), str);
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
            if (!isCancelled() && f.this.pRz != null) {
                try {
                    com.ss.android.downloadlib.a.b.b A = com.ss.android.downloadlib.f.i.A(f.this.pRz.v(), f.this.pRz.r(), f.this.pRz.s());
                    com.ss.android.downloadlib.a.b.f.eCe().a(f.this.pRz.r(), A.b(), com.ss.android.downloadlib.a.b.d.eCc().j(cVar));
                    boolean a2 = A.a();
                    if (cVar != null && cVar.g() != 0 && (a2 || !com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(cVar))) {
                        com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).k(cVar.g());
                        if (f.this.pRw == null || f.this.pRw.q() != -4) {
                            f.this.pRw = cVar;
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(f.this.pRw.g(), f.this.pRy, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(f.this.pRw.g(), f.this.pRy);
                            }
                        } else {
                            f.this.pRw = null;
                        }
                        f.this.pRu.a(f.this.pRw, f.this.eCl(), h.a(f.this.f));
                    } else {
                        if (cVar != null && com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(cVar)) {
                            com.ss.android.socialbase.downloader.notification.b.eGk().f(cVar.g());
                            f.this.pRw = null;
                        }
                        if (f.this.pRw != null) {
                            com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).k(f.this.pRw.g());
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iy(f.this.k()).a(f.this.pRw.g(), f.this.pRy, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iy(f.this.k()).a(f.this.pRw.g(), f.this.pRy);
                            }
                        }
                        if (!a2) {
                            for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.pRw = null;
                        } else {
                            f.this.pRw = new c.a(f.this.pRz.a()).a();
                            f.this.pRw.c(-3);
                            f.this.pRu.a(f.this.pRw, f.this.eCl(), h.a(f.this.f));
                        }
                    }
                    f.this.pRu.b(f.this.pRw);
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
        this.pRt.sendMessage(obtain);
    }

    private void p() {
        if (this.pRx != null && this.pRx.getStatus() != AsyncTask.Status.FINISHED) {
            this.pRx.cancel(true);
        }
        this.pRx = new c();
        com.ss.android.downloadlib.f.b.a(this.pRx, this.pRz.a(), this.pRz.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.a.a.d.e eCl() {
        if (this.pRv == null) {
            this.pRv = new com.ss.android.a.a.d.e();
        }
        return this.pRv;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void g() {
        com.ss.android.downloadlib.a.b.d.eCc().f(this.m);
    }
}
