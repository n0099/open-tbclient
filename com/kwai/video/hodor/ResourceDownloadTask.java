package com.kwai.video.hodor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import com.kwai.video.hodor.util.Timber;
import java.util.Map;
/* loaded from: classes7.dex */
public class ResourceDownloadTask extends AbstractHodorTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ResourceDirEvictStrategy_Auto = 1;
    public static final int ResourceDirEvictStrategy_Manual = 0;
    public static final int SaveMode_CopyAfterDownload = 2;
    public static final int SaveMode_MoveAfterDownload = 1;
    public static final int SaveMode_NonExport = 0;
    public static final int SaveMode_Unset = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @AccessedByNative
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    public final String mCacheKey;
    @AccessedByNative
    public boolean mDeleteCacheOnCancel;
    @AccessedByNative
    public int mEvictStrategy;
    @AccessedByNative
    public String mExpectSavePath;
    @AccessedByNative
    public final String mHttpHeadersString;
    @AccessedByNative
    public int mProgressCallbackIntervalMs;
    @AccessedByNative
    public int mReadTimeoutSec;
    public ResourceDownloadCallback mResourceDownloadCallback;
    @AccessedByNative
    public int mSaveMode;
    public long mStepDownloadBytes;
    public TaskInfo mTaskInfo;
    @AccessedByNative
    public boolean mUpdatePriorityIfExist;
    @AccessedByNative
    public final String mUrl;
    public boolean setPathBefore;

    /* loaded from: classes7.dex */
    public @interface ResourceDirEvictStrategy {
    }

    /* loaded from: classes7.dex */
    public interface ResourceDownloadCallback {
        void onCdnReport(TaskInfo taskInfo);

        void onTaskStatusChanged(TaskInfo taskInfo);
    }

    /* loaded from: classes7.dex */
    public @interface SaveMode {
    }

    /* loaded from: classes7.dex */
    public static class TaskInfo extends BaseTaskInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String cacheFilePath;
        public boolean loadFromCache;

        public TaskInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cacheFilePath = "";
        }

        public void debugPrintTaskStatus(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                Timber.log(i2, "%s loadFromCache:%b, complete:%b,cacheFilePath:%s, currentUrl:%s", str, Boolean.valueOf(this.loadFromCache), Boolean.valueOf(isComplete()), this.cacheFilePath, this.currentUrl);
            }
        }

        public String getCacheFilePath() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.cacheFilePath : (String) invokeV.objValue;
        }

        public boolean isLoadFromCache() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.loadFromCache : invokeV.booleanValue;
        }
    }

    public ResourceDownloadTask(@NonNull String str, @Nullable Map<String, String> map, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExpectSavePath = "";
        this.mSaveMode = -1;
        this.mEvictStrategy = 0;
        this.mDeleteCacheOnCancel = false;
        this.mStepDownloadBytes = -1L;
        this.mProgressCallbackIntervalMs = 200;
        this.mReadTimeoutSec = 10;
        this.mUpdatePriorityIfExist = false;
        this.setPathBefore = false;
        this.mAwesomeCacheCallback = new AwesomeCacheCallback(this) { // from class: com.kwai.video.hodor.ResourceDownloadTask.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResourceDownloadTask this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.kwai.video.cache.AwesomeCacheCallback
            public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, acCallBackInfo) == null) {
                    this.this$0.mTaskInfo.copyInfoAfterDownload(acCallBackInfo);
                    ResourceDownloadCallback resourceDownloadCallback = this.this$0.mResourceDownloadCallback;
                    if (resourceDownloadCallback != null) {
                        resourceDownloadCallback.onCdnReport(this.this$0.mTaskInfo);
                    }
                }
            }

            @Override // com.kwai.video.cache.AwesomeCacheCallback
            public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
                TaskInfo taskInfo;
                String str3;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acCallBackInfo) == null) {
                    if (!this.this$0.setPathBefore) {
                        if (TextUtils.isEmpty(this.this$0.mExpectSavePath)) {
                            taskInfo = this.this$0.mTaskInfo;
                            str3 = this.this$0.getInnerCacheFilePath();
                        } else {
                            taskInfo = this.this$0.mTaskInfo;
                            str3 = this.this$0.mExpectSavePath;
                        }
                        taskInfo.cacheFilePath = str3;
                        this.this$0.setPathBefore = true;
                    }
                    this.this$0.mTaskInfo.copyInfoInProgress(acCallBackInfo);
                    ResourceDownloadCallback resourceDownloadCallback = this.this$0.mResourceDownloadCallback;
                    if (resourceDownloadCallback != null) {
                        resourceDownloadCallback.onTaskStatusChanged(this.this$0.mTaskInfo);
                    }
                }
            }
        };
        this.mTaskInfo = new TaskInfo();
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, awesomeCacheCallback) == null) {
            throw new UnsupportedOperationException("not support operation, use setResourceDownloadCallback instead");
        }
    }

    public void setDeleteCacheOnCancel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mDeleteCacheOnCancel = z;
        }
    }

    public void setEvictStrategy(@ResourceDirEvictStrategy int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.mEvictStrategy = i2;
        }
    }

    public void setExpectSavePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mExpectSavePath = str;
        }
    }

    public void setProgressCallbackIntervalMs(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.mProgressCallbackIntervalMs = i2;
        }
    }

    public void setReadTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.mReadTimeoutSec = i2;
        }
    }

    public void setResourceDownloadCallback(ResourceDownloadCallback resourceDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, resourceDownloadCallback) == null) {
            this.mResourceDownloadCallback = resourceDownloadCallback;
        }
    }

    public void setSaveMode(@SaveMode int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.mSaveMode = i2;
        }
    }

    public void setStepDownloadBytes(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.mStepDownloadBytes = j;
        }
    }

    public void setUpdatePriorityIfExist(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mUpdatePriorityIfExist = z;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();
}
