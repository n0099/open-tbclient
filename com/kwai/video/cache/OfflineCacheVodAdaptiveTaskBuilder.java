package com.kwai.video.cache;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCache;
/* loaded from: classes7.dex */
public class OfflineCacheVodAdaptiveTaskBuilder extends OfflineCacheTaskBuilderBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VodAdaptiveInit mVodAdaptiveInitValue;

    /* loaded from: classes7.dex */
    public static class VodAdaptiveInit {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int devResHeigh;
        public int devResWidth;
        public int lowDevice;
        public int manifestType;
        public int netType;
        public String rateConfig;
        public int signalStrength;

        public VodAdaptiveInit() {
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
            this.manifestType = 0;
        }
    }

    public OfflineCacheVodAdaptiveTaskBuilder(String str, VodAdaptiveInit vodAdaptiveInit, AwesomeCacheCallback awesomeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, vodAdaptiveInit, awesomeCacheCallback};
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
        offlineCacheDataSpec.host = "";
        offlineCacheDataSpec.key = "";
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = awesomeCacheCallback;
    }

    public OfflineCacheVodTask build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? AwesomeCache.newOfflineCacheVodAdaptiveTask(this.mDataSpec, this.mAwesomeCacheCallback, this.mVodAdaptiveInitValue) : (OfflineCacheVodTask) invokeV.objValue;
    }
}
