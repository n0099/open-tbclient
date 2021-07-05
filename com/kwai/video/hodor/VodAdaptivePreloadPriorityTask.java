package com.kwai.video.hodor;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.hodor.anotations.AccessedByNative;
import com.kwai.video.hodor.util.HeaderUtil;
import java.util.Map;
/* loaded from: classes7.dex */
public class VodAdaptivePreloadPriorityTask extends AbstractHodorPreloadTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AwesomeCacheCallback mAwesomeCacheCallback;
    @AccessedByNative
    public String mCacheKey;
    public VodAdaptiveDataSpec mDataSpec;
    public VodAdaptiveInit mVodAdaptiveInitValue;

    /* loaded from: classes7.dex */
    public static class VodAdaptiveDataSpec {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long durMs;
        public String headers;
        public String manifestJson;
        public long preloadBytes;

        public VodAdaptiveDataSpec() {
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
            this.preloadBytes = 1048576L;
            this.durMs = -1L;
        }
    }

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
        public int switchCode;

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
            this.rateConfig = "";
            this.devResWidth = 720;
            this.devResHeigh = 1280;
            this.netType = 1;
            this.lowDevice = 0;
            this.signalStrength = 1;
            this.switchCode = 0;
            this.manifestType = 0;
        }
    }

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, vodAdaptiveInit};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        VodAdaptiveDataSpec vodAdaptiveDataSpec = new VodAdaptiveDataSpec();
        this.mDataSpec = vodAdaptiveDataSpec;
        vodAdaptiveDataSpec.manifestJson = str;
        vodAdaptiveDataSpec.headers = "";
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = null;
    }

    public VodAdaptivePreloadPriorityTask(String str, VodAdaptiveInit vodAdaptiveInit, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, vodAdaptiveInit, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        VodAdaptiveDataSpec vodAdaptiveDataSpec = new VodAdaptiveDataSpec();
        this.mDataSpec = vodAdaptiveDataSpec;
        vodAdaptiveDataSpec.manifestJson = str;
        vodAdaptiveDataSpec.headers = HeaderUtil.parseHeaderMapToFlatString(map);
        this.mVodAdaptiveInitValue = vodAdaptiveInit;
        this.mAwesomeCacheCallback = null;
    }

    private native void _cancel();

    private native void _submit(Object obj, Object obj2, Object obj3);

    public native void _pause();

    public native void _resume();

    @Override // com.kwai.video.hodor.IHodorTask
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            _cancel();
        }
    }

    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCacheKey : (String) invokeV.objValue;
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            _pause();
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            _resume();
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void setAwesomeCacheCallback(@NonNull AwesomeCacheCallback awesomeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, awesomeCacheCallback) == null) {
            this.mAwesomeCacheCallback = awesomeCacheCallback;
        }
    }

    public void setPreloadBytes(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.mDataSpec.preloadBytes = j;
        }
    }

    public void setPreloadDurationMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mDataSpec.durMs = j;
        }
    }

    @Override // com.kwai.video.hodor.IHodorTask
    public void submit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            _submit(this.mDataSpec, this.mVodAdaptiveInitValue, this.mAwesomeCacheCallback);
        }
    }
}
