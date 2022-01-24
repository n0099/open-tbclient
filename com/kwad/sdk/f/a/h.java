package com.kwad.sdk.f.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes3.dex */
public class h extends com.kwad.sdk.f.kwai.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56871b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56872c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f56873d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f56874e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f56875f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.f.a.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f56872c.setText(com.kwad.sdk.core.response.a.a.A(this.f56874e));
        this.f56871b.setOnClickListener(this);
        this.f56871b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.a.a.a(new a.C2106a(this.f56871b.getContext()).a(this.f56873d).a(2).a(new a.b() { // from class: com.kwad.sdk.f.a.h.2
            @Override // com.kwad.sdk.core.download.a.a.b
            public void a() {
                com.kwad.sdk.core.report.a.a(h.this.f56873d, 2, ((com.kwad.sdk.f.kwai.a) h.this).a.f56903c.getTouchCoords());
            }
        }));
    }

    private void g() {
        ((com.kwad.sdk.f.kwai.a) this).a.a.a(this.f56871b, null);
    }

    @Override // com.kwad.sdk.f.kwai.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.f.kwai.a) this).a.f56904d;
        this.f56873d = adTemplate;
        this.f56874e = com.kwad.sdk.core.response.a.d.j(adTemplate);
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.a(this.f56875f);
        this.f56871b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.f.kwai.a) this).a.f56906f.b(this.f56875f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.f56871b = (ViewGroup) a(R.id.ksad_video_complete_h5_container);
        this.f56872c = (TextView) a(R.id.ksad_h5_open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
        g();
    }
}
