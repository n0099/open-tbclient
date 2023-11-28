package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bl;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    public KsAdVideoPlayConfig dU;
    public ViewGroup mQ;
    public ImageView mR;
    public TextView mS;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dU = ksAdVideoPlayConfig;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        if (view2 == this.mR) {
            this.mM.mN.eC();
        }
    }

    private boolean e(AdInfo adInfo) {
        if (!ag.isNetworkConnected(getContext())) {
            return false;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return true;
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ag.isWifiConnected(getContext());
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                if (!ag.isWifiConnected(getContext()) && (!kSAdVideoPlayConfigImpl.isDataFlowAutoStart() || !ag.isMobileConnected(getContext()))) {
                    return false;
                }
                return true;
            }
        }
        if (com.kwad.sdk.core.response.b.a.bU(adInfo)) {
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.bV(adInfo) || !ag.isWifiConnected(getContext())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu() {
        if (this.mQ.getVisibility() != 0) {
            return;
        }
        this.mQ.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mQ = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091343);
        this.mR = (ImageView) findViewById(R.id.obfuscated_res_0x7f091344);
        this.mS = (TextView) findViewById(R.id.obfuscated_res_0x7f091345);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mM.mAdTemplate);
        if (!e(dP)) {
            this.mS.setText(bl.X(com.kwad.sdk.core.response.b.a.L(dP) * 1000));
            this.mR.setOnClickListener(this);
            this.mM.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.mQ.setVisibility(0);
        } else {
            this.mQ.setVisibility(8);
        }
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.a.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                a.this.eu();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                a.this.eu();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
    }
}
