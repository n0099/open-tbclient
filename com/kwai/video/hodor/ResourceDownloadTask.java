package com.kwai.video.hodor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import com.kwai.video.hodor.util.Timber;
import java.util.Map;
/* loaded from: classes3.dex */
public class ResourceDownloadTask extends AbstractHodorTask {
    public static final int ResourceDirEvictStrategy_Auto = 1;
    public static final int ResourceDirEvictStrategy_Manual = 0;
    public static final int SaveMode_CopyAfterDownload = 2;
    public static final int SaveMode_MoveAfterDownload = 1;
    public static final int SaveMode_NonExport = 0;
    private static final int SaveMode_Unset = -1;
    @AccessedByNative
    private final String mCacheKey;
    @AccessedByNative
    private final String mHttpHeadersString;
    private ResourceDownloadCallback mResourceDownloadCallback;
    @AccessedByNative
    private final String mUrl;
    @AccessedByNative
    private String mExpectSavePath = "";
    @AccessedByNative
    private int mSaveMode = -1;
    @AccessedByNative
    private int mEvictStrategy = 0;
    @AccessedByNative
    private boolean mDeleteCacheOnCancel = false;
    private long mStepDownloadBytes = -1;
    @AccessedByNative
    private int mProgressCallbackIntervalMs = 200;
    @AccessedByNative
    private int mReadTimeoutSec = 10;
    @AccessedByNative
    private boolean mUpdatePriorityIfExist = false;
    private boolean setPathBefore = false;
    @AccessedByNative
    private AwesomeCacheCallback mAwesomeCacheCallback = new AwesomeCacheCallback() { // from class: com.kwai.video.hodor.ResourceDownloadTask.1
        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            ResourceDownloadTask.this.mTaskInfo.copyInfoAfterDownload(acCallBackInfo);
            ResourceDownloadCallback resourceDownloadCallback = ResourceDownloadTask.this.mResourceDownloadCallback;
            if (resourceDownloadCallback != null) {
                resourceDownloadCallback.onCdnReport(ResourceDownloadTask.this.mTaskInfo);
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            if (!ResourceDownloadTask.this.setPathBefore) {
                if (TextUtils.isEmpty(ResourceDownloadTask.this.mExpectSavePath)) {
                    ResourceDownloadTask.this.mTaskInfo.cacheFilePath = ResourceDownloadTask.this.getInnerCacheFilePath();
                } else {
                    ResourceDownloadTask.this.mTaskInfo.cacheFilePath = ResourceDownloadTask.this.mExpectSavePath;
                }
                ResourceDownloadTask.this.setPathBefore = true;
            }
            ResourceDownloadTask.this.mTaskInfo.copyInfoInProgress(acCallBackInfo);
            ResourceDownloadCallback resourceDownloadCallback = ResourceDownloadTask.this.mResourceDownloadCallback;
            if (resourceDownloadCallback != null) {
                resourceDownloadCallback.onTaskStatusChanged(ResourceDownloadTask.this.mTaskInfo);
            }
        }
    };
    private TaskInfo mTaskInfo = new TaskInfo();

    /* loaded from: classes3.dex */
    public @interface ResourceDirEvictStrategy {
    }

    /* loaded from: classes3.dex */
    public interface ResourceDownloadCallback {
        void onCdnReport(TaskInfo taskInfo);

        void onTaskStatusChanged(TaskInfo taskInfo);
    }

    /* loaded from: classes3.dex */
    public @interface SaveMode {
    }

    /* loaded from: classes3.dex */
    public static class TaskInfo extends BaseTaskInfo {
        private String cacheFilePath = "";
        private boolean loadFromCache;

        public void debugPrintTaskStatus(int i, String str) {
            Timber.log(i, "%s loadFromCache:%b, complete:%b,cacheFilePath:%s, currentUrl:%s", str, Boolean.valueOf(this.loadFromCache), Boolean.valueOf(isComplete()), this.cacheFilePath, this.currentUrl);
        }

        public String getCacheFilePath() {
            return this.cacheFilePath;
        }

        public boolean isLoadFromCache() {
            return this.loadFromCache;
        }
    }

    public ResourceDownloadTask(@NonNull String str, @Nullable Map<String, String> map, @Nullable String str2) {
        this.mUrl = str;
        this.mHttpHeadersString = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mCacheKey = str2;
        setTaskQosClass(0);
        setPriority(3000);
        this.mTaskInfo.loadFromCache = Hodor.instance().isFullyCached(str2, 1);
    }

    public static native long getCachedBytes(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native String getInnerCacheFilePath();

    public static native long getTotalBytes(String str);

    public native void abandon();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void cancel();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void pause();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        throw new UnsupportedOperationException("not support operation, use setResourceDownloadCallback instead");
    }

    public void setDeleteCacheOnCancel(boolean z) {
        this.mDeleteCacheOnCancel = z;
    }

    public void setEvictStrategy(@ResourceDirEvictStrategy int i) {
        this.mEvictStrategy = i;
    }

    public void setExpectSavePath(String str) {
        this.mExpectSavePath = str;
    }

    public void setProgressCallbackIntervalMs(int i) {
        this.mProgressCallbackIntervalMs = i;
    }

    public void setReadTimeout(int i) {
        this.mReadTimeoutSec = i;
    }

    public void setResourceDownloadCallback(ResourceDownloadCallback resourceDownloadCallback) {
        this.mResourceDownloadCallback = resourceDownloadCallback;
    }

    public void setSaveMode(@SaveMode int i) {
        this.mSaveMode = i;
    }

    public void setStepDownloadBytes(long j) {
        this.mStepDownloadBytes = j;
    }

    public void setUpdatePriorityIfExist(boolean z) {
        this.mUpdatePriorityIfExist = z;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();
}
