package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class q implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f34405a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public a f34406b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34407c;

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a();
    }

    public q(a aVar) {
        this.f34406b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f34406b;
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
        this.f34407c = cVar;
        this.f34405a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.q.1
            @Override // java.lang.Runnable
            public void run() {
                q.this.c();
                if (q.this.f34407c != null) {
                    q.this.f34407c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34406b = null;
        this.f34407c = null;
        this.f34405a.removeCallbacksAndMessages(null);
    }
}
