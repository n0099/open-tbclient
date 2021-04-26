package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f33696a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public a f33697b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f33698c;

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a();
    }

    public h(a aVar) {
        this.f33697b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f33697b;
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
        this.f33698c = cVar;
        this.f33696a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
                if (h.this.f33698c != null) {
                    h.this.f33698c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f33697b = null;
        this.f33698c = null;
        this.f33696a.removeCallbacksAndMessages(null);
    }
}
