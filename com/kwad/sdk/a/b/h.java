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
    public ViewGroup f32509b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32510c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32511d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f32512e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f32513f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f32510c.setText(com.kwad.sdk.core.response.b.a.u(this.f32512e));
        this.f32509b.setOnClickListener(this);
        this.f32509b.setVisibility(0);
    }

    private void m() {
        com.kwad.sdk.core.download.b.a.a(this.f32509b.getContext(), this.f32511d, new a.InterfaceC0376a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.f32511d, 2, ((com.kwad.sdk.a.a.a) h.this).f32456a.f32459c.getTouchCoords());
            }
        }, null, false);
    }

    private void n() {
        ((com.kwad.sdk.a.a.a) this).f32456a.f32457a.onAdClicked(this.f32509b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32456a.f32460d;
        this.f32511d = adTemplate;
        this.f32512e = com.kwad.sdk.core.response.b.c.g(adTemplate);
        ((com.kwad.sdk.a.a.a) this).f32456a.f32462f.a(this.f32513f);
        this.f32509b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f32509b = (ViewGroup) a(R.id.ksad_video_complete_h5_container);
        this.f32510c = (TextView) a(R.id.ksad_h5_open);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f32456a.f32462f.b(this.f32513f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m();
        n();
    }
}
