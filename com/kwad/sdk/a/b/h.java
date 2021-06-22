package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class h extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32357b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32358c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32359d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f32360e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32361f = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f32358c.setText(com.kwad.sdk.core.response.b.a.w(this.f32360e));
        this.f32357b.setOnClickListener(this);
        this.f32357b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f32357b.getContext(), this.f32359d, new a.InterfaceC0382a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.f32359d, 2, ((com.kwad.sdk.a.a.a) h.this).f32304a.f32307c.getTouchCoords());
            }
        }, null);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f32304a.f32305a.onAdClicked(this.f32357b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32304a.f32308d;
        this.f32359d = adTemplate;
        this.f32360e = com.kwad.sdk.core.response.b.c.j(adTemplate);
        ((com.kwad.sdk.a.a.a) this).f32304a.f32310f.a(this.f32361f);
        this.f32357b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32304a.f32310f.b(this.f32361f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32357b = (ViewGroup) b(R.id.ksad_video_complete_h5_container);
        this.f32358c = (TextView) b(R.id.ksad_h5_open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
        g();
    }
}
