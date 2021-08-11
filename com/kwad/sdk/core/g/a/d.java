package com.kwad.sdk.core.g.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.q;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71389a;

    /* renamed from: b  reason: collision with root package name */
    public String f71390b;

    /* renamed from: c  reason: collision with root package name */
    public String f71391c;

    /* renamed from: d  reason: collision with root package name */
    public String f71392d;

    /* renamed from: e  reason: collision with root package name */
    public String f71393e;

    /* renamed from: f  reason: collision with root package name */
    public String f71394f;

    /* renamed from: g  reason: collision with root package name */
    public int f71395g;

    /* renamed from: h  reason: collision with root package name */
    public int f71396h;

    /* renamed from: i  reason: collision with root package name */
    public String f71397i;

    /* renamed from: j  reason: collision with root package name */
    public int f71398j;
    public int k;
    public String l;
    public String m;
    public String n;
    public int o;
    public String p;
    public String q;
    public String r;
    public String s;
    public JSONArray t;
    public String u;
    public int v;

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
        this.v = 0;
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a(false, 0) : (d) invokeV.objValue;
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
            dVar.f71390b = ap.d(KsAdSDKImpl.get().getContext());
            String[] g2 = ap.g(KsAdSDKImpl.get().getContext());
            dVar.f71391c = g2[0];
            dVar.f71392d = g2[1];
            dVar.f71393e = ap.f(KsAdSDKImpl.get().getContext());
            dVar.f71394f = com.kwad.sdk.core.f.b.a();
            dVar.p = ap.e();
            dVar.q = ap.f();
            dVar.f71395g = 1;
            dVar.f71396h = ap.k();
            dVar.f71397i = ap.j();
            dVar.f71389a = ap.l();
            dVar.k = ap.l(KsAdSDKImpl.get().getContext());
            dVar.f71398j = ap.k(KsAdSDKImpl.get().getContext());
            dVar.l = ap.m(KsAdSDKImpl.get().getContext());
            if (z) {
                dVar.t = InstalledAppInfoManager.a(KsAdSDKImpl.get().getContext());
            }
            dVar.m = ap.n();
            dVar.n = ap.g();
            dVar.s = com.kwad.sdk.core.b.e.a();
            dVar.r = com.kwad.sdk.core.b.e.b();
            dVar.o = ap.h();
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
            sb.append("3.3.11");
            sb.append(",d:");
            sb.append(dVar.m);
            sb.append(",dh:");
            String str = dVar.m;
            sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
            sb.append(",o:");
            sb.append(dVar.f71394f);
            sb.append(",i:");
            sb.append(dVar.f71390b);
            com.kwad.sdk.core.d.a.a(sb.toString());
            try {
                dVar.u = ap.i();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.b(e2);
            }
            dVar.v = i2;
            return dVar;
        }
        return (d) invokeCommon.objValue;
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
            q.a(jSONObject, "imei", this.f71390b);
            q.a(jSONObject, "imei1", this.f71391c);
            q.a(jSONObject, IAdRequestParam.IMEI2, this.f71392d);
            q.a(jSONObject, "meid", this.f71393e);
            q.a(jSONObject, "oaid", this.f71394f);
            q.a(jSONObject, "deviceModel", this.p);
            q.a(jSONObject, "deviceBrand", this.q);
            q.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, this.f71395g);
            q.a(jSONObject, "osVersion", this.f71397i);
            q.a(jSONObject, "osApi", this.f71396h);
            q.a(jSONObject, "language", this.f71389a);
            q.a(jSONObject, "androidId", this.l);
            q.a(jSONObject, "deviceId", this.m);
            q.a(jSONObject, "deviceVendor", this.n);
            q.a(jSONObject, com.tencent.connect.common.Constants.PARAM_PLATFORM, this.o);
            q.a(jSONObject, "screenWidth", this.f71398j);
            q.a(jSONObject, "screenHeight", this.k);
            q.a(jSONObject, "appPackageName", this.t);
            if (!TextUtils.isEmpty(this.s)) {
                q.a(jSONObject, "egid", this.s);
            }
            if (!TextUtils.isEmpty(this.r)) {
                q.a(jSONObject, "deviceSig", this.r);
            }
            q.a(jSONObject, "arch", this.u);
            q.a(jSONObject, "screenDirection", this.v);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
