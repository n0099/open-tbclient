package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i implements com.kwad.sdk.core.webview.kwai.a {
    public final Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public b f40041b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f40042c;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
    }

    /* loaded from: classes7.dex */
    public interface b {
        @MainThread
        void a(int i);
    }

    public i(b bVar) {
        this.f40041b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        b bVar = this.f40041b;
        if (bVar != null) {
            bVar.a(i);
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
            this.f40042c = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.a(aVar.a);
                    if (i.this.f40042c != null) {
                        i.this.f40042c.a(null);
                    }
                }
            });
        } catch (Exception e2) {
            this.f40042c.a(-1, e2.getMessage());
            com.kwad.sdk.core.d.a.b(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.f40041b = null;
        this.f40042c = null;
        this.a.removeCallbacksAndMessages(null);
    }
}
