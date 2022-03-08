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

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void addNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    public boolean canResume(int i2) {
        return d.a().e(i2);
    }

    public void cancel(int i2) {
        cancel(i2, true);
    }

    public void clearDownloadData(int i2) {
        d.a().d(i2, true);
    }

    public void destoryDownloader() {
        c.a();
    }

    public void forceDownloadIngoreRecommendSize(int i2) {
        d.a().n(i2);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return d.a().e();
    }

    public long getCurBytes(int i2) {
        return d.a().h(i2);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        return d.a().r(i2);
    }

    public int getDownloadId(String str, String str2) {
        return d.a().a(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i2) {
        return d.a().k(i2);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return d.a().a(str);
    }

    public z getDownloadNotificationEventListener(int i2) {
        return d.a().l(i2);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return d.a().e(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return d.a().b(str);
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

    public int getStatus(int i2) {
        return d.a().i(i2);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return d.a().c(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return d.a().d(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return d.a().f();
    }

    public boolean isDownloadServiceForeground(int i2) {
        return d.a().c(i2).b();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return d.a().a(downloadInfo);
    }

    public boolean isDownloading(int i2) {
        boolean j2;
        if (com.ss.android.socialbase.downloader.i.a.a(4194304)) {
            synchronized (this) {
                j2 = d.a().j(i2);
            }
            return j2;
        }
        return d.a().j(i2);
    }

    public boolean isHttpServiceInit() {
        return d.a().d();
    }

    public void pause(int i2) {
        d.a().d(i2);
    }

    public void pauseAll() {
        d.a().c();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        d.a().a(kVar);
    }

    public void registerDownloaderProcessConnectedListener(ac acVar) {
        d.a().a(acVar);
    }

    public void removeMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, false);
    }

    public void removeNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i2) {
        d.a().a(i2, null, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i2) {
        d.a().a(i2, null, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i2) {
        d.a().a(i2, null, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void restart(int i2) {
        d.a().g(i2);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        d.a().a(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        d.a().b(list);
    }

    public void resume(int i2) {
        d.a().f(i2);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
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

    public void setDownloadNotificationEventListener(int i2, z zVar) {
        d.a().a(i2, zVar);
    }

    public void setLogLevel(int i2) {
        d.a().p(i2);
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(r rVar) {
        c.a(rVar);
    }

    @Deprecated
    public void setSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().b(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.SUB, true);
    }

    public void setThrottleNetSpeed(int i2, long j2) {
        d.a().a(i2, j2);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        d.a().b(kVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ac acVar) {
        d.a().b(acVar);
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

    public void cancel(int i2, boolean z) {
        d.a().c(i2, z);
    }

    public void clearDownloadData(int i2, boolean z) {
        d.a().d(i2, z);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return d.a().b(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i2, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        d.a().a(i2, iDownloadListener, com.ss.android.socialbase.downloader.constants.f.MAIN, true, z);
    }
}
