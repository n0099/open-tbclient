package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f33663a;

    /* renamed from: b  reason: collision with root package name */
    public b f33664b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f33665c = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f33666a;

        /* renamed from: b  reason: collision with root package name */
        public int f33667b;

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "width", this.f33666a);
            com.kwad.sdk.utils.o.a(jSONObject, "height", this.f33667b);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(a aVar);
    }

    public c(com.kwad.sdk.core.webview.a aVar) {
        this.f33663a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "getContainerLimit";
    }

    public void a(b bVar) {
        this.f33664b = bVar;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        a aVar = new a();
        b bVar = this.f33664b;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.f33666a = this.f33663a.f33625e.getWidth();
            aVar.f33667b = this.f33663a.f33625e.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f33665c.removeCallbacksAndMessages(null);
    }
}
