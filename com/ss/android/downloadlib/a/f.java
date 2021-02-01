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
/* loaded from: classes6.dex */
public class f implements g, j.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12958a = f.class.getSimpleName();
    private WeakReference<Context> e;
    private boolean k;
    private long l;
    private com.ss.android.socialbase.downloader.g.c qbA;
    private c qbB;
    private SoftReference<s> qbG;
    private com.ss.android.a.a.d.e qbz;
    private boolean r;
    private final com.ss.android.downloadlib.f.j qbx = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private final com.ss.android.socialbase.downloader.d.b qbC = new h.a(this.qbx);
    private long m = -1;
    private com.ss.android.a.a.b.c qbD = null;
    private com.ss.android.a.a.b.b qbE = null;
    private com.ss.android.a.a.b.a qbF = null;
    private h qby = new h();
    private e qbu = new e(this.qbx);
    private final boolean s = com.ss.android.socialbase.downloader.k.a.eIx().a("ttdownloader_callback_twice");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface b {
        void a(long j);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: ix */
    public f iy(Context context) {
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
            com.ss.android.downloadlib.a.b.d.eEt().a(cVar);
            this.m = cVar.d();
            this.qbD = cVar;
            if (i.b(cVar)) {
                ((com.ss.android.b.a.a.c) cVar).a(3L);
                com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEt().je(this.m);
                if (je != null && je.k() != 3) {
                    je.e(3L);
                    com.ss.android.downloadlib.a.b.g.eEw().d(je);
                }
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.a aVar) {
        this.qbF = aVar;
        com.ss.android.downloadlib.a.b.d.eEt().a(this.m, eEB());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.qbE = bVar;
        this.r = eEA().k() == 0;
        com.ss.android.downloadlib.a.b.d.eEt().a(this.m, eEA());
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public g a(s sVar) {
        if (sVar == null) {
            this.qbG = null;
        } else {
            this.qbG = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.a.b.d.eEt().a(this.m, eEA());
        com.ss.android.downloadlib.a.b.d.eEt().a(this.m, eEB());
        this.qby.a(this.m);
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
            if (this.qbA != null) {
                com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).k(this.qbA.g());
            }
            if (this.qbB != null && this.qbB.getStatus() != AsyncTask.Status.FINISHED) {
                this.qbB.cancel(true);
            }
            this.qby.a(this.qbA);
            com.ss.android.downloadlib.f.h.i(f12958a, "onUnbind removeCallbacksAndMessages, downloadUrl:" + (this.qbA == null ? "" : this.qbA.j()), null);
            this.qbx.removeCallbacksAndMessages(null);
            this.qbz = null;
            this.qbA = null;
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(boolean z) {
        if (this.qbA != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d eFj = com.ss.android.socialbase.appdownloader.d.eFn().eFj();
                if (eFj != null) {
                    eFj.a(this.qbA);
                }
                com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGu()).a(this.qbA.g(), true);
                return;
            }
            Intent intent = new Intent(j.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.qbA.g());
            j.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.qbA != null;
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
            com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEt().jb(j);
            if (jb != null) {
                this.qbD = jb;
                this.m = j;
                this.qby.a(this.m);
            }
        } else {
            com.ss.android.downloadlib.f.i.b();
        }
        if (!this.qby.e(k(), i, this.r)) {
            boolean b2 = b(i);
            switch (i) {
                case 1:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f12958a, "handleDownload id:" + j + ",tryPerformItemClick:", null);
                        c(true);
                        return;
                    }
                    return;
                case 2:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f12958a, "handleDownload id:" + j + ",tryPerformButtonClick:", null);
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
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && com.ss.android.downloadlib.a.c.b(this.qbD) && com.ss.android.downloadlib.a.c.a(this.qbA);
    }

    private boolean b(int i) {
        if (i()) {
            int i2 = -1;
            String a2 = this.qbD.eDY().a();
            switch (i) {
                case 1:
                    i2 = 5;
                    break;
                case 2:
                    i2 = 4;
                    break;
            }
            com.ss.android.downloadlib.e.a.eFc().a(this.m, i);
            boolean c2 = com.ss.android.downloadlib.f.f.c(j.a(), a2);
            if (c2) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.qbD.d());
                this.qbx.sendMessageDelayed(obtain, com.ss.android.downloadlib.a.c.eEx().b());
                com.ss.android.downloadlib.a.c.eEx().a(i2, this.qbD, this.qbE);
            } else {
                com.ss.android.downloadlib.e.a.eFc().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void b(boolean z) {
        switch (this.qby.a(this.r)) {
            case 1:
                if (z) {
                    com.ss.android.downloadlib.e.a.eFc().a(this.m, 1);
                }
                j();
                return;
            default:
                d(z);
                return;
        }
    }

    private void j() {
        if (this.qbG != null && this.qbG.get() != null) {
            this.qbG.get().a(this.qbD, eEA(), eEB());
            this.qbG = null;
            return;
        }
        j.eEE().a(k(), this.qbD, eEB(), eEA());
    }

    private void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.eFc().a(this.m, 1);
        }
        e(z);
    }

    private void d(boolean z) {
        f(z);
    }

    public void e() {
        this.qbx.post(new Runnable() { // from class: com.ss.android.downloadlib.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                    dVar.b(f.this.eEC());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null && this.k) {
            switch (message.what) {
                case 3:
                    this.qbA = (com.ss.android.socialbase.downloader.g.c) message.obj;
                    this.qby.a(message, eEC(), this.f);
                    return;
                case 4:
                    if (j.eEM() == null || !j.eEM().a()) {
                        com.ss.android.downloadlib.e.a.eFc().a(this.m, false, 2);
                        b(false);
                        return;
                    }
                    return;
                case 5:
                    if (j.eEM() == null || !j.eEM().a()) {
                        com.ss.android.downloadlib.e.a.eFc().a(this.m, false, 1);
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
    private com.ss.android.a.a.b.b eEA() {
        return this.qbE == null ? new f.a().eEa() : this.qbE;
    }

    @NonNull
    private com.ss.android.a.a.b.a eEB() {
        return this.qbF == null ? new a.C1218a().eEe() : this.qbF;
    }

    private void e(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12958a, "performItemClickWithNewDownloader", null);
        if (this.qby.c(this.qbA)) {
            com.ss.android.downloadlib.f.h.i(f12958a, "performItemClickWithNewDownloader ButtonClick", null);
            f(z);
            return;
        }
        com.ss.android.downloadlib.f.h.i(f12958a, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12958a, "performButtonClickWithNewDownloader", null);
        if (this.qbA == null || (this.qbA.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).d(this.qbA.g()))) {
            if (z) {
                com.ss.android.downloadlib.e.a.eFc().a(this.m, 2);
            }
            if (com.ss.android.downloadlib.f.d.i(this.qbD) != 0) {
                n();
                return;
            }
            com.ss.android.downloadlib.f.h.i(f12958a, "performButtonClickWithNewDownloader not start", null);
            this.qby.a(new q() { // from class: com.ss.android.downloadlib.a.f.2
                @Override // com.ss.android.a.a.a.q
                public void a() {
                    com.ss.android.downloadlib.f.h.i(f.f12958a, "performButtonClickWithNewDownloader start download", null);
                    f.this.n();
                }

                @Override // com.ss.android.a.a.a.q
                public void a(String str) {
                    com.ss.android.downloadlib.f.h.i(f.f12958a, "performButtonClickWithNewDownloader onDenied", null);
                }
            });
            return;
        }
        com.ss.android.downloadlib.f.h.i(f12958a, "performButtonClickWithNewDownloader continue download, status:" + this.qbA.q(), null);
        this.qby.d(this.qbA);
        if (this.qbA != null && this.qbD != null) {
            this.qbA.c(this.qbD.m());
        }
        final int q = this.qbA.q();
        final int g = this.qbA.g();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEt().j(this.qbA);
        if (q == -4 || q == -2 || q == -1) {
            if (j != null) {
                j.h(System.currentTimeMillis());
                j.ja(this.qbA.eHa());
            }
            this.qbA.d(false);
            this.qbu.a(new d.a(this.m, this.qbD, eEA(), eEB()));
            this.qbu.a(g, this.qbA.eHa(), this.qbA.eij(), new a() { // from class: com.ss.android.downloadlib.a.f.3
                @Override // com.ss.android.downloadlib.a.f.a
                public void a() {
                    if (!f.this.qbu.a()) {
                        com.ss.android.socialbase.appdownloader.d.eFn().e(j.a(), g, q);
                    }
                }
            });
            return;
        }
        if (l.a(q)) {
            this.qbu.a(true);
        }
        com.ss.android.socialbase.appdownloader.d.eFn().e(j.a(), g, q);
        l.a(j, this.qbA, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.qbu.a(new d.a(this.m, this.qbD, eEA(), eEB()));
        this.qbu.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.a.f.4
            @Override // com.ss.android.downloadlib.a.f.a
            public void a() {
                if (!f.this.qbu.a()) {
                    f.this.o();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
            dVar.a(this.qbD, eEB());
        }
        int a2 = this.qby.a(j.a(), this.qbC);
        com.ss.android.b.a.b.a a3 = a(this.qbD, a2);
        com.ss.android.downloadlib.a.b.d.eEt().d(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.ja(0L);
        com.ss.android.downloadlib.f.h.i(f12958a, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.qbA == null) {
                this.qby.b();
            } else {
                this.qby.d(this.qbA);
            }
        } else {
            com.ss.android.socialbase.downloader.g.c a4 = new c.a(this.qbD.a()).a();
            a4.c(-1);
            a(a4);
            com.ss.android.downloadlib.e.a.eFc().a(this.m, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
            com.ss.android.downloadlib.f.i.b();
        }
        if (this.qby.b(c())) {
            com.ss.android.downloadlib.f.h.i(f12958a, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    private com.ss.android.b.a.b.a a(com.ss.android.a.a.b.c cVar, int i) {
        com.ss.android.b.a.b.a aVar = new com.ss.android.b.a.b.a(cVar, eEA(), eEB(), i);
        if (com.ss.android.socialbase.downloader.k.a.RV(i).a("download_event_opt", 1) > 1) {
            try {
                String v = this.qbD.v();
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
            if (this.qbA != null) {
                this.qbA.c(-4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
                    if (f.this.qbD != null && !TextUtils.isEmpty(f.this.qbD.n())) {
                        cVar = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).hz(str, f.this.qbD.n());
                    }
                    if (cVar == null) {
                        return com.ss.android.socialbase.appdownloader.d.eFn().bG(j.a(), str);
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
            if (!isCancelled() && f.this.qbD != null) {
                try {
                    com.ss.android.downloadlib.a.b.b A = com.ss.android.downloadlib.f.i.A(f.this.qbD.v(), f.this.qbD.r(), f.this.qbD.s());
                    com.ss.android.downloadlib.a.b.f.eEv().a(f.this.qbD.r(), A.b(), com.ss.android.downloadlib.a.b.d.eEt().j(cVar));
                    boolean a2 = A.a();
                    if (cVar != null && cVar.g() != 0 && (a2 || !com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(cVar))) {
                        com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).k(cVar.g());
                        if (f.this.qbA == null || f.this.qbA.q() != -4) {
                            f.this.qbA = cVar;
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(f.this.qbA.g(), f.this.qbC, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(f.this.qbA.g(), f.this.qbC);
                            }
                        } else {
                            f.this.qbA = null;
                        }
                        f.this.qby.a(f.this.qbA, f.this.eEC(), h.a(f.this.f));
                    } else {
                        if (cVar != null && com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(cVar)) {
                            com.ss.android.socialbase.downloader.notification.b.eIB().f(cVar.g());
                            f.this.qbA = null;
                        }
                        if (f.this.qbA != null) {
                            com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).k(f.this.qbA.g());
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iB(f.this.k()).a(f.this.qbA.g(), f.this.qbC, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iB(f.this.k()).a(f.this.qbA.g(), f.this.qbC);
                            }
                        }
                        if (!a2) {
                            for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.qbA = null;
                        } else {
                            f.this.qbA = new c.a(f.this.qbD.a()).a();
                            f.this.qbA.c(-3);
                            f.this.qby.a(f.this.qbA, f.this.eEC(), h.a(f.this.f));
                        }
                    }
                    f.this.qby.b(f.this.qbA);
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
        this.qbx.sendMessage(obtain);
    }

    private void p() {
        if (this.qbB != null && this.qbB.getStatus() != AsyncTask.Status.FINISHED) {
            this.qbB.cancel(true);
        }
        this.qbB = new c();
        com.ss.android.downloadlib.f.b.a(this.qbB, this.qbD.a(), this.qbD.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.a.a.d.e eEC() {
        if (this.qbz == null) {
            this.qbz = new com.ss.android.a.a.d.e();
        }
        return this.qbz;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void g() {
        com.ss.android.downloadlib.a.b.d.eEt().f(this.m);
    }
}
