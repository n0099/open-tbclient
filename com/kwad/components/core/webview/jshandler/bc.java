package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class bc implements com.kwad.sdk.core.webview.c.a {
    @Nullable
    public com.kwad.sdk.core.webview.c.c Wl;
    public b XO;

    @KsJson
    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    /* loaded from: classes10.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "setHeaderBar";
    }

    public bc(b bVar) {
        this.XO = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.XO;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Wl = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.bc.1
            @Override // java.lang.Runnable
            public final void run() {
                bc.this.b(aVar);
                if (bc.this.Wl != null) {
                    bc.this.Wl.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.XO = null;
        this.Wl = null;
    }
}
