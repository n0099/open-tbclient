package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.core.webview.kwai.d;
import com.kwad.sdk.core.webview.kwai.e;
import com.kwad.sdk.core.webview.kwai.f;
import com.kwad.sdk.utils.bd;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, com.kwad.sdk.core.webview.kwai.a> a;
    public WebView b;
    public com.kwad.sdk.core.webview.kwai.a c;
    public boolean d;

    public a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap(32);
        this.c = new d();
        this.b = webView;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) {
            if (this.d) {
                str3 = "callJS after destroy jsInterface, " + str2;
            } else if (!TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.b.a("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
                WebView webView = this.b;
                if (webView == null) {
                    return;
                }
                bd.a(webView, str, str2);
                return;
            } else {
                str3 = "callJS callback is empty";
            }
            com.kwad.sdk.core.d.b.a("KSAdJSBridge", str3);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            a(new com.kwad.sdk.core.webview.a.a());
            a(new com.kwad.sdk.core.webview.a.b());
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.d.b.c("KSAdJSBridge", "destroy jsInterface");
            for (Map.Entry<String, com.kwad.sdk.core.webview.kwai.a> entry : this.a.entrySet()) {
                com.kwad.sdk.core.webview.kwai.a value = entry.getValue();
                if (value != null) {
                    value.b();
                }
            }
            this.d = true;
        }
    }

    public final void a(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                com.kwad.sdk.core.d.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
                return;
            }
            if (this.a.containsKey(aVar.a())) {
                com.kwad.sdk.core.d.b.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.a());
            }
            this.a.put(aVar.a(), aVar);
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            com.kwad.sdk.core.d.b.a("KSAdJSBridge", "callAdBridge ==" + str);
            try {
                com.kwad.sdk.core.webview.kwai.b bVar = new com.kwad.sdk.core.webview.kwai.b();
                bVar.parseJson(new JSONObject(str));
                com.kwad.sdk.core.webview.kwai.a aVar = this.a.get(bVar.a);
                if (aVar == null) {
                    aVar = this.c;
                }
                if (this.b != null && (this.b instanceof KsAdWebView)) {
                    KsAdWebView ksAdWebView = (KsAdWebView) this.b;
                    com.kwad.components.a.b.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.a, bVar.b);
                }
                if (aVar != null) {
                    aVar.a(bVar.b, !TextUtils.isEmpty(bVar.c) ? new c(this, bVar) { // from class: com.kwad.components.core.webview.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.sdk.core.webview.kwai.b a;
                        public final /* synthetic */ a b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = bVar;
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void a(int i, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str2) == null) {
                                this.b.a(this.a.c, new e(i, str2).toJson().toString());
                            }
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                                this.b.a(this.a.c, new f(bVar2).toJson().toString());
                            }
                        }
                    } : new c(this) { // from class: com.kwad.components.core.webview.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void a(int i, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str2) == null) {
                            }
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                            }
                        }
                    });
                } else {
                    com.kwad.sdk.core.d.b.e("KSAdJSBridge", "bridgeHandler is null");
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
                com.kwad.sdk.core.d.b.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
            }
        }
    }
}
