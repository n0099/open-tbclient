package com.kwad.sdk.draw.a;

import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes8.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f55243b;

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f55243b.setVisibility(0);
        this.f55243b.setAdTemplate(((com.kwad.sdk.draw.kwai.a) this).a.f55301c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55243b = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
