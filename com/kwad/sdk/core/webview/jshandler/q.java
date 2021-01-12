package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class q implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Handler f9613a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private a f9614b;
    @Nullable
    private com.kwad.sdk.core.webview.a.c c;

    /* loaded from: classes4.dex */
    public interface a {
        @MainThread
        void a();
    }

    public q(a aVar) {
        this.f9614b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f9614b != null) {
            this.f9614b.a();
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "replayVideo";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.c = cVar;
        this.f9613a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.this.c();
                if (q.this.c != null) {
                    q.this.c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f9614b = null;
        this.c = null;
        this.f9613a.removeCallbacksAndMessages(null);
    }
}
