package com.kwad.sdk.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.reward.g {

    /* renamed from: b  reason: collision with root package name */
    public ComplianceTextView f40925b;

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f40925b.setVisibility(0);
        this.f40925b.setAdTemplate(((com.kwad.sdk.reward.g) this).a.f40747g);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f40925b = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091058);
    }
}
