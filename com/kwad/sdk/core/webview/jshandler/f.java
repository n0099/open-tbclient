package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35077a;

    /* renamed from: b  reason: collision with root package name */
    public a f35078b;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes7.dex */
    public static final class b implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f35079a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "screenOrientation", this.f35079a);
            return jSONObject;
        }
    }

    public f(com.kwad.sdk.core.webview.a aVar) {
        this.f35077a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getScreenOrientation";
    }

    public void a(a aVar) {
        this.f35078b = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f35077a.f35027b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        a aVar = this.f35078b;
        if (aVar != null) {
            aVar.a();
        }
        b bVar = new b();
        bVar.f35079a = this.f35077a.f35026a;
        cVar.a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
