package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public class q implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f35051a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public a f35052b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f35053c;

    /* loaded from: classes7.dex */
    public interface a {
        @MainThread
        void a();
    }

    public q(a aVar) {
        this.f35052b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f35052b;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "replayVideo";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f35053c = cVar;
        this.f35051a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.this.c();
                if (q.this.f35053c != null) {
                    q.this.f35053c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f35052b = null;
        this.f35053c = null;
        this.f35051a.removeCallbacksAndMessages(null);
    }
}
