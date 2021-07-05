package com.kwai.video.hodor;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.IHodorTask;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import com.kwai.video.hodor.util.Timber;
import java.util.HashMap;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class MediaPreloadPriorityTask extends AbstractHodorPreloadTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @AccessedByNative
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    public final String mCacheKey;
    @IHodorTask.MediaDirEvictStrategy
    @AccessedByNative
    public int mEvictStrategy;
    @AccessedByNative
    public final String mHttpHeaders;
    @AccessedByNative
    public String mMd5HashCode;
    @AccessedByNative
    public long mPreloadBytes;
    @AccessedByNative
    public final String mUrl;

    public MediaPreloadPriorityTask(@NonNull String str, @Nullable Map<String, String> map, @Nullable String str2) {
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
        this.mPreloadBytes = 1048576L;
        this.mMd5HashCode = "";
        this.mEvictStrategy = 1;
        this.mUrl = str;
        this.mHttpHeaders = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mCacheKey = str2;
    }

    public static MediaPreloadPriorityTask newTaskWithHttpDns(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, str3)) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("Host", str2);
            }
            return new MediaPreloadPriorityTask(str, hashMap, str3);
        }
        return (MediaPreloadPriorityTask) invokeLLL.objValue;
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
            this.mAwesomeCacheCallback = awesomeCacheCallback;
        }
    }

    public void setEvictStrategy(@IHodorTask.MediaDirEvictStrategy int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mEvictStrategy = i2;
        }
    }

    public void setPreloadBytes(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.mPreloadBytes = j;
        }
    }

    public void setmMd5HashCode(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str == null) {
                Timber.e("setmMd5HashCode,input md5 is null invalid", new Object[0]);
            } else {
                this.mMd5HashCode = str;
            }
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public native void submit();
}
