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
    public AdBaseFrameLayout f32488b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32489c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32490d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f32491e;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        com.kwad.sdk.core.report.b.a(this.f32490d, 24, this.f32488b.getTouchCoords());
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i2;
        super.a();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32692a;
        AdTemplate adTemplate = cVar.j;
        this.f32490d = adTemplate;
        this.f32491e = cVar.o;
        String u = com.kwad.sdk.core.response.b.c.u(adTemplate);
        if (ag.a(u) && com.kwad.sdk.core.response.b.c.c(this.f32490d)) {
            u = o().getString(R.string.ksad_ad_default_username);
        }
        if (ag.a(u)) {
            textView = this.f32489c;
            i2 = 8;
        } else {
            this.f32489c.setText(u);
            this.f32489c.setOnClickListener(this);
            textView = this.f32489c;
            i2 = 0;
        }
        textView.setVisibility(i2);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32488b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
        this.f32489c = (TextView) b(R.id.ksad_bottom_author_name);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.kwad.sdk.core.response.b.c.c(this.f32490d)) {
            com.kwad.sdk.core.download.b.a.a(this.f32489c.getContext(), this.f32490d, new a.InterfaceC0379a() { // from class: com.kwad.sdk.contentalliance.detail.a.a.a.1
                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
                public void a() {
                    a.this.e();
                }
            }, this.f32491e);
        }
    }
}
