package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f36829a;

        /* renamed from: b  reason: collision with root package name */
        public String f36830b;

        /* renamed from: c  reason: collision with root package name */
        public String f36831c;

        /* renamed from: d  reason: collision with root package name */
        public String f36832d;

        /* renamed from: e  reason: collision with root package name */
        public String f36833e;

        /* renamed from: f  reason: collision with root package name */
        public String f36834f;

        /* renamed from: g  reason: collision with root package name */
        public String f36835g;

        /* renamed from: h  reason: collision with root package name */
        public String f36836h;

        /* renamed from: i  reason: collision with root package name */
        public int f36837i;
        public int j;
        public String k;
        public String l;
        public String m;
        public String n;
        public int o;
        public int p;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                a aVar = new a();
                aVar.f36829a = ah.l(KsAdSDKImpl.get().getContext());
                aVar.f36830b = "";
                aVar.f36831c = String.valueOf(v.d(KsAdSDKImpl.get().getContext()));
                aVar.f36832d = ah.g();
                aVar.f36833e = ah.e();
                aVar.f36834f = ah.i();
                aVar.f36835g = ah.d();
                aVar.f36836h = ah.m();
                aVar.f36837i = ao.c(KsAdSDKImpl.get().getContext());
                aVar.j = ao.b(KsAdSDKImpl.get().getContext());
                aVar.k = ah.d(KsAdSDKImpl.get().getContext());
                aVar.l = com.kwad.sdk.core.f.a.a();
                aVar.m = ah.i(KsAdSDKImpl.get().getContext());
                aVar.n = ah.k(KsAdSDKImpl.get().getContext());
                aVar.o = ao.a(KsAdSDKImpl.get().getContext());
                aVar.p = ao.a(KsAdSDKImpl.get().getContext(), 50.0f);
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.o.a(jSONObject, "appVersion", this.f36829a);
                com.kwad.sdk.utils.o.a(jSONObject, "globalId", this.f36830b);
                com.kwad.sdk.utils.o.a(jSONObject, "networkType", this.f36831c);
                com.kwad.sdk.utils.o.a(jSONObject, HttpConstants.HTTP_MANUFACTURER, this.f36832d);
                com.kwad.sdk.utils.o.a(jSONObject, "model", this.f36833e);
                com.kwad.sdk.utils.o.a(jSONObject, "systemVersion", this.f36834f);
                com.kwad.sdk.utils.o.a(jSONObject, "locale", this.f36835g);
                com.kwad.sdk.utils.o.a(jSONObject, "uuid", this.f36836h);
                com.kwad.sdk.utils.o.a(jSONObject, "screenWidth", this.f36837i);
                com.kwad.sdk.utils.o.a(jSONObject, "screenHeight", this.j);
                com.kwad.sdk.utils.o.a(jSONObject, "imei", this.k);
                com.kwad.sdk.utils.o.a(jSONObject, "oaid", this.l);
                com.kwad.sdk.utils.o.a(jSONObject, "androidId", this.m);
                com.kwad.sdk.utils.o.a(jSONObject, "mac", this.n);
                com.kwad.sdk.utils.o.a(jSONObject, "statusBarHeight", this.o);
                com.kwad.sdk.utils.o.a(jSONObject, "titleBarHeight", this.p);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "getDeviceInfo" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            cVar.a(a.a());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
