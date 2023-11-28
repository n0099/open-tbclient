package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ad implements com.kwad.sdk.core.webview.c.a {
    public final com.kwad.sdk.core.webview.b VP;
    public final boolean Wv = false;
    public com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> iJ;

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    /* loaded from: classes10.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public AdResultData mAdResultData;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        public a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.c.printStackTrace(e);
                        jSONArray.put(adTemplate.toJson());
                    }
                } else {
                    jSONArray.put(adTemplate.toJson());
                }
            }
            com.kwad.sdk.utils.t.putValue(json, "impAdInfo", jSONArray);
            return json;
        }
    }

    public ad(com.kwad.sdk.core.webview.b bVar) {
        this.VP = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar) {
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ad.3
            @Override // java.lang.Runnable
            public final void run() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                cVar.a(adResultData);
            }
        });
    }

    private void a(final ImpInfo impInfo, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar2 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: Z */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mt */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }
        };
        this.iJ = lVar2;
        lVar2.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.2
            private void h(int i, String str) {
                com.kwad.sdk.core.e.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                ad.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }

            private void c(@NonNull final AdResultData adResultData) {
                String str;
                if (adResultData.isAdResultDataEmpty()) {
                    StringBuilder sb = new StringBuilder("onError:");
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(com.kwad.sdk.core.network.e.ats.errorCode);
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.ats.msg;
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    objArr[1] = str;
                    sb.append(String.format("code:%s__msg:%s", objArr));
                    com.kwad.sdk.core.e.c.d("WebCardGetKsAdDataHandler", sb.toString());
                    bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ad.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            cVar.a(adResultData);
                        }
                    });
                    return;
                }
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ad.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a(adResultData);
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i, String str) {
                h(i, str);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.Wv) {
            AdTemplate adTemplate = this.VP.getAdTemplate();
            ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null) {
                impInfo.pageScene = sceneImpl.getPageScene();
            }
            impInfo.subPageScene = 106L;
            impInfo.adScene.setAdNum(12);
            impInfo.sdkExtraData = com.kwad.sdk.core.response.b.e.dY(adTemplate);
            a(impInfo, cVar);
        } else if (this.VP.FE()) {
            cVar.onError(-1, "native adTemplate is null");
        } else {
            cVar.a(new a(this.VP.hi()));
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
    }
}
