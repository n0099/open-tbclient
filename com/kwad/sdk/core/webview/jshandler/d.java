package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements com.kwad.sdk.core.webview.a.a {

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public String f34324a;

        /* renamed from: b  reason: collision with root package name */
        public String f34325b;

        /* renamed from: c  reason: collision with root package name */
        public String f34326c;

        /* renamed from: d  reason: collision with root package name */
        public String f34327d;

        /* renamed from: e  reason: collision with root package name */
        public String f34328e;

        /* renamed from: f  reason: collision with root package name */
        public String f34329f;

        /* renamed from: g  reason: collision with root package name */
        public String f34330g;

        /* renamed from: h  reason: collision with root package name */
        public String f34331h;
        public int i;
        public int j;
        public String k;
        public String l;
        public String m;
        public String n;
        public int o;
        public int p;

        public static a a() {
            a aVar = new a();
            aVar.f34324a = ah.l(KsAdSDKImpl.get().getContext());
            aVar.f34325b = "";
            aVar.f34326c = String.valueOf(v.d(KsAdSDKImpl.get().getContext()));
            aVar.f34327d = ah.g();
            aVar.f34328e = ah.e();
            aVar.f34329f = ah.i();
            aVar.f34330g = ah.d();
            aVar.f34331h = ah.m();
            aVar.i = ao.c(KsAdSDKImpl.get().getContext());
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
            com.kwad.sdk.utils.o.a(jSONObject, "appVersion", this.f34324a);
            com.kwad.sdk.utils.o.a(jSONObject, "globalId", this.f34325b);
            com.kwad.sdk.utils.o.a(jSONObject, "networkType", this.f34326c);
            com.kwad.sdk.utils.o.a(jSONObject, "manufacturer", this.f34327d);
            com.kwad.sdk.utils.o.a(jSONObject, "model", this.f34328e);
            com.kwad.sdk.utils.o.a(jSONObject, "systemVersion", this.f34329f);
            com.kwad.sdk.utils.o.a(jSONObject, "locale", this.f34330g);
            com.kwad.sdk.utils.o.a(jSONObject, "uuid", this.f34331h);
            com.kwad.sdk.utils.o.a(jSONObject, "screenWidth", this.i);
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
