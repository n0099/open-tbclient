package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final com.kwad.sdk.core.webview.a f9860a;

    /* renamed from: b  reason: collision with root package name */
    private b f9861b;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f9862a;

        /* renamed from: b  reason: collision with root package name */
        public int f9863b;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "width", this.f9862a);
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f9863b);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(a aVar);
    }

    public c(com.kwad.sdk.core.webview.a aVar) {
        this.f9860a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getContainerLimit";
    }

    public void a(b bVar) {
        this.f9861b = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        a aVar = new a();
        if (this.f9861b != null) {
            this.f9861b.a(aVar);
            cVar.a(aVar);
            return;
        }
        aVar.f9862a = this.f9860a.e.getWidth();
        aVar.f9863b = this.f9860a.e.getHeight();
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
