package com.kwad.sdk.draw;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.c.c;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.view.a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f33111a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f33112b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f33113c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f33114d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f33115e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f33116f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f33117g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f33118h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.core.view.b f33119i;
    public Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f33112b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f33113c = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.draw.a.b d() {
        com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
        bVar.f33121a = this.f33111a;
        bVar.f33122b = this.f33112b;
        bVar.f33123c = this.f33116f;
        if (com.kwad.sdk.core.response.b.a.v(this.f33117g)) {
            bVar.f33124d = new com.kwad.sdk.core.download.b.b(this.f33116f);
        }
        bVar.f33125e = this.f33118h;
        bVar.f33126f = new com.kwad.sdk.draw.b.b.a(this.f33116f);
        if (com.kwad.sdk.core.response.b.b.j(this.f33116f)) {
            bVar.f33127g = new c();
        }
        return bVar;
    }

    private Presenter e() {
        Presenter presenter = new Presenter();
        presenter.a((Presenter) new com.kwad.sdk.draw.b.a.a());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.a());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.b());
        presenter.a((Presenter) new com.kwad.sdk.draw.b.b.b());
        if (com.kwad.sdk.core.response.b.b.i(this.f33116f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.j(this.f33116f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.a
    public void a() {
        this.f33114d = d();
        Presenter e2 = e();
        this.f33115e = e2;
        e2.a((View) this.f33112b);
        this.f33115e.a(this.f33114d);
        this.f33119i.a();
        this.f33118h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f33116f = adTemplate;
        this.f33117g = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.core.view.b bVar = new com.kwad.sdk.core.view.b(this, 70);
        this.f33119i = bVar;
        this.f33118h = new com.kwad.sdk.draw.c.a(this.f33116f, bVar, this.f33113c);
    }

    @Override // com.kwad.sdk.core.view.a
    public void b() {
        com.kwad.sdk.core.view.b bVar = this.f33119i;
        if (bVar != null) {
            bVar.c();
        }
        com.kwad.sdk.draw.c.a aVar = this.f33118h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.a.b bVar2 = this.f33114d;
        if (bVar2 != null) {
            bVar2.a();
        }
        Presenter presenter = this.f33115e;
        if (presenter != null) {
            presenter.g();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f33111a = adInteractionListener;
    }
}
