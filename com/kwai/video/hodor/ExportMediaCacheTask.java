package com.kwai.video.hodor;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import com.kwai.video.hodor.util.Timber;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes6.dex */
public class ExportMediaCacheTask extends AbstractHodorTask {
    @AccessedByNative
    public final String mCacheKey;
    @AccessedByNative
    public final String mExportFilePath;
    public ExportMediaCacheTaskCallback mExportMediaCacheTaskCallback;
    @AccessedByNative
    public final String mHttpHeaders;
    @AccessedByNative
    public final String mUrl;
    @AccessedByNative
    public AwesomeCacheCallback mAwesomeCacheCallback = new AwesomeCacheCallback() { // from class: com.kwai.video.hodor.ExportMediaCacheTask.1
        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            ExportMediaCacheTask.this.mTaskInfo.copyInfoAfterDownload(acCallBackInfo);
            ExportMediaCacheTaskCallback exportMediaCacheTaskCallback = ExportMediaCacheTask.this.mExportMediaCacheTaskCallback;
            if (exportMediaCacheTaskCallback != null) {
                exportMediaCacheTaskCallback.onCdnReport(ExportMediaCacheTask.this.mTaskInfo);
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            ExportMediaCacheTask.this.mTaskInfo.copyInfoInProgress(acCallBackInfo);
            ExportMediaCacheTaskCallback exportMediaCacheTaskCallback = ExportMediaCacheTask.this.mExportMediaCacheTaskCallback;
            if (exportMediaCacheTaskCallback != null) {
                exportMediaCacheTaskCallback.onTaskStatusChanged(ExportMediaCacheTask.this.mTaskInfo);
            }
        }
    };
    public TaskInfo mTaskInfo = new TaskInfo();

    /* loaded from: classes6.dex */
    public interface ExportMediaCacheTaskCallback {
        void onCdnReport(TaskInfo taskInfo);

        void onTaskStatusChanged(TaskInfo taskInfo);
    }

    /* loaded from: classes6.dex */
    public static class TaskInfo extends BaseTaskInfo {
        public String cacheFilePath = "";
        public boolean loadFromCache;

        public void debugPrintTaskStatus(int i, String str) {
            Timber.log(i, "%s loadFromCache:%b, complete:%b,cacheFilePath:%s", str, Boolean.valueOf(this.loadFromCache), Boolean.valueOf(isComplete()), this.cacheFilePath);
        }

        public String getCacheFilePath() {
            return this.cacheFilePath;
        }

        public boolean isLoadFromCache() {
            return this.loadFromCache;
        }
    }

    public ExportMediaCacheTask(@NonNull String str, @Nullable Map<String, String> map, @Nullable String str2, @NonNull String str3) {
        this.mUrl = str;
        this.mHttpHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mCacheKey = str2;
        this.mExportFilePath = str3;
        setTaskQosClass(2);
        this.mTaskInfo.cacheFilePath = str3;
        this.mTaskInfo.loadFromCache = Hodor.instance().isFullyCached(str2, 0);
    }

    public static ExportMediaCacheTask newTaskWithHttpDns(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull String str4) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Host", str2);
        }
        return new ExportMediaCacheTask(str, hashMap, str3, str4);
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void cancel();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void pause();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        throw new UnsupportedOperationException("not support operation, use setExportMediaCacheTaskCallback instead");
    }

    public void setExportMediaCacheTaskCallback(ExportMediaCacheTaskCallback exportMediaCacheTaskCallback) {
        this.mExportMediaCacheTaskCallback = exportMediaCacheTaskCallback;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();
}
