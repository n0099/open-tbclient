package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34335a;

    /* renamed from: b  reason: collision with root package name */
    public a f34336b;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes6.dex */
    public static final class b implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34337a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "screenOrientation", this.f34337a);
            return jSONObject;
        }
    }

    public f(com.kwad.sdk.core.webview.a aVar) {
        this.f34335a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getScreenOrientation";
    }

    public void a(a aVar) {
        this.f34336b = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f34335a.f34286b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        a aVar = this.f34336b;
        if (aVar != null) {
            aVar.a();
        }
        b bVar = new b();
        bVar.f34337a = this.f34335a.f34285a;
        cVar.a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
