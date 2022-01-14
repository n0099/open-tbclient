package com.kwad.sdk.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.core.webview.kwai.a {
    public final com.kwad.sdk.core.webview.a a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f56376b = false;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.request.a, AdResultData> f56377c;

    /* loaded from: classes3.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public List<AdTemplate> a;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.a) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
                jSONArray.put(adTemplate.toJson());
            }
            com.kwad.sdk.utils.t.a(jSONObject, "impAdInfo", jSONArray);
            return jSONObject;
        }
    }

    public f(com.kwad.sdk.core.webview.a aVar) {
        this.a = aVar;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        return "getKsAdData";
    }

    public void a(final com.kwad.sdk.core.request.model.f fVar, final com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.request.a, AdResultData> iVar = this.f56377c;
        if (iVar != null) {
            iVar.e();
        }
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.request.a, AdResultData> iVar2 = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.request.a, AdResultData>() { // from class: com.kwad.sdk.core.webview.jshandler.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.request.a b() {
                return new com.kwad.sdk.core.request.a(fVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(fVar.a);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        };
        this.f56377c = iVar2;
        iVar2.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.request.a, AdResultData>() { // from class: com.kwad.sdk.core.webview.jshandler.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.a aVar, int i2, String str) {
                com.kwad.sdk.core.d.a.a("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i2 + " msg: " + str);
                ax.a(new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.f.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar2 = new a();
                        aVar2.a = new ArrayList();
                        cVar.a(aVar2);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.a aVar, @NonNull final AdResultData adResultData) {
                Runnable runnable;
                if (adResultData.isAdResultDataEmpty()) {
                    com.kwad.sdk.core.d.a.a("WebCardGetKsAdDataHandler", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.f.f55895e.n), com.kwad.sdk.core.network.f.f55895e.o));
                    runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a aVar2 = new a();
                            aVar2.a = new ArrayList();
                            cVar.a(aVar2);
                        }
                    };
                } else {
                    runnable = new Runnable() { // from class: com.kwad.sdk.core.webview.jshandler.f.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a aVar2 = new a();
                            aVar2.a = adResultData.adTemplateList;
                            cVar.a(aVar2);
                        }
                    };
                }
                ax.a(runnable);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        if (!this.f56376b) {
            if (this.a.c()) {
                cVar.a(-1, "native adTemplate is null");
                return;
            }
            a aVar = new a();
            aVar.a = this.a.b();
            cVar.a(aVar);
            return;
        }
        AdTemplate a2 = this.a.a();
        com.kwad.sdk.core.request.model.f fVar = new com.kwad.sdk.core.request.model.f(a2.mAdScene);
        SceneImpl sceneImpl = a2.mAdScene;
        if (sceneImpl != null) {
            fVar.f56161b = sceneImpl.getPageScene();
        }
        fVar.f56162c = 106L;
        fVar.a.setAdNum(12);
        fVar.f56163d = com.kwad.sdk.core.response.a.d.x(a2);
        a(fVar, cVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.request.a, AdResultData> iVar = this.f56377c;
        if (iVar != null) {
            iVar.e();
        }
    }
}
