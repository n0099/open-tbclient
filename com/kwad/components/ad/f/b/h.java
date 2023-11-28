package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.l;
/* loaded from: classes10.dex */
public final class h extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    public ViewGroup nf;
    public TextView ng;

    /* JADX INFO: Access modifiers changed from: private */
    public void ew() {
        this.ng.setText(com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.dP(this.mM.mAdTemplate)));
        this.nf.setOnClickListener(this);
        this.nf.setVisibility(0);
    }

    private void ey() {
        com.kwad.components.core.e.d.a.a(new a.C0644a(this.nf.getContext()).aq(this.mM.mAdTemplate).an(2).a(new a.b() { // from class: com.kwad.components.ad.f.b.h.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(h.this.mM.mAdTemplate, 2, h.this.mM.mH.getTouchCoords());
            }
        }));
    }

    private void notifyAdClick() {
        this.mM.mv.l(this.nf);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.h.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayCompleted() {
                h.this.ew();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mM.mN.b((com.kwad.components.core.video.k) lVar);
        this.nf.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.nf = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f0914e6);
        this.ng = (TextView) findViewById(R.id.obfuscated_res_0x7f091370);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        ey();
        notifyAdClick();
    }
}
