package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.draw.a.c;
import com.kwad.sdk.draw.a.d;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes3.dex */
public class a extends KSFrameLayout {
    @Nullable
    public KsDrawAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f56672b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f56673c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.kwai.b f56674d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f56675e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f56676f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f56677g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.b.a f56678h;

    /* renamed from: i  reason: collision with root package name */
    public f f56679i;

    /* renamed from: j  reason: collision with root package name */
    public Context f56680j;

    public a(@NonNull Context context) {
        super(context);
        this.f56680j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.f56680j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f56672b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f56673c = detailVideoView;
        detailVideoView.setAd(true);
        this.f56673c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.draw.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.kwad.sdk.core.download.a.a.a(new a.C2100a(a.this.f56674d.f56738b.getContext()).a(a.this.f56674d.f56739c).a(a.this.f56674d.f56740d).a(false).a(3).a(new a.b() { // from class: com.kwad.sdk.draw.a.1.1
                    @Override // com.kwad.sdk.core.download.a.a.b
                    public void a() {
                    }
                }));
            }
        });
    }

    private com.kwad.sdk.draw.kwai.b d() {
        com.kwad.sdk.draw.kwai.b bVar = new com.kwad.sdk.draw.kwai.b();
        bVar.a = this.a;
        bVar.f56738b = this.f56672b;
        bVar.f56739c = this.f56676f;
        if (com.kwad.sdk.core.response.a.a.B(this.f56677g)) {
            bVar.f56740d = new com.kwad.sdk.core.download.a.b(this.f56676f);
        }
        bVar.f56741e = this.f56678h;
        bVar.f56742f = new com.kwad.sdk.draw.a.a.a(this.f56676f);
        if (com.kwad.sdk.core.response.a.b.h(this.f56676f)) {
            bVar.f56743g = new com.kwad.sdk.i.b();
        }
        return bVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.draw.a.kwai.a());
        presenter.a((Presenter) new com.kwad.sdk.draw.a.b());
        presenter.a((Presenter) new d());
        presenter.a((Presenter) new c());
        presenter.a((Presenter) new com.kwad.sdk.draw.a.a.b());
        if (com.kwad.sdk.core.response.a.b.d(this.f56676f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.a.b.a());
        if (com.kwad.sdk.core.response.a.b.h(this.f56676f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.b.b());
        }
        if (com.kwad.sdk.core.response.a.a.D(this.f56677g)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.a.a());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.f56674d = d();
        Presenter e2 = e();
        this.f56675e = e2;
        e2.c(this.f56672b);
        this.f56675e.a(this.f56674d);
        this.f56679i.a();
        this.f56678h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f56676f = adTemplate;
        this.f56677g = com.kwad.sdk.core.response.a.d.j(adTemplate);
        f fVar = new f(this, 70);
        this.f56679i = fVar;
        this.f56678h = new com.kwad.sdk.draw.b.a(this.f56676f, fVar, this.f56673c);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        f fVar = this.f56679i;
        if (fVar != null) {
            fVar.g();
        }
        com.kwad.sdk.draw.b.a aVar = this.f56678h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.kwai.b bVar = this.f56674d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f56675e;
        if (presenter != null) {
            presenter.k();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.a = adInteractionListener;
    }
}
