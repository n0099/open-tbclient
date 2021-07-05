package com.kwai.video.hodor;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class ExportMediaCacheTask extends AbstractHodorTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @AccessedByNative
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    public final String mCacheKey;
    @AccessedByNative
    public final String mExportFilePath;
    public ExportMediaCacheTaskCallback mExportMediaCacheTaskCallback;
    @AccessedByNative
    public final String mHttpHeaders;
    public TaskInfo mTaskInfo;
    @AccessedByNative
    public final String mUrl;

    /* loaded from: classes7.dex */
    public interface ExportMediaCacheTaskCallback {
        void onCdnReport(TaskInfo taskInfo);

        void onTaskStatusChanged(TaskInfo taskInfo);
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
                Timber.log(i2, "%s loadFromCache:%b, complete:%b,cacheFilePath:%s", str, Boolean.valueOf(this.loadFromCache), Boolean.valueOf(isComplete()), this.cacheFilePath);
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

    public ExportMediaCacheTask(@NonNull String str, @Nullable Map<String, String> map, @Nullable String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAwesomeCacheCallback = new AwesomeCacheCallback(this) { // from class: com.kwai.video.hodor.ExportMediaCacheTask.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ExportMediaCacheTask this$0;

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
                    ExportMediaCacheTaskCallback exportMediaCacheTaskCallback = this.this$0.mExportMediaCacheTaskCallback;
                    if (exportMediaCacheTaskCallback != null) {
                        exportMediaCacheTaskCallback.onCdnReport(this.this$0.mTaskInfo);
                    }
                }
            }

            @Override // com.kwai.video.cache.AwesomeCacheCallback
            public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, acCallBackInfo) == null) {
                    this.this$0.mTaskInfo.copyInfoInProgress(acCallBackInfo);
                    ExportMediaCacheTaskCallback exportMediaCacheTaskCallback = this.this$0.mExportMediaCacheTaskCallback;
                    if (exportMediaCacheTaskCallback != null) {
                        exportMediaCacheTaskCallback.onTaskStatusChanged(this.this$0.mTaskInfo);
                    }
                }
            }
        };
        this.mTaskInfo = new TaskInfo();
        this.mUrl = str;
        this.mHttpHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mCacheKey = str2;
        this.mExportFilePath = str3;
        setTaskQosClass(2);
        this.mTaskInfo.cacheFilePath = str3;
        this.mTaskInfo.loadFromCache = Hodor.instance().isFullyCached(str2, 0);
    }

    public static ExportMediaCacheTask newTaskWithHttpDns(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, str3, str4)) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("Host", str2);
            }
            return new ExportMediaCacheTask(str, hashMap, str3, str4);
        }
        return (ExportMediaCacheTask) invokeLLLL.objValue;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void cancel();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void pause();

    @Override // com.kwai.video.hodor.IHodorTask
    public native void resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(AwesomeCacheCallback awesomeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, awesomeCacheCallback) == null) {
            throw new UnsupportedOperationException("not support operation, use setExportMediaCacheTaskCallback instead");
        }
    }

    public void setExportMediaCacheTaskCallback(ExportMediaCacheTaskCallback exportMediaCacheTaskCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, exportMediaCacheTaskCallback) == null) {
            this.mExportMediaCacheTaskCallback = exportMediaCacheTaskCallback;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();
}
