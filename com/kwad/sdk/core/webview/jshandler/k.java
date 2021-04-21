package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public b f34753a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f34754b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34755c;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f34758a;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f34758a = jSONObject.optInt("status");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f34758a);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(int i);
    }

    public k(b bVar) {
        this.f34753a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        b bVar = this.f34753a;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f34755c = cVar;
        try {
            final a aVar = new a();
            aVar.a(new JSONObject(str));
            this.f34754b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.a(aVar.f34758a);
                    if (k.this.f34755c != null) {
                        k.this.f34755c.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.d("WebCardPageStatusHandler", "handleJsCall error: " + e2);
            cVar.a(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34753a = null;
        this.f34755c = null;
        this.f34754b.removeCallbacksAndMessages(null);
    }
}
