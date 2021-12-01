package com.kwad.tachikoma;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.TKContext;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.webview.kwai.e;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.plugin.g;
import com.kwad.v8.V8Object;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, com.kwad.sdk.core.webview.kwai.a> a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.a f59808b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59809c;

    /* renamed from: d  reason: collision with root package name */
    public TKContext f59810d;

    /* renamed from: e  reason: collision with root package name */
    public String f59811e;

    /* renamed from: f  reason: collision with root package name */
    public String f59812f;

    public a(TKContext tKContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tKContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
        this.f59808b = new com.kwad.sdk.core.webview.kwai.d();
        this.f59810d = tKContext;
        this.f59812f = str;
        g gVar = (g) f.a(g.class);
        if (gVar != null) {
            this.f59811e = gVar.d();
        }
    }

    private void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            i.a("ad_client_error_log", new CommercialAction.TKPerformMsg().setRenderState(3).setErrorReason(str).setTemplateId(this.f59812f).setVersionCode(this.f59811e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, str2) == null) {
            if (this.f59809c) {
                str3 = "callJS after destroy jsInterface, " + str2;
            } else if (str != null) {
                com.kwad.sdk.core.d.a.c("TKJSBridge", "callJS callback:+ " + str + "--params: " + str2);
                try {
                    this.f59810d.evaluateScript(str + "(" + JSONObject.quote(str2) + SmallTailInfo.EMOTION_SUFFIX, null, null);
                    return;
                } catch (Throwable th) {
                    g gVar = (g) f.a(g.class);
                    if (gVar != null) {
                        gVar.c();
                    }
                    a(th.getMessage());
                    com.kwad.sdk.core.kwai.a.a(th);
                    com.kwad.sdk.core.d.a.a(th);
                    return;
                }
            } else {
                str3 = "callJS callback is empty";
            }
            com.kwad.sdk.core.d.a.c("TKJSBridge", str3);
        }
    }

    public void a(com.kwad.sdk.core.webview.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (aVar == null || TextUtils.isEmpty(aVar.a())) {
                com.kwad.sdk.core.d.a.e("TKJSBridge", "handler and handler'key cannot be null");
                return;
            }
            if (this.a.containsKey(aVar.a())) {
                com.kwad.sdk.core.d.a.e("TKJSBridge", "cannot register handler again, handler: " + aVar.a());
            }
            this.a.put(aVar.a(), aVar);
        }
    }

    @JavascriptInterface
    public void callAdBridge(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Object) == null) {
            String string = v8Object.getString("action");
            String string2 = v8Object.getString("data");
            String string3 = v8Object.getString("callback");
            com.kwad.sdk.core.d.a.c("TKJSBridge", "callAdBridge == action " + string + " param: " + string2 + " callback" + string3);
            com.kwad.sdk.core.webview.kwai.a aVar = this.a.get(string);
            if (aVar == null) {
                a("Js Action not found");
                aVar = this.f59808b;
            }
            if (aVar == null) {
                com.kwad.sdk.core.d.a.e("TKJSBridge", "bridgeHandler is null");
                return;
            }
            try {
                aVar.a(string2, string3 != null ? new com.kwad.sdk.core.webview.kwai.c(this, string3) { // from class: com.kwad.tachikoma.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f59813b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, string3};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f59813b = this;
                        this.a = string3;
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            this.f59813b.a(this.a, new e(i2, str).toJson().toString());
                        }
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public void a(com.kwad.sdk.core.b bVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                            this.f59813b.a(this.a, new com.kwad.sdk.core.webview.kwai.f(bVar).toJson().toString());
                        }
                    }
                } : new com.kwad.sdk.core.webview.kwai.c(this) { // from class: com.kwad.tachikoma.a.2
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public void a(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        }
                    }

                    @Override // com.kwad.sdk.core.webview.kwai.c
                    public void a(com.kwad.sdk.core.b bVar) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                        }
                    }
                });
            } catch (Throwable th) {
                a(th.getMessage());
                com.kwad.sdk.core.kwai.a.a(th);
            }
        }
    }
}
