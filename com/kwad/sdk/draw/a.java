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
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.core.view.b {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public KsDrawAd.AdInteractionListener f35164a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f35165b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f35166c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f35167d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f35168e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35169f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f35170g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f35171h;

    /* renamed from: i  reason: collision with root package name */
    public g f35172i;
    public Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f35165b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f35166c = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.draw.a.b d() {
        com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
        bVar.f35174a = this.f35164a;
        bVar.f35175b = this.f35165b;
        bVar.f35176c = this.f35169f;
        if (com.kwad.sdk.core.response.b.a.y(this.f35170g)) {
            bVar.f35177d = new com.kwad.sdk.core.download.b.b(this.f35169f);
        }
        bVar.f35178e = this.f35171h;
        bVar.f35179f = new com.kwad.sdk.draw.b.b.a(this.f35169f);
        if (com.kwad.sdk.core.response.b.b.p(this.f35169f)) {
            bVar.f35180g = new c();
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
        if (com.kwad.sdk.core.response.b.b.o(this.f35169f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.p(this.f35169f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f35167d = d();
        Presenter e2 = e();
        this.f35168e = e2;
        e2.a((View) this.f35165b);
        this.f35168e.a(this.f35167d);
        this.f35172i.a();
        this.f35171h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f35169f = adTemplate;
        this.f35170g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        g gVar = new g(this, 70);
        this.f35172i = gVar;
        this.f35171h = new com.kwad.sdk.draw.c.a(this.f35169f, gVar, this.f35166c);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        g gVar = this.f35172i;
        if (gVar != null) {
            gVar.c();
        }
        com.kwad.sdk.draw.c.a aVar = this.f35171h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.a.b bVar = this.f35167d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f35168e;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f35164a = adInteractionListener;
    }
}
