package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34719a;

    /* renamed from: b  reason: collision with root package name */
    public a f34720b;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes6.dex */
    public static final class b implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34721a;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "screenOrientation", this.f34721a);
            return jSONObject;
        }
    }

    public f(com.kwad.sdk.core.webview.a aVar) {
        this.f34719a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getScreenOrientation";
    }

    public void a(a aVar) {
        this.f34720b = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        if (this.f34719a.f34670b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        a aVar = this.f34720b;
        if (aVar != null) {
            aVar.a();
        }
        b bVar = new b();
        bVar.f34721a = this.f34719a.f34669a;
        cVar.a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
