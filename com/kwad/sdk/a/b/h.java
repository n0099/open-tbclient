package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class h extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f32259b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32260c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32261d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f32262e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32263f = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f32260c.setText(com.kwad.sdk.core.response.b.a.w(this.f32262e));
        this.f32259b.setOnClickListener(this);
        this.f32259b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f32259b.getContext(), this.f32261d, new a.InterfaceC0379a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.f32261d, 2, ((com.kwad.sdk.a.a.a) h.this).f32206a.f32209c.getTouchCoords());
            }
        }, null);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f32206a.f32207a.onAdClicked(this.f32259b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f32206a.f32210d;
        this.f32261d = adTemplate;
        this.f32262e = com.kwad.sdk.core.response.b.c.j(adTemplate);
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.a(this.f32263f);
        this.f32259b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32263f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32259b = (ViewGroup) b(R.id.ksad_video_complete_h5_container);
        this.f32260c = (TextView) b(R.id.ksad_h5_open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
        g();
    }
}
