package com.kwad.sdk.draw.a;

import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.draw.kwai.a {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f40306b;

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40306b.setVisibility(0);
        this.f40306b.setAdTemplate(((com.kwad.sdk.draw.kwai.a) this).a.f40360c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40306b = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091058);
    }
}
