package com.kwad.components.offline.api.core.network;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter;
import com.kwad.components.offline.api.core.network.adapter.RequestAdapter;
import com.kwad.components.offline.api.core.network.adapter.RequestListenerAdapter;
import com.kwad.components.offline.api.core.network.adapter.ResultDataAdapter;
import com.kwad.components.offline.api.core.network.model.BaseOfflineCompoResultData;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.l;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class OfflineCompoNetworking<R extends IOfflineCompoRequest, T extends BaseOfflineCompoResultData> implements IOfflineCompoNetworking<R, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l<RequestAdapter<R>, ResultDataAdapter<T>> mNetworking;

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

    public static <DATA extends BaseOfflineCompoResultData> DATA parseData(String str, DATA data) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, data)) == null) {
            data.parseJson(new JSONObject(str));
            return data;
        }
        return (DATA) invokeLL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mNetworking.cancel();
        }
    }

    public abstract T createResponseData();

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
    public void onResponse(R r, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, r, cVar) == null) {
        }
    }

    @NonNull
    public T parseData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? (T) parseData(str, createResponseData()) : (T) invokeL.objValue;
    }

    @Override // com.kwad.components.offline.api.core.network.IOfflineCompoNetworking
    public void request(@NonNull IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iOfflineCompoRequestListener) == null) {
            this.mNetworking.request(new RequestListenerAdapter(iOfflineCompoRequestListener));
        }
    }
}
