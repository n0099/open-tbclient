package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.av;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String A;
        public int B;
        public int C;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f58576b;

        /* renamed from: c  reason: collision with root package name */
        public String f58577c;

        /* renamed from: d  reason: collision with root package name */
        public int f58578d;

        /* renamed from: e  reason: collision with root package name */
        public int f58579e;

        /* renamed from: f  reason: collision with root package name */
        public String f58580f;

        /* renamed from: g  reason: collision with root package name */
        public String f58581g;

        /* renamed from: h  reason: collision with root package name */
        public String f58582h;

        /* renamed from: i  reason: collision with root package name */
        public String f58583i;

        /* renamed from: j  reason: collision with root package name */
        public String f58584j;

        /* renamed from: k  reason: collision with root package name */
        public String f58585k;
        public String l;
        public String m;
        public String n;
        public String o;
        public int p;
        public String q;
        public int r;
        public String s;
        public String t;
        public String u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

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
                aVar.a = "3.3.17.4";
                aVar.f58576b = 3031704;
                aVar.f58577c = KsAdSDKImpl.get().getApiVersion();
                aVar.f58578d = KsAdSDKImpl.get().getApiVersionCode();
                aVar.f58579e = KsAdSDKImpl.get().getSDKType();
                aVar.f58580f = av.w(KsAdSDKImpl.get().getContext());
                aVar.f58581g = KsAdSDKImpl.get().getAppName();
                aVar.f58582h = KsAdSDKImpl.get().getAppId();
                aVar.f58583i = "";
                aVar.f58584j = com.kwad.sdk.core.a.e.a();
                aVar.f58585k = com.kwad.sdk.core.a.e.b();
                aVar.l = String.valueOf(ad.c(KsAdSDKImpl.get().getContext()));
                aVar.m = av.n();
                aVar.n = av.e();
                aVar.o = av.g();
                aVar.p = 1;
                aVar.q = av.q();
                aVar.r = av.r();
                aVar.s = av.s();
                aVar.t = av.d();
                aVar.u = av.u();
                aVar.v = av.n(KsAdSDKImpl.get().getContext());
                aVar.w = av.o(KsAdSDKImpl.get().getContext());
                aVar.x = av.d(KsAdSDKImpl.get().getContext());
                aVar.y = com.kwad.sdk.core.f.a.a();
                aVar.z = av.t(KsAdSDKImpl.get().getContext());
                aVar.A = av.v(KsAdSDKImpl.get().getContext());
                aVar.B = com.kwad.sdk.a.kwai.a.a(KsAdSDKImpl.get().getContext());
                aVar.C = com.kwad.sdk.a.kwai.a.a(KsAdSDKImpl.get().getContext(), 50.0f);
                return aVar;
            }
            return (a) invokeV.objValue;
        }
    }

    public e() {
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

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "getDeviceInfo" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            cVar.a(a.a());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }
}
