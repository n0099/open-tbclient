package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private b f9889a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f9890b = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.a.c c;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f9893a;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f9893a = jSONObject.optInt("status");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f9893a);
            return jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        @MainThread
        void a(int i);
    }

    public k(b bVar) {
        this.f9889a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.f9889a != null) {
            this.f9889a.a(i);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.c = cVar;
        try {
            final a aVar = new a();
            aVar.a(new JSONObject(str));
            this.f9890b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.a(aVar.f9893a);
                    if (k.this.c != null) {
                        k.this.c.a(null);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.d("WebCardPageStatusHandler", "handleJsCall error: " + e);
            cVar.a(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f9889a = null;
        this.c = null;
        this.f9890b.removeCallbacksAndMessages(null);
    }
}
