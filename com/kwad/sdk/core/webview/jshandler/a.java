package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f35050a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f35051b = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f35052c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f35053d;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0398a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f35059a;
    }

    /* loaded from: classes7.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f35050a = aVar;
        this.f35052c = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f35053d = bVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "convert";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Handler handler;
        Runnable runnable;
        if (this.f35050a.f35027b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C0398a c0398a = new C0398a();
        try {
            c0398a.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.f35050a.f35032g) {
            if (this.f35053d != null) {
                handler = this.f35051b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.download.b.b.a(a.this.f35052c, c0398a.f35059a);
                        if (a.this.f35053d != null) {
                            a.this.f35053d.a();
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f35051b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.b.b.a(a.this.f35052c, c0398a.f35059a);
                com.kwad.sdk.core.download.b.a.a(a.this.f35050a.f35030e.getContext(), a.this.f35050a.f35027b, new a.InterfaceC0382a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
                    public void a() {
                        if (a.this.f35053d != null) {
                            a.this.f35053d.a();
                        }
                    }
                }, a.this.f35052c);
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f35051b.removeCallbacksAndMessages(null);
        this.f35053d = null;
    }
}
