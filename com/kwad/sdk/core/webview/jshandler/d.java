package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d implements com.kwad.sdk.core.webview.a.a {

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public String f32913a;

        /* renamed from: b  reason: collision with root package name */
        public String f32914b;

        /* renamed from: c  reason: collision with root package name */
        public String f32915c;

        /* renamed from: d  reason: collision with root package name */
        public String f32916d;

        /* renamed from: e  reason: collision with root package name */
        public String f32917e;

        /* renamed from: f  reason: collision with root package name */
        public String f32918f;

        /* renamed from: g  reason: collision with root package name */
        public String f32919g;

        /* renamed from: h  reason: collision with root package name */
        public String f32920h;

        /* renamed from: i  reason: collision with root package name */
        public int f32921i;
        public int j;
        public String k;
        public String l;
        public String m;
        public String n;
        public int o;
        public int p;

        public static a a() {
            a aVar = new a();
            aVar.f32913a = ai.n(KsAdSDKImpl.get().getContext());
            aVar.f32914b = "";
            aVar.f32915c = String.valueOf(t.c(KsAdSDKImpl.get().getContext()));
            aVar.f32916d = ai.g();
            aVar.f32917e = ai.e();
            aVar.f32918f = ai.j();
            aVar.f32919g = ai.d();
            aVar.f32920h = ai.n();
            aVar.f32921i = an.c(KsAdSDKImpl.get().getContext());
            aVar.j = an.b(KsAdSDKImpl.get().getContext());
            aVar.k = ai.d(KsAdSDKImpl.get().getContext());
            aVar.l = com.kwad.sdk.core.f.a.b();
            aVar.m = ai.k(KsAdSDKImpl.get().getContext());
            aVar.n = ai.m(KsAdSDKImpl.get().getContext());
            aVar.o = an.a(KsAdSDKImpl.get().getContext());
            aVar.p = an.a(KsAdSDKImpl.get().getContext(), 50.0f);
            return aVar;
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "appVersion", this.f32913a);
            com.kwad.sdk.utils.o.a(jSONObject, "globalId", this.f32914b);
            com.kwad.sdk.utils.o.a(jSONObject, "networkType", this.f32915c);
            com.kwad.sdk.utils.o.a(jSONObject, "manufacturer", this.f32916d);
            com.kwad.sdk.utils.o.a(jSONObject, "model", this.f32917e);
            com.kwad.sdk.utils.o.a(jSONObject, "systemVersion", this.f32918f);
            com.kwad.sdk.utils.o.a(jSONObject, "locale", this.f32919g);
            com.kwad.sdk.utils.o.a(jSONObject, "uuid", this.f32920h);
            com.kwad.sdk.utils.o.a(jSONObject, "screenWidth", this.f32921i);
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
