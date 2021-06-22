package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.core.webview.a.a {

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public String f35066a;

        /* renamed from: b  reason: collision with root package name */
        public String f35067b;

        /* renamed from: c  reason: collision with root package name */
        public String f35068c;

        /* renamed from: d  reason: collision with root package name */
        public String f35069d;

        /* renamed from: e  reason: collision with root package name */
        public String f35070e;

        /* renamed from: f  reason: collision with root package name */
        public String f35071f;

        /* renamed from: g  reason: collision with root package name */
        public String f35072g;

        /* renamed from: h  reason: collision with root package name */
        public String f35073h;

        /* renamed from: i  reason: collision with root package name */
        public int f35074i;
        public int j;
        public String k;
        public String l;
        public String m;
        public String n;
        public int o;
        public int p;

        public static a a() {
            a aVar = new a();
            aVar.f35066a = ah.l(KsAdSDKImpl.get().getContext());
            aVar.f35067b = "";
            aVar.f35068c = String.valueOf(v.d(KsAdSDKImpl.get().getContext()));
            aVar.f35069d = ah.g();
            aVar.f35070e = ah.e();
            aVar.f35071f = ah.i();
            aVar.f35072g = ah.d();
            aVar.f35073h = ah.m();
            aVar.f35074i = ao.c(KsAdSDKImpl.get().getContext());
            aVar.j = ao.b(KsAdSDKImpl.get().getContext());
            aVar.k = ah.d(KsAdSDKImpl.get().getContext());
            aVar.l = com.kwad.sdk.core.f.a.a();
            aVar.m = ah.i(KsAdSDKImpl.get().getContext());
            aVar.n = ah.k(KsAdSDKImpl.get().getContext());
            aVar.o = ao.a(KsAdSDKImpl.get().getContext());
            aVar.p = ao.a(KsAdSDKImpl.get().getContext(), 50.0f);
            return aVar;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "appVersion", this.f35066a);
            com.kwad.sdk.utils.o.a(jSONObject, "globalId", this.f35067b);
            com.kwad.sdk.utils.o.a(jSONObject, "networkType", this.f35068c);
            com.kwad.sdk.utils.o.a(jSONObject, "manufacturer", this.f35069d);
            com.kwad.sdk.utils.o.a(jSONObject, "model", this.f35070e);
            com.kwad.sdk.utils.o.a(jSONObject, "systemVersion", this.f35071f);
            com.kwad.sdk.utils.o.a(jSONObject, "locale", this.f35072g);
            com.kwad.sdk.utils.o.a(jSONObject, "uuid", this.f35073h);
            com.kwad.sdk.utils.o.a(jSONObject, "screenWidth", this.f35074i);
            com.kwad.sdk.utils.o.a(jSONObject, "screenHeight", this.j);
            com.kwad.sdk.utils.o.a(jSONObject, "imei", this.k);
            com.kwad.sdk.utils.o.a(jSONObject, "oaid", this.l);
            com.kwad.sdk.utils.o.a(jSONObject, "androidId", this.m);
            com.kwad.sdk.utils.o.a(jSONObject, "mac", this.n);
            com.kwad.sdk.utils.o.a(jSONObject, "statusBarHeight", this.o);
            com.kwad.sdk.utils.o.a(jSONObject, "titleBarHeight", this.p);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        cVar.a(a.a());
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
