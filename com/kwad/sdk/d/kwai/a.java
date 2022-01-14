package com.kwad.sdk.d.kwai;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.utils.bb;
/* loaded from: classes3.dex */
public class a extends b {
    public ComplianceTextView a;

    private void a(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = bb.a(q(), 12.0f);
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        if (cVar.f56618f) {
            a((View) this.a);
        }
        this.a.setVisibility(0);
        this.a.setAdTemplate(cVar.a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.a = (ComplianceTextView) a(R.id.ksad_compliance_view);
    }
}
