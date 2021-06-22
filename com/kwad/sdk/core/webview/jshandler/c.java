package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35062a;

    /* renamed from: b  reason: collision with root package name */
    public b f35063b;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f35064a;

        /* renamed from: b  reason: collision with root package name */
        public int f35065b;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "width", this.f35064a);
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f35065b);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(a aVar);
    }

    public c(com.kwad.sdk.core.webview.a aVar) {
        this.f35062a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getContainerLimit";
    }

    public void a(b bVar) {
        this.f35063b = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        a aVar = new a();
        b bVar = this.f35063b;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.f35064a = this.f35062a.f35030e.getWidth();
            aVar.f35065b = this.f35062a.f35030e.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
