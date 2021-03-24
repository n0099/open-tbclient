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
    public final com.kwad.sdk.core.webview.a f34308a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f34309b = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f34310c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f34311d;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0394a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f34317a;
    }

    /* loaded from: classes6.dex */
    public interface b {
        @WorkerThread
        void a();
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f34308a = aVar;
        this.f34310c = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f34311d = bVar2;
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
        if (this.f34308a.f34285b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C0394a c0394a = new C0394a();
        try {
            c0394a.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.f34308a.f34290g) {
            if (this.f34311d != null) {
                handler = this.f34309b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.download.b.b.a(a.this.f34310c, c0394a.f34317a);
                        if (a.this.f34311d != null) {
                            a.this.f34311d.a();
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f34309b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.kwad.sdk.core.download.b.b.a(a.this.f34310c, c0394a.f34317a);
                com.kwad.sdk.core.download.b.a.a(a.this.f34308a.f34288e.getContext(), a.this.f34308a.f34285b, new a.InterfaceC0378a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                    @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
                    public void a() {
                        if (a.this.f34311d != null) {
                            a.this.f34311d.a();
                        }
                    }
                }, a.this.f34310c);
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34309b.removeCallbacksAndMessages(null);
        this.f34311d = null;
    }
}
