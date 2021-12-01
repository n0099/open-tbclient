package com.kwad.sdk.core.webview.request;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.utils.t;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public String f58115b;

    /* renamed from: c  reason: collision with root package name */
    public String f58116c;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58115b = str;
        this.f58116c = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
            jSONObject = null;
        }
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "mBodyParams1 size=" + this.a.length());
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        t.a(this.a, jSONObject);
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "mBodyParams2 size=" + this.a.length());
        a("user-agent", k.c());
        a("BrowserUa", k.d());
        a("SystemUa", k.a());
        com.kwad.sdk.core.d.a.a("WebCardGetDataRequest", "user-agent" + k.c());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return com.kwad.sdk.d.a() + this.f58115b;
        }
        return (String) invokeV.objValue;
    }
}
