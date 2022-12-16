package com.kwad.components.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.core.webview.kwai.d;
import com.kwad.sdk.core.webview.kwai.e;
import com.kwad.sdk.core.webview.kwai.f;
import com.kwad.sdk.utils.bh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WebView Fv;
    public final Map<String, com.kwad.sdk.core.webview.kwai.a> KC;
    public com.kwad.sdk.core.webview.kwai.a KD;
    public boolean KE;

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
        this.KC = new ConcurrentHashMap(32);
        this.KD = new d();
        this.Fv = webView;
        pn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) {
            if (this.KE) {
                str3 = "callJS after destroy jsInterface, " + str2;
            } else if (!TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.e.b.d("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
                WebView webView = this.Fv;
                if (webView == null) {
                    return;
                }
                bh.a(webView, str, str2);
                return;
            } else {
                str3 = "callJS callback is empty";
            }
            com.kwad.sdk.core.e.b.d("KSAdJSBridge", str3);
        }
    }

    private void pn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            a(new com.kwad.sdk.core.webview.a.a());
            a(new com.kwad.sdk.core.webview.a.b());
            a(new h());
        }
    }

    public final void a(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.getKey())) {
                com.kwad.sdk.core.e.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
                return;
            }
            if (this.KC.containsKey(aVar.getKey())) {
                com.kwad.sdk.core.e.b.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.getKey());
            }
            this.KC.put(aVar.getKey(), aVar);
        }
    }

    public final void b(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (TextUtils.isEmpty(aVar.getKey())) {
                com.kwad.sdk.core.e.b.e("KSAdJSBridge", "handler and handler'key cannot be null");
            } else {
                this.KC.put(aVar.getKey(), aVar);
            }
        }
    }

    @JavascriptInterface
    public final void callAdBridge(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            com.kwad.sdk.core.e.b.d("KSAdJSBridge", "callAdBridge ==" + str);
            try {
                com.kwad.sdk.core.webview.kwai.b bVar = new com.kwad.sdk.core.webview.kwai.b();
                bVar.parseJson(new JSONObject(str));
                com.kwad.sdk.core.webview.kwai.a aVar = this.KC.get(bVar.agi);
                if (aVar == null) {
                    aVar = this.KD;
                }
                if (this.Fv != null && (this.Fv instanceof KsAdWebView)) {
                    KsAdWebView ksAdWebView = (KsAdWebView) this.Fv;
                    com.kwad.components.a.b.b.a(ksAdWebView.getLoadUrl(), ksAdWebView.getUniqueId(), bVar.agi, bVar.data);
                }
                if (aVar != null) {
                    aVar.a(bVar.data, !TextUtils.isEmpty(bVar.agj) ? new c(this, bVar) { // from class: com.kwad.components.core.webview.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.sdk.core.webview.kwai.b KF;
                        public final /* synthetic */ a KG;

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
                            this.KG = this;
                            this.KF = bVar;
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) {
                                this.KG.h(this.KF.agj, new f(bVar2).toJson().toString());
                            }
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void onError(int i, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                                this.KG.h(this.KF.agj, new e(i, str2).toJson().toString());
                            }
                        }
                    } : new c(this) { // from class: com.kwad.components.core.webview.a.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a KG;

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
                            this.KG = this;
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void a(com.kwad.sdk.core.b bVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar2) == null) {
                            }
                        }

                        @Override // com.kwad.sdk.core.webview.kwai.c
                        public final void onError(int i, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                            }
                        }
                    });
                } else {
                    com.kwad.sdk.core.e.b.e("KSAdJSBridge", "bridgeHandler is null");
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
                com.kwad.sdk.core.e.b.e("KSAdJSBridge", "callAdBridge JSONException:" + e);
            }
        }
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.sdk.core.e.b.i("KSAdJSBridge", "destroy jsInterface");
            for (Map.Entry<String, com.kwad.sdk.core.webview.kwai.a> entry : this.KC.entrySet()) {
                com.kwad.sdk.core.webview.kwai.a value = entry.getValue();
                if (value != null) {
                    value.onDestroy();
                }
            }
            this.KE = true;
        }
    }
}
