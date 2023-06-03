package com.kwad.components.ad.draw.a.a;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.a.a.a;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    public DrawCardApp bC;
    public DrawCardH5 bD;
    public ViewGroup bh;
    public a.InterfaceC0581a bz = new a.InterfaceC0581a() { // from class: com.kwad.components.ad.draw.a.a.b.1
        @Override // com.kwad.components.ad.draw.a.a.a.InterfaceC0581a
        public final void ax() {
            b.this.ax();
        }
    };
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    private void aA() {
        this.bh.setVisibility(8);
        this.bD.a(this.mAdTemplate, new DrawCardH5.a() { // from class: com.kwad.components.ad.draw.a.a.b.3
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aC() {
                b.this.bh.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aD() {
                b.this.aB();
            }
        });
        this.bD.setVisibility(0);
        this.bD.aT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 29, this.aK.mRootContainer.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = this.aK.aJ;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ax() {
        if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            az();
        } else {
            aA();
        }
    }

    private void az() {
        this.bh.setVisibility(8);
        this.bC.a(this.mAdTemplate, new DrawCardApp.a() { // from class: com.kwad.components.ad.draw.a.a.b.2
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aC() {
                b.this.bh.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aD() {
                b.this.aB();
            }
        });
        this.bC.setVisibility(0);
        this.bC.aT();
    }

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        AdTemplate adTemplate = this.aK.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.bQ(adTemplate);
        this.aK.ba.a(this.bz);
        this.bC.setVisibility(8);
        this.bD.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bh = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091225);
        this.bC = (DrawCardApp) findViewById(R.id.obfuscated_res_0x7f091244);
        this.bD = (DrawCardH5) findViewById(R.id.obfuscated_res_0x7f09124d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.bC.release();
        this.bD.release();
        this.aK.ba.a((a.InterfaceC0581a) null);
    }
}
