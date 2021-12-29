package com.kwad.sdk.draw.a;

import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes3.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f58900b;

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f58900b.setVisibility(0);
        this.f58900b.setAdTemplate(((com.kwad.sdk.draw.kwai.a) this).a.f58960c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f58900b = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
