package com.kwad.sdk.splashscreen.a;

import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class e extends Presenter {
    public ComplianceTextView a;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.a.setVisibility(0);
        this.a.setAdTemplate(((com.kwad.sdk.splashscreen.g) p()).d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.a = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091051);
    }
}
