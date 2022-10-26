package com.kwad.components.offline.api.core.network.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.EmptyResultData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BaseOfflineCompoResultData implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_RESULT_OK = 1;
    public static final long serialVersionUID = 7464537023322307192L;
    public transient /* synthetic */ FieldHolder $fh;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public BaseResultData mBaseResultData;
    public int result;

    public BaseOfflineCompoResultData() {
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
        this.mBaseResultData = new EmptyResultData();
    }

    public boolean hasData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.hasAd : invokeV.booleanValue;
    }

    public boolean isDataEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isResultOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.result == 1 : invokeV.booleanValue;
    }

    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (this.mBaseResultData == null) {
            this.mBaseResultData = new EmptyResultData();
        }
        this.mBaseResultData.parseJson(jSONObject);
        BaseResultData baseResultData = this.mBaseResultData;
        this.llsid = baseResultData.llsid;
        this.result = baseResultData.result;
        this.hasAd = baseResultData.hasAd;
        this.errorMsg = baseResultData.errorMsg;
        this.extra = baseResultData.extra;
        this.cookie = baseResultData.cookie;
    }

    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            BaseResultData baseResultData = this.mBaseResultData;
            return baseResultData == null ? new JSONObject() : baseResultData.toJson();
        }
        return (JSONObject) invokeV.objValue;
    }
}
