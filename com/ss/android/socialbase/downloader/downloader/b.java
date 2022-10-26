package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public String globalDefaultSavePath;
    public String globalDefaultSaveTempPath;

    public void destoryDownloader() {
        c.a();
    }

    public List getAllDownloadInfo() {
        return d.a().e();
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public r getReserveWifiStatusListener() {
        return c.Q();
    }

    public boolean isDownloadCacheSyncSuccess() {
        return d.a().f();
    }

    public boolean isHttpServiceInit() {
        return d.a().d();
    }

    public void pauseAll() {
        d.a().c();
    }

    public void setDownloadInMultiProcess() {
        if (com.ss.android.socialbase.downloader.i.a.a(4194304)) {
            synchronized (this) {
                c.b();
            }
            return;
        }
        c.b();
    }

    private File getGlobalSaveDir(String str, boolean z) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    public void cancel(int i, boolean z) {
        d.a().c(i, z);
    }

    public void clearDownloadData(int i, boolean z) {
        d.a().d(i, z);
    }

    public int getDownloadId(String str, String str2) {
        return d.a().a(str, str2);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return d.a().b(str, str2);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    public void setDownloadNotificationEventListener(int i, z zVar) {
        d.a().a(i, zVar);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void setThrottleNetSpeed(int i, long j) {
        d.a().a(i, j);
    }

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public boolean canResume(int i) {
        return d.a().e(i);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void clearDownloadData(int i) {
        d.a().d(i, true);
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        d.a().n(i);
    }

    public long getCurBytes(int i) {
        return d.a().h(i);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return d.a().r(i);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return d.a().k(i);
    }

    public List getDownloadInfoList(String str) {
        return d.a().a(str);
    }

    public z getDownloadNotificationEventListener(int i) {
        return d.a().l(i);
    }

    public List getDownloadingDownloadInfosWithMimeType(String str) {
        return d.a().e(str);
    }

    public List getFailedDownloadInfosWithMimeType(String str) {
        return d.a().b(str);
    }

    public int getStatus(int i) {
        return d.a().i(i);
    }

    public List getSuccessedDownloadInfosWithMimeType(String str) {
        return d.a().c(str);
    }

    public List getUnCompletedDownloadInfosWithMimeType(String str) {
        return d.a().d(str);
    }

    public boolean isDownloadServiceForeground(int i) {
        return d.a().c(i).b();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return d.a().a(downloadInfo);
    }

    public boolean isDownloading(int i) {
        boolean j;
        if (com.ss.android.socialbase.downloader.i.a.a(4194304)) {
            synchronized (this) {
                j = d.a().j(i);
            }
            return j;
        }
        return d.a().j(i);
    }

    public void pause(int i) {
        d.a().d(i);
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        d.a().a(kVar);
    }

    public void registerDownloaderProcessConnectedListener(ac acVar) {
        d.a().a(acVar);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        d.a().a(i, null, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        d.a().a(i, null, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        d.a().a(i, null, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void restart(int i) {
        d.a().g(i);
    }

    public void restartAllFailedDownloadTasks(List list) {
        d.a().a(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        d.a().b(list);
    }

    public void resume(int i) {
        d.a().f(i);
    }

    public void setDefaultSavePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.globalDefaultSavePath = str;
        }
    }

    public void setDefaultSaveTempPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.globalDefaultSaveTempPath = str;
        }
    }

    public void setLogLevel(int i) {
        d.a().p(i);
    }

    public void setReserveWifiStatusListener(r rVar) {
        c.a(rVar);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        d.a().b(kVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ac acVar) {
        d.a().b(acVar);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true, z);
    }
}
