package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class h extends com.kwad.sdk.a.a.a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f31683b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31684c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f31685d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f31686e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31687f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f31684c.setText(com.kwad.sdk.core.response.b.a.u(this.f31686e));
        this.f31683b.setOnClickListener(this);
        this.f31683b.setVisibility(0);
    }

    private void m() {
        com.kwad.sdk.core.download.b.a.a(this.f31683b.getContext(), this.f31685d, new a.InterfaceC0364a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0364a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.f31685d, 2, ((com.kwad.sdk.a.a.a) h.this).f31630a.f31633c.getTouchCoords());
            }
        }, null, false);
    }

    private void n() {
        ((com.kwad.sdk.a.a.a) this).f31630a.f31631a.onAdClicked(this.f31683b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31630a.f31634d;
        this.f31685d = adTemplate;
        this.f31686e = com.kwad.sdk.core.response.b.c.g(adTemplate);
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.a(this.f31687f);
        this.f31683b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31683b = (ViewGroup) a(R.id.ksad_video_complete_h5_container);
        this.f31684c = (TextView) a(R.id.ksad_h5_open);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31630a.f31636f.b(this.f31687f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m();
        n();
    }
}
