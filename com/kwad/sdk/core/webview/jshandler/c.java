package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34610a;

    /* renamed from: b  reason: collision with root package name */
    public b f34611b;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34612a;

        /* renamed from: b  reason: collision with root package name */
        public int f34613b;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "width", this.f34612a);
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f34613b);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(a aVar);
    }

    public c(com.kwad.sdk.core.webview.a aVar) {
        this.f34610a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getContainerLimit";
    }

    public void a(b bVar) {
        this.f34611b = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        a aVar = new a();
        b bVar = this.f34611b;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.f34612a = this.f34610a.f34578e.getWidth();
            aVar.f34613b = this.f34610a.f34578e.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
    }
}
