package com.kwad.sdk.d;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
/* loaded from: classes3.dex */
public class a implements KsInterstitialAd {
    public KsScene a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final AdTemplate f58797b;

    /* renamed from: c  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f58798c;

    /* renamed from: d  reason: collision with root package name */
    public b f58799d;

    public a(@NonNull KsScene ksScene, @NonNull AdTemplate adTemplate) {
        this.a = ksScene;
        this.f58797b = adTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public int getECPM() {
        return com.kwad.sdk.core.response.a.a.F(d.j(this.f58797b));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.E(d.j(this.f58797b));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.R(d.j(this.f58797b));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.a.a.P(d.j(this.f58797b));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.f58797b, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.f58798c = adInteractionListener;
        b bVar = this.f58799d;
        if (bVar != null) {
            bVar.a(adInteractionListener);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f58797b;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.a.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        DevelopMangerPlugin.DevelopValue a;
        if (activity == null) {
            com.kwad.sdk.core.d.a.e("StayAdHelper", "showInterstitialAd activity must not be null");
            return;
        }
        DevelopMangerPlugin developMangerPlugin = (DevelopMangerPlugin) f.a(DevelopMangerPlugin.class);
        if (developMangerPlugin != null && (a = developMangerPlugin.a("KEY_INIT_VOICE_STATUS")) != null) {
            ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a.getValue()).booleanValue());
        }
        if (ksVideoPlayConfig.isVideoSoundEnable()) {
            adTemplate = this.f58797b;
            i2 = 2;
        } else {
            adTemplate = this.f58797b;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
        if (this.f58799d == null) {
            b bVar = new b(activity, this.f58797b, ksVideoPlayConfig, this.f58798c);
            this.f58799d = bVar;
            bVar.a();
        }
    }
}
