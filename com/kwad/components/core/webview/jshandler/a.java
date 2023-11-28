package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    public b VB;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0664a extends com.kwad.sdk.core.response.a.a {
        public String Jw;
        public String VE;
        public String VF;
    }

    /* loaded from: classes10.dex */
    public interface b {
        void c(C0664a c0664a);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public a(b bVar) {
        this.VB = bVar;
    }

    private void b(final C0664a c0664a) {
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.VB != null) {
                    a.this.VB.c(c0664a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0664a c0664a = new C0664a();
            c0664a.parseJson(new JSONObject(str));
            b(c0664a);
        } catch (Throwable unused) {
        }
    }
}
