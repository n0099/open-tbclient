package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.webview.a.b;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static final Handler a = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public interface a {
        @MainThread
        void a(int i, String str);

        @MainThread
        void a(@NonNull WebCardGetDataResponse webCardGetDataResponse);
    }

    public final void a(final b.a aVar, @NonNull final a aVar2) {
        new l<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.1
            @NonNull
            public static WebCardGetDataResponse a(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.webview.request.a createRequest() {
                b.a aVar3 = aVar;
                return new com.kwad.sdk.core.webview.request.a(aVar3.a, aVar3.b, aVar3.c);
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ WebCardGetDataResponse parseData(String str) {
                return a(str);
            }
        }.request(new m<com.kwad.sdk.core.webview.request.a, WebCardGetDataResponse>() { // from class: com.kwad.sdk.core.webview.request.b.2
            private void a(final int i, final String str) {
                com.kwad.sdk.core.d.b.a("WebCardGetDataRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                b.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.a("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar2.a(i, str);
                    }
                });
            }

            private void a(@NonNull final WebCardGetDataResponse webCardGetDataResponse) {
                com.kwad.sdk.core.d.b.a("WebCardGetDataRequestManager", "onSuccess");
                b.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.core.webview.request.a aVar3) {
                super.onStartRequest(aVar3);
                com.kwad.sdk.core.d.b.a("WebCardGetDataRequestManager", "onStartRequest");
                b.a.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                a(i, str);
            }

            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                a((WebCardGetDataResponse) baseResultData);
            }
        });
    }
}
