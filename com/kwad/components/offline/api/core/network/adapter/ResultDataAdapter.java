package com.kwad.components.offline.api.core.network.adapter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ResultDataAdapter extends BaseResultData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6920968714292152136L;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseOfflineCompoResultData mOfflineCompoResultData;

    public ResultDataAdapter(BaseOfflineCompoResultData baseOfflineCompoResultData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseOfflineCompoResultData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOfflineCompoResultData = baseOfflineCompoResultData;
    }

    public BaseOfflineCompoResultData getOfflineCompoResultData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mOfflineCompoResultData : (BaseOfflineCompoResultData) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean hasData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mOfflineCompoResultData.hasData() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOfflineCompoResultData.isDataEmpty() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isResultOk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOfflineCompoResultData.isResultOk() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            this.mOfflineCompoResultData.parseJson(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            JSONObject json = super.toJson();
            r.merge(json, this.mOfflineCompoResultData.toJson());
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
