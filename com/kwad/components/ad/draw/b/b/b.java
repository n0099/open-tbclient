package com.kwad.components.ad.draw.b.b;

import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.components.ad.draw.b.b.a;
import com.kwad.components.ad.draw.view.playcard.DrawCardApp;
import com.kwad.components.ad.draw.view.playcard.DrawCardH5;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.draw.a.a {
    public a.InterfaceC0582a cF = new a.InterfaceC0582a() { // from class: com.kwad.components.ad.draw.b.b.b.1
        @Override // com.kwad.components.ad.draw.b.b.a.InterfaceC0582a
        public final void aq() {
            b.this.aq();
        }
    };
    public DrawCardApp cI;
    public DrawCardH5 cJ;
    public ViewGroup co;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            as();
        } else {
            at();
        }
    }

    private void as() {
        this.co.setVisibility(8);
        this.cI.a(this.mAdTemplate, new DrawCardApp.a() { // from class: com.kwad.components.ad.draw.b.b.b.2
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void av() {
                b.this.co.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardApp.a
            public final void aw() {
                b.this.au();
            }
        });
        this.cI.setVisibility(0);
        this.cI.aO();
    }

    private void at() {
        this.co.setVisibility(8);
        this.cJ.a(this.mAdTemplate, new DrawCardH5.a() { // from class: com.kwad.components.ad.draw.b.b.b.3
            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void av() {
                b.this.co.setVisibility(0);
            }

            @Override // com.kwad.components.ad.draw.view.playcard.DrawCardH5.a
            public final void aw() {
                b.this.au();
            }
        });
        this.cJ.setVisibility(0);
        this.cJ.aO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au() {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, 29, this.bO.mRootContainer.getTouchCoords());
        KsDrawAd.AdInteractionListener adInteractionListener = this.bO.bN;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdTemplate adTemplate = this.bO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dP(adTemplate);
        this.bO.ch.a(this.cF);
        this.cI.setVisibility(8);
        this.cJ.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.co = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0912f8);
        this.cI = (DrawCardApp) findViewById(R.id.obfuscated_res_0x7f09131b);
        this.cJ = (DrawCardH5) findViewById(R.id.obfuscated_res_0x7f091324);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.cI.release();
        this.cJ.release();
        this.bO.ch.a((a.InterfaceC0582a) null);
    }
}
