package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i implements com.kwad.sdk.core.webview.kwai.a {
    public final Handler a = new Handler(Looper.getMainLooper());
    public b b;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c c;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
    }

    /* loaded from: classes5.dex */
    public interface b {
        @MainThread
        void a(int i);
    }

    public i(b bVar) {
        this.b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        b bVar = this.b;
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
            this.c = cVar;
            final a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.a(aVar.a);
                    if (i.this.c != null) {
                        i.this.c.a(null);
                    }
                }
            });
        } catch (Exception e) {
            this.c.a(-1, e.getMessage());
            com.kwad.sdk.core.d.a.b(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        this.b = null;
        this.c = null;
        this.a.removeCallbacksAndMessages(null);
    }
}
