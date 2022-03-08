package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class c implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public a f54925b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f54926c = new Handler(Looper.getMainLooper());

    /* loaded from: classes8.dex */
    public interface a {
        void a();
    }

    public c(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        this.a = aVar;
        this.f54925b = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        this.f54926c.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.f54925b.a();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f54926c.removeCallbacksAndMessages(null);
    }
}
