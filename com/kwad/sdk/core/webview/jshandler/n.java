package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private com.kwad.sdk.core.webview.a.c f6360a;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        private String f6361a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "lifeStatus", this.f6361a);
            return jSONObject;
        }
    }

    private void a(String str) {
        if (this.f6360a != null) {
            a aVar = new a();
            aVar.f6361a = str;
            this.f6360a.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerLifecycleListener";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f6360a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f6360a = null;
    }

    public void c() {
        a("showStart");
    }

    public void d() {
        a("showEnd");
    }

    public void e() {
        a("hideStart");
    }

    public void f() {
        a("hideEnd");
    }
}
