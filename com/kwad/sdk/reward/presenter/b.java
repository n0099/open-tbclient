package com.kwad.sdk.reward.presenter;

import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f57450b;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f57450b.setVisibility(0);
        this.f57450b.setAdTemplate(((com.kwad.sdk.reward.g) this).a.f57252g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f57450b = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
