package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadlib.g.j;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class g implements m.a {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public com.ss.android.downloadlib.addownload.b.e f59594b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59595c = false;

    /* renamed from: d  reason: collision with root package name */
    public e f59596d;

    /* renamed from: e  reason: collision with root package name */
    public b f59597e;

    /* loaded from: classes4.dex */
    public static class a extends com.ss.android.socialbase.downloader.depend.a {
        public m a;

        public a(m mVar) {
            this.a = mVar;
        }

        @Override // com.ss.android.socialbase.downloader.depend.a, com.ss.android.socialbase.downloader.depend.s
        public void a(DownloadInfo downloadInfo) {
            a(downloadInfo, 11);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            a(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            a(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            a(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            a(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            a(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            a(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            a(downloadInfo, -3);
        }

        private void a(DownloadInfo downloadInfo, int i2) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i2;
            this.a.sendMessage(obtain);
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(DownloadInfo downloadInfo);
    }

    public g(e eVar) {
        this.f59596d = eVar;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        DownloadModel downloadModel = this.f59594b.f59509b;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f59594b.f59509b.getDownloadUrl())) ? false : true;
    }

    private boolean e() {
        return this.f59594b.f59511d.isAddToDownloadManage();
    }

    private boolean f() {
        return com.ss.android.downloadlib.g.l.a(this.f59594b.f59509b) && h.a(this.f59594b.f59511d.getLinkMode());
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
    }

    private boolean e(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.g.l.a(this.f59594b.f59509b) && f(downloadInfo);
    }

    private boolean f(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public void a(long j2) {
        this.a = j2;
        com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(j2);
        this.f59594b = e2;
        if (e2.x()) {
            com.ss.android.downloadlib.e.c.a().a("setAdId ModelBox notValid");
        }
    }

    public void b(@Nullable DownloadInfo downloadInfo) {
        b bVar = this.f59597e;
        if (bVar != null) {
            bVar.a(downloadInfo);
            this.f59597e = null;
        }
    }

    public void c(DownloadInfo downloadInfo) {
        if (!h.a(this.f59594b.f59509b) || this.f59595c) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("file_status", (downloadInfo == null || !com.ss.android.downloadlib.g.l.b(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f59594b);
        this.f59595c = true;
    }

    public boolean d(DownloadInfo downloadInfo) {
        return f() || e(downloadInfo);
    }

    private void b(final s sVar) {
        if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.ss.android.downloadlib.g.j.a(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new j.a() { // from class: com.ss.android.downloadlib.addownload.g.2
                @Override // com.ss.android.downloadlib.g.j.a
                public void a() {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.a();
                    }
                }

                @Override // com.ss.android.downloadlib.g.j.a
                public void a(String str) {
                    s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.a(str);
                    }
                }
            });
        } else if (sVar != null) {
            sVar.a();
        }
    }

    public void a(DownloadInfo downloadInfo) {
        this.f59595c = false;
        b(downloadInfo);
    }

    public boolean a(Context context, int i2, boolean z) {
        if (com.ss.android.downloadlib.g.l.a(this.f59594b.f59509b)) {
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(this.f59594b.a);
            if (d2 != null) {
                com.ss.android.socialbase.downloader.notification.b.a().f(d2.s());
            }
            return com.ss.android.downloadlib.b.a.a(this.f59594b);
        } else if (a(i2) && !TextUtils.isEmpty(this.f59594b.f59509b.getPackageName()) && j.i().optInt("disable_market") != 1) {
            return com.ss.android.downloadlib.b.a.a(this.f59594b, i2);
        } else {
            if (z && this.f59594b.f59511d.getDownloadMode() == 4 && !this.f59596d.e()) {
                this.f59596d.c(true);
                return true;
            }
            return false;
        }
    }

    @Nullable
    public String b() {
        File externalFilesDir = j.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            if (externalFilesDir.exists()) {
                return externalFilesDir.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.a> b(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.a) {
                    arrayList.add((com.ss.android.download.api.download.a) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof com.ss.android.download.api.download.a) {
                        arrayList.add((com.ss.android.download.api.download.a) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean a(int i2) {
        if (this.f59594b.f59511d.getDownloadMode() == 2 && i2 == 2) {
            return true;
        }
        return this.f59594b.f59511d.getDownloadMode() == 2 && i2 == 1 && j.i().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean a(boolean z) {
        return !z && this.f59594b.f59511d.getDownloadMode() == 1;
    }

    public void a(@NonNull final s sVar) {
        if (!TextUtils.isEmpty(this.f59594b.f59509b.getFilePath())) {
            String filePath = this.f59594b.f59509b.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                sVar.a();
                return;
            }
            try {
                if (filePath.startsWith(j.getContext().getExternalCacheDir().getParent())) {
                    sVar.a();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        b(new s() { // from class: com.ss.android.downloadlib.addownload.g.1
            @Override // com.ss.android.download.api.config.s
            public void a() {
                sVar.a();
            }

            @Override // com.ss.android.download.api.config.s
            public void a(String str) {
                j.c().a(1, j.getContext(), g.this.f59594b.f59509b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.d.a.a().b(g.this.a, 1);
                sVar.a(str);
            }
        });
    }

    public void a(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        b bVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i2 = message.arg1;
        if (i2 != 1 && i2 != 6 && i2 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.f a2 = com.ss.android.downloadlib.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f59594b;
                a2.a(eVar.f59509b, eVar.f59511d, eVar.f59510c);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.d.a.a().a(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        i.a(downloadShortInfo);
        int a3 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int i3 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
        int curBytes = i3 > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((i3 > 0 || com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) && (bVar = this.f59597e) != null) {
            bVar.a(downloadInfo);
            this.f59597e = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : a(map)) {
            if (a3 != 1) {
                if (a3 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, i.a(downloadInfo.getId(), curBytes));
                } else if (a3 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.g.l.a(this.f59594b.f59509b)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), curBytes));
            } else {
                for (com.ss.android.download.api.download.a aVar : b(map)) {
                    aVar.a(downloadInfo);
                }
            }
        }
    }

    public void a() {
        if (this.f59597e == null) {
            this.f59597e = new b() { // from class: com.ss.android.downloadlib.addownload.g.3
                @Override // com.ss.android.downloadlib.addownload.g.b
                public void a(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.d.a.a().a(g.this.a, 2, downloadInfo);
                }
            };
        }
    }

    public int a(Context context, IDownloadListener iDownloadListener) {
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f59594b.f59509b.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        String a2 = com.ss.android.downloadlib.g.d.a(String.valueOf(this.f59594b.f59509b.getId()), this.f59594b.f59509b.getNotificationJumpUrl(), this.f59594b.f59509b.isShowToast(), String.valueOf(this.f59594b.f59509b.getModelType()));
        com.ss.android.socialbase.downloader.g.a b2 = com.ss.android.downloadlib.g.e.b(this.f59594b.f59509b);
        JSONObject a3 = com.ss.android.downloadlib.g.e.a(this.f59594b.f59509b);
        if (!this.f59594b.f59511d.enableAH()) {
            a3 = com.ss.android.downloadlib.g.l.a(a3);
            com.ss.android.downloadlib.g.l.a(a3, "ah_plans", new JSONArray());
        }
        this.f59594b.f59509b.getExecutorGroup();
        int i2 = (this.f59594b.f59509b.isAd() || h.b(this.f59594b.f59509b)) ? 4 : 4;
        String a4 = a(b2);
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.c.a(this.f59594b.f59509b.getDownloadUrl(), a4));
        if (downloadInfo != null && 3 == this.f59594b.f59509b.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.f o = new com.ss.android.socialbase.appdownloader.f(context, this.f59594b.f59509b.getDownloadUrl()).b(this.f59594b.f59509b.getBackupUrls()).a(this.f59594b.f59509b.getName()).d(a2).a(arrayList).a(this.f59594b.f59509b.isShowNotification()).c(this.f59594b.f59509b.isNeedWifi()).b(this.f59594b.f59509b.getFileName()).c(a4).j(this.f59594b.f59509b.getAppIcon()).g(this.f59594b.f59509b.getMd5()).i(this.f59594b.f59509b.getSdkMonitorScene()).a(this.f59594b.f59509b.getExpectFileLength()).a(iDownloadListener).l(this.f59594b.f59509b.needIndependentProcess() || b2.a("need_independent_process", 0) == 1).a(this.f59594b.f59509b.getDownloadFileUriProvider()).b(this.f59594b.f59509b.autoInstallWithoutNotification()).f(this.f59594b.f59509b.getPackageName()).d(1000).e(100).a(a3).i(true).j(true).b(b2.a("retry_count", 5)).c(b2.a("backup_url_retry_count", 0)).j(true).m(b2.a("need_head_connection", 0) == 1).d(b2.a("need_https_to_http_retry", 0) == 1).h(b2.a("need_chunk_downgrade_retry", 1) == 1).g(b2.a("need_retry_delay", 0) == 1).h(b2.c("retry_delay_time_array")).k(b2.a("need_reuse_runnable", 0) == 1).f(i2).p(this.f59594b.f59509b.isAutoInstall()).o(this.f59594b.f59509b.distinctDir());
        if (!TextUtils.isEmpty(this.f59594b.f59509b.getMimeType())) {
            o.e(this.f59594b.f59509b.getMimeType());
        } else {
            o.e("application/vnd.android.package-archive");
        }
        if (b2.a("notification_opt_2", 0) == 1) {
            o.a(false);
            o.b(true);
        }
        com.ss.android.downloadlib.addownload.c.a aVar = null;
        if (b2.a("clear_space_use_disk_handler", 0) == 1) {
            aVar = new com.ss.android.downloadlib.addownload.c.a();
            o.a(aVar);
        }
        int a5 = h.a(this.f59594b, c(), o);
        if (aVar != null) {
            aVar.a(a5);
        }
        return a5;
    }

    private String a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (!TextUtils.isEmpty(this.f59594b.f59509b.getFilePath())) {
            return this.f59594b.f59509b.getFilePath();
        }
        DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), this.f59594b.f59509b.getDownloadUrl());
        boolean b2 = com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE");
        String b3 = b();
        if (a2 != null && !TextUtils.isEmpty(a2.getSavePath())) {
            String savePath = a2.getSavePath();
            if (b2 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(b3)) {
                    if (savePath.startsWith(b3)) {
                        return savePath;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(a2.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(b2 ? 1 : 2));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("label_external_permission", jSONObject, this.f59594b);
        String str = null;
        try {
            str = com.ss.android.socialbase.appdownloader.c.b();
        } catch (Exception unused) {
        }
        int a3 = com.ss.android.downloadlib.g.e.a(aVar);
        if (a3 != 0) {
            if (a3 != 4 && (b2 || a3 != 2)) {
                if ((a3 == 3 || (!b2 && a3 == 1)) && !TextUtils.isEmpty(b3)) {
                    return b3;
                }
            } else {
                File filesDir = j.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return str;
    }

    public void a(DownloadInfo downloadInfo, boolean z) {
        if (this.f59594b.f59509b == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (h.a(this.f59594b.f59509b)) {
                com.ss.android.downloadlib.d.a.a().a(this.a, 2);
            } else if (z && com.ss.android.downloadlib.d.c.a().c() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.d.a.a().a(this.a, 2);
            }
        } else {
            com.ss.android.downloadlib.d.a.a().a(this.a, 2);
        }
        switch (status) {
            case -4:
            case -1:
                a();
                com.ss.android.downloadlib.addownload.b.f a2 = com.ss.android.downloadlib.addownload.b.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f59594b;
                a2.a(new com.ss.android.downloadad.api.a.b(eVar.f59509b, eVar.f59510c, eVar.f59511d, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.g.l.a(this.f59594b.f59509b)) {
                    com.ss.android.downloadlib.e.c.a().b("SUCCESSED isInstalledApp");
                    return;
                }
                com.ss.android.downloadlib.d.a.a().a(this.a, 5, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.a, this.f59594b.f59509b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.a, 2);
                    return;
                }
                return;
            case -2:
                com.ss.android.downloadlib.d.a.a().a(this.a, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.a, this.f59594b.f59509b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.a, 2);
                    return;
                }
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.d.a.a().a(this.a, 3, downloadInfo);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list) {
        int i2;
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (downloadInfo.getTotalBytes() > 0) {
                i2 = (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes());
                int i3 = i2 >= 0 ? i2 : 0;
                downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
                i.a(downloadShortInfo);
                for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                    switch (downloadInfo.getStatus()) {
                        case -4:
                        case 0:
                            if (com.ss.android.downloadlib.g.l.a(this.f59594b.f59509b)) {
                                downloadShortInfo.status = -3;
                                downloadStatusChangeListener.onInstalled(downloadShortInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onIdle();
                                break;
                            }
                        case -3:
                            if (com.ss.android.downloadlib.g.l.a(this.f59594b.f59509b)) {
                                downloadStatusChangeListener.onInstalled(downloadShortInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                                break;
                            }
                        case -2:
                            downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, i.a(downloadInfo.getId(), i3));
                            break;
                        case -1:
                            downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                        case 8:
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i3));
                            break;
                        case 11:
                            if (downloadStatusChangeListener instanceof com.ss.android.download.api.download.a) {
                                ((com.ss.android.download.api.download.a) downloadStatusChangeListener).a(downloadInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i3));
                                break;
                            }
                    }
                }
                return;
            }
            i2 = 0;
            if (i2 >= 0) {
            }
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            i.a(downloadShortInfo);
            while (r9.hasNext()) {
            }
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener2 : list) {
            downloadStatusChangeListener2.onIdle();
        }
    }

    @NonNull
    public static List<DownloadStatusChangeListener> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof DownloadStatusChangeListener) {
                        arrayList.add((DownloadStatusChangeListener) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }
}
