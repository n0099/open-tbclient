package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f32364b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32365c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f32366d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            i.this.f32364b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.f32364b.getContext(), this.f32365c, new a.InterfaceC0382a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0382a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.f32365c, 2, ((com.kwad.sdk.a.a.a) i.this).f32304a.f32307c.getTouchCoords());
            }
        }, ((com.kwad.sdk.a.a.a) this).f32304a.f32309e);
    }

    private void f() {
        ((com.kwad.sdk.a.a.a) this).f32304a.f32305a.onAdClicked(this.f32364b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32304a;
        this.f32365c = bVar.f32308d;
        bVar.f32310f.a(this.f32366d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f32364b.setOnClickListener(null);
        ((com.kwad.sdk.a.a.a) this).f32304a.f32310f.b(this.f32366d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32364b = (DetailVideoView) b(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32364b) {
            e();
            f();
        }
    }
}
