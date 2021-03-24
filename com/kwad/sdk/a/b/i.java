package com.kwad.sdk.a.b;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class i extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f31722b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f31723c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31724d = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void b() {
            super.b();
            i.this.f31722b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.b.a.a(this.f31722b.getContext(), this.f31723c, new a.InterfaceC0378a() { // from class: com.kwad.sdk.a.b.i.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0378a
            public void a() {
                com.kwad.sdk.core.report.b.a(i.this.f31723c, 2, ((com.kwad.sdk.a.a.a) i.this).f31664a.f31667c.getTouchCoords());
            }
        }, ((com.kwad.sdk.a.a.a) this).f31664a.f31669e);
    }

    private void f() {
        ((com.kwad.sdk.a.a.a) this).f31664a.f31665a.onAdClicked(this.f31722b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f31664a;
        this.f31723c = bVar.f31668d;
        bVar.f31670f.a(this.f31724d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f31722b.setOnClickListener(null);
        ((com.kwad.sdk.a.a.a) this).f31664a.f31670f.b(this.f31724d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31722b = (DetailVideoView) b(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f31722b) {
            e();
            f();
        }
    }
}
