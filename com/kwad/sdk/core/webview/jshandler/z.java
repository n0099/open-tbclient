package com.kwad.sdk.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class z implements com.kwad.sdk.core.webview.kwai.a {

    /* renamed from: c  reason: collision with root package name */
    public static Handler f56506c;
    public com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.download.a.b f56507b;

    /* renamed from: d  reason: collision with root package name */
    public b f56508d;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int a;
    }

    /* loaded from: classes3.dex */
    public interface b {
        @MainThread
        void a(int i2);
    }

    public z(com.kwad.sdk.core.webview.a aVar, com.kwad.sdk.core.download.a.b bVar, b bVar2) {
        this.a = aVar;
        this.f56507b = bVar;
        this.f56508d = bVar2;
        if (f56506c == null) {
            f56506c = new Handler(Looper.getMainLooper());
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
            final int i2 = aVar.a;
            f56506c.post(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.z.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.f56508d != null) {
                        z.this.f56508d.a(i2);
                    }
                }
            });
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
    }
}
