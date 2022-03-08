package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i implements com.kwad.sdk.core.webview.kwai.a {
    public final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public b f54955b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f54956c;

    /* loaded from: classes8.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
    }

    /* loaded from: classes8.dex */
    public interface b {
        @MainThread
        void a(int i2);
    }

    public i(b bVar) {
        this.f54955b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        b bVar = this.f54955b;
        if (bVar != null) {
            bVar.a(i2);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        try {
            this.f54956c = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.a(aVar.a);
                    if (i.this.f54956c != null) {
                        i.this.f54956c.a(null);
                    }
                }
            });
        } catch (Exception e2) {
            this.f54956c.a(-1, e2.getMessage());
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f54955b = null;
        this.f54956c = null;
        this.a.removeCallbacksAndMessages(null);
    }
}
