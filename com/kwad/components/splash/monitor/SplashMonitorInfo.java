package com.kwad.components.splash.monitor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes7.dex */
public class SplashMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECK_BACKUP_FAILED = 4;
    public static final int CHECK_BACKUP_SUCCESS = 3;
    public static final int CHECK_CACHE = 2;
    public static final int CHECK_ERROR = 6;
    public static final int CHECK_INVALID_VIDEO = 5;
    public static final int CHECK_START = 1;
    public static final int CHECK_TIME_OUT = 7;
    public static final int ERROR_DOWNLOAD = 4;
    public static final int ERROR_NET = 1;
    public static final String ERROR_NET_MSG = "networkError";
    public static final int ERROR_PRELOAD_ID_INVALID = 3;
    public static final String ERROR_PRELOAD_ID_INVALID_MSG = "preloadIdError";
    public static final int ERROR_URL_INVALID = 2;
    public static final String ERROR_URL_INVALID_MSG = "urlError";
    public static final int LOAD_STATUS_CHECK_SUCCESS = 3;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 4;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int MATERIAL_IMAGE = 2;
    public static final int MATERIAL_VIDEO = 1;
    public static final int PRE_LOAD_FAIL = 3;
    public static final int PRE_LOAD_START = 1;
    public static final int PRE_LOAD_SUCCESS = 2;
    public static final int SHOW_AD_CALL = 4;
    public static final int SHOW_FAIL = 3;
    public static final int SHOW_START = 1;
    public static final int SHOW_SUCCESS = 2;
    public static final int SINGLE_CACHE_FAIL = 2;
    public static final int SINGLE_CACHE_SUCCESS = 1;
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_UPDATE = 2;
    public static final long serialVersionUID = 3528420046810658543L;
    public transient /* synthetic */ FieldHolder $fh;
    public long cacheValidTime;
    public long checkDataTime;
    public long costTime;
    public int count;
    public long creativeId;
    public List creativeIds;
    public int errorCode;
    public String errorMsg;
    public String failUrl;
    public List ids;
    public long loadAndCheckDataTime;
    public long loadDataTime;
    public int materialType;
    public String preloadId;
    public List preloadIds;
    public double ratioCount;
    public long size;
    public int status;
    public int totalCount;
    public int type;

    public SplashMonitorInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public SplashMonitorInfo setCacheValidTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            this.cacheValidTime = j;
            return this;
        }
        return (SplashMonitorInfo) invokeJ.objValue;
    }

    public SplashMonitorInfo setCheckDataTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            this.checkDataTime = j;
            return this;
        }
        return (SplashMonitorInfo) invokeJ.objValue;
    }

    public SplashMonitorInfo setCostTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            this.costTime = j;
            return this;
        }
        return (SplashMonitorInfo) invokeJ.objValue;
    }

    public SplashMonitorInfo setCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.count = i;
            return this;
        }
        return (SplashMonitorInfo) invokeI.objValue;
    }

    public SplashMonitorInfo setCreativeId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            this.creativeId = j;
            return this;
        }
        return (SplashMonitorInfo) invokeJ.objValue;
    }

    public SplashMonitorInfo setCreativeIds(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            this.creativeIds = list;
            return this;
        }
        return (SplashMonitorInfo) invokeL.objValue;
    }

    public SplashMonitorInfo setErrorCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.errorCode = i;
            return this;
        }
        return (SplashMonitorInfo) invokeI.objValue;
    }

    public SplashMonitorInfo setErrorMsg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            this.errorMsg = str;
            return this;
        }
        return (SplashMonitorInfo) invokeL.objValue;
    }

    public SplashMonitorInfo setFailUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.failUrl = str;
            return this;
        }
        return (SplashMonitorInfo) invokeL.objValue;
    }

    public SplashMonitorInfo setIds(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, list)) == null) {
            this.ids = list;
            return this;
        }
        return (SplashMonitorInfo) invokeL.objValue;
    }

    public SplashMonitorInfo setLoadAndCheckDataTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            this.loadAndCheckDataTime = j;
            return this;
        }
        return (SplashMonitorInfo) invokeJ.objValue;
    }

    public SplashMonitorInfo setLoadDataTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
            this.loadDataTime = j;
            return this;
        }
        return (SplashMonitorInfo) invokeJ.objValue;
    }

    public SplashMonitorInfo setMaterialType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.materialType = i;
            return this;
        }
        return (SplashMonitorInfo) invokeI.objValue;
    }

    public SplashMonitorInfo setPreloadId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.preloadId = str;
            return this;
        }
        return (SplashMonitorInfo) invokeL.objValue;
    }

    public SplashMonitorInfo setPreloadIds(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, list)) == null) {
            this.preloadIds = list;
            return this;
        }
        return (SplashMonitorInfo) invokeL.objValue;
    }

    public SplashMonitorInfo setRatioCount(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Double.valueOf(d)})) == null) {
            this.ratioCount = d;
            return this;
        }
        return (SplashMonitorInfo) invokeCommon.objValue;
    }

    public SplashMonitorInfo setSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            this.size = j;
            return this;
        }
        return (SplashMonitorInfo) invokeJ.objValue;
    }

    public SplashMonitorInfo setStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            this.status = i;
            return this;
        }
        return (SplashMonitorInfo) invokeI.objValue;
    }

    public SplashMonitorInfo setTotalCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            this.totalCount = i;
            return this;
        }
        return (SplashMonitorInfo) invokeI.objValue;
    }

    public SplashMonitorInfo setType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.type = i;
            return this;
        }
        return (SplashMonitorInfo) invokeI.objValue;
    }
}
