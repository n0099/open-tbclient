package com.kwad.sdk.draw.a;

import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f56681b;

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f56681b.setVisibility(0);
        this.f56681b.setAdTemplate(((com.kwad.sdk.draw.kwai.a) this).a.f56739c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56681b = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
