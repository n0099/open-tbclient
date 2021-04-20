package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class q implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f34694a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public a f34695b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34696c;

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a();
    }

    public q(a aVar) {
        this.f34695b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f34695b;
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
        this.f34696c = cVar;
        this.f34694a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.this.c();
                if (q.this.f34696c != null) {
                    q.this.f34696c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34695b = null;
        this.f34696c = null;
        this.f34694a.removeCallbacksAndMessages(null);
    }
}
