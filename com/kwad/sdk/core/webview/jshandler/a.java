package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.download.b.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f33648a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f33649b = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f33650c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f33651d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f33652e;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0386a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f33658a;
    }

    /* loaded from: classes6.dex */
    public interface b {
        @WorkerThread
        void a(@Nullable C0386a c0386a);
    }

    /* loaded from: classes6.dex */
    public interface c {
        @MainThread
        void a(int i2);
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f33648a = aVar;
        this.f33650c = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f33651d = bVar2;
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
        if (this.f33648a.f33622b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C0386a c0386a = new C0386a();
        try {
            c0386a.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.f33648a.f33627g) {
            if (this.f33651d != null) {
                handler = this.f33649b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f33651d != null) {
                            a.this.f33651d.a(c0386a);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f33649b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f33648a.f33628h || c0386a.f33658a) {
                    int a2 = com.kwad.sdk.core.download.b.a.a(a.this.f33648a.f33625e.getContext(), a.this.f33648a.f33622b, new a.InterfaceC0376a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
                        public void a() {
                            if (a.this.f33651d != null) {
                                a.this.f33651d.a(c0386a);
                            }
                        }
                    }, a.this.f33650c, c0386a.f33658a);
                    if (a.this.f33652e != null) {
                        a.this.f33652e.a(a2);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f33649b.removeCallbacksAndMessages(null);
        this.f33651d = null;
    }
}
