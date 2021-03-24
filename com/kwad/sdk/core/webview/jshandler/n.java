package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34391a;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public String f34392a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "lifeStatus", this.f34392a);
            return jSONObject;
        }
    }

    private void a(String str) {
        if (this.f34391a != null) {
            a aVar = new a();
            aVar.f34392a = str;
            this.f34391a.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "registerLifecycleListener";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34391a = cVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34391a = null;
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
