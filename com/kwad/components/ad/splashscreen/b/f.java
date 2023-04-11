package com.kwad.components.ad.splashscreen.b;

import com.baidu.tieba.R;
import com.kwad.components.core.widget.ComplianceTextView;
/* loaded from: classes8.dex */
public final class f extends e {
    public ComplianceTextView bc;

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.bc.setVisibility(0);
        this.bc.setAdTemplate(this.yF.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0911f5);
    }
}
