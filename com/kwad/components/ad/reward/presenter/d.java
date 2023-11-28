package com.kwad.components.ad.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.components.core.widget.ComplianceTextView;
/* loaded from: classes10.dex */
public final class d extends b {
    public ComplianceTextView cj;

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.qn.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cj = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f09133a);
    }
}
