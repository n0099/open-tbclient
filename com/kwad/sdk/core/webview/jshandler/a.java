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
    public final com.kwad.sdk.core.webview.a f34952a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f34953b = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f34954c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34955d;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0395a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f34961a;
    }

    /* loaded from: classes7.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f34952a = aVar;
        this.f34954c = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f34955d = bVar2;
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
        if (this.f34952a.f34929b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C0395a c0395a = new C0395a();
        try {
            c0395a.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.f34952a.f34934g) {
            if (this.f34955d != null) {
                handler = this.f34953b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.download.b.b.a(a.this.f34954c, c0395a.f34961a);
                        if (a.this.f34955d != null) {
                            a.this.f34955d.a();
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f34953b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.b.b.a(a.this.f34954c, c0395a.f34961a);
                com.kwad.sdk.core.download.b.a.a(a.this.f34952a.f34932e.getContext(), a.this.f34952a.f34929b, new a.InterfaceC0379a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                    public void a() {
                        if (a.this.f34955d != null) {
                            a.this.f34955d.a();
                        }
                    }
                }, a.this.f34954c);
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34953b.removeCallbacksAndMessages(null);
        this.f34955d = null;
    }
}
