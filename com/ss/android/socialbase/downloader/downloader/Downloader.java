package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
/* loaded from: classes8.dex */
public class Downloader extends b {
    public static volatile Downloader instance;

    static {
        c.a(new v());
        instance = null;
    }

    public Downloader() {
    }

    public static Downloader getInstance(Context context) {
        if (instance == null) {
            synchronized (Downloader.class) {
                if (instance == null) {
                    c.a(context);
                    instance = new Downloader();
                }
            }
        }
        return instance;
    }

    public static synchronized void init(DownloaderBuilder downloaderBuilder) {
        synchronized (Downloader.class) {
            initOrCover(downloaderBuilder, false);
        }
    }

    public static synchronized void initOrCover(DownloaderBuilder downloaderBuilder, boolean z) {
        synchronized (Downloader.class) {
            if (downloaderBuilder == null) {
                return;
            }
            if (instance == null) {
                instance = downloaderBuilder.build();
            } else if (!c.R()) {
                c.a(downloaderBuilder);
            } else if (z) {
                c.b(downloaderBuilder);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void addMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.addMainThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void addNotificationListener(int i2, IDownloadListener iDownloadListener) {
        super.addNotificationListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void addSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.addSubThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean canResume(int i2) {
        return super.canResume(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void cancel(int i2) {
        super.cancel(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void clearDownloadData(int i2) {
        super.clearDownloadData(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void forceDownloadIngoreRecommendSize(int i2) {
        super.forceDownloadIngoreRecommendSize(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ long getCurBytes(int i2) {
        return super.getCurBytes(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int i2) {
        return super.getDownloadFileUriProvider(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ int getDownloadId(String str, String str2) {
        return super.getDownloadId(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int i2) {
        return super.getDownloadInfo(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String str) {
        return super.getDownloadInfoList(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ z getDownloadNotificationEventListener(int i2) {
        return super.getDownloadNotificationEventListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String str) {
        return super.getDownloadingDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getFailedDownloadInfosWithMimeType(String str) {
        return super.getFailedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ r getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ int getStatus(int i2) {
        return super.getStatus(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String str) {
        return super.getSuccessedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String str) {
        return super.getUnCompletedDownloadInfosWithMimeType(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloadServiceForeground(int i2) {
        return super.isDownloadServiceForeground(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return super.isDownloadSuccessAndFileNotExist(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isDownloading(int i2) {
        return super.isDownloading(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void pause(int i2) {
        super.pause(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        super.registerDownloadCacheSyncListener(kVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(ac acVar) {
        super.registerDownloaderProcessConnectedListener(acVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.removeMainThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void removeNotificationListener(int i2, IDownloadListener iDownloadListener) {
        super.removeNotificationListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.removeSubThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int i2) {
        super.removeTaskMainListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int i2) {
        super.removeTaskNotificationListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int i2) {
        super.removeTaskSubListener(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void restart(int i2) {
        super.restart(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List list) {
        super.restartAllFailedDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List list) {
        super.restartAllPauseReserveOnWifiDownloadTasks(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void resume(int i2) {
        super.resume(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String str) {
        super.setDefaultSavePath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String str) {
        super.setDefaultSaveTempPath(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int i2, z zVar) {
        super.setDownloadNotificationEventListener(i2, zVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setLogLevel(int i2) {
        super.setLogLevel(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.setMainThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setNotificationListener(int i2, IDownloadListener iDownloadListener) {
        super.setNotificationListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(r rVar) {
        super.setReserveWifiStatusListener(rVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setSubThreadListener(int i2, IDownloadListener iDownloadListener) {
        super.setSubThreadListener(i2, iDownloadListener);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int i2, long j2) {
        super.setThrottleNetSpeed(i2, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.k kVar) {
        super.unRegisterDownloadCacheSyncListener(kVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(ac acVar) {
        super.unRegisterDownloaderProcessConnectedListener(acVar);
    }

    public Downloader(DownloaderBuilder downloaderBuilder) {
        c.a(downloaderBuilder);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void cancel(int i2, boolean z) {
        super.cancel(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ void clearDownloadData(int i2, boolean z) {
        super.clearDownloadData(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String str, String str2) {
        return super.getDownloadInfo(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.b
    @Deprecated
    public /* bridge */ /* synthetic */ void setMainThreadListener(int i2, IDownloadListener iDownloadListener, boolean z) {
        super.setMainThreadListener(i2, iDownloadListener, z);
    }
}
