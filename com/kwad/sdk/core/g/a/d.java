package com.kwad.sdk.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwai.video.player.KsMediaMeta;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f36127a;

    /* renamed from: b  reason: collision with root package name */
    public String f36128b;

    /* renamed from: c  reason: collision with root package name */
    public String f36129c;

    /* renamed from: d  reason: collision with root package name */
    public int f36130d;

    /* renamed from: e  reason: collision with root package name */
    public int f36131e;

    /* renamed from: f  reason: collision with root package name */
    public String f36132f;

    /* renamed from: g  reason: collision with root package name */
    public int f36133g;

    /* renamed from: h  reason: collision with root package name */
    public int f36134h;

    /* renamed from: i  reason: collision with root package name */
    public String f36135i;
    public String j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public JSONArray q;
    public String r;

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

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a(false) : (d) invokeV.objValue;
    }

    public static d a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            d dVar = new d();
            dVar.f36128b = ah.d(KsAdSDKImpl.get().getContext());
            dVar.f36129c = com.kwad.sdk.core.f.a.a();
            dVar.m = ah.e();
            dVar.n = ah.f();
            dVar.f36130d = 1;
            dVar.f36131e = ah.j();
            dVar.f36132f = ah.i();
            dVar.f36127a = ah.k();
            dVar.f36134h = ah.h(KsAdSDKImpl.get().getContext());
            dVar.f36133g = ah.g(KsAdSDKImpl.get().getContext());
            dVar.f36135i = ah.i(KsAdSDKImpl.get().getContext());
            if (z) {
                dVar.q = InstalledAppInfoManager.a(KsAdSDKImpl.get().getContext());
            }
            dVar.j = ah.m();
            dVar.k = ah.g();
            dVar.p = com.kwad.sdk.core.b.e.a();
            dVar.o = com.kwad.sdk.core.b.e.b();
            dVar.l = ah.h();
            Log.d("DeviceInfo", "external: " + KsAdSDKImpl.get().getIsExternal() + ",v:3.3.9,d:" + dVar.j);
            try {
                dVar.r = System.getProperty("os.arch");
            } catch (Exception unused) {
            }
            return dVar;
        }
        return (d) invokeZ.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "imei", this.f36128b);
            o.a(jSONObject, "oaid", this.f36129c);
            o.a(jSONObject, "deviceModel", this.m);
            o.a(jSONObject, "deviceBrand", this.n);
            o.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, this.f36130d);
            o.a(jSONObject, "osVersion", this.f36132f);
            o.a(jSONObject, "osApi", this.f36131e);
            o.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, this.f36127a);
            o.a(jSONObject, "androidId", this.f36135i);
            o.a(jSONObject, "deviceId", this.j);
            o.a(jSONObject, "deviceVendor", this.k);
            o.a(jSONObject, Constants.PARAM_PLATFORM, this.l);
            o.a(jSONObject, "screenWidth", this.f36133g);
            o.a(jSONObject, "screenHeight", this.f36134h);
            o.a(jSONObject, "appPackageName", this.q);
            if (!TextUtils.isEmpty(this.p)) {
                o.a(jSONObject, "egid", this.p);
            }
            if (!TextUtils.isEmpty(this.o)) {
                o.a(jSONObject, "deviceSig", this.o);
            }
            o.a(jSONObject, "arch", this.r);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
