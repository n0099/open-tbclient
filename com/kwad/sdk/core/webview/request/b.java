package com.kwad.sdk.core.webview.request;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.webview.a.b;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class b {
    public static final Handler mHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public interface a {
        void a(WebCardGetDataResponse webCardGetDataResponse);

        void onError(int i, String str);
    }

    public final void a(final b.a aVar, final a aVar2) {
        new m() { // from class: com.kwad.sdk.core.webview.request.b.1
            public static WebCardGetDataResponse cK(String str) {
                JSONObject jSONObject = new JSONObject(str);
                WebCardGetDataResponse webCardGetDataResponse = new WebCardGetDataResponse();
                webCardGetDataResponse.parseJson(jSONObject);
                return webCardGetDataResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: wk */
            public com.kwad.sdk.core.webview.request.a createRequest() {
                b.a aVar3 = aVar;
                return new com.kwad.sdk.core.webview.request.a(aVar3.url, aVar3.method, aVar3.params);
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ BaseResultData parseData(String str) {
                return cK(str);
            }
        }.request(new n() { // from class: com.kwad.sdk.core.webview.request.b.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(com.kwad.sdk.core.webview.request.a aVar3) {
                super.onStartRequest(aVar3);
                com.kwad.sdk.core.e.b.d("WebCardGetDataRequestManager", "onStartRequest");
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                    }
                });
            }

            private void b(final WebCardGetDataResponse webCardGetDataResponse) {
                com.kwad.sdk.core.e.b.d("WebCardGetDataRequestManager", "onSuccess");
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar2.a(webCardGetDataResponse);
                    }
                });
            }

            private void i(final int i, final String str) {
                com.kwad.sdk.core.e.b.d("WebCardGetDataRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                b.mHandler.post(new Runnable() { // from class: com.kwad.sdk.core.webview.request.b.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.d("WebCardGetDataRequestManager", "load onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        aVar2.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(g gVar, int i, String str) {
                i(i, str);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(g gVar, BaseResultData baseResultData) {
                b((WebCardGetDataResponse) baseResultData);
            }
        });
    }
}
