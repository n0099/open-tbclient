package com.kwad.components.ad.reward;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class KsRewardVideoAdControl implements com.kwad.components.core.internal.api.a, KsRewardVideoAd {
    public final AdInfo mAdInfo;
    @NonNull
    public final AdResultData mAdResultData;
    @NonNull
    public final AdTemplate mAdTemplate;
    public final AdGlobalConfigInfo ov;
    public com.kwad.components.ad.reward.e.h ow;
    public com.kwad.components.core.i.d ox;
    public com.kwad.components.core.internal.api.c bZ = new com.kwad.components.core.internal.api.c();
    public int rewardType = 1;

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ag() {
        return true;
    }

    @Keep
    public void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
    }

    public KsRewardVideoAdControl(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate m = com.kwad.sdk.core.response.b.c.m(adResultData);
        this.mAdTemplate = m;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dP(m);
        this.ov = adResultData.adGlobalConfigInfo;
        fg();
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.ox = new com.kwad.components.core.i.d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.ow == null) {
            this.ow = new com.kwad.components.ad.reward.e.h() { // from class: com.kwad.components.ad.reward.KsRewardVideoAdControl.1
                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    KsRewardVideoAdControl.this.bZ.i(KsRewardVideoAdControl.this);
                }

                @Override // com.kwad.components.ad.reward.e.h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    KsRewardVideoAdControl.this.bZ.h(KsRewardVideoAdControl.this);
                }
            };
        }
        this.ow.b(rewardAdInteractionListener);
    }

    private void a(Activity activity, @NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        fh();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.isNativeRewardPreview) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdResultData, adTemplate, com.kwad.sdk.core.response.b.a.aS(this.mAdInfo), this.ow);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.ow, this.ox, this.rewardType);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.report.a.k(adTemplate, j2);
    }

    private void fg() {
        boolean z;
        com.kwad.components.ad.h.b.eH().a(this);
        AdGlobalConfigInfo adGlobalConfigInfo = this.ov;
        boolean z2 = true;
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.isNeoScan()) {
            z = true;
        } else {
            z = false;
        }
        this.mAdTemplate.isNativeRewardPreview = (!com.kwad.sdk.core.response.b.a.bX(this.mAdInfo) || z) ? false : false;
    }

    private void fh() {
        AdInfo adInfo;
        if (!com.kwad.components.ad.reward.c.c.a(this.ow) && (adInfo = this.mAdInfo) != null) {
            adInfo.adBaseInfo.extraClickReward = false;
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.AO()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.ef(this.mAdTemplate) >= 0) {
            return true;
        }
        return com.kwad.components.core.video.j.ax(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bZ.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public List<KSAdInfoData> getKSAdInfoDatas() {
        AdResultData adResultData;
        ArrayList arrayList = new ArrayList();
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqU) && (adResultData = this.mAdResultData) != null && adResultData.getAdTemplateList().size() > 0) {
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                arrayList.add(com.kwad.sdk.core.response.b.a.cY(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity != null && !activity.isFinishing()) {
            com.kwad.sdk.i.a.ai("reward", "show");
            com.kwad.components.ad.reward.monitor.c.h(true, this.mAdTemplate);
            com.kwad.sdk.commercial.e.c.bz(this.mAdTemplate);
            if (!com.kwad.sdk.core.config.d.Bv() && !isAdEnable()) {
                com.kwad.sdk.core.e.c.i("KsRewardVideoAdControl", "isAdEnable is false");
                com.kwad.sdk.i.a.aj("reward", "show");
                com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "cache_not_ready");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            a(activity, ksVideoPlayConfig);
            return;
        }
        com.kwad.sdk.core.e.c.e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
        com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate, "illegal_activity");
    }
}
