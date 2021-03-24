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
    public AdBaseFrameLayout f31939b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31940c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f31941d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f31942e;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f31941d, 24, this.f31939b.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32132a;
        AdTemplate adTemplate = cVar.j;
        this.f31941d = adTemplate;
        this.f31942e = cVar.o;
        String u = com.kwad.sdk.core.response.b.c.u(adTemplate);
        if (ag.a(u) && com.kwad.sdk.core.response.b.c.c(this.f31941d)) {
            u = o().getString(R.string.ksad_ad_default_username);
        }
        if (ag.a(u)) {
            textView = this.f31940c;
            i = 8;
        } else {
            this.f31940c.setText(u);
            this.f31940c.setOnClickListener(this);
            textView = this.f31940c;
            i = 0;
        }
        textView.setVisibility(i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31939b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f31940c = (TextView) b(R.id.ksad_bottom_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f31941d)) {
            com.kwad.sdk.core.download.b.a.a(this.f31940c.getContext(), this.f31941d, new a.InterfaceC0378a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.a.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
                public void a() {
                    a.this.e();
                }
            }, this.f31942e);
        }
    }
}
