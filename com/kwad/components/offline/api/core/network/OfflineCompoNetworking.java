package com.kwad.components.offline.api.core.network;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter;
import com.kwad.components.offline.api.core.network.adapter.RequestListenerAdapter;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.m;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class OfflineCompoNetworking implements IOfflineCompoNetworking {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m mNetworking;

    public OfflineCompoNetworking() {
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
        this.mNetworking = new NetworkingAdapter(this);
    }

    public static BaseOfflineCompoResultData parseData(String str, BaseOfflineCompoResultData baseOfflineCompoResultData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, baseOfflineCompoResultData)) == null) {
            baseOfflineCompoResultData.parseJson(new JSONObject(str));
            return baseOfflineCompoResultData;
        }
        return (BaseOfflineCompoResultData) invokeLL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mNetworking.cancel();
        }
    }

    public abstract BaseOfflineCompoResultData createResponseData();

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean enableMonitorReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public boolean isPostByJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void onResponse(IOfflineCompoRequest iOfflineCompoRequest, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, iOfflineCompoRequest, cVar) == null) {
        }
    }

    public BaseOfflineCompoResultData parseData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? parseData(str, createResponseData()) : (BaseOfflineCompoResultData) invokeL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void request(IOfflineCompoRequestListener iOfflineCompoRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iOfflineCompoRequestListener) == null) {
            this.mNetworking.request(new RequestListenerAdapter(iOfflineCompoRequestListener));
        }
    }
}
