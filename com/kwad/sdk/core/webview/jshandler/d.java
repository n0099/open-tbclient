package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
        public String f34709a;

        /* renamed from: b  reason: collision with root package name */
        public String f34710b;

        /* renamed from: c  reason: collision with root package name */
        public String f34711c;

        /* renamed from: d  reason: collision with root package name */
        public String f34712d;

        /* renamed from: e  reason: collision with root package name */
        public String f34713e;

        /* renamed from: f  reason: collision with root package name */
        public String f34714f;

        /* renamed from: g  reason: collision with root package name */
        public String f34715g;

        /* renamed from: h  reason: collision with root package name */
        public String f34716h;
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
            aVar.f34709a = ah.l(KsAdSDKImpl.get().getContext());
            aVar.f34710b = "";
            aVar.f34711c = String.valueOf(v.d(KsAdSDKImpl.get().getContext()));
            aVar.f34712d = ah.g();
            aVar.f34713e = ah.e();
            aVar.f34714f = ah.i();
            aVar.f34715g = ah.d();
            aVar.f34716h = ah.m();
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
            com.kwad.sdk.utils.o.a(jSONObject, "appVersion", this.f34709a);
            com.kwad.sdk.utils.o.a(jSONObject, "globalId", this.f34710b);
            com.kwad.sdk.utils.o.a(jSONObject, "networkType", this.f34711c);
            com.kwad.sdk.utils.o.a(jSONObject, "manufacturer", this.f34712d);
            com.kwad.sdk.utils.o.a(jSONObject, "model", this.f34713e);
            com.kwad.sdk.utils.o.a(jSONObject, "systemVersion", this.f34714f);
            com.kwad.sdk.utils.o.a(jSONObject, "locale", this.f34715g);
            com.kwad.sdk.utils.o.a(jSONObject, "uuid", this.f34716h);
            com.kwad.sdk.utils.o.a(jSONObject, "screenWidth", this.i);
            com.kwad.sdk.utils.o.a(jSONObject, "screenHeight", this.j);
            com.kwad.sdk.utils.o.a(jSONObject, "imei", this.k);
            com.kwad.sdk.utils.o.a(jSONObject, "oaid", this.l);
            com.kwad.sdk.utils.o.a(jSONObject, "androidId", this.m);
            com.kwad.sdk.utils.o.a(jSONObject, IAdRequestParam.MAC, this.n);
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
