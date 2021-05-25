package com.kwad.sdk.core.g.a;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.o;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f32231a;

    /* renamed from: b  reason: collision with root package name */
    public String f32232b;

    /* renamed from: c  reason: collision with root package name */
    public String f32233c;

    /* renamed from: d  reason: collision with root package name */
    public String f32234d;

    /* renamed from: e  reason: collision with root package name */
    public String f32235e;

    /* renamed from: f  reason: collision with root package name */
    public String f32236f;

    /* renamed from: g  reason: collision with root package name */
    public int f32237g;

    /* renamed from: h  reason: collision with root package name */
    public int f32238h;

    /* renamed from: i  reason: collision with root package name */
    public String f32239i;
    public int j;
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
    public int v = 0;

    public static d a() {
        return a(false, 0);
    }

    public static d a(boolean z) {
        return a(false, 0);
    }

    public static d a(boolean z, int i2) {
        d dVar = new d();
        dVar.f32232b = ai.d(KsAdSDKImpl.get().getContext());
        String[] f2 = ai.f(KsAdSDKImpl.get().getContext());
        dVar.f32233c = f2[0];
        dVar.f32234d = f2[1];
        dVar.f32235e = ai.e(KsAdSDKImpl.get().getContext());
        dVar.f32236f = com.kwad.sdk.core.f.a.a();
        dVar.p = ai.e();
        dVar.q = ai.f();
        dVar.f32237g = 1;
        dVar.f32238h = ai.k();
        dVar.f32239i = ai.j();
        dVar.f32231a = ai.l();
        dVar.k = ai.j(KsAdSDKImpl.get().getContext());
        dVar.j = ai.i(KsAdSDKImpl.get().getContext());
        dVar.l = ai.k(KsAdSDKImpl.get().getContext());
        if (z) {
            dVar.t = InstalledAppInfoManager.a(KsAdSDKImpl.get().getContext());
        }
        dVar.m = ai.n();
        dVar.n = ai.g();
        dVar.s = com.kwad.sdk.core.b.e.a();
        dVar.r = com.kwad.sdk.core.b.e.b();
        dVar.o = ai.h();
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
        sb.append("3.3.8.3");
        sb.append(",d:");
        sb.append(dVar.m);
        sb.append(",dh:");
        String str = dVar.m;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        com.kwad.sdk.core.d.a.a(sb.toString());
        try {
            dVar.u = ai.i();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.b(e2);
        }
        dVar.v = i2;
        return dVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "imei", this.f32232b);
        o.a(jSONObject, "imei1", this.f32233c);
        o.a(jSONObject, IAdRequestParam.IMEI2, this.f32234d);
        o.a(jSONObject, "meid", this.f32235e);
        o.a(jSONObject, "oaid", this.f32236f);
        o.a(jSONObject, "deviceModel", this.p);
        o.a(jSONObject, "deviceBrand", this.q);
        o.a(jSONObject, "osType", this.f32237g);
        o.a(jSONObject, "osVersion", this.f32239i);
        o.a(jSONObject, "osApi", this.f32238h);
        o.a(jSONObject, "language", this.f32231a);
        o.a(jSONObject, "androidId", this.l);
        o.a(jSONObject, "deviceId", this.m);
        o.a(jSONObject, "deviceVendor", this.n);
        o.a(jSONObject, Constants.PARAM_PLATFORM, this.o);
        o.a(jSONObject, "screenWidth", this.j);
        o.a(jSONObject, "screenHeight", this.k);
        o.a(jSONObject, "appPackageName", this.t);
        if (!TextUtils.isEmpty(this.s)) {
            o.a(jSONObject, "egid", this.s);
        }
        if (!TextUtils.isEmpty(this.r)) {
            o.a(jSONObject, "deviceSig", this.r);
        }
        o.a(jSONObject, "arch", this.u);
        o.a(jSONObject, "screenDirection", this.v);
        return jSONObject;
    }
}
