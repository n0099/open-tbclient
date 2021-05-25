package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f32870a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public a f32871b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f32872c;

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a();
    }

    public h(a aVar) {
        this.f32871b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f32871b;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        this.f32872c = cVar;
        this.f32870a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
                if (h.this.f32872c != null) {
                    h.this.f32872c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f32871b = null;
        this.f32872c = null;
        this.f32870a.removeCallbacksAndMessages(null);
    }
}
