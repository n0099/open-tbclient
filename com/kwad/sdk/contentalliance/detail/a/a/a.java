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
    public AdBaseFrameLayout f31940b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31941c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f31942d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31943e;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f31942d, 24, this.f31940b.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        AdTemplate adTemplate = cVar.j;
        this.f31942d = adTemplate;
        this.f31943e = cVar.o;
        String u = com.kwad.sdk.core.response.b.c.u(adTemplate);
        if (ag.a(u) && com.kwad.sdk.core.response.b.c.c(this.f31942d)) {
            u = o().getString(R.string.ksad_ad_default_username);
        }
        if (ag.a(u)) {
            textView = this.f31941c;
            i = 8;
        } else {
            this.f31941c.setText(u);
            this.f31941c.setOnClickListener(this);
            textView = this.f31941c;
            i = 0;
        }
        textView.setVisibility(i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31940b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f31941c = (TextView) b(R.id.ksad_bottom_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f31942d)) {
            com.kwad.sdk.core.download.b.a.a(this.f31941c.getContext(), this.f31942d, new a.InterfaceC0379a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.a.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    a.this.e();
                }
            }, this.f31943e);
        }
    }
}
