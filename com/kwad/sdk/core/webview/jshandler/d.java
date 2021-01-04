package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.ar.constants.HttpConstants;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements com.kwad.sdk.core.webview.a.a {

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        private String f9864a;

        /* renamed from: b  reason: collision with root package name */
        private String f9865b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private int i;
        private int j;
        private String k;
        private String l;
        private String m;
        private String n;
        private int o;
        private int p;

        public static a a() {
            a aVar = new a();
            aVar.f9864a = ah.l(KsAdSDKImpl.get().getContext());
            aVar.f9865b = "";
            aVar.c = String.valueOf(v.d(KsAdSDKImpl.get().getContext()));
            aVar.d = ah.g();
            aVar.e = ah.e();
            aVar.f = ah.i();
            aVar.g = ah.d();
            aVar.h = ah.m();
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
            com.kwad.sdk.utils.o.a(jSONObject, "appVersion", this.f9864a);
            com.kwad.sdk.utils.o.a(jSONObject, "globalId", this.f9865b);
            com.kwad.sdk.utils.o.a(jSONObject, "networkType", this.c);
            com.kwad.sdk.utils.o.a(jSONObject, HttpConstants.HTTP_MANUFACTURER, this.d);
            com.kwad.sdk.utils.o.a(jSONObject, "model", this.e);
            com.kwad.sdk.utils.o.a(jSONObject, "systemVersion", this.f);
            com.kwad.sdk.utils.o.a(jSONObject, "locale", this.g);
            com.kwad.sdk.utils.o.a(jSONObject, "uuid", this.h);
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
