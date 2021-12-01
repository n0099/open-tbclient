package com.kwad.sdk.core.request.model;

import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.av;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d extends com.kwad.sdk.core.response.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public long C;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f57771b;

    /* renamed from: c  reason: collision with root package name */
    public String f57772c;

    /* renamed from: d  reason: collision with root package name */
    public String f57773d;

    /* renamed from: e  reason: collision with root package name */
    public String f57774e;

    /* renamed from: f  reason: collision with root package name */
    public String f57775f;

    /* renamed from: g  reason: collision with root package name */
    public String f57776g;

    /* renamed from: h  reason: collision with root package name */
    public int f57777h;

    /* renamed from: i  reason: collision with root package name */
    public int f57778i;

    /* renamed from: j  reason: collision with root package name */
    public String f57779j;

    /* renamed from: k  reason: collision with root package name */
    public String f57780k;
    public int l;
    public int m;
    public int n;
    public int o;
    public String p;
    public String q;
    public String r;
    public int s;
    public String t;
    public String u;
    public String v;
    public String w;
    public JSONArray x;
    public String y;
    public int z;

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
                return;
            }
        }
        this.z = 0;
        this.C = 0L;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            d dVar = new d();
            dVar.f57774e = com.kwad.sdk.core.f.a.a();
            dVar.q = av.u();
            dVar.t = av.e();
            dVar.f57777h = 1;
            dVar.f57778i = av.r();
            dVar.f57779j = av.q();
            dVar.w = com.kwad.sdk.core.a.e.a();
            dVar.v = com.kwad.sdk.core.a.e.b();
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public static d a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) ? a(z, 0) : (d) invokeZ.objValue;
    }

    public static d a(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            d dVar = new d();
            dVar.a = av.d(KsAdSDKImpl.get().getContext());
            String[] g2 = av.g(KsAdSDKImpl.get().getContext());
            dVar.f57771b = g2[0];
            dVar.f57772c = g2[1];
            dVar.f57773d = av.f(KsAdSDKImpl.get().getContext());
            dVar.f57774e = com.kwad.sdk.core.f.a.a();
            dVar.t = av.e();
            dVar.u = av.g();
            dVar.f57777h = 1;
            dVar.f57778i = av.r();
            dVar.f57779j = av.q();
            dVar.f57780k = av.s();
            dVar.m = av.o(KsAdSDKImpl.get().getContext());
            dVar.l = av.n(KsAdSDKImpl.get().getContext());
            dVar.n = av.p(KsAdSDKImpl.get().getContext());
            dVar.o = av.q(KsAdSDKImpl.get().getContext());
            dVar.p = av.t(KsAdSDKImpl.get().getContext());
            if (z) {
                dVar.x = InstalledAppInfoManager.a(KsAdSDKImpl.get().getContext());
            }
            dVar.q = av.u();
            dVar.C = av.f();
            dVar.r = av.n();
            dVar.w = com.kwad.sdk.core.a.e.a();
            dVar.v = com.kwad.sdk.core.a.e.b();
            dVar.s = av.o();
            StringBuilder sb = new StringBuilder();
            sb.append("DeviceInfo i=");
            sb.append(KsAdSDKImpl.get().getAppId());
            sb.append(",n=");
            sb.append(KsAdSDKImpl.get().getAppName());
            sb.append(",external:");
            sb.append(KsAdSDKImpl.get().getIsExternal());
            sb.append(",v1:");
            sb.append(KsAdSDKImpl.get().getApiVersion());
            sb.append(",v2:");
            sb.append("3.3.17.4");
            sb.append(",d:");
            sb.append(dVar.q);
            sb.append(",dh:");
            String str = dVar.q;
            sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
            sb.append(",o:");
            sb.append(dVar.f57774e);
            com.kwad.sdk.core.d.a.a(sb.toString());
            dVar.y = av.p();
            dVar.z = i2;
            if (com.kwad.sdk.core.config.b.ar()) {
                dVar.A = av.b(KsAdSDKImpl.get().getContext(), "com.smile.gifmaker");
                dVar.B = av.b(KsAdSDKImpl.get().getContext(), "com.kuaishou.nebula");
            }
            dVar.f57775f = Build.BRAND;
            dVar.f57776g = com.kwad.sdk.core.download.a.g.a(KsAdSDKImpl.get().getContext());
            return dVar;
        }
        return (d) invokeCommon.objValue;
    }
}
