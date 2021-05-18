package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f31761b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f31762c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31763d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            i.this.f31761b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.f31761b.getContext(), this.f31762c, new a.InterfaceC0363a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.f31762c, 2, ((com.kwad.sdk.a.a.a) i.this).f31701a.f31704c.getTouchCoords());
            }
        }, ((com.kwad.sdk.a.a.a) this).f31701a.f31706e, false);
    }

    private void m() {
        ((com.kwad.sdk.a.a.a) this).f31701a.f31702a.onAdClicked(this.f31761b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31701a;
        this.f31762c = bVar.f31705d;
        bVar.f31707f.a(this.f31763d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31761b = (DetailVideoView) a(R.id.ksad_video_player);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31761b.setOnClickListener(null);
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.b(this.f31763d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31761b) {
            e();
            m();
        }
    }
}
