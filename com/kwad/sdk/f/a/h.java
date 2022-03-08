package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class h extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f55388b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55389c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f55390d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f55391e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f55392f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f55389c.setText(com.kwad.sdk.core.response.a.a.A(this.f55391e));
        this.f55388b.setOnClickListener(this);
        this.f55388b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.a.a.a(new a.C2095a(this.f55388b.getContext()).a(this.f55390d).a(2).a(new a.b() { // from class: com.kwad.sdk.f.a.h.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(h.this.f55390d, 2, ((com.kwad.sdk.f.kwai.a) h.this).a.f55420c.getTouchCoords());
            }
        }));
    }

    private void g() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f55388b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f55421d;
        this.f55390d = adTemplate;
        this.f55391e = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.a(this.f55392f);
        this.f55388b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f55423f.b(this.f55392f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f55388b = (ViewGroup) a(R.id.ksad_video_complete_h5_container);
        this.f55389c = (TextView) a(R.id.ksad_h5_open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
        g();
    }
}
