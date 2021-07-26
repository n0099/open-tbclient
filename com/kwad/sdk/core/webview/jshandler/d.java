package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f35353a;

        /* renamed from: b  reason: collision with root package name */
        public String f35354b;

        /* renamed from: c  reason: collision with root package name */
        public String f35355c;

        /* renamed from: d  reason: collision with root package name */
        public String f35356d;

        /* renamed from: e  reason: collision with root package name */
        public String f35357e;

        /* renamed from: f  reason: collision with root package name */
        public String f35358f;

        /* renamed from: g  reason: collision with root package name */
        public String f35359g;

        /* renamed from: h  reason: collision with root package name */
        public String f35360h;

        /* renamed from: i  reason: collision with root package name */
        public int f35361i;
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
                aVar.f35353a = ap.p(KsAdSDKImpl.get().getContext());
                aVar.f35354b = "";
                aVar.f35355c = String.valueOf(z.c(KsAdSDKImpl.get().getContext()));
                aVar.f35356d = ap.g();
                aVar.f35357e = ap.e();
                aVar.f35358f = ap.j();
                aVar.f35359g = ap.d();
                aVar.f35360h = ap.n();
                aVar.f35361i = av.c(KsAdSDKImpl.get().getContext());
                aVar.j = av.b(KsAdSDKImpl.get().getContext());
                aVar.k = ap.d(KsAdSDKImpl.get().getContext());
                aVar.l = com.kwad.sdk.core.f.b.a();
                aVar.m = ap.m(KsAdSDKImpl.get().getContext());
                aVar.n = ap.o(KsAdSDKImpl.get().getContext());
                aVar.o = av.a(KsAdSDKImpl.get().getContext());
                aVar.p = av.a(KsAdSDKImpl.get().getContext(), 50.0f);
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            }
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.q.a(jSONObject, "appVersion", this.f35353a);
                com.kwad.sdk.utils.q.a(jSONObject, "globalId", this.f35354b);
                com.kwad.sdk.utils.q.a(jSONObject, "networkType", this.f35355c);
                com.kwad.sdk.utils.q.a(jSONObject, HttpConstants.HTTP_MANUFACTURER, this.f35356d);
                com.kwad.sdk.utils.q.a(jSONObject, "model", this.f35357e);
                com.kwad.sdk.utils.q.a(jSONObject, "systemVersion", this.f35358f);
                com.kwad.sdk.utils.q.a(jSONObject, "locale", this.f35359g);
                com.kwad.sdk.utils.q.a(jSONObject, "uuid", this.f35360h);
                com.kwad.sdk.utils.q.a(jSONObject, "screenWidth", this.f35361i);
                com.kwad.sdk.utils.q.a(jSONObject, "screenHeight", this.j);
                com.kwad.sdk.utils.q.a(jSONObject, "imei", this.k);
                com.kwad.sdk.utils.q.a(jSONObject, "oaid", this.l);
                com.kwad.sdk.utils.q.a(jSONObject, "androidId", this.m);
                com.kwad.sdk.utils.q.a(jSONObject, "mac", this.n);
                com.kwad.sdk.utils.q.a(jSONObject, "statusBarHeight", this.o);
                com.kwad.sdk.utils.q.a(jSONObject, "titleBarHeight", this.p);
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
