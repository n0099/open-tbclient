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
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.view.b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f34514a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34515b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f34516c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f34517d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f34518e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34519f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34520g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f34521h;
    public g i;
    public Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f34515b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f34516c = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.draw.a.b d() {
        com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
        bVar.f34523a = this.f34514a;
        bVar.f34524b = this.f34515b;
        bVar.f34525c = this.f34519f;
        if (com.kwad.sdk.core.response.b.a.y(this.f34520g)) {
            bVar.f34526d = new com.kwad.sdk.core.download.b.b(this.f34519f);
        }
        bVar.f34527e = this.f34521h;
        bVar.f34528f = new com.kwad.sdk.draw.b.b.a(this.f34519f);
        if (com.kwad.sdk.core.response.b.b.p(this.f34519f)) {
            bVar.f34529g = new c();
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
        if (com.kwad.sdk.core.response.b.b.o(this.f34519f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.p(this.f34519f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f34517d = d();
        Presenter e2 = e();
        this.f34518e = e2;
        e2.a((View) this.f34515b);
        this.f34518e.a(this.f34517d);
        this.i.a();
        this.f34521h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f34519f = adTemplate;
        this.f34520g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        g gVar = new g(this, 70);
        this.i = gVar;
        this.f34521h = new com.kwad.sdk.draw.c.a(this.f34519f, gVar, this.f34516c);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.c();
        }
        com.kwad.sdk.draw.c.a aVar = this.f34521h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.a.b bVar = this.f34517d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f34518e;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f34514a = adInteractionListener;
    }
}
