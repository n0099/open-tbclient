package com.kwad.components.ad.draw.a;

import com.baidu.tieba.R;
import com.kwad.components.core.widget.ComplianceTextView;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.ad.draw.kwai.a {
    public ComplianceTextView bc;

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.bc.setVisibility(0);
        this.bc.setAdTemplate(this.aK.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0912a8);
    }
}
