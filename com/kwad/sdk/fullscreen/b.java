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
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.reward.f;
/* loaded from: classes6.dex */
public class b implements KsFullScreenVideoAd {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35014a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f35015b;

    /* renamed from: c  reason: collision with root package name */
    public KsFullScreenVideoAd.FullScreenVideoAdInteractionListener f35016c;

    public b(@NonNull AdTemplate adTemplate) {
        this.f35014a = adTemplate;
        this.f35015b = c.j(adTemplate);
    }

    private void a(Context context, KsVideoPlayConfig ksVideoPlayConfig) {
        if (!isAdEnable()) {
            com.kwad.sdk.core.d.a.b("KsFullScreenVideoAdControl", "isAdEnable is false");
            return;
        }
        if (ksVideoPlayConfig == null) {
            ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_INIT_VOICE_STATUS");
        if (a2 != null) {
            ksVideoPlayConfig.setVideoSoundEnable(((Boolean) a2.getValue()).booleanValue());
        }
        KsFullScreenVideoActivityProxy.launch(context, this.f35014a, ksVideoPlayConfig, this.f35016c);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.A(this.f35015b);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public boolean isAdEnable() {
        if (com.kwad.sdk.core.config.c.ae() >= 0) {
            return true;
        }
        return f.b(this.f35014a);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setBidEcpm(int i) {
        AdTemplate adTemplate = this.f35014a;
        adTemplate.mBidEcpm = i;
        com.kwad.sdk.core.report.b.m(adTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f35016c = fullScreenVideoAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        a(activity, ksVideoPlayConfig);
    }
}
