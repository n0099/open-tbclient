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
    public ViewGroup f31716b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31717c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f31718d;

    /* renamed from: e  reason: collision with root package name */
    public AdInfo f31719e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f31720f = new com.kwad.sdk.contentalliance.detail.video.f() { // from class: com.kwad.sdk.a.b.h.1
        @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
        public void a() {
            h.this.e();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f31717c.setText(com.kwad.sdk.core.response.b.a.w(this.f31719e));
        this.f31716b.setOnClickListener(this);
        this.f31716b.setVisibility(0);
    }

    private void f() {
        com.kwad.sdk.core.download.b.a.a(this.f31716b.getContext(), this.f31718d, new a.InterfaceC0379a() { // from class: com.kwad.sdk.a.b.h.2
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0379a
            public void a() {
                com.kwad.sdk.core.report.b.a(h.this.f31718d, 2, ((com.kwad.sdk.a.a.a) h.this).f31665a.f31668c.getTouchCoords());
            }
        }, null);
    }

    private void g() {
        ((com.kwad.sdk.a.a.a) this).f31665a.f31666a.onAdClicked(this.f31716b, null);
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f31665a.f31669d;
        this.f31718d = adTemplate;
        this.f31719e = com.kwad.sdk.core.response.b.c.j(adTemplate);
        ((com.kwad.sdk.a.a.a) this).f31665a.f31671f.a(this.f31720f);
        this.f31716b.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((com.kwad.sdk.a.a.a) this).f31665a.f31671f.b(this.f31720f);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f31716b = (ViewGroup) b(R.id.ksad_video_complete_h5_container);
        this.f31717c = (TextView) b(R.id.ksad_h5_open);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
        g();
    }
}
