package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p implements com.kwad.sdk.core.webview.kwai.a {
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f56423b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f56424c;

    /* loaded from: classes3.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f56426b;
    }

    /* loaded from: classes3.dex */
    public interface b {
        @MainThread
        void a(a aVar);
    }

    public p(b bVar) {
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f56424c = cVar;
        try {
            final a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            this.f56423b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.p.1
                @Override // java.lang.Runnable
                public void run() {
                    p.this.a(aVar);
                    if (p.this.f56424c != null) {
                        p.this.f56424c.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.e("WebCardPageStatusHandler", "handleJsCall error: " + e2);
            cVar.a(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.a = null;
        this.f56424c = null;
        this.f56423b.removeCallbacksAndMessages(null);
    }
}
