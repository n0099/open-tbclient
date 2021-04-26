package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f32516b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f32517c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f32518d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            i.this.f32516b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.f32516b.getContext(), this.f32517c, new a.InterfaceC0376a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0376a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.f32517c, 2, ((com.kwad.sdk.a.a.a) i.this).f32456a.f32459c.getTouchCoords());
            }
        }, ((com.kwad.sdk.a.a.a) this).f32456a.f32461e, false);
    }

    private void m() {
        ((com.kwad.sdk.a.a.a) this).f32456a.f32457a.onAdClicked(this.f32516b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f32456a;
        this.f32517c = bVar.f32460d;
        bVar.f32462f.a(this.f32518d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f32516b = (DetailVideoView) a(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f32516b.setOnClickListener(null);
        ((com.kwad.sdk.a.a.a) this).f32456a.f32462f.b(this.f32518d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f32516b) {
            e();
            m();
        }
    }
}
