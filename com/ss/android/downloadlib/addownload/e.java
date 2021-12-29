package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.c;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.g;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e implements f, m.a {
    public static final String a = "e";

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Context> f61876e;

    /* renamed from: g  reason: collision with root package name */
    public DownloadShortInfo f61878g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadInfo f61879h;

    /* renamed from: i  reason: collision with root package name */
    public c f61880i;

    /* renamed from: k  reason: collision with root package name */
    public boolean f61882k;
    public long l;
    public SoftReference<u> q;
    public boolean r;
    public SoftReference<IDownloadButtonClickListener> t;

    /* renamed from: b  reason: collision with root package name */
    public final m f61873b = new m(Looper.getMainLooper(), this);

    /* renamed from: f  reason: collision with root package name */
    public final Map<Integer, Object> f61877f = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    public final IDownloadListener f61881j = new g.a(this.f61873b);
    public long m = -1;
    public DownloadModel n = null;
    public DownloadEventConfig o = null;
    public DownloadController p = null;

    /* renamed from: c  reason: collision with root package name */
    public g f61874c = new g(this);

    /* renamed from: d  reason: collision with root package name */
    public d f61875d = new d(this.f61873b);
    public final boolean s = com.ss.android.socialbase.downloader.g.a.c().a("ttdownloader_callback_twice");

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.f61876e;
        if (weakReference != null && weakReference.get() != null) {
            return this.f61876e.get();
        }
        return j.getContext();
    }

    private void j() {
        SoftReference<u> softReference = this.q;
        if (softReference != null && softReference.get() != null) {
            this.q.get().a(this.n, k(), l());
            this.q = null;
            return;
        }
        j.b().a(getContext(), this.n, l(), k());
    }

    @NonNull
    private DownloadEventConfig k() {
        DownloadEventConfig downloadEventConfig = this.o;
        return downloadEventConfig == null ? new c.a().a() : downloadEventConfig;
    }

    @NonNull
    private DownloadController l() {
        if (this.p == null) {
            this.p = new com.ss.android.download.api.download.b();
        }
        return this.p;
    }

    private void m() {
        com.ss.android.downloadlib.g.k.a(a, "pICD", null);
        if (this.f61874c.d(this.f61879h)) {
            com.ss.android.downloadlib.g.k.a(a, "pICD BC", null);
            e(false);
            return;
        }
        com.ss.android.downloadlib.g.k.a(a, "pICD IC", null);
        j();
    }

    private boolean n() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            DownloadInfo downloadInfo = this.f61879h;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.f61879h.getCurBytes() <= 0) || this.f61879h.getStatus() == 0 || this.f61879h.getStatus() == -4) {
                return true;
            }
            return com.ss.android.socialbase.downloader.i.f.a(this.f61879h.getStatus(), this.f61879h.getSavePath(), this.f61879h.getName());
        }
        DownloadInfo downloadInfo2 = this.f61879h;
        if (downloadInfo2 == null) {
            return true;
        }
        return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(j.getContext()).canResume(this.f61879h.getId())) || this.f61879h.getStatus() == 0;
    }

    private void o() {
        c cVar = this.f61880i;
        if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f61880i.cancel(true);
        }
        c cVar2 = new c();
        this.f61880i = cVar2;
        com.ss.android.downloadlib.g.b.a(cVar2, this.n.getDownloadUrl(), this.n.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo p() {
        if (this.f61878g == null) {
            this.f61878g = new DownloadShortInfo();
        }
        return this.f61878g;
    }

    private boolean q() {
        SoftReference<IDownloadButtonClickListener> softReference = this.t;
        if (softReference != null && softReference.get() != null) {
            this.t.get().handleComplianceDialog(true);
            this.t = null;
            return true;
        }
        com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f61877f)) {
            downloadStatusChangeListener.onDownloadStart(this.n, l());
        }
        int a2 = this.f61874c.a(j.getContext(), this.f61881j);
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "beginDown id:" + a2, null);
        if (a2 != 0) {
            if (this.f61879h != null && !com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
                this.f61874c.a(this.f61879h, false);
            } else if (z) {
                this.f61874c.a();
            }
        } else {
            DownloadInfo a3 = new DownloadInfo.a(this.n.getDownloadUrl()).a();
            a3.setStatus(-1);
            a(a3);
            com.ss.android.downloadlib.d.a.a().a(this.m, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.e.c.a().b("beginDown");
        }
        if (this.f61874c.a(c())) {
            String str2 = a;
            com.ss.android.downloadlib.g.k.a(str2, "beginDown IC id:" + a2, null);
            j();
        }
    }

    public boolean c() {
        DownloadInfo downloadInfo = this.f61879h;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public long d() {
        return this.l;
    }

    public boolean e() {
        return j.i().optInt("quick_app_enable_switch", 0) == 0 && this.n.getQuickAppModel() != null && !TextUtils.isEmpty(this.n.getQuickAppModel().a()) && com.ss.android.downloadlib.addownload.c.a(this.f61879h) && com.ss.android.downloadlib.g.l.a(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.n.getQuickAppModel().a())));
    }

    public void f() {
        this.f61873b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(e.this.f61877f)) {
                    downloadStatusChangeListener.onInstalled(e.this.p());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void h() {
        com.ss.android.downloadlib.addownload.b.f.a().f(this.m);
    }

    private boolean c(int i2) {
        if (e()) {
            int i3 = -1;
            String a2 = this.n.getQuickAppModel().a();
            if (i2 == 1) {
                i3 = 5;
            } else if (i2 == 2) {
                i3 = 4;
            }
            DownloadModel downloadModel = this.n;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            boolean c2 = com.ss.android.downloadlib.g.i.c(j.getContext(), a2);
            if (c2) {
                com.ss.android.downloadlib.d.a.a().a(this.m, i2);
                Message obtain = Message.obtain();
                obtain.what = i3;
                obtain.obj = Long.valueOf(this.n.getId());
                com.ss.android.downloadlib.addownload.c.a().a(this, i3, this.n);
            } else {
                com.ss.android.downloadlib.d.a.a().a(this.m, false, 0);
            }
            return c2;
        }
        return false;
    }

    private void d(boolean z) {
        if (com.ss.android.downloadlib.g.e.b(this.n).b("notification_opt_2") == 1 && this.f61879h != null) {
            com.ss.android.socialbase.downloader.notification.b.a().f(this.f61879h.getId());
        }
        e(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final boolean z) {
        this.f61875d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, k(), l()));
        this.f61875d.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.addownload.e.5
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f61875d.a()) {
                    return;
                }
                e.this.g(z);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(Context context) {
        if (context != null) {
            this.f61876e = new WeakReference<>(context);
        }
        j.b(context);
        return this;
    }

    /* loaded from: classes3.dex */
    public class c extends AsyncTask<String, Void, DownloadInfo> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr != null) {
                if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                    String str = strArr[0];
                    if (e.this.n != null && !TextUtils.isEmpty(e.this.n.getFilePath())) {
                        downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(str, e.this.n.getFilePath());
                    }
                    return downloadInfo == null ? com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str) : downloadInfo;
                }
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || e.this.n == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.b.c a = com.ss.android.downloadlib.g.l.a(e.this.n.getPackageName(), e.this.n.getVersionCode(), e.this.n.getVersionName());
                com.ss.android.downloadlib.addownload.b.h.a().a(e.this.n.getVersionCode(), a.b(), com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo));
                boolean a2 = a.a();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (a2 || !Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(j.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (e.this.f61879h == null || e.this.f61879h.getStatus() != -4) {
                        e.this.f61879h = downloadInfo;
                        if (e.this.s) {
                            Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.f61879h.getId(), e.this.f61881j, false);
                        } else {
                            Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.f61879h.getId(), e.this.f61881j);
                        }
                    } else {
                        e.this.f61879h = null;
                    }
                    e.this.f61874c.a(e.this.f61879h, e.this.p(), g.a(e.this.f61877f));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                        e.this.f61879h = null;
                    }
                    if (e.this.f61879h != null) {
                        Downloader.getInstance(j.getContext()).removeTaskMainListener(e.this.f61879h.getId());
                        if (e.this.s) {
                            Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.f61879h.getId(), e.this.f61881j, false);
                        } else {
                            Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.f61879h.getId(), e.this.f61881j);
                        }
                    }
                    if (a2) {
                        e.this.f61879h = new DownloadInfo.a(e.this.n.getDownloadUrl()).a();
                        e.this.f61879h.setStatus(-3);
                        e.this.f61874c.a(e.this.f61879h, e.this.p(), g.a(e.this.f61877f));
                    } else {
                        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(e.this.f61877f)) {
                            downloadStatusChangeListener.onIdle();
                        }
                        e.this.f61879h = null;
                    }
                }
                e.this.f61874c.c(e.this.f61879h);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void e(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        com.ss.android.downloadlib.g.k.a(a, "pBCD", null);
        if (n()) {
            com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(this.m);
            DownloadInfo downloadInfo = this.f61879h;
            if (downloadInfo != null && downloadInfo.getStatus() != 0) {
                a(z, true);
                return;
            } else if (this.r) {
                if (this.n.isAd() && this.t != null) {
                    if (q() && (downloadController2 = e2.f61806d) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        a(z, true);
                        return;
                    }
                    return;
                }
                a(z, true);
                return;
            } else if (this.n.isAd() && (downloadController = e2.f61806d) != null && downloadController.enableShowComplianceDialog() && e2.f61804b != null && com.ss.android.downloadlib.addownload.compliance.b.a().a(e2.f61804b) && com.ss.android.downloadlib.addownload.compliance.b.a().a(e2)) {
                return;
            } else {
                a(z, true);
                return;
            }
        }
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "pBCD continue download, status:" + this.f61879h.getStatus(), null);
        DownloadInfo downloadInfo2 = this.f61879h;
        if (downloadInfo2 != null && (downloadModel = this.n) != null) {
            downloadInfo2.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.f61879h.getStatus();
        final int id = this.f61879h.getId();
        final com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(this.f61879h);
        if (status != -2 && status != -1) {
            if (l.a(status)) {
                if (this.n.enablePause()) {
                    this.f61875d.a(true);
                    com.ss.android.downloadlib.c.h.a().b(com.ss.android.downloadlib.addownload.b.f.a().d(this.m));
                    com.ss.android.downloadlib.addownload.d.f.a().a(a2, status, new com.ss.android.downloadlib.addownload.d.c() { // from class: com.ss.android.downloadlib.addownload.e.3
                        @Override // com.ss.android.downloadlib.addownload.d.c
                        public void a(com.ss.android.downloadad.api.a.b bVar) {
                            e.this.f61874c.a(e.this.f61879h, z);
                            if (com.ss.android.socialbase.downloader.i.f.b(j.getContext()) && e.this.f61879h.isPauseReserveOnWifi()) {
                                e.this.f61879h.stopPauseReserveOnWifi();
                                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel_on_wifi", a2);
                                return;
                            }
                            e eVar = e.this;
                            eVar.a(id, status, eVar.f61879h);
                        }
                    });
                    return;
                }
                return;
            }
            this.f61874c.a(this.f61879h, z);
            a(id, status, this.f61879h);
            return;
        }
        this.f61874c.a(this.f61879h, z);
        if (a2 != null) {
            a2.h(System.currentTimeMillis());
            a2.i(this.f61879h.getCurBytes());
        }
        this.f61879h.setDownloadFromReserveWifi(false);
        this.f61875d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, k(), l()));
        this.f61875d.a(id, this.f61879h.getCurBytes(), this.f61879h.getTotalBytes(), new a() { // from class: com.ss.android.downloadlib.addownload.e.2
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f61875d.a()) {
                    return;
                }
                e eVar = e.this;
                eVar.a(id, status, eVar.f61879h);
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(int i2, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (j.i().optInt("back_use_softref_listener") == 1) {
                this.f61877f.put(Integer.valueOf(i2), downloadStatusChangeListener);
            } else {
                this.f61877f.put(Integer.valueOf(i2), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean b() {
        return this.f61882k;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void b(int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f61874c.a(this.m);
        if (!com.ss.android.downloadlib.addownload.b.f.a().e(this.m).y()) {
            com.ss.android.downloadlib.e.c.a().a("handleDownload ModelBox !isStrictValid");
        }
        if (this.f61874c.a(getContext(), i2, this.r)) {
            return;
        }
        boolean c2 = c(i2);
        if (i2 == 1) {
            if (c2) {
                return;
            }
            String str = a;
            com.ss.android.downloadlib.g.k.a(str, "handleDownload id:" + this.m + ",pIC:", null);
            c(true);
        } else if (i2 == 2 && !c2) {
            String str2 = a;
            com.ss.android.downloadlib.g.k.a(str2, "handleDownload id:" + this.m + ",pBC:", null);
            b(true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.e.c.a().a("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.e.c.a().a(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.g.a.c().a("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.b.f.a().a(downloadModel);
            this.m = downloadModel.getId();
            this.n = downloadModel;
            if (h.a(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(this.m);
                if (d2 != null && d2.l() != 3) {
                    d2.e(3L);
                    com.ss.android.downloadlib.addownload.b.i.a().a(d2);
                }
            }
        }
        return this;
    }

    public void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.m, 1);
        }
        m();
    }

    public void g() {
        if (this.f61877f.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f61877f)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.f61879h;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    public void b(boolean z) {
        d(z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadController downloadController) {
        JSONObject extra;
        this.p = downloadController;
        if (com.ss.android.downloadlib.g.e.b(this.n).b("force_auto_open") == 1) {
            l().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_show_dialog") && (extra = this.n.getExtra()) != null && extra.optInt("subprocess") > 0) {
            l().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadEventConfig downloadEventConfig) {
        this.o = downloadEventConfig;
        this.r = k().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, k());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(u uVar) {
        if (uVar == null) {
            this.q = null;
        } else {
            this.q = new SoftReference<>(uVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a() {
        this.f61882k = true;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, k());
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        this.f61874c.a(this.m);
        o();
        if (j.i().optInt("enable_empty_listener", 1) == 1 && this.f61877f.get(Integer.MIN_VALUE) == null) {
            b(Integer.MIN_VALUE, new com.ss.android.download.api.config.a());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean a(int i2) {
        if (i2 == 0) {
            this.f61877f.clear();
        } else {
            this.f61877f.remove(Integer.valueOf(i2));
        }
        if (this.f61877f.isEmpty()) {
            this.f61882k = false;
            this.l = System.currentTimeMillis();
            if (this.f61879h != null) {
                Downloader.getInstance(j.getContext()).removeTaskMainListener(this.f61879h.getId());
            }
            c cVar = this.f61880i;
            if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f61880i.cancel(true);
            }
            this.f61874c.a(this.f61879h);
            String str = a;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f61879h;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.g.k.a(str, sb.toString(), null);
            this.f61873b.removeCallbacksAndMessages(null);
            this.f61878g = null;
            this.f61879h = null;
            return true;
        }
        if (this.f61877f.size() == 1 && this.f61877f.containsKey(Integer.MIN_VALUE)) {
            this.f61874c.b(this.f61879h);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a(boolean z) {
        if (this.f61879h != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
                if (b2 != null) {
                    b2.a(this.f61879h);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(this.f61879h.getId(), true);
                return;
            }
            Intent intent = new Intent(j.getContext(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f61879h.getId());
            j.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(long j2) {
        if (j2 != 0) {
            DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
            if (a2 != null) {
                this.n = a2;
                this.m = j2;
                this.f61874c.a(j2);
            }
        } else {
            com.ss.android.downloadlib.e.c.a().a(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        if (message != null && this.f61882k && message.what == 3) {
            this.f61879h = (DownloadInfo) message.obj;
            this.f61874c.a(message, p(), this.f61877f);
        }
    }

    public void a(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.m, 2);
        }
        if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE") && !l().enableNewActivity()) {
            this.n.setFilePath(this.f61874c.b());
        }
        if (com.ss.android.downloadlib.g.e.c(this.n) == 0) {
            com.ss.android.downloadlib.g.k.a(a, "pBCD not start", null);
            this.f61874c.a(new s() { // from class: com.ss.android.downloadlib.addownload.e.4
                @Override // com.ss.android.download.api.config.s
                public void a() {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD start download", null);
                    e.this.f(z2);
                }

                @Override // com.ss.android.download.api.config.s
                public void a(String str) {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD onDenied", null);
                }
            });
            return;
        }
        f(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            if (i3 != -3 && !com.ss.android.socialbase.downloader.downloader.d.a().e(i2)) {
                a(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
    }

    private void a(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.f61873b.sendMessage(obtain);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.t = null;
        } else {
            this.t = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
