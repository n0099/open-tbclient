package com.ss.android.socialbase.downloader.constants;

import com.baidu.searchbox.pms.db.PackageTable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.core.RemoteViewBuilder;
/* loaded from: classes2.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f70086a = {"_id", "url", "savePath", "tempPath", "name", "chunkCount", "status", "curBytes", "totalBytes", "eTag", "onlyWifi", TTDownloadField.TT_FORCE, "retryCount", "extra", "mimeType", "title", "notificationEnable", "notificationVisibility", "isFirstDownload", "isFirstSuccess", "needHttpsToHttpRetry", "downloadTime", "packageName", PackageTable.MD5, "retryDelay", "curRetryTime", "retryDelayStatus", "defaultHttpServiceBackUp", "chunkRunnableReuse", "retryDelayTimeArray", "chunkDowngradeRetry", "backUpUrlsStr", "backUpUrlRetryCount", "realDownloadTime", "retryScheduleMinutes", "independentProcess", "auxiliaryJsonobjectString", "iconUrl", "appVersionCode", RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f70087b = {"_id"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f70088c = {"_id", "chunkIndex", "startOffset", "curOffset", "endOffset", "chunkContentLen", "hostChunkIndex"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f70089d = {"_id"};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f70090e = {"_id", "info"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f70091f = {"_id"};
}
