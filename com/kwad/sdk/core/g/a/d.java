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
    public String f33641a;

    /* renamed from: b  reason: collision with root package name */
    public String f33642b;

    /* renamed from: c  reason: collision with root package name */
    public String f33643c;

    /* renamed from: d  reason: collision with root package name */
    public int f33644d;

    /* renamed from: e  reason: collision with root package name */
    public int f33645e;

    /* renamed from: f  reason: collision with root package name */
    public String f33646f;

    /* renamed from: g  reason: collision with root package name */
    public int f33647g;

    /* renamed from: h  reason: collision with root package name */
    public int f33648h;
    public String i;
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
        dVar.f33642b = ah.d(KsAdSDKImpl.get().getContext());
        dVar.f33643c = com.kwad.sdk.core.f.a.a();
        dVar.m = ah.e();
        dVar.n = ah.f();
        dVar.f33644d = 1;
        dVar.f33645e = ah.j();
        dVar.f33646f = ah.i();
        dVar.f33641a = ah.k();
        dVar.f33648h = ah.h(KsAdSDKImpl.get().getContext());
        dVar.f33647g = ah.g(KsAdSDKImpl.get().getContext());
        dVar.i = ah.i(KsAdSDKImpl.get().getContext());
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
        o.a(jSONObject, "imei", this.f33642b);
        o.a(jSONObject, "oaid", this.f33643c);
        o.a(jSONObject, "deviceModel", this.m);
        o.a(jSONObject, "deviceBrand", this.n);
        o.a(jSONObject, "osType", this.f33644d);
        o.a(jSONObject, "osVersion", this.f33646f);
        o.a(jSONObject, "osApi", this.f33645e);
        o.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, this.f33641a);
        o.a(jSONObject, "androidId", this.i);
        o.a(jSONObject, "deviceId", this.j);
        o.a(jSONObject, "deviceVendor", this.k);
        o.a(jSONObject, Constants.PARAM_PLATFORM, this.l);
        o.a(jSONObject, "screenWidth", this.f33647g);
        o.a(jSONObject, "screenHeight", this.f33648h);
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
