package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f6339a;
    private a b;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes3.dex */
    public static final class b implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        private int f6340a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "screenOrientation", this.f6340a);
            return jSONObject;
        }
    }

    public f(com.kwad.sdk.core.webview.a aVar) {
        this.f6339a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getScreenOrientation";
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f6339a.b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        if (this.b != null) {
            this.b.a();
        }
        b bVar = new b();
        bVar.f6340a = this.f6339a.f6320a;
        cVar.a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
