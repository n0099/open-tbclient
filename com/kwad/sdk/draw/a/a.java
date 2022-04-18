package com.kwad.sdk.draw.a;

import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.draw.kwai.a {
    public ComplianceTextView b;

    @Override // com.kwad.sdk.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.b.setVisibility(0);
        this.b.setAdTemplate(((com.kwad.sdk.draw.kwai.a) this).a.c);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.b = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091052);
    }
}
