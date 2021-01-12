package com.kwad.sdk.contentalliance.detail.a.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
/* loaded from: classes4.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private AdBaseFrameLayout f8290b;
    private TextView c;
    private AdTemplate d;
    private com.kwad.sdk.core.download.b.b e;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.d, 24, this.f8290b.getTouchCoords());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d = this.f8393a.j;
        this.e = this.f8393a.o;
        String u = com.kwad.sdk.core.response.b.c.u(this.d);
        if (ag.a(u) && com.kwad.sdk.core.response.b.c.c(this.d)) {
            u = o().getString(R.string.ksad_ad_default_username);
        }
        if (ag.a(u)) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setText(u);
        this.c.setOnClickListener(this);
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f8290b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.c = (TextView) b(R.id.ksad_bottom_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.d)) {
            com.kwad.sdk.core.download.b.a.a(this.c.getContext(), this.d, new a.InterfaceC1088a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.a.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1088a
                public void a() {
                    a.this.e();
                }
            }, this.e);
        }
    }
}
