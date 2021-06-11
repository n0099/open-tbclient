package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34964a;

    /* renamed from: b  reason: collision with root package name */
    public b f34965b;

    /* loaded from: classes7.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34966a;

        /* renamed from: b  reason: collision with root package name */
        public int f34967b;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "width", this.f34966a);
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f34967b);
            return jSONObject;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(a aVar);
    }

    public c(com.kwad.sdk.core.webview.a aVar) {
        this.f34964a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getContainerLimit";
    }

    public void a(b bVar) {
        this.f34965b = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        a aVar = new a();
        b bVar = this.f34965b;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.f34966a = this.f34964a.f34932e.getWidth();
            aVar.f34967b = this.f34964a.f34932e.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
