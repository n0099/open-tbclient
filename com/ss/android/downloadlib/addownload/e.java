package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.s;
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
/* loaded from: classes8.dex */
public class e implements f, m.a {
    public static final String a = "e";
    public WeakReference e;
    public DownloadShortInfo g;
    public DownloadInfo h;
    public c i;
    public boolean k;
    public long l;
    public SoftReference q;
    public boolean r;
    public SoftReference t;
    public final m b = new m(Looper.getMainLooper(), this);
    public final Map f = new ConcurrentHashMap();
    public final IDownloadListener j = new g.a(this.b);
    public long m = -1;
    public DownloadModel n = null;
    public DownloadEventConfig o = null;
    public DownloadController p = null;
    public g c = new g(this);
    public d d = new d(this.b);
    public final boolean s = com.ss.android.socialbase.downloader.g.a.c().a("ttdownloader_callback_twice");

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(long j);
    }

    /* loaded from: classes8.dex */
    public class c extends AsyncTask {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = strArr[0];
            if (e.this.n != null && !TextUtils.isEmpty(e.this.n.getFilePath())) {
                downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(str, e.this.n.getFilePath());
            }
            if (downloadInfo == null) {
                return com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str);
            }
            return downloadInfo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (!isCancelled() && e.this.n != null) {
                try {
                    com.ss.android.downloadlib.addownload.b.c a = com.ss.android.downloadlib.g.l.a(e.this.n.getPackageName(), e.this.n.getVersionCode(), e.this.n.getVersionName());
                    com.ss.android.downloadlib.addownload.b.h.a().a(e.this.n.getVersionCode(), a.b(), com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo));
                    boolean a2 = a.a();
                    if (downloadInfo != null && downloadInfo.getId() != 0 && (a2 || !Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                        Downloader.getInstance(j.getContext()).removeTaskMainListener(downloadInfo.getId());
                        if (e.this.h == null || e.this.h.getStatus() != -4) {
                            e.this.h = downloadInfo;
                            if (e.this.s) {
                                Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.h.getId(), e.this.j, false);
                            } else {
                                Downloader.getInstance(j.getContext()).setMainThreadListener(e.this.h.getId(), e.this.j);
                            }
                        } else {
                            e.this.h = null;
                        }
                        e.this.c.a(e.this.h, e.this.q(), g.a(e.this.f));
                    } else {
                        if (downloadInfo != null && Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                            com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                            e.this.h = null;
                        }
                        if (e.this.h != null) {
                            Downloader.getInstance(j.getContext()).removeTaskMainListener(e.this.h.getId());
                            if (e.this.s) {
                                Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.h.getId(), e.this.j, false);
                            } else {
                                Downloader.getInstance(e.this.getContext()).setMainThreadListener(e.this.h.getId(), e.this.j);
                            }
                        }
                        if (a2) {
                            e.this.h = new DownloadInfo.a(e.this.n.getDownloadUrl()).a();
                            e.this.h.setStatus(-3);
                            e.this.c.a(e.this.h, e.this.q(), g.a(e.this.f));
                        } else {
                            for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(e.this.f)) {
                                downloadStatusChangeListener.onIdle();
                            }
                            e.this.h = null;
                        }
                    }
                    e.this.c.c(e.this.h);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void k() {
        SoftReference softReference = this.q;
        if (softReference != null && softReference.get() != null) {
            ((OnItemClickListener) this.q.get()).onItemClick(this.n, l(), m());
            this.q = null;
            return;
        }
        j.b().a(getContext(), this.n, m(), l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final boolean z) {
        this.d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, l(), m()));
        this.d.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.addownload.e.5
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (!e.this.d.a()) {
                    e.this.h(z);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            if (i2 != -3 && !com.ss.android.socialbase.downloader.downloader.d.a().e(i)) {
                a(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i, i2);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i, i2);
    }

    private void a(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.b.sendMessage(obtain);
    }

    private void e(boolean z) {
        if (com.ss.android.downloadlib.g.e.b(this.n).b("notification_opt_2") == 1 && this.h != null) {
            com.ss.android.socialbase.downloader.notification.b.a().f(this.h.getId());
        }
        f(z);
    }

    public void c(boolean z) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.m, 1);
        }
        n();
    }

    private boolean c(int i) {
        if (!e()) {
            return false;
        }
        int i2 = -1;
        String a2 = this.n.getQuickAppModel().a();
        if (i != 1) {
            if (i == 2) {
                i2 = 4;
            }
        } else {
            i2 = 5;
        }
        DownloadModel downloadModel = this.n;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean c2 = com.ss.android.downloadlib.g.i.c(j.getContext(), a2);
        if (c2) {
            com.ss.android.downloadlib.d.a.a().a(this.m, i);
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = Long.valueOf(this.n.getId());
            com.ss.android.downloadlib.addownload.c.a().a(this, i2, this.n);
        } else {
            com.ss.android.downloadlib.d.a.a().a(this.m, false, 0);
        }
        return c2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadController downloadController) {
        JSONObject extra;
        this.p = downloadController;
        if (com.ss.android.downloadlib.g.e.b(this.n).b("force_auto_open") == 1) {
            m().setLinkMode(1);
        }
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_show_dialog") && (extra = this.n.getExtra()) != null && extra.optInt("subprocess") > 0) {
            m().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, m());
        return this;
    }

    private void f(final boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        com.ss.android.downloadlib.g.k.a(a, "pBCD", null);
        if (o()) {
            com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(this.m);
            if (this.r) {
                if (i()) {
                    if (d(false) && (downloadController2 = e.d) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        a(z, true);
                        return;
                    }
                    return;
                }
                a(z, true);
                return;
            } else if (this.n.isAd() && (downloadController = e.d) != null && downloadController.enableShowComplianceDialog() && e.b != null && com.ss.android.downloadlib.addownload.compliance.b.a().a(e.b) && com.ss.android.downloadlib.addownload.compliance.b.a().a(e)) {
                return;
            } else {
                a(z, true);
                return;
            }
        }
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "pBCD continue download, status:" + this.h.getStatus(), null);
        DownloadInfo downloadInfo = this.h;
        if (downloadInfo != null && (downloadModel = this.n) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.h.getStatus();
        final int id = this.h.getId();
        final com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(this.h);
        if (status != -2 && status != -1) {
            if (l.a(status)) {
                if (!this.n.enablePause()) {
                    return;
                }
                this.d.a(true);
                com.ss.android.downloadlib.c.h.a().b(com.ss.android.downloadlib.addownload.b.f.a().d(this.m));
                com.ss.android.downloadlib.addownload.d.f.a().a(a2, status, new com.ss.android.downloadlib.addownload.d.c() { // from class: com.ss.android.downloadlib.addownload.e.3
                    @Override // com.ss.android.downloadlib.addownload.d.c
                    public void a(com.ss.android.downloadad.api.a.b bVar) {
                        if (e.this.h == null && com.ss.android.socialbase.downloader.g.a.c().a("fix_handle_pause")) {
                            e.this.h = Downloader.getInstance(j.getContext()).getDownloadInfo(id);
                        }
                        e.this.c.a(e.this.h, z);
                        if (e.this.h != null && com.ss.android.socialbase.downloader.i.f.b(j.getContext()) && e.this.h.isPauseReserveOnWifi()) {
                            e.this.h.stopPauseReserveOnWifi();
                            com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel_on_wifi", a2);
                            return;
                        }
                        e eVar = e.this;
                        eVar.a(id, status, eVar.h);
                    }
                });
                return;
            }
            this.c.a(this.h, z);
            a(id, status, this.h);
            return;
        }
        this.c.a(this.h, z);
        if (a2 != null) {
            a2.h(System.currentTimeMillis());
            a2.i(this.h.getCurBytes());
        }
        this.h.setDownloadFromReserveWifi(false);
        this.d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, l(), m()));
        this.d.a(id, this.h.getCurBytes(), this.h.getTotalBytes(), new a() { // from class: com.ss.android.downloadlib.addownload.e.2
            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.d.a()) {
                    return;
                }
                e eVar = e.this;
                eVar.a(id, status, eVar.h);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            return (Context) this.e.get();
        }
        return j.getContext();
    }

    private DownloadEventConfig l() {
        DownloadEventConfig downloadEventConfig = this.o;
        if (downloadEventConfig == null) {
            return new c.a().a();
        }
        return downloadEventConfig;
    }

    private DownloadController m() {
        if (this.p == null) {
            this.p = new com.ss.android.download.api.download.b();
        }
        return this.p;
    }

    private void n() {
        com.ss.android.downloadlib.g.k.a(a, "pICD", null);
        if (this.c.d(this.h)) {
            com.ss.android.downloadlib.g.k.a(a, "pICD BC", null);
            f(false);
            return;
        }
        com.ss.android.downloadlib.g.k.a(a, "pICD IC", null);
        k();
    }

    private void p() {
        c cVar = this.i;
        if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.i.cancel(true);
        }
        c cVar2 = new c();
        this.i = cVar2;
        com.ss.android.downloadlib.g.b.a(cVar2, this.n.getDownloadUrl(), this.n.getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo q() {
        if (this.g == null) {
            this.g = new DownloadShortInfo();
        }
        return this.g;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean b() {
        return this.k;
    }

    public boolean c() {
        DownloadInfo downloadInfo = this.h;
        if (downloadInfo != null && downloadInfo.getStatus() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public long d() {
        return this.l;
    }

    public void f() {
        this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.e.1
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(e.this.f)) {
                    downloadStatusChangeListener.onInstalled(e.this.q());
                }
            }
        });
    }

    public void g() {
        if (this.f.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.h;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void h() {
        com.ss.android.downloadlib.addownload.b.f.a().f(this.m);
    }

    public boolean i() {
        SoftReference softReference = this.t;
        if (softReference == null) {
            return false;
        }
        return h.a(this.n, (IDownloadButtonClickListener) softReference.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z) {
        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f)) {
            downloadStatusChangeListener.onDownloadStart(this.n, m());
        }
        int a2 = this.c.a(j.getContext(), this.j);
        String str = a;
        com.ss.android.downloadlib.g.k.a(str, "beginDown id:" + a2, null);
        if (a2 != 0) {
            if (this.h != null && !com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
                this.c.a(this.h, false);
            } else if (z) {
                this.c.a();
            }
        } else {
            DownloadInfo a3 = new DownloadInfo.a(this.n.getDownloadUrl()).a();
            a3.setStatus(-1);
            a(a3);
            com.ss.android.downloadlib.d.a.a().a(this.m, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.e.c.a().b("beginDown");
        }
        if (this.c.a(c())) {
            String str2 = a;
            com.ss.android.downloadlib.g.k.a(str2, "beginDown IC id:" + a2, null);
            k();
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean a(int i) {
        String url;
        if (i == 0) {
            this.f.clear();
        } else {
            this.f.remove(Integer.valueOf(i));
        }
        if (this.f.isEmpty()) {
            this.k = false;
            this.l = System.currentTimeMillis();
            if (this.h != null) {
                Downloader.getInstance(j.getContext()).removeTaskMainListener(this.h.getId());
            }
            c cVar = this.i;
            if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.i.cancel(true);
            }
            this.c.a(this.h);
            String str = a;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.h;
            if (downloadInfo == null) {
                url = "";
            } else {
                url = downloadInfo.getUrl();
            }
            sb.append(url);
            com.ss.android.downloadlib.g.k.a(str, sb.toString(), null);
            this.b.removeCallbacksAndMessages(null);
            this.g = null;
            this.h = null;
            return true;
        }
        if (this.f.size() == 1 && this.f.containsKey(Integer.MIN_VALUE)) {
            this.c.b(this.h);
        }
        return false;
    }

    private boolean o() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
            DownloadInfo downloadInfo = this.h;
            if (downloadInfo == null) {
                return true;
            }
            if ((downloadInfo.getStatus() == -3 && this.h.getCurBytes() <= 0) || this.h.getStatus() == 0 || this.h.getStatus() == -4) {
                return true;
            }
            if (!com.ss.android.socialbase.downloader.i.f.a(this.h.getStatus(), this.h.getSavePath(), this.h.getName())) {
                return false;
            }
            return true;
        }
        DownloadInfo downloadInfo2 = this.h;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 || Downloader.getInstance(j.getContext()).canResume(this.h.getId())) && this.h.getStatus() != 0) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (j.i().optInt("back_use_softref_listener") == 1) {
                this.f.put(Integer.valueOf(i), downloadStatusChangeListener);
            } else {
                this.f.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(Context context) {
        if (context != null) {
            this.e = new WeakReference(context);
        }
        j.b(context);
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadEventConfig downloadEventConfig) {
        boolean z;
        this.o = downloadEventConfig;
        if (l().getDownloadScene() == 0) {
            z = true;
        } else {
            z = false;
        }
        this.r = z;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        return this;
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
                com.ss.android.downloadad.api.a.b d = com.ss.android.downloadlib.addownload.b.f.a().d(this.m);
                if (d != null && d.l() != 3) {
                    d.e(3L);
                    com.ss.android.downloadlib.addownload.b.i.a().a(d);
                }
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void b(int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.c.a(this.m);
        if (!com.ss.android.downloadlib.addownload.b.f.a().e(this.m).y()) {
            com.ss.android.downloadlib.e.c.a().a("handleDownload ModelBox !isStrictValid");
        }
        if (!this.c.a(getContext(), i, this.r)) {
            boolean c2 = c(i);
            if (i != 1) {
                if (i == 2 && !c2) {
                    String str = a;
                    com.ss.android.downloadlib.g.k.a(str, "handleDownload id:" + this.m + ",pBC:", null);
                    b(true);
                }
            } else if (!c2) {
                String str2 = a;
                com.ss.android.downloadlib.g.k.a(str2, "handleDownload id:" + this.m + ",pIC:", null);
                c(true);
            }
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(long j) {
        if (j != 0) {
            DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j);
            if (a2 != null) {
                this.n = a2;
                this.m = j;
                this.c.a(j);
            }
        } else {
            com.ss.android.downloadlib.e.c.a().a(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.t = null;
        } else {
            this.t = new SoftReference(iDownloadButtonClickListener);
        }
        return this;
    }

    public void b(boolean z) {
        e(z);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.q = null;
        } else {
            this.q = new SoftReference(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a() {
        this.k = true;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
        com.ss.android.downloadlib.addownload.b.f.a().a(this.m, m());
        this.c.a(this.m);
        p();
        if (j.i().optInt("enable_empty_listener", 1) == 1 && this.f.get(Integer.MIN_VALUE) == null) {
            b(Integer.MIN_VALUE, new com.ss.android.download.api.config.a());
        }
    }

    public boolean e() {
        if (j.i().optInt("quick_app_enable_switch", 0) != 0 || this.n.getQuickAppModel() == null || TextUtils.isEmpty(this.n.getQuickAppModel().a()) || !com.ss.android.downloadlib.addownload.c.a(this.h) || !com.ss.android.downloadlib.g.l.a(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.n.getQuickAppModel().a())))) {
            return false;
        }
        return true;
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        if (message != null && this.k && message.what == 3) {
            this.h = (DownloadInfo) message.obj;
            this.c.a(message, q(), this.f);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a(boolean z) {
        if (this.h != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.c.d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
                if (b2 != null) {
                    b2.a(this.h);
                }
                Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(this.h.getId(), true);
                return;
            }
            Intent intent = new Intent(j.getContext(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.h.getId());
            j.getContext().startService(intent);
        }
    }

    public void a(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.d.a.a().a(this.m, 2);
        }
        if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE") && !m().enableNewActivity()) {
            this.n.setFilePath(this.c.b());
        }
        if (com.ss.android.downloadlib.g.e.c(this.n) == 0) {
            com.ss.android.downloadlib.g.k.a(a, "pBCD not start", null);
            this.c.a(new s() { // from class: com.ss.android.downloadlib.addownload.e.4
                @Override // com.ss.android.download.api.config.s
                public void a() {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD start download", null);
                    e.this.g(z2);
                }

                @Override // com.ss.android.download.api.config.s
                public void a(String str) {
                    com.ss.android.downloadlib.g.k.a(e.a, "pBCD onDenied", null);
                }
            });
            return;
        }
        g(z2);
    }

    public boolean d(boolean z) {
        SoftReference softReference = this.t;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    ((IDownloadButtonClickListener) this.t.get()).handleComplianceDialog(true);
                } else {
                    ((IDownloadButtonClickListener) this.t.get()).handleMarketFailedComplianceDialog();
                }
                this.t = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
        return false;
    }
}
