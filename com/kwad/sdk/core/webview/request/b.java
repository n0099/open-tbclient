package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.webview.jshandler.w;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static final Handler a = new Handler(Looper.getMainLooper());

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        @MainThread
        void a(int i2, String str);

        @MainThread
        void a(@NonNull WebCardGetDataResponse webCardGetDataResponse);
    }

    public void a(final w.a aVar, @NonNull final a aVar2) {
        new i<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public WebCardGetDataResponse b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.webview.request.a b() {
                w.a aVar3 = aVar;
                return new com.kwad.sdk.core.webview.request.a(aVar3.a, aVar3.f55021b, aVar3.f55022c);
            }
        }.a(new j<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.webview.request.a aVar3) {
                super.a((AnonymousClass2) aVar3);
                com.kwad.sdk.core.d.a.a("WebCardGetDataRequestManager", "onStartRequest");
                b.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar2.a();
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.webview.request.a aVar3, final int i2, final String str) {
                com.kwad.sdk.core.d.a.a("WebCardGetDataRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
                b.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.a("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        aVar2.a(i2, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.webview.request.a aVar3, @NonNull final WebCardGetDataResponse webCardGetDataResponse) {
                com.kwad.sdk.core.d.a.a("WebCardGetDataRequestManager", "onSuccess");
                b.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }
        });
    }
}
