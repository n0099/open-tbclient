package com.kwad.sdk.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes5.dex */
public class b extends com.kwad.sdk.reward.g {
    public ComplianceTextView b;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setVisibility(0);
        this.b.setAdTemplate(((com.kwad.sdk.reward.g) this).a.g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091013);
    }
}
