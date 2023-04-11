package com.kwad.components.ad.reward.presenter;

import com.baidu.tieba.R;
import com.kwad.components.core.widget.ComplianceTextView;
/* loaded from: classes8.dex */
public final class c extends a {
    public ComplianceTextView bc;
    public com.kwad.components.core.webview.b.d.b gp = new com.kwad.components.core.webview.b.d.b() { // from class: com.kwad.components.ad.reward.presenter.c.1
        @Override // com.kwad.components.core.webview.b.d.b
        public final void u(String str) {
            if ("ksad-video-top-bar".equals(str)) {
                c.this.bc.setVisibility(0);
                c.this.bc.setAdTemplate(c.this.nM.mAdTemplate);
            }
        }
    };

    private boolean gU() {
        com.kwad.components.ad.reward.k kVar = this.nM;
        return kVar.mz ? com.kwad.components.ad.reward.k.a(kVar) : com.kwad.components.ad.reward.k.b(kVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.core.webview.b.c.a.pR().a(this.gp);
        if (gU()) {
            return;
        }
        this.bc.setVisibility(0);
        this.bc.setAdTemplate(this.nM.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.bc = (ComplianceTextView) findViewById(R.id.obfuscated_res_0x7f0911f5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.b.c.a.pR().b(this.gp);
    }
}
