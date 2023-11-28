package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.d;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public static <T extends com.kwad.components.core.request.a> T a(com.kwad.sdk.g.c<T> cVar) {
        return cVar.get();
    }

    @Nullable
    public static AdTemplate a(AdBitResultData adBitResultData, long j) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j == e.dZ(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }

    public static String a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        final com.kwad.components.core.request.model.a ql = new a.C0661a().e(new ImpInfo(sceneImpl)).a(new d()).ql();
        b bVar = (b) a(new com.kwad.sdk.g.c<b>() { // from class: com.kwad.components.ad.adbit.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* renamed from: O */
            public b get() {
                return new b(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).N();
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate a;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (a = a(adBitResultData, j)) != null) {
                    a.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.request.model.a ql = new a.C0661a().e(new ImpInfo(SceneImpl.covert(ksScene))).a(new d()).ql();
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) a(new com.kwad.sdk.g.c<com.kwad.components.ad.a.a>() { // from class: com.kwad.components.ad.adbit.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* renamed from: P */
            public com.kwad.components.ad.a.a get() {
                return new com.kwad.components.ad.a.a(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).N();
    }

    public static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate a;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (a = a(adBitResultData2, j)) != null) {
                    a.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    public static void a(String str, @NonNull com.kwad.components.core.request.model.a aVar) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.Mp.adScene);
            adBitResultData.parseJson(jSONObject);
            List<String> a = a(adBitResultData);
            if (a.isEmpty()) {
                int i = com.kwad.sdk.core.network.e.ats.errorCode;
                if (TextUtils.isEmpty(adBitResultData.testErrorMsg)) {
                    str2 = com.kwad.sdk.core.network.e.ats.msg;
                } else {
                    str2 = adBitResultData.testErrorMsg;
                }
                com.kwad.components.core.request.model.a.a(aVar, i, str2, false);
                return;
            }
            a(a, adBitResultData, aVar);
        } catch (Exception e) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.atr;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, false);
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    public static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.request.model.a aVar) {
        new l<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: Q */
            public com.kwad.components.ad.a.b createRequest() {
                return new com.kwad.components.ad.a.b(adBitResultData.adxId, list);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: n */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(com.kwad.components.core.request.model.a.this.Mp.adScene);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new o<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            private void b(int i, String str) {
                com.kwad.components.core.request.model.a.a(aVar, i, str, false);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                String str;
                adBitResultData2.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData2));
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    int i = com.kwad.sdk.core.network.e.ats.errorCode;
                    if (TextUtils.isEmpty(adBitResultData2.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.ats.msg;
                    } else {
                        str = adBitResultData2.testErrorMsg;
                    }
                    com.kwad.components.core.request.model.a.a(aVar2, i, str, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i2 = aVar.Mp.adScene.adStyle;
                if (i2 != 10000 && i2 != e.dJ(adTemplate)) {
                    com.kwad.components.core.request.model.a aVar3 = aVar;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.atw;
                    com.kwad.components.core.request.model.a.a(aVar3, eVar.errorCode, eVar.msg, false);
                    return;
                }
                com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                b(i, str);
            }
        });
    }

    public static boolean b(@NonNull final com.kwad.components.core.request.model.a aVar) {
        String bidResponseV2 = aVar.Mp.adScene.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.Mp.adScene.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.Ey().submit(new Runnable() { // from class: com.kwad.components.ad.adbit.c.3
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                try {
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(aVar.Mp.adScene);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.request.model.a aVar2 = aVar;
                        int i = com.kwad.sdk.core.network.e.ats.errorCode;
                        if (TextUtils.isEmpty(adBitResultData.testErrorMsg)) {
                            str = com.kwad.sdk.core.network.e.ats.msg;
                        } else {
                            str = adBitResultData.testErrorMsg;
                        }
                        com.kwad.components.core.request.model.a.a(aVar2, i, str, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = aVar.Mp.adScene.getAdStyle();
                    if (adStyle != 10000 && adStyle != e.dJ(adTemplate)) {
                        com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.atw.errorCode, com.kwad.sdk.core.network.e.atw.msg, true);
                    } else {
                        com.kwad.components.core.request.model.a.a(aVar, adBitResultData, true);
                    }
                } catch (Exception e) {
                    com.kwad.components.core.request.model.a aVar3 = aVar;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.atr;
                    com.kwad.components.core.request.model.a.a(aVar3, eVar.errorCode, eVar.msg, true);
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
        });
        return true;
    }
}
