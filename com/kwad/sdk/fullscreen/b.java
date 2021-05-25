package com.kwad.sdk.fullscreen;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes6.dex */
public class b implements KsFullScreenVideoAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33307a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f33308b;

    /* renamed from: c  reason: collision with root package name */
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener f33309c;

    public b(@NonNull AdTemplate adTemplate) {
        this.f33307a = adTemplate;
        this.f33308b = c.g(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.a.c("KsFullScreenVideoAdControl", "isAdEnable is false");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
        if (a2 != null) {
            ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
        }
        KsFullScreenVideoActivityProxy.launch(context, this.f33307a, ksVideoPlayConfig, this.f33309c);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.x(this.f33308b);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.config.c.y() >= 0) {
            return true;
        }
        return g.b(this.f33307a);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setBidEcpm(int i2) {
        AdTemplate adTemplate = this.f33307a;
        adTemplate.mBidEcpm = i2;
        com.kwad.sdk.core.report.b.l(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f33309c = fullScreenVideoAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        a(activity, ksVideoPlayConfig);
    }
}
