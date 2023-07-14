package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class i {
    public volatile boolean fq;
    public com.kwad.sdk.core.network.m<j, BaseResultData> fr;

    /* loaded from: classes10.dex */
    public static class a {
        public static i mi = new i((byte) 0);
    }

    public i() {
        this.fq = false;
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public static /* synthetic */ boolean a(i iVar, boolean z) {
        iVar.fq = false;
        return false;
    }

    public static i fn() {
        return a.mi;
    }

    private void n(final AdTemplate adTemplate) {
        if (this.fq) {
            return;
        }
        this.fq = true;
        com.kwad.sdk.core.network.m<j, BaseResultData> mVar = new com.kwad.sdk.core.network.m<j, BaseResultData>() { // from class: com.kwad.components.ad.reward.i.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: fo */
            public j createRequest() {
                return new j(adTemplate);
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final BaseResultData parseData(String str) {
                BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$1$1
                };
                if (!TextUtils.isEmpty(str)) {
                    try {
                        baseResultData.parseJson(new JSONObject(str));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.b.printStackTrace(th);
                    }
                }
                return baseResultData;
            }
        };
        this.fr = mVar;
        mVar.request(new com.kwad.sdk.core.network.n<j, BaseResultData>() { // from class: com.kwad.components.ad.reward.i.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull j jVar, int i, String str) {
                super.onError(jVar, i, str);
                i.a(i.this, false);
                com.kwad.components.core.j.a.og().c(adTemplate, 1, str);
                com.kwad.sdk.core.e.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull j jVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(jVar, baseResultData);
                i.a(i.this, false);
                com.kwad.components.core.j.a.og().c(adTemplate, 0, "success");
                com.kwad.sdk.core.e.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }
        });
    }

    public final void m(AdTemplate adTemplate) {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.be(bQ))) {
            r.b(adTemplate, bQ);
        } else {
            n(adTemplate);
        }
    }

    public final void release() {
        com.kwad.sdk.core.network.m<j, BaseResultData> mVar = this.fr;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
