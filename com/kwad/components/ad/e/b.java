package com.kwad.components.ad.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        boolean a = m.oF().a(ksScene, "loadNativeAd");
        ksScene.setAdStyle(10000);
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0646a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new com.kwad.components.core.k.c() { // from class: com.kwad.components.ad.e.b.1
            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        arrayList.add(new c(adTemplate));
                    }
                }
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.b.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ab().b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
            public final void onError(final int i, final String str) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.b.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.NativeAdListener.this.onError(i, str);
                    }
                });
            }
        }).oo());
    }

    public static void loadNativeAd(String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        if (m.oF().a((KsScene) null, "loadNativeAdByJson") && m.oF().oG() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.b.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                    f fVar = f.Yd;
                    nativeAdListener2.onError(fVar.errorCode, fVar.Qd);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.b.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.e.b.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = AdResultData.this;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
            } else if (adResultData.isAdResultDataEmpty()) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                        f fVar = f.Yd;
                        nativeAdListener2.onError(fVar.errorCode, fVar.Qd);
                    }
                });
            } else {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        arrayList.add(new c(adTemplate));
                    }
                }
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.e.b.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            f fVar = f.Yc;
            nativeAdListener.onError(fVar.errorCode, fVar.Qd);
        }
    }
}
