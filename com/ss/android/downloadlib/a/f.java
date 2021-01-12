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
    private SoftReference<s> pRB;
    private com.ss.android.a.a.d.e pRu;
    private com.ss.android.socialbase.downloader.g.c pRv;
    private c pRw;
    private boolean r;
    private final com.ss.android.downloadlib.f.j pRs = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private final com.ss.android.socialbase.downloader.d.b pRx = new h.a(this.pRs);
    private long m = -1;
    private com.ss.android.a.a.b.c pRy = null;
    private com.ss.android.a.a.b.b pRz = null;
    private com.ss.android.a.a.b.a pRA = null;
    private h pRt = new h();
    private e pRp = new e(this.pRs);
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
            this.pRy = cVar;
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
        this.pRA = aVar;
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCk());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.pRz = bVar;
        this.r = eCj().k() == 0;
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCj());
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public g a(s sVar) {
        if (sVar == null) {
            this.pRB = null;
        } else {
            this.pRB = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCj());
        com.ss.android.downloadlib.a.b.d.eCc().a(this.m, eCk());
        this.pRt.a(this.m);
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
            if (this.pRv != null) {
                com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).k(this.pRv.g());
            }
            if (this.pRw != null && this.pRw.getStatus() != AsyncTask.Status.FINISHED) {
                this.pRw.cancel(true);
            }
            this.pRt.a(this.pRv);
            com.ss.android.downloadlib.f.h.i(f12956a, "onUnbind removeCallbacksAndMessages, downloadUrl:" + (this.pRv == null ? "" : this.pRv.j()), null);
            this.pRs.removeCallbacksAndMessages(null);
            this.pRu = null;
            this.pRv = null;
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(boolean z) {
        if (this.pRv != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d eCS = com.ss.android.socialbase.appdownloader.d.eCW().eCS();
                if (eCS != null) {
                    eCS.a(this.pRv);
                }
                com.ss.android.socialbase.downloader.downloader.f.iy(com.ss.android.socialbase.downloader.downloader.b.eEd()).a(this.pRv.g(), true);
                return;
            }
            Intent intent = new Intent(j.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.pRv.g());
            j.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.pRv != null;
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
                this.pRy = iY;
                this.m = j;
                this.pRt.a(this.m);
            }
        } else {
            com.ss.android.downloadlib.f.i.b();
        }
        if (!this.pRt.e(k(), i, this.r)) {
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
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && com.ss.android.downloadlib.a.c.b(this.pRy) && com.ss.android.downloadlib.a.c.a(this.pRv);
    }

    private boolean b(int i) {
        if (i()) {
            int i2 = -1;
            String a2 = this.pRy.eBH().a();
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
                obtain.obj = Long.valueOf(this.pRy.d());
                this.pRs.sendMessageDelayed(obtain, com.ss.android.downloadlib.a.c.eCg().b());
                com.ss.android.downloadlib.a.c.eCg().a(i2, this.pRy, this.pRz);
            } else {
                com.ss.android.downloadlib.e.a.eCL().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void b(boolean z) {
        switch (this.pRt.a(this.r)) {
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
        if (this.pRB != null && this.pRB.get() != null) {
            this.pRB.get().a(this.pRy, eCj(), eCk());
            this.pRB = null;
            return;
        }
        j.eCn().a(k(), this.pRy, eCk(), eCj());
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
        this.pRs.post(new Runnable() { // from class: com.ss.android.downloadlib.a.f.1
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
                    this.pRv = (com.ss.android.socialbase.downloader.g.c) message.obj;
                    this.pRt.a(message, eCl(), this.f);
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
        return this.pRz == null ? new f.a().eBJ() : this.pRz;
    }

    @NonNull
    private com.ss.android.a.a.b.a eCk() {
        return this.pRA == null ? new a.C1214a().eBN() : this.pRA;
    }

    private void e(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12956a, "performItemClickWithNewDownloader", null);
        if (this.pRt.c(this.pRv)) {
            com.ss.android.downloadlib.f.h.i(f12956a, "performItemClickWithNewDownloader ButtonClick", null);
            f(z);
            return;
        }
        com.ss.android.downloadlib.f.h.i(f12956a, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12956a, "performButtonClickWithNewDownloader", null);
        if (this.pRv == null || (this.pRv.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).d(this.pRv.g()))) {
            if (z) {
                com.ss.android.downloadlib.e.a.eCL().a(this.m, 2);
            }
            if (com.ss.android.downloadlib.f.d.i(this.pRy) != 0) {
                n();
                return;
            }
            com.ss.android.downloadlib.f.h.i(f12956a, "performButtonClickWithNewDownloader not start", null);
            this.pRt.a(new q() { // from class: com.ss.android.downloadlib.a.f.2
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
        com.ss.android.downloadlib.f.h.i(f12956a, "performButtonClickWithNewDownloader continue download, status:" + this.pRv.q(), null);
        this.pRt.d(this.pRv);
        if (this.pRv != null && this.pRy != null) {
            this.pRv.c(this.pRy.m());
        }
        final int q = this.pRv.q();
        final int g = this.pRv.g();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eCc().j(this.pRv);
        if (q == -4 || q == -2 || q == -1) {
            if (j != null) {
                j.h(System.currentTimeMillis());
                j.iX(this.pRv.eEJ());
            }
            this.pRv.d(false);
            this.pRp.a(new d.a(this.m, this.pRy, eCj(), eCk()));
            this.pRp.a(g, this.pRv.eEJ(), this.pRv.efR(), new a() { // from class: com.ss.android.downloadlib.a.f.3
                @Override // com.ss.android.downloadlib.a.f.a
                public void a() {
                    if (!f.this.pRp.a()) {
                        com.ss.android.socialbase.appdownloader.d.eCW().e(j.a(), g, q);
                    }
                }
            });
            return;
        }
        if (l.a(q)) {
            this.pRp.a(true);
        }
        com.ss.android.socialbase.appdownloader.d.eCW().e(j.a(), g, q);
        l.a(j, this.pRv, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.pRp.a(new d.a(this.m, this.pRy, eCj(), eCk()));
        this.pRp.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.a.f.4
            @Override // com.ss.android.downloadlib.a.f.a
            public void a() {
                if (!f.this.pRp.a()) {
                    f.this.o();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
            dVar.a(this.pRy, eCk());
        }
        int a2 = this.pRt.a(j.a(), this.pRx);
        com.ss.android.b.a.b.a a3 = a(this.pRy, a2);
        com.ss.android.downloadlib.a.b.d.eCc().d(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.iX(0L);
        com.ss.android.downloadlib.f.h.i(f12956a, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.pRv == null) {
                this.pRt.b();
            } else {
                this.pRt.d(this.pRv);
            }
        } else {
            com.ss.android.socialbase.downloader.g.c a4 = new c.a(this.pRy.a()).a();
            a4.c(-1);
            a(a4);
            com.ss.android.downloadlib.e.a.eCL().a(this.m, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
            com.ss.android.downloadlib.f.i.b();
        }
        if (this.pRt.b(c())) {
            com.ss.android.downloadlib.f.h.i(f12956a, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    private com.ss.android.b.a.b.a a(com.ss.android.a.a.b.c cVar, int i) {
        com.ss.android.b.a.b.a aVar = new com.ss.android.b.a.b.a(cVar, eCj(), eCk(), i);
        if (com.ss.android.socialbase.downloader.k.a.RA(i).a("download_event_opt", 1) > 1) {
            try {
                String v = this.pRy.v();
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
            if (this.pRv != null) {
                this.pRv.c(-4);
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
                    if (f.this.pRy != null && !TextUtils.isEmpty(f.this.pRy.n())) {
                        cVar = com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).hs(str, f.this.pRy.n());
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
            if (!isCancelled() && f.this.pRy != null) {
                try {
                    com.ss.android.downloadlib.a.b.b A = com.ss.android.downloadlib.f.i.A(f.this.pRy.v(), f.this.pRy.r(), f.this.pRy.s());
                    com.ss.android.downloadlib.a.b.f.eCe().a(f.this.pRy.r(), A.b(), com.ss.android.downloadlib.a.b.d.eCc().j(cVar));
                    boolean a2 = A.a();
                    if (cVar != null && cVar.g() != 0 && (a2 || !com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(cVar))) {
                        com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).k(cVar.g());
                        if (f.this.pRv == null || f.this.pRv.q() != -4) {
                            f.this.pRv = cVar;
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(f.this.pRv.g(), f.this.pRx, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(f.this.pRv.g(), f.this.pRx);
                            }
                        } else {
                            f.this.pRv = null;
                        }
                        f.this.pRt.a(f.this.pRv, f.this.eCl(), h.a(f.this.f));
                    } else {
                        if (cVar != null && com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).a(cVar)) {
                            com.ss.android.socialbase.downloader.notification.b.eGk().f(cVar.g());
                            f.this.pRv = null;
                        }
                        if (f.this.pRv != null) {
                            com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).k(f.this.pRv.g());
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iy(f.this.k()).a(f.this.pRv.g(), f.this.pRx, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iy(f.this.k()).a(f.this.pRv.g(), f.this.pRx);
                            }
                        }
                        if (!a2) {
                            for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.pRv = null;
                        } else {
                            f.this.pRv = new c.a(f.this.pRy.a()).a();
                            f.this.pRv.c(-3);
                            f.this.pRt.a(f.this.pRv, f.this.eCl(), h.a(f.this.f));
                        }
                    }
                    f.this.pRt.b(f.this.pRv);
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
        this.pRs.sendMessage(obtain);
    }

    private void p() {
        if (this.pRw != null && this.pRw.getStatus() != AsyncTask.Status.FINISHED) {
            this.pRw.cancel(true);
        }
        this.pRw = new c();
        com.ss.android.downloadlib.f.b.a(this.pRw, this.pRy.a(), this.pRy.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.a.a.d.e eCl() {
        if (this.pRu == null) {
            this.pRu = new com.ss.android.a.a.d.e();
        }
        return this.pRu;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void g() {
        com.ss.android.downloadlib.a.b.d.eCc().f(this.m);
    }
}
