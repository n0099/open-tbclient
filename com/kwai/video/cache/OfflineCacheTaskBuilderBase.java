package com.kwai.video.cache;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCache;
/* loaded from: classes7.dex */
public class OfflineCacheTaskBuilderBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CONNECT_TIMEOUT_MS = 3000;
    public static final int DEFAULT_READ_TIMEOUT_MS = 5000;
    public static final int DURATION_UNSET = -1;
    public static final int LENGTH_UNSET = -1;
    public static final int MAX_CONNECT_TIMEOUT_MS = 120000;
    public static final int MAX_READ_TIMEOUT_MS = 120000;
    public static final int MIN_CONNECT_TIMEOUT_MS = 500;
    public static final int MIN_READ_TIMEOUT_MS = 500;
    public static final int SOCKET_BUF_SIZE_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public AwesomeCacheCallback mAwesomeCacheCallback;
    public AwesomeCache.OfflineCacheDataSpec mDataSpec;

    public OfflineCacheTaskBuilderBase() {
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
        AwesomeCache.OfflineCacheDataSpec offlineCacheDataSpec = new AwesomeCache.OfflineCacheDataSpec();
        this.mDataSpec = offlineCacheDataSpec;
        offlineCacheDataSpec.cacheMode = 0;
        offlineCacheDataSpec.pos = 0L;
        offlineCacheDataSpec.len = -1L;
        offlineCacheDataSpec.durMs = -1L;
        offlineCacheDataSpec.connectTimeoutMs = 3000;
        offlineCacheDataSpec.readTimeoutMs = 5000;
        offlineCacheDataSpec.socketBufSizeKb = -1;
        offlineCacheDataSpec.maxSpeedKbps = -1;
        offlineCacheDataSpec.enableLimitSpeedWhenCancel = false;
        offlineCacheDataSpec.bandWidthThreshold = -1;
    }

    public OfflineCacheTaskBuilderBase enableLimitSpeedWhenCancel(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            if (z) {
                this.mDataSpec.enableLimitSpeedWhenCancel = z;
            }
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeZ.objValue;
    }

    public OfflineCacheTaskBuilderBase setBandWidthThreshold(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 > 0) {
                this.mDataSpec.bandWidthThreshold = i2;
            }
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeI.objValue;
    }

    public OfflineCacheTaskBuilderBase setCacheMode(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.mDataSpec.cacheMode = i2;
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeI.objValue;
    }

    public OfflineCacheTaskBuilderBase setConnectTimeoutMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 >= 500 && i2 <= 120000) {
                this.mDataSpec.connectTimeoutMs = i2;
            }
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeI.objValue;
    }

    public OfflineCacheTaskBuilderBase setLen(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            this.mDataSpec.len = j;
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeJ.objValue;
    }

    public OfflineCacheTaskBuilderBase setMaxSpeedKbps(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 > 0) {
                this.mDataSpec.maxSpeedKbps = i2;
            }
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeI.objValue;
    }

    public OfflineCacheTaskBuilderBase setPos(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            this.mDataSpec.pos = j;
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeJ.objValue;
    }

    public OfflineCacheTaskBuilderBase setPreloadDurationMs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) {
            this.mDataSpec.durMs = j;
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeJ.objValue;
    }

    public OfflineCacheTaskBuilderBase setReadTimeoutMs(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 >= 500 && i2 <= 120000) {
                this.mDataSpec.readTimeoutMs = i2;
            }
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeI.objValue;
    }

    public OfflineCacheTaskBuilderBase setSocketBufSizeKb(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 > 0) {
                this.mDataSpec.socketBufSizeKb = i2;
            }
            return this;
        }
        return (OfflineCacheTaskBuilderBase) invokeI.objValue;
    }
}
