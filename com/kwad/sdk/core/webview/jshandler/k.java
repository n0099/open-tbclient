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
    public b f33714a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f33715b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f33716c;

    /* loaded from: classes6.dex */
    public static final class a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f33719a;

        public void a(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f33719a = jSONObject.optInt("status");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "status", this.f33719a);
            return jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        @MainThread
        void a(int i2);
    }

    public k(b bVar) {
        this.f33714a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        b bVar = this.f33714a;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "pageStatus";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f33716c = cVar;
        try {
            final a aVar = new a();
            aVar.a(new JSONObject(str));
            this.f33715b.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.a(aVar.f33719a);
                    if (k.this.f33716c != null) {
                        k.this.f33716c.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.e("WebCardPageStatusHandler", "handleJsCall error: " + e2);
            cVar.a(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f33714a = null;
        this.f33716c = null;
        this.f33715b.removeCallbacksAndMessages(null);
    }
}
