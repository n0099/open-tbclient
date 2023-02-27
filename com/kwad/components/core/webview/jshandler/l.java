package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class l implements com.kwad.sdk.core.webview.kwai.a {
    public final boolean LB = false;
    public final com.kwad.sdk.core.webview.b Lk;
    public com.kwad.sdk.core.network.m<com.kwad.components.core.k.a, AdResultData> fr;

    /* loaded from: classes8.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public List<AdTemplate> LE;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.LE) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                    }
                }
                jSONArray.put(adTemplate.toJson());
            }
            com.kwad.sdk.utils.r.putValue(jSONObject, "impAdInfo", jSONArray);
            return jSONObject;
        }
    }

    public l(com.kwad.sdk.core.webview.b bVar) {
        this.Lk = bVar;
    }

    private void a(final com.kwad.components.core.k.kwai.b bVar, final com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.network.m<com.kwad.components.core.k.a, AdResultData> mVar = this.fr;
        if (mVar != null) {
            mVar.cancel();
        }
        com.kwad.sdk.core.network.m<com.kwad.components.core.k.a, AdResultData> mVar2 = new com.kwad.sdk.core.network.m<com.kwad.components.core.k.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.l.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            /* renamed from: ah */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(bVar.HS);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: fe */
            public com.kwad.components.core.k.a createRequest() {
                return new com.kwad.components.core.k.a(bVar);
            }
        };
        this.fr = mVar2;
        mVar2.request(new com.kwad.sdk.core.network.n<com.kwad.components.core.k.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.l.2
            private void b(@NonNull final AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty()) {
                    bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.l.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            a aVar = new a();
                            aVar.LE = adResultData.getAdTemplateList();
                            cVar.a(aVar);
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.e.b.d("WebCardGetKsAdDataHandler", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.f.Yd.errorCode), com.kwad.sdk.core.network.f.Yd.Qd));
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.l.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a aVar = new a();
                        aVar.LE = new ArrayList();
                        cVar.a(aVar);
                    }
                });
            }

            private void c(int i, String str) {
                com.kwad.sdk.core.e.b.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                l.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i, String str) {
                c(i, str);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.kwai.c cVar) {
        bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.l.3
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = new a();
                aVar.LE = new ArrayList();
                cVar.a(aVar);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (!this.LB) {
            if (this.Lk.wh()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            }
            a aVar = new a();
            aVar.LE = this.Lk.wg();
            cVar.a(aVar);
            return;
        }
        AdTemplate adTemplate = this.Lk.getAdTemplate();
        com.kwad.components.core.k.kwai.b bVar = new com.kwad.components.core.k.kwai.b(adTemplate.mAdScene);
        SceneImpl sceneImpl = adTemplate.mAdScene;
        if (sceneImpl != null) {
            bVar.HT = sceneImpl.getPageScene();
        }
        bVar.HU = 106L;
        bVar.HS.setAdNum(12);
        bVar.sdkExtraData = com.kwad.sdk.core.response.a.d.bZ(adTemplate);
        a(bVar, cVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.m<com.kwad.components.core.k.a, AdResultData> mVar = this.fr;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
