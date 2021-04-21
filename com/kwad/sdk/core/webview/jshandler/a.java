package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f34693a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f34694b = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f34695c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34696d;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0412a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f34702a;
    }

    /* loaded from: classes6.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f34693a = aVar;
        this.f34695c = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f34696d = bVar2;
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
        if (this.f34693a.f34670b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C0412a c0412a = new C0412a();
        try {
            c0412a.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.f34693a.f34675g) {
            if (this.f34696d != null) {
                handler = this.f34694b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.download.b.b.a(a.this.f34695c, c0412a.f34702a);
                        if (a.this.f34696d != null) {
                            a.this.f34696d.a();
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f34694b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.b.b.a(a.this.f34695c, c0412a.f34702a);
                com.kwad.sdk.core.download.b.a.a(a.this.f34693a.f34673e.getContext(), a.this.f34693a.f34670b, new a.InterfaceC0396a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
                    public void a() {
                        if (a.this.f34696d != null) {
                            a.this.f34696d.a();
                        }
                    }
                }, a.this.f34695c);
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34694b.removeCallbacksAndMessages(null);
        this.f34696d = null;
    }
}
