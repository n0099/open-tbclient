package com.kwad.sdk.d.kwai;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public class a extends b {
    public ComplianceTextView a;

    private void a(View view2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        marginLayoutParams.topMargin = bb.a(q(), 12.0f);
        view2.setLayoutParams(marginLayoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        c cVar = (c) p();
        if (cVar.f) {
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
        this.a = (ComplianceTextView) a(R.id.obfuscated_res_0x7f091061);
    }
}
