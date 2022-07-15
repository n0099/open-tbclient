package com.kwad.components.offline.tk.kwai;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.utils.aj;
/* loaded from: classes5.dex */
public final class b implements IOfflineCompoBridgeHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.kwai.a a;

    public b(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        aj.a(aVar);
        this.a = aVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.a() : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, iOfflineCompoCallBackFunction) == null) {
            this.a.a(str, new a(iOfflineCompoCallBackFunction));
        }
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.b();
        }
    }
}
