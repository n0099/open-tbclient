package com.kwad.components.offline.api.core.network.adapter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class NetworkingAdapter extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OfflineCompoNetworking mOfflineCompoNetworking;

    public NetworkingAdapter(OfflineCompoNetworking offlineCompoNetworking) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {offlineCompoNetworking};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOfflineCompoNetworking = offlineCompoNetworking;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    public RequestAdapter createRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new RequestAdapter(this, this.mOfflineCompoNetworking.createRequest()) { // from class: com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NetworkingAdapter this$0;
            public final /* synthetic */ IOfflineCompoRequest val$offlineRequest;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, r7};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$offlineRequest = r7;
            }

            @Override // com.kwad.sdk.core.network.b
            public boolean encryptDisable() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? this.val$offlineRequest.encryptDisable() : invokeV2.booleanValue;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public JSONObject getBody() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$offlineRequest.getBody() : (JSONObject) invokeV2.objValue;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public Map getBodyMap() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.val$offlineRequest.getBodyMap() : (Map) invokeV2.objValue;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public Map getHeader() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? this.val$offlineRequest.getHeader() : (Map) invokeV2.objValue;
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.RequestAdapter
            public IOfflineCompoRequest getOfflineCompoRequest() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048580, this)) == null) ? this.val$offlineRequest : (IOfflineCompoRequest) invokeV2.objValue;
            }

            @Override // com.kwad.sdk.core.network.b
            public String getRequestHost() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048581, this)) == null) ? this.val$offlineRequest.getRequestHost() : (String) invokeV2.objValue;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public SceneImpl getScene() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048582, this)) == null) {
                    return null;
                }
                return (SceneImpl) invokeV2.objValue;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public String getUrl() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048583, this)) == null) ? this.val$offlineRequest.getUrl() : (String) invokeV2.objValue;
            }
        } : (RequestAdapter) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.network.m
    public boolean enableMonitorReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mOfflineCompoNetworking.enableMonitorReport() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.core.network.m
    public boolean isPostByJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOfflineCompoNetworking.isPostByJson() : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.a
    public void onResponse(RequestAdapter requestAdapter, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, requestAdapter, cVar) == null) {
            super.onResponse((g) requestAdapter, cVar);
            this.mOfflineCompoNetworking.onResponse(requestAdapter.getOfflineCompoRequest(), cVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.m
    public ResultDataAdapter parseData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new ResultDataAdapter(this.mOfflineCompoNetworking.parseData(str)) : (ResultDataAdapter) invokeL.objValue;
    }
}
