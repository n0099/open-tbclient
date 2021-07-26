package com.kwad.sdk.core.webview.a;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.az;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f35303a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f35304b;

    /* renamed from: c  reason: collision with root package name */
    public a f35305c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35306d;

    public g(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {webView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35303a = new ConcurrentHashMap();
        this.f35305c = new d();
        this.f35304b = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, str2) == null) {
            if (this.f35306d) {
                str3 = "callJS after destroy jsInterface, " + str2;
            } else if (!TextUtils.isEmpty(str)) {
                com.kwad.sdk.core.d.a.a("KSAdJSBridge", "callJS callback:+ " + str + "--params: " + str2);
                WebView webView = this.f35304b;
                if (webView == null) {
                    return;
                }
                az.a(webView, str, str2);
                return;
            } else {
                str3 = "callJS callback is empty";
            }
            com.kwad.sdk.core.d.a.a("KSAdJSBridge", str3);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.d.a.c("KSAdJSBridge", "destroy jsInterface");
            for (Map.Entry<String, a> entry : this.f35303a.entrySet()) {
                a value = entry.getValue();
                if (value != null) {
                    value.b();
                }
            }
            this.f35306d = true;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                com.kwad.sdk.core.d.a.e("KSAdJSBridge", "handler and handler'key cannot be null");
                return;
            }
            if (this.f35303a.containsKey(aVar.a())) {
                com.kwad.sdk.core.d.a.e("KSAdJSBridge", "cannot register handler again, handler: " + aVar.a());
            }
            this.f35303a.put(aVar.a(), aVar);
        }
    }

    @JavascriptInterface
    public void callAdBridge(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            com.kwad.sdk.core.d.a.a("KSAdJSBridge", "callAdBridge ==" + str);
            try {
                b bVar = new b();
                bVar.parseJson(new JSONObject(str));
                a aVar = this.f35303a.get(bVar.f35296a);
                if (aVar == null) {
                    aVar = this.f35305c;
                }
                if (aVar != null) {
                    aVar.a(bVar.f35297b, !TextUtils.isEmpty(bVar.f35298c) ? new c(this, bVar) { // from class: com.kwad.sdk.core.webview.a.g.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ b f35307a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ g f35308b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35308b = this;
                            this.f35307a = bVar;
                        }

                        @Override // com.kwad.sdk.core.webview.a.c
                        public void a(int i2, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                                this.f35308b.a(this.f35307a.f35298c, new e(i2, str2).toJson().toString());
                            }
                        }

                        @Override // com.kwad.sdk.core.webview.a.c
                        public void a(com.kwad.sdk.core.b bVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                                this.f35308b.a(this.f35307a.f35298c, new f(bVar2).toJson().toString());
                            }
                        }
                    } : new c(this) { // from class: com.kwad.sdk.core.webview.a.g.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ g f35309a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35309a = this;
                        }

                        @Override // com.kwad.sdk.core.webview.a.c
                        public void a(int i2, String str2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                            }
                        }

                        @Override // com.kwad.sdk.core.webview.a.c
                        public void a(com.kwad.sdk.core.b bVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar2) == null) {
                            }
                        }
                    });
                } else {
                    com.kwad.sdk.core.d.a.e("KSAdJSBridge", "bridgeHandler is null");
                }
            } catch (JSONException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.d.a.e("KSAdJSBridge", "callAdBridge JSONException:" + e2);
            }
        }
    }
}
