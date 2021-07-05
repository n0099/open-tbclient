package com.kwai.video.cache;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCache;
/* loaded from: classes7.dex */
public class OfflineCacheTaskBuilder extends OfflineCacheTaskBuilderBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OfflineCacheTaskBuilder(String str, String str2, String str3, AwesomeCacheCallback awesomeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, awesomeCacheCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        AwesomeCache.OfflineCacheDataSpec offlineCacheDataSpec = this.mDataSpec;
        offlineCacheDataSpec.url = str;
        offlineCacheDataSpec.host = str3;
        offlineCacheDataSpec.key = str2;
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public OfflineCacheVodTask build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AwesomeCache.newOfflineCacheVodFileTask(this.mDataSpec, this.mAwesomeCacheCallback) : (OfflineCacheVodTask) invokeV.objValue;
    }
}
