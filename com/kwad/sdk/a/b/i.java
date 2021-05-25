package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f31690b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f31691c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31692d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            i.this.f31690b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.f31690b.getContext(), this.f31691c, new a.InterfaceC0364a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.f31691c, 2, ((com.kwad.sdk.a.a.a) i.this).f31630a.f31633c.getTouchCoords());
            }
        }, ((com.kwad.sdk.a.a.a) this).f31630a.f31635e, false);
    }

    private void m() {
        ((com.kwad.sdk.a.a.a) this).f31630a.f31631a.onAdClicked(this.f31690b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31630a;
        this.f31691c = bVar.f31634d;
        bVar.f31636f.a(this.f31692d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31690b = (DetailVideoView) a(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31690b.setOnClickListener(null);
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.b(this.f31692d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31690b) {
            e();
            m();
        }
    }
}
