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
    public ViewGroup f31754b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31755c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f31756d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f31757e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f31758f = new com.kwad.sdk.contentalliance.detail.video.e() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
        public void f() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f31755c.setText(com.kwad.sdk.core.response.b.a.u(this.f31757e));
        this.f31754b.setOnClickListener(this);
        this.f31754b.setVisibility(0);
    }

    private void m() {
        com.kwad.sdk.core.download.b.a.a(this.f31754b.getContext(), this.f31756d, new a.InterfaceC0363a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0363a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.f31756d, 2, ((com.kwad.sdk.a.a.a) h.this).f31701a.f31704c.getTouchCoords());
            }
        }, null, false);
    }

    private void n() {
        ((com.kwad.sdk.a.a.a) this).f31701a.f31702a.onAdClicked(this.f31754b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31701a.f31705d;
        this.f31756d = adTemplate;
        this.f31757e = com.kwad.sdk.core.response.b.c.g(adTemplate);
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.a(this.f31758f);
        this.f31754b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        super.b();
        this.f31754b = (ViewGroup) a(R.id.ksad_video_complete_h5_container);
        this.f31755c = (TextView) a(R.id.ksad_h5_open);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        ((com.kwad.sdk.a.a.a) this).f31701a.f31707f.b(this.f31758f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        m();
        n();
    }
}
