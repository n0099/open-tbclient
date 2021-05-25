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
    public final com.kwad.sdk.core.webview.a f32822a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f32823b = new Handler(Looper.getMainLooper());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.core.download.b.b f32824c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public b f32825d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public c f32826e;

    /* renamed from: com.kwad.sdk.core.webview.jshandler.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0374a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f32832a;
    }

    /* loaded from: classes6.dex */
    public interface b {
        @WorkerThread
        void a(@Nullable C0374a c0374a);
    }

    /* loaded from: classes6.dex */
    public interface c {
        @MainThread
        void a(int i2);
    }

    public a(@NonNull com.kwad.sdk.core.webview.a aVar, @Nullable com.kwad.sdk.core.download.b.b bVar, @Nullable b bVar2) {
        this.f32822a = aVar;
        this.f32824c = bVar;
        if (bVar != null) {
            bVar.a(1);
        }
        this.f32825d = bVar2;
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
        if (this.f32822a.f32796b == null) {
            cVar.a(-1, "native adTemplate is null");
            return;
        }
        final C0374a c0374a = new C0374a();
        try {
            c0374a.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (!this.f32822a.f32801g) {
            if (this.f32825d != null) {
                handler = this.f32823b;
                runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f32825d != null) {
                            a.this.f32825d.a(c0374a);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        handler = this.f32823b;
        runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f32822a.f32802h || c0374a.f32832a) {
                    int a2 = com.kwad.sdk.core.download.b.a.a(a.this.f32822a.f32799e.getContext(), a.this.f32822a.f32796b, new a.InterfaceC0364a() { // from class: com.kwad.sdk.core.webview.jshandler.a.1.1
                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
                        public void a() {
                            if (a.this.f32825d != null) {
                                a.this.f32825d.a(c0374a);
                            }
                        }
                    }, a.this.f32824c, c0374a.f32832a);
                    if (a.this.f32826e != null) {
                        a.this.f32826e.a(a2);
                    }
                }
            }
        };
        handler.post(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f32823b.removeCallbacksAndMessages(null);
        this.f32825d = null;
    }
}
