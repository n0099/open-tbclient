package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f59660b;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f59660b.setVisibility(0);
        this.f59660b.setAdTemplate(((com.kwad.sdk.reward.g) this).a.f59455g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f59660b = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
