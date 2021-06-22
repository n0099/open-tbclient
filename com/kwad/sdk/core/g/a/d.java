package com.kwad.sdk.core.g.a;

import android.text.TextUtils;
import android.util.Log;
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

    /* renamed from: a  reason: collision with root package name */
    public String f34364a;

    /* renamed from: b  reason: collision with root package name */
    public String f34365b;

    /* renamed from: c  reason: collision with root package name */
    public String f34366c;

    /* renamed from: d  reason: collision with root package name */
    public int f34367d;

    /* renamed from: e  reason: collision with root package name */
    public int f34368e;

    /* renamed from: f  reason: collision with root package name */
    public String f34369f;

    /* renamed from: g  reason: collision with root package name */
    public int f34370g;

    /* renamed from: h  reason: collision with root package name */
    public int f34371h;

    /* renamed from: i  reason: collision with root package name */
    public String f34372i;
    public String j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public JSONArray q;
    public String r;

    public static d a() {
        return a(false);
    }

    public static d a(boolean z) {
        d dVar = new d();
        dVar.f34365b = ah.d(KsAdSDKImpl.get().getContext());
        dVar.f34366c = com.kwad.sdk.core.f.a.a();
        dVar.m = ah.e();
        dVar.n = ah.f();
        dVar.f34367d = 1;
        dVar.f34368e = ah.j();
        dVar.f34369f = ah.i();
        dVar.f34364a = ah.k();
        dVar.f34371h = ah.h(KsAdSDKImpl.get().getContext());
        dVar.f34370g = ah.g(KsAdSDKImpl.get().getContext());
        dVar.f34372i = ah.i(KsAdSDKImpl.get().getContext());
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

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "imei", this.f34365b);
        o.a(jSONObject, "oaid", this.f34366c);
        o.a(jSONObject, "deviceModel", this.m);
        o.a(jSONObject, "deviceBrand", this.n);
        o.a(jSONObject, "osType", this.f34367d);
        o.a(jSONObject, "osVersion", this.f34369f);
        o.a(jSONObject, "osApi", this.f34368e);
        o.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, this.f34364a);
        o.a(jSONObject, "androidId", this.f34372i);
        o.a(jSONObject, "deviceId", this.j);
        o.a(jSONObject, "deviceVendor", this.k);
        o.a(jSONObject, Constants.PARAM_PLATFORM, this.l);
        o.a(jSONObject, "screenWidth", this.f34370g);
        o.a(jSONObject, "screenHeight", this.f34371h);
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
}
