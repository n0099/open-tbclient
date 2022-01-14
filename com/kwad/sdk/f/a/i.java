package com.kwad.sdk.f.a;

import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class i extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f56831b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f56832c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56833d = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.i.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void c() {
            super.c();
            i.this.f56831b.setOnClickListener(i.this);
        }
    };

    private void e() {
        com.kwad.sdk.core.download.a.a.a(new a.C2100a(this.f56831b.getContext()).a(this.f56832c).a(((com.kwad.sdk.f.kwai.a) this).a.f56860e).a(new a.b() { // from class: com.kwad.sdk.f.a.i.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(i.this.f56832c, 2, ((com.kwad.sdk.f.kwai.a) i.this).a.f56858c.getTouchCoords());
            }
        }));
    }

    private void f() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f56831b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        com.kwad.sdk.f.kwai.b bVar = ((com.kwad.sdk.f.kwai.a) this).a;
        this.f56832c = bVar.f56859d;
        bVar.f56861f.a(this.f56833d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f56831b.setOnClickListener(null);
        ((com.kwad.sdk.f.kwai.a) this).a.f56861f.b(this.f56833d);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56831b = (DetailVideoView) a(R.id.ksad_video_player);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f56831b) {
            e();
            f();
        }
    }
}
