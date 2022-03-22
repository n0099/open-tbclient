package com.ss.android.socialbase.downloader.constants;

import com.baidu.searchbox.pms.db.PackageTable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
/* loaded from: classes7.dex */
public interface c {
    public static final String[] a = {"_id", "url", "savePath", "tempPath", "name", "chunkCount", "status", "curBytes", "totalBytes", "eTag", "onlyWifi", TTDownloadField.TT_FORCE, "retryCount", "extra", "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", "packageName", PackageTable.MD5, "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", "taskId"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f43188b = {"_id"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f43189c = {"_id", "chunkIndex", "startOffset", "curOffset", "endOffset", "chunkContentLen", "hostChunkIndex"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f43190d = {"_id"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f43191e = {"_id", "info"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f43192f = {"_id"};
}
