package com.kwad.components.ad.e.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bc;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.ad.e.kwai.a implements View.OnClickListener {
    public KsAdVideoPlayConfig cN;
    public ViewGroup jP;
    public ImageView jQ;
    public TextView jR;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.cN = ksAdVideoPlayConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep() {
        if (this.jP.getVisibility() != 0) {
            return;
        }
        this.jP.setVisibility(8);
    }

    private boolean f(AdInfo adInfo) {
        if (ae.isNetworkConnected(getContext())) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                    return true;
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                    return ae.isWifiConnected(getContext());
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return ae.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ae.isMobileConnected(getContext()));
                }
            }
            if (com.kwad.sdk.core.response.a.a.bi(adInfo)) {
                return true;
            }
            return com.kwad.sdk.core.response.a.a.bj(adInfo) && ae.isWifiConnected(getContext());
        }
        return false;
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        ViewGroup viewGroup;
        int i;
        super.aq();
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.jL.mAdTemplate);
        if (f(bQ)) {
            viewGroup = this.jP;
            i = 8;
        } else {
            this.jR.setText(bc.v(com.kwad.sdk.core.response.a.a.B(bQ) * 1000));
            this.jQ.setOnClickListener(this);
            this.jL.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            viewGroup = this.jP;
            i = 0;
        }
        viewGroup.setVisibility(i);
        com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h() { // from class: com.kwad.components.ad.e.a.a.1
            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                super.onVideoPlayStart();
                a.this.ep();
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                super.onVideoPlaying();
                a.this.ep();
            }
        };
        this.mVideoPlayStateListener = hVar;
        this.jL.jM.a(hVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.jQ) {
            this.jL.jM.ex();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jP = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0911c8);
        this.jQ = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c9);
        this.jR = (TextView) findViewById(R.id.obfuscated_res_0x7f0911ca);
    }
}
