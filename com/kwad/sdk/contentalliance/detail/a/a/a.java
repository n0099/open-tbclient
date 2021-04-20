package com.kwad.sdk.contentalliance.detail.a.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f32229b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32230c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32231d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32232e;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f32231d, 24, this.f32229b.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32422a;
        AdTemplate adTemplate = cVar.j;
        this.f32231d = adTemplate;
        this.f32232e = cVar.o;
        String u = com.kwad.sdk.core.response.b.c.u(adTemplate);
        if (ag.a(u) && com.kwad.sdk.core.response.b.c.c(this.f32231d)) {
            u = o().getString(R.string.ksad_ad_default_username);
        }
        if (ag.a(u)) {
            textView = this.f32230c;
            i = 8;
        } else {
            this.f32230c.setText(u);
            this.f32230c.setOnClickListener(this);
            textView = this.f32230c;
            i = 0;
        }
        textView.setVisibility(i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32229b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32230c = (TextView) b(R.id.ksad_bottom_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32231d)) {
            com.kwad.sdk.core.download.b.a.a(this.f32230c.getContext(), this.f32231d, new a.InterfaceC0393a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.a.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
                public void a() {
                    a.this.e();
                }
            }, this.f32232e);
        }
    }
}
