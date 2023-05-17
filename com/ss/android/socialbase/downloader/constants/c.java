package com.ss.android.socialbase.downloader.constants;

import com.baidu.searchbox.pms.db.PackageTable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
/* loaded from: classes10.dex */
public interface c {
    public static final String[] a = {"_id", "url", "savePath", "tempPath", "name", "chunkCount", "status", "curBytes", "totalBytes", "eTag", "onlyWifi", TTDownloadField.TT_FORCE, "retryCount", "extra", "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", "packageName", PackageTable.MD5, "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", "taskId"};
    public static final String[] b = {"_id"};
    public static final String[] c = {"_id", "chunkIndex", "startOffset", "curOffset", "endOffset", "chunkContentLen", "hostChunkIndex"};
    public static final String[] d = {"_id"};
    public static final String[] e = {"_id", "info"};
    public static final String[] f = {"_id"};
}
