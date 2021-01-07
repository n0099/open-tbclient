package com.kwad.sdk.core.g.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwai.video.player.KsMediaMeta;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public String f9461a;

    /* renamed from: b  reason: collision with root package name */
    private String f9462b;
    private String c;
    private int d;
    private int e;
    private String f;
    private int g;
    private int h;
    private String i;
    private String j;
    private String k;
    private int l;
    private String m;
    private String n;
    private String o;
    private String p;
    private JSONArray q;
    private String r;

    public static d a() {
        return a(false);
    }

    public static d a(boolean z) {
        d dVar = new d();
        dVar.f9462b = ah.d(KsAdSDKImpl.get().getContext());
        dVar.c = com.kwad.sdk.core.f.a.a();
        dVar.m = ah.e();
        dVar.n = ah.f();
        dVar.d = 1;
        dVar.e = ah.j();
        dVar.f = ah.i();
        dVar.f9461a = ah.k();
        dVar.h = ah.h(KsAdSDKImpl.get().getContext());
        dVar.g = ah.g(KsAdSDKImpl.get().getContext());
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
        } catch (Exception e) {
        }
        return dVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "imei", this.f9462b);
        o.a(jSONObject, "oaid", this.c);
        o.a(jSONObject, "deviceModel", this.m);
        o.a(jSONObject, "deviceBrand", this.n);
        o.a(jSONObject, HttpConstants.HTTP_OS_TYPE_OLD, this.d);
        o.a(jSONObject, "osVersion", this.f);
        o.a(jSONObject, "osApi", this.e);
        o.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, this.f9461a);
        o.a(jSONObject, "androidId", this.i);
        o.a(jSONObject, "deviceId", this.j);
        o.a(jSONObject, "deviceVendor", this.k);
        o.a(jSONObject, "platform", this.l);
        o.a(jSONObject, "screenWidth", this.g);
        o.a(jSONObject, "screenHeight", this.h);
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
