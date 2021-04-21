package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f32107b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32108c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32109d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            i.this.f32107b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.f32107b.getContext(), this.f32108c, new a.InterfaceC0396a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0396a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.f32108c, 2, ((com.kwad.sdk.a.a.a) i.this).f32049a.f32052c.getTouchCoords());
            }
        }, ((com.kwad.sdk.a.a.a) this).f32049a.f32054e);
    }

    private void f() {
        ((com.kwad.sdk.a.a.a) this).f32049a.f32050a.onAdClicked(this.f32107b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32049a;
        this.f32108c = bVar.f32053d;
        bVar.f32055f.a(this.f32109d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32107b.setOnClickListener(null);
        ((com.kwad.sdk.a.a.a) this).f32049a.f32055f.b(this.f32109d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32107b = (DetailVideoView) b(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32107b) {
            e();
            f();
        }
    }
}
