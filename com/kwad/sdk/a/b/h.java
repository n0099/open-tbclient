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
    public ViewGroup f32005b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32006c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f32007d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f32008e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32009f = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f32006c.setText(com.kwad.sdk.core.response.b.a.w(this.f32008e));
        this.f32005b.setOnClickListener(this);
        this.f32005b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f32005b.getContext(), this.f32007d, new a.InterfaceC0393a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.f32007d, 2, ((com.kwad.sdk.a.a.a) h.this).f31954a.f31957c.getTouchCoords());
            }
        }, null);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f31954a.f31955a.onAdClicked(this.f32005b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31954a.f31958d;
        this.f32007d = adTemplate;
        this.f32008e = com.kwad.sdk.core.response.b.c.j(adTemplate);
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.a(this.f32009f);
        this.f32005b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31954a.f31960f.b(this.f32009f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32005b = (ViewGroup) b(R.id.ksad_video_complete_h5_container);
        this.f32006c = (TextView) b(R.id.ksad_h5_open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
        g();
    }
}
