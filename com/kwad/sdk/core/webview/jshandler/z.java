package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class z implements com.kwad.sdk.core.webview.kwai.a {
    public static Handler c;
    public com.kwad.sdk.core.webview.a a;
    public com.kwad.sdk.core.download.a.b b;
    public b d;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
    }

    /* loaded from: classes5.dex */
    public interface b {
        @MainThread
        void a(int i);
    }

    public z(com.kwad.sdk.core.webview.a aVar, com.kwad.sdk.core.download.a.b bVar, b bVar2) {
        this.a = aVar;
        this.b = bVar;
        this.d = bVar2;
        if (c == null) {
            c = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            final int i = aVar.a;
            c.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.z.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.d != null) {
                        z.this.d.a(i);
                    }
                }
            });
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
