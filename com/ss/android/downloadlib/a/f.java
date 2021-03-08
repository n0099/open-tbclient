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
    private static final String f7708a = f.class.getSimpleName();
    private WeakReference<Context> e;
    private boolean k;
    private long l;
    private com.ss.android.a.a.d.e qcN;
    private com.ss.android.socialbase.downloader.g.c qcO;
    private c qcP;
    private SoftReference<s> qcT;
    private boolean r;
    private final com.ss.android.downloadlib.f.j qcL = new com.ss.android.downloadlib.f.j(Looper.getMainLooper(), this);
    private final Map<Integer, Object> f = new ConcurrentHashMap();
    private final com.ss.android.socialbase.downloader.d.b qcQ = new h.a(this.qcL);
    private long m = -1;
    private com.ss.android.a.a.b.c n = null;
    private com.ss.android.a.a.b.b qcR = null;
    private com.ss.android.a.a.b.a qcS = null;
    private h qcM = new h();
    private e qcI = new e(this.qcL);
    private final boolean s = com.ss.android.socialbase.downloader.k.a.eIH().a("ttdownloader_callback_twice");

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
    /* renamed from: iy */
    public f iz(Context context) {
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
            com.ss.android.downloadlib.a.b.d.eEF().a(cVar);
            this.m = cVar.d();
            this.n = cVar;
            if (i.b(cVar)) {
                ((com.ss.android.b.a.a.c) cVar).a(3L);
                com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEF().je(this.m);
                if (je != null && je.k() != 3) {
                    je.e(3L);
                    com.ss.android.downloadlib.a.b.g.eEI().d(je);
                }
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.a aVar) {
        this.qcS = aVar;
        com.ss.android.downloadlib.a.b.d.eEF().a(this.m, eEN());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.a.g
    /* renamed from: a */
    public f b(com.ss.android.a.a.b.b bVar) {
        this.qcR = bVar;
        this.r = eEM().k() == 0;
        com.ss.android.downloadlib.a.b.d.eEF().a(this.m, eEM());
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public g a(s sVar) {
        if (sVar == null) {
            this.qcT = null;
        } else {
            this.qcT = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.a.b.d.eEF().a(this.m, eEM());
        com.ss.android.downloadlib.a.b.d.eEF().a(this.m, eEN());
        this.qcM.a(this.m);
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
            if (this.qcO != null) {
                com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).k(this.qcO.g());
            }
            if (this.qcP != null && this.qcP.getStatus() != AsyncTask.Status.FINISHED) {
                this.qcP.cancel(true);
            }
            this.qcM.a(this.qcO);
            com.ss.android.downloadlib.f.h.i(f7708a, "onUnbind removeCallbacksAndMessages, downloadUrl:" + (this.qcO == null ? "" : this.qcO.j()), null);
            this.qcL.removeCallbacksAndMessages(null);
            this.qcN = null;
            this.qcO = null;
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void a(boolean z) {
        if (this.qcO != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d eFv = com.ss.android.socialbase.appdownloader.d.eFz().eFv();
                if (eFv != null) {
                    eFv.a(this.qcO);
                }
                com.ss.android.socialbase.downloader.downloader.f.iC(com.ss.android.socialbase.downloader.downloader.b.eGG()).a(this.qcO.g(), true);
                return;
            }
            Intent intent = new Intent(j.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.qcO.g());
            j.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.a.g
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.qcO != null;
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
            com.ss.android.a.a.b.c jb = com.ss.android.downloadlib.a.b.d.eEF().jb(j);
            if (jb != null) {
                this.n = jb;
                this.m = j;
                this.qcM.a(this.m);
            }
        } else {
            com.ss.android.downloadlib.f.i.b();
        }
        if (!this.qcM.e(k(), i, this.r)) {
            boolean b2 = b(i);
            switch (i) {
                case 1:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f7708a, "handleDownload id:" + j + ",tryPerformItemClick:", null);
                        c(true);
                        return;
                    }
                    return;
                case 2:
                    if (!b2) {
                        com.ss.android.downloadlib.f.h.i(f7708a, "handleDownload id:" + j + ",tryPerformButtonClick:", null);
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
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && com.ss.android.downloadlib.a.c.b(this.n) && com.ss.android.downloadlib.a.c.a(this.qcO);
    }

    private boolean b(int i) {
        if (i()) {
            int i2 = -1;
            String a2 = this.n.eEk().a();
            switch (i) {
                case 1:
                    i2 = 5;
                    break;
                case 2:
                    i2 = 4;
                    break;
            }
            com.ss.android.downloadlib.e.a.eFo().a(this.m, i);
            boolean c2 = com.ss.android.downloadlib.f.f.c(j.a(), a2);
            if (c2) {
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.n.d());
                this.qcL.sendMessageDelayed(obtain, com.ss.android.downloadlib.a.c.eEJ().b());
                com.ss.android.downloadlib.a.c.eEJ().a(i2, this.n, this.qcR);
            } else {
                com.ss.android.downloadlib.e.a.eFo().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void b(boolean z) {
        switch (this.qcM.a(this.r)) {
            case 1:
                if (z) {
                    com.ss.android.downloadlib.e.a.eFo().a(this.m, 1);
                }
                j();
                return;
            default:
                d(z);
                return;
        }
    }

    private void j() {
        if (this.qcT != null && this.qcT.get() != null) {
            this.qcT.get().a(this.n, eEM(), eEN());
            this.qcT = null;
            return;
        }
        j.eEQ().a(k(), this.n, eEN(), eEM());
    }

    private void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.e.a.eFo().a(this.m, 1);
        }
        e(z);
    }

    private void d(boolean z) {
        f(z);
    }

    public void e() {
        this.qcL.post(new Runnable() { // from class: com.ss.android.downloadlib.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                    dVar.b(f.this.eEO());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.f.j.a
    public void a(Message message) {
        if (message != null && this.k) {
            switch (message.what) {
                case 3:
                    this.qcO = (com.ss.android.socialbase.downloader.g.c) message.obj;
                    this.qcM.a(message, eEO(), this.f);
                    return;
                case 4:
                    if (j.eEY() == null || !j.eEY().a()) {
                        com.ss.android.downloadlib.e.a.eFo().a(this.m, false, 2);
                        b(false);
                        return;
                    }
                    return;
                case 5:
                    if (j.eEY() == null || !j.eEY().a()) {
                        com.ss.android.downloadlib.e.a.eFo().a(this.m, false, 1);
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
    private com.ss.android.a.a.b.b eEM() {
        return this.qcR == null ? new f.a().eEm() : this.qcR;
    }

    @NonNull
    private com.ss.android.a.a.b.a eEN() {
        return this.qcS == null ? new a.C1210a().eEq() : this.qcS;
    }

    private void e(boolean z) {
        com.ss.android.downloadlib.f.h.i(f7708a, "performItemClickWithNewDownloader", null);
        if (this.qcM.c(this.qcO)) {
            com.ss.android.downloadlib.f.h.i(f7708a, "performItemClickWithNewDownloader ButtonClick", null);
            f(z);
            return;
        }
        com.ss.android.downloadlib.f.h.i(f7708a, "performItemClickWithNewDownloader onItemClick", null);
        j();
    }

    private void f(boolean z) {
        com.ss.android.downloadlib.f.h.i(f7708a, "performButtonClickWithNewDownloader", null);
        if (this.qcO == null || (this.qcO.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).d(this.qcO.g()))) {
            if (z) {
                com.ss.android.downloadlib.e.a.eFo().a(this.m, 2);
            }
            if (com.ss.android.downloadlib.f.d.i(this.n) != 0) {
                n();
                return;
            }
            com.ss.android.downloadlib.f.h.i(f7708a, "performButtonClickWithNewDownloader not start", null);
            this.qcM.a(new q() { // from class: com.ss.android.downloadlib.a.f.2
                @Override // com.ss.android.a.a.a.q
                public void a() {
                    com.ss.android.downloadlib.f.h.i(f.f7708a, "performButtonClickWithNewDownloader start download", null);
                    f.this.n();
                }

                @Override // com.ss.android.a.a.a.q
                public void a(String str) {
                    com.ss.android.downloadlib.f.h.i(f.f7708a, "performButtonClickWithNewDownloader onDenied", null);
                }
            });
            return;
        }
        com.ss.android.downloadlib.f.h.i(f7708a, "performButtonClickWithNewDownloader continue download, status:" + this.qcO.q(), null);
        this.qcM.d(this.qcO);
        if (this.qcO != null && this.n != null) {
            this.qcO.c(this.n.m());
        }
        final int q = this.qcO.q();
        final int g = this.qcO.g();
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEF().j(this.qcO);
        if (q == -4 || q == -2 || q == -1) {
            if (j != null) {
                j.h(System.currentTimeMillis());
                j.ja(this.qcO.eHm());
            }
            this.qcO.d(false);
            this.qcI.a(new d.a(this.m, this.n, eEM(), eEN()));
            this.qcI.a(g, this.qcO.eHm(), this.qcO.am(), new a() { // from class: com.ss.android.downloadlib.a.f.3
                @Override // com.ss.android.downloadlib.a.f.a
                public void a() {
                    if (!f.this.qcI.a()) {
                        com.ss.android.socialbase.appdownloader.d.eFz().e(j.a(), g, q);
                    }
                }
            });
            return;
        }
        if (l.a(q)) {
            this.qcI.a(true);
        }
        com.ss.android.socialbase.appdownloader.d.eFz().e(j.a(), g, q);
        l.a(j, this.qcO, q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.qcI.a(new d.a(this.m, this.n, eEM(), eEN()));
        this.qcI.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.a.f.4
            @Override // com.ss.android.downloadlib.a.f.a
            public void a() {
                if (!f.this.qcI.a()) {
                    f.this.o();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        for (com.ss.android.a.a.b.d dVar : h.a(this.f)) {
            dVar.a(this.n, eEN());
        }
        int a2 = this.qcM.a(j.a(), this.qcQ);
        com.ss.android.b.a.b.a a3 = a(this.n, a2);
        com.ss.android.downloadlib.a.b.d.eEF().d(a3);
        a3.g(a2);
        a3.h(System.currentTimeMillis());
        a3.ja(0L);
        com.ss.android.downloadlib.f.h.i(f7708a, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.qcO == null) {
                this.qcM.b();
            } else {
                this.qcM.d(this.qcO);
            }
        } else {
            com.ss.android.socialbase.downloader.g.c a4 = new c.a(this.n.a()).a();
            a4.c(-1);
            a(a4);
            com.ss.android.downloadlib.e.a.eFo().a(this.m, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
            com.ss.android.downloadlib.f.i.b();
        }
        if (this.qcM.b(c())) {
            com.ss.android.downloadlib.f.h.i(f7708a, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            j();
        }
    }

    private com.ss.android.b.a.b.a a(com.ss.android.a.a.b.c cVar, int i) {
        com.ss.android.b.a.b.a aVar = new com.ss.android.b.a.b.a(cVar, eEM(), eEN(), i);
        if (com.ss.android.socialbase.downloader.k.a.Sa(i).a("download_event_opt", 1) > 1) {
            try {
                String v = this.n.v();
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
            if (this.qcO != null) {
                this.qcO.c(-4);
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
                    if (f.this.n != null && !TextUtils.isEmpty(f.this.n.n())) {
                        cVar = com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).hC(str, f.this.n.n());
                    }
                    if (cVar == null) {
                        return com.ss.android.socialbase.appdownloader.d.eFz().bE(j.a(), str);
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
            if (!isCancelled() && f.this.n != null) {
                try {
                    com.ss.android.downloadlib.a.b.b B = com.ss.android.downloadlib.f.i.B(f.this.n.v(), f.this.n.r(), f.this.n.s());
                    com.ss.android.downloadlib.a.b.f.eEH().a(f.this.n.r(), B.b(), com.ss.android.downloadlib.a.b.d.eEF().j(cVar));
                    boolean a2 = B.a();
                    if (cVar != null && cVar.g() != 0 && (a2 || !com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).a(cVar))) {
                        com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).k(cVar.g());
                        if (f.this.qcO == null || f.this.qcO.q() != -4) {
                            f.this.qcO = cVar;
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).a(f.this.qcO.g(), f.this.qcQ, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).a(f.this.qcO.g(), f.this.qcQ);
                            }
                        } else {
                            f.this.qcO = null;
                        }
                        f.this.qcM.a(f.this.qcO, f.this.eEO(), h.a(f.this.f));
                    } else {
                        if (cVar != null && com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).a(cVar)) {
                            com.ss.android.socialbase.downloader.notification.b.eIK().f(cVar.g());
                            f.this.qcO = null;
                        }
                        if (f.this.qcO != null) {
                            com.ss.android.socialbase.downloader.downloader.f.iC(j.a()).k(f.this.qcO.g());
                            if (f.this.s) {
                                com.ss.android.socialbase.downloader.downloader.f.iC(f.this.k()).a(f.this.qcO.g(), f.this.qcQ, false);
                            } else {
                                com.ss.android.socialbase.downloader.downloader.f.iC(f.this.k()).a(f.this.qcO.g(), f.this.qcQ);
                            }
                        }
                        if (!a2) {
                            for (com.ss.android.a.a.b.d dVar : h.a(f.this.f)) {
                                dVar.a();
                            }
                            f.this.qcO = null;
                        } else {
                            f.this.qcO = new c.a(f.this.n.a()).a();
                            f.this.qcO.c(-3);
                            f.this.qcM.a(f.this.qcO, f.this.eEO(), h.a(f.this.f));
                        }
                    }
                    f.this.qcM.b(f.this.qcO);
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
        this.qcL.sendMessage(obtain);
    }

    private void p() {
        if (this.qcP != null && this.qcP.getStatus() != AsyncTask.Status.FINISHED) {
            this.qcP.cancel(true);
        }
        this.qcP = new c();
        com.ss.android.downloadlib.f.b.a(this.qcP, this.n.a(), this.n.v());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.a.a.d.e eEO() {
        if (this.qcN == null) {
            this.qcN = new com.ss.android.a.a.d.e();
        }
        return this.qcN;
    }

    @Override // com.ss.android.downloadlib.a.g
    public void g() {
        com.ss.android.downloadlib.a.b.d.eEF().f(this.m);
    }
}
