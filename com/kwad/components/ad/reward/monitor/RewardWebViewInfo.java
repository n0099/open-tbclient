package com.kwad.components.ad.reward.monitor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class RewardWebViewInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4316140680874648788L;
    public transient /* synthetic */ FieldHolder $fh;
    public long durationMs;
    public String event;
    public String pageType;
    public double ratioCount;
    public String sceneId;
    public String source;
    public int status;
    public String url;

    public RewardWebViewInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.event = "";
        this.url = "";
        this.source = "";
        this.sceneId = "";
        this.pageType = "";
        this.durationMs = -1L;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterToJson(jSONObject);
            if (this.durationMs == -1) {
                jSONObject.remove("duration_ms");
            }
        }
    }

    public RewardWebViewInfo setDurationMs(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            this.durationMs = j;
            return this;
        }
        return (RewardWebViewInfo) invokeJ.objValue;
    }

    public RewardWebViewInfo setEvent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.event = str;
            return this;
        }
        return (RewardWebViewInfo) invokeL.objValue;
    }

    public RewardWebViewInfo setPageType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.pageType = str;
            return this;
        }
        return (RewardWebViewInfo) invokeL.objValue;
    }

    public RewardWebViewInfo setRatioCount(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Double.valueOf(d)})) == null) {
            this.ratioCount = d;
            return this;
        }
        return (RewardWebViewInfo) invokeCommon.objValue;
    }

    public RewardWebViewInfo setSceneId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.sceneId = str;
            return this;
        }
        return (RewardWebViewInfo) invokeL.objValue;
    }

    public RewardWebViewInfo setSource(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.source = str;
            return this;
        }
        return (RewardWebViewInfo) invokeL.objValue;
    }

    public RewardWebViewInfo setStatus(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.status = i;
            return this;
        }
        return (RewardWebViewInfo) invokeI.objValue;
    }

    public RewardWebViewInfo setUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.url = str;
            return this;
        }
        return (RewardWebViewInfo) invokeL.objValue;
    }
}
