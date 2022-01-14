package com.kwad.sdk.splashscreen.a;

import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes3.dex */
public class e extends Presenter {
    public ComplianceTextView a;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.a.setVisibility(0);
        this.a.setAdTemplate(((com.kwad.sdk.splashscreen.g) p()).f57875d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.a = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
