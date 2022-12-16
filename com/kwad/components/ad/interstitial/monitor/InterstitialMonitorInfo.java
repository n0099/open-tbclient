package com.kwad.components.ad.interstitial.monitor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
@KsJson
/* loaded from: classes8.dex */
public class InterstitialMonitorInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DOWNLOAD_TYPE_ALL = 2;
    public static final int DOWNLOAD_TYPE_ONLINE = 1;
    public static final int DOWNLOAD_TYPE_PART = 3;
    public static final int LOAD_STATUS_AD_SHOWN = 4;
    public static final int LOAD_STATUS_DATA_FINISH = 2;
    public static final int LOAD_STATUS_FAILED = 5;
    public static final int LOAD_STATUS_LOAD_FINISH = 3;
    public static final int LOAD_STATUS_SHOW_AD_CALL = 6;
    public static final int LOAD_STATUS_START = 1;
    public static final int LOAD_TYPE_CACHE = 2;
    public static final int LOAD_TYPE_ONLINE = 1;
    public static final int TYPE_H5 = 2;
    public static final int TYPE_NATIVE = 1;
    public static final int TYPE_TK = 3;
    public static final long serialVersionUID = 6882024284587637114L;
    public transient /* synthetic */ FieldHolder $fh;
    public long creativeId;
    public long downloadDuration;
    public long downloadSize;
    public int downloadType;
    public int errorCode;
    public String errorMsg;
    public long loadDataTime;
    public int materialType;
    public double ratioCount;
    public long renderDuration;
    public int renderType;
    public int status;
    public int type;
    public long videoDuration;
    public String videoUrl;

    public InterstitialMonitorInfo() {
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

    public InterstitialMonitorInfo setCreativeId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            this.creativeId = j;
            return this;
        }
        return (InterstitialMonitorInfo) invokeJ.objValue;
    }

    public InterstitialMonitorInfo setDownloadDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            this.downloadDuration = j;
            return this;
        }
        return (InterstitialMonitorInfo) invokeJ.objValue;
    }

    public InterstitialMonitorInfo setDownloadSize(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            this.downloadSize = j;
            return this;
        }
        return (InterstitialMonitorInfo) invokeJ.objValue;
    }

    public InterstitialMonitorInfo setDownloadType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.downloadType = i;
            return this;
        }
        return (InterstitialMonitorInfo) invokeI.objValue;
    }

    public InterstitialMonitorInfo setErrorCode(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.errorCode = i;
            return this;
        }
        return (InterstitialMonitorInfo) invokeI.objValue;
    }

    public InterstitialMonitorInfo setErrorMsg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.errorMsg = str;
            return this;
        }
        return (InterstitialMonitorInfo) invokeL.objValue;
    }

    public InterstitialMonitorInfo setLoadDataTime(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
            this.loadDataTime = j;
            return this;
        }
        return (InterstitialMonitorInfo) invokeJ.objValue;
    }

    public InterstitialMonitorInfo setMaterialType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.materialType = i;
            return this;
        }
        return (InterstitialMonitorInfo) invokeI.objValue;
    }

    public InterstitialMonitorInfo setRatioCount(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)})) == null) {
            this.ratioCount = d;
            return this;
        }
        return (InterstitialMonitorInfo) invokeCommon.objValue;
    }

    public InterstitialMonitorInfo setRenderDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j)) == null) {
            this.renderDuration = j;
            return this;
        }
        return (InterstitialMonitorInfo) invokeJ.objValue;
    }

    public InterstitialMonitorInfo setRenderType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.renderType = i;
            return this;
        }
        return (InterstitialMonitorInfo) invokeI.objValue;
    }

    public InterstitialMonitorInfo setStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.status = i;
            return this;
        }
        return (InterstitialMonitorInfo) invokeI.objValue;
    }

    public InterstitialMonitorInfo setType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            this.type = i;
            return this;
        }
        return (InterstitialMonitorInfo) invokeI.objValue;
    }

    public InterstitialMonitorInfo setVideoDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048589, this, j)) == null) {
            this.videoDuration = j;
            return this;
        }
        return (InterstitialMonitorInfo) invokeJ.objValue;
    }

    public InterstitialMonitorInfo setVideoUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            this.videoUrl = str;
            return this;
        }
        return (InterstitialMonitorInfo) invokeL.objValue;
    }
}
