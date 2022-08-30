package com.kwad.components.offline.tk.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.webview.kwai.e;
import com.kwad.sdk.core.webview.kwai.f;
/* loaded from: classes7.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IOfflineCompoCallBackFunction Qn;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iOfflineCompoCallBackFunction};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Qn = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.kwai.c
    public final void a(com.kwad.sdk.core.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            String jSONObject = new f(bVar).toJson().toString();
            IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.Qn;
            if (iOfflineCompoCallBackFunction != null) {
                iOfflineCompoCallBackFunction.onSuccess(jSONObject);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.c
    public final void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            String jSONObject = new e(i, str).toJson().toString();
            IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.Qn;
            if (iOfflineCompoCallBackFunction != null) {
                iOfflineCompoCallBackFunction.onError(jSONObject);
            }
        }
    }
}
