package com.kwad.components.ad.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public static void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a = m.qR().a(covert, "loadNativeAd");
        covert.setAdStyle(10000);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0661a().e(new ImpInfo(covert)).aI(a).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.f.c.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.f.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.NativeAdListener.this.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                com.kwad.sdk.commercial.e.c.j(adTemplateList.get(0), adTemplateList.size());
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = covert;
                        arrayList.add(new d(adTemplate));
                    }
                }
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.f.c.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.M().b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
                try {
                    for (AdTemplate adTemplate2 : adResultData.getAdTemplateList()) {
                        if (adTemplate2 != null) {
                            com.kwad.sdk.core.response.b.e.dP(adTemplate2);
                            try {
                                if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                                    com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }).ql());
    }

    public static void loadNativeAd(String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        if (m.qR().a((SceneImpl) null, "loadNativeAdByJson") && m.qR().qS() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.f.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.c.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.ats;
                    nativeAdListener2.onError(eVar.errorCode, eVar.msg);
                }
            });
        }
        com.kwad.sdk.commercial.e.c.a(BusinessType.AD_NATIVE, true);
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.f.c.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.c.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = AdResultData.this;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
            } else if (adResultData.isAdResultDataEmpty()) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.f.c.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str2;
                        KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                        int i = com.kwad.sdk.core.network.e.ats.errorCode;
                        if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                            str2 = com.kwad.sdk.core.network.e.ats.msg;
                        } else {
                            str2 = adResultData.testErrorMsg;
                        }
                        nativeAdListener2.onError(i, str2);
                    }
                });
            } else {
                final ArrayList arrayList = new ArrayList();
                List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        arrayList.add(new d(adTemplate));
                    }
                }
                com.kwad.sdk.commercial.e.c.a(BusinessType.AD_NATIVE, adTemplateList.get(0), adTemplateList.size(), true);
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.f.c.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.atr;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
