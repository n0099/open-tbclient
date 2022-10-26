package com.kwad.components.core.webview.jshandler;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class h implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    public static void a(WebViewCommercialMsg webViewCommercialMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, webViewCommercialMsg) == null) {
            com.kwad.sdk.core.e.b.d("WebCardLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
            com.kwad.sdk.core.report.k.a(webViewCommercialMsg.category, webViewCommercialMsg);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            try {
                WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg();
                webViewCommercialMsg.parseJson(new JSONObject(str));
                a(webViewCommercialMsg);
                cVar.a(null);
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
                cVar.onError(-1, e.getMessage());
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "commercialLog" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
