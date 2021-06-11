package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f32266b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32267c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32268d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            i.this.f32266b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.f32266b.getContext(), this.f32267c, new a.InterfaceC0379a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.f32267c, 2, ((com.kwad.sdk.a.a.a) i.this).f32206a.f32209c.getTouchCoords());
            }
        }, ((com.kwad.sdk.a.a.a) this).f32206a.f32211e);
    }

    private void f() {
        ((com.kwad.sdk.a.a.a) this).f32206a.f32207a.onAdClicked(this.f32266b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32206a;
        this.f32267c = bVar.f32210d;
        bVar.f32212f.a(this.f32268d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32266b.setOnClickListener(null);
        ((com.kwad.sdk.a.a.a) this).f32206a.f32212f.b(this.f32268d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32266b = (DetailVideoView) b(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32266b) {
            e();
            f();
        }
    }
}
