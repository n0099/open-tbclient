package com.kwad.components.ad.splashscreen.c;

import com.baidu.tieba.R;
import com.kwad.components.core.widget.ComplianceTextView;
/* loaded from: classes10.dex */
public final class f extends e {
    public ComplianceTextView cj;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        int i;
        super.aj();
        if (com.kwad.components.ad.splashscreen.f.c.z(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate))) {
            i = R.id.obfuscated_res_0x7f091339;
        } else {
            i = R.id.obfuscated_res_0x7f091338;
        }
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(i);
        this.cj = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.cj.setVisibility(0);
        this.cj.setAdTemplate(this.Df.mAdTemplate);
    }
}
