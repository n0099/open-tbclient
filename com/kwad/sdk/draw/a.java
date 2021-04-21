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
    public KsDrawAd.AdInteractionListener f34898a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34899b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f34900c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f34901d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f34902e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34903f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34904g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f34905h;
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
        this.f34899b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f34900c = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.draw.a.b d() {
        com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
        bVar.f34907a = this.f34898a;
        bVar.f34908b = this.f34899b;
        bVar.f34909c = this.f34903f;
        if (com.kwad.sdk.core.response.b.a.y(this.f34904g)) {
            bVar.f34910d = new com.kwad.sdk.core.download.b.b(this.f34903f);
        }
        bVar.f34911e = this.f34905h;
        bVar.f34912f = new com.kwad.sdk.draw.b.b.a(this.f34903f);
        if (com.kwad.sdk.core.response.b.b.p(this.f34903f)) {
            bVar.f34913g = new c();
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
        if (com.kwad.sdk.core.response.b.b.o(this.f34903f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.p(this.f34903f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f34901d = d();
        Presenter e2 = e();
        this.f34902e = e2;
        e2.a((View) this.f34899b);
        this.f34902e.a(this.f34901d);
        this.i.a();
        this.f34905h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f34903f = adTemplate;
        this.f34904g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        g gVar = new g(this, 70);
        this.i = gVar;
        this.f34905h = new com.kwad.sdk.draw.c.a(this.f34903f, gVar, this.f34900c);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        g gVar = this.i;
        if (gVar != null) {
            gVar.c();
        }
        com.kwad.sdk.draw.c.a aVar = this.f34905h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.a.b bVar = this.f34901d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f34902e;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f34898a = adInteractionListener;
    }
}
