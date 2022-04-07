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
/* loaded from: classes7.dex */
public class g implements m.a {
    public long a;
    public com.ss.android.downloadlib.addownload.b.e b;
    public boolean c = false;
    public e d;
    public b e;

    /* loaded from: classes7.dex */
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

        private void a(DownloadInfo downloadInfo, int i) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i;
            this.a.sendMessage(obtain);
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(DownloadInfo downloadInfo);
    }

    public g(e eVar) {
        this.d = eVar;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        DownloadModel downloadModel = this.b.b;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.b.b.getDownloadUrl())) ? false : true;
    }

    private boolean e() {
        return this.b.d.isAddToDownloadManage();
    }

    private boolean f() {
        return com.ss.android.downloadlib.g.l.a(this.b.b) && h.a(this.b.d.getLinkMode());
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
    }

    private boolean e(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.g.l.a(this.b.b) && f(downloadInfo);
    }

    private boolean f(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && com.ss.android.socialbase.downloader.i.f.d(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public void a(long j) {
        this.a = j;
        com.ss.android.downloadlib.addownload.b.e e = com.ss.android.downloadlib.addownload.b.f.a().e(j);
        this.b = e;
        if (e.x()) {
            com.ss.android.downloadlib.e.c.a().a("setAdId ModelBox notValid");
        }
    }

    public void b(@Nullable DownloadInfo downloadInfo) {
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(downloadInfo);
            this.e = null;
        }
    }

    public void c(DownloadInfo downloadInfo) {
        if (!h.a(this.b.b) || this.c) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("file_status", (downloadInfo == null || !com.ss.android.downloadlib.g.l.b(downloadInfo.getTargetFilePath())) ? 2 : 1, this.b);
        this.c = true;
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
        this.c = false;
        b(downloadInfo);
    }

    public boolean a(Context context, int i, boolean z) {
        if (com.ss.android.downloadlib.g.l.a(this.b.b)) {
            com.ss.android.downloadad.api.a.b d = com.ss.android.downloadlib.addownload.b.f.a().d(this.b.a);
            if (d != null) {
                com.ss.android.socialbase.downloader.notification.b.a().f(d.s());
            }
            return com.ss.android.downloadlib.b.a.a(this.b);
        } else if (a(i) && !TextUtils.isEmpty(this.b.b.getPackageName()) && j.i().optInt("disable_market") != 1) {
            return com.ss.android.downloadlib.b.a.a(this.b, i);
        } else {
            if (z && this.b.d.getDownloadMode() == 4 && !this.d.e()) {
                this.d.c(true);
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

    private boolean a(int i) {
        if (this.b.d.getDownloadMode() == 2 && i == 2) {
            return true;
        }
        return this.b.d.getDownloadMode() == 2 && i == 1 && j.i().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean a(boolean z) {
        return !z && this.b.d.getDownloadMode() == 1;
    }

    public void a(@NonNull final s sVar) {
        if (!TextUtils.isEmpty(this.b.b.getFilePath())) {
            String filePath = this.b.b.getFilePath();
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
                j.c().a(1, j.getContext(), g.this.b.b, "您已禁止使用存储权限，请授权后再下载", null, 1);
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
        int i = message.arg1;
        if (i != 1 && i != 6 && i == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.f a2 = com.ss.android.downloadlib.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.b;
                a2.a(eVar.b, eVar.d, eVar.c);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.d.a.a().a(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        i.a(downloadShortInfo);
        int a3 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int i2 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
        int curBytes = i2 > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((i2 > 0 || com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) && (bVar = this.e) != null) {
            bVar.a(downloadInfo);
            this.e = null;
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
                        if (com.ss.android.downloadlib.g.l.a(this.b.b)) {
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
        if (this.e == null) {
            this.e = new b() { // from class: com.ss.android.downloadlib.addownload.g.3
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
        Map<String, String> headers = this.b.b.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        String a2 = com.ss.android.downloadlib.g.d.a(String.valueOf(this.b.b.getId()), this.b.b.getNotificationJumpUrl(), this.b.b.isShowToast(), String.valueOf(this.b.b.getModelType()));
        com.ss.android.socialbase.downloader.g.a b2 = com.ss.android.downloadlib.g.e.b(this.b.b);
        JSONObject a3 = com.ss.android.downloadlib.g.e.a(this.b.b);
        if (!this.b.d.enableAH()) {
            a3 = com.ss.android.downloadlib.g.l.a(a3);
            com.ss.android.downloadlib.g.l.a(a3, "ah_plans", new JSONArray());
        }
        this.b.b.getExecutorGroup();
        int i = (this.b.b.isAd() || h.b(this.b.b)) ? 4 : 4;
        String a4 = a(b2);
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(com.ss.android.socialbase.downloader.downloader.c.a(this.b.b.getDownloadUrl(), a4));
        if (downloadInfo != null && 3 == this.b.b.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.f o = new com.ss.android.socialbase.appdownloader.f(context, this.b.b.getDownloadUrl()).b(this.b.b.getBackupUrls()).a(this.b.b.getName()).d(a2).a(arrayList).a(this.b.b.isShowNotification()).c(this.b.b.isNeedWifi()).b(this.b.b.getFileName()).c(a4).j(this.b.b.getAppIcon()).g(this.b.b.getMd5()).i(this.b.b.getSdkMonitorScene()).a(this.b.b.getExpectFileLength()).a(iDownloadListener).l(this.b.b.needIndependentProcess() || b2.a("need_independent_process", 0) == 1).a(this.b.b.getDownloadFileUriProvider()).b(this.b.b.autoInstallWithoutNotification()).f(this.b.b.getPackageName()).d(1000).e(100).a(a3).i(true).j(true).b(b2.a("retry_count", 5)).c(b2.a("backup_url_retry_count", 0)).j(true).m(b2.a("need_head_connection", 0) == 1).d(b2.a("need_https_to_http_retry", 0) == 1).h(b2.a("need_chunk_downgrade_retry", 1) == 1).g(b2.a("need_retry_delay", 0) == 1).h(b2.c("retry_delay_time_array")).k(b2.a("need_reuse_runnable", 0) == 1).f(i).p(this.b.b.isAutoInstall()).o(this.b.b.distinctDir());
        if (!TextUtils.isEmpty(this.b.b.getMimeType())) {
            o.e(this.b.b.getMimeType());
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
        int a5 = h.a(this.b, c(), o);
        if (aVar != null) {
            aVar.a(a5);
        }
        return a5;
    }

    private String a(com.ss.android.socialbase.downloader.g.a aVar) {
        if (!TextUtils.isEmpty(this.b.b.getFilePath())) {
            return this.b.b.getFilePath();
        }
        DownloadInfo a2 = com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), this.b.b.getDownloadUrl());
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(a2.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(b2 ? 1 : 2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("label_external_permission", jSONObject, this.b);
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
        if (this.b.b == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (h.a(this.b.b)) {
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
                com.ss.android.downloadlib.addownload.b.e eVar = this.b;
                a2.a(new com.ss.android.downloadad.api.a.b(eVar.b, eVar.c, eVar.d, downloadInfo.getId()));
                return;
            case -3:
                if (com.ss.android.downloadlib.g.l.a(this.b.b)) {
                    com.ss.android.downloadlib.e.c.a().b("SUCCESSED isInstalledApp");
                    return;
                }
                com.ss.android.downloadlib.d.a.a().a(this.a, 5, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.a, this.b.b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.a, 2);
                    return;
                }
                return;
            case -2:
                com.ss.android.downloadlib.d.a.a().a(this.a, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.a, this.b.b.getLogExtra())) {
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
        int i;
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (downloadInfo.getTotalBytes() > 0) {
                i = (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes());
                int i2 = i >= 0 ? i : 0;
                downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
                i.a(downloadShortInfo);
                for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                    switch (downloadInfo.getStatus()) {
                        case -4:
                        case 0:
                            if (com.ss.android.downloadlib.g.l.a(this.b.b)) {
                                downloadShortInfo.status = -3;
                                downloadStatusChangeListener.onInstalled(downloadShortInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onIdle();
                                break;
                            }
                        case -3:
                            if (com.ss.android.downloadlib.g.l.a(this.b.b)) {
                                downloadStatusChangeListener.onInstalled(downloadShortInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                                break;
                            }
                        case -2:
                            downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, i.a(downloadInfo.getId(), i2));
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
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i2));
                            break;
                        case 11:
                            if (downloadStatusChangeListener instanceof com.ss.android.download.api.download.a) {
                                ((com.ss.android.download.api.download.a) downloadStatusChangeListener).a(downloadInfo);
                                break;
                            } else {
                                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, i.a(downloadInfo.getId(), i2));
                                break;
                            }
                    }
                }
                return;
            }
            i = 0;
            if (i >= 0) {
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
