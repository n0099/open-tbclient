package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class h implements com.kwad.sdk.core.webview.a.a {

    /* renamed from: a  reason: collision with root package name */
    public Handler f34640a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public a f34641b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.a.c f34642c;

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a();
    }

    public h(a aVar) {
        this.f34641b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar = this.f34641b;
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
        this.f34642c = cVar;
        this.f34640a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.c();
                if (h.this.f34642c != null) {
                    h.this.f34642c.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        this.f34641b = null;
        this.f34642c = null;
        this.f34640a.removeCallbacksAndMessages(null);
    }
}
