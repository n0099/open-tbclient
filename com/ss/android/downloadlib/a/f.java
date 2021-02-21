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
    private com.ss.android.a.a.d.e qbZ;
    private com.ss.android.socialbase.downloader.g.c qca;
    private c qcb;
    private SoftReference<s> qcg;
    private boolean r;
    private final com.ss.android.downloadlib.f.j qbX = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private final com.ss.android.socialbase.downloader.d.b qcc = new h.a(this.qbX);
    private long m = -1;
    private com.ss.android.a.a.b.c qcd = null;
    private com.ss.android.a.a.b.b qce = null;
    private com.ss.android.a.a.b.a qcf = null;
    private h qbY = new h();
    private e qbU = new e(this.qbX);
    private final boolean s = com.ss.android.socialbase.downloader.k.a.eIF().a("ttdownloader_callback_twice");

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
            com.ss.android.downloadlib.a.b.d.eEB().a(cVar);
            this.m = cVar.d();
            this.qcd = cVar;
            if (i.b(cVar)) {
                ((com.ss.android.b.a.a.c) cVar).a(3L);
                com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEB().je(this.m);
                if (je != null && je.k() != 3) {
                    je.e(3L);
                    com.ss.android.downloadlib.a.b.g.eEE().d(je);
                }
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.a aVar) {
        this.qcf = aVar;
        com.ss.android.downloadlib.a.b.d.eEB().a(this.m, eEJ());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.qce = bVar;
        this.r = eEI().k() == 0;
        com.ss.android.downloadlib.a.b.d.eEB().a(this.m, eEI());
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public g a(s sVar) {
        if (sVar == null) {
            this.qcg = null;
        } else {
            this.qcg = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.a.b.d.eEB().a(this.m, eEI());
        com.ss.android.downloadlib.a.b.d.eEB().a(this.m, eEJ());
        this.qbY.a(this.m);
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
            if (this.qca != null) {
                com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).k(this.qca.g());
            }
            if (this.qcb != null && this.qcb.getStatus() != AsyncTask.Status.FINISHED) {
                this.qcb.cancel(true);
            }
            this.qbY.a(this.qca);
            com.ss.android.downloadlib.f.h.i(f12958a, "onUnbind removeCallbacksAndMessages, downloadUrl:" + (this.qca == null ? "" : this.qca.j()), null);
            this.qbX.removeCallbacksAndMessages(null);
            this.qbZ = null;
            this.qca = null;
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(boolean z) {
        if (this.qca != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d eFr = com.ss.android.socialbase.appdownloader.d.eFv().eFr();
                if (eFr != null) {
                    eFr.a(this.qca);
                }
                com.ss.android.socialbase.downloader.downloader.f.iB(com.ss.android.socialbase.downloader.downloader.b.eGC()).a(this.qca.g(), true);
                return;
            }
            Intent intent = new Intent(j.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.qca.g());
            j.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.qca != null;
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
            com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEB().jb(j);
            if (jb != null) {
                this.qcd = jb;
                this.m = j;
                this.qbY.a(this.m);
            }
        } else {
            com.ss.android.downloadlib.f.i.b();
        }
        if (!this.qbY.e(k(), i, this.r)) {
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
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && com.ss.android.downloadlib.a.c.b(this.qcd) && com.ss.android.downloadlib.a.c.a(this.qca);
    }

    private boolean b(int i) {
        if (i()) {
            int i2 = -1;
            String a2 = this.qcd.eEg().a();
            switch (i) {
                case 1:
                    i2 = 5;
                    break;
                case 2:
                    i2 = 4;
                    break;
            }
            com.ss.android.downloadlib.e.a.eFk().a(this.m, i);
            boolean c2 = com.ss.android.downloadlib.f.f.c(j.a(), a2);
            if (c2) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.qcd.d());
                this.qbX.sendMessageDelayed(obtain, com.ss.android.downloadlib.a.c.eEF().b());
                com.ss.android.downloadlib.a.c.eEF().a(i2, this.qcd, this.qce);
            } else {
                com.ss.android.downloadlib.e.a.eFk().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void b(boolean z) {
        switch (this.qbY.a(this.r)) {
            case 1:
                if (z) {
                    com.ss.android.downloadlib.e.a.eFk().a(this.m, 1);
                }
                j();
                return;
            default:
                d(z);
                return;
        }
    }

    private void j() {
        if (this.qcg != null && this.qcg.get() != null) {
            this.qcg.get().a(this.qcd, eEI(), eEJ());
            this.qcg = null;
            return;
        }
        j.eEM().a(k(), this.qcd, eEJ(), eEI());
    }

    private void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.eFk().a(this.m, 1);
        }
        e(z);
    }

    private void d(boolean z) {
        f(z);
    }

    public void e() {
        this.qbX.post(new Runnable() { // from class: com.ss.android.downloadlib.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                    dVar.b(f.this.eEK());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null && this.k) {
            switch (message.what) {
                case 3:
                    this.qca = (com.ss.android.socialbase.downloader.g.c) message.obj;
                    this.qbY.a(message, eEK(), this.f);
                    return;
                case 4:
                    if (j.eEU() == null || !j.eEU().a()) {
                        com.ss.android.downloadlib.e.a.eFk().a(this.m, false, 2);
                        b(false);
                        return;
                    }
                    return;
                case 5:
                    if (j.eEU() == null || !j.eEU().a()) {
                        com.ss.android.downloadlib.e.a.eFk().a(this.m, false, 1);
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
    private com.ss.android.a.a.b.b eEI() {
        return this.qce == null ? new f.a().eEi() : this.qce;
    }

    @NonNull
    private com.ss.android.a.a.b.a eEJ() {
        return this.qcf == null ? new a.C1220a().eEm() : this.qcf;
    }

    private void e(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12958a, "performItemClickWithNewDownloader", null);
        if (this.qbY.c(this.qca)) {
            com.ss.android.downloadlib.f.h.i(f12958a, "performItemClickWithNewDownloader ButtonClick", null);
            f(z);
            return;
        }
        com.ss.android.downloadlib.f.h.i(f12958a, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(boolean z) {
        com.ss.android.downloadlib.f.h.i(f12958a, "performButtonClickWithNewDownloader", null);
        if (this.qca == null || (this.qca.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).d(this.qca.g()))) {
            if (z) {
                com.ss.android.downloadlib.e.a.eFk().a(this.m, 2);
            }
            if (com.ss.android.downloadlib.f.d.i(this.qcd) != 0) {
                n();
                return;
            }
            com.ss.android.downloadlib.f.h.i(f12958a, "performButtonClickWithNewDownloader not start", null);
            this.qbY.a(new q() { // from class: com.ss.android.downloadlib.a.f.2
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
        com.ss.android.downloadlib.f.h.i(f12958a, "performButtonClickWithNewDownloader continue download, status:" + this.qca.q(), null);
        this.qbY.d(this.qca);
        if (this.qca != null && this.qcd != null) {
            this.qca.c(this.qcd.m());
        }
        final int q = this.qca.q();
        final int g = this.qca.g();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEB().j(this.qca);
        if (q == -4 || q == -2 || q == -1) {
            if (j != null) {
                j.h(System.currentTimeMillis());
                j.ja(this.qca.eHi());
            }
            this.qca.d(false);
            this.qbU.a(new d.a(this.m, this.qcd, eEI(), eEJ()));
            this.qbU.a(g, this.qca.eHi(), this.qca.eir(), new a() { // from class: com.ss.android.downloadlib.a.f.3
                @Override // com.ss.android.downloadlib.a.f.a
                public void a() {
                    if (!f.this.qbU.a()) {
                        com.ss.android.socialbase.appdownloader.d.eFv().e(j.a(), g, q);
                    }
                }
            });
            return;
        }
        if (l.a(q)) {
            this.qbU.a(true);
        }
        com.ss.android.socialbase.appdownloader.d.eFv().e(j.a(), g, q);
        l.a(j, this.qca, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.qbU.a(new d.a(this.m, this.qcd, eEI(), eEJ()));
        this.qbU.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.a.f.4
            @Override // com.ss.android.downloadlib.a.f.a
            public void a() {
                if (!f.this.qbU.a()) {
                    f.this.o();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
            dVar.a(this.qcd, eEJ());
        }
        int a2 = this.qbY.a(j.a(), this.qcc);
        com.ss.android.b.a.b.a a3 = a(this.qcd, a2);
        com.ss.android.downloadlib.a.b.d.eEB().d(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.ja(0L);
        com.ss.android.downloadlib.f.h.i(f12958a, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.qca == null) {
                this.qbY.b();
            } else {
                this.qbY.d(this.qca);
            }
        } else {
            com.ss.android.socialbase.downloader.g.c a4 = new c.a(this.qcd.a()).a();
            a4.c(-1);
            a(a4);
            com.ss.android.downloadlib.e.a.eFk().a(this.m, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
            com.ss.android.downloadlib.f.i.b();
        }
        if (this.qbY.b(c())) {
            com.ss.android.downloadlib.f.h.i(f12958a, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    private com.ss.android.b.a.b.a a(com.ss.android.a.a.b.c cVar, int i) {
        com.ss.android.b.a.b.a aVar = new com.ss.android.b.a.b.a(cVar, eEI(), eEJ(), i);
        if (com.ss.android.socialbase.downloader.k.a.RW(i).a("download_event_opt", 1) > 1) {
            try {
                String v = this.qcd.v();
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
            if (this.qca != null) {
                this.qca.c(-4);
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
                    if (f.this.qcd != null && !TextUtils.isEmpty(f.this.qcd.n())) {
                        cVar = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).hB(str, f.this.qcd.n());
                    }
                    if (cVar == null) {
                        return com.ss.android.socialbase.appdownloader.d.eFv().bF(j.a(), str);
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
            if (!isCancelled() && f.this.qcd != null) {
                try {
                    com.ss.android.downloadlib.a.b.b A = com.ss.android.downloadlib.f.i.A(f.this.qcd.v(), f.this.qcd.r(), f.this.qcd.s());
                    com.ss.android.downloadlib.a.b.f.eED().a(f.this.qcd.r(), A.b(), com.ss.android.downloadlib.a.b.d.eEB().j(cVar));
                    boolean a2 = A.a();
                    if (cVar != null && cVar.g() != 0 && (a2 || !com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(cVar))) {
                        com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).k(cVar.g());
                        if (f.this.qca == null || f.this.qca.q() != -4) {
                            f.this.qca = cVar;
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(f.this.qca.g(), f.this.qcc, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(f.this.qca.g(), f.this.qcc);
                            }
                        } else {
                            f.this.qca = null;
                        }
                        f.this.qbY.a(f.this.qca, f.this.eEK(), h.a(f.this.f));
                    } else {
                        if (cVar != null && com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).a(cVar)) {
                            com.ss.android.socialbase.downloader.notification.b.eIJ().f(cVar.g());
                            f.this.qca = null;
                        }
                        if (f.this.qca != null) {
                            com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).k(f.this.qca.g());
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iB(f.this.k()).a(f.this.qca.g(), f.this.qcc, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iB(f.this.k()).a(f.this.qca.g(), f.this.qcc);
                            }
                        }
                        if (!a2) {
                            for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.qca = null;
                        } else {
                            f.this.qca = new c.a(f.this.qcd.a()).a();
                            f.this.qca.c(-3);
                            f.this.qbY.a(f.this.qca, f.this.eEK(), h.a(f.this.f));
                        }
                    }
                    f.this.qbY.b(f.this.qca);
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
        this.qbX.sendMessage(obtain);
    }

    private void p() {
        if (this.qcb != null && this.qcb.getStatus() != AsyncTask.Status.FINISHED) {
            this.qcb.cancel(true);
        }
        this.qcb = new c();
        com.ss.android.downloadlib.f.b.a(this.qcb, this.qcd.a(), this.qcd.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.a.a.d.e eEK() {
        if (this.qbZ == null) {
            this.qbZ = new com.ss.android.a.a.d.e();
        }
        return this.qbZ;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void g() {
        com.ss.android.downloadlib.a.b.d.eEB().f(this.m);
    }
}
