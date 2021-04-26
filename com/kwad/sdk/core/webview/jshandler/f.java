package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f33679a;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f33680a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "screenOrientation", this.f33680a);
            return jSONObject;
        }
    }

    public f(com.kwad.sdk.core.webview.a aVar) {
        this.f33679a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getScreenOrientation";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f33679a.f33622b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        aVar.f33680a = this.f33679a.f33621a;
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
