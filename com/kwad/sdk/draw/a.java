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
    public KsDrawAd.AdInteractionListener f35262a;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f35263b;

    /* renamed from: c  reason: collision with root package name */
    public DetailVideoView f35264c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.draw.a.b f35265d;

    /* renamed from: e  reason: collision with root package name */
    public Presenter f35266e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35267f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f35268g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.draw.c.a f35269h;

    /* renamed from: i  reason: collision with root package name */
    public g f35270i;
    public Context j;

    public a(@NonNull Context context) {
        super(context);
        this.j = context;
        c();
    }

    private void c() {
        FrameLayout.inflate(this.j, R.layout.ksad_draw_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.f35263b = adBaseFrameLayout;
        DetailVideoView detailVideoView = (DetailVideoView) adBaseFrameLayout.findViewById(R.id.ksad_video_player);
        this.f35264c = detailVideoView;
        detailVideoView.setAd(true);
    }

    private com.kwad.sdk.draw.a.b d() {
        com.kwad.sdk.draw.a.b bVar = new com.kwad.sdk.draw.a.b();
        bVar.f35272a = this.f35262a;
        bVar.f35273b = this.f35263b;
        bVar.f35274c = this.f35267f;
        if (com.kwad.sdk.core.response.b.a.y(this.f35268g)) {
            bVar.f35275d = new com.kwad.sdk.core.download.b.b(this.f35267f);
        }
        bVar.f35276e = this.f35269h;
        bVar.f35277f = new com.kwad.sdk.draw.b.b.a(this.f35267f);
        if (com.kwad.sdk.core.response.b.b.p(this.f35267f)) {
            bVar.f35278g = new c();
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
        if (com.kwad.sdk.core.response.b.b.o(this.f35267f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.b.c());
        }
        presenter.a((Presenter) new com.kwad.sdk.draw.b.c.a());
        if (com.kwad.sdk.core.response.b.b.p(this.f35267f)) {
            presenter.a((Presenter) new com.kwad.sdk.draw.b.c.b());
        }
        return presenter;
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f35265d = d();
        Presenter e2 = e();
        this.f35266e = e2;
        e2.a((View) this.f35263b);
        this.f35266e.a(this.f35265d);
        this.f35270i.a();
        this.f35269h.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f35267f = adTemplate;
        this.f35268g = com.kwad.sdk.core.response.b.c.j(adTemplate);
        g gVar = new g(this, 70);
        this.f35270i = gVar;
        this.f35269h = new com.kwad.sdk.draw.c.a(this.f35267f, gVar, this.f35264c);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        g gVar = this.f35270i;
        if (gVar != null) {
            gVar.c();
        }
        com.kwad.sdk.draw.c.a aVar = this.f35269h;
        if (aVar != null) {
            aVar.b();
        }
        com.kwad.sdk.draw.a.b bVar = this.f35265d;
        if (bVar != null) {
            bVar.a();
        }
        Presenter presenter = this.f35266e;
        if (presenter != null) {
            presenter.j();
        }
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f35262a = adInteractionListener;
    }
}
