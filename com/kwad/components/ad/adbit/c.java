package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.k.kwai.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c {
    public static <T extends com.kwad.components.core.k.a> T a(com.kwad.sdk.d.b<T> bVar) {
        return bVar.get();
    }

    @Nullable
    public static AdTemplate a(AdBitResultData adBitResultData, long j) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j == d.ca(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
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

    public static void a(String str, @NonNull com.kwad.components.core.k.kwai.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.EI.HS);
            adBitResultData.parseJson(jSONObject);
            List<String> a = a(adBitResultData);
            if (a.isEmpty()) {
                com.kwad.components.core.k.kwai.a.a(aVar, f.Yd.errorCode, f.Yd.Qd, false);
            } else {
                a(a, adBitResultData, aVar);
            }
        } catch (Exception e) {
            f fVar = f.Yc;
            com.kwad.components.core.k.kwai.a.a(aVar, fVar.errorCode, fVar.Qd, false);
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    public static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.k.kwai.a aVar) {
        new m<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: af */
            public com.kwad.components.ad.kwai.b createRequest() {
                return new com.kwad.components.ad.kwai.b(adBitResultData.adxId, list);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            /* renamed from: s */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(com.kwad.components.core.k.kwai.a.this.EI.HS);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new n<com.kwad.components.ad.kwai.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            private void b(int i, String str) {
                com.kwad.components.core.k.kwai.a.a(aVar, i, str, false);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData2));
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.k.kwai.a aVar2 = aVar;
                    f fVar = f.Yd;
                    com.kwad.components.core.k.kwai.a.a(aVar2, fVar.errorCode, fVar.Qd, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i = aVar.EI.HS.adStyle;
                if (i == 10000 || i == d.bK(adTemplate)) {
                    com.kwad.components.core.k.kwai.a.a(aVar, adBitResultData2, false);
                    return;
                }
                com.kwad.components.core.k.kwai.a aVar3 = aVar;
                f fVar2 = f.Yh;
                com.kwad.components.core.k.kwai.a.a(aVar3, fVar2.errorCode, fVar2.Qd, false);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                b(i, str);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }
        });
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

    public static boolean b(@NonNull final com.kwad.components.core.k.kwai.a aVar) {
        String bidResponseV2 = aVar.EI.HS.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.EI.HS.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        com.kwad.sdk.core.threads.b.vn().submit(new Runnable() { // from class: com.kwad.components.ad.adbit.c.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(aVar.EI.HS);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.k.kwai.a.a(aVar, f.Yd.errorCode, f.Yd.Qd, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = aVar.EI.HS.getAdStyle();
                    if (adStyle == 10000 || adStyle == d.bK(adTemplate)) {
                        com.kwad.components.core.k.kwai.a.a(aVar, adBitResultData, true);
                    } else {
                        com.kwad.components.core.k.kwai.a.a(aVar, f.Yh.errorCode, f.Yh.Qd, true);
                    }
                } catch (Exception e) {
                    com.kwad.components.core.k.kwai.a aVar2 = aVar;
                    f fVar = f.Yc;
                    com.kwad.components.core.k.kwai.a.a(aVar2, fVar.errorCode, fVar.Qd, true);
                    com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                }
            }
        });
        return true;
    }

    public static String getBidRequestToken(KsScene ksScene) {
        final com.kwad.components.core.k.kwai.a oo = new a.C0652a().c(new com.kwad.components.core.k.kwai.b(ksScene)).a(new com.kwad.components.core.k.c()).oo();
        b bVar = (b) a(new com.kwad.sdk.d.b<b>() { // from class: com.kwad.components.ad.adbit.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.b
            /* renamed from: ad */
            public b get() {
                return new b(com.kwad.components.core.k.kwai.a.this);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).ac();
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.k.kwai.a oo = new a.C0652a().c(new com.kwad.components.core.k.kwai.b(ksScene)).a(new com.kwad.components.core.k.c()).oo();
        com.kwad.components.ad.kwai.a aVar = (com.kwad.components.ad.kwai.a) a(new com.kwad.sdk.d.b<com.kwad.components.ad.kwai.a>() { // from class: com.kwad.components.ad.adbit.c.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.d.b
            /* renamed from: ae */
            public com.kwad.components.ad.kwai.a get() {
                return new com.kwad.components.ad.kwai.a(com.kwad.components.core.k.kwai.a.this);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).ac();
    }
}
