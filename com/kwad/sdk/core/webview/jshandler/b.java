package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public class b implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f33659a;

    /* renamed from: b  reason: collision with root package name */
    public a f33660b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f33661c = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public b(com.kwad.sdk.core.webview.a aVar, a aVar2) {
        this.f33659a = aVar;
        this.f33660b = aVar2;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "dislike";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f33661c.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f33660b.a();
            }
        });
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f33661c.removeCallbacksAndMessages(null);
    }
}
