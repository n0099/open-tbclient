package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class q implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Handler f6367a = new Handler(Looper.getMainLooper());
    private a b;
    @Nullable
    private com.kwad.sdk.core.webview.a.c c;

    /* loaded from: classes3.dex */
    public interface a {
        @MainThread
        void a();
    }

    public q(a aVar) {
        this.b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b != null) {
            this.b.a();
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
        this.f6367a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.q.1
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
        this.b = null;
        this.c = null;
        this.f6367a.removeCallbacksAndMessages(null);
    }
}
