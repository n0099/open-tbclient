package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class h implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    private Handler f9579a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private a f9580b;
    @Nullable
    private com.kwad.sdk.core.webview.a.c c;

    /* loaded from: classes3.dex */
    public interface a {
        @MainThread
        void a();
    }

    public h(a aVar) {
        this.f9580b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f9580b != null) {
            this.f9580b.a();
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.c = cVar;
        this.f9579a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
                if (h.this.c != null) {
                    h.this.c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f9580b = null;
        this.c = null;
        this.f9579a.removeCallbacksAndMessages(null);
    }
}
