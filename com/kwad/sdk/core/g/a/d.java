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
/* loaded from: classes6.dex */
public class d implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f34266a;

    /* renamed from: b  reason: collision with root package name */
    public String f34267b;

    /* renamed from: c  reason: collision with root package name */
    public String f34268c;

    /* renamed from: d  reason: collision with root package name */
    public int f34269d;

    /* renamed from: e  reason: collision with root package name */
    public int f34270e;

    /* renamed from: f  reason: collision with root package name */
    public String f34271f;

    /* renamed from: g  reason: collision with root package name */
    public int f34272g;

    /* renamed from: h  reason: collision with root package name */
    public int f34273h;

    /* renamed from: i  reason: collision with root package name */
    public String f34274i;
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
        dVar.f34267b = ah.d(KsAdSDKImpl.get().getContext());
        dVar.f34268c = com.kwad.sdk.core.f.a.a();
        dVar.m = ah.e();
        dVar.n = ah.f();
        dVar.f34269d = 1;
        dVar.f34270e = ah.j();
        dVar.f34271f = ah.i();
        dVar.f34266a = ah.k();
        dVar.f34273h = ah.h(KsAdSDKImpl.get().getContext());
        dVar.f34272g = ah.g(KsAdSDKImpl.get().getContext());
        dVar.f34274i = ah.i(KsAdSDKImpl.get().getContext());
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
        o.a(jSONObject, "imei", this.f34267b);
        o.a(jSONObject, "oaid", this.f34268c);
        o.a(jSONObject, "deviceModel", this.m);
        o.a(jSONObject, "deviceBrand", this.n);
        o.a(jSONObject, "osType", this.f34269d);
        o.a(jSONObject, "osVersion", this.f34271f);
        o.a(jSONObject, "osApi", this.f34270e);
        o.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, this.f34266a);
        o.a(jSONObject, "androidId", this.f34274i);
        o.a(jSONObject, "deviceId", this.j);
        o.a(jSONObject, "deviceVendor", this.k);
        o.a(jSONObject, Constants.PARAM_PLATFORM, this.l);
        o.a(jSONObject, "screenWidth", this.f34272g);
        o.a(jSONObject, "screenHeight", this.f34273h);
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
