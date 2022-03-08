package com.kwad.sdk.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes8.dex */
public class b extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f55967b;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55967b.setVisibility(0);
        this.f55967b.setAdTemplate(((com.kwad.sdk.reward.g) this).a.f55769g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55967b = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
