package com.kwad.sdk.f.a;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class i extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f55393b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f55394c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55395d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            i.this.f55393b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.a.a.a(new a.C2095a(this.f55393b.getContext()).a(this.f55394c).a(((com.kwad.sdk.f.kwai.a) this).a.f55422e).a(new a.b() { // from class: com.kwad.sdk.f.a.i.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(i.this.f55394c, 2, ((com.kwad.sdk.f.kwai.a) i.this).a.f55420c.getTouchCoords());
            }
        }));
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f55393b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f55394c = bVar.f55421d;
        bVar.f55423f.a(this.f55395d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f55393b.setOnClickListener(null);
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.b(this.f55395d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55393b = (DetailVideoView) a(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f55393b) {
            e();
            f();
        }
    }
}
